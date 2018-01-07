package common.pattern.status.v2;
/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 下午2:28:19
 * 类说明
 */
public class GumballMachineTestDeive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);
        
        insertAndTurn(gumballMachine, 5);
    }
    public static void insertAndTurn(GumballMachine gm, int times) {
        for(int i = 0; i < times; i++) {
            gm.insertQuarter();
            gm.turnCrank();
            System.out.println(gm);
        }
    }
}
