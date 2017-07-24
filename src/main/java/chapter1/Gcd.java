package chapter1;
/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午3:50:10
 * 最大公约数
 */
public class Gcd {
    /**
     * 欧几里得算法
     * 时间复杂对数
     */
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
