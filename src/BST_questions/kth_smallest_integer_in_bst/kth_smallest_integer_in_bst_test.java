package BST_questions.kth_smallest_integer_in_bst;

import BST_questions.TreeNode;

public class kth_smallest_integer_in_bst_test {
    public static void main(String[] args) {

        var myNode =
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                );

        var myNode2 =
                new TreeNode(4,
                        new TreeNode(3,
                                new TreeNode(2), null
                        ),
                        new TreeNode(5)
                );



        /*System.out.println(
                new kth_smallest_integer_in_bst().kthSmallest(myNode, 1)
        );*/

        System.out.println(
                new kth_smallest_integer_in_bst().kthSmallest(myNode2, 4)
        );


    }
}

