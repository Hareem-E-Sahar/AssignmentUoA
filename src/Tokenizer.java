import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	
	
	int count=0;
	float score;
	int index=0;
	HashMap < ArrayList <String>,Integer> tokens=new HashMap< ArrayList <String>,Integer>(); // stores all tokens
	Filing f;
		
	public ArrayList tokenize(String str) throws IOException	{
		
		int noOfTokens=0;
		ArrayList <String> tokenList=new ArrayList<String>();   

	   	final String regex = "[\\w--]+|[\\w++][a-zA-Z]+|\\\\d+|[\\\\^$.|?<>;=]|[()]+|[\\{}]+|[++]+|[--]+\n\n\n";	
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(str);

		while (matcher.find()) 
		{ 
			tokenList.add(matcher.group(0));	//list of tokens generated from a single line of source code 
			System.out.println("Token:" + matcher.group(0));
		} 
			noOfTokens=tokenList.size();
			System.out.println("Number of Tokens:"+noOfTokens);
			return tokenList;
	}



	public void populateHashMap(){
		
		f=new Filing();
		f.readListOfFiles();
		f.readFile();	
		int i=0;
		
		while(i<f.fileContents.size()){
			try {
				 
				System.out.println("File contents :"+f.fileContents.get(i));	
				count=Collections.frequency((Collection<?>) f.fileContents, f.fileContents.get(i));
				tokens.put(tokenize(f.fileContents.get(i)),count); //or tokens.put(f.fileContents.get(i))
			
			} catch (IOException e) {
				System.out.println("Tokenize called in longestCommonSequences");
				e.printStackTrace();
			}
			i++;
		}
		
		/*
		count=0;
		score=ScoreCalculator.calculateScore(2, 2);
		System.out.println("Update count and score here:"+count+" "+score);
		*/
		
	}
	public void longestCommonSequences()
	{ 
		/*Iterable<Entry<ArrayList<String>,Integer>> entries= tokens.entrySet();
		
		while(entries.iterator().hasNext())
		{
			Entry ent=(Entry) entries.iterator().next();
			ArrayList<String> temp=(ArrayList<String>) ent.getKey();
			System.out.println("temp entry::******"+temp);
			
		}*/
	
			
		
	}
	void displayHashMap()
	{
		for (Map.Entry<ArrayList<String>, Integer> ent : tokens.entrySet())
		{
			ArrayList<String> key = ent.getKey();
		    Integer value = ent.getValue();
		    System.out.println("Key-"+key+"\nValue-"+value+"\n\n");
		}
		
	}

}