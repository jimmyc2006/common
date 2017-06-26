package common.util.array;

import java.nio.ByteBuffer;

/**
 * @author shuwei
 * @version 创建时间：2017年5月22日 下午5:56:26
 * 类说明
 */
public class ByteArrayUtil {
    public static final byte[] intTo4ByteArray(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static final byte[] intTo2ByteArray(int value) {
        int s1 = (value & 0xFF00) >> 8;
        int s2 = value & 0xFF;
        return new byte[] {(byte) s1, (byte) s2};
    }
    
    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(0, x);  
        return buffer.array();  
    }
}
