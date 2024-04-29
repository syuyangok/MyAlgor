
// find a min substring in s, which will cover all the letters in t
//it's similar to validate Anagram, and findAnagram
class Solution {
    public String minWindow(String s, String t) {
	
		int n = s.length();
		int m = t.lenght();	
		int ret = n ;
	
		//safe check
		if(n<m) return ret;
	
		int[] arr = new int[60];
	
		//put all t in arr
		for(int i=0; i<m; i++){
			arr[t.charAt(i) - 'A'] ++;
			arr[s.charAt(i) - 'A'] --;
		
		}
		if(areAllZero(arr)) return arr.length;
		
		int left = 0;
		for(int right=m; right<n; right++){
			arr[s.charAt(right) - 'A'] --;			
			
			while(areAllZero(arr){				
				//move start to left
				ret = Math.min(ret, right-left+1);
				arr[s.charAt(left)-'A']++;
				left++;				
			}
			
		}
	
		return ret;
	}
	
	public boolean areAllZero(int[] arr){
		for(int i : arr){
			if(i>0) return false;
		}
		return true;
	}
	
}