/**
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */

class Solution {
    private int numTreesRecurse(int n, int[] result) {
        if(result[n] != -1) {
            return result[n];
        }
        
        int res = 0;
        
        for(int i = 1; i <= Math.ceil(n/2.0); i++) {
            res += ((n%2 != 0 && i == Math.ceil(n/2.0)) ? 1 : 2) * numTreesRecurse(n-i, result) * numTreesRecurse(i-1, result);
        }
        
        result[n] = res;
        return res;
    }
    
    public int numTrees(int n) {
        int[] result = new int[n+1];
        Arrays.fill(result, -1);
        result[0] = 1;
        if(n > 0)
            result[1] = 1;
        if(n > 1)
            result[2] = 2;
        if(n > 2)
            result[3] = 5;
        return numTreesRecurse(n, result);
    }
}