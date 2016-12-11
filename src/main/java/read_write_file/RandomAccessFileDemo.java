package read_write_file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by a on 25.11.16.
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        try {
//            long f = 184750874576l;

            // create a new RandomAccessFile with filename test
            RandomAccessFile raf = new RandomAccessFile("test", "rw");

            // write a long in the file
            raf.writeLong(-34324l);

            // set the file pointer at 0 position
            raf.seek(0);

            // read long
            System.out.println("" + raf.readLong());

            // set the file pointer at 0 position
            raf.seek(0);

            // write a long at the start
            raf.writeLong(20000000000l);

            // set the file pointer at 0 position
            raf.seek(0);

            // read long
            System.out.println("" + raf.readLong());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}