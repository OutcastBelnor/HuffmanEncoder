import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Jakub Janas
 *
 */
public class jaj48CS21120Assign
{
	private static Scanner in;
	private HashMap hashMap;
	private String text;
	private BinaryTree binaryTree;

	public jaj48CS21120Assign() throws FileNotFoundException
	{
		in = new Scanner (System.in);
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
					System.out.println("\n\n" + text + "\n");
					break;
					
				case "3":
					Encode();
					break;
					
				case "Q":
					break;
			}
		} while (!choice.equals("Q"));
		
		//System.out.print(text.length());
		//System.out.print(toString(text[1]));
//		char[] c_array = text.toCharArray();
//		System.out.println(c_array);
		
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
				 	"Q. Quit\n");
	}

	/**
	 * This method reads data from file.
	 * @throws FileNotFoundException 
	 */
	private void readFile()
	{
		text = "";
		while (text == "")
		{
			System.out.println ("Specify the path to the file:");
			String fileName = in.next();
			
			Scanner fileReader;
			try
			{
				fileReader = new Scanner (new FileReader(fileName));
				text = fileReader.useDelimiter("\\Z").next();
			}
			catch (FileNotFoundException fnfe)
			{
				System.out.print ("File not found. ");
			}
		}
	}
	
	private void Encode()
	{
		System.out.println("Encoding sequence starting...");
		
		binaryTree = new BinaryTree();
		binaryTree.createATree(text);
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		jaj48CS21120Assign app = new jaj48CS21120Assign();
		app.runApp();
	}
}
