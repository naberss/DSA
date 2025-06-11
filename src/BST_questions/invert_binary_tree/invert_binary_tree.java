package BST_questions.invert_binary_tree;

import BST_questions.TreeNode;

import static BST_questions.TreeNode.printTree;

public class invert_binary_tree {
    public static void main(String[] args) {
        printTree(invertTree(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                )
        ));
    }

  public static TreeNode invertTree(TreeNode root) {

       if (root==null) {
           return null;
       }

      var temp = root.left;
      root.left = invertTree(root.right);
      root.right = invertTree(temp);

      return root;
    }



}
