class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

            //the data structures to use
            int[][] adj = new int[numCourses][numCourses];
            int[] inDegree = new int[numCourses];
            Queue<Integer> qu = new LinkedList<>();

            // instantiate data
            for (int[] p : prerequisites){
                adj[p[1]][p[0]] = 1;
                inDegree[p[0]]++;
            }

            //add all the nodes with indegree 0 in the qu
            for (int i = 0; i < inDegree.length; i++){
                if (inDegree[i] == 0){
                    qu.add(i);
                }
            }

            int count = 0;

            while (!qu.isEmpty()){
                int current = qu.remove();

                // update in degree for neighbours
                for (int next = 0; next < adj[current].length; next ++){
                    if (adj[current][next] == 1){
                        inDegree[next]--;
                        if (inDegree[next] == 0){
                            qu.add(next);
                        }
                    }
                }

                count++;
            }

            return count == numCourses;
    }
}

