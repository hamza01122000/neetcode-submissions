class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean result = false;


        for(int i = 0; i< nums.length; i++){
            int currElement = nums[i];

            for(int j = 0; j<nums.length; j++){
                
                 if(nums[j] == currElement && i != j){
                    result = true;
                    break;
                 }
            }

            if(result) break;
            
        }

        System.out.println(result);
        return result;
    }
}