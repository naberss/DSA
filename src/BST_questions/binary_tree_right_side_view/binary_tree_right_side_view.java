package BST_questions.binary_tree_right_side_view;

import BST_questions.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class binary_tree_right_side_view {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}
