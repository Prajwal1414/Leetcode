class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0 ; i < n - 2; i++){

            int first = i ;
            int second = first + 1;
            int third = second + 1;

            if(2 * (nums[first] + nums[third]) == nums[second]){
                count++;
            }


            
        }
        return count;
    }
}