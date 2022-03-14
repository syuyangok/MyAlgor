/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5

*/

import java.util.*;
import java.lang.Math;


public class MedianSortedArrays 
{

	public static double mysolution(int[] nums1, int[] nums2) 
	{
		    
		int l=0; // set left and right pointer
		int r=1;
		double median =0;

		//set lengh
		int m = nums1.length;
		int n = nums2.length;
		
		int l1=0;
		int l2=0;
		int r1 =m-1;
		int r2 =n-1;
		//initail l r to min and max
		//l = Math.min(nums1[0], nums2[0]);
		//r = Math.max(nums1[r1], nums2[r2]);

		while(l<r)
		{

			if (l1>=m)// run out l1
			{
				l = nums2[l2];
				l2++;
				System.out.println("Left: " + l);


			}
			else if(l2>=n)//run out l2
			{
				l = nums1[l1];
				l1++;
				System.out.println("Left: " + l);
				
			}
			else// have both l1, l2
			{
				if (nums1[l1] < nums2[l2])
				{
					l = nums1[l1];
					l1++;
					System.out.println("Left: " + l);
				
				}
				else 
				{
					l = nums2[l2];
					l2++;
					System.out.println("Left: " + l);
				}
			}
			//deal with right
			if (r1 < 0)//run out r1;
			{
				r = nums2[r2];
				r2--;
				System.out.println("Right: " + r);
				
			}
			else if(r2 <0)//rout out r2
			{
				r = nums1[r1];
				r1--;
				System.out.println("Right: " + r);
			}
			else//have both r1,r2
			{						
				if (nums1[r1] < nums2[r2])
				{
					r = nums2[r2];
					r2--;
					System.out.println("Right: " + r);
				
				}
				else 
				{
					r = nums1[r1];
					r1--;
					System.out.println("Right: " + r);
				}
			}
		}
		
		
		if (l==r)
		{
			median = l;
		}
		else
		{
			median =(double)(l+r)/2;

		}

		return median;

	}//solution end

	public static void main (String args[])
	{
		int[] nums1 = {1, 2,7,10};
		int[] nums2 = {3, 5,6};

		double result = mysolution(nums1, nums2);
		System.out.println("Result: " + result);

	}

};
