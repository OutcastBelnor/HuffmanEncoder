<<<<<<< HEAD
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
=======
import java.util.HashMap;
import java.util.PriorityQueue;
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7

/**
 * @author Jakub Janas
 *
 */
public class BinaryTree
{
<<<<<<< HEAD
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
	
=======
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
	private HashMap<Character, Integer> map;
	private PriorityQueue<HuffmanNode> pq;
	
	/**
	 * 
	 */
	public BinaryTree()
	{
		map = new HashMap<Character, Integer>();
<<<<<<< HEAD
		pq = new PriorityQueue(huffmanComparator);
=======
		pq = new PriorityQueue<HuffmanNode>();
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
	}
	
	public HashMap<Character, Integer> getMap()
	{
		return map;
	}
<<<<<<< HEAD
=======
	
	public PriorityQueue<HuffmanNode> getPQ()
	{
		return pq;
	}
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7

	/**
	 * 
	 * @param text
	 */
	public void createATree(String text)
	{
		characterCount(text);
<<<<<<< HEAD
		
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
=======
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
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
		
<<<<<<< HEAD
		System.out.println(map);
=======
		sort();
	}

	private void sort()
	{
		
>>>>>>> f2a73cd1a141feb393b49137dcdebe378095eee7
	}
}
