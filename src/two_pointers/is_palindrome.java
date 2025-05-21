package two_pointers;


public class is_palindrome {
    public static void main(String[] args) {
        System.out.println(
                isPalindrome("Was it a car or a cat I saw?")
        );
    }

    public static boolean isPalindrome(String s) {
        var fmtInput = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split("");
        int L = 0;
        int R = fmtInput.length-1;

        while(L<=R){
            if(!fmtInput[L].equals(fmtInput[R])){
                return false;
            } else {
                L++;
                R--;
            }
        }

        return true;
    }



}