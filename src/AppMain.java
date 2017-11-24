import java.io.IOException;

public class AppMain {

public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filing f=new Filing();
    	Tokenizer tk=new Tokenizer();
  
		//tk.tokenize();
		
    	tk.populateHashMap();
    	tk.displayHashMap();
    	tk.longestCommonSequences();
    	System.out.println("Program Ends Successfully");
 	}

}
