package mergesort;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a on 12/28/16.
 */
public class MergingFileFrome {
    public static void main(String[] args) throws IOException {
        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int size = a1.length + a2.length;

        RandomAccessFile raf1 = new RandomAccessFile("storage1", "rw");
        raf1.seek(0L);
        List<Integer> l1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
        l1.forEach((v) -> {
            try {
                raf1.writeInt(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        RandomAccessFile raf2 = new RandomAccessFile("storage2", "rw");
        raf2.seek(0L);
        List<Integer> l2 = Arrays.stream(a2).boxed().collect(Collectors.toList());
        l2.forEach((v) -> {
            try {
                raf2.writeInt(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.print("storage1: ");
        raf1.seek(0);
        for (int i1 = 0; i1 < l1.size(); i1++) {
            System.out.print(raf1.readInt() + " ");
        }

        System.out.print("\nstorage2: ");
        raf2.seek(0);
        for (int i2 = 0; i2 < l2.size(); i2++) {
            System.out.print(raf2.readInt() + " ");
        }
        System.out.println();

        RandomAccessFile rafRez = new RandomAccessFile("storageRez", "rw");

        int i = 0, j = 0;
        for (int k = 0; k < size; k++) {

            if (i > a1.length - 1) {
                int a = a2[j];
                rafRez.writeInt(a);
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                rafRez.writeInt(a);
                i++;
            } else if (a1[i] < a2[j]) {
                int a = a1[i];
                rafRez.writeInt(a);
                i++;
            } else {
                int b = a2[j];
                rafRez.writeInt(b);
                j++;
            }
        }


        System.out.println(l1);
        System.out.println(l2);



        rafRez.seek(0);
        for (int k = 0; k < size; k++) {
            System.out.print(rafRez.readInt() + " ");
        }


    }
}
