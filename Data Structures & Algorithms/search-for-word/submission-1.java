class Solution {

    HashSet<List<Integer>> usedIndex = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ArrayList<int[]> startingIndex = new ArrayList<>();
        
        StringBuffer str = new StringBuffer();
        boolean result;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    startingIndex.add(new int[]{i, j});
                }
            }
        }

        // for (int[] coordinates : startingIndex) {
        //     System.out.println("Starting Index Cordinates "+Arrays.toString(coordinates));
        // }

        for(int i = 0; i < startingIndex.size(); i++){
            usedIndex.clear();
            int[] innerList = startingIndex.get(i);
            int l = innerList[0];
            int m = innerList[1];
            usedIndex.add(Arrays.asList(l, m));
            // System.out.println("Now we are searching for index "+ l+" "+ m);
            result = dfs(startingIndex.get(i), str.append(word.charAt(0)), word, board, 1);
            // System.out.println("We are back for Next Search & result is "+ result);
            if(result) return true;
        }

        return false;
    }

    public boolean dfs(int[] list, StringBuffer str, String word, char[][] board, int index){
        ArrayList<int[]> neighbourList = new ArrayList<>();
        // System.out.println("Final String "+str.toString());
        if(str.toString().equals(word)) {
            // System.out.println("We reached our destination");
            return true;
        }

        int i = list[0];
        int j = list[1];

        

        if(i - 1 >= 0){
            if(!usedIndex.contains(Arrays.asList(i - 1, j)))
                neighbourList.add(new int[]{i - 1, j});
        }
        if(j - 1 >= 0){
            if(!usedIndex.contains(Arrays.asList(i, j - 1)))
                neighbourList.add(new int[]{i, j - 1});
        }
        if(i + 1 < board.length){
            if(!usedIndex.contains(Arrays.asList(i + 1, j)))
                neighbourList.add(new int[]{i + 1, j});
        }
        if(j + 1 < board[0].length){
            if(!usedIndex.contains(Arrays.asList(i, j + 1)))
                neighbourList.add(new int[]{i, j + 1});
        }
    
        // for (int[] coordinates : neighbourList) {
        //     System.out.println("Searching Neighbour Cordinates "+Arrays.toString(coordinates));
        // }

        for(int k = 0; k < neighbourList.size(); k++){
            int[] innerList = neighbourList.get(k);
            int l = innerList[0];
            int m = innerList[1];

            // System.out.println("Searching Index Row "+ l);
            // System.out.println("Searching Index Col "+ m);
            // System.out.println("Searching String Char "+ word.charAt(index + 1));

            if(board[l][m] == word.charAt(index)){
                str.append(board[l][m]);
                usedIndex.add(Arrays.asList(l, m));
                boolean res = dfs(innerList, str, word, board, index + 1);
                if(res) return true;
            }
            usedIndex.remove(Arrays.asList(l, m));
        }
        str.deleteCharAt(str.length() - 1);
        return false;
        
    }
}