package common.util.parameter;
/**
 * @author shuwei
 * @version 创建时间：2017年6月2日 下午8:02:03
 * 类说明
 */
public class ParamUtil {
    /**
     * @param defaultValue 默认值
     * @param arr   字符数组
     * @param index 数组下标
     * 不直接传字符串的原因是将ArrayIndexOutOfBoundsException也封装进来
     * @return
     */
    public static int parseInt(int defaultValue, String[] arr, int index) {
        try {
            defaultValue = Integer.parseInt(arr[index]);
        } catch(Exception e) {
        }
        return defaultValue;
    }
}