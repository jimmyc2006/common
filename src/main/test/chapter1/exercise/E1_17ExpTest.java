package chapter1.exercise;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午1:47:55
 * 类说明
 */
public class E1_17ExpTest {
    @Test
    public void testMultiple() {
        assertEquals(12, E1_17Exp.multiple(3, 4));
        assertEquals(1, E1_17Exp.multiple(1, 1));
        assertEquals(4, E1_17Exp.multiple(1, 4));
        assertEquals(45, E1_17Exp.multiple(5, 9));
        assertEquals(28, E1_17Exp.multiple(7, 4));
        assertEquals(64, E1_17Exp.multiple(8, 8));
        assertEquals(625, E1_17Exp.multiple(25, 25));
    }
    
    @Test
    public void testFastMultiple() {
        assertEquals(12, E1_17Exp.fastMultiple(3, 4));
        assertEquals(1, E1_17Exp.fastMultiple(1, 1));
        assertEquals(4, E1_17Exp.fastMultiple(1, 4));
        assertEquals(45, E1_17Exp.fastMultiple(5, 9));
        assertEquals(28, E1_17Exp.fastMultiple(7, 4));
        assertEquals(64, E1_17Exp.fastMultiple(8, 8));
        assertEquals(625, E1_17Exp.fastMultiple(25, 25));
    }
    
    @Test
    public void testFastMultipleIterator() {
        assertEquals(12, E1_17Exp.fastMultipleIterator(3, 4));
        assertEquals(1, E1_17Exp.fastMultipleIterator(1, 1));
        assertEquals(4, E1_17Exp.fastMultipleIterator(1, 4));
        assertEquals(45, E1_17Exp.fastMultipleIterator(5, 9));
        assertEquals(28, E1_17Exp.fastMultipleIterator(7, 4));
        assertEquals(64, E1_17Exp.fastMultipleIterator(8, 8));
        assertEquals(625, E1_17Exp.fastMultipleIterator(25, 25));
    }
}
