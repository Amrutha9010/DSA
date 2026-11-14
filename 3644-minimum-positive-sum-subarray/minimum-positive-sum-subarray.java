class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        for(int i=l; i<=r; i++){
            min = Math.min(mini(nums,i),min);
            if(min == 1) return 1;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int mini(List<Integer> nums, int l){
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<l; i++){
            sum += nums.get(i);
        }

        if(sum > 0){
            min = Math.min(min,sum);
        }

        for(int i=l; i<nums.size(); i++){
            sum -= nums.get(i-l);
            sum += nums.get(i);
            if(sum > 0){
                min = Math.min(min,sum);
            }
        }
        return min;
    }
}