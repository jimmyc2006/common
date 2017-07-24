package chapter1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2017年7月20日 下午8:49:40 类说明
 */
public class FibTest {

    @Test
    public void testFibRecursion() {
        assertEquals(0, Fib.fibRecursion(0));
        assertEquals(55, Fib.fibRecursion(10));
        assertEquals(1, Fib.fibRecursion(1));
        assertEquals(1, Fib.fibRecursion(2));
        assertEquals(610, Fib.fibRecursion(15));
    }

    @Test
    public void testFibIteration() {
        assertEquals(0, Fib.fibIteration(0));
        assertEquals(55, Fib.fibIteration(10));
        assertEquals(1, Fib.fibIteration(1));
        assertEquals(1, Fib.fibIteration(2));
        assertEquals(610, Fib.fibIteration(15));
    }
}
