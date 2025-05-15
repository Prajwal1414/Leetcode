import java.util.*;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        OptionalInt min = Arrays.stream(bloomDay).min();
        OptionalInt max = Arrays.stream(bloomDay).max();
        int low = min.getAsInt();
        int high = max.getAsInt();
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countBloomed(bloomDay, mid, k);

            if (count >= m) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        return ans;
    }

    public int countBloomed(int[] arr, int day, int k) {
        int count = 0;
        int consecutive = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                consecutive++;
                if (consecutive == k) {
                    count++;
                    consecutive = 0;
                }

            } else {
                consecutive = 0;
            }
        }

        System.out.println("For day : " + day + "THe count is : " + count);

        return count;
    }
}