package chapter1;
/**
 * @author shuwei
 * @version 创建时间：2017年7月20日 下午5:57:21
 * 找零钱算法
 * 时间复杂度应该小于斐波那契，量级也差不多，一个常数的n次方;
 * 空间复杂度应该是n
 * 
 */
public class Changer {
    private static final int[] CHANGE = new int[]{1, 5, 10, 25, 50};
    
    public static int change(int amount) {
        return innerChange(amount, 5);
    }
    
    private static int innerChange(int sum, int n) {
        if(sum < 0) {
            return 0;
        }
        if(sum == 0) {
            return 1;
        }
        if(n < 1) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return innerChange(sum, n - 1) + innerChange(sum - CHANGE[ n -1], n);
    }
    
    public static void main(String[] args) {
        System.out.println(innerChange(100, 5));
    }
}
