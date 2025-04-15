class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> Smap = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++){
            if(!Smap.containsKey(s.charAt(i))){

                if(!Smap.containsValue(t.charAt(i)))
                    Smap.put(s.charAt(i), t.charAt(i));
                else
                    Smap.put(s.charAt(i), null);
            }
        }
        System.out.println(Smap);
        for(int i = 0 ; i < s.length(); i++){
            
            if( Smap.containsValue(null) || Smap.get(s.charAt(i)) != t.charAt(i)) return false;
            
        }
        return true;
    }
}