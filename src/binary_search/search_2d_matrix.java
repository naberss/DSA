package binary_search;

import java.util.ArrayList;

public class search_2d_matrix {
    public static void main(String[] args) {
        System.out.println(
                searchMatrix(new int[][]{
                        {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,50}
                        },
                        11)
        );
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        var verticalArray = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length; i++){
            verticalArray.add(matrix[i][0]);
        }

        var left = 0;
        var right = verticalArray.size()-1;
        var verticalResult = 0;
        Integer previous = null;
        while(left <= right){
            var mid = left + ((right-left) / 2);
            verticalResult = mid;

            if(previous !=null){
                if(verticalArray.get(previous) < target && verticalArray.get(mid) > target ){
                    verticalResult = previous;
                    break;
                }
            }
            if(target > verticalArray.get(mid)){
                left = mid + 1;
            } else if (target < verticalArray.get(mid)){
                right = mid -1;
            } else {
                break;
            }
            previous = mid;
        }

        for (int i = 0; i < matrix[verticalResult].length; i++){
            if(target == matrix[verticalResult][i]){
                return true;
            }
        }

        return false;
    }

}