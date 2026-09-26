// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         int count = 0;
//         int result = 0;
//         Queue<String> q = new ArrayDeque<>();
//         boolean[] visited = new boolean[wordList.size()];

//         if (!wordList.contains(endWord)) {
//             return 0;
//         }

//         // if (wordList.contains(beginWord)) {
//         //     result = 0;
//         // }

//         q.offer(beginWord);

//         while(!q.isEmpty()){
//             int qsize = q.size();
//             // List<String> strList = q.poll();
//             // System.out.println("Removal of Queue "+qsize);
//             for(int m = 0; m < qsize; m++){
//                 // System.out.println("We are cheking for "+chkStr);
//                 String chkStr = q.poll();
//                 if(chkStr.equals(endWord)) return result + 1;
//                 for(int i = 0; i < wordList.size(); i++){
//                     // System.out.println(" For str "+wordList.get(i)+" and it's visited Array is "+visited[i]);
                    
//                     if(!visited[i]){
//                         String str = wordList.get(i);
//                         // System.out.println("Here we are cheking for "+str+" with "+chkStr);
//                         StringBuilder st = new StringBuilder();
//                         for(int j = 0; j < str.length(); j++){
//                             char c1 = str.charAt(j);
//                             char c2 = chkStr.charAt(j);

//                             if(c1 != c2) st.append(c1);
//                         }

//                         String startStr = st.toString();
//                         // System.out.println("Diffrence String is "+startStr);
//                         if(startStr.length() == 1){
//                             q.offer(str);
//                             visited[i] = true;
//                         }
//                         // if(startStr.length() > 1 && i == wordList.size() - 1) return 0;
//                     }
//                 }
//             }
//             if(q.isEmpty()) return 0;
//             // System.out.println(" Currently Queue is "+q+" And Result is "+result);
//             result = result + 1;
//         }
//         return result;
//     }
// }

// Negative Test case is not passing, Just the Positive is running. 
// It work but we can also generate all the possible Neighbours and look up in wordSet.


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // If endWord doesn't exist, transformation is impossible
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // HashSet gives O(1) average lookup
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        // beginWord itself should not be discovered again
        wordSet.remove(beginWord);

        int result = 1;

        while (!q.isEmpty()) {

            int qsize = q.size();

            for (int k = 0; k < qsize; k++) {

                String current = q.poll();

                if (current.equals(endWord)) {
                    return result;
                }

                char[] chars = current.toCharArray();

                // Change every character position
                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    // Try all 26 alphabets
                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;

                        String next = new String(chars);

                        // HashSet acts as both dictionary + visited
                        if (wordSet.remove(next)) {
                            q.offer(next);
                        }
                    }

                    // Restore original character
                    chars[i] = original;
                }
            }

            result++;
        }

        return 0;
    }
}
