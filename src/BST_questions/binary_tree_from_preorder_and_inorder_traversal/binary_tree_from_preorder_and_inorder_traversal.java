package BST_questions.binary_tree_from_preorder_and_inorder_traversal;

import BST_questions.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class binary_tree_from_preorder_and_inorder_traversal {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int indexCouter = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0){
            return null;
        }

        for (int i =0; i <inorder.length; i++){
            indexMap.put(inorder[i], i);
        }

        return dfsBuildTree(preorder, 0, inorder.length-1);

    }

    public TreeNode dfsBuildTree(int[] preorder, int l, int r){
        if(l>r){
            return null;
        }

        var root = new TreeNode(preorder[indexCouter]);
        indexCouter++;
        var midIndex = indexMap.get(root.val);
        root.left = dfsBuildTree(preorder, l, midIndex-1);
        root.right = dfsBuildTree(preorder, midIndex+1, r);

        return root;
    }

}

