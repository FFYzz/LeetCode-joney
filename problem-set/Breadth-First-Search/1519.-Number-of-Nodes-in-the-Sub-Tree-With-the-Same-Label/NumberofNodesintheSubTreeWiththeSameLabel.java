import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/20
 * @Description:
 */
public class NumberofNodesintheSubTreeWiththeSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], f -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], f -> new ArrayList<>()).add(e[0]);
        }
        dfs(map, 0, visited, labels, res);
        return res;
    }

    public int[] dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, String label, int[] res) {
        int[] ans = new int[26];
        // 还未遍历过
        if (visited.add(node)) {
            char c = label.charAt(node);
            List<Integer> curr = graph.getOrDefault(node, Collections.emptyList());
            for (int child : curr) {
                int[] count = dfs(graph, child, visited, label, res);
                for (int i = 0; i < 26; i++) {
                    ans[i] += count[i];
                }
            }
            ++ans[c - 'a'];
            res[node] = ans[c - 'a'];
        }
        return ans;
    }

    // 4
    // [[0,2],[0,3],[1,2]]
    // "aeed"
    // output [1,2,1,1]
    // expected [1,1,2,1]

}
