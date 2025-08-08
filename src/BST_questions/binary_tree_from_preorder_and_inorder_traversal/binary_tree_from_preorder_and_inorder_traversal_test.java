package BST_questions.binary_tree_from_preorder_and_inorder_traversal;

public class binary_tree_from_preorder_and_inorder_traversal_test {

    public static void main(String[] args) {

        System.out.println(new binary_tree_from_preorder_and_inorder_traversal().buildTree(
                new int[]{10,7,2,99,9,130,13,15,17},
                new int[]{99,2,7,9,130,10,15,13,17}
        ));
    }

}

