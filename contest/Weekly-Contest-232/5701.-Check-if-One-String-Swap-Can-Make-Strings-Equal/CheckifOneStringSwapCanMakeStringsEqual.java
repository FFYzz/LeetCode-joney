/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/14
 * @Description:
 */
public class CheckifOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean diff = false;
        char c1 = '0';
        char c2 = '0';
        int diffCount = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diffCount;
                if (diffCount > 2) {
                    return false;
                }
                if (!diff) {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                    diff = true;
                } else {
                    if (c1 != s2.charAt(i) || c2 != s1.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return diffCount == 0 || diffCount == 2;
    }

}
