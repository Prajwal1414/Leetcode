class Solution {
    public String longestPalindrome(String s) {
        String LPS = " ";

        if(s.length() <= 1) return s;

        if(s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? s : Character.toString(s.charAt(0));
        }

        for (int i = 1 ; i < s.length(); i++){

            //Odd length
            int low = i;
            int high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high == s.length()) break;
            }

            String palindrome = s.substring(low + 1, high);
            if(palindrome.length() > LPS.length())
                LPS = palindrome;

            //Even length
            low = i - 1;
            high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high == s.length()) break;
            }

            palindrome = s.substring(low + 1, high);
            if(palindrome.length() > LPS.length())
                LPS = palindrome;
        }

        if(LPS.length() == 1) 
            return Character.toString(s.charAt(0));
        else
            return LPS;
    }
}