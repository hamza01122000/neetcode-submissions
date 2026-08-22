class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backTrack(candidates, 0, 0, target, list, res);
        return res;
    }

    public void backTrack(int[] arr, int index, int sum, int target, List<Integer> subList, List<List<Integer>> result){

        if(sum == target){
            result.add(new ArrayList<>(subList));
            return;
        }
        if(sum > target || index >= arr.length) return;

        subList.add(arr[index]);
        backTrack(arr, index, sum + arr[index], target, subList, result);
        subList.remove(subList.size() - 1);
        backTrack(arr, index+1, sum, target, subList, result);
        
    }
}