package read_write_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.stream.IntStream;

/**
 * Created by a on 12/28/16.
 */
public class CheckReadInt {
    public static void main(String[] args) throws IOException {
        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};

        RandomAccessFile raf = new RandomAccessFile("storage2", "rw");
        raf.seek(4);
//        for (int i = 0; i < 4; i++) {
//            raf.writeInt(i);
//        }
//        raf.seek(0);
//        for (int i = 0; i < 27; i++) {
//            System.out.print(raf.readInt() + " ");
//        }
//        System.out.println(a1.length);
        System.out.println(raf.readInt());
    }
}
