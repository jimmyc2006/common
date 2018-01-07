package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 上午8:59:42
 * 类说明
 */
public class GumballMachine {
    
    State soldOutState;
    State noQuarterState;
    State hadQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;
    
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hadQuarterState = new HadQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if(numberGumballs > 0) {
            this.state = this.noQuarterState;
        }
    }
    
    public void insertQuarter() {
        this.state.insertQuarter();
    }
    
    public void turnCrank(){
        this.state.turnCrank();
        this.state.dispense();
    }
    
    public void ejectQuarter() {
        this.state.ejectQuarter();
    }
    
    void realeaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if(count != 0) {
            count = count - 1;
        }
    }
    

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHadQuarterState() {
        return hadQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GumballMachine [state=" + state + ", count=" + count + "]";
    }
    
    public void refill(int count) {
        this.count = this.count + count;
        if(this.state == this.getSoldOutState()) {
            this.state = this.getNoQuarterState();
        }
    }
}
