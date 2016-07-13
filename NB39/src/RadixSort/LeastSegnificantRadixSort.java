package RadixSort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hipernx on 2015-02-18.
 */
public class LeastSegnificantRadixSort {
    public static Integer[] sort(Integer[] arr){
        LinkedList<Integer> send = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            send.add(arr[i]);
        }
        return sort(send, 1).toArray(arr);

    }
    private static LinkedList<Integer> sort(LinkedList<Integer> old, int x){
        if(x == 1073741824){
            return old;
        }
        LinkedList<Integer> one = new LinkedList<Integer>();
        LinkedList<Integer> zero = new LinkedList<Integer>();
        for(Iterator<Integer> iter = old.iterator(); iter.hasNext();){
            int current = iter.next();
            if((current & x) == 0){
                zero.add(current);
            } else {
                one.add(current);
            }
        }
        zero.addAll(one);
        return sort(zero, x << 1);
    }

}
