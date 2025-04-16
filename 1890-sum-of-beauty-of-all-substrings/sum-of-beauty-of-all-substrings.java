class Solution {
    public int beautySum(String s) {
        int beauty = 0;

        for(int i = 0 ; i < s.length(); i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            int minFreq = 0;

            for(int j = i ; j < s.length(); j++){
                char c = s.charAt(j);
                freq[c - 'a']++;

                maxFreq = 0;
                minFreq = Integer.MAX_VALUE;
                for(int f : freq ){
                    maxFreq = Math.max(maxFreq, f);
                    if(f > 0) minFreq = Math.min(minFreq, f);
                }

                beauty += maxFreq - minFreq;
            }
        }

        return beauty;
    }
}