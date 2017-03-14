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
    public void writeToFile(int[] a1, int[] a2) throws IOException {
        int size = a1.length + a2.length;

        RandomAccessFile raf1 = new RandomAccessFile("a1", "rw");
        RandomAccessFile raf2 = new RandomAccessFile("a2", "rw");

        System.out.print("a1: ");
        raf1.seek(0);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(raf1.readInt() + " ");
        }

        System.out.print("\na2: ");
        raf2.seek(0);
        for (int i = 0; i < a2.length; i++) {
            System.out.print(raf2.readInt() + " ");
        }
        System.out.println();

        RandomAccessFile rafRez = new RandomAccessFile("storageRez", "rw");

        int i = 0, j = 0;
        for (int k = 0; k < size; k++) {
            if (i > ((a1.length - 1) * 4)) {
                raf2.seek(j);
                int a = raf2.readInt();
                rafRez.writeInt(a);
                j += 4;
            } else {
                if (j > ((a2.length - 1) * 4)) {
                    raf1.seek(i);
                    int a = raf1.readInt();
                    rafRez.writeInt(a);
                    i += 4;
                } else {
                    raf1.seek(i);
                    raf2.seek(j);
                    int a = raf1.readInt();
                    int b = raf2.readInt();
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

        rafRez.seek(0);
        for (int k = 0; k < size; k++) {
            System.out.print(rafRez.readInt() + " ");
        }
    }

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
