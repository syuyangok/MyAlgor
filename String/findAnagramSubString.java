

//leetocde, 438. Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        List<Integer> ret = new ArrayList<>();

        if (n < m) return ret;

        //ceate a arr to store counts
        int[] counts = new int[26];

        for(int i=0; i<m; i++){
            counts[p.charAt(i)-'a']++;
            counts[s.charAt(i)-'a']--;
        }

        if(areAllZero(counts)) ret.add(0);

        for(int i=m; i<n; i++){
            int j = i-m;
            counts[s.charAt(i)-'a']--;
            counts[s.charAt(j)-'a']++;
            if(areAllZero(counts)) ret.add(j+1);
        }

        return ret;
    }

    public boolean areAllZero(int[] arr){
        for(int i: arr){
            if (i !=0) return false;
        }
        return true;
    }
}

//Valid Anagram in Sequence, does s cantians a anagram of s. Too slow, should use above method.
class Solution2 {
        boolean isAllZero(HashMap<Character, Integer> map){
		for(Character i : map.keySet()){
                if(map.get(i)!=0){
                    return false;
                }
            }
        return true;
    }
	
	
    public boolean isAnagramMap(String s, String t) {

        //create a HashMap contains all the char in t
        HashMap<Character, Integer> ret = new HashMap<>();

        int n = s.length();
        int m = t.length();
        if(m>n) return false;

        for (int i =0; i<m; i++){
            Character current = t.charAt(i);
            if(ret.containsKey(current)){
                ret.put(current, ret.get(current)+1);
            } else {
                ret.put(current, 1);
            }
        }

        int left = 0, right = m-1;
        for(int i = 0; i<=right; i++){
            Character temp = s.charAt(i);
            if (ret.containsKey(temp)){
                ret.put(temp, ret.get(temp)-1);
            }
        }
        if (isAllZero(ret)) return true;


        while (left<n-m ){
            Character l = s.charAt(left);
            Character r = s.charAt(right);
            if (ret.containsKey(l)){
                ret.put(l, ret.get(l)-1);
            }
            if (ret.containsKey(r)){
                ret.put(r, ret.get(r)+1);
            }
			if (isAllZero(ret)) return true;

        }

        return false;
    }
	
	
	public boolean isAnagram(String s, String t) {
		
		int n = s.length(), m = t.length();
		
		if (
		
	}

}

