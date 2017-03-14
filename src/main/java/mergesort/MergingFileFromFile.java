package mergesort;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.stream.Collectors;

public class MergingFileFromFile {
    public static void main(String[] args) throws IOException {
        int k = 4;
        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
//        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200};
        int[] a2 = new int[]{30, 31, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};

        List<Integer> l1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(a2).boxed().collect(Collectors.toList());
        Collections.shuffle(l1);
        Collections.shuffle(l2);
        int size = (l1.size() + l2.size()) * k;
        System.out.println("l1: " + l1);
        System.out.println("l2: " + l2);

        RandomAccessFile raf = new RandomAccessFile("storageBase", "rw");
        raf.seek(0);
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l1.size(); i++) {
                raf.writeInt(l1.get(i));
            }
            for (int i = 0; i < l2.size(); i++) {
                raf.writeInt(l2.get(i));
            }
        }

        System.out.print("storageBase befor: ");
        printFile(raf);

        ToFile tf = new ToFile();
        tf.sortParts("storageBase", 10);

        System.out.print("storageBase after: ");
        printFile(raf);
    }

    public static void printFile(RandomAccessFile raf) throws IOException {
        int counter = 0;
        raf.seek(0);
        boolean eof = false;
        do {
            try {
                counter++;
                System.out.print(raf.readInt() + ", ");
            } catch (EOFException e) {
                eof = true;
            }
        } while (!eof);
        System.out.println(" итого: " + counter);
    }
}
