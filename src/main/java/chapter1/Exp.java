package chapter1;
/**
 * @author shuwei
 * @version 创建时间：2017年7月21日 下午4:52:48
 * 1.2.4求幂
 * 本类包含1个递归求幂，2个迭代求幂
 */
public class Exp {
    
    // 递归求幂
    // 时间复杂度是n
    // 空间复杂度是n
    public static long ExpRecursion(long a, int x) {
        if(x == 0) {
            return 1;
        }
        if(x == 1) {
            return a;
        }
        return a * ExpRecursion(a, x - 1);
    }
    
    // 普通java写法迭代求幂
    // 时间复杂度n
    // 空间复杂度1
    public static long ExpIteration(int a, int x) {
        assert x >= 0;
        long sum = 1;
        for(int i = 0; i < x; i++) {
            sum = sum * a;
        }
        return sum;
    }

    // 这个是书上的例子
    // 时间复杂度是n
    // 空间复杂度是1
    public static long ExpIteration2(long a, int x) {
        return expInner(a, 1, x);
    }
    private static long expInner(long a, long sum, int x) {
        if(x == 0) {
            return sum;
        }
        return expInner(a, sum * a, --x);
    }
    
    // 这个问题没有考虑清楚,按照书上的说明把代码写出来
    // 这个代码的时间复杂度应该logn
    // 空间复杂度也是对数
    public static long expHP(long a, int x) {
        return expHPInner(a, x);
    }
    private static long expHPInner(long a, int x) {
        if(x == 0) {
            return 1;
        }
        if(x == 1) {
            return a;
        }
        if(x % 2 == 0) {
            return expHPInner(a, x / 2) * expHPInner(a, x / 2);
        } else {
            return a * expHPInner(a, x - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ExpRecursion(2, 9));
        System.out.println(ExpRecursion(10, 4));
        System.out.println("------------------");
        System.out.println(ExpIteration(2, 9));
        System.out.println(ExpIteration(10, 4));
        System.out.println("------------------");
        System.out.println(ExpIteration2(2, 9));
        System.out.println(ExpIteration2(10, 4));
        System.out.println("------------------");
        System.out.println(expHP(2, 9));
        System.out.println(expHP(10, 4));
    }
}
