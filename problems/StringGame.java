/**
Problem Statement:
Player1 and Player2 decided to play a game. The game comprises of a String S which consist of lowercase English alphabets only and both players take alternative terms.

In each turn, a Player choose a character present in the string and remove all occurrences of the character. For each player to play his turn, there should be at least one character in the string. The Player who is not able to play his turn loses.

Your task is to find the winner of the game, if both the players play optimally and Player1 plays the first turn.

Sample Input:
1
aba

Output:
Player2
*/

import java.util.*;

class StringGame {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        int[] hash;
        int count;
        while(T-- != 0) {
            String str = s.nextLine().trim();
            hash = new int[26];
            count = 0;
            for(int i = 0; i < str.length(); i++) {
                if(hash[str.charAt(i) - 'a'] == 0) {
                    count++;
                    hash[str.charAt(i) - 'a']++;
                }
            }
            if(count % 2 == 0) {
                System.out.println("Player2");
            }
            else {
                System.out.println("Player1");
            }
        }

    }
}