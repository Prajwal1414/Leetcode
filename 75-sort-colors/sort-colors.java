class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for(int i = 0 ; i < nums.length; i++){
            count[nums[i]]++;
        }
        int j = 0;
        for(int i = 0 ; i < nums.length;){
            
            while(count[j] > 0 && j < 3){
                nums[i] = j;
                count[j]--;
                i++;
            }
            j++;
        }

    }
}