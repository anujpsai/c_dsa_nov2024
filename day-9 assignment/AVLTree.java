public class AVLTree {

    // Node structure for the AVL Tree
    static class Node {
        int value;
        Node left, right;
        int height;

        // Constructor for the node
        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
            this.height = 1;  // New node is initially at height 1
        }
    }

    // Root of the AVL Tree
    private Node root;

    // Constructor
    public AVLTree() {
        root = null;
    }

    // Method to insert a value in the AVL tree
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a value in the AVL tree
    private Node insertRec(Node node, int value) {
        // 1. Perform the normal BST insertion
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        } else {
            return node;  // Duplicate values are not allowed
        }

        // 2. Update the height of this node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get the balance factor to check whether this node became unbalanced
        int balance = getBalance(node);

        // 4. If the node becomes unbalanced, then there are 4 cases:

        // Left Left Case
        if (balance > 1 && value < node.left.value) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && value > node.right.value) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Method to perform a right rotation on a node
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return the new root
        return x;
    }

    // Method to perform a left rotation on a node
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return the new root
        return y;
    }

    // Get the height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Get the balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // In-order traversal of the AVL tree
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    // Recursive function for in-order traversal
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    // Method to search for a value in the AVL tree
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive function for searching a value
    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value < root.value) {
            return searchRec(root.left, value);
        } else if (value > root.value) {
            return searchRec(root.right, value);
        } else {
            return true;  // value is equal to root.value
        }
    }

    // Main method to test the AVL Tree
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert values into the AVL Tree
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
        tree.insert(25);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);

        // In-order traversal
        System.out.println("In-order traversal:");
        tree.inOrderTraversal();  // Expected output: 10 20 25 30 40 50 60
        System.out.println();

        // Search for a value
        System.out.println("Searching for 25: " + tree.search(25));  // Expected output: true
        System.out.println("Searching for 35: " + tree.search(35));  // Expected output: false
    }
}
