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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        final int JANUARY = 31;
        int february = 28;
        final int MARCH = 31;
        final int APRIL = 30;
        final int MAY = 31;
        final int JUNE = 30;
        final int JULY = 31;
        final int AUGUST = 31;
        final int SEPTEMBER = 30;
        int [] daysInMonths = {JANUARY, february, MARCH, APRIL, MAY, JUNE, 
            JULY, AUGUST, SEPTEMBER};
        int sumOfDays = 0;
        int remainingDays = 0;
        String dateOfProgrammer = "";
        
        if (year < 1918 && year >= 1700 && year % 4 == 0)
            daysInMonths[1] = 29;
        else if (year == 1918)
            daysInMonths[1] = 15;
        else if (year > 1918 && year % 400 == 0 )
            daysInMonths[1] = 29;
        else if (year > 1918 && year % 4 == 0 && year % 100 == 0 && year % 400 != 0)
                daysInMonths[1] = 28;
        else if (year > 1918 & year % 4 == 0 && year % 100 != 0)
                daysInMonths[1] = 29;
        for (int i = 0; i <= 7; i++)
            sumOfDays += daysInMonths[i];
        
        remainingDays = 256 - sumOfDays;        
        dateOfProgrammer = remainingDays + "." + "09." + year; 
        
        return dateOfProgrammer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
