/**
Problem Statement:
You are given a 2D character array denoting forest of length N and breadth M . In the matrix, '.' denotes barren land and ' * ' denotes tree.
You are given Q questions. In each question, you are given integer K and you have to determine the number of unique squares of side less than or equal to K which contain only trees.

Sample Input:
4 4
*..*
.***
****
.***
3
1
2
3

Output:
12
16
17
*/

import java.util.*;
import java.lang.Math;

class BobAndForest {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<String> forest = new ArrayList<>(n);
        s.nextLine();
        for(int i = 0; i < n; i++) {
            forest.add(s.nextLine());
        }
        int q = s.nextInt();
        ArrayList<Integer> queries = new ArrayList<>(q);
        for(int i = 0; i < q; i++) {
            queries.add(s.nextInt());
        }
        int[][] mat = new int[n][m];
        String tmp;
        int sqSize = Math.min(m,n) + 1;
        int[] count = new int[sqSize];
        for(int i = 0; i < n; i++) {
            tmp = forest.get(i);
            for(int j = 0; j < m; j++) {
                if(tmp.charAt(j) == '*') {
                    if(i == 0 || j == 0) {
                        mat[i][j] = 1;
                    }
                    else {
                        mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
                    }
                    count[mat[i][j]]++;
                }
                else {
                    mat[i][j] = 0;
                }
            }
        }
        ArrayList<Long> result = new ArrayList<>(q);
        int que;
        long total;
        for(int i = 0; i < q; i++) {
            total = 0;
            que = queries.get(i);
            for(int j = 1; j < que && j < sqSize; j++) {
                total += count[j] * j;
            }
            for(int j = que; j < sqSize; j++) {
                if(count[j] == 0)
                    break;
                total += count[j] * que;
            }
            result.add(total);
        }
        
        for(int i = 0; i < q; i++) {
            System.out.println(result.get(i));
        }
    }
}
