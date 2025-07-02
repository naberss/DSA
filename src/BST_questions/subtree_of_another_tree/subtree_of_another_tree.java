package BST_questions.subtree_of_another_tree;

import BST_questions.TreeNode;

public class subtree_of_another_tree {
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

        System.out.println(isSubtree(myNode5, myNode6));
    }


    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // Check if the trees rooted at root and subRoot are the same
        if (isSameTree(root, subRoot)) return true;

        // Otherwise, recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

