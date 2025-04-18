class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0 ; i < n - 1; i++){

            for(int j = i + 1 ; j <  n; j++){
                swap(matrix, i , j);
            }
        }

        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n - 1;
            int[] row = matrix[i];
            while(left < right){
                swap(row, left,right);
                left++;
                right--;
            }
        }

        
    }

    public static void swap(int[][] matrix, int i , int j){
        final int temp = matrix[i] [j];
        matrix[i] [j] =matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void swap(int[] matrix, int i , int j){
        final int temp = matrix[i];
        matrix[i] =matrix[j];
        matrix[j] = temp;
    }
}