import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Stores the contents of a .txt file into a heap and prints out the contents of the heap in lexicographic order
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class SortHeapMain {

	public static void main(String[] args) {
		
	Heap heap = readFile("file.txt");
	
	heap.printAndRemove();

	}

	/**
	 * Reads a .txt file and stores its contents into a Heap
	 * 
	 * @param fileName
	 * @return
	 */
	public static Heap readFile(String fileName)
	{
		Heap h = new Heap();
		try
		{
			Scanner read = new Scanner(new File(fileName));
			while (read.hasNextLine())
			{
				String line = read.nextLine();
				h.addNode(new Node(line));
			}
			read.close();
			
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found.");
		}

		return h;
	}
}
