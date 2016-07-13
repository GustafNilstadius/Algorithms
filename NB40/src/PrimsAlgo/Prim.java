package PrimsAlgo;

import java.util.Arrays;

/**
 *@author Gustaf Nilstadius
 */
public class Prim {

    public static int[] sort(int[][] matrix){
        int[] ret = new int[matrix.length];
        Arrays.fill(ret, Integer.MAX_VALUE);

        boolean taken[] = new boolean[matrix.length];
        Arrays.fill(taken, false);
        taken[0] = true;

        sort(matrix, ret, 0, taken);
        return ret;
    }

    private static void sort(int[][] matrix,int[] ret, int T, boolean[] taken){
        if(T == matrix.length-1){
            return;
        }

        int lowest = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            if(matrix[T][j] < lowest && !taken[j]){
                lowest = matrix[T][j];
                ret[T] = j;

            }
        }
        taken[ret[T]] = true;

        sort(matrix, ret, (T+1), taken);

        return;
    }
}
