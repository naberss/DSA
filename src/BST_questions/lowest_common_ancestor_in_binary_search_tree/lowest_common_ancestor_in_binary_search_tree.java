package BST_questions.lowest_common_ancestor_in_binary_search_tree;

import BST_questions.TreeNode;

public class lowest_common_ancestor_in_binary_search_tree {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3,
                                new TreeNode(4),
                                null
                        )
                );

        var myNode2 =
                new TreeNode(3,
                        new TreeNode(4),
                        null
                );


        var myNode3 =
                new TreeNode(1,
                        new TreeNode(1),
                        null
                );

        var myNode4 =
                new TreeNode(1);


        var myNode5 =
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1),
                                null),
                        new TreeNode(5,
                                new TreeNode(2),
                                null)
                );

        var myNode6 =
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(2)
                );

        lowestCommonAncestor(myNode, myNode2, myNode3);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return new TreeNode(0);
    }
}

