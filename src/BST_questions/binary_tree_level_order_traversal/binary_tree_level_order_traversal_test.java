package BST_questions.binary_tree_level_order_traversal;

import BST_questions.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class binary_tree_level_order_traversal_test {
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
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                );


        System.out.println(new binary_tree_level_order_traversal().levelOrder(myNode));
        System.out.println(new binary_tree_level_order_traversal().levelOrder(myNode2));
        System.out.println(new binary_tree_level_order_traversal().levelOrder(new TreeNode(1)));
        System.out.println(new binary_tree_level_order_traversal().levelOrder(null));
    }
}

