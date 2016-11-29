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
public class Dictionary
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
	private PriorityQueue<HuffmanNode> binaryTree;
	private HashMap<Character, String> dictionary;
	
	/**
	 * 
	 */
	public Dictionary()
	{
		map = new HashMap<Character, Integer>();
		pq = new PriorityQueue<HuffmanNode>(huffmanComparator);
		binaryTree = new PriorityQueue<HuffmanNode>(huffmanComparator);
		dictionary = new HashMap<Character, String>();
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
	 * This method overlooks the process of creating a Huffman's encoding scheme
	 * binary tree.
	 *  
	 * @param text
	 */
	public void createATree(String text)
	{
		characterCount(text);
		
		sortingPQ();
		
		constructATree();
		
		creatingDictionary();
	}

	/**
	 * This method populates the HashMap with characters and their frequency in the text.
	 * 
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
	
	/**
	 * This method sorts the the characters and frequency in descending order
	 * by putting it in the priority queue with a custom comparator.
	 */
	private void sortingPQ()
	{
		Set<Character> characters = map.keySet();
		Collection<Integer> frequency = map.values();
		
		Iterator<Character> c = characters.iterator();
		Iterator<Integer> f = frequency.iterator();
		
		for (int i = 0; i < characters.size(); i++)
		{		
			pq.add(new HuffmanNode("" + c.next(), f.next()));
		}
		
//		Iterator<HuffmanNode> hn = pq.iterator();
//		for (int i = 0; i < pq.size(); i++)
//		{
//			HuffmanNode node = hn.next();
//			node.print();
//		}
	}

	/**
	 * 
	 */
	private void constructATree()
	{
		while (!pq.isEmpty() || findSmallest() != binaryTree.peek())
		{
			HuffmanNode minOne = findSmallest();
			minOne.setChecked();
			if (pq.contains(minOne))
			{
				pq.remove(minOne);
			}
			
			HuffmanNode minTwo = findSmallest();
			minTwo.setChecked();
			if (pq.contains(minTwo))
			{
				pq.remove(minTwo);
			}
			
			if (!binaryTree.contains(minOne))
			{
				binaryTree.add(minOne);
			}
			if (!binaryTree.contains(minTwo))
			{
				binaryTree.add(minTwo);
			}
			
//			minOne.print();
//			minTwo.print();
			
			String combinedChars = minOne.getCharacters() + minTwo.getCharacters();
			int combinedFrequency = minOne.getFrequency() + minTwo.getFrequency();
			
			HuffmanNode newNode = new HuffmanNode(combinedChars, combinedFrequency, minTwo, minOne);
			
			binaryTree.add(newNode);
		}
		
		for (HuffmanNode node : binaryTree)
		{
			node.print();
		}
	}

	/**
	 * This method finds the smallest node in both pq and binaryTree,
	 * and if it is in pq it removes it from there.
	 */
	private HuffmanNode findSmallest()
	{
		HuffmanNode min = new HuffmanNode("1", 6000000);
		
		if (!binaryTree.isEmpty())
			for (HuffmanNode node : binaryTree)
			{
				if (!node.isChecked())
				{
					if (node.getFrequency() < min.getFrequency())
					{
						min = node;
					}
				}
			}
		
		for (HuffmanNode node : pq)
		{
			if (node.getFrequency() < min.getFrequency())
			{
				min = node;
			}
		}
		
		return min;
	}

	private void creatingDictionary()
	{
		Set<Character> characters = map.keySet();
		
		
	}
}
