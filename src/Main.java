import java.io.IOException;


//import au.com.bytecode.opencsv.CSVReader;
public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileManager csv=new FileManager();
		
		csv.readListOfFiles();
		csv.readFile();
	//	csv.tk.displayTokens();
		csv.writeTokensToFile(csv.tk.tokensMap);
		csv.matcher.longestSequence(csv.it);	//csv.it.intTokenList was supposed to be passed but since I need csv.it object in caller so im passing it
		csv.writeMatchesToFile(csv.matcher.resultMap,csv.it);
	    System.out.println("\nProgram Ends ");
	 	 
	}//main ends
	
}//class ends
