import java.util.*;

class Solution {
    static class Node {
        HashMap<Character, Node> child;
        boolean isLastChar;
        
        public Node() {
            this.child = new HashMap<>();
            this.isLastChar = false;
        }
    }
    
    static class Trie {
        Node root;
        
        public Trie() {
            this.root = new Node();
        }
        
        public boolean insert(String str) {
            Node cur = this.root;
            
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                cur.child.putIfAbsent(c,new Node());
                cur = cur.child.get(c);
                if (cur.isLastChar) {
                    return false;
                }
            }
            if (!cur.child.isEmpty()) {
                return false;
            }
            cur.isLastChar = true;
            return true;
        }
    }
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();

        for (int i = 0; i < phone_book.length; i++) {
            if(!trie.insert(phone_book[i])) {
                answer = false;
            }
        }
        return answer;
    }
}