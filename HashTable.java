package DSAProblems.second_day;

// Solution with one Hashmap
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

class HashTableResult {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        if(magazine.size() < note.size()){
            System.out.print("No");
            return;
        }

        HashMap<String,Integer>magazineMap = new HashMap<>();
        HashMap<String,Integer>noteMap = new HashMap<>();

        for(String str : magazine){
            if(magazineMap.containsKey(str)){

                magazineMap.put(str, magazineMap.get(str)+1);
            }
            else{
                magazineMap.put(str, 1);
            }
        }


        for(String str : note){
            if(magazineMap.getOrDefault(str,0) != 0){

                magazineMap.put(str, magazineMap.get(str)-1);
            }
            else{
                System.out.print("No");
                return;
            }
        }

        System.out.print("Yes");
    }

}

public class HashTable {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        HashTableResult.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}



// Solution with Two HashMaps

//import java.io.*;
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
//class Result {
//
//    /*
//     * Complete the 'checkMagazine' function below.
//     *
//     * The function accepts following parameters:
//     *  1. STRING_ARRAY magazine
//     *  2. STRING_ARRAY note
//     */
//
//    public static void checkMagazine(List<String> magazine, List<String> note) {
//        // Write your code here
//        if(magazine.size() < note.size()){
//            System.out.print("No");
//            return;
//        }
//
//        HashMap<String,Integer>magazineMap = new HashMap<>();
//        HashMap<String,Integer>noteMap = new HashMap<>();
//
//        for(String str : magazine){
//            if(magazineMap.containsKey(str)){
//
//                magazineMap.put(str, magazineMap.get(str)+1);
//            }
//            else{
//                magazineMap.put(str, 1);
//            }
//        }
//
//
//        for(String str : note){
//            if(noteMap.containsKey(str)){
//
//                noteMap.put(str, noteMap.get(str)+1);
//            }
//            else{
//                noteMap.put(str, 1);
//            }
//        }
//
//        for(String str : note){
//
//            if(magazineMap.get(str) == null || (noteMap.get(str) > magazineMap.get(str))){
//                System.out.print("No");
//                return;
//            }
//        }
//
//        System.out.print("Yes");
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int m = Integer.parseInt(firstMultipleInput[0]);
//
//        int n = Integer.parseInt(firstMultipleInput[1]);
//
//        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .collect(toList());
//
//        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .collect(toList());
//
//        Result.checkMagazine(magazine, note);
//
//        bufferedReader.close();
//    }
//}
