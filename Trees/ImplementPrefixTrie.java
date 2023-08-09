class Trie {

    public List<Node> roots = new ArrayList<>();

    public Trie() {}
    
    public void insert(String word) {
        if (!isRootNodeExists(word.charAt(0))) addRootNode(word.charAt(0));
        Node n = getRootNode(word.charAt(0));
        n.add(word,word);        
    }
    
    public boolean search(String word) {
        if (!isRootNodeExists(word.charAt(0))) return false;
        return getRootNode(word.charAt(0)).exists(word);
    }
    
    public boolean startsWith(String prefix) {
        if (!isRootNodeExists(prefix.charAt(0))) return false;
        return getRootNode(prefix.charAt(0)).startsWith(prefix);
    }

    public boolean isRootNodeExists(char c){
        for (int i = 0; i < roots.size(); i++){
            if (roots.get(i) != null){
                if (roots.get(i).val == c){
                    return true;
                }
            }
        }
        return false;
    }

    public void addRootNode(char c){
        Node n = new Node(c);
        roots.add(n);
    }

    public Node getRootNode(char c){
        for (Node n : roots) {
            if (n.val == c) return n;
        }
        return null;
    }
}

class Node {
    char val;
    List<Node> children = new ArrayList<>();
    boolean isWord = false;

    public Node(char val) {
        this.val = val;
    }

    public void add(String word, String complete){
        if (word.length() == 0){
            isWord = true;
            return;
        }
        Node next = null;
        boolean exists = false;

        for (Node n : children){
            if (n.val == word.charAt(0)){
                exists = true;
                next = n;
            }
        }
        if (!exists){
            next = new Node(word.charAt(0));
            children.add(next);
        }
        next.add(word.substring(1), complete);
    }

    public boolean exists(String word){
        if (word.length() == 0){
            return (isWord) ? true : false;
        } 

        for (Node n : children){
            if (n.val == word.charAt(0)){
                return true && n.exists(word.substring(1));
            }
        }
        return false;
    }

    public boolean startsWith(String word){
        if (word.length() == 0) return true;

        for (Node n : children){
            if (n.val == word.charAt(0)){
                return true && n.startsWith(word.substring(1));
            }
        }
        return false;
    }

    public boolean isNodeExists(char c){
        for (Node n : children){
            if (n.val == c){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */