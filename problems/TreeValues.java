/**
Problem Statement:
For each node in a tree find the maximum distance between two nodes in the subtree. Assume an edge is a distance of 1 unit.
*/

import java.util.*;
 
class TreeValues {
    
    public static void findSubtreeDepth(int source, List<List<Integer>> edges, int[] dist) {
        Stack<Integer> depthStack = new Stack<>();
        Queue<Integer> temp = new LinkedList<>();
        int[] depth = new int[edges.size()];
        boolean[] visited = new boolean[edges.size()];
        depthStack.push(source);
        temp.add(source);
        visited[source] = true;
        int tempSrc, tempChild, max1, max2, maxDist;
        List<Integer> sourceEdges, tempEdges;
        
        while(temp.peek() != null) {
            tempSrc = temp.remove();
            sourceEdges = edges.get(tempSrc);
            tempEdges = new ArrayList<>();
            for(int i = 0; i < sourceEdges.size(); i++) {
                tempChild = sourceEdges.get(i);
                if(visited[tempChild] == false) {
                    visited[tempChild] = true;
                    tempEdges.add(tempChild);
                    depthStack.push(tempChild);
                    temp.add(tempChild);   
                }
            }
            edges.set(tempSrc, tempEdges);
        }
        
        while(depthStack.empty() != true) {
            tempSrc = depthStack.pop();
            sourceEdges = edges.get(tempSrc);
            max1 = max2 = -1;
            maxDist = 0;
            for(int i = 0; i < sourceEdges.size(); i++) {
                tempChild = sourceEdges.get(i);
                if(max1 < depth[tempChild]) {
                    max2 = max1;
                    max1 = depth[tempChild];
                }
                else if(max2 < depth[tempChild]) {
                    max2 = depth[tempChild];
                }
                if(maxDist < dist[tempChild]) {
                    maxDist = dist[tempChild];
                }
            }
            depth[tempSrc] = max1 + 1;
            dist[tempSrc] = max1 + max2 + 2;
            if(dist[tempSrc] < maxDist) {
                dist[tempSrc] = maxDist;
            }
        }
    }
    
    public static void main(String args[] ) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), t1, t2;
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for(int i = 0; i < N; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < N - 1; i++) {
            t1 = s.nextInt() - 1;
            t2 = s.nextInt() - 1;
            edges.get(t1).add(t2);
            edges.get(t2).add(t1);
        }
        
        int[] dist = new int[N];
        
        findSubtreeDepth(0, edges, dist);
        
        for(int i = 0; i < N; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}