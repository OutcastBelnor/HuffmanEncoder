package huffmanEncoder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author outca_000
 *
 */
public class FileHandler
{
	private Scanner fileReader;
	
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
		
		fileReader.close();
		
		return text;
	}
}
