package Default;

import java.util.Arrays;

public class Mergesort {

    public void merge(int[] a, int[] b, int[] c){
        int indexa = 0, indexb = 0, indexc = 0;
        //System.out.println("Length: a= " + a.length + " b= " + b.length);
        while (indexa < a.length && indexb < b.length){
            if (a[indexa] <= b[indexb]){
                c[indexc++] = a[indexa];
                indexa++;
            } else {
                c[indexc++] = b[indexb];
                indexb++;
            }
        }
        while (indexa < a.length){
            c[indexc++] = a[indexa];
            indexa++;
        }
        while (indexb < b.length){
            c[indexc++] = b[indexb];
            indexb++;
        }
        return;
    }

    public void mergesort(int [] arr){
        int[] b, c;
        if (arr.length == 1){
            return;
        }
        if (arr.length > 2){
            b = Arrays.copyOfRange(arr, 0, arr.length / 2);
            c = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        } else {
            b = new int[] {arr[0]};
            c = new int[] {arr[1]};
        }
        mergesort(b);
        mergesort(c);
        merge(b, c, arr);
        return;
    }

}
