import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Integer[] array = {1, 2, 3};
        String[] str1 = {"Hello", "World"};
        
        printAll(array);
        printAll(str1);
        
    }
    
    public static <E> void printAll(E[] data){
        for(E t: data){
            System.out.println(t);
        }
    }
}
