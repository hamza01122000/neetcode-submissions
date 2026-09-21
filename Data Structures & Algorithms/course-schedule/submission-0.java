class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            map.merge(prerequisites[i][0], 1, Integer:: sum);
        }

        for(int i = 0; i < numCourses; i++){
            if(!map.containsKey(i)) q.offer(i);
        }

        if(q.isEmpty()) return false;

        int courseTaken = q.size();

        while(!q.isEmpty()){
            int edge = q.poll();

            for(int i = 0; i < n; i++){
                if(edge == prerequisites[i][1]){
                    map.computeIfPresent(prerequisites[i][0], (key, val) -> val - 1);
                    if(map.get(prerequisites[i][0]) == 0){
                        courseTaken++;
                        q.offer(prerequisites[i][0]);
                    } 
                }
            }
        }

        return courseTaken == numCourses ? true : false;
    }
}