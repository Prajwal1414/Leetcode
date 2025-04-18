class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxFreq = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for(int key: map.keySet()){
            if(map.get(key) > maxFreq){
                maxFreq = map.get(key);
                maxElement = key;
            }
        }
        return maxElement;
    }
}