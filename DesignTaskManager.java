class TaskManager {

   
    List<List<Integer>> ans;
    public TaskManager(List<List<Integer>> tasks) {
        ans = new ArrayList<>();
          for (List<Integer> innerList : tasks) {
            List<Integer> newInnerList = new ArrayList<>(innerList); // Create a new inner list
            ans.add(newInnerList);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        list.add(taskId);
        list.add(priority);
        ans.add(list);
    }
    
    public void edit(int taskId, int newPriority) {
        for(int i = 0;i<ans.size();i++){
            if(ans.get(i).get(1) == taskId){
                ans.get(i).set(2,newPriority);
                break;
            }
        }
    }
    
    public void rmv(int taskId) {
        
        for(int i = 0;i<ans.size();i++){
            if(ans.get(i).get(1) == taskId){
                ans.remove(i);
                break;
            }
        }
    }
    
    public int execTop() {
        if(ans.size() == 0) return -1;
        int max = Integer.MIN_VALUE;
        int task = 0;
        int user = 0;
        for(int i = 0;i<ans.size();i++){
            if(ans.get(i).get(2) == max){
                if(ans.get(i).get(1) > task){
                    task = ans.get(i).get(1);
                    user = ans.get(i).get(0);
                } 
            }
            else if(ans.get(i).get(2) > max){
             max = ans.get(i).get(2);
             task = ans.get(i).get(1);
             user = ans.get(i).get(0);
            }
        }

        rmv(task);
        return user;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */



// second approach(for last 3 cases, TLE is coming)
// class Task{  
//      int userId, taskId, priority;

//      Task(int userId, int taskId, int priority){
//         this.userId = userId;
//         this.taskId = taskId;
//         this.priority = priority;
//      }
// }

// class TaskManager {

//     List<Task> ans;
//     public TaskManager(List<List<Integer>> tasks) {
//         ans = new ArrayList<>();
//           for (List<Integer> t : tasks) {
//             ans.add(new Task(t.get(0),t.get(1),t.get(2)));
//         }
//     }
    
//     public void add(int userId, int taskId, int priority) {
//         ans.add(new Task(userId,taskId,priority));
//     }
    
//     public void edit(int taskId, int newPriority) {
//         for(Task task: ans){
//             if(task.taskId == taskId){
//                 task.priority = newPriority;
//                 break;
//             }
//         }
//     }
    
//     public void rmv(int taskId) {
//         Iterator<Task> it = ans.iterator();

//         while(it.hasNext()){
//             if(it.next().taskId == taskId){
//                 it.remove();
//                 break;
//             }
//         }
//     }
    
//     public int execTop() {
//         if(ans.size() == 0) return -1;

//         // Task topTask = null;
//         for(Task task : ans){
//             if(topTask == null || task.priority > topTask.priority || (task.priority  == topTask.priority && task.taskId > topTask.taskId)){
//                 topTask = task;
//             } 
//         }

//         ans.remove(topTask);
//         return topTask.userId;
//     }
// }

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
