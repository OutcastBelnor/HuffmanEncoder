# HuffmanEncoder
  A Huffman encoding scheme implemented in Java.

  This project contains four classes: Encoder, FileHandler, Dictionary and HuffmanNode.
  
  FileHandler is a very basic class just for reading from a txt file. You create an object of this class with a file name as a parameter and use the method readFile() that returns a single string with the whole file contents. FileHandler uses Scanner object that is open to the file and reads with a delimiter "\\Z" which matches the end of the file. After that Scanner object is closed.
  
  Encoder is main class with static main() method. It controls the process of encoding the file. Firstly it calls readFile() method from the FileHandler to read the file. Then it calls the encode method of Dictionary. After that it prints the statistics of the encoding process and the dictionary.
  
  Dictionary is the class where the encoding takes place. The encode() method calls other methods in order. First one to go is characterCount(). It uses a HashMap to store and count the frequency of the character.
  Second is the sortingPQ(). A priority queue with a custom comparator is being filled up with HuffmanNode objects that contain the keys and values from the HashMap. The comparator sorts it in descending order.
  After in constructATree() a tree is constructed (obviously). It uses a helper method findSmallest() to find two smallest nodes in the priority queue or the binaryTree (which is a priority queue too). If they're not in the binaryTree yet, they are added to it and the a new HuffmanNode object is created and added to the tree which is a sum of the two previous nodes. These nodes have a boolean instance variable that when it's checked it's not taken as a smallest node. The process is repeated until the old priority queue is empty and the smallest node found is the root of the tree.
  Last step is to create binary codes for the characters. I have chosen bottom-top traversing and implemented it using a helper method that searches for the node in the bottom row that contains the desired character. The tree is then traverse to the top checking every node if it is left or right child of the parent. The ready codes are stored in a new HashMap.
  
  Last class is the HuffmanNode. It is used twice for the two priority queues in the Dictionary class. For the first one it only needs the character and frequency instance variable and all other are set to null and false in boolean. For the second one the constructor is a bit more complicated as it takes more parameters which are the children of the node. There are getters and setters for the instance variables and setChecked() method to set the boolean to true.
