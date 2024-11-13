public class BinarySearchTree {

    // Node structure of the BST
    static class Node {
        int value;
        Node left, right;

        // Constructor for creating a new node
        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    // Root of the BST
    private Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Helper method for insertion (recursive)
    private Node insertRec(Node root, int value) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Helper method for searching (recursive)
    private boolean searchRec(Node root, int value) {
        // Base case: root is null or value is present at the root
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        // Value is greater than the root's value, search in right subtree
        if (value > root.value) {
            return searchRec(root.right, value);
        }

        // Value is smaller than the root's value, search in left subtree
        return searchRec(root.left, value);
    }

    // In-order traversal of the tree
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    // Helper method for in-order traversal (recursive)
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    // Main method to test the BST implementation
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // In-order traversal
        System.out.println("In-order traversal:");
        bst.inOrderTraversal();  // Expected output: 20 30 40 50 60 70 80
        System.out.println();

        // Search for a value
        System.out.println("Searching for 40: " + bst.search(40));  // Expected output: true
        System.out.println("Searching for 90: " + bst.search(90));  // Expected output: false
    }
}
