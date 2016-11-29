/**
 * @author Jakub Janas
 *
 */
public class HuffmanNode
{
	private String characters;
	private int frequency;
	
	private HuffmanNode left = null;
	private HuffmanNode right = null;
	
	private boolean checked = false;
	
	
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
	public HuffmanNode(String key, int value)
	{
		characters = key;
		frequency = value;
	}
	
	/**
	 * This is a constructor for priority queue used for creating a binary tree.
	 * @param key
	 * @param value
	 * @param leftNode
	 * @param rightNode
	 */
	public HuffmanNode(String key, int value, HuffmanNode leftNode, HuffmanNode rightNode)
	{
		this(key,value);
		left = leftNode;
		right = rightNode;
	}
	
	public String getCharacters()
	{
		return characters;
	}
	
	public int getFrequency()
	{
		return frequency;
	}
	
	public void increment()
	{
		frequency++;
	}
	
	public HuffmanNode getLeftNode()
	{
		return left;
	}
	
	public HuffmanNode getRightNode()
	{
		return right;
	}
	
	public void setLeftNode(HuffmanNode leftNode)
	{
		left = leftNode;
	}
	
	public void setRightNode(HuffmanNode rightNode)
	{
		left = rightNode;
	}
	
	public boolean isChecked()
	{
		return checked;
	}
	
	public void setChecked()
	{
		checked = true;
	}
	
	public void print()
	{
		System.out.println("Character: " + characters + " Frequency: " + frequency);
	}
}
