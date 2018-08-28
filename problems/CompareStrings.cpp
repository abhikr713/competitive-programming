/**
Problem Statement:
You have been given two strings, A and B (of length N each) and Q queries.
The strings contain only 0s and/or 1s.

For every query, you are given an index i. You have to update the value at index i to 1 in string B and check if B is lexicographically equal to or larger than A or not.
If yes, then print "YES" and if not, print "NO" (without quotes).

Sample Input:
5 5
11111
00010
1
2
3
4
5

Output:
NO
NO
NO
NO
YES
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

int compareBinaryStr(string a, string b, int startPos) {
    for(int i = startPos; i < a.length(); i++) {
        if(a[i] < b[i]) {
            return -1;
        }
        else if(a[i] > b[i]) {
            return i+1;
        }
    }
    return -1;
}

int main() {
    string a,b;
    int n,q,inp,lastPos;
    vector<int> queries;
    cin>>n>>q;
    cin>>a>>b;
    for(int i = 0; i< q; i++) {
        cin>>inp;
        queries.push_back(inp);
    }
    lastPos = compareBinaryStr(a, b, 0);
    for(int i = 0; i< q; i++) {
        inp = queries[i];
        if(lastPos != -1 && b[inp - 1] == '0') {
            b.replace(inp-1,1,"1");
            if(inp <= lastPos) {
                lastPos = compareBinaryStr(a,b,inp - 1);
            }
        }
        if(lastPos == -1) {
            cout<<"YES\n";
        }
        else {
            cout<<"NO\n";
        }
    }
    return 0;
}