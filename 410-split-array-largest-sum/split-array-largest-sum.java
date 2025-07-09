class Solution {
    public int splitArray(int[] nums, int k) {
       int[] sumMax = findSumMax(nums);
       int low = sumMax[1];
       int high = sumMax[0];
       int minMaxSum = 0;

       while(low <= high){
        int K = 1;
        int mid = low + ( high - low )  / 2;
        int sum = 0;
        
        for(int i = 0 ; i < nums.length; i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }
            else{
                K++;
                sum = nums[i];
            }
        }
        if(K > k){
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }
       }
       return low;
    }

    public int[] findSumMax(int[] arr) {
        int max = 0, sum = 0;

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            sum += i;
        }
        return new int[] { sum, max };
    }
}