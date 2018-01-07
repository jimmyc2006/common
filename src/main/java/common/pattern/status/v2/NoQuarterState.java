package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午9:03:06
 * 类说明
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;
    
    public NoQuarterState(GumballMachine gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHadQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }
    
    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

}
