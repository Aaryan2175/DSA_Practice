class Solution {
    static int index ;
    public static int findMax(int[] arr, int start,int end){

        if(start > end) return index;
      
        int mid = start + (end-start)/2;
        if(arr[mid]> arr[mid-1]&& arr[mid] > arr[mid+1]){
                  index = mid;
        } 
        else if(arr[mid] > arr[mid-1]) findMax(arr,mid,end);
        else findMax(arr,start,mid);

       return index;
    }

    public int peakIndexInMountainArray(int[] arr) {
        // By linear search 
        // int max = Integer.MIN_VALUE;
        // int index = 0;
        // for(int i = 0;i<arr.length;i++){
        //      if(arr[i] > max){
        //         max = arr[i];
        //         index = i;
        //      } 
        // }
        // return index;

    // By iterative binary search
    //     int start = 0;
    //     int end = arr.length - 1;
    //     int index = 0;
    //     while(start < end){
    //        int mid = start + (end-start)/2;

    //        if(arr[mid]> arr[mid +1] && arr[mid]>arr[mid-1]) return mid;
    //        else if(arr[mid]> arr[mid-1]) start = mid;
    //        else end = mid; 
    //     }
    //     return index;

    // By recursive binary search
         int start= 0;
         int end = arr.length-1;
         int index = 0;

       int ans =  findMax(arr,start,end);
       return ans;
     }

}
