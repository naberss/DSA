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

        lowestCommonAncestor(myNode, myNode2, myNode3);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (Math.max(p.val, q.val) < root.val) { // Ambos à esquerda
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) { // Ambos à direita
            return lowestCommonAncestor(root.right, p, q);
        } else { // Um de cada lado ou igual ao root
            return root;
        }
    }
}

