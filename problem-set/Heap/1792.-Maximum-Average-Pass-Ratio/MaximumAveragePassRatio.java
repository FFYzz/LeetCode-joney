import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/15
 * @Description:
 */
public class MaximumAveragePassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(x -> -x[0]));
        for (int[] c : classes) {
            maxHeap.offer(new double[]{profile(c[0], c[1]), c[0], c[1]});
        }
        while (extraStudents-- > 0) {
            double[] curr = maxHeap.poll();
            double a = curr[1] + 1;
            double b = curr[2] + 1;
            maxHeap.offer(new double[]{profile(a, b), a, b});
        }
        double res = 0;
        while (!maxHeap.isEmpty()) {
            double[] curr = maxHeap.poll();
            res += (curr[1] / curr[2]);
        }
        return res / classes.length;
    }

    public double profile(double x, double y) {
        return (x + 1) / (y + 1) - (x / y);
    }

}
