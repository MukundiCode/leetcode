/**
TODO IMPLEMENT IS WORD
*/
class WordDictionary {

    List<Node> roots = new ArrayList<>();


    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        if (!isRootNodeExists(word.charAt(0))) {
            Node n = new Node(word.charAt(0));
            roots.add(n);
        }

        Node root = getRootNode(word.charAt(0));
        root.add(word.substring(1));

    }
    
    public boolean search(String word) {

        if (word.charAt(0) == '.'){
            for (Node root : roots){
                if (root.search(word.substring(1))){
                    return true;
                }
            }
            return false;
        }

        if (!isRootNodeExists(word.charAt(0))) return false;
        return getRootNode(word.charAt(0)).search(word.substring(1));
    }

    public Node getRootNode(char c){
        for (Node root: roots){
            if (root.val == c){
                return root;
            }
        }
        return null;
    }

    public boolean isRootNodeExists(char c){
        for (Node root: roots){
            if (root.val == c) return true;
        }
        return false;
    }


}

class Node {
    char val;
    List<Node> children = new ArrayList<>();
    boolean isWord = false;

    public Node(char c){
        this.val = c; 
    }

    public void add(String word){
        if (word.length() == 0){
            isWord = true;
            return;
        } 
        boolean exists = false;
        Node next = null;
        for (Node n: children){
            if (n.val == word.charAt(0)){
                exists = true;
                next = n;
            }
        }

        if (!exists){
            next = new Node(word.charAt(0));
            children.add(next);
        }
        next.add(word.substring(1));
    }

    public boolean search(String word){
        if (word.length() == 0) {
            return isWord ? true : false;  
        } 

        if (word.charAt(0) == '.'){
            for (Node child : children){
                if (child.search(word.substring(1))){
                    return true;
                }
            }
            return false;
        }


        Node next = null;
        for (Node child : children ){
            if (child.val == word.charAt(0)){
                return true && child.search(word.substring(1));
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */