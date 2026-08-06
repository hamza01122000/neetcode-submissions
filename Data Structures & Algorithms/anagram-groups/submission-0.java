class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        ArrayList<List<String>> outerList = new ArrayList<>();

        for(int i = 1; i <= strs.length; i++){
            // String originalElement = strs[i-1];
            char[] charArray = strs[i-1].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            hashMap.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(i);
        }

        hashMap.forEach((k, v) -> {
            ArrayList<String> innerList = new ArrayList<>();
            for(int value : v){
                innerList.add(strs[value - 1]);
            }

            outerList.add(innerList);
        });
        
        return outerList;

    }
}
