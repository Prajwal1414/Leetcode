class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400 , 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < values.length; i++){
            int val = values[i];
            String symbol = symbols[i];

            while(num >= val){
                ans.append(symbol);

                num -= val;
            }
        }

        return ans.toString();
    }
}