package DSAProblems.third_day;

import java.io.*;
        import java.util.*;

public class QueueUsingTwoStacks {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


        Scanner scanner = new Scanner(System.in);
        Stack<Long> firstStack = new Stack<>();
        Stack<Long> secondStack = new Stack<>();

        long turn = scanner.nextInt();
        long front = 0;

        while(turn != 0){
            int query = scanner.nextInt();

            if(query == 1){  // pushing element in stack
                long data = scanner.nextInt();
                firstStack.push(data);
            }
            else if(query == 2){   // code for pop the first element
                if(secondStack.isEmpty()){
                    while(!firstStack.isEmpty()){
                        secondStack.push(firstStack.pop());
                    }
                }

                if(!secondStack.isEmpty()) secondStack.pop();

            }
            else {
                   // code for printing first element
                if(secondStack.isEmpty()){
                    while(!firstStack.isEmpty()){
                        secondStack.push(firstStack.pop());
                    }
                }

                if(!secondStack.isEmpty()) System.out.println(secondStack.peek());

            }

            turn--;
        }
    }
}

// TLE is coming
//import java.io.*;
//        import java.util.*;
//
//public class Solution {
//
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//
//
//        Scanner scanner = new Scanner(System.in);
//        Stack<Integer> firstStack = new Stack<>();
//        Stack<Integer> secondStack = new Stack<>();
//
//        int turn = scanner.nextInt();
//        int front = 0;
//
//        while(turn != 0){
//            int query = scanner.nextInt();
//
//            if(query == 1){
//                int data = scanner.nextInt();
//                firstStack.push(data);
//            }
//            else if(query == 2){
//                while(firstStack.size() > 1){
//                    secondStack.push(firstStack.pop());
//                }
//
//                firstStack.pop();
//
//                while(secondStack.size() > 0){
//                    firstStack.push(secondStack.pop());
//                }
//            }
//            else if(query == 3){
//                while(firstStack.size() > 1){
//                    secondStack.push(firstStack.pop());
//                }
//
//                front = firstStack.peek();
//
//                while(secondStack.size() > 0){
//                    firstStack.push(secondStack.pop());
//                }
//
//                System.out.println(front);
//            }
//
//            turn--;
//        }
//    }
//}
