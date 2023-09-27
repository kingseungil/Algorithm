import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * @problem	    전화번호 목록(5052)
 * @Url         https://www.acmicpc.net/problem/5052
 * @date		2023-09-27
 */
public class Main {

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
                if (cur.child.get(c) == null) {
                    cur.child.put(c, new Node());
                }
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                if (!trie.insert(br.readLine())) {
                    isPossible = false;
                }
            }
            sb.append(isPossible ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}
