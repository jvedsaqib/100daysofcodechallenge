/*
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

 will consist at most  lower case english letters.
Sample Input

madam
Sample Output

Yes

Solution -

*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static char[] reverse(char[] arr) {
        char temp[] = new char[arr.length];
        int j = 0;
        for(int i = arr.length-1; i>=0; i--) {
            temp[j] = arr[i];
            j++;
        }
        
        return temp;
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        char arr[] = reverse(A.toCharArray());
        String B = new String(arr);
        
        if(A.equals(B))
            System.out.println("Yes");
        else
            System.out.println("No");
        
    }
}



