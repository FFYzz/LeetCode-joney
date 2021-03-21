/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/21
 * @Description:
 */
public class XOROperationinanArray {

    public int xorOperation(int n, int start) {
        int res = start, base = start;
        for (int i = 1; i < n; ++i) {
            base += 2;
            res = res ^ base;
        }
        return res;
    }

    public static void main(String[] args) {
        new XOROperationinanArray().xorOperation(5, 0);
    }
}
