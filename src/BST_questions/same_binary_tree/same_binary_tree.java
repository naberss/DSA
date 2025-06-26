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

        var myNode3 =
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

        System.out.println(isSameTree(myNode2, myNode3));
    }


    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        int t1Value = -151;
        int t2Value = -151;
        if(t1!=null) t1Value = t1.val;
        if(t2!=null) t2Value = t2.val;


        if(t1Value!=t2Value) return false;

        if(t1!=null && t2!=null) {
            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        } else if ((t1!=null && t2==null)||(t2!=null && t1==null)){
            return false;
        } else {
            return true;
        }
    }
}
