package chapter1.exercise;
/**
 * @author shuwei
 * @version 创建时间：2017年7月21日 下午4:16:29
 * 例题，根据公式求值
 * 感觉这应该是一个递归计算过程,只是值下降的比较快
 * 时间和空间复杂度没明白怎么求，网上说的是log(n)
 * 这个程序的写法，比较意味深长。。
 */
public class E1_15Radian {
    static int step = 0;
    private static double sineInner(double x) {
        System.out.println(++step);
        return 3 * x - 4 * x * x * x;
    }
    
    public static double sine(double angle) {
        if(Math.abs(angle) < 0.1) {
            return angle;
        } else {
            return sineInner(sine(angle / 3));
        }
    }
    public static void main(String[] args) {
        System.out.println(sine(200.15));
    }
}