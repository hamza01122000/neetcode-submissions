class Solution {
    public int findDuplicate(int[] nums) {
        int fastPtr = nums[0];
        int slowPtr = nums[0];


        while(true){
            slowPtr = nums[slowPtr];
            fastPtr = nums[nums[fastPtr]];
            if(slowPtr == fastPtr) break;
        }

        slowPtr = nums[0];

        while(slowPtr != fastPtr){
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
        }

        return slowPtr;
    }
}
