package chapter1.exercise;
/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 上午10:36:04
 * 作业习题1.16
 * 这个是自己想出来的,通过具体的列子不断举例，找规律
 * 
 */
public class E1_16Exp {
    
    public static long exp(long a, int x) {
        if(x == 0) {
            return 1;
        }
        return expInner(a, 1, x);
    }
    
    private static long expInner(long a, long coefficient, int x) {
        if(x == 1) {
            return coefficient * a;
        }
        if(x % 2 == 0) {
            return expInner(a * a, coefficient, x / 2);
        } else {
            return expInner(a, a * coefficient, x - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(exp(2, 10));
        System.out.println(exp(3, 2));
        System.out.println(exp(5, 4));
        System.out.println(exp(3, 3));
    }
}
