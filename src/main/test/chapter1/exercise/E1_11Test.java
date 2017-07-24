package chapter1.exercise;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2017年7月20日 下午9:36:06
 * 类说明
 */
public class E1_11Test {
    
    @Test
    public void test1() {
        assertEquals(0, E1_11.calculateRecursion(0));
        assertEquals(1, E1_11.calculateRecursion(1));
        assertEquals(2, E1_11.calculateRecursion(2));
        assertEquals(4, E1_11.calculateRecursion(3));
        assertEquals(1892, E1_11.calculateRecursion(10));
        assertEquals(10661, E1_11.calculateRecursion(12));
        
        assertEquals(0, E1_11.calculateIteration(0));
        assertEquals(1, E1_11.calculateIteration(1));
        assertEquals(2, E1_11.calculateIteration(2));
        assertEquals(4, E1_11.calculateIteration(3));
        assertEquals(1892, E1_11.calculateIteration(10));
        assertEquals(10661, E1_11.calculateIteration(12));
    }
}
