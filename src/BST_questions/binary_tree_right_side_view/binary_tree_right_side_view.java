package BST_questions.binary_tree_right_side_view;
import BST_questions.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class binary_tree_right_side_view {
    List<Integer> myList = new ArrayList<Integer>();


    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return myList;
        }

        traverseAndPersist(root, 0);

        return myList;
    }

    public void traverseAndPersist(TreeNode root, Integer depth) {
        if (root == null){
            return;
        }

        if(myList.size() == depth){
            myList.add(root.val);
        }

        traverseAndPersist(root.right, depth+1);
        traverseAndPersist(root.left, depth+1);
    }
}
