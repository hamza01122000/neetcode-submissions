class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int output = Integer.MIN_VALUE;

        int mid = (r - l)/2 + l;

        if(nums[mid] < target){
            while(mid < r){
                if(nums[mid] == target) output = mid;
                mid++;
            }
        }
        else{
            while(mid >= l){ 
                if(nums[mid] == target) output = mid;
                mid--;
            }
        }
        return output == Integer.MIN_VALUE ? -1 : output;
    }
}
