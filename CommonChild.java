package DSAProblems;

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

class CommonChildResult {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
        // Write your code here
        int[][] memo = new int[s1.length()+1][s2.length()+1];

        for(int i = 0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                memo[i][j] = -1;
            }
        }

        return lcs(s1,s2,s1.length(),s2.length(),memo);
    }

    public static int lcs(String s1, String s2, int len1, int len2,int[][] memo){
        if(len1 == 0 || len2 == 0) return 0;

        if(memo[len1][len2] != -1){
            return memo[len1][len2];
        }


        if(s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) memo[len1][len2] =  1 + lcs(s1,s2,len1-1,len2-1,memo);
        else{
            return memo[len1][len2] = Math.max(lcs(s1,s2,len1-1,len2,memo),lcs(s1,s2,len1,len2-1,memo));
        }
        return memo[len1][len2];
    }

}

public class CommonChild {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = CommonChildResult.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
