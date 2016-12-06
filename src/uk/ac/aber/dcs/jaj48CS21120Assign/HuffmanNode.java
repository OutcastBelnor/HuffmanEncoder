package uk.ac.aber.dcs.jaj48CS21120Assign;
/**
 * @author Jakub Janas
 *
 */
public class HuffmanNode
{
	private String characters;
	private int frequency;
	
	private HuffmanNode left;
	private HuffmanNode right;
	private HuffmanNode parent;
	
	private boolean checked = false;
	
	/** This is a constructor for standard HuffmanNode for the first priority
	 * queue.
	 * 
	 * @param key
	 * @param value
	 */
	public HuffmanNode(String key, int value)
	{
		characters = key;
		frequency = value;
		
		left = null;
		right = null;
		parent = null;
		checked = false;
	}
	
	/**
	 * This is a constructor for priority queue used for creating a binary tree.
	 * 
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
	
	/**
	 * This method returns characters.
	 * @return characters
	 */
	public String getCharacters()
	{
		return characters;
	}
	
	/**
	 * This method returns frequency.
	 * @return
	 */
	public int getFrequency()
	{
		return frequency;
	}
	
	/**
	 * This method returns left node.
	 * @return left
	 */
	public HuffmanNode getLeftNode()
	{
		return left;
	}
	
	/**
	 * This method returns right node.
	 * @return right
	 */
	public HuffmanNode getRightNode()
	{
		return right;
	}
	
	/**
	 * This method returns parent node.
	 * @return parent
	 */
	public HuffmanNode getParentNode()
	{
		return parent;
	}
	
	/**
	 * This method sets the parent node
	 * @param parentNode becomes parent
	 */
	public void setParentNode(HuffmanNode parentNode)
	{
		parent = parentNode;
	}
	
	/**
	 * This method returns checked.
	 * @return checked
	 */
	public boolean isChecked()
	{
		return checked;
	}
	
	/**
	 * This method sets the bool variable to true.
	 */
	public void setChecked()
	{
		checked = true;
	}
	
	/**
	 * This method prints the characters and frequency of the node.
	 */
	public String toString()
	{
		return "Character: " + characters + " Frequency: " + frequency;
	}
}
