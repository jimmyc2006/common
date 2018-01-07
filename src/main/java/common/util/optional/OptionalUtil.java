package common.util.optional;

import java.util.Optional;

/**
 * @author shuwei
 * @version 创建时间：2017年9月26日 上午9:19:27
 * 类说明
 */
public class OptionalUtil {
    // from java8 in action p217
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
