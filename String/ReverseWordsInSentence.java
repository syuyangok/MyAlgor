package com.yuyang.string;

/**
 * @author : Yuyang Sun
 * @date: 4/9/2022, Sat
 **/
//151. Reverse Words in a String
// Input: s = "the sky is blue" Output: "blue is sky the"
public class ReverseWordsInSentence {
    public String reverseWords(String s) {
        //clean space

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        int right = words.length-1;
        for (int i = 0; i <=right; i++) {
            if ( !words[i].isEmpty()){
                sb.insert(0, words[i]);
                if (i != right)    sb.insert(0," ");
            }

        }
        //System.out.println(sb);
        return sb.toString();

    }
}
