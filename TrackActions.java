/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int actions = scanner.nextInt();
		int maxAction = scanner.nextInt();
		
		ArrayList<String> registerAction = new ArrayList<>();
		ArrayList<String> analyticsStore = new ArrayList<>();
		HashMap<String,Integer> frequentActionsSort = new HashMap<>();
		
		while(actions > 0){
		    String action = scanner.next();
		    
		    if(action.equals("registerAction")){
		        String button = scanner.next();
		        registerAction.add(button);
		        
		        if(registerAction.size() == maxAction){
		            for(int i = 0;i<registerAction.size();i++){
		                analyticsStore.add(registerAction.get(i));
		            }
		            registerAction.clear();
		        }
		        
		        if(frequentActionsSort.containsKey(button)){
		            frequentActionsSort.put(button,frequentActionsSort.get(button)+1);
		        }
		        else{
		            frequentActionsSort.put(button,1);
		        }
		        
		    }
		    
		    else if(action.equals("getTotalNumberOfLoggedActions")){
		        System.out.println(registerAction.size() + analyticsStore.size());
		    }
		    else if(action.equals("getNumberOfActionRegisteredButNotSentToAnalyticsStore")){
		        System.out.println(registerAction.size());
		    }
		    else if(action.equals("getMostFrequentlyUsedActions")){
		        
		        List<Map.Entry<String,Integer>> sortedMap = new ArrayList<>(frequentActionsSort.entrySet());
		        
		        sortedMap.sort(Map.Entry.<String,Integer>comparingByValue().reversed());
		       
		        
		        int val = sortedMap.get(0).getValue();
		       sortedMap.sort(Map.Entry.<String,Integer>comparingByKey());

		        
		        for(int m = 0;m<sortedMap.size();m++){
		            if(sortedMap.get(m).getValue() == val) System.out.print(sortedMap.get(m).getKey()+ " ");
		        }
		    }
		    actions--;
		}
		
		System.out.println();
		for(int i = 0;i<analyticsStore.size();i++){
		    System.out.print(analyticsStore.get(i) + " ");
		}
	}
}
