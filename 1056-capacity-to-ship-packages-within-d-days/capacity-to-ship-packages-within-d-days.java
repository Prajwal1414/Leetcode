class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high = 0, low = 0, ans = 0;

        for(int w : weights){
            high += w;
            low = Math.max(low, w);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int d = 1;
            int cap = 0;

            for(int w : weights){

                if(cap + w <= mid){
                    cap += w;
                }
                else{
                    d++;
                    cap = w;
                }
            }

            if(d <= days){
                ans = mid;
                high = mid - 1;

            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}