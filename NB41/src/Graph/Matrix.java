package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Gustaf Nilstadius
 * Created by Gustaf Nilstadius ( hipernx ) on 2015-02-18.
 */
public class Matrix {


    private LinkedList<Node>[] list;
    private int rows;

    public Matrix(BufferedReader in){
        try {
            rows = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            rows = 0;
        }
        list = new LinkedList[rows];

        for (int i = 0; i < rows; i++) {
            list[i] = new LinkedList<Node>();
            String row = null;
            try {
                row = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                row = "";
            }
            for (int j = 0; j < row.length(); j++) {
                if(row.charAt(j) != 'X'){
                    list[i].add(new Node(Integer.parseInt("" + row.charAt(j)), j));
                }
            }
        }
    }

    public LinkedList<Node>[] getList(){
        return list;
    }

    public int getRows(){
        return rows;
    }

    public LinkedList<Node> getConnected(int node){
        return list[node];
    }
}
