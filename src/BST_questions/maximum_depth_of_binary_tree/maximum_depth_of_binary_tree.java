package BST_questions.maximum_depth_of_binary_tree;

import BST_questions.TreeNode;

import java.math.MathContext;

import static BST_questions.TreeNode.printTree;

public class maximum_depth_of_binary_tree {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                );

        System.out.println(maxDepth(myNode));
        printTree(myNode);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
