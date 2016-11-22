package h;

import java.nio.ByteBuffer;

/**
 * Created by a on 22.11.16.
 */
public class H {
    public static void main(String[] args) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(1695609641).array();

        for (byte b : bytes) {
            System.out.format("0x%x ", b);
        }

        int i = 5 ^ 2;
        System.out.println(i);
    }
}
