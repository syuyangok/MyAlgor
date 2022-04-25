package com.yuyang.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Yuyang Sun
 * @date 4/25/2022
 */
//leetcode 68
public class TextJustify {
    public List<String> fullJustify(String[] words, int maxWidth){
        List<String> result = new ArrayList<>();
        int occupied = 0;
        int start = 0;

        for (int i = 0; i < words.length; i++) {
            occupied = occupied + words[i].length() +1; //each words need a space at end
            //if occupied + next words reach max width, means have find all words in a line.
            //if (i+1 == words.length), it means it's last line.
            if(i+1 == words.length ||occupied + words[i+1].length() > maxWidth){
                //assigned space in a line
                String line = fillWords(words, start, i, maxWidth, i + 1 == words.length);
                result.add(line);
                //after fill line, reset occupied, start
                start = i+1;
                occupied = 0;
            }
        }
        return result;
    }

    private String fillWords(String[] words, int start, int end, int maxWidth, boolean isLastline) {
        int wordCount = end - start +1;
        int spaceCount = maxWidth +1;
        //remove all the word length plus one end space
        for (int i = start; i<=end; i++){
            spaceCount = spaceCount -words[i].length() -1;
        }
        int spaceSuffix  =1;
        int spaceAvg, spaceExtra;
        //extra space average = left space/ number of gap
        if(wordCount == 1){
            spaceAvg  = 1;
            spaceExtra = 0;
        }
        else{
            spaceAvg = spaceCount/(wordCount-1);
            spaceExtra = spaceCount %(wordCount-1);
        }

        //fill words;
        StringBuilder sb = new StringBuilder();
        for(int i = start; i<end; i++){
            sb.append(words[i]);
            if(isLastline){
                sb.append(" ");//last line all words to left.
                continue;
            }
            int n  = spaceSuffix + spaceAvg;
            //front spaceExtra gap, each need 1 more space
            if( (i-start) < spaceExtra){
                n = n+1;
            }
            //fill space
            while (n>0){
                sb.append(" ");
                n--;
            }
        }
        //fill last word in line
        sb.append(words[end]);
        //make up space
        int lastSpace = maxWidth - sb.length();
        while(lastSpace > 0){
            sb.append(" ");
            lastSpace--;
        }
    return sb.toString();

    }
}
