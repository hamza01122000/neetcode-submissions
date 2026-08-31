class Solution {
    HashSet<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backTrack(nums, 0, list);
        return new ArrayList<>(res);
    }

    public void backTrack(int[] arr, int i, List<Integer> list){

        if(i >= arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        backTrack(arr, i+1, list);
        list.remove(list.size() - 1);
        backTrack(arr, i+1, list);
    }

}