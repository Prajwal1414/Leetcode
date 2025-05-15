import java.util.*;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]); 
            high = Math.max(high, bloomDay[i]);
        }

        int ans = -1;
        if((double) m * (double) k > bloomDay.length) return - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(possible(bloomDay, mid, m , k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return low;
    }

    public boolean possible(int[] arr, int day, int m, int k ){
        int count = 0;
        int no = 0;

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] <= day){
                count++;    
            }
            else{
                no += count / k;
                count = 0;
            }
        }
        no += count / k;

        if(no >= m) return true;
        else return false;
    }

    
}