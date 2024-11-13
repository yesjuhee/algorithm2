import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {
    private final static int A = 0;
    private final static int B = 1;
    private final static int C = 2;
    private final static int D = 3;
    private final static int E = 4;
    private final static int F = 5;

    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size(); // 노드 수
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE); // 무한대로 초기화
        distances[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0}); // {node, distance} 우선순위큐 초기화

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if (distance > distances[node]) {
                continue;
            }

            for (Edge edge : graph.get(node)) {
                int newDist = distances[node] + edge.weight;
                if (newDist < distances[edge.target]) {
                    distances[edge.target] = newDist;
                    pq.offer(new int[]{edge.target, newDist});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        // 노드 수
        int V = 6;

        // 간접리스트 형태로 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // 0:A, 1:B, 2:C, 3:D, 4:E, 5:F
        graph.get(A).add(new Edge(B, 3));
        graph.get(A).add(new Edge(C, 5));
        graph.get(A).add(new Edge(D, 9));
        graph.get(B).add(new Edge(A, 3));
        graph.get(B).add(new Edge(C, 3));
        graph.get(B).add(new Edge(D, 4));
        graph.get(B).add(new Edge(E, 7));
        graph.get(C).add(new Edge(A, 5));
        graph.get(C).add(new Edge(B, 3));
        graph.get(C).add(new Edge(D, 2));
        graph.get(C).add(new Edge(E, 6));
        graph.get(C).add(new Edge(F, 8));
        graph.get(D).add(new Edge(A, 9));
        graph.get(D).add(new Edge(B, 4));
        graph.get(D).add(new Edge(C, 2));
        graph.get(D).add(new Edge(E, 2));
        graph.get(D).add(new Edge(F, 2));
        graph.get(E).add(new Edge(B, 7));
        graph.get(E).add(new Edge(C, 6));
        graph.get(E).add(new Edge(D, 2));
        graph.get(E).add(new Edge(F, 5));
        graph.get(F).add(new Edge(C, 8));
        graph.get(F).add(new Edge(D, 2));
        graph.get(F).add(new Edge(E, 5));

        int source = A;
        int[] distances = dijkstra(graph, source);

        System.out.println("=== Shortest path from A ===");
        for (int i = 0; i < distances.length; i++) {
            System.out.printf("To node %c : %d%n", i + 'A', distances[i]);
        }
    }
}
