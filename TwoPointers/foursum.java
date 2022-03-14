/*
Given an array S of n integers, are there elements a, b, c d in S 
such that a + b + c + d= target 
Find all unique quadruplets 
*/
import java.util.*;

public class foursum 
{ 
        
    //This method use two pointer to find. O(n) is n2log(n).
    private static ArrayList<Integer> mysolution2(int[] num, int target)
    {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        //if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            //if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
            //if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
            //if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
            for(int j=i+1; j<num.length-2; j++){
                //if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
                //if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
                //if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        result.add(num[i]);
                        result.add(num[j]);
                        result.add(num[low]);
                        result.add(num[high]);
                        System.out.println(num[i]);
                        System.out.println(num[j]);
                        System.out.println(num[low]);
                        System.out.println(num[high]);
                        //result.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        //while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
                        //while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
                        low++; 
                        high--;
                    }
                    //move window
                    else if(sum<target)low++; 
                    else high--;
                }
            }
        }
        
        return result;   
        
    }//solution2 end.    
  
    public static void main (String[] args) 
        {
        int[] list = {-1, 0, 1, 2, -4, 4};
            ArrayList<Integer> myresult = mysolution2(list, 0);            

            System.out.println("");
            /*
        for (int x:  myresult)
            {
                for (int y =0; y<myresult.size(); y++)
                {                    
                    System.out.println(x);           
                }
            }
            */
        }
}
            
          