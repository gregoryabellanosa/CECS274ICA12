import java.util.ArrayList;
/**
 * Creates a Heap using an ArrayList and provides a set of methods to access and modify its contents
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class Heap {

	/** list that will store the Nodes intended to store into the heap */
	private ArrayList<Node> heap;
	
	/**
	 * Constructs a heap using an empty ArrayList
	 */
	public Heap()
	{
		heap = new ArrayList<Node>();
	}
	
	/**
	 * Gets the size of the heap by calculating the size of the ArrayList
	 * 
	 * @return the size of the Heap
	 */
	public int getSize()
	{
		return heap.size();
	}
	
	/**
	 * Checks if the Heap is empty
	 * 
	 * @return true or false depending on whether or not the Heap is empty
	 */
	public boolean isEmpty()
	{
		return heap.isEmpty();
	}
	
	/**
	 * Gets the location of the parent Node of the specified Node
	 * 
	 * @param i the Node in search of its daddy
	 * @return location of the parent Node
	 */
	public int getPLoc(int i)
	{
		return (i - 1) / 2;
	}
	
	/**
	 * Gets the location of the left child Node of the Node at the given location
	 * 
	 * @param i location of the specified Node
	 * @return location of the left child Node
	 */
	public int getLCLoc(int i)
	{
		return 2 * i + 1;
	}
	
	/**
	 * Gets the location of the right child Node of the Node at the given location
	 * 
	 * @param i location of the specified Node
	 * @return location of the right child Node
	 */
	public int getRCLoc(int i)
	{
		return 2 * i + 2;
	}
	
	/**
	 * Gets the Node at a specified location
	 * 
	 * @param i specifies the location of which Node to access
	 * @return the Node at the specified location
	 */
	public Node getNodeAt(int i)
	{
		if (heap.get(i) == null)
		{
			System.out.println("Item does not exist.");
			return null;
		}
		else
		{
			return heap.get(i);
		}
	}
	
	/**
	 * Simultaneously prints and removes the contents of a Heap in a lexicographic order
	 */
	public void printAndRemove()
	{
		while (heap.size() != 0)
		{
			System.out.print(removeMin().getWord() + " ");
		}
	}
	
	/**
	 * Adds a Node to a Heap
	 * 
	 * @param n the Node containing the String value to add into the Heap
	 */
	public void addNode(Node n)
	{
		heap.add(null);
		int index = heap.size() - 1;
		while (index > 0 && getNodeAt(getPLoc(index)).getWord().compareToIgnoreCase(n.getWord()) > 0)
		{
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n);
	}
	
	/**
	 * Removes the minimum Node
	 * 
	 * @return the Node that was removed
	 */
	public Node removeMin()
	{
		Node min = heap.get(0);
		int index = heap.size() - 1;
		Node last = heap.remove(index);
		if (index > 0)
		{
			heap.set(0, last);
			Node root = heap.get(0);
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			while (!done)
			{
				if (getLCLoc(index) <= end) //left exists
				{
					Node child = getNodeAt(getLCLoc(index));
					int childLoc= getLCLoc(index);
					if (getRCLoc(index) <= end) //right exists
					{
						if (getNodeAt(getRCLoc(index)).getWord().compareToIgnoreCase(child.getWord()) < 0)
						{
							child = getNodeAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if (child.getWord().compareToIgnoreCase(root.getWord()) < 0)
					{
						heap.set(index, child);
						index = childLoc;
					}
					else
					{
						done = true;
					}
				}
				else //no children
				{
					done = true;
				}
			}
			heap.set(index, root);
		}
		return min;
	}
}
