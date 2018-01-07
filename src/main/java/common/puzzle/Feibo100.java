package common.puzzle;

import java.math.BigInteger;

/**
 * @author shuwei
 * @version 创建时间：2017年12月19日 下午4:04:56
 * 计算斐波的第100项
 */
public class Feibo100 {
    public static BigInteger feibo(int number) {
        BigInteger tmp = BigInteger.valueOf(0);
        BigInteger b1 = BigInteger.valueOf(1);
        BigInteger b2 = BigInteger.valueOf(1);
        if(number == 1) {
            return b1;
        }
        for(int i = 2; i < number; i++) {
            tmp = b2;
            b2 = b1.add(b2);
            b1 = tmp;
        }
        return b2;
    }
    public static void main(String[] args) {
        System.out.println(feibo(100));
    }
}
