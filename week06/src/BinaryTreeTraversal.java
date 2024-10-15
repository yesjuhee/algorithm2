import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
    public static Node makeTree() {
        Node root = new Node(80);
        // level 1
        root.left = new Node(41);
        root.right = new Node(74);
        // level 2
        root.left.left = new Node(16);
        root.left.right = new Node(53);
        root.right.left = new Node(65);
        // level 3
        root.left.left.right = new Node(25);
        root.left.right.left = new Node(46);
        root.left.right.right = new Node(55);
        root.right.left.left = new Node(63);
        root.right.left.right = new Node(70);
        // level 4
        root.left.right.left.left = new Node(42);
        root.right.left.left.left = new Node(62);
        root.right.left.left.right = new Node(64);
        return root;
    }
}

public class BinaryTreeTraversal {
    List<Integer> preorderResult = new ArrayList<>();
    List<Integer> inorderResult = new ArrayList<>();
    List<Integer> postorderResult = new ArrayList<>();

    private List<Integer> preorderTraversal(Node root) {
        if (root != null) {
            preorderResult.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return preorderResult;
    }
    private List<Integer> inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            inorderResult.add(root.val);
            inorderTraversal(root.right);
        }
        return inorderResult;
    }
    private List<Integer> postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            postorderResult.add(root.val);
        }
        return postorderResult;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        Node tree = Node.makeTree();

        System.out.println("Preorder traversal: " + binaryTreeTraversal.preorderTraversal(tree));
        System.out.println("Inorder traversal: " + binaryTreeTraversal.inorderTraversal(tree));
        System.out.println("Postorder traversal: " + binaryTreeTraversal.postorderTraversal(tree));
    }
}