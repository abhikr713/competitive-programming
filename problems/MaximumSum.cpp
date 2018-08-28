/**
Problem Statement:
You are the king of Pensville where you have 2N workers. 
All workers will be grouped in association of size 2,so a total of N associations have to be formed. 
The building speed of the ith worker is Ai. 
To make an association, you pick up 2 workers. Let the minimum building speed between both workers be x, then the association has the resultant building speed x. 
You have to print the maximum value possible of the sum of building speeds of N associations if you make the associations optimally.

SAMPLE INPUT:
2
1 3 1 2

OUTPUT: 
3
*/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    int N, tmp;
    long result = 0;
    cin>>N;
    vector<int> speed;
    for(int i = 0; i < 2*N; i++) {
        cin>>tmp;
        speed.push_back(tmp);
    }
    
    sort(speed.begin(),speed.end(), std::greater<int>());
    
    for(int i = 1; i < 2*N; i+=2) {
        result += speed[i];
    }
    
    cout<<result<<'\n';
    return 0;
}