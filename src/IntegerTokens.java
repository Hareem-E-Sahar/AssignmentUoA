import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntegerTokens {

	int counter=0;
	ArrayList <LineTokenInt> intTokenList=new ArrayList<>();
	HashMap<String,Integer> uniqueTokens=new HashMap<String,Integer>();
	
	public ArrayList<LineTokenInt> getIntTokenList() {
		return intTokenList;
	}

	public void setIntTokenList(ArrayList<LineTokenInt> intTokenList) {
		this.intTokenList = intTokenList;
	}
	
	
	public void findUniqueTokens(final ArrayList<LineToken> tokenList)
	{
		for(LineToken tk:tokenList)
		{
			for(String t:tk.tok)
				uniqueTokens.put(t,counter++);//counter;
		}
	}
	
	public LineTokenInt convertStringToInt( LineToken t)
	{
		ArrayList<Integer> temp=new ArrayList<Integer>();
		
			
			for(String s:t.tok)
			{
				temp.add(uniqueTokens.get(s));
				
			}LineTokenInt intTok=new LineTokenInt(temp);
		
		return intTok;
		
	}
	
	public ArrayList<String>  convertIntToString( ArrayList<Integer> temp)
	{
		
		ArrayList<String> tempStr=new  ArrayList<String>();
		for(int s:temp)
		{	
			tempStr.add(getKeyFromValue(s));
		}
		/*System.out.print(" String representation:");
		for(String s:tempStr)
			System.out.print(s+",");
		System.out.println();*/
		return tempStr;
	}
	
	void displayHashMap()
	{
		for (Map.Entry<String, Integer> ent : uniqueTokens.entrySet())
		{
			String key = ent.getKey();
		    Integer value = ent.getValue();
		    System.out.println("Key-"+key+"\nValue-"+value+"\n\n");
		}
		
	}
	public String getKeyFromValue(int val) {
		for (Map.Entry<String, Integer> entry : uniqueTokens.entrySet())
		{
			   int value = entry.getValue();
			   if(val==value)
				   return entry.getKey();
			   
		}   return null;
		  
	}	
}	
