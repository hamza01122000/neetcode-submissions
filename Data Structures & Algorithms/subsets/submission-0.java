class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, list, res);
        return res;
    }

    public void backTrack(int[] arr, int i, List<Integer> list, List<List<Integer>> res){

        if(i >= arr.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        backTrack(arr, i+1, list, res);
        list.remove(list.size() - 1);
        backTrack(arr, i+1, list, res);
    }
}