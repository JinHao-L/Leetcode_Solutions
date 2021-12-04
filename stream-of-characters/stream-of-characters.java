class Node {
    char value;
    boolean isEnd;
    Node[] children = new Node[27];
    
    public Node(char value) {
        this.value = value;
    }
    
    public void insert(String s) {
        int idx = s.charAt(0) - 'a';
        
        if (children[idx] == null) {
            children[idx] = new Node(s.charAt(0));
        }

        if (s.length() > 1) {
            children[idx].insert(s.substring(1));
        } else {
            children[idx].isEnd = true;
        }
    }

    public Node getChild(char s) {
        return children[s - 'a'];
    }
}

class StreamChecker {
    List<Node> pointers;
    Node root;

    public StreamChecker(String[] words) {
        root = new Node('~');
        for(String s: words) {
            root.insert(s);
        }
        
        this.pointers = new ArrayList<Node>();
    }
    
    public boolean query(char letter) {
        boolean result = false;
        
        for(int i = 0; i < pointers.size(); i++) {
            Node ptr = pointers.get(i);
            Node next = ptr.getChild(letter);
            if (next != null) {
                pointers.set(i, next);
                if (next.isEnd) {
                    result = true;
                }
            } else {
                pointers.remove(i);
                i--;
            }
        }

        Node child = root.getChild(letter);
        if (child != null) {
            pointers.add(child);
            if (child.isEnd) {
                result = true;
            }
        }

        return result;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */