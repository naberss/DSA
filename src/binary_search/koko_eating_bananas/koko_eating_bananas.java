package binary_search.koko_eating_bananas;

import java.util.Arrays;

public class koko_eating_bananas {
    public static void main(String[] args) {
        /*System.out.println(
                minEatingSpeed(
                        new int[]{312884470},
                        312884469
                )
        );

        System.out.println(
                minEatingSpeed(
                        new int[]{25,10,23,4},
                        4
                )
        );

        System.out.println(
                minEatingSpeed(
                        new int[]{1,4,3,2},
                        9
                )
        );

        System.out.println(
                minEatingSpeed(
                        new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184},
                        823855818
                )
        );

        System.out.println(
                minEatingSpeed(
                        new int[]{3,6,7,11},
                        8
                )
        );
        */

        System.out.println(
                minEatingSpeed(
                        new int[]{1,1,1,999999999},
                        10
                )
        );
    }

    public static int minEatingSpeed(int[] piles, int h) {



        Arrays.sort(piles);
        calculateCoeficient(new int[]{999999999}, 142857143);
        int left = 0;
        int right = piles.length-1;
        int minimumK = 1;
        int maximumK = piles[piles.length-1];

        while(left<=right){
            int mid = left + ((right - left) / 2);
            var currentTotalAmount = calculateCoeficient(piles, piles[mid]);
            if(currentTotalAmount >= h){
                left = mid+1;
            } else  {
                right = mid-1;

                if(piles[mid] <= maximumK){
                    maximumK = piles[mid];
                }
            }
        }

            for(int i = minimumK; i <= maximumK; i++){
                minimumK = i;
                if(calculateCoeficient(piles, i)<=h){
                    return i;
                }
            }

        return minimumK;
    }

    // calculates what is the coeficient `K` given pile array
    // returns k if coeficient is valid for the given total amount of hours
    public static long calculateCoeficient(int[] piles, int k){
        long totalAmount = 0;
        for(int pile: piles) {
            long myValue = (long)Math.ceil(((double)pile/(double)k));
                totalAmount =  totalAmount + myValue;
                if((myValue)==0){
                    totalAmount++;
                }
        }
        return totalAmount;
    }

}