package DSAProblems.third_day;



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

class LargestRectangleResult {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static List nextSmaller(List<Integer>h, int size){

        List<Integer> result = new ArrayList<>(Collections.nCopies(size, size));
        Stack<Integer> st = new Stack<>();


        for(int i = size-1;i>=0;i--){
            while(!st.isEmpty() && h.get(st.peek()) >= h.get(i)){
                st.pop();
            }

            result.set(i,st.isEmpty() ? size : st.peek());
            st.push(i);

        }
        //    Collections.reverse(result);
        return result;
    }

    public static List prevSmaller(List<Integer>h, int size){

        List<Integer> result = new ArrayList<>(Collections.nCopies(size, size));
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<size;i++){
            while(!st.isEmpty() && h.get(st.peek()) >= h.get(i)){
                st.pop();
            }

            result.set(i,st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }

        return result;
    }

    public static long largestRectangle(List<Integer> h) {
        // Write your code here
        long maxArea = Integer.MIN_VALUE;

        List<Integer> nextSmaller = nextSmaller(h,h.size());

        List<Integer> prevSmaller = prevSmaller(h,h.size());

        for(int i = 0;i<h.size();i++){
            int height = h.get(i);

            if(nextSmaller.get(i) == -1){
                nextSmaller.set(i,h.size());
            }

            int b = nextSmaller.get(i) - prevSmaller.get(i) - 1;
            long area = height*b;
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;

    }

}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = LargestRectangleResult.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
