package Default;

import java.util.Arrays;

/**
 * Created by hipernx on 2015-02-18.
 */
public class NB36Main {
    public static void main(String[] args) {
        int[] array = {2, 87 , 4, 12, 43, 41, 9999, 1, 3, 5,24, 8743 , 41, 99, 1235, 53, 1, 34};
        System.out.println(Arrays.toString(array));
        Mergesort sort = new Mergesort();
        sort.mergesort(array);
        System.out.println(Arrays.toString(array));

    }


}
