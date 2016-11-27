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
	
	public HuffmanNode()
	{
		
	}
	
	public HuffmanNode(char key, int value)
	{
		character = key;
		frequency = value;
	}
	
	public char getCharacter()
	{
		return character;
	}
	
	public int getFrequency()
	{
		return frequency;
	}
	
	public void increment()
	{
		frequency++;
	}
	
	public void print()
	{
		System.out.println("Character: " + character + " Frequency: " + frequency);
	}
}
