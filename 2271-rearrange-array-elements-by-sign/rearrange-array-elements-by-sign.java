class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];

        int posIndex = 0;
        int negIndex = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] >= 0){
                positive[posIndex] = nums[i];
                posIndex++;
            } 

            else{
                negative[negIndex] = nums[i];
                negIndex++;
            } 
        }

        System.out.println(Arrays.toString(positive));
        System.out.println(Arrays.toString(negative));

        posIndex = 0;
        negIndex = 0;
        for(int i = 0 ; i < nums.length ; i++){
            
            if(i == 0 || i % 2 == 0){
                nums[i] = positive[posIndex];
                posIndex++;
            }
            else{
                nums[i] = negative[negIndex];
                negIndex++;
            }
        }

        return nums;
    }
}