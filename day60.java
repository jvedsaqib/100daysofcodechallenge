import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque deque = new LinkedList<>();
        HashSet hashSet = new HashSet<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            deque.add(input);
            hashSet.add(input);
            if (deque.size() == m) {
                max = Math.max(max, hashSet.size());
                int remove = (int) deque.removeFirst();
                if (!deque.contains(remove)) {
                    hashSet.remove(remove);
                }
            }
        }
        System.out.println(max);
    }
}
