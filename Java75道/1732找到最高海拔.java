class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int pre = 0;
        int current  = 0;
        for(int i = 0; i < gain.length; i++){
            current = pre + gain[i];
            pre = current;
            if(current > max){
                max = current;
            }
        }
        return max;
    }
}
//送自信题目，不多说