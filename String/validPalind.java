//given a string, valid if string is palindrome;
//leetcdoe 125

public class validPalind {
    public boolean isPalindrome(String s) {
        //step1, clean string, remove non-alph non-num, change to lower case

        if (s.length() == 1) return true;

        String s_cleaned =cleanString(s);
        //step2, compare chararcter with two pointers
        int i = 0;
        int j = s_cleaned.length() -1;

        while (i<j && i< s_cleaned.length() && j>=0 ){
            char front = s_cleaned.charAt(i);
            char back = s_cleaned.charAt(j);

            if(!isAlphaNumeric(front)) i++;
            else if (!isAlphaNumeric(back)) j--;
            else if (front != back) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    private String cleanString(String s){
        s = s.toLowerCase();
        return s;
    }

    private boolean isAlphaNumeric(char c) {
        return (Character.isDigit(c) || Character.isLetter(c));
    }
