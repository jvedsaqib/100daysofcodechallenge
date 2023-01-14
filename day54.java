import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr < 0 || game[curr] == 1) continue;
            if (curr + leap >= game.length || curr + 1 >= game.length) return true;
            game[curr] = 1;
            queue.add(curr - 1);
            queue.add(curr + 1);
            queue.add(curr + leap);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
