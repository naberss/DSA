package BST_questions.kth_smallest_integer_in_bst;

import BST_questions.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class kth_smallest_integer_in_bst {
    List<Integer> values = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        if (root.right== null && root.left==null && k==1){
            return root.val;
        }

        values.add(root.val);

        if (root.left!=null){
            traverAndRecord(root.left, Integer.MAX_VALUE);
            if (values.size() >= k){
                Collections.sort(values);
                return values.get(k-1);
            }
        }

        if (root.right!=null){
            traverAndRecord(root.right, k);
            Collections.sort(values);
            return values.get(k-1);
        }

        return 1;
    }

    public void traverAndRecord(TreeNode root, int k) {

        if(root == null){return;}
        values.add(root.val);
        if (values.size() == k){return;}

        traverAndRecord(root.left, k);
        traverAndRecord(root.right, k);
    }
}

