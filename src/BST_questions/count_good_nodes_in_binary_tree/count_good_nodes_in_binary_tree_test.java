package BST_questions.count_good_nodes_in_binary_tree;

import BST_questions.TreeNode;

public class count_good_nodes_in_binary_tree_test {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)
                );


        var myNode2 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(7,
                                        new TreeNode(9),
                                        new TreeNode(10))),
                        new TreeNode(-1)
                );


        var myNode3 = new TreeNode(3,
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(2)
                ),
                null
        );


        System.out.println(new count_good_nodes_in_binary_tree().goodNodes(myNode2));
    }
}
