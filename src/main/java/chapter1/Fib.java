package chapter1;
/**
 * @author shuwei
 * @version 创建时间：2017年7月20日 下午8:44:18
 * 斐波那契的递归算法:fibRecursion
 * 时间复杂度是1.618的n次方
 * 空间复杂度是n
 * 斐波那契的迭代算法:fibIteration
 * 时间复杂度是n
 * 空间复杂度是n
 */
public class Fib {
    public static int fibRecursion(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }
    
    public static int fibIteration(int n) {
        assert n >= 0;
        return innerFibIteration(1, 0, n);
    }
    
    private static int innerFibIteration(int a, int b, int count) {
        if(count == 0) {
            return b;
        } else {
            return innerFibIteration(a + b, a, --count);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(fibRecursion(10));
        System.out.println(fibRecursion(15));
    }
}
