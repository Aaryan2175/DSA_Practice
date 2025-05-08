package DSAProblems.third_day;

import java.io.*;
import java.util.*;

public class QueuesAndStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Stack<Character> st = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for(char ch : str.toCharArray()){
            st.push(ch);
            queue.add(ch);
        }

        while(!st.isEmpty()){
            if(!(st.pop()).equals(queue.poll())) {
                System.out.print("The word, " + str + ", is not a palindrome.");
                break;
            }
        }

        if(st.size() == 0){
            System.out.print("The word, " + str + ", is a palindrome.");
        }
    }
}
