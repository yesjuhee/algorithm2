import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public final static int GRAPH_LIST_SIZE = 10;
    public final static int TARGET = 9;
    public static boolean[] visitedD = new boolean[GRAPH_LIST_SIZE + 1];
    public static boolean[] visitedB = new boolean[GRAPH_LIST_SIZE + 1];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        for (int i = 0; i < GRAPH_LIST_SIZE + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1 : 2, 4, 5
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(1).add(5);
        // 노드 2 : 1, 3
        graph.get(2).add(1);
        graph.get(2).add(3);
        // 노드 3 : 2, 4
        graph.get(3).add(2);
        graph.get(3).add(4);
        // 노드 4 : 1, 3
        graph.get(4).add(1);
        graph.get(4).add(3);
        // 노드 5 : 1, 6
        graph.get(5).add(1);
        graph.get(5).add(6);
        // 노드 6 : 5, 7, 9
        graph.get(6).add(5);
        graph.get(6).add(7);
        graph.get(6).add(9);
        // 노드 7 : 6, 8
        graph.get(7).add(6);
        graph.get(7).add(8);
        // 노드 8 : 7, 9
        graph.get(8).add(7);
        graph.get(8).add(9);
        // 노드 9 : 6, 8, 10
        graph.get(9).add(6);
        graph.get(9).add(8);
        graph.get(9).add(10);
        // 노드 10 : 9
        graph.get(10).add(9);

        System.out.println("DFS");
        dfs(1);
        System.out.println("BFS");
        bfs(1);
    }

    public static void dfs(int node) {
        if (node == TARGET) {
            System.out.print(node + "\n");
            return;
        }
        visitedD[node] = true;
        System.out.print(node + " ");

        for(Integer neighbor : graph.get(node)) {
            if (!visitedD[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(node);
        visitedB[node] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            if (current == TARGET) {
                return;
            }

            for(Integer neighbor : graph.get(current)) {
                if (!visitedB[neighbor]) {
                    queue.offer(neighbor);
                    visitedB[neighbor] = true;
                }
            }
        }
    }
}