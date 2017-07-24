package chapter1.exercise;
/**
 * @author shuwei
 * @version 创建时间：2017年7月21日 上午10:07:46
 * 帕斯卡三角的求法,sicp第二版习题1.12
 */
public class E1_12Pasc {
    public static int pasc(int row, int column) {
        assert column <= row;
        if(column == 1 || row == 1) {
            return 1;
        }
        if(column == row) {
            return 1;
        }
        // 3,2 = 2,1 + 2,2; 4,3 = 3,2 + 3,3
        return pasc(row - 1, column - 1) + pasc(row - 1, column);
    }
}
