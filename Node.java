/**
 * Creates Nodes that stores Strings so that they may be placed in a Heap
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class Node {

	/** the string to store in the Node */
	private String word;

	/**
	 * Constructs a node that stores a String object
	 * @param w the string to 
	 */
	public Node(String w)
	{
		word = w;
	}
	
	/**
	 * Gets the String object stored in a Node
	 * @return returns the word in the node
	 */
	public String getWord()
	{
		return word;
	}
	
	/**
	 * Sets the String object to the given String
	 * 
	 * @param w the String value to store in the Node
	 */
	public void setWord(String w)
	{
		word = w;
	}
}
