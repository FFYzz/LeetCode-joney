import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/16
 * @Description:
 */
public class MapofHighestPeak {

    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length, columns = isWater[0].length;
        int[][] res = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                } else {
                    // 未赋值标志
                    res[i][j] = -1;
                }
            }
        }
        int[] dir = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + dir[i], nc = c + dir[i + 1];
                if (nr < 0 || nr == rows || nc < 0 || nc == columns || res[nr][nc] != -1) {
                    continue;
                }
                res[nr][nc] = res[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
        return res;
    }

}
