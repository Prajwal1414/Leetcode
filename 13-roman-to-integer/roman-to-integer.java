class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < s.length() ; i++){
            int currentValue = map.get(s.charAt(i));

           if(i < s.length() - 1){
            int nextValue = map.get(s.charAt(i + 1));
                if(currentValue >= nextValue){
                    ans += currentValue;
                }
                else{
                    ans -= currentValue;
                }
           } 
           else{
            ans += currentValue;
           }
        }

      return ans;
    }
}