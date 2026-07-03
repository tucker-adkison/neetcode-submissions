/*
Definition for a Node.
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
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();

        cloneNodes(node, nodes);
        cloneNeighbors(node, nodes, new HashSet<Integer>());

        return nodes.get(node.val);
    }

    public void cloneNodes(Node node, HashMap<Integer, Node> nodes) {
        if (!nodes.containsKey(node.val)) {
            nodes.put(node.val, new Node(node.val));

            for (Node n : node.neighbors) {
                cloneNodes(n, nodes);
            }
        }
    }

    public void cloneNeighbors(Node node, HashMap<Integer, Node> nodes, HashSet<Integer> seen) {
        if (!seen.contains(node.val)) {
            seen.add(node.val);

            ArrayList<Node> neighbors = new ArrayList<Node>();
            Node newNode = nodes.get(node.val);
            
            for (Node n : node.neighbors) {
                neighbors.add(nodes.get(n.val));
                cloneNeighbors(n, nodes, seen);
            }

            // System.out.println(newNode.val + " " + newNode + " " + neighbors);
            newNode.neighbors = neighbors;
        }
    }
}