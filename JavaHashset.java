package DSAProblems.second_day;

import java.io.*;
import java.util.*;

public class JavaHashset {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int turn = scanner.nextInt();

        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<turn;i++){
            String firstName = scanner.next();
            String lastName = scanner.next();

            String combine = firstName +" "+ lastName;
            String reverseCombine = lastName+ " " + firstName;

            if(!set.contains(reverseCombine)) set.add(combine);
            System.out.println(set.size());
        }

    }
}
