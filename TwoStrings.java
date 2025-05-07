package DSAProblems.second_day;


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

class TwoStringsResult {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here


        HashMap<Character,Integer>firstString = new HashMap<>();
        HashMap<String,Integer>noteMap = new HashMap<>();

        for(char str : s1.toCharArray()){
            if(firstString.containsKey(str)){

                firstString.put(str, firstString.get(str)+1);
            }
            else{
                firstString.put(str, 1);
            }
        }


        for(char str : s2.toCharArray()){
            if(firstString.getOrDefault(str,0) != 0){

                return "YES";
            }


        }
        return "NO";


         //Some cases not working
        //    HashSet<Character> concate = new HashSet<>();

        //    for(char ch : s1.toCharArray()){
        //     concate.add(ch);
        //    }

        //    for(char ch : s2.toCharArray()){
        //     concate.add(ch);
        //    }

        //    if(concate.size() != (s1.length() + s2.length())){
        //     return "YES";
        //    }

        //    return "NO";

            // TLE is coming
        // for(char ch : s1.toCharArray()){
        //     if(s2.indexOf(ch) != -1){
        //         return "YES";
        //     }
        // }

        // return "NO";
    }

}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = TwoStringsResult.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
