import java.util.*;
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int i = 0 ; i < nums.length; i++){
            high = Math.max(high, nums[i]);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = computeSum(nums, mid);

            if(sum <= threshold){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return low;
    }

    public int computeSum(int[] nums, int mid){
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            //This is just an optimal way to write Math.ceil( (float) nums[i] / (float) mid)
            sum += (nums[i] + mid - 1 ) / mid;
        }
        System.out.println("The sum for mid: " +mid+ " is: " +sum);
        return sum;
    }
}