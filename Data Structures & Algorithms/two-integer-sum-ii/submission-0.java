class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];

        int i = 1;
        int j = numbers.length;

        while(i < j){
             if(numbers[i-1] + numbers[j-1] == target){     
                // System.out.println(i);
                output[0] = i;
                output[1] = j;
                break;
            }
            else if(numbers[i-1] + numbers[j-1] < target) i++;
            else if(numbers[i-1] + numbers[j-1] > target) j--;
        }

        return output;
    }
}
