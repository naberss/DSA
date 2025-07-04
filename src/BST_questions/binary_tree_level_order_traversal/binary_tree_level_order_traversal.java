package BST_questions.binary_tree_level_order_traversal;

import BST_questions.TreeNode;

import java.util.*;

public class binary_tree_level_order_traversal {
    Map<Integer, List<Integer>> storage = new HashMap<Integer, List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root!=null){
            addToStorage(1, root.val);
        } else {
            new ArrayList<>(new ArrayList<>());
        }

        traverseAndStore(root, 1);

        var keyList = new ArrayList<Integer>();
        for(Map.Entry<Integer, List<Integer>> currSet: storage.entrySet()){
            keyList.add(currSet.getKey());
        }

        Collections.sort(keyList);
        var finalList = new ArrayList<List<Integer>>();

        for(Integer currKey: keyList){
            finalList.add(storage.get(currKey));
        }

        return finalList;
    }


    public void traverseAndStore(TreeNode root, int level) {
        if (root!=null){
            var newLevel = level+1;
            if (root.left!=null){
                addToStorage(newLevel, root.left.val);
                traverseAndStore(root.left, newLevel+1);
            }

            if (root.right!=null){
                addToStorage(newLevel, root.right.val);
                traverseAndStore(root.right, newLevel+1);
            }
        }
    }

    public void addToStorage(Integer key, Integer value){
        if (!storage.containsKey(key)){
            var bootstrapList = new ArrayList<Integer>();
            bootstrapList.add(value);
            storage.put(key, bootstrapList);
        } else {
            var currentList = storage.get(key);
            currentList.add(value);
            storage.put(key, currentList);
        }
    }
}

