package packagerun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class CalAlpha {
	public static void prvdPer(ArrayList<String> al)
	{
		String stmt="";
		
		Iterator<String> it=al.iterator();
		while(it.hasNext())
		{
			stmt = stmt + it.next();
		}
		
		
		
		
		
		
		
		//Get the statement ready for analysis
		String s=stmt.toLowerCase();
		s=s.replace(" ","");
		char c[]=s.toCharArray();
		
		//Calculate the number of times a character is used and put counts in a MAP
		HashMap<Character, Integer> map = new HashMap<>();
		for(Character ch:c)
		{
			if(map.containsKey(ch))
			{
				int i=map.get(ch);
				i=i+1;
				map.replace(ch,i);
			}
			else
			{
				map.put(ch,1);
			}
		}
		
		int sum=map.values().stream().mapToInt(Number::intValue).sum();
		int len = map.size();
		int ar[] = new int[len];
		int i=0;
		String str="";
		for (Character key: map.keySet())
		{
			str=map.get(key)+""+Character.getNumericValue(key);
			ar[i]=Integer.parseInt(str);
			i++;
		}
		
		//Sort the values
		Arrays.sort(ar);
		String str1="",str2="";
		float srt[]= new float[4];
		int charac;
		char chtr[]=new char[4];
		
		for(int a:ar)
		{
			System.out.println(a);
		}
		
		for (int z=len-1,y=0;z>len-5&&y<=3;z--,y++)
		{
			str1=Integer.toString(ar[z]);
			len=str1.length();
		    //Calculate percentage
		    srt[y]=Integer.parseInt(str1.substring(0,len-2));
			srt[y]=(srt[y]/sum)*100;
			System.out.println(srt[y]);
			
			//Retrieve the character
			charac=Integer.parseInt(str1.substring(len-2,len));
			str2 = Integer.toHexString(charac);
			chtr[y]=str2.charAt(0);
			System.out.println(chtr[y]);
			
		}
		
	}
}
