package common.util.collection;

import java.util.HashSet;
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
    
    /**
     * 将Set<X>类型转化为Set<Y>类型
     * @param src
     * @param changer
     * @return
     */
    public static <X, Y> Set<Y> set2set (Set<X> src, Changer<X, Y> changer) {
        Set<Y> result = new HashSet<>(src.size());
        for(X x : src) {
            Y y = changer.change(x);
            result.add(y);
        }
        return result;
    }
}