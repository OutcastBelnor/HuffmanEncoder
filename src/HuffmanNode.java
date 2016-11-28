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
	
	private HuffmanNode left;
	private HuffmanNode right;
	
	
	/**
	 * A basic constructor.
	 */
	public HuffmanNode()
	{
		
	}
	
	/**
	 * This is a constructor for standard HuffmanNode for the first priority
	 * queue.
	 * 
	 * @param key
	 * @param value
	 */
	public HuffmanNode(char key, int value)
	{
		character = key;
		frequency = value;
	}
	
	public HuffmanNode(char key, int value, HuffmanNode leftNode, HuffmanNode rightNode)
	{
		this(key,value);
		left = leftNode;
		right = rightNode;
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
