package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午9:01:29
 * 类说明
 */
public class SoldState implements State{
    GumballMachine gumballMachine;
    
    public SoldState(GumballMachine gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("is solding");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("is solding");
    }

    @Override
    public void turnCrank() {
        System.out.println("is solding");
    }

    @Override
    public void dispense() {
        // 数量减1
        this.gumballMachine.realeaseBall();
        if(this.gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("no have gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
    
}
