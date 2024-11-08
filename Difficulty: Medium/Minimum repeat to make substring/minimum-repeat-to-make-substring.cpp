//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minRepeats(string& s1, string& s2) {
        // code here
        string temp=s1;
        int cnt=1;
        while(temp.size()<s2.size()){
            temp+=s1;
            cnt++;
        }
        if(temp.find(s2)!=string::npos) return cnt;
        temp+=s1;
        if(temp.find(s2)!=string::npos) return cnt+1;
        return -1;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {
        string A, B;
        getline(cin, A);
        getline(cin, B);

        Solution ob;
        cout << ob.minRepeats(A, B) << endl;
    }
    return 0;
}
// } Driver Code Ends