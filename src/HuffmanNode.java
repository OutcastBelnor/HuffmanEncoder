/**
 * @author Jakub Janas
 *
 */
public class HuffmanNode
{
	private char character;
	private int frequency;
	
	public HuffmanNode(char charact, int number)
	{
		character = charact;
		frequency = number;
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
}
