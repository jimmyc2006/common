package common.util.aes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @author shuwei
 * @version 创建时间：2017年6月27日 下午9:59:41 产生随机aeskey
 */
public class AESUtil {
    private static String getKey(int bits) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(bits);// 要生成多少位，只需要修改这里即可128, 192或256
            SecretKey sk = kg.generateKey();
            byte[] b = sk.getEncoded();
            return Base64.encode(b);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAesKey() {
        return getKey(128);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getKey(128));
        }
    }

    // 使用指定的aeskey和默认字符集加密字节数组
    public static byte[] getEncrypt(String keyStr, byte[] bytes) throws Exception {
        return getEncrypt(keyStr.getBytes(), bytes);
    }

    // 使用keyBytes对bytes进行加密
    public static byte[] getEncrypt(byte[] keyBytes, byte[] bytes) throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher enCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        enCipher.init(Cipher.ENCRYPT_MODE, key);
        return enCipher.doFinal(bytes);
    }

    // 使用指定mode和base64以后的key生成Cipher
    // 加密或者解密频率比较高的时候可以提升性能
    public static Cipher getCipherFromBase64Key(int mode, String base64Key) throws Base64DecodingException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        byte[] keyBytes = Base64.decode(base64Key);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher enCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        enCipher.init(mode, key);
        return enCipher;
    }

    // 使用base64的key加密指定字节数组
    public static byte[] getEncryptBase64Key(String base64Key, byte[] bytes) throws Exception {
        byte[] key = Base64.decode(base64Key);
        return getEncrypt(key, bytes);
    }

    // 使用默认字符集解密bytes
    public static byte[] getDecrypt(String keyStr, byte[] bytes) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return getDecrypt(keyStr.getBytes(), bytes);
    }

    // 使用base64以后的key来解密bytes
    public static byte[] getDecryptBase64Key(String base64Key, byte[] bytes) throws Base64DecodingException,
            InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {
        return getDecrypt(Base64.decode(base64Key), bytes);
    }

    // 使用指定key来解密bytes
    public static byte[] getDecrypt(byte[] keyBytes, byte[] bytes) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher deCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key);
        return deCipher.doFinal(bytes);
    }
}
