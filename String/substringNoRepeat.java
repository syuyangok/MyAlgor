
//leecode 3. Longest Substring Without Repeating Characters
public class Solution {
	
	// double pointer + Map (store char location), more faster
    public int lengthOfLongestSubstring1(String s) {
	int n = s.length();
	
	int left = 0, right = 0;
	int ret =0;
	
	Map<Character, Integer> map = new HashMap<>();
	
	while(right<n){
		//move right pointer
		if(!map.containsKey(s.charAt(right))){
			map.put(s.charAt(right), right);			
			ret = Math.max(ret, right-left+1);
			right++;
		} else{			
			//move left pointer, make sure left not back up		
			left = Math.max(left, map.get(s.charAt(right)) + 1);
			map.remove(s.charAt(right));				
		}
		
	}
	return ret;	
	
	}
	
	
	
		// double pointer + HashSet
    public int lengthOfLongestSubstring2(String s) {
	int n = s.length();
	
	int left = 0, right = 0;
	int ret =0;
	
	Set<Character> set = new HashSet<>();
	
	while(right<n){
		//move right pointer
		if(!set.contains(s.charAt(right))){
			set.add(s.charAt(right));			
			ret = Math.max(ret, right-left+1);
			right++;
		} else{			
			//move left pointer
			set.remove(s.charAt(left))
			left++;	
		}
		
	}
	return ret;	
	
	}
}


abcdba

map = abcd
   map = acdb