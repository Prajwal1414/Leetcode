import java.util.*;
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        OptionalInt max = Arrays.stream(nums).max();
        int high = max.getAsInt();
        int low = 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = computeSum(nums, threshold, mid);

            if(sum <= threshold){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return low;
    }

    public int computeSum(int[] nums, int threshold, int mid){
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum += Math.ceil((float) nums[i] / (float) mid);
        }
        System.out.println("The sum for mid: " +mid+ " is: " +sum);
        return sum;
    }
}