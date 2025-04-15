class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] Smap = new int[200];
        int[] Tmap = new int[200];

        for( int i = 0 ; i < s.length(); i++){

            if(Smap[s.charAt(i)] != Tmap[t.charAt(i)])
                return false;

            Smap[s.charAt(i)] = i + 1;
            Tmap[t.charAt(i)] = i + 1;
        }
        return true;
    }
}