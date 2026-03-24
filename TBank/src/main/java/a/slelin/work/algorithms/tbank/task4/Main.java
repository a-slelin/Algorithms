package a.slelin.work.algorithms.tbank.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            @SuppressWarnings("unchecked")
            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(reader.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj[u].add(v);
                adj[v].add(u);
            }

            int result = solve(n, m, adj);

            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int solve(int n, @SuppressWarnings("unused") int m, List<Integer>[] adj) {
        int minCycle = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new ArrayDeque<>();

            dist[i] = 0;
            queue.add(i);

            bfs:
            while (!queue.isEmpty()) {
                int u = queue.poll();

                if (minCycle != Integer.MAX_VALUE && dist[u] * 2 + 1 >= minCycle) {
                    break;
                }

                for (int v : adj[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        queue.add(v);
                    } else if (v != parent[u]) {
                        minCycle = Math.min(minCycle, dist[u] + dist[v] + 1);
                        if (minCycle == 3) break bfs;
                    }
                }
            }
            if (minCycle == 3) break;
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}