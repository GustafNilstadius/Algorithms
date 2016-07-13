package Eight;

/**
 * @author Gustaf Nilstadius
 */
public class EightQueens {
    private static int nrOfQueens = 8;

    private boolean[] neDiagonal;
    private boolean[] nwDiagonal;
    private boolean[][] matrix;

    public EightQueens(){
        neDiagonal = new boolean[(nrOfQueens*2)+1];
        nwDiagonal = new boolean[(nrOfQueens*2)+1];
        matrix = new boolean[nrOfQueens][nrOfQueens];
    }

    public void addQueen(){
        addQueen(1);
    }
    private void addQueen(int row){
        for (int column = 1; column <= nrOfQueens; column++) {
            if(checkPossition(row, column)){
                matrix[row-1][column-1] = true;
                neDiagonal[row+column] = true;
                nwDiagonal[row-column+7] = true;
                if (row == nrOfQueens){
                    System.out.println("\n\nSOLVED! ");
                    for (int i = 0; i < nrOfQueens; i++) {
                        for (int j = 0; j < nrOfQueens; j++) {
                            if(matrix[i][j]){
                                System.out.print("X");
                            } else {
                                System.out.print("O");
                            }
                        }
                        System.out.println();
                    }
                } else {
                    addQueen(row+1);
                }
                matrix[row-1][column-1] = false;
                neDiagonal[row+column] = false;
                nwDiagonal[row-column+7] = false;
            }
        }
    }

    private boolean checkPossition (int row, int column){
        if (checkColumn(column) && checkRow(row) && !neDiagonal[row+column] && !nwDiagonal[row-column+7]){
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
