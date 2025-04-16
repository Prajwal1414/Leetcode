class Solution {
    public int beautySum(String s) {
        
        int totalBeauty = 0;
        int n = s.length();

        for(int i = 0 ; i < n; i++){
            int maxFreq = 0;
            int minFreq = 0;
            HashMap<Character, Integer> map = new HashMap<>();

            for(int j = i ; j < n; j++){
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);

                int currentFreq = map.get(c);
                maxFreq = Math.max(maxFreq, currentFreq);

                if(map.size() == 1){
                    minFreq = currentFreq;
                }
                else{
                    minFreq = Integer.MAX_VALUE;
                    for(int freq : map.values()){
                        minFreq = Math.min(freq, minFreq);
                    }
                }

                totalBeauty += maxFreq - minFreq;
            }


        }
            return totalBeauty;
    }
}