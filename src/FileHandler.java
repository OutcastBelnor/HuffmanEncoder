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
	
	public FileHandler(String fileName) throws FileNotFoundException
	{
		fileReader = new Scanner (new FileReader(fileName));
	}
	
	public String readFile()
	{
		String text = fileReader.useDelimiter("\\Z").next();
		
		return text;
	}
}
