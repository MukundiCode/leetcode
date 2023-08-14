class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[][] adj = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        Queue<Integer> qu = new LinkedList<>();
        int[] ans = new int[numCourses];

        for (int[] p : prerequisites){
            adj[p[1]][p[0]] = 1;
            inDegree[p[0]]++;
        }

        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0){
                qu.add(i);
            }
        }

        int count = 0;

        while (!qu.isEmpty()){
            int current = qu.remove();

            for (int next = 0; next < adj[current].length; next++){
                if (adj[current][next] == 1){
                    inDegree[next]--;
                    if (inDegree[next] == 0){
                        qu.add(next);
                    }
                }
            }

            ans[count] = current;
            count++;
        }

        return (count == numCourses) ? ans : new int[0];

    }
}