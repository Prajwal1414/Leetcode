class Solution {
    public long subArrayRanges(int[] nums) {
        long mins = findMinimums(nums);
        long maxs = findMaximums(nums);

        System.out.println(mins);
        System.out.println(maxs);

        return maxs - mins;
        
    }

    public long findMaximums(int[] nums){
       int[] nge = findNGE( nums);
       int[] pge = findPGE( nums);
       long sum = 0;

        for(int i = 0 ; i < nums.length; i++){
            int left = i - pge[i];
            int right = nge[i] - i;

            sum += (long) (left * right) * nums[i];
        }

        return sum;

    }

    public int[] findNGE(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, n);

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] findPGE(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public long findMinimums(int[] nums){
        int[] pse = findPSE( nums);
        int[] nse = findNSE( nums);
        long sum = 0;

        for(int i = 0; i < nums.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            sum += (long) (left * right) * nums[i];
        }

        return sum;
    }

    public int[] findPSE(int[] nums){
        int[] ans = new int[nums.length];

        Arrays.fill(ans, - 1);

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] findNSE(int[] nums){
        int[] ans = new int[nums.length];

        Arrays.fill(ans, nums.length);

        Stack<Integer> st = new Stack<>();

        for(int i = nums.length - 1 ; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}