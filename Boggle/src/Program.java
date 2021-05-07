import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Boggle, by Toby");
		
		WordList wordList = new WordList("WordList.txt", 3, 8);
		
		// wordList.Dump();
		
		Board board = new Board(wordList, 4);
		
		System.out.println(board);
		
		List<String> result = board.find();
		
		System.out.println("\nFound " + result.size() + " word(s)");
		
		int currentLength = 0;
		
		for (int i=0;i<result.size();i++){
			String word = result.get(i);
			if (word.length() != currentLength)
			{
				currentLength = word.length();
				System.out.println("\n" +  currentLength +  " letter words");
			}
			
			System.out.println(word);
		}
		
	}

}
