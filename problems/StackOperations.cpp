/*
Problem Statement:
You are given a stack of N integers. In one operation, you can either pop an element from the stack or push any popped element into the stack. You need to maximize the top element of the stack after performing exactly K operations. If the stack becomes empty after performing K operations and there is no other way for the stack to be non-empty, print -1.

Sample Input:
6 4
1 2 4 3 3 5

Output:
4
*/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    long N, K, tmp;
    cin>>N>>K;
    if(N == 1 && K%2 == 1) {
        cout<<-1<<"\n";
        return 0;
    }
    vector<long> stack;
    for(int i = 0; i < N && i < K+1; i++) {
        cin>>tmp;
        stack.push_back(tmp);
    }
    int maxPos = max_element(stack.begin(), stack.end()) - stack.begin();
    
    if(maxPos == K-1) {
        stack.erase(stack.begin() + maxPos);
    }
    
    cout<<*max_element(stack.begin(), stack.end())<<"\n";
    return 0;
}
