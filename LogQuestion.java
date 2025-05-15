/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main
{
    // final Comparator<List<String>> comparator = new Comparator<List<String>>(){
    //     public int compare(List<String> log1, List<String> log2){
    //         log1.get(0).compareTo(log2.get(0));
    //         return log1.get(1).compareTo(log2.get(1));
    //     }
    // };
    
    public static void extraLogs(List<List<String>> logs){
        
        List<List<String>> sortedAns = new ArrayList<>();
        
        for(int i = 0;i<logs.size();i++){
            if(logs.get(i).get(2).equals("ERROR") || logs.get(i).get(2).equals("CRITICAL")){
                       sortedAns.add(logs.get(i));
            } 
        }
        
      //  System.out.print(sortedAns);
        String[][] index = new String[sortedAns.size()][4];
        for(int i = 0;i<sortedAns.size();i++){
            
            String str = sortedAns.get(i).get(0) + sortedAns.get(i).get(1);
            index[i][0] = String.valueOf(i);
            index[i][1] = str;
            index[i][2] = sortedAns.get(i).get(2);
            index[i][3] = sortedAns.get(i).get(3);
            
        }
        
        Arrays.sort(index,Comparator.comparing(row -> row[1]));
        
        for(int i = 0;i<index.length;i++){
            int indexAt = Integer.parseInt(index[i][0]);
            System.out.println(sortedAns.get(indexAt));
        }
        
        
        
    }
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    List<List<String>> logs = new ArrayList<>();
	    
	    int size = scanner.nextInt();
	    while(size>0){
	        List<String> log = new ArrayList<>();
	        String date = scanner.next();
	        log.add(date);
	        
	        String time = scanner.next();
	        log.add(time);
	        
	        String status = scanner.next();
	        log.add(status);
	        
	        String message = scanner.next();
	        log.add(message);
	        
	        logs.add(log);
	        size--;
	    }
	   
		extraLogs(logs);
	}
}
