/**
Problem Statement:
Mr X is very curious to know about the frequency of stocks. But unfortunately for him, the stocks are represented as nodes of a tree with prices of the stocks as their value. Mr X hates trees as much as he loves to learn about stocks. So he asks for your help:

    Given a tree with N nodes (each node represents a stock) numbered from 1 to N (rooted at 1). Each stock has a price/value which is denoted by Pi. He is very curious so he asks a lot of questions of the form: U L R . For each of his question he wants to know how many different stock prices/values are present in the subtree of U for which frequency is between L and R(Both inclusive).

Constraints :
    1<=N,Q,U<=105
    1<=L<=R<=105
    1<=Pi<=105

Sample Input:
6 3
1 2
1 3
2 4
2 5
5 6
2 1 2 1 1 2
2 2 2
1 2 3
3 1 4

Sample Output:
0
2
1
*/

#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>

using namespace std;

void mergeMaps(int index, vector<int> &adjacencyList, vector< unordered_map<int, int> > &freq) {
    unordered_map<int,int>::iterator tmp;
    for(int i = 0; i < adjacencyList.size(); i++) {
        for (unordered_map<int,int>::iterator it=freq[adjacencyList[i]].begin(); it!=freq[adjacencyList[i]].end(); ++it) {
            tmp = freq[index].find(it->first);
            if(tmp != freq[index].end()) {
                freq[index][it->first] = tmp->second + it->second;
            }
            else {
                freq[index][it->first] = it->second;
            }
        }
    }
}

void calculateFreq(int index, int N, vector< vector<int> > &adjacencyList, vector<int> &values, vector< unordered_map<int, int> > &freq, vector<bool> &visited) {
    visited[index] = true;
    vector<int> actualAdjacency;
    for(int i=0; i < adjacencyList[index].size(); i++) {
        if(visited[adjacencyList[index][i]] == false) {
            actualAdjacency.push_back(adjacencyList[index][i]);
            calculateFreq(adjacencyList[index][i], N, adjacencyList, values, freq, visited);
        }
    }
    freq[index][values[index]] = 1;
    if(actualAdjacency.size() != 0) {
        mergeMaps(index, actualAdjacency, freq);
    }
}

int main() {
    int N, Q, tmpA, tmpB, tmpC;
    cin>>N>>Q;
    vector< vector<int> > adjacencyList(N);
    vector<int> values;
    vector< vector<int> > queries;
    for(int i=0; i < N-1; i++) {
        cin>>tmpA>>tmpB;
        adjacencyList[tmpA - 1].push_back(tmpB - 1);
        adjacencyList[tmpB - 1].push_back(tmpA - 1);
    }
    for(int i=0; i < N; i++) {
        cin>>tmpA;
        values.push_back(tmpA);
    }
    for(int i=0; i < Q; i++) {
        cin>>tmpA>>tmpB>>tmpC;
        queries.push_back({tmpA - 1, tmpB, tmpC});
    }
    vector< unordered_map<int, int> > freq(N); 
    vector<bool> visited(N, false);
    calculateFreq(0, N, adjacencyList, values, freq, visited);
    
    for(int i=0; i < Q; i++) {
        tmpA = 0;
        for(unordered_map<int,int>::iterator it=freq[queries[i][0]].begin(); it!=freq[queries[i][0]].end(); ++it) {
            if(it->second >= queries[i][1] && it->second <= queries[i][2]) {
                tmpA++;
            }
        }
        cout<<tmpA<<"\n";
    }
    
    return 0;
}