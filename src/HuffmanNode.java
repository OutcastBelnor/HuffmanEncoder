/**
 * @author outca_000
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
}
