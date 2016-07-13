package Default;

import RadixSort.LeastSegnificantRadixSort;

import java.util.Random;

/**
 * @author Gustaf Nilstadius
 * Created by Gustaf Nilstadius ( hipernx ) on 2015-02-19.
 */
public class NB39Main {
    private static int n = 1000000;
    private static int max = 1000000;
    private static int min = 1;

    public static void main(String[] args) {
        System.out.println("Generating " + n + " random numbers");
        Integer arr[] = new Integer[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt((max - min) + 1) + min;
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println("Staring sort");
        LeastSegnificantRadixSort.sort(arr);
        System.out.println("Checking sort");
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if(prev > arr[i]){
                System.err.println("Error in sorting");
                System.exit(-1);
            }
        }
        System.out.println("Soring Complete");
        //System.out.println(Arrays.toString(arr));
    }
}
