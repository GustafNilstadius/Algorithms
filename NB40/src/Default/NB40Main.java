package Default;
import PrimsAlgo.*;

/**
 * Created by hipernx on 2015-02-18.
 */
public class NB40Main {
    public static void main(String[] args) {
        int X = Integer.MAX_VALUE;
        int[][] w = {
                {X, 2, X, X, X, 1, X, X},
                {2, X, 2, 2, 4, X, X, X},
                {X, 2, X, X, 3, X, X, 1},
                {X, 2, X, X, 3, 1, X, X},
                {X, 4, 3, 3, X, X, 7, X},
                {1, X, X, 1, X, X, 5, X},
                {X, X, X, X, 7, 5, X, 6},
                {X, X, 1, X, X, X, 6, X}};


        int[] p = Prim.sort(w);
        for (int i = 0; i < w.length; i++) {
            System.out.println("Nod "+(char)(p[i]+'A')+" Anslöts till:  "+(char)(i+'A'));
        }
    }



}
