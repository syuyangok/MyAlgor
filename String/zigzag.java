/*
Write the code that will take a string and make this conversion given a number of rows: 
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
P   A   H   N
A P L S I I G
Y   I   R

*/

import java.util.*;
import java.lang.Math;


public class zigzag 
{


	public static String mysolution(String s, int numRows) 
	{
		if(numRows<=1)
		{
			return s;
		}

		StringBuilder[] ns = new StringBuilder[numRows]; 
		int idx =0;
		int i =0;
		int inc = 0;
		
		// initial array;
		for (idx=0; idx < numRows; idx++)
		{
			ns[idx] = new StringBuilder("");

		}

		idx =0;

		// build string
		for (i=0; i < s.length(); i++ )
		{
			ns[idx].append(s.charAt(i));
			

			if (idx ==0)//point to change 
			{
				inc = 1;
			}
			if (idx == numRows-1)//point to change
			{
				inc = -1;
			}

			idx += inc;
		}

		// concetate to one string
		for (i =1; i < numRows; i++)
		{
			ns[0].append(ns[i]);
		}

		return ns[0].toString();
	}//solution end

	public static void main(String args[])
	{
		String ss = "PAYPALISHIRINGGGG";
		System.out.println(mysolution(ss, 3));

	}

}
