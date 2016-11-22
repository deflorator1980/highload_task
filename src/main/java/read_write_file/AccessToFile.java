package read_write_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 * Created by a on 22.11.16.
 */
public class AccessToFile {
    public static void main(String[] args) throws IOException {
//        AccessToFile atf = new AccessToFile();
        String filename = "/home/a/Documents/My/hightload_task/just_file.txt";
//        System.out.println(atf.reader("/home/a/Documents/My/hightload_task/just_file.txt", 0));
        RandomAccessFile read = new RandomAccessFile(filename, "r");
        RandomAccessFile write = new RandomAccessFile(filename, "rw");
//        read.seek(0);
//        System.out.println(read.readLine());


//        byte[] bytes = ByteBuffer.allocate(4).putInt(1695609641).array();

        byte[] bytes = ByteBuffer.allocate(4).putInt(16).array();
        write.seek(0);
        write.write(bytes);

        bytes = ByteBuffer.allocate(4).putInt(32).array();
        write.seek(4);
        write.write(bytes);

        read.seek(0);
        System.out.println(read.readInt());

//        read.seek(0);
//        byte[] bytes = new byte[50];
//        read.read(bytes);
//        System.out.println(new String(bytes));


        read.close();
    }

//    public int reader(String filename, long position) throws IOException {
//    public char reader(String filename, long position) throws IOException {
//        int result = 0;
//        char result = 0;
//        RandomAccessFile read = new RandomAccessFile(filename, "r");
//        read.seek(position);
//        result = read.readInt();
//        result = read.readChar();
//        System.out.println(read.readLine());
//        read.close();
//        return result;
//    }


}
