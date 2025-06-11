package BST_questions;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    /**
     * traverses and prints tree structure horizontaly e.g.:
     * <pre>
     *      4
     *   2
     *      5
     * 1
     *      6
     *   3
     *      7
     * </pre>
     */
    private static void printTreeHelper(TreeNode node, int level) {
        if (node == null) return;
        printTreeHelper(node.right, level + 1);
        System.out.print(" ".repeat(level * 3));
        System.out.println(node.val);
        printTreeHelper(node.left, level + 1);
    }
}
