import java.util.*;
// Time Complexity: O(V+E)
// Space Complexity: O(V)
public class problem2 {
    HashMap<Node, Node> map;
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
    public Node cloneGraph(Node node) {
        if (node==null){return null;}
        this.map= new HashMap<>();
        Queue<Node> q= new LinkedList<>();
        q.add(node);

        while(!q.isEmpty())
        {
            Node curr= q.poll();
            Node copyCurr= clone(curr);
            for (Node ne: curr.neighbors)
            {
                if (!map.containsKey(ne))
                {
                    q.add(ne);
                }
                copyCurr.neighbors.add(clone(ne));
            }
        }
        return map.get(node);
    }
    private Node clone(Node node)
    {
        if (!map.containsKey(node))
        {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}
