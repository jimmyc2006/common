package chapter1.exercise;
/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 上午11:59:12
 * 习题1.17假设没有乘法的情况下求乘法
 * 
 */
public class E1_17Exp {
    public static long multiple(long a, long b) {
        return multipleInner(a, b);
    }
    
    private static long multipleInner(long a, long b) {
        if(b == 1) {
            return a;
        }
        return a + multipleInner(a, b - 1);
    }
    
    private static long doubleMultiple(long a) {
        return a + a;
    }
    
    private static long halve(long a) {
        return a / 2;
    }
    
    public static long fastMultiple(long a, long b) {
        if(b == 1) {
            return a;
        }
        if(b % 2 == 0) {
            return doubleMultiple(fastMultiple(a, halve(b)));
        } else {
            return a + fastMultiple(a, b - 1);
        }
    }
    
    /**
     * 这个是模仿之前那个求幂的fast方法做的
     * @param a
     * @param b
     * @return
     */
    public static long fastMultipleIterator(long a, long b) {
        return fmiInner(a, 0, b);
    }
    
    private static long fmiInner(long a, long append, long b) {
        if(b == 1) {
            return a + append;
        }
        if(b % 2 == 0) {
            return fmiInner(doubleMultiple(a), append, halve(b));
        } else {
            return fmiInner(a, a + append, b - 1);
        }
    }
}