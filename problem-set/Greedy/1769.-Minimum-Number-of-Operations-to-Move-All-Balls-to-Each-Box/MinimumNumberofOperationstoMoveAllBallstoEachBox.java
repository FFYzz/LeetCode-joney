import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/4/5
 * @Description:
 */
public class MinimumNumberofOperationstoMoveAllBallstoEachBox {

    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); ++i) {
            int count = 0;
            for (int j = 0; j < boxes.length(); ++j) {
                if (i == j) {
                    continue;
                }
                if (boxes.charAt(j) != '0') {
                    count += Math.abs(i- j);
                }
            }
            res[i] = count;
        }
        return res;
    }

}
