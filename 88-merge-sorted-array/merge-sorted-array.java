class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for(int i = m ; i < m + n; i++){
            nums1[i] = nums2[i - m];
        }

        int gap = (int) Math.ceil((m + n) + 1/ 2.0 );
        System.out.println(Math.ceil((m + n) / 2.0 ));
        while(gap > 0){
            int left = 0;
            int right = gap;

            while( right < m + n  ){
                if(nums1[left] <= nums1[right]){
                    left++;
                    right++;
                }
                else{
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;
                    left++;
                    right++;
                }
            }

            
            if(gap <= 1) {
                gap = 0;
            }
            else{
                gap = (int) Math.ceil(gap / 2.0);
            }

        }
    }
}