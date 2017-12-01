import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringMatcher {

    ArrayList <LineToken> tokenList=new ArrayList<LineToken>(); 	//Used to save tokens in readFile class function
 //   ArrayList <ArrayList<String>> resultSequences=new ArrayList<ArrayList<String>>();
    ArrayList <Integer> indexes=new ArrayList<>();
	int [][] L;
	LinkedHashMap <ArrayList<Integer>,Integer> resultMap=new LinkedHashMap <ArrayList<Integer>,Integer>();
    
  
	  /* Utility function to get max of 2 integers */
	  int max(int a, int b)
	  {
	  	return (a > b)? a : b;
	  }
	  
	  public int[][] longestSequenceLength(ArrayList<Integer>  A, ArrayList<Integer>  B)
		{
			int m= A.size();
			int n=B.size();
			L=new int[m+1][n+1];
			
			//To calculate length of common sequence and populate array L 
			for (int i = m-1; i >= 0; i--)
		    	for (int j = n-1; j >= 0; j--)
		    {
		    		if (i == A.size() || j==B.size())
		    			L[i][j] = 0;
		    	
		    		else if (A.get(i) == B.get(j)) 
		    			L[i][j] = 1 + L[i+1][j+1];
		    		
		    		else
		    			L[i][j] = max(L[i+1][j], L[i][j+1]);
		    }
			return L;
			
		}
		public ArrayList<Integer> longestSequenceInt(ArrayList<Integer>  A, ArrayList<Integer>  B)
		{
			int m= A.size();
			int n=B.size();
			L=new int[m+1][n+1];
			L=longestSequenceLength(A,B);
			
			  
			
			// To find actual sequence and store it in seq variable
			ArrayList<Integer>  seq =new ArrayList<Integer>();
			indexes.clear();
			int i = 0;
		    int j = 0;
		  
		    while (i < m && j < n)
		    {
		    	
		    	if (A.get(i)==B.get(j))
		    	{
		    		seq.add(A.get(i));   //add A[i] to end of S;
		    		indexes.add(i);
		    		i++; j++;
		    		
			    
		    	}
		    	else if (L[i+1][j] >= L[i][j+1]) 
		    		i++;
		    	else
		    		j++;
		    }
		    System.out.print("\nLongest Sequence Represented as Integer:");
		    for (int it:seq)
		    	System.out.print(it+",");
		    
		    System.out.print("\nIndexes:");
		   
		    for(int itr:indexes)
		    	System.out.print(+itr+",");
		    System.out.println();
		    
		    return seq;
		}

		public LineTokenInt longestSequence(final IntegerTokens csv_it)	//ArrayList <LineTokenInt> intTokens
	    {
		  
	  //    System.out.println("\nToken List Size:"+csv_it.intTokenList.size());
	      LineTokenInt tObj,tObj2;
		
	 	  ArrayList<Integer> resSeqInt =new ArrayList<Integer>();
		  for (int i = 0; i < csv_it.getIntTokenList().size(); i++) 		 
		  { 
			//  LinkedHashMap <ArrayList <Integer>,Integer> tempMap=new LinkedHashMap <ArrayList <Integer>,Integer>();
			  for (int j = i+1; j < csv_it.getIntTokenList().size(); j++)
			  {  
				  	System.out.print("\nComparing "+i+" with "+j);
				  	
				  	tObj = new LineTokenInt(csv_it.getIntTokenList().get(i).tok);
			     	tObj2 = new LineTokenInt(csv_it.getIntTokenList().get(j).tok);
			     	csv_it.convertIntToString(tObj.tok);csv_it.convertIntToString(tObj2.tok);
			     	
			     	resSeqInt= longestSequenceInt(tObj.tok,tObj2.tok);
			     	csv_it.convertIntToString(resSeqInt);
			       // ArrayList<ArrayList<Integer>> tempList=findSubSequences(new LineTokenInt(resSeqInt));
			     
			    	System.out.println("Common Sequence: "+csv_it.convertIntToString(resSeqInt));    //comment it later     
			  }
			}
		  	LineTokenInt ret=new LineTokenInt(resSeqInt);
		  	return ret;	
		  }
	    			 
	    public ArrayList <ArrayList <Integer>> findSubSequences(LineTokenInt obj)
	    {
	    	
	    	  int k=0; 
	    	  ArrayList<ArrayList <Integer>> tempList=new ArrayList<ArrayList<Integer>>();
	          ArrayList<Integer> temp=new ArrayList<Integer>();
	          
			//  System.out.print("Indexes length:"+indexes.size());
			  while(k < indexes.size()-1)
			  {
				  if(indexes.get(k+1)-indexes.get(k)==1)
			      { 
			     	 temp.add(obj.tok.get(k));
			     	 k++;
			     	 if(k==indexes.size()-1)
			     	 {	
			     	    temp.add(obj.tok.get(k));  //to add last matching element (k+1 th)	
			     		
			     	    saveSubsequences(temp);
			     	    
			     	 }
			     			 
			      }
			      else if (indexes.get(k+1)-indexes.get(k)> 1)	//new subsequence begins here
			      {
			    	  temp.add(obj.tok.get(k));
			    	  tempList.add(temp);
			     	  saveSubsequences(temp);
			     	
			     	  //temp.clear();							//This wont work
			     	  temp=new ArrayList<Integer>();			//becauase put uses reference to key so we need to create new always
			     	  k++;
			     	  
			     	  if(k==indexes.size()-1)
			     	  {	
			     		 temp.add(obj.tok.get(k));  //to add last matching element (k+1 th)
			     		 saveSubsequences(temp);
			     	  }
			     			 	
			      }//else if ends
			     			
			    }//while ends
			  		
			       return  tempList;
	    	}
			   
	
    
  void  displaySequences()
  {
	  for (Map.Entry<ArrayList<Integer>, Integer> ent : resultMap.entrySet())
		{
			ArrayList<Integer> key = ent.getKey();
		    Integer value = ent.getValue();
		    System.out.println("Key-"+key+"\nValue-"+value+"\n\n");
		}
	
  }
  

  public void saveSubsequences(ArrayList <Integer> temp)
  {	
		
	 		if(temp.size()>1)
			{   ;
				 if(resultMap.containsKey(temp))
				  {  
					 resultMap.put(temp, resultMap.get(temp)+1);//previous count+1
				  }
				  else
				  {
					 // System.out.println("\nSaving this:"+temp);
					  resultMap.put(temp, 1);
				  }   
			}
		
			/***Printing*******/
		//	System.out.print("\nMap Size:"+resultMap.size()+"\n");
  	 	

  }
void  displaySubsequences(IntegerTokens csv_it)
{
	 System.out.println("Printing subsequences\n");			   
	 
	  for (Map.Entry<ArrayList<Integer>, Integer> ent : resultMap.entrySet())
		{
			ArrayList<Integer> key = ent.getKey();
		    Integer value = ent.getValue();
		    ArrayList <String> list=csv_it.convertIntToString(key);
		    System.out.println("Value-"+value+"\n\n");
		    System.out.print("Key-");
		    for(String s:list)
		    	System.out.print(s);
		}
	
}

  
}
