package BST_questions.balanced_binary_tree;

import BST_questions.TreeNode;

public class balanced_binary_tree {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3,
                                new TreeNode(3),
                                null
                        )
                );

        var myNode2 =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(5),
                                        null
                                ),
                                null
                        )
                );

        System.out.println(isBalanced(myNode2));
    }


    public static boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        var leftMaxHeight = traverseCount(root.left);
        var rightMaxHeight = traverseCount(root.right);
        if(Math.abs(leftMaxHeight- rightMaxHeight) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    public static int traverseCount(TreeNode root) {
        if(root == null) return 0;
        return 1+(Math.max(traverseCount(root.left), traverseCount(root.right)));
    }
}
