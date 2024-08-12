//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

//Position this line where user code will be pasted.
class Solution {
  public:
    int SumofMiddleElements(vector<int> &arr1, vector<int> &arr2) {
        // code here
        int l1=0,l2=0,n1=arr1.size(),n2=arr2.size(),n=n1+n2,s=0;
        bool f=0;
        if(n%2) f==1;
        while(l1<n1 && l2<n2){
            if(arr1[l1]<=arr2[l2]){
                if(f && l1+l2==n/2)s+=arr1[l1];
                if(!f && (l1+l2==n/2-1 || l1+l2==n/2))s+=arr1[l1];
                l1++;
            }
            else{
                if(f && l1+l2==n/2)s+=arr2[l2];
                if(!f && (l1+l2==n/2-1 || l1+l2==n/2))s+=arr2[l2];
                l2++;
            }
        }
        return s;
    }
};

//{ Driver Code Starts.
//Back-end complete function template in C++

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr, brr;
        string input1;
        getline(cin, input1);
        stringstream ss1(input1);
        int number1;
        while (ss1 >> number1) {
            arr.push_back(number1);
        }
        string input2;
        getline(cin, input2);
        stringstream ss2(input2);
        int number2;
        while (ss2 >> number2) {
            brr.push_back(number2);
        }
        Solution ob;
        int res = ob.SumofMiddleElements(arr, brr);
        cout << res << endl;
    }
}
// } Driver Code Ends