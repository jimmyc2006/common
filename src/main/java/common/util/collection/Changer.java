package common.util.collection;
/**
 * @author shuwei
 * @version 创建时间：2017年7月9日 下午4:18:31
 * 类说明
 */
public interface Changer<X, Y> {
    public Y change(X x);
}
