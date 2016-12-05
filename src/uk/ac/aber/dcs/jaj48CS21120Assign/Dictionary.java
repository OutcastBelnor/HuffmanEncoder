package uk.ac.aber.dcs.jaj48CS21120Assign;
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
	/**
	 *  Custom comparator for the priority queue which sorts in the descending order.
	 */
	public static Comparator<HuffmanNode> huffmanComparator = new Comparator<HuffmanNode>()
	{
		@Override
		public int compare(HuffmanNode node1, HuffmanNode node2)
		{
			return -(node1.getFrequency() - node2.getFrequency());
        }
	};
	
	private HashMap<Character, Integer> map; // used for counting frequency of the characters
	private PriorityQueue<HuffmanNode> pq; // used for sorting
	private PriorityQueue<HuffmanNode> binaryTree; // used for creating a binary tree
	private HashMap<Character, String> dictionary; // used for storing the encoded characters
	private int height; // the height of the binary tree
	private int depths[]; // different depths of the tree used to calculate average depth
	
	/**
	 *  Constructor for Dictionary class.
	 */
	public Dictionary()
	{
		map = new HashMap<Character, Integer>();
		pq = new PriorityQueue<HuffmanNode>(huffmanComparator);
		binaryTree = new PriorityQueue<HuffmanNode>(huffmanComparator);
		dictionary = new HashMap<Character, String>();
		height = 0;
	}

	/**
	 *  This method prints the dictionary HashMap in a nice way.
	 */
	public void print()
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
		
		Iterator<HuffmanNode> hn = pq.iterator();
		for (int i = 0; i < pq.size(); i++)
		{
			HuffmanNode node = hn.next();
			node.print();
		}
	}

	/**
	 *  This method constructs a binary tree according to Huffman Encoding scheme.
	 *  The nodes from the previous priority queue become the bottom layer of the tree,
	 *  and the tree builds up by adding two lowest frequencies of the character, until
	 *  the pq is empty and the smallest node is the top node of the binary tree.
	 */
	private void constructATree()
	{
		while (!pq.isEmpty() || findSmallest() != binaryTree.peek())
		{
			HuffmanNode minOne = findSmallest();
			minOne.setChecked();
			if (pq.contains(minOne))		// if it is a node from pq
			{
				pq.remove(minOne);			// remove it from there
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
			
			String combinedChars = minOne.getCharacters() + minTwo.getCharacters();
			int combinedFrequency = minOne.getFrequency() + minTwo.getFrequency();
			
			HuffmanNode newNode = new HuffmanNode(combinedChars, combinedFrequency, minOne, minTwo);
			
			minOne.setParentNode(newNode);
			minTwo.setParentNode(newNode);
			
			binaryTree.add(newNode);
		}
	}

	/**
	 * This method finds the smallest node in both pq and binaryTree..
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
	}
	
	
	/**
	 *  This method finds the node by the provided character.
	 * @param character
	 * @return node with character
	 */
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
	
	/**
	 *  This method calculates the statistics of the encoding process and prints it.
	 */
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
