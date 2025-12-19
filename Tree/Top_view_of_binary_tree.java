
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Solution {
    static class Info{
        Node node;
        int hd;
        
        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int min = 0;
        int max = 0;
        if(root == null){
            return ans;
        }
        
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            Info curr = q.poll();
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node);
            }
            if(curr.node.left != null){
                q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new Info(curr.node.right, curr.hd+1));
                 max = Math.max(max, curr.hd+1);
            }
        }
        
        for(int i=min; i<= max; i++){
            ans.add(map.get(i).data);
        }
        return ans;
    }
}
