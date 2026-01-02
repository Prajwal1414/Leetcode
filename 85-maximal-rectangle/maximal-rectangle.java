class Solution {
    public int maximalRectangle(char[][] matrix) {
    //    System.out.println(Arrays.deepToString(getPrefixSum(matrix)))  ;
        int[][] preSum = getPrefixSum(matrix);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0 ; i < matrix.length; i++){
            maxArea = Math.max(maxArea, maxHistogram(preSum[i]));
        }

       return maxArea;
    }

    public int[][] getPrefixSum(char[][] matrix){
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] preSum = new int[rows][cols];

        for(int j = 0; j < cols; j++){
            int sum = 0;
            for(int i = 0; i < rows; i++){
                sum += matrix[i][j] - '0';

                if(matrix[i][j] == '0') sum = 0;
                preSum[i][j] = sum;
            }
        }

        return preSum;


    }

    public int maxHistogram(int[] heights){
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int nse = i;
                int ele = heights[st.pop()];
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, ele * (nse - pse - 1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int ele = heights[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, ele * (nse - pse - 1));

        }

        return maxArea;
    }
}