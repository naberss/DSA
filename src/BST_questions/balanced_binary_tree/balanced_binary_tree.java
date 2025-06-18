package BST_questions.balanced_binary_tree;

import BST_questions.TreeNode;

public class balanced_binary_tree {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                new TreeNode(3,new TreeNode(5), null),
                                new TreeNode(4, new TreeNode(6), null)
                        )
                );

        var myNode2 =
                new TreeNode(1,
                        new TreeNode(9,
                                new TreeNode(4,
                                        new TreeNode(5,
                                                new TreeNode(7),
                                                null),
                                        new TreeNode(6,
                                                new TreeNode(2),
                                                null)
                                ),
                                null
                        ),
                        null
                );

        var myNode3 =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)
                );

        var myNode4 =
                new TreeNode(1,
                        new TreeNode(2),
                        null
                );

        System.out.println(isBalanced(myNode4));
    }


    public static boolean isBalanced(TreeNode root) {
        return false;
    }
}
