import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Jakub Janas
 *
 */
public class BinaryTree
{
	private HashMap<Character, Integer> map;
	private PriorityQueue<HuffmanNode> pq;
	
	/**
	 * 
	 */
	public BinaryTree()
	{
		map = new HashMap<Character, Integer>();
		pq = new PriorityQueue<HuffmanNode>();
	}
	
	public HashMap<Character, Integer> getMap()
	{
		return map;
	}
	
	public PriorityQueue<HuffmanNode> getPQ()
	{
		return pq;
	}

	/**
	 * 
	 * @param text
	 */
	public void createATree(String text)
	{
		characterCount(text);
	}

	/**
	 * @param text
	 */
	private void characterCount(String text)
	{
		for (int i = 0; i < text.length(); i++)
		{
			char character = text.charAt(i);
			
			if (map.get(character) == null)
			{
				map.put(character, 1);
			}
			else
			{
				map.put(character, (map.get(character) + 1));
			}
		}
		
		sort();
	}

	private void sort()
	{
		
	}
}
