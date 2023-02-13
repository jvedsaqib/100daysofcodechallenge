import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // All possible MS's 
                /*In the above the below each row represents a 3x3 magic square (explained in more detail little further)*/
        int[][] possibleMS = {{8, 1, 6, 3, 5, 7, 4, 9, 2},
                              {6, 1, 8, 7, 5, 3, 2, 9, 4},
                              {4, 9, 2, 3, 5, 7, 8, 1, 6},
                              {2, 9, 4, 7, 5, 3, 6, 1, 8},
                              {8, 3, 4, 1, 5, 9, 6, 7, 2},
                              {4, 3, 8, 9, 5, 1, 2, 7, 6},
                              {6, 7, 2, 1, 5, 9, 8, 3, 4},
                              {2, 7, 6, 9, 5, 1, 4, 3, 8}};
        // Min cost variable            
        int minCost = Integer.MAX_VALUE;
        
        /*Looping through the possible MS's*/
        for (int i = 0; i < possibleMS.length; i++){
            int currentCost = 0;
            for (int j =0; j < possibleMS[i].length; j++){
            // Getting the right indexes of Lis s and currentCost
                currentCost += Math.abs(s.get(j/3).get(j%3) - possibleMS[i][j]);
            }
            if(currentCost < minCost) minCost = currentCost;
        }
        
        return minCost;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
