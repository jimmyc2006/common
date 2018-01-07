package common.pattern.status.v1;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午8:36:50
 * 这种设计，如果增加一个赢家的状态，需要改所有相应的操作方法,需要使用新的设计，见v2
 */
public class GumballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;
    
    int state = SOLD_OUT;
    int count = 0;
    
    public GumballMachine(int count) {
        this.count = count;
        if(count > 0) {
            state = NO_QUARTER;
        }
    }
    
    public void insertQuarter() {
        if(state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if(state == SOLD_OUT) {
            System.out.println("You can't insert a quarter, the machine is sold out");
        } else if(state == SOLD) {
            System.out.println("Please wait, we're already gibing you gumball");
        } else if(state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        }
    }
    
    public void ejectQuarter() {
        if(state == HAS_QUARTER) {
            System.out.println("Quartetr returned");
            state = NO_QUARTER;
        } else if(state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if(state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
        } else if(state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a qurted yet");
        }
    }
    
    public void turnCrank() {
        if(state == SOLD) {
            System.out.println("Turing twice doesn't get you another gumball!");
        } else if(state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        } else if(state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
        } else if(state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }
    
    public void dispense() {
        if(state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if(count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if(state == NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if(state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if(state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }
}
