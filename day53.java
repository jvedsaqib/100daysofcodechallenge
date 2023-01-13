import java.io.*;
import java.util.*;

public class Solution {

   public static void main(String[] args)
    {
         Scanner sc = new Scanner(System.in);
            int total_lines = sc.nextInt();
            ArrayList<ArrayList<Integer>> line_elements = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<total_lines;i++)
            {
                int each_line_input = sc.nextInt();
                line_elements.add(new ArrayList<Integer>());
                for(int j=0;j<each_line_input;j++)
                {
                    
                    Integer element = sc.nextInt();
                    line_elements.get(i).add(j, element);
                }
            }
            int total_queries = sc.nextInt();
            ArrayList<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<total_queries;i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                queries.add(new ArrayList<Integer>());
                queries.get(i).add(0, x);
                queries.get(i).add(1, y);
            }
            for(int i=0;i<queries.size();i++)
            {
                int line_number = queries.get(i).get(0);
                int block_number = queries.get(i).get(1);
                if(line_number<=total_lines && line_number>0)
                {
                    
                    if((line_elements.get(line_number-1).size()-1)>=(block_number-1) && (block_number-1)>=0)
                    {
                        System.out.println(line_elements.get(line_number-1).get(block_number-1));
                    }
                    else
                    {
                        System.out.println("ERROR!");
                    }
                }
                else
                {
                    System.out.println("ERROR!");
                }
            }
    }
}
