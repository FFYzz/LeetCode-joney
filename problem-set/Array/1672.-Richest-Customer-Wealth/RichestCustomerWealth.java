import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/23
 * @Description:
 */
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(x -> Arrays.stream(x).sum()).max().getAsInt();
    }

}
