package chapter1.exercise;

/**
 * @author shuwei
 * @version 创建时间：2017年7月20日 下午9:18:33 练习题1.11
 * 
 */
public class E1_11 {
    
    public static long calculateRecursion(long n) {
        if (n < 3) {
            return n;
        } else {
            return calculateRecursion(n - 1) + 2 * calculateRecursion(n - 2) + 3 * calculateRecursion(n - 3);
        }
    }
    
    public static long calculateIteration(int n) {
        assert n > 0;
        return iterationInner(0, 1, 2, n);
    }
    
    private static long iterationInner(long a, long b, long c, int count) {
        if(count ==0) {
            return a;
        } else if(count == 1) {
            return b;
        } else if(count == 2) {
            return c;
        }
        return iterationInner(b, c, c + 2 * b + 3 * a, --count);
    }
    
    public static void main(String[] args) {
        int n = 38;
        long start = System.currentTimeMillis();
        long result1 = calculateRecursion(n);
        System.out.println("n=" + n + "时,递归算法耗时:" + (System.currentTimeMillis() - start) + "计算结果:" + result1);
        start = System.currentTimeMillis();
        long result2 = calculateIteration(n);
        System.out.println("n=" + n + "时,迭代算法耗时:" + (System.currentTimeMillis() - start) + "计算结果:" + result2);
    }
}