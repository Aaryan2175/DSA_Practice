class Solution {
    public int firstMissingPositive(int[] nums) {

    // Using sorting method
    Arrays.sort(nums);
    int pos = 1;
    for(int i = 0;i<nums.length;i++){
        if(nums[i] > 0 && nums[i] == pos) pos++;
        else if(nums[i] < 0) continue;
        else if(nums[i] == pos) continue;
    }

   return pos;

    //     Using HashSet
    //     HashSet<Integer> positive = new HashSet<>();

    //     for(int i = 0;i<nums.length;i++){
    //         if(nums[i] < 1) continue;
    //         else positive.add(nums[i]);
    //     }

    //     int pos = 1;
    //     while(pos<= positive.size()){
    //         if(positive.contains(pos)) pos++;
    //         else break;
    //     }

    //    return pos;

   // TLE is coming
    //        ArrayList<Integer> positive = new ArrayList<>();

    //     for(int i = 0;i<nums.length;i++){
    //         if(nums[i] < 1) continue;
    //         else if(positive.contains(nums[i])) continue;
    //         else positive.add(nums[i]);
    //     }

    //    Collections.sort(positive);
    //     int pos = 1;
    //     while(pos<= positive.size()){
    //         if(positive.contains(pos)) pos++;
    //         else break;
    //     }

    //    return pos;
        // HashSet<Integer> set = new HashSet<>();

        // for(int i = 0;i<n)
        // int pos = 1;

        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] == pos && nums[i] > 0) pos++;
        
        //     else if(nums[i] > 0) return pos;
        // }
        // return pos;

        // return pos;
    }
}
