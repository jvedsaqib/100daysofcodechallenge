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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

   public static int pickingNumbers(List<Integer> a) {    
    int result = 0, k;
    boolean band;
    List<Integer> arrayAux = new ArrayList<Integer>();
    
    for (int i = 0; i < a.size(); i++) {
        arrayAux.add(a.get(i));
        for (int j = 0; j < a.size(); j++) {
            k = 0;
            band = true;
            while (k < arrayAux.size() && band) {
                band = (Math.abs(arrayAux.get(k) - a.get(j)) <= 1) ? true : false;
                k++;
            }
            if (band) arrayAux.add(a.get(j));         
        }
        if (arrayAux.size() - 1 > result) result = arrayAux.size() - 1;
        arrayAux.clear();
    }
    
    return result;
}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
