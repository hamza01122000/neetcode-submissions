class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

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
            }
        }

        int courseTaken = 0;

        while(!q.isEmpty()) {

            int course = q.poll();
            courseTaken++;

            // Courses unlocked by this course
            for(int nextCourse : graph.get(course)) {

                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0) {
                    q.offer(nextCourse);
                }
            }
        }

        return courseTaken == numCourses;
    }
}