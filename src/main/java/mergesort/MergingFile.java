package mergesort;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a on 15.12.16.
 */
public class MergingFile {
    public static void main(String[] args) throws IOException {
        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int size = a1.length + a2.length;

        RandomAccessFile raf = new RandomAccessFile("storage", "rw");
        raf.seek(0L);

        int i = 0, j = 0;
        for (int k = 0; k < size; k++) {

            if (i > a1.length - 1) {
                int a = a2[j];
                raf.writeInt(a);
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                raf.writeInt(a);
                i++;
            } else if (a1[i] < a2[j]) {
                int a = a1[i];
                raf.writeInt(a);
                i++;
            } else {
                int b = a2[j];
                raf.writeInt(b);
                j++;
            }
        }

        List<Integer> l1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(a2).boxed().collect(Collectors.toList());
        System.out.println(l1);
        System.out.println(l2);

        raf.seek(0);
        for (int k = 0; k < size; k++) {
            System.out.print(raf.readInt() + " ");
        }


    }
}
