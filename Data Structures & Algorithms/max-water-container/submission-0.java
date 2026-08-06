class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;

        result = (j-i) * Math.min(height[i], height[j]);

        while(i < j){

            int leftBoxArea = (j-(i+1)) * Math.min(height[i+1], height[j]);
            int rightBoxArea = ((j-1)-i) * Math.min(height[i], height[j-1]);

            if(result <= leftBoxArea){
                result = leftBoxArea;
                i++;
            }
            else if(result <= rightBoxArea){
                result = rightBoxArea;
                j--;
            }
            else{
                if(height[j-1] > height[i+1]) i++;
                else j--;
            }
        }

        return result;
    }
}
