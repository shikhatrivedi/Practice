package packagerun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RunIt {
		public static void main(String args[])
		{
			GetFile gt=new GetFile();
			String file = gt.func();

			String output="./output.txt";		
			try(FileReader fr=new FileReader(file); 
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(output);	
				BufferedWriter bw = new BufferedWriter(fw);
					){
				ArrayList<String> al=new ArrayList<>();
				String statement;
				while((statement = br.readLine())!=null)
				{
					al.add(statement);
				}
				
				// Procedure call to calculate the percentage of letters usage
				String str="";
				List<Entry<Character, Float>> list = CalAlpha.prvdPer(al);
				for(Map.Entry<Character, Float> entry:list){
					str="The character '"+entry.getKey()+"' occurs "+entry.getValue()+"% in the file";
					bw.write(str);
					bw.newLine();
		            }
		   }
			catch(FileNotFoundException e)
			{
				System.out.println("The file to be read is not found");
			} catch (IOException e1) {
				System.out.println("Error occured in dealing with files");
				e1.printStackTrace();
			}
		}
}
