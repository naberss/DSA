package binary_search.search_in_rotated_sorted_array;

public class search_in_rotated_sorted_array {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,4,5,6,1,2}, 1));
        System.out.println(search(new int[]{3,5,6,0,1,2}, 4));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));

    }

    public static int search(int[] nums, int target) {

        var left = 0; //start index
        var right = nums.length-1; //end index


        while(left<=right){

            int leftRemaining;
            int rightRemaining;

            if(nums[left]!=target){
                leftRemaining = Math.abs(target-nums[left]);
            } else {
                return left;
            }

            if(nums[right]!=target){
                rightRemaining = Math.abs(target-nums[right]);
            } else {
                return right;
            }

            // checking for closest on sides

            if(rightRemaining<leftRemaining){
                left++;
            } else if (leftRemaining<rightRemaining){
                right++;
            } else {
                left++;
                right--;
            }

            /////////////////////////////////////////////////////

            int mid = left + ((right-left)/2);

            if(nums[mid]==target){
                return mid;
            }

            var predecessor = (mid-1 >=0) ?nums[mid-1]: Integer.MAX_VALUE;
            var successor = (mid+1 <=nums.length-1) ?nums[mid+1]: Integer.MAX_VALUE;

            if(predecessor==target){
                return mid-1;
            }

            if(successor==target){
                return mid+1;
            }

            var predecessorRemainings = Math.abs(target-predecessor);
            var sucessorRemainings = Math.abs(target-successor);

            if(predecessorRemainings<sucessorRemainings){
                right = mid-1;
            } else if (sucessorRemainings<predecessorRemainings){
                left = mid+1;
            }
        }

        return -1;

    }

}