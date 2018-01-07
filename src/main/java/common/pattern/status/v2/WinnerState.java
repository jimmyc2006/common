package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 下午1:59:37
 * 类说明
 */
public class WinnerState implements State {
    private GumballMachine gumballMachine;
    
    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("winner state");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("winner state");
    }

    @Override
    public void turnCrank() {
        System.out.println("winner state");
    }

    @Override
    public void dispense() {
        this.gumballMachine.realeaseBall();
        System.out.println("you are winner");
        this.gumballMachine.realeaseBall();
        if(gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
