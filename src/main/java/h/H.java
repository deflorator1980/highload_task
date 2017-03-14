package h;

import mergesort.MergingFileFromFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a on 22.11.16.
 */
public class H {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hui", "rw");
        RandomAccessFile raf2 = new RandomAccessFile("hui", "rw");
        for (int i = 0; i < 4; i++) {
            raf1.writeInt(1);
            raf2.seek(raf1.getFilePointer());
            raf2.writeInt(2);
            raf1.seek(raf2.getFilePointer());
        }
        MergingFileFromFile.printFile(raf1);
    }
}
