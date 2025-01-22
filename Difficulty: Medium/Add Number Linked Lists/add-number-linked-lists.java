//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
       StringBuilder str1 = new StringBuilder(), str2 = new StringBuilder();
        while (num1 != null) {
            str1.append(num1.data);
            num1 = num1.next;
        }

        while (num2 != null) {
            str2.append(num2.data);
            num2 = num2.next;
        }

        StringBuilder ans = new StringBuilder();
        int carry = 0, i = str1.length() - 1, j = str2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += str1.charAt(i--) - '0';
            if (j >= 0) sum += str2.charAt(j--) - '0';
            carry = sum / 10;
            ans.append(sum % 10);
        }

        Node newHead = new Node(ans.charAt(0) - '0');
        Node ptr = newHead;
        for (int k = 1; k < ans.length(); k++) {
            ptr.next = new Node(ans.charAt(k) - '0');
            ptr = ptr.next;
        }
        newHead = reverse(newHead);
        while (newHead != null && newHead.data == 0) {
            newHead = newHead.next;
        }

        return (newHead == null) ? new Node(0) : newHead; 
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends