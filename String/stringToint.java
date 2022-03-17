/*
Implement atoi to convert a string to an integer.
Attention:
1 handle various situation: while space, sign nondigit;
2 digit = index of char - '0';

*/

import java.util.*;
import java.lang.Math;


public class stringToint 
{


	public static int mysolution(String str)
	{
	
		int base = 0, sign =1, i =0;

		// if empty
		if (str.length() ==0)
		{
			return 0;
		} 

		// remove white 
		while (str.charAt(i) == ' ' && i < str.length())
		{
			i++;
		}

		// handle sign
		if (str.charAt(i) == '-')
		{
			 sign = -1;
			i++;
		}  
		else if (str.charAt(i) == '+') i++;

		for (; i < str.length(); i++)
		{
			//if no digit break
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
			{
				break;
			}

			// overflow
			if ( base > Integer.MAX_VALUE/10 || ( base == Integer.MAX_VALUE/10 &&  (str.charAt(i) - '0') >  Integer.MAX_VALUE%10 ))
			{
				if (sign ==1)
				{
					return Integer.MAX_VALUE;
				}
				else 
				{
					return Integer.MIN_VALUE;
				}
			}

			// add numbers
			base = base*10 +  (str.charAt(i) - '0');
		}

		return base*sign;

	}//solution end

	public static void main (String args[])
	{
		String s = "  -9808jhhjk";
		System.out.println(mysolution(s));

	}




}
