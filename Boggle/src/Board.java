import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Board {
	
	private char[][] matrix;
	
	private WordList wordList;

	
	public Board(WordList wordList, int size)
	
	{	
		this.wordList = wordList;
		
		this.matrix = new char[size][size];
		
		//populate the array with random letters from random words in the list
		for (int i = 0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				Random random = new Random();
				
				String word = this.wordList.get(random.nextInt(this.wordList.size()));
				
				char letter = word.charAt(random.nextInt(word.length()));
				
				matrix[i][j] = letter;
			}
		}
	}

    // Display the Board
	public String toString(){
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i<this.matrix.length; i++){
			for (int j=0; j<this.matrix.length; j++)
			{
				stringBuffer.append(matrix[i][j]);
				
				if (j!=this.matrix.length -1)
				{
					stringBuffer.append(" ");
				}
			}
			
			stringBuffer.append("\n");
		}
		
		return stringBuffer.toString();
	}
	
	public ArrayList<String> find(){
		ArrayList<String> result =  new ArrayList<String>();
		
		for (int i=0; i<this.matrix.length; i++)
		{
			for (int j=0; j<this.matrix.length; j++)
			{
				ArrayList<String> temp = find(i, j, new ArrayList<Integer>());
				
				// System.out.println(i + " " + j + " " + temp.size());
				
				for (int m=0;m<temp.size();m++)
				{
					// System.out.println(i + " " + j + " " + temp.get(m));
				    if(this.wordList.contains(temp.get(m)))
						result.add(temp.get(m));
				}
				
			}
		}
		
		// System.out.println(result.size());
		
		//Sort the results, ordered by length, and then alphabetically within length
		Collections.sort(result,new WordComparator());
		
		 // get rid of any duplicates in the list
        // do it backwards to simplify  removals 
        
        for (int i = result.size() - 2; i >= 0; i--) {
             if (result.get(i).equals(result.get(i + 1))) {
                 result.remove(i + 1);
             }
        }
		
		// System.out.println(result.size());
		
		return result;
	}
	
	// internal method that accepts additional parameters to implement the recursion successfully,
	private ArrayList<String> find(int i, int j, ArrayList<Integer> history)
	{
		ArrayList<String> result = new ArrayList<String>();
		String self = String.valueOf(matrix[i][j]);
		
	    result.add(self);
	    
	    // This means the program has reached the maximum length words and do not need to search further
	    if (history.size() + 1 == this.wordList.getLongestWordLength())
	    {
	    	return result;
	    }
		
		ArrayList<Integer> copyHistory = new ArrayList<Integer>();
		
		//Create a new breadcrumbs object to pass into the recursive loop 
		copyHistory.addAll(history);
		copyHistory.add(new Integer(i*this.matrix.length + j));
		
		//search the neighbors 
		for (int m=i-1; m<=i+1;m++)
			for (int n=j-1; n<=j+1; n++)
			{
				// If outside of bound, skip
				if (m<0||m>=this.matrix.length||n<0||n>=this.matrix.length) continue;
				
				// If this has been visited includes itself, skip
				if (copyHistory.contains(new Integer (m*this.matrix.length + n))) continue;
				
				ArrayList<String> temp = find(m, n, copyHistory );
				
				for (int item = 0; item<temp.size(); item++){
						result.add(self+ temp.get(item));
				}
			}
		
		return result;
	}
}
