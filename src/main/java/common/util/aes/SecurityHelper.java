package common.util.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecurityHelper {
    public static byte[] getEncrypt(String keyStr, byte[] bytes) {
        byte[] encrypted = null;
        try {
            SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), "AES");
            Cipher enCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            enCipher.init(Cipher.ENCRYPT_MODE, key);
            encrypted = enCipher.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    public static byte[] getDecrypt(String keyStr, byte[] bytes) {
        byte[] dncrypted = null;
        try {
            SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), "AES");
            Cipher deCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            deCipher.init(Cipher.DECRYPT_MODE, key);
            dncrypted = deCipher.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dncrypted;
    }
    
    public static void test(String testKey, String content) {
        System.out.println("测试数据:" + content);
        byte[] contentBytes = content.getBytes();
        System.out.println("加密前的长度:" + contentBytes.length);
        byte[] securtyBytes = getEncrypt(testKey, contentBytes);
        System.out.println("加密后的长度:" + securtyBytes.length);
        System.out.println("解密后的数据:" + new String(getDecrypt(testKey, securtyBytes)));
    }

    public static void main(String[] args) {
        test("abcdefghabcdefgh", "这是一条聊天信息，说不同的字压缩效果可能会差一些，所以我写了这个来测试一下。");
        test("1234567812345678", "这是一条聊天信息，说不同的字压缩效果可能会差一些，所以我写了这个来测试一下。");
        test("abcdabcdabcdabcd", "你好!");
        test("abcdabcdabcdabcd", "哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈啊哈哈哈哈哈");
    }
}