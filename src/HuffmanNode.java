/**
<<<<<<< HEAD
 * @author outca_000
=======
 * @author Jakub Janas
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
 *
 */
public class HuffmanNode
{
	private char character;
	private int frequency;
	
<<<<<<< HEAD
	public HuffmanNode()
	{
		
	}
	
	public HuffmanNode(char key, int value)
	{
		character = key;
		frequency = value;
=======
	public HuffmanNode(char charact, int number)
	{
		character = charact;
		frequency = number;
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
	}
	
	public char getCharacter()
	{
		return character;
	}
	
	public int getFrequency()
	{
		return frequency;
	}
<<<<<<< HEAD
=======
	
	public void increment()
	{
		frequency++;
	}
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
}
