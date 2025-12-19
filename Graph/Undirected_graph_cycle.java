class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int edge[] = edges[i];
            int p = edge[0];
            int q = edge[1];
            adj.get(p).add(q);
            adj.get(q).add(p);
        }
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                if(dfs(neigh, node, visited, adj)) return true;
            }else if(neigh != parent){
                return true;
            }
        }
        return false;
    }
}
