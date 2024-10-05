/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week5tryitoutbinarytrees;

/**
 *
 * @author Mark
 */
public class Week5TryItOutBinaryTrees {

    // Function to count the number of nodes in the binary tree
    public int countNodes(TreeNode root) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }
        // Recursively count the nodes in the left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Function to check if the binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1; // -1 indicates the tree is unbalanced
    }

    // Helper method to check balance and return the height
    private int checkBalance(TreeNode node) {
        // Base case: if the node is null, the height is 0
        if (node == null) {
            return 0;
        }

        // Check the height of left subtree
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1; // Left subtree is unbalanced

        // Check the height of right subtree
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1; // Right subtree is unbalanced

        // Check the balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Tree is unbalanced
        }

        // Return the height of the tree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);
        
        Week5TryItOutBinaryTrees tree = new Week5TryItOutBinaryTrees();
        
        int nodeCount = tree.countNodes(root);
        System.out.println("Number of nodes in the tree: " + nodeCount);
        
        boolean balanced = tree.isBalanced(root);
        System.out.println("Is the tree balanced? " + balanced);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
