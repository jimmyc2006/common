package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午9:02:34
 * 类说明
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;
    
    public SoldOutState(GumballMachine gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("sold out... you can't inset quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("no had quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("no had quarter");
    }

    @Override
    public void dispense() {
        System.out.println("no ball");
    }
}
