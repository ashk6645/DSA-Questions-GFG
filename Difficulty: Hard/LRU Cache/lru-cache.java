//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    class Node {
        int key, value;
        Node prev, next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;
    LRUCache(int cap) {
        // code here
         this.capacity = cap;
        this.cache = new HashMap<>();
        
        // Create a dummy head and tail node
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public  int get(int key) {
        // your code here
         if (!cache.containsKey(key)) {
            return -1;
        }
        
        // Move the accessed node to the front (most recently used)
        Node node = cache.get(key);
        remove(node);
        addFirst(node);
        
        return node.value;
    }

    // Function for storing key-value pair.
    public  void put(int key, int value) {
        // your code here
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        } else {
            // If key doesn't exist, create a new node
            Node newNode = new Node(key, value);
            
            // If cache is full, remove the least recently used item
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            // Add the new node to the front
            addFirst(newNode);
            cache.put(key, newNode);
        }
    
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node to the front (just after head)
    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
