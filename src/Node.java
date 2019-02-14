/**
 * Class contains node structure of AVL-tree
 */
class Node {

    public Node left;   // left subtree
    public Node right;  // right subtree
    public int height;  // height of the subtree
    public int value;   // the sets value from main class

    /* Constructor */
    Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
        this.height = 1;
    }
}