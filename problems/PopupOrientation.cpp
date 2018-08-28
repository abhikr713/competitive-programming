/**
Problem Statement:
In web application development, it is often required to draw a pop-up window on top of a web page when the user clicks on an icon on the page that brings up the pop-up.
You are given a web page with width x and height y, a pop-up window with width l and height m, and an icon at distance a from the left of the page and distance b from the bottom of the page.
Your program should output the orientation in which the pop-up can be rendered fully, relative to the icon, within the page dimensions. The orientation of pop up should be such that it lies completely within the page.
There are 4 possible orientations: bottom-right, bottom-left, top-right and top-left, in the same order of preference. In other words, you should first attempt to render the pop-up bottom-right, and if that is not possible, try bottom-left, and so on.

Note: Icon location and pop-up size are such that the pop-up can always be fully rendered within the page.

Sample Input:
4
1024 768 200 300 200 600
1024 768 200 300 1000 600
1024 768 200 300 200 200
1024 768 200 300 900 100

Output:
bottom-right
bottom-left
top-right
top-left
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

string findPosition(vector<int> t) {
    int x = t[0], y = t[1], l = t[2], m = t[3], a = t[4], b = t[1] - t[5];
    if(a+l <= x && b+m <= y) {
        return "bottom-right";
    }
    else if(a-l >= 0 && b+m <= y) {
        return "bottom-left";
    }
    else if(a+l <= x && b-m >= 0) {
        return "top-right";
    }
    else if(a-l >= 0 && b-m >= 0) {
        return "top-left";
    }
    return "\n";
}

int main() {
    
    int T, x, y, l, m, a, b;
    cin>>T;
    vector<vector<int>> dims;
    
    while(T--) {
        vector<int> t;
        cin>>x>>y>>l>>m>>a>>b;
        t.push_back(x);
        t.push_back(y);
        t.push_back(l);
        t.push_back(m);
        t.push_back(a);
        t.push_back(b);
        dims.push_back(t);
    }
    
    for(int i = 0; i < dims.size(); i++) {
        cout<<findPosition(dims[i])<<"\n";
    }
    
    return 0;
}