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

class EqualStacksResult {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static Stack stackSum(List<Integer>h){
        Stack<Integer>sum = new Stack<>();

        int add = 0;
        for(int i = h.size()-1;i>=0;i--){
            add += h.get(i);
            sum.push(add);
        }

        return sum;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> firstStack = stackSum(h1);
        Stack<Integer> secondStack = stackSum(h2);
        Stack<Integer> thirdStack = stackSum(h3);

        System.out.print(firstStack);
        int maxheight = 0;
        while((firstStack.size() > 0) && (secondStack.size() > 0) && (thirdStack.size() > 0)){


            int firstHeight = firstStack.peek();
            int secondHeight = secondStack.peek();
            int thirdHeight = thirdStack.peek();

            if(firstHeight == secondHeight && firstHeight == thirdHeight){
                maxheight = firstHeight;
                break;
            }


            if(firstHeight >= secondHeight && firstHeight >= thirdHeight){
                firstStack.pop();
            }
            else if(secondHeight >= firstHeight && secondHeight >= thirdHeight){
                secondStack.pop();
            }
            else  if(thirdHeight >= firstHeight && thirdHeight >= secondHeight){
                thirdStack.pop();
            }
        }
        if(firstStack.size() > 0) return maxheight;
        return 0;
    }

}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EqualStacksResult.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Wrong Answer
// import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.function.*;
//        import java.util.regex.*;
//        import java.util.stream.*;
//        import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//class EqualStacksResult {
//
//    /*
//     * Complete the 'equalStacks' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. INTEGER_ARRAY h1
//     *  2. INTEGER_ARRAY h2
//     *  3. INTEGER_ARRAY h3
//     */
//
//    public static Stack stackSum(List<Integer>h){
//        Stack<Integer>sum = new Stack<>();
//
//        int add = 0;
//        for(int i = h.size()-1;i>=0;i--){
//            add += h.get(i);
//            sum.push(add);
//        }
//
//        return sum;
//    }
//
//    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
//        // Write your code here
//        Stack<Integer> firstStack = stackSum(h1);
//        Stack<Integer> secondStack = stackSum(h2);
//        Stack<Integer> thirdStack = stackSum(h3);
//
//        System.out.print(firstStack);
//        int maxheight = 0;
//        while((firstStack.size() > 0) && (secondStack.size() > 0) && (thirdStack.size() > 0)){
//
//
//            int firstHeight = firstStack.peek();
//            int secondHeight = secondStack.peek();
//            int thirdHeight = thirdStack.peek();
//
//            if(firstHeight == secondHeight && firstHeight == thirdHeight){
//                maxheight = firstHeight;
//                break;
//            }
//
//
//            if(firstHeight >= Math.max(secondHeight,thirdHeight)){
//                firstStack.pop();
//            }
//            else if(secondHeight >= Math.max(thirdHeight,firstHeight)){
//                secondStack.pop();
//            }
//            else  if(thirdHeight >= Math.max(secondHeight,firstHeight)){
//                thirdStack.pop();
//            }
//        }
//        if(firstStack.size() > 0) return maxheight;
//        return 0;
//    }
//
//}
//
//public class EqualStacks {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n1 = Integer.parseInt(firstMultipleInput[0]);
//
//        int n2 = Integer.parseInt(firstMultipleInput[1]);
//
//        int n3 = Integer.parseInt(firstMultipleInput[2]);
//
//        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = EqualStacksResult.equalStacks(h1, h2, h3);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
//











