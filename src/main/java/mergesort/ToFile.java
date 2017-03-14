package mergesort;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by isakow on 13.03.2017.
 */
public class ToFile {
    public void sortParts(String file, int memorySize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int x;
        int i;
        raf.seek(0);
        boolean eof = false;
        /**
         * todo дописать while eof = false
         */
        do {
            List<Integer> values = new ArrayList<>();
            for (i = 0; i < memorySize; i++) {
                try {
                    x = raf.readInt();
                    values.add(x);
                } catch (EOFException eofe) {
                    eof = true;
                break;
                }
            }
            Collections.sort(values);
            raf.seek(raf.getFilePointer() - (i * 4));
            writeSorted(raf, values);
        } while (!eof);
    }

    public void writeSorted(RandomAccessFile raf, List<Integer> values) throws IOException {
        for (int value : values) {
            raf.writeInt(value);
        }
    }
}
