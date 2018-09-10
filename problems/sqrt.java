/**
Given an integer, estimate the square root to nearest integer.
 */

class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        
        int low = 0;
        int high = x / 2;
        int mid = (low + high) / 2;
        long curr_sq = (long)mid*(long)mid;
        float error = 0.9f;
        while(low <= high && Math.abs(curr_sq - (long)x) > error) {            
            if(curr_sq == (long)x) {
                return mid;
            }
            else if(curr_sq > (long)x) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
            mid = (low + high) / 2;
            curr_sq = (long)mid*(long)mid;
        }
        return mid;
    }
}