package common.generic.coffee;
/**
 * @author shuwei
 * @version 创建时间：2017年12月15日 上午9:49:44
 * 类说明
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
