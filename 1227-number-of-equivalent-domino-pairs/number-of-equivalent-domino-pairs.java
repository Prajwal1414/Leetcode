class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int count = 0;

        for(int[] domino : dominoes){
            if(domino[0] > domino[1]){
                int temp = domino[1];
                domino[1] = domino[0];
                domino[0] = temp;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(domino[0]);
            temp.add(domino[1]);
            map.put(temp, map.getOrDefault(temp, 0 ) + 1);
        }

        for(int freq: map.values()){
            count += (freq * (freq - 1)) / 2;
        }

        
        System.out.print(map);
        return count;

    }
}