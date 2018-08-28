/**
Problem Statement:
Let's say 1,2,3 are the only digits which exists in a unique number system, so the numbers will be 1,2,3,11,12,13,21.... in ascending order .

1st number is 1 and number of digits is 1

4th will be 11 and number of digits is 2

14th will be 112 and number of digits will be 3

40th will be 1111 and number of digits will be 4

You have to find number of digits of Nth term in unique number system .

Sample Input:
4
1
4
14
40

Output:
1
2
3
4

*/


#include<iostream>
#include<cmath>
#include<vector>

using namespace std;

int main() {
    vector<long> pow3;
    int T, i;
    cin>>T;
    unsigned long long sum, inp;
    pow3.push_back(3);
    while(T--) {
        i = 0;
        sum = 0;
        cin>>inp;
        while(inp > sum) {
            if(i >= pow3.size()) {
                pow3.push_back(pow3[i-1] * 3);
            }
            sum += pow3[i];
            i++;
        }
        cout<<i<<"\n";
    }
    
    return 0;
}
