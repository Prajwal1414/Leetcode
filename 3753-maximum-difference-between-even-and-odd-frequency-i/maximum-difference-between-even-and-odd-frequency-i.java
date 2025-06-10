class Solution {
    public int maxDifference(String s) {
        int[] map = new int[26];

        for(Character c : s.toCharArray()){
           map[c - 'a']++;
        }
        System.out.println(Arrays.toString(map));
        int odd = 0;
        int even = s.length();
        for(int i = 0 ; i < 26 ; i++){
           if(map[i] % 2 != 0) {
             odd = Math.max(odd, map[i]);
           }

           if(map[i] % 2 == 0 && map[i] > 0) {
             even = Math.min(even, map[i]);
           }
        }
        return odd - even;
    }
    }