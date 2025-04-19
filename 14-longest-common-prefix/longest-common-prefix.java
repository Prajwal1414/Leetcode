class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder ans = new StringBuilder();

        for(int i = 0 ; i < first.length() ; i++){

            if(first.charAt(i) == last.charAt(i))
                ans.append(first.charAt(i));
            else return ans.toString();
        }

        return ans.toString();
    }
}