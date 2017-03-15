package mergesort;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by isakow on 13.03.2017.
 */
public class ToFile {
    public int writeSortedParts(int size) throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("storageBase", "rw");
        RandomAccessFile raf2 = new RandomAccessFile("storageBase", "rw");

        RandomAccessFile rafRez = new RandomAccessFile("storageRez", "rw");
        int i = 0, j = size * 4;
        for (int k = 0; k < size * 2; k++) {
            if (i > ((size - 1) * 4)) {
                raf2.seek(j);
                int a;
                try {
                    a = raf2.readInt();
                } catch (EOFException e) {
                    break;
                }
                rafRez.writeInt(a);
                j += 4;
            } else {
                if (j > ((size - 1) * 4) + (size * 4)) {
                    raf1.seek(i);
                    int a = raf1.readInt();
                    rafRez.writeInt(a);
                    i += 4;
                } else {
                    raf1.seek(i);
                    raf2.seek(j);
                    int a = raf1.readInt();
                    int b;
                    try {
                        b = raf2.readInt();
                    } catch (EOFException e) {
                        b = Integer.MAX_VALUE;
                    }
                    if (a < b) {
                        rafRez.writeInt(a);
                        i += 4;
                    } else {
                        rafRez.writeInt(b);
                        j += 4;
                    }
                }
            }
        }

        System.out.print("storageRez       : ");
        int counter = MergingFileFromFile.printFile(rafRez);
        writeFromTo(rafRez, new RandomAccessFile("storageBase", "rw"), counter);
        return counter;
    }

    public void sortParts(String file, int memorySize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int x;
        int i;
        raf.seek(0);
        boolean eof = false;

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

    public void writeFromTo(RandomAccessFile rafFrom, RandomAccessFile rafTo, int counter) throws IOException {
        rafFrom.seek(0);
        rafTo.seek(0);
        for (int i = 0; i < counter; i++) {
            rafTo.writeInt(rafFrom.readInt());
        }
    }
}
