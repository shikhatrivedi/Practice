package packagerun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunIt {
		public static void main(String args[])
		{
			//Read from file
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the file name to be read : ");
			String file = "C:\\Users\\Nidhi\\Documents\\"+scanner.next()+".txt";
						
			try(FileReader fr=new FileReader(file); BufferedReader br = new BufferedReader(fr);){
				
				ArrayList<String> al=new ArrayList<>();
				String statement;
				while((statement = br.readLine())!=null)
				{
					al.add(statement);
				}
				// Procedure call to calculate the percentage of letters usage
				CalAlpha.prvdPer(al);
			
			}
			catch(FileNotFoundException e)
			{
				System.out.println("The file to be read is not found");
				//e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			scanner.close();
		}
}
