/*
Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 100
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer
*/

import java.util.*;
import java.lang.Math;


public class longPal 
{
	//global varialbe to keep update maxlen and start position.
	private int lo=0;
	private int maxlen=0;

	public String mysolution(String s) 
	{

		if (s.length()<2)
		{
			return s;

		}

		
	
		for (int i =0; i < s.length()-1; i++)//repeat check from middle 
		{
			
			findPal(s, i, i);// if Pal in (aba)mode
			findPal(s, i, i+1);// if Pal in (aabb)mode
		}

		return s.substring(lo, lo+maxlen);
	}//solution end

	private void findPal(String s, int l, int h)
	{
		while (l>=0 && h<s.length() && s.charAt(l)== s.charAt(h))//check boundary and if charL ==charH
		{
			l--;//check previous
			h++;//check next			
			
		}

		//check max length pal
		if (h-l-1 > maxlen)
		{
			maxlen = (h-l-1);
			lo = l+1;
			System.out.println(s.substring(lo, lo+maxlen));
		}


	}






}
