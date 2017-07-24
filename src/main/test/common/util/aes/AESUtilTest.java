package common.util.aes;

import java.security.InvalidKeyException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2017年6月23日 下午6:00:52 类说明
 */
public class AESUtilTest {
    @Test
    public void testEncryptAndDecryptOk() throws Exception {
        String key = "12345678abcdefgh";
        String content = "sadfs@!$#@#$%@`测试一下";
        byte[] afterEncode = AESUtil.getEncrypt(key, content.getBytes());
        byte[] afterDecode = AESUtil.getDecrypt(key, afterEncode);
        Assert.assertEquals(content, new String(afterDecode));
    }

    @Test(expected = InvalidKeyException.class)
    public void testEncryptAndDecryptBadKey() throws Exception{
        AESUtil.getEncrypt("1", "123".getBytes());
    }
}
