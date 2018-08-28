/**
Problem Statement:
You have to design a new model which maps an even length palindromic number to some digit between 0 to 9.
The number is mapped to a digit  on the basis of following criteria:
1.  should appear maximum number of times in the palindromic number, that is, among all digits in the number,  should appear maximum number of times.
2. If more than one digit appears maximum number of times,  should be the smallest digit among them.

Given an integer , you have to find the digit  for the  even length palindromic number.

Note- First 9 even length palindromic numbers are:
11, 22, 33, 44, 55, 66, 77, 88, 99

Sample Input:
3
1
2
10

Output:
1
2
0
*/

import java.util.*;

class PalindromicNumber {
    static int findMaxRepeating(String num) {
        long[] hash = new long[10];
        for(int i = 0; i < num.length(); i++) {
            hash[num.charAt(i) - '0']++;
        }
        int maxIndex = 0;
        for(int i = 1; i < 10; i++) {
            if(hash[i] > hash[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        ArrayList<String> nums = new ArrayList<>(T);
        ArrayList<Integer> result = new ArrayList<>(T);
        s.nextLine();
        for(int i = 0; i < T; i++) {
            nums.add(s.nextLine());
        }
        for(int i = 0; i < T; i++) {
            result.add(findMaxRepeating(nums.get(i)));    
        }
        for(int i = 0; i < T; i++) {
            System.out.println(result.get(i));
        }
    }
}
