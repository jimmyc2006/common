package chapter1;

import java.util.Random;

/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午4:56:59
 * 1.2.6素数
 */
public class Prime {
    public static boolean isPrime(int n) {
        return n == smallestDivisor(n);
    }
    
    private static int smallestDivisor(int n) {
        return findDivisor(n, 2);
    }
    
    private static int findDivisor(int n, int testDivisor) {
        if(testDivisor * testDivisor > n) {
            return n;
        }
        if(n % testDivisor == 0) {
            return testDivisor;
        } else {
            return findDivisor(n, ++testDivisor);
        }
    }
    
    // --------------------按照书上的思路来-----------------------
    public static boolean isPrimeBook(int n) {
        return fastPrime(n, 10);
    }
    
    public static boolean fastPrime(int n, int times) {
        if(times == 0) {
            return true;
        }
        if(fermatTest(n)) {
            return fastPrime(n, times - 1);
        }
        return false;
    }
    
    private static boolean fermatTest(int n) {
        return tryIt(random(n), n);
    }
    
    private static boolean tryIt(int a, int n) {
        return expmod(a, n, n) == a;
    }
    
    /**
     * 这个算法比较神奇，在求余的时候，进行了分布计算，避免了数据越界
     * 这里使用了分配率
     */
    private static int expmod(int base, int exp, int m) {
        if(exp == 0) {
            return 1;
        }
        if(exp %2 ==0) {
            int res = square(expmod(base, exp / 2, m));
            // System.out.println("60:::" + exp + "::::" + res + ":" + m);
            return res % m;
        } else {
            int res = base * expmod(base, (exp -1), m);
            // System.out.println("64:::" + exp + "::::" + res + ":" + m);
            return res % m;
        }
    }
    
    private static int square(int a) {
        return a * a;
    }
    
    // ------------------------下面这个自己写的--------------------------
    public static boolean isPrimeFermat(int n) {
        return isPrimeFermatInner(n, 10);
    }
    
    private static boolean isPrimeFermatInner(int n, int checkTimes) {
        for(int i = 0; i < checkTimes; i++) {
            if(!check(random(n), n)) {
                return false;
            }
        }
        return true;
    }
    
    protected static boolean check(int a, int n) {
        return a == powerAndMod(a, n, n);
    }
    /**
     * 求base的emp次方对m求模
     * 如果不使用求模公式，会造成数据的越界
     * (a * b) mod c = ((a mod c) * (b mod c)) mod c
     * 分配率和递归的结合，让计算的数量级降下来，才能避免数据越界
     */
    private static int powerAndMod(int base, int emp, int m) {
        assert base < m;
        if(emp == 1) {
            return base;
        }
        return (base * (powerAndMod(base, emp - 1, m))) % m;
    }
    
    private static int random(int max) {
        Random rand = new Random();
        int res = rand.nextInt(max);
        return res;
    }
    public static void main(String[] args) {
        
    }
}