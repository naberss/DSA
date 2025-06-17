package BST_questions.diameter_of_binary_tree;

import BST_questions.TreeNode;

import static BST_questions.TreeNode.printTree;

public class diameter_of_binary_tree {
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

        System.out.println(diameterOfBinaryTree(myNode4));
        //printTree(myNode);
    }


    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if(root.left!=null && root.right!=null){
            var internalMaxLeft = 0;
            var internalMaxRight = 0;

            internalMaxLeft = Math.max(internalMaxLeft,traverseCount(root.left));
            internalMaxRight = Math.max(internalMaxRight, traverseCount(root.right));

            return internalMaxLeft + internalMaxRight;
        } else if (root.left!=null) {
            return diameterOfBinaryTree(root.left);
        } else {
            return diameterOfBinaryTree(root.right);
        }
    }


    public static int traverseCount(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(traverseCount(root.left), traverseCount(root.right));
    }
}
