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
	private int height;
	int depths[];
	
	/**
	 * 
	 */
	public Dictionary()
	{
		map = new HashMap<Character, Integer>();
		pq = new PriorityQueue<HuffmanNode>(huffmanComparator);
		binaryTree = new PriorityQueue<HuffmanNode>(huffmanComparator);
		dictionary = new HashMap<Character, String>();
		height = 0;
	}

	public void print()
	{
		if (!dictionary.isEmpty())
		{
			Set<Character> characters = dictionary.keySet();
			Collection<String> code = dictionary.values();
			
			Iterator<Character> c = characters.iterator();
			Iterator<String> cd = code.iterator();
			
			for (int i = 0; i < characters.size(); i++)
			{		
				System.out.println(c.next() + " = " + cd.next());
			}
		}
		else
		{
			System.out.println("There isn't any encoded dictionary yet!");
		}
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
		
//		System.out.println(map);
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
			
			HuffmanNode newNode = new HuffmanNode(combinedChars, combinedFrequency, minOne, minTwo);
			
			minOne.setParentNode(newNode);
			minTwo.setParentNode(newNode);
			
			binaryTree.add(newNode);
		}
		
//		for (HuffmanNode node : binaryTree)
//		{
//			node.print();
//		}
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

	/**
	 * This method creates a dictionary for characters in the input text
	 * i.e. it generates a binary-like code for each characters. The most
	 * common character has the shortest code.
	 */
	private void creatingDictionary()
	{
		Set<Character> characters = map.keySet();
		Iterator<Character> c = characters.iterator();
		depths = new int[characters.size()];
		
		for (int i = 0; i < characters.size(); i++)
		{
			Character ch = c.next();
			String character = "" + ch;
			HuffmanNode characterNode = findCharacterNode(character);
			
			String binaryCode = "";
			
			while (characterNode.getParentNode() != null)
			{
				depths[i]++;
				HuffmanNode parent = characterNode.getParentNode();
				
				if (characterNode == parent.getLeftNode())
				{
					binaryCode = "0" + binaryCode;
				}
				else if (characterNode == parent.getRightNode())
				{
					binaryCode = "1" + binaryCode;
				}
				
				characterNode = parent;
			}

			dictionary.put(ch, binaryCode);
		}
		
//		System.out.println(dictionary);
	}
	
	private HuffmanNode findCharacterNode(String character)
	{
		HuffmanNode characterNode = null;
		
		for (HuffmanNode node : binaryTree)
		{
			if (character.equals(node.getCharacters()))
			{
				characterNode = node;
			}
		}
		
		return characterNode;
	}
	
	public void stats()
	{
		int averageDepth = 0;
		for (int i = 0; i < depths.length; i++)
		{
			if (height < depths[i])
			{
				height = depths[i];
			}
			averageDepth += depths[i];
		}
		averageDepth /= depths.length;
		
		System.out.println("Height: " + height);
		System.out.println("Number of nodes: " + binaryTree.size());
		System.out.println("Average depth: " +  averageDepth);
	}
}
