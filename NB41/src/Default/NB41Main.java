package Default;

import Graph.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Gustaf Nilstadius
 *         Created by Gustaf Nilstadius ( hipernx ) on 2015-02-18.
 */
public class NB41Main {

    private static String fileName = "Matrix.txt";
    private static int start = 0;
    private static int stop = 2;

    public static void main(String[] args) {

        if(args != null){
            if(args.length >= 2){
                start = Integer.parseInt(args[0]);
                stop = Integer.parseInt(args[1]);
            }
            if(args.length == 3){
                fileName = args[2];
            }
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Matrix matrix = new Matrix(in);
        LinkedList<Node> result = findRoute(matrix.getList(), start, stop);
        System.out.println("From " + (char)(start+'A') + " to " + (char)(stop+'A') + ". Route:" + result.toString());

    }


    public static LinkedList<Node> findRoute(LinkedList<Node>[] list, int start, int stop){
        LinkedList<Node> ret = new LinkedList<Node>();
        boolean visited[] = new boolean[list.length];
        Arrays.fill(visited, false);
        visited[start] = true;
        System.out.println("Total Cost: " + findRoute(list, start, stop, ret, 0, 0, visited));

        return ret;
    }

    private static int findRoute(LinkedList<Node>[] list, int current, int stop, LinkedList<Node> ret, int T, int cost, boolean[] visited) {
        if (T == list.length && current != stop){
            return Integer.MAX_VALUE;
        }
        if (current == stop){
            return cost;
        }
        LinkedList<Node> save = new LinkedList<Node>();
        int shortestRouteCost = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (Iterator<Node> iter = list[current].iterator(); iter.hasNext();) {
            visited[current] = true;
            LinkedList<Node> test = new LinkedList<Node>();
            Node node = iter.next();
            test.add(node);
            if(!visited[node.nodeNr]){
                int routeCost = findRoute(list, node.nodeNr, stop, test, T+1, cost+node.cost, visited);
                if(routeCost < smallest){
                    save = test;
                    smallest = routeCost;
                    shortestRouteCost = routeCost;
                }
            }
            visited[current] = false;
        }
        ret.addAll(save);
        return shortestRouteCost;
    }
}
