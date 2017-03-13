package h;

import com.arturmkrtchyan.sizeof4j.SizeOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a on 22.11.16.
 */
public class H {
    public static void main(String[] args) {
//        byte[] bytes = ByteBuffer.allocate(4).putInt(1695609641).array();
//
//        for (byte b : bytes) {
//            System.out.format("0x%x ", b);
//        }
//
//        int i = 5 ^ 2;
//        System.out.println(i);
//        int[] a1 = new int[]{21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
//        int[] a2 = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
//        List<Integer> l1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
//        List<Integer> l2 = Arrays.stream(a2).boxed().collect(Collectors.toList());
//        Collections.shuffle(l1);
//        Collections.shuffle(l2);
//        System.out.println(l1);
//        System.out.println(l2);
//        Collections.sort(l1);
//        System.out.println(l1);
//        System.out.println("a1: " + SizeOf.shallowSize(a1));
//        System.out.print("a1: [");
//        Arrays.stream(a1).forEach(a -> System.out.print(a + " "));
//        System.out.println("]" + SizeOf.shallowSize(a1));
//        System.out.println("l1: " + l1 + " " + SizeOf.shallowSize(l1));
//
//        System.out.println(l1.get(1));
//        System.out.println(l1);
//        System.out.println(a1.length);
//        System.out.println(l1.size());

        ArrayList<Integer> list = new ArrayList<>(10_000_000);
        Integer[] arr = list.toArray(new Integer[10_000_000]);
        list.addAll(Arrays.stream(arr).collect(Collectors.toList()));
        System.out.println(SizeOf.shallowSize(arr));
        System.out.println(SizeOf.shallowSize(list));
    }
}
