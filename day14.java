/*
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

Example

The minimum sum is  and the maximum sum is . The function prints

16 24
Function Description

Complete the miniMaxSum function in the editor below.

miniMaxSum has the following parameter(s):

arr: an array of  integers
Print

Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.

Input Format

A single line of five space-separated integers.

Constraints


Output Format

Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

Sample Input

1 2 3 4 5
Sample Output

10 14

Solution - 


*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    long sum = 0, max = 0, min = 0;
        
        for(int i = 0; i<arr.size(); i++){
            sum = sum + arr.get(i);
        }
        
        long min_sum = arr.get(0);
        long max_sum = arr.get(0);
        
        for(int i = 0; i<arr.size(); i++){
            if (arr.get(i) < min_sum)
                min_sum = arr.get(i);
        }
        
        for(int i = 0; i<arr.size(); i++){
            if (arr.get(i) > max_sum)
                max_sum = arr.get(i);
        }
        
        System.out.println((sum - max_sum)+" "+(sum - min_sum));
    }
    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
