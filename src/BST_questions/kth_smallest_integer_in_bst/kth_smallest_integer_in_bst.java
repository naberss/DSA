package BST_questions.kth_smallest_integer_in_bst;

import BST_questions.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class kth_smallest_integer_in_bst {
    public static void main(String[] args) {
        var myNode =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)
                );

        var myNode2 =
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                );

        var myNode3 = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6,
                        new TreeNode(3),
                        new TreeNode(8)
                )
        );



        System.out.println(kthSmallest(myNode3, 5));
    }


    public static int kthSmallest(TreeNode root, int k) {
        return 1;
    }
}

