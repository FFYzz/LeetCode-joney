import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/17
 * @Description:
 */
public class NumberofOperationstoMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        int res = 0;
        if (connections.length < n - 1) {
            return -1;
        }
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.length; ++i) {
            graph[connections[i][0]].add(connections[i][1]);
            graph[connections[i][1]].add(connections[i][0]);
        }
        for (int i = 0; i < n; ++i) {
            res += dfs(i, visited, graph);
        }
        return res - 1;
    }

    private int dfs(int index, boolean[] visited, List<Integer>[] list) {
        if (visited[index]) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int e : list[x]) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.offer(e);
                }
            }
        }
        return 1;
    }

}
