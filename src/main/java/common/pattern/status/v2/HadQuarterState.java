package common.pattern.status.v2;

import java.util.Random;

/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午9:03:30
 * 类说明
 */
public class HadQuarterState implements State {
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;
    
    public HadQuarterState(GumballMachine gumballMachine) {
        super();
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("eject success");
        this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        int num = this.randomWinner.nextInt(10);
        System.out.println("You turned...");
        if(num == 0 && gumballMachine.getCount() > 1) {
            this.gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            this.gumballMachine.setState(this.gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

}
