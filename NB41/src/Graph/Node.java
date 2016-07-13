package Graph;

/**
 * @author Gustaf Nilstadius
 *         Created by Gustaf Nilstadius ( hipernx ) on 2015-02-18.
 */
public class Node{
    public int cost;
    public int nodeNr;

    public Node(int cost, int nodeNr){
        this.cost = cost;
        this.nodeNr = nodeNr;
    }

    public String toString(){
        return "Node: " + (char)(nodeNr+'A') + " Cost: " + cost;
    }
}