class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph + indegree
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        // Courses with no prerequisites
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                result[index] = i;
                index++;
            }
        }

        if(q.isEmpty()) return new int[0];

        while(!q.isEmpty()) {

            int course = q.poll();

            // Courses unlocked by this course
            for(int nextCourse : graph.get(course)) {

                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0) {
                    q.offer(nextCourse);
                    result[index] = nextCourse;
                    index++;
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}