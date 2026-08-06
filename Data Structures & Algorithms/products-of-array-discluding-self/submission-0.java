class Solution {
    public int[] productExceptSelf(int[] nums) {
        int target = 1;
        int[] productArray = new int[nums.length];

        productArray[0] = 1;

        for( int i = 1; i < nums.length; i++){
            productArray[i] = nums[i-1] * productArray[i-1];
        }
        

        for( int i = nums.length-2; i >= 0; i--){
            
            target = nums[i+1] * target;
            productArray[i] = target * productArray[i];
        }

        return productArray;
       
    }
}