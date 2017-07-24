package chapter1.exercise;
/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午3:33:17
 * p31页习题1.19
 */
public class E1_19FastFib {
    public static long fastFib(int n) {
        return fbInner(1, 0, 0, 1, n);
    }
    
    private static long fbInner(long a, long b, long p, long q, int count) {
        if(count == 0) {
            return b;
        }
        if(count % 2 == 0) {
            return fbInner(a, b, p * p + q * q, 2 * p * q + q * q, count / 2);
        } else {
            return fbInner(b * q + a * q + a * p, b * p + a * q, p, q, --count);
        }
    }
}
