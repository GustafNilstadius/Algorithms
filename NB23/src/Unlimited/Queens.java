package Unlimited;

/**
 * @author Gustaf Nilstadius
 */
public class Queens {
    private static int nrOfQueens = 8;
    private int solutions = 0;

    private boolean[] neDiagonal;
    private boolean[] nwDiagonal;
    private boolean[][] matrix;

    public Queens(int nrOfQueens){
        this.nrOfQueens = nrOfQueens;
        neDiagonal = new boolean[(nrOfQueens*2)+1];
        nwDiagonal = new boolean[(nrOfQueens*2)+1];
        matrix = new boolean[nrOfQueens][nrOfQueens];
    }

    public int addQueen(){
        addQueen(1);
        return solutions;
    }
    private void addQueen(int row){
        for (int column = 1; column <= nrOfQueens; column++) {
            if(checkPossition(row, column)){
                matrix[row-1][column-1] = true;
                neDiagonal[row+column] = true;
                nwDiagonal[row-column+(nrOfQueens-1)] = true;
                if (row == nrOfQueens){
                    solutions++;
                } else {
                    addQueen(row+1);
                }
                matrix[row-1][column-1] = false;
                neDiagonal[row+column] = false;
                nwDiagonal[row-column+(nrOfQueens-1)] = false;
            }
        }
    }

    private boolean checkPossition (int row, int column){
        if (checkColumn(column) && checkRow(row) && !neDiagonal[row+column] && !nwDiagonal[row-column+(nrOfQueens-1)]){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRow(int row){
        boolean ret = true;
        for (int i = 0; i < nrOfQueens; i++) {
            if(matrix[row-1][i]){
                ret = false;
                break;
            }
        }
        return ret;
    }

    private boolean checkColumn(int column){
        boolean ret = true;
        for (int i = 0; i < nrOfQueens; i++) {
            if(matrix[i][column-1]){
                ret = false;
                break;
            }
        }
        return ret;
    }
}
