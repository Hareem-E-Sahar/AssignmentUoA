import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileManager {
	
	String input=null;
	ArrayList <String> fileList=new ArrayList <String>();  
	StringMatcher matcher=new StringMatcher();
	IntegerTokens it=new IntegerTokens();
	Tokenizer tk=new Tokenizer();
	
	public void readFile()
	{
		for(String filename:fileList)
		{	System.out.println("File:"+filename);
		try{
			FileReader fr=new FileReader(filename);
			BufferedReader inStream = new BufferedReader(fr);
		
			while((input=inStream.readLine())!=null)	//read till end of file
			{
				LineToken line=null;
			//	System.out.println("\nInput read:"+input+"\n");
				if((input.length())> 0){
					
					line=new LineToken(Tokenizer.tokenize(input));
					matcher.tokenList.add(line);
					tk.saveTokens(line.tok);
				}
			}
			
			
			
			//Printing Input string as a string of integers where each integer
			// value corresponds a token
		/*	System.out.print("\nInteger representation of input string:");
			for(int c=0;c<it.getIntTokenList().size();c++)
			{  
				System.out.print("\nNew Token "+c+": ");
				LineTokenInt t=it.getIntTokenList().get(c);
				for(int j: t.tok)
					System.out.print(+j+",");
				
			}
		*/	
			fr.close();
		}catch(IOException e){
				e.printStackTrace();
		}
		
		}
	}	
	
	
	////********This function creates a file named Tokens.csv and writes to it******///

	public void writeTokensToFile(HashMap <ArrayList<String>,Integer> tokenList)
	{
		
		File filename=null;
		FileWriter fw=null;
		try {

			filename=new File("Tokens.csv");
			filename.createNewFile();
			fw=new FileWriter(filename);
			//System.out.println("RESULT:"+tok.size());
			
			Integer value=0;
			ArrayList<String> key=new ArrayList<String> ();
			for (Map.Entry<ArrayList<String>, Integer> entry : tokenList.entrySet())
			{
			    key = entry.getKey();
			    value = entry.getValue();
			    Integer numTokens=key.size();
			    Double score=ScoreCalculator.calculateScore(numTokens, value);
			   
			    fw.append(score.toString());			//score = log2(numTokens) * log2(count), 
			    fw.append(",");
			    fw.append(numTokens.toString());		//number of tokens of string
			    fw.append(",");
			    fw.append(value.toString());		//value is count or occurrence of string in files
			    fw.append(",");
			    for(String str:key)
				{
					fw.append(str);
					fw.append(",");
					
				}
				
				fw.append("\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Exception while opening output file");
			e.printStackTrace();
		}//for ends
		it.findUniqueTokens(matcher.tokenList);
		
		for(LineToken t:matcher.tokenList)
	    	it.getIntTokenList().add(it.convertStringToInt(t));
		
	}
	


	////********This function creates a file named Matches.csv and writes to it******///
	
	public void writeMatchesToFile(final LinkedHashMap <ArrayList<Integer>,Integer> matches,IntegerTokens csv_it)
	{
		
		File filename=null;
		FileWriter fw=null;
		try {

			filename=new File("Matches.csv");
			filename.createNewFile();
			fw=new FileWriter(filename);

			Integer value=0;
			ArrayList<Integer> tempKey;
			System.out.println("size:"+matches.size());
			for (Map.Entry<ArrayList<Integer>, Integer> entry : matches.entrySet())
			{
			    tempKey = entry.getKey();
			    ArrayList<String> key= csv_it.convertIntToString(tempKey);
			    Integer numOfTokens=key.size();
			    value = entry.getValue();			//count

			    Double score=ScoreCalculator.calculateScore(value,numOfTokens);
			   
			    fw.append(score.toString());		//score = log2(count), 
			    fw.append(",");
			    fw.append(numOfTokens.toString());	//number of tokens of string
			    fw.append(",");
			    fw.append(value.toString());		//value is count or occurrence of sequence in files
			    fw.append(",");
			    for(String str:key)
				{
			    	
			    	fw.append(str);
					fw.append(",");
					
				}
				
				fw.append("\n");
			}
			fw.close();

		} catch (IOException e) {
			System.out.println("Exception while opening output file");
			e.printStackTrace();
		}
		
	}


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
	

}
