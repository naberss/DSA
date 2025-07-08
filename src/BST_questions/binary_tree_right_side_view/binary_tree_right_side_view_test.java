package BST_questions.binary_tree_right_side_view;

import BST_questions.TreeNode;

public class binary_tree_right_side_view_test {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)
                );

        var myNode2 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5,
                                        new TreeNode(9),
                                        null
                                )
                        ),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                );
        System.out.println(new binary_tree_right_side_view().rightSideView(myNode2));
    }
}
