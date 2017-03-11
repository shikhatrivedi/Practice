package packagerun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CalAlpha {
	public static List<Entry<Character, Float>> prvdPer(ArrayList<String> al)
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
		
		HashMap<Character, Float> map1 = new HashMap<>();
		
		Set<Entry<Character, Integer>> set = map.entrySet();
        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<Character, Integer>>()
        {
            public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        int i=1;
        
        for(Map.Entry<Character, Integer> entry:list){
			if(i<5){
			map1.put(entry.getKey(),((float)entry.getValue()/sum)*100);
		    i++;
			}
        }
        Set<Entry<Character, Float>> set1 = map1.entrySet();
        List<Entry<Character, Float>> list1 = new ArrayList<Entry<Character, Float>>(set1);
        
        return list1;
	}
}
