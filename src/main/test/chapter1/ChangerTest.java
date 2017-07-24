package chapter1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author shuwei
 * @version 创建时间：2017年7月20日 下午8:53:12
 * 类说明
 */
public class ChangerTest {
    @Test
    public void testChange() {
        assertEquals(4, Changer.change(11));
        assertEquals(292, Changer.change(100));
    }
}
