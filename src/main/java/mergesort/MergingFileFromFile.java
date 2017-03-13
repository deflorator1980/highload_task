package mergesort;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergingFileFromFile {
    public static void main(String[] args) throws IOException {
        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
//        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int[] a2 = new int[]{30, 31, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int size = a1.length + a2.length;

        RandomAccessFile raf1 = new RandomAccessFile("a1", "rw");
        raf1.seek(0);
        for (int i = 0; i < a1.length; i++) {
            raf1.writeInt(a1[i]);
        }

        RandomAccessFile raf2 = new RandomAccessFile("a2", "rw");
        raf2.seek(0L);
        for (int i = 0; i < a2.length; i++) {
            raf2.writeInt(a2[i]);
        }

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
}
