package huffmanEncoder;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @author Jakub Janas
 *
 */
public class jaj48CS21120Assign
{
	private Scanner in;
	private String text;
	private Dictionary dictionary;

	public jaj48CS21120Assign() throws FileNotFoundException
	{
		in = new Scanner (System.in);
		text = "";
		dictionary = new Dictionary();
	}

	/**
	 * This is the core method in the program.
	 * @throws FileNotFoundException
	 */
	private void runApp() throws FileNotFoundException
	{
		readFile();
		encode();
		displayStats();
		
		print();
		
		in.close();
	}
	
	/**
	 * This method reads data from file.
	 * @throws FileNotFoundException 
	 */
	private void readFile()
	{
		while (text == "")
		{
			System.out.println ("Specify the path to the file:");
			String fileName = in.next();
			
			try
			{
				FileHandler file = new FileHandler(fileName);
				text = file.readFile();
			}
			catch (FileNotFoundException fnf)
			{
				System.out.println("File not found. ");
			}
		}
	}
	
	/**
	 *  This method encodes the dictionary based on the file.
	 */
	private void encode()
	{
		System.out.println("\nEncoding sequence starting...");
		
		dictionary.encode(text);
		
		System.out.println("Dictionary created.");
	}
	
	/**
	 *  This method displays the statistics of encoding process.
	 */
	private void displayStats()
	{
		System.out.println("\nCompression statistics:");
		dictionary.stats(text);
	}
	
	/**
	 * This method prints the entire dictionary.
	 */
	private void print()
	{
		String info = dictionary.toString();
		
		System.out.println(info);
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		jaj48CS21120Assign app = new jaj48CS21120Assign();
		app.runApp();
	}
}
