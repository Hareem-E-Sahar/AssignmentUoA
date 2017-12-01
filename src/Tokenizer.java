import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	 HashMap <ArrayList<String>,Integer> tokensMap=new HashMap<ArrayList<String>,Integer>();
	
	public static ArrayList<String> tokenize(String string) throws IOException {
		ArrayList<String> tok = new ArrayList<>(0);
		final String regex = "[\\w--]+|[\\w++][a-zA-Z]+|\\\\d+|[\\\\^$.|?<>;=]|[()]+|[\\{}]+|[++]+|[--]+\n\n\n"; //regex Expression	
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(string);

		int i = 0;
		while (matcher.find()) {
			tok.add(matcher.group(0)); // tokenArray.add(matcher.group(0));
			// System.out.println("Count: " + matcher.group(0));
			i++;
		}
		
		return tok;
	}

public 	void displayTokens()
	{
		//Traversing Map
		//System.out.println("Display Tokens function executing\n");
		for (Map.Entry<ArrayList<String>, Integer> entry : tokensMap.entrySet())
		{
		    ArrayList<String> key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println("Key-"+key+"\nValue-"+value+"\n\n");
		}
	}
  public void saveTokens(ArrayList<String> token)
  {
	  if(tokensMap.containsKey(token))
	  {
		  tokensMap.put(token, tokensMap.get(token)+1);//previous count+1
	  }
	  else
	  {
		  tokensMap.put(token, 1);
	  }
  }
	
}
