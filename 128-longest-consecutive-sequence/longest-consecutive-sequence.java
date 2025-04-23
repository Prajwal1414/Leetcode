class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0 ) return 0;
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        int count = 0;
        for(int i = 0 ; i < nums.length; i++)
            set.add(nums[i]);

        for(int num : set){

            if(!set.contains(num - 1)){
                count = 1;
                int x = num;

                while(set.contains(x + 1)){
                    count++;
                    x++;
                }
                
                longest = Math.max(longest,count);

            }
        }

        return longest;
    }
}