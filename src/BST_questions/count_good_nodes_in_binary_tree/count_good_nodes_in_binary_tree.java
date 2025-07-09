package BST_questions.count_good_nodes_in_binary_tree;

import BST_questions.TreeNode;

public class count_good_nodes_in_binary_tree {
    Integer count = 0;


    public int goodNodes(TreeNode root) {
        if(root==null){
            return count;
        }

        // root is always a good node
        this.count++;
        traverseAndCount(root.left, root.val);
        traverseAndCount(root.right, root.val);

        return count;

    }

    public void traverseAndCount(TreeNode root, Integer max) {

        if(root==null){
            return;
        }

        if(root.val >= max){
            max = root.val;
            this.count++;
        }

        traverseAndCount(root.right, max);
        traverseAndCount(root.left, max);
    }
}
