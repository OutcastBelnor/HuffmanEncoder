import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Jakub Janas
 *
 */
public class BinaryTree
{
	public static Comparator<HuffmanNode> huffmanComparator = new Comparator<HuffmanNode>()
	{
		@Override
		public int compare(HuffmanNode node1, HuffmanNode node2) {
			if (node1.getFrequency() > node2.getFrequency())
			{
				return (int) -1;
			}
			else if (node1.getFrequency() == node2.getFrequency())
			{
				return (int) 0;
			}
			else
			{
				return (int) 1;
			}
        }
	};
	
	private HashMap<Character, Integer> map;
	private PriorityQueue<HuffmanNode> pq;
	
	/**
	 * 
	 */
	public BinaryTree()
	{
		map = new HashMap<Character, Integer>();
		pq = new PriorityQueue(huffmanComparator);
	}
	
	public HashMap<Character, Integer> getMap()
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
		
		Set<Character> characters = map.keySet();
		Collection<Integer> frequency = map.values();
		
		Iterator<Character> c = characters.iterator();
		Iterator<Integer> f = frequency.iterator();
		
		for (int i = 0; i < characters.size(); i++)
		{		
			pq.add(new HuffmanNode(c.next(), f.next()));
		}
		
		Iterator<HuffmanNode> hn = pq.iterator();
		for (int i = 0; i < pq.size(); i++)
		{
			HuffmanNode node = hn.next();
			System.out.println(node.getCharacter() + " " + node.getFrequency());
		}
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
		
		System.out.println(map);
	}
}
