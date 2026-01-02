class Solution {
    public int largestRectangleArea(int[] heights) {
       int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
       for(int i = 0 ; i < n; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int nse = i;
                int ele = heights[st.peek()];
                st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, ele * (nse - pse - 1));
            }

            st.push(i);
       }

       while(!st.isEmpty()){
        int nse = n;
        int ele = heights[st.peek()];
        st.pop();
        int pse = st.isEmpty() ? -1 : st.peek();

        maxArea = Math.max(maxArea, ele * (nse - pse - 1));
       }

       return maxArea;
    }
}