package BST_questions.valid_binary_search_tree;

import BST_questions.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class valid_binary_search_tree {
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



        System.out.println(isValidBST(myNode3));
    }


    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }


        if(root.left!=null){
            if(root.left.val>=root.val){
                return false;
            }
        }

        if(root.right!=null){
            if(root.right.val<=root.val){
                return false;
            }
        }

        var leftReturn = checkLeftSideFromRoot(root.left, new ArrayList<>(List.of(root.val)));
        var rightReturn = checkRightSideFromRoot(root.right, new ArrayList<>(List.of(root.val)));
        return leftReturn&&rightReturn;

    }

    public static boolean checkRightSideFromRoot(TreeNode root, List<Integer> previousRootList){

        if(root==null){
            return true;
        }

        if(root.left!=null){
            if( !(root.left.val>=root.val)&&!compareValuesWithRootList(root.left.val, previousRootList, "higher")){
                return false;
            }
        }

        if(root.right!=null){
            if(!(root.right.val<=root.val) && !compareValuesWithRootList(root.right.val, previousRootList, "higher")){
                return false;
            }
        }

        previousRootList.add(root.val);
        return checkRightSideFromRoot(root.left, previousRootList)&&checkRightSideFromRoot(root.right, previousRootList);
    }


    public static boolean checkLeftSideFromRoot(TreeNode root, List<Integer> previousRootList){
        if(root==null){
            return true;
        }

        if(root.left!=null){
            if( !(root.left.val>=root.val) && !compareValuesWithRootList(root.left.val, previousRootList, "lower")){
                return false;
            }
        }

        if(root.right!=null){
            if(!(root.right.val<=root.val) && !compareValuesWithRootList(root.right.val, previousRootList, "lower")){
                return false;
            }
        }

        previousRootList.add(root.val);
        return checkLeftSideFromRoot(root.left, previousRootList)&&checkLeftSideFromRoot(root.right, previousRootList);
    }

    public static boolean compareValuesWithRootList (int currentNodeValue, List<Integer> previousRootList, String comparation){
        for (int previous : previousRootList){
            if (comparation.equals("higher")){
                if (currentNodeValue < previous){
                    return false;
                }
            } else {
                if (currentNodeValue > previous){
                    return false;
                }
            }
        }
        return true;
    }
}

