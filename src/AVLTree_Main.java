import java.util.Scanner;

/**
 * The class is designed to work with AVL-tree.
 *
 * @author Syniuk Valentyn
 */
public class AVLTree_Main {

    public static void main(String[] args) {

        /* create an object of the class AVLTree */
        AVLTree avlTree = new AVLTree();
        Scanner scanner = new Scanner(System.in);

        /* AVLTree Operations (menu) */
        while (true) {
            System.out.println("\nAVLTree Operations:");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty");
            System.out.println("6. clear tree");
            System.out.println("7. get minimum");
            System.out.println("8. get maximum");
            System.out.println("9. display tree");
            System.out.println("10. exit..\n");

            System.out.print("Enter your change: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Enter integer element to insert: ");
                    avlTree.insert(scanner.nextInt());
                    break;
                }
                case 2: {
                    System.out.print("Enter integer element to remove: ");
                    System.out.println("Remove result: " + avlTree.remove(scanner.nextInt()));
                    break;
                }
                case 3: {
                    System.out.print("Enter integer element to search: ");
                    System.out.println("Search result: " + avlTree.search(scanner.nextInt()));
                    break;
                }
                case 4: {
                    System.out.println("Count nodes: " + avlTree.countNodes());
                    break;
                }
                case 5: {
                    System.out.println("Empty status: " + avlTree.isEmpty());
                    break;
                }
                case 6: {
                    System.out.println("\nTree Cleared!");
                    avlTree.makeEmpty();
                    break;
                }
                case 7: {
                    if (avlTree.getMin() == 0) {
                        System.out.println("Tree is empty!");
                    } else System.out.println("Minimum element: " + avlTree.getMin());
                    break;
                }
                case 8: {
                    if (avlTree.getMax() == 0) {
                        System.out.println("Tree is empty!");
                    } else System.out.println("Maximum element: " + avlTree.getMax());
                    break;
                }
                case 9: {
                    System.out.print("\nPost order : ");
                    avlTree.postOrder();
                    System.out.print("\nPre order : ");
                    avlTree.preOrder();
                    System.out.print("\nIn order : ");
                    avlTree.inOrder();
                    System.out.println();
                    break;
                }
                case 10: { // exit
                    return;
                }
                default: {
                    System.out.println("\nWrong Entry!");
                    break;
                }
            }
        }
    }
}