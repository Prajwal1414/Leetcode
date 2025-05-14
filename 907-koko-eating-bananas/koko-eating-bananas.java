import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        OptionalInt max = Arrays.stream(piles).max();
        int high = max.getAsInt();
        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int totalHours = calcHours(piles, mid);

            if(totalHours <= h){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
            
        }
     
       return low;
    }

    private int calcHours(int[] piles, int rate){

        int totalHours = 0;
        for(int i = 0 ; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i] / (double) rate);
        }

        return totalHours;
    }
}