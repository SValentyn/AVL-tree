/**
 * The class contains the basic methods for working with the AVL-tree
 */
class AVLTree {

    /* The root node */
    private Node root;

    /* Constructor */
    public AVLTree() {
        root = null;
    }

    /* Method to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Make the tree empty */
    public void makeEmpty() {
        root = null;
    }

    /* Method to insert value in tree */
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if (current == null) return new Node(value);
        if (value < current.value) {
            current.left = insert(current.left, value);
        } else {
            current.right = insert(current.right, value);
        }
        return balance(current);
    }

    /* Subtree height correction */
    private void correctHeight(Node node) {
        node.height = 1 + Math.max((heightSubtree(node.left)), (heightSubtree(node.right)));
    }

    /* Returns the height of the subtree */
    private int heightSubtree(Node current) {
        if (current == null) return -1;
        return current.height;
    }

    /* Method to balance values in tree */
    private Node balance(Node node) {

        correctHeight(node);
        if (balanceFactor(node) == 2) {
            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        if (balanceFactor(node) == -2) {
            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        return node;
    }

    /* Returns the balance factor of the subtree */
    private int balanceFactor(Node current) {
        return (heightSubtree(current.right) - heightSubtree(current.left));
    }

    /* Rotate binary tree node with left child */
    private Node rotateLeft(Node node) {
        Node tempNode = node.right;
        node.right = tempNode.left;
        tempNode.left = node;
        correctHeight(node);
        correctHeight(tempNode);
        return tempNode;
    }

    /* Rotate binary tree node with right child */
    private Node rotateRight(Node node) {
        Node tempNode = node.left;
        node.left = tempNode.right;
        tempNode.right = node;
        correctHeight(node);
        correctHeight(tempNode);
        return tempNode;
    }

    /* Method to remove value from tree */
    public boolean remove(int value) {
        return remove(root, value) != null;
    }

    private Node remove(Node node, int value) {
        if (node == null) return null;
        if (value < node.value) {
            node.left = remove(node.left, value);
        } else if (value > node.value) {
            node.right = remove(node.right, value);
        } else {
            Node tempLeft = node.left;
            Node tempRight = node.right;
            if (tempRight == null) {
                return tempLeft;
            } else {
                Node min = getMin(tempRight);
                min.right = removeMin(tempRight);
                min.left = tempLeft;
                return balance(min);
            }
        }

        return balance(node);
    }

    /* Method remove minimum value */
    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = removeMin(node.left);
        }
        return balance(node);
    }

    /* Method get minimum value */
    public int getMin() {
        if (root == null) {
            return 0;
        } else {
            return getMin(root).value;
        }
    }

    private Node getMin(Node current) {
        if (current.left == null) {
            return current;
        } else {
            return getMin(current.left);
        }
    }

    /* Method get maximum value */
    public int getMax() {
        if (root == null) {
            return 0;
        } else {
            return getMax(root).value;
        }
    }

    private Node getMax(Node current) {
        if (current.right == null) return current;
        return getMax(current.right);
    }

    /* Method to search for an element */
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node current, int value) {
        boolean ifFound = false;
        while ((current != null) && !ifFound) {
            int tempValue = current.value;
            if (value < tempValue)
                current = current.left;
            else if (value > tempValue)
                current = current.right;
            else {
                ifFound = true;
                break;
            }
            ifFound = search(current, value);
        }
        return ifFound;
    }

    /* Method to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null)
            return 0;
        else {
            int count = 1;
            count += countNodes(node.left);
            count += countNodes(node.right);
            return count;
        }
    }

    /* Function for inOrder traversal */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    /* Function for preOrder traversal */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /* Function for postOrder traversal */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }
}
