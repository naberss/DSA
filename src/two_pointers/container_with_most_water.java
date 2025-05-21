package two_pointers;


public class container_with_most_water {
    public static void main(String[] args) {
        System.out.println(
                maxArea(new int[]{1,7,2,5,4,7,3,6})
        );
    }

    public static int maxArea(int[] heights) {
        Integer highestArea = null;

        for (int i = 0; i < heights.length; i++){

            for (int j = 0; j < heights.length; j++){

                var max = Math.max(i, j);
                var min = Math.min(i, j);

                var area =  (Math.min(heights[i], heights[j]) * (max - min));
                if(i==j){
                    continue;
                }

                if(highestArea == null){
                    highestArea = area;
                } else {
                    highestArea = Math.max(area, highestArea);
                }


            }
        }
        return highestArea;
    }

}