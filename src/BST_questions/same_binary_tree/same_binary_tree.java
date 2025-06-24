package BST_questions.same_binary_tree;

import BST_questions.TreeNode;

public class same_binary_tree {
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

        System.out.println(isSameTree(myNode2, myNode));
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return false;
    }
}
