package chapter1.exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chapter1.Fib;

/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午3:47:00
 * 类说明
 */
public class E1_19FastFibTest {
    @Test
    public void testfastFib() {
        assertEquals(0, E1_19FastFib.fastFib(0));
        assertEquals(55, E1_19FastFib.fastFib(10));
        assertEquals(1, E1_19FastFib.fastFib(1));
        assertEquals(1, E1_19FastFib.fastFib(2));
        assertEquals(610, E1_19FastFib.fastFib(15));
    }
}
