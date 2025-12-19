class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private void bfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            for (int j = 0; j < isConnected[curr].length; j++) {
                if (isConnected[curr][j] == 1 && !visited[j]) {  
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}
