package chapter1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author shuwei
 * @version 创建时间：2017年7月23日 下午3:53:18
 * 类说明
 */
public class GcdTest {
    
    @Test
    public void testGcd() {
        assertEquals(1, Gcd.gcd(2, 3));
        assertEquals(2, Gcd.gcd(2, 4));
        assertEquals(2, Gcd.gcd(4, 6));
        assertEquals(1, Gcd.gcd(3, 17));
        assertEquals(10, Gcd.gcd(20, 30));
        assertEquals(5, Gcd.gcd(15, 355));
        assertEquals(2, Gcd.gcd(206, 40));
    }
}
