class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxEle = nums[0];
        int maxInd = 0;
        ArrayList<Integer> output = new ArrayList<>();

        for(int i = 0; i < k; i++){
            if(maxEle < nums[i]){
                maxEle = nums[i];
                maxInd = i;
            }
        }
        output.add(maxEle);

        for(int i = 1, j = k; i <= nums.length - k; i++, j++){
            if(maxInd < i){
                int index = i;
                int winCount = 0;
                maxEle = nums[i];
                maxInd = index;
                while(winCount < k){
                    if(nums[index] > maxEle){
                        maxEle = nums[index];
                        maxInd = index;
                    }
                    index++;
                    winCount++;
                }
            }
            else{
                if(maxEle < nums[j]){
                    maxEle = nums[j];
                    maxInd = j;
                }
            }
            output.add(maxEle);
        }
    return output.stream().mapToInt(i -> i).toArray();
    }
}
