class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> newHashSet = new HashSet<Integer>();


        for(int i = 1; i<= nums.length; i++){
            if(newHashSet.contains(nums[i - 1]))
               return true;
            else
               newHashSet.add(nums[i - 1]);
            
        }

        return false;
    }
}