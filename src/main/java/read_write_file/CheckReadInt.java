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
        RandomAccessFile raf = new RandomAccessFile("storage", "rw");
//        raf.seek(0);
//        for (int i = 0; i < 4; i++) {
//            raf.writeInt(i);
//        }
        raf.seek(0);
        for (int i = 0; i < 27; i++) {
            System.out.print(raf.readInt() + " ");
        }
    }
}
