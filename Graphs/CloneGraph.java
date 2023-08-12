/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return null; 
        Node ans = new Node();                         
        Queue<Node> qu = new LinkedList<>();
        Queue<Node> cloneQu = new LinkedList<>();
        List<Node> cloned = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        qu.add(node);
        cloneQu.add(ans);
        while(!qu.isEmpty()){
            Node n = qu.remove();
            if (!visited.contains(n)){
                Node clone = cloneQu.remove();
                clone.val = n.val;
                cloned.add(clone);

                n.neighbors.stream().forEach( neigh -> {
                    qu.add(neigh);
                    boolean exists = false;
                    Node z = null;
                    for (Node c : cloned){
                        if (c.val == neigh.val) {
                            exists = true;
                            z = c;
                            break;
                        }
                    }
                    if (!exists){
                        Node child = new Node(neigh.val);
                        clone.neighbors.add(child);
                        cloneQu.add(child);
                        cloned.add(child);
                    } else {
                        clone.neighbors.add(z);
                    }

                    });
                visited.add(n);
            }
        }
        return ans;
    }

    public static void bfs(Node node){
        Queue<Node> qu = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        qu.add(node);
        while(!qu.isEmpty()){
            Node n = qu.remove();
            if (!visited.contains(n)){
                System.out.println(n.val);
                n.neighbors.stream().forEach( neigh -> qu.add(neigh));
                visited.add(n);
            }
        }
        
    }
}