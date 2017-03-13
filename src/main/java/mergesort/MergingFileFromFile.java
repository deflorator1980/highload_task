package mergesort;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MergingFileFromFile {
    public static void main(String[] args) throws IOException {
        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
//        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int[] a2 = new int[]{30, 31, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};

        List<Integer> l1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(a2).boxed().collect(Collectors.toList());
        Collections.shuffle(l1);
        Collections.shuffle(l2);
        Collections.sort(l1);
        Collections.sort(l2);

        int size = l1.size() + l2.size();

        RandomAccessFile raf1 = new RandomAccessFile("l1", "rw");
        raf1.seek(0);
        for (int i = 0; i < l1.size(); i++) {
            raf1.writeInt(l1.get(i));
        }

        RandomAccessFile raf2 = new RandomAccessFile("l2", "rw");
        raf2.seek(0L);
        for (int i = 0; i < l2.size(); i++) {
            raf2.writeInt(l2.get(i));
        }

        System.out.print("l1: ");
        raf1.seek(0);
        for (int i = 0; i < l1.size(); i++) {
            System.out.print(raf1.readInt() + " ");
        }

        System.out.print("\nl2: ");
        raf2.seek(0);
        for (int i = 0; i < l2.size(); i++) {
            System.out.print(raf2.readInt() + " ");
        }
        System.out.println();

        RandomAccessFile rafRez = new RandomAccessFile("lRes", "rw");

        int i = 0, j = 0;
        for (int k = 0; k < size; k++) {
            if (i > ((l1.size() - 1) * 4)) {
                raf2.seek(j);
                int a = raf2.readInt();
                rafRez.writeInt(a);
                j += 4;
            } else if (j > ((l2.size() - 1) * 4)) {
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

        rafRez.seek(0);
        for (int k = 0; k < size; k++) {
            System.out.print(rafRez.readInt() + " ");
        }
    }
}
