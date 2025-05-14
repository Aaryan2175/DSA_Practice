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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
     public static boolean isAlternate(Stack<Character> st){
        
        // for(int i = st.size();i>2;i--){
        
        //     char ch = st.pop();
            
        //     if(ch == st.peek()) return false;
        //     else if(ch != st.peek()){
        //         char nextCh = st.pop();
        //         if(ch != st.peek()) return false;
        //     }
        // }
        List<Character> list = new ArrayList<>(st);
        for(int i = 1;i<list.size();i++){
            if(list.get(i) == list.get(i-1)) return false;
        } 
        return true;
     }
     
    public static int alternate(String s) {
    // Write your code here
          HashSet<Character> set = new HashSet<>();
          for(int i=0;i<s.length();i++){
             set.add(s.charAt(i));
          }
          
          ArrayList<Character> list = new ArrayList<>(set);
          
          int max = 0;
           
          for(int i = 0;i<list.size();i++ ){
            
            for(int j = i+1;j<list.size();j++){
              Stack<Character> stack = new Stack<>();
              
              for(char c : s.toCharArray()){
                if((c == list.get(i))  || (c == list.get(j))) stack.push(c);
              }
               
                if(stack.size() >= 2 && isAlternate(stack)){
                   if(stack.size() > max) max = stack.size();
               }
               
            }
            
          }
          return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
