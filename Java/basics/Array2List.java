import java.util.*;
import java.io.*;

public class Array2List {
    public static void main (String []args) {
        Integer[] array = new Integer[] {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        // if use the List<Integer> list = Arrays.asList(array), cannot add/remove element for list.
        list.add(6);
        for (Integer x : list) {
            System.out.println(x);
        }
    }
}