public class BinarySearchTree <E extends Comparable<E>> {
    private E deletedData;

    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private void inOrder (Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append(": "+ node.toString());
            inOrder(node.right, sb);
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private boolean add(E data, Node<E> node){
        if(data.compareTo (node.data)==0)
            return false;
        else if(data.compareTo (node.data)<0)
            if(node.left == null){
                node.left = new Node<E>(data);
                return true;
            }
            else
                return add(data, node.left);
        else if(node.right == null){
            node.right = new Node<E>(data);
            return true;
        }
        else
            return add(data, node.right);
    }

    public boolean add(E data){
        if(root == null){
            root = new Node<E>(data);
            return true;
        }
        else
            return add(data, root);
    }

    public int numberOfNodes(){
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node<E> node){
        if(node == null){
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    public int numberOfLeaves(){
        return numberOfLeaves(root);
    }
    private int numberOfLeaves(Node<E> node){
        if(node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        } else {
            return numberOfLeaves(node.left) + numberOfLeaves(node.right);
        }
    }

    private E find(E target, Node<E> node){
        if(node == null)
            return null;
        if(target.compareTo(node.data)==0)
            return node.data;
        if(target.compareTo(node.data)<0)
            return find(target,node.left);
        return find(target,node.right);
    }
    public E find(E target){
        return find(target, root);
    }

    public E delete(E target){
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target,Node<E> node) {
        if (node == null) {//target finns ej i trädet
            deletedData = null;
            return null;
        } else {
            if (target.compareTo(node.data) < 0) {//target finns i vänstra trädet
                node.left = delete(target, node.left); //om det finns
                return node;
            } else if (target.compareTo(node.data) > 0) {//target i högra trädet
                node.right = delete(target, node.right);
                return node;
            } else {//target finns i node!
                deletedData = node.data; //lagrar data att returnera
                //nu ska vi bygga om trädet
                if (node.left == null) //noden som ska bort saknar vänster träd
                    return node.right;
                else if (node.right == null)//noden som ska bort saknar högerträd
                    return node.left;
                else {//noden vi ska ta bort har två barn
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    if (nodeToMove.left == null) {//högra barnet har inget vänsterbarn
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    //högra barnet har vänsterbarn
                    while (nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }
}