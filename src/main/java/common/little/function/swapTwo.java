package common.little.function;
/**
 * @author shuwei
 * @version 创建时间：2017年9月28日 上午9:50:20
 * 类说明
 */
public class swapTwo {
    public static void swapTest() {
        int a = 1;
        int b = 2;
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("a:" + a + ", b:" + b);
    }
    public static void main(String[] args) {
        swapTest();
    }
}
