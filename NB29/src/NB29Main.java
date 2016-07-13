/**
 * Created by hipernx on 2015-02-15.
 */
public class NB29Main {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.add("Kakor");
        tree.add("Majs");
        tree.add("Palm");
        tree.add("Is");
        tree.add("up");
        tree.add("down");
        tree.add("wonderland");
        tree.add("centuries");
        tree.add("I");
        tree.add("VerryLongString");
        System.out.println(tree.toString());
        System.out.println("Number of leaves " + tree.numberOfLeaves());
        System.out.println("Number of nodes " + tree.numberOfNodes());
        System.out.println("Find down:" + tree.find("down"));
    }
}
