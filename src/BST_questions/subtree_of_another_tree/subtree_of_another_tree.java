package BST_questions.subtree_of_another_tree;

import BST_questions.TreeNode;

public class subtree_of_another_tree {
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
                new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(4)
                );

        System.out.println(isSubtree(myNode2, myNode2));
    }


    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot==null) return true;
        if ((root == null && subRoot!=null)||(root != null && subRoot==null)) return false;

        if (root!=null && subRoot!=null){
            if(root.val == subRoot.val){
                return isSubtree(root.left, subRoot.left)&&isSubtree(root.right, subRoot.right);
            }
        }

        return false;

    }
}
