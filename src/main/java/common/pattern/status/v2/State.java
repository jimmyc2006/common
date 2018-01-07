package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午9:00:23
 * 类说明
 */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
