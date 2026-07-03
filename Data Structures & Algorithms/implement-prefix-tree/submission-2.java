class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node(true);
    }

    public void insert(String word) {
        Node node = this.root;

        for (char c : word.toCharArray()) {
            if (node.neighbors[c - 'a'] == null) {
                node.neighbors[c - 'a'] = new Node(false); 
            }

            node = node.neighbors[c - 'a'];
        }

        node.end = true;
    }

    public boolean search(String word) {
        Node node = this.root;
        for (char c : word.toCharArray()) {
            if (node.neighbors[c-'a'] != null) {
                node = node.neighbors[c - 'a'];
            } else {
                return false;
            }
        }

        return node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = this.root;
        for (char c : prefix.toCharArray()) {
            if (node.neighbors[c-'a'] != null) {
                node = node.neighbors[c - 'a'];
            } else {
                return false;
            }
        }

        return true;
    }

    class Node {
        boolean end;
        Node[] neighbors;

        public Node(boolean end) {
            this.end = end;
            this.neighbors = new Node[26];;
        }
    }
}
