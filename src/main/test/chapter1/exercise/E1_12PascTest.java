package chapter1.exercise;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author shuwei
 * @version 创建时间：2017年7月21日 上午10:25:39
 * 类说明
 */
public class E1_12PascTest {
    
    @Test
    public void testPasc() {
        assertEquals(3, E1_12Pasc.pasc(4, 3));
        assertEquals(10, E1_12Pasc.pasc(6, 3));
    }
}
