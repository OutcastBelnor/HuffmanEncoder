package uk.ac.aber.dcs.jaj48CS21120Assign;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author outca_000
 *
 */
public class FileHandler
{
	Scanner fileReader;
	
	/**
	 * Constructor for FileHandler class.
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public FileHandler(String fileName) throws FileNotFoundException
	{
		fileReader = new Scanner (new FileReader(fileName));
	}
	
	/**
	 * This method reads from the file.
	 * @return
	 */
	public String readFile()
	{
		String text = fileReader.useDelimiter("\\Z").next();
		
		return text;
	}
}
