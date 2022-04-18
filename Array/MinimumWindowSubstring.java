package com.yuyang.leetcode.array;

import java.util.HashMap;

/**
 * @author : Yuyang Sun
 * @date: 4/17/2022, Sun
 **/
//leetcode 76 Minimum Window Substring
// sliding window

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String result;
        int left = 0, right = 0;//two pointers, for sliding window
        int valid = 0;//to record how many valid char in windows

        //to record, min substring start index, and length
        int start = 0, min_len = Integer.MAX_VALUE;

        //to store needs character and appear times.
        HashMap<Character, Integer> need = new HashMap<>();
        //to store needs characters in window and their apppear times
        HashMap<Character, Integer> window = new HashMap<>();

        //initial needs map
        for(int i = 0; i<t.length();i++){
            char c = t.charAt(i);
            /*
            if (need.containsKey(c)){
               need.put(c, need.get(c)+1);
            }
            else {
                need.put(c, 1);
            }
             */
            need.put(c, need.getOrDefault(c, 0)+1);//equal to above code
        }

        //sliding window
        while(right < s.length()){
            char c = s.charAt(right);
            //check right if belong to vaild,
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0 )+1);//update windows key value
                //update valid
                if(window.get(c) == need.get(c)){
                    valid++;
                }
            }
            right ++;
//            System.out.println("valid is " + valid);
//            System.out.println("need size is " + need.size());

             //shrink left
            while(valid == need.size()){
                //update mini substring
                if((right - left)< min_len ){
                    start = left;
                    min_len = right - left;
                }

                char lc = s.charAt(left);
                //check if lc in the windows/needs
                if (need.containsKey(lc)){
                    //update valid
                    if (window.get(lc) == need.get(lc)){
                        valid--;
                    }
                    window.put(lc, window.get(lc)-1);
                }
                left++;
            }

        }
//        System.out.println(start);
//       System.out.println(min_len);
        //get result string
        if (min_len == Integer.MAX_VALUE){
            result = "";
        }
        else{
            result = s.substring(start, start+min_len);//not include right end char
        }
//        System.out.println(result);
        return result;
    }





    //another sliding window, pass the leetcode
    public String minWindow2(String s, String t){
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, min_len = s.length()+1;//to record, min substring start index, and length
        String result;
        //to store char appear times
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        while(right < s.length()){
            char right_c = s.charAt(right);
            if (map.containsKey(right_c)){
                map.put(right_c, map.get(right_c) -1);//to match, need to cancel the char
                if (map.get(right_c) == 0){
                    valid++;
                }
            }
            right++;
//            System.out.println("right is " + right);
//            System.out.println("left is " + left);
//            System.out.println("valid is " + valid);

            while (valid == map.size()){
                if(right-left < min_len){
                    start = left;
                    min_len = right -left;
                }
                //System.out.println("mini len is " + min_len);

                char left_c = s.charAt(left);
                if (map.containsKey(left_c)){
                    if (map.get(left_c) == 0){
                        valid--;
                    }
                    map.put(left_c, map.get(left_c)+1);
                }
                left++;

            }

        }

        System.out.println(start);
       System.out.println(min_len);
        //get result string
        if (min_len > s.length()){
            result = "";
        }
        else{
            result = s.substring(start, start+min_len);//not include right end char
        }
        //System.out.println(result);
        return result;
    }



}
