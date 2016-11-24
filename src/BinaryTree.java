import java.util.TreeMap;

/**
 * @author Jakub Janas
 *
 */
public class BinaryTree
{
	private TreeMap<Character, Integer> map;
	
	/**
	 * 
	 */
	public BinaryTree()
	{
		map = new TreeMap<Character, Integer>();
	}
	
	public TreeMap<Character, Integer> getMap()
	{
		return map;
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
		
		System.out.print(map);
	}
}
