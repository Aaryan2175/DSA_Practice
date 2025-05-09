package DSAProblems.third_day;

import java.io.*;
import java.util.*;

public class MinMaxRiddle {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function

        int n = arr.length;
        long[] res = new long[n + 1];  // index i stores answer for window size i

        int[] left = new int[n];     // previous smaller element indices
        int[] right = new int[n];    // next smaller element indices

        Stack<Integer> stack = new Stack<>();

        // Find indices of previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find indices of next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Fill res[] using length of window where arr[i] is minimum
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;

            res[len] = Math.max(res[len], arr[i]);
        }

        // Fill the remaining entries
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        // Skip index 0 as window size starts from 1
        return Arrays.copyOfRange(res, 1, n + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
