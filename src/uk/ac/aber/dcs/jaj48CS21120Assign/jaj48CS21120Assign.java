package uk.ac.aber.dcs.jaj48CS21120Assign;
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
	}

	/**
	 * This is the core method in the program.
	 * @throws FileNotFoundException
	 */
	private void runApp() throws FileNotFoundException
	{
		System.out.print("####################### Huffman Scheme Encoder #######################\n\n" +
				"This program can read in the file, encode in the Huffman scheme and\nprint the statitics of the process.\n");
		String choice;
		do
		{
			printMenu();
			
			choice = in.next
					().toUpperCase();
			switch(choice)
			{
				case "1":
					readFile();
					break;
					
				case "2":
					printFile();
					break;
					
				case "3":
					encode();
					break;
					
				case "4":
					displayDictionary();
					break;
					
				case "5":
					displayStats();
					break;
					
				case "Q":
					break;
			}
		} while (!choice.equals("Q"));
		
		in.close();
	}

	/**
	 * This method prints the menu.
	 */
	private void printMenu()
	{
		 System.out.println("\n1. Read in from the file.\n" +
					"2. Print the text\n" +
					"3. Encode the text\n" +
					"4. Display the dictionary\n" +
					"5. Statistics\n" +
				 	"Q. Quit\n");
	}

	/**
	 * This method reads data from file.
	 * @throws FileNotFoundException 
	 */
	private void readFile()
	{
		dictionary = new Dictionary();
		text = "";
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
	 *  This method prints the contents of the file.
	 */
	private void printFile()
	{	
		if (text != "")
		{
			System.out.println("\n\n" + text + "\n");
		}
		else
		{
			System.out.println("No file scanned!");
		}
	}

	/**
	 *  This method encodes the dictionary based on the file.
	 */
	private void encode()
	{
		if (dictionary != null)
		{
			System.out.println("Encoding sequence starting...");
			
			dictionary.createATree(text);
			
			System.out.println("Dictionary created.");
		}
		else
		{
			System.out.println("Dictionary wasn't encoded yet!");
		}
	}

	/**
	 *  This method prints the dictionary.
	 */
	private void displayDictionary()
	{
		if (dictionary != null)
		{
			dictionary.print();
		}
		else
		{
			System.out.println("Dictionary wasn't encoded yet!");
		}
	}
	
	/**
	 *  This method displays the statistics of encoding process.
	 */
	public void displayStats()
	{
		if (dictionary != null)
		{
			dictionary.stats();
		}
		else
		{
			System.out.println("Dictionary wasn't encoded yet!");
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		jaj48CS21120Assign app = new jaj48CS21120Assign();
		app.runApp();
	}
}
