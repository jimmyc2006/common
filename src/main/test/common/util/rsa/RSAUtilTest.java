package common.util.rsa;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

/**
 * @author shuwei
 * @version 创建时间：2017年6月25日 下午3:53:28
 * 类说明
 */
public class RSAUtilTest {
    private static String privateKeyFileName = "private_key";
    private static String publicKeyFileName = "public_key";
    private static int keySize = 1024;
    private String defaultCharset = "utf-8";
    
    String content = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十";
    byte[] contentBytes = null;
    RSAPublicKey publicKey = null;
    RSAPrivateKey privateKey = null;
    
    @BeforeClass
    public static void generateKeyFile() throws NoSuchAlgorithmException, IOException {
        RSAUtil.generateKeyFile(privateKeyFileName, publicKeyFileName, keySize);
    }
    
    @Before
    public void generateContentBytes() throws ClassNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException, Base64DecodingException {
        this.contentBytes = content.getBytes(defaultCharset);
        publicKey = RSAUtil.getRSAPublicKey(publicKeyFileName);
        privateKey = RSAUtil.getRSAPrivateKey(privateKeyFileName);
    }
    
    @Test
    public void publicKey2PrivateKey() throws ClassNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] afterEncode = RSAUtil.encrypt(publicKey, contentBytes);
        byte[] afterDecode = RSAUtil.decrypt(privateKey, afterEncode);
        Assert.assertEquals(content, new String(afterDecode, defaultCharset));
    }
    
    @Test
    public void privateKey2PublicKey() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] afterPrivateKeyEncode = RSAUtil.encrypt(privateKey, contentBytes);
        byte[] afterPubicKeyDecoder = RSAUtil.decrypt(publicKey, afterPrivateKeyEncode);
        Assert.assertEquals(content, new String(afterPubicKeyDecoder, defaultCharset));
    }
    
    @Test
    public void publicKey2PublicKey() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] afterPrivateKeyEncode = RSAUtil.encrypt(publicKey, contentBytes);
        boolean isException = false;
        try{
            RSAUtil.decrypt(publicKey, afterPrivateKeyEncode);
        } catch (Exception e) {
            isException = true;
        }
        Assert.assertTrue(isException);
    }
    
    @Test
    public void publicPrivate2PrivateKey() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] afterPrivateKeyEncode = RSAUtil.encrypt(privateKey, contentBytes);
        boolean isException = false;
        try{
            RSAUtil.decrypt(privateKey, afterPrivateKeyEncode);
        } catch (Exception e) {
            isException = true;
        }
        Assert.assertTrue(isException);
    }
    
}