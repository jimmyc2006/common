package common.util.collection;

import java.util.Set;

/**
 * @author shuwei
 * @version 创建时间：2017年4月10日 下午4:54:58
 * 类说明
 */
public class CollectionUtil {
    /**
     * 使用泛型的没搞定
     * @param source
     * @return
     */
    public static Long[] Set2Array(Set<Long> source) {
        Long[] result = source.toArray(new Long[]{});
        return result;
    }
}