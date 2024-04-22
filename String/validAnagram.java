
//leetcode 248. Valid Anagram
class Solution {
	
	
	//use int array to store char counts
	    public boolean isAnagram2(String s, String t) {

        //create a HashMap contains all the char in t
        int[] counts = new int[26];

        int n = s.length();
        int m = t.length();
        if (n != m) return false;

        for(int i=0; i<n; i++){
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }

        for(int c : counts){
            if (c !=0) return false;
        }
        return true;

    }


//use hashMap to store counts
    public boolean isAnagram(String s, String t) {

        //create a HashMap contains all the char in t
        HashMap<Character, Integer> ret = new HashMap<>();

        int n = s.length();
        int m = t.length();
        if(m!=n) return false;

        for(int i = 0; i<n; i++){
            Character currentS = s.charAt(i);
            Character currentT = t.charAt(i);
            if(ret.containsKey(currentS)){
                ret.put(currentS, ret.get(currentS)+1);
            } else{
                ret.put(currentS, 1);
            }
            if(ret.containsKey(currentT)){
                ret.put(currentT, ret.get(currentT)-1);
            } else{
                ret.put(currentT, -1);
            }

        }

        for(Character i : ret.keySet()){
            if(ret.get(i)!=0){
                    return false;
                }
            }
        return true;


    }


}