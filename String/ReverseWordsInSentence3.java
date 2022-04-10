package com.yuyang.string;

/**
 * @author : Yuyang Sun
 * @date: 4/9/2022, Sat
 **/
//557. Reverse Words in a String III
// Input: s = "God Ding"   Output: "doG gniD"
public class ReverseWordsInSentence3 {
    public String reverseWords(String s) {

        //change string to char array
        char[] chars = s.toCharArray();

        int n =chars.length;
        int index = 0;
        for(; index <n;index++){
            int left = index;

            while(index< n && chars[index] != ' '){
                index++;//move index = space
            }
            int right = index-1;
            //reverse single word
            reverse(chars, left, right);
        }

    return new String(chars);

    }
    //reverse single word
    private void reverse(char[] chars, int left, int right) {
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

    }
}
