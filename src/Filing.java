import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Filing {
	ArrayList <String> fileList=new ArrayList <String>();
	ArrayList <String> fileContents=new ArrayList<String>();
	
	void readListOfFiles()
	{
		try{
			FileReader fr=new FileReader("list.txt");
			BufferedReader inStream = new BufferedReader(fr);
			String str=null;
			int i=0;
			while((str=inStream.readLine())!=null)
			{
				fileList.add(str);
				i++;
			}
			fr.close();
			
		} 
		catch(IOException e)
		{
			System.out.println("Error in reading file list\n");
			e.printStackTrace();
		}
		for(String s:fileList)
		{
			System.out.println(s+"\n");
		}
		
	}
	
	public void readFile()
	{
		for(String filename:fileList)
		{	
			//System.out.println("File:"+filename);
			try{
				FileReader fr=new FileReader(filename);
				BufferedReader inStream = new BufferedReader(fr);
				String input=null;
				while((input=inStream.readLine())!=null)	//read till end of file
				{
					if((input.length())> 0){
						//System.out.println("\nInput read:"+input+"\n");
						fileContents.add(input);
						//int c=Collections.frequency((Collection<?>) fileContents, input);
						//System.out.println("Count of Input:"+c);
						//tk.tokenize(input);
						
					}
				}
				fr.close();
			}catch(IOException e){
					e.printStackTrace();
			}
		}
	}	
	
	public void  writeFile()
	{		
			
		File file=new File("output2.csv");
		FileWriter fw=null;
	    try {
			file.createNewFile();
			fw=new FileWriter(file,true);
			fw.append("scores");
			fw.append(',');
			fw.append("token");
			fw.append(',');
			fw.append("count");
			fw.append(',');
			fw.append("sourceCode");
			fw.append("\n");
		    fw.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("File Writing Exception");
			e1.printStackTrace();
		}


	}
	
	
}
