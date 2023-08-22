import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    * 문제: 트리의 부모 찾기
    https://www.acmicpc.net/problem/11725
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트로 트리 구현
        List<List<Integer>> tree = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 정보를 읽고 인접 리스트에 저장
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a,b를 연결
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // bfs를 이용해 부모 찾기
        boolean[] visited = new boolean[N + 1];
        int[] parents = new int[N + 1];

        bfs(tree, 1, visited, parents);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }


    public static void bfs(List<List<Integer>> tree, int start, boolean[] visited, int[] parents) {
        // bfs 구현을 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // 인접한 노드들을 방문하면서 부모 정보를 저장
            for (int neighbor : tree.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parents[neighbor] = currentNode;
                    queue.add(neighbor);
                }
            }
        }
    }

}
