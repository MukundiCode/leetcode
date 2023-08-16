import java.util.*;
public class Heap{

	int[] array; 

	int maxSize;

	int heapSize = 0;

	public Heap(int maxSize){
		this.maxSize = maxSize;
		array = new int[maxSize];
	}

	/* Get the left index child of the node at i */
	int leftOf(int i){
		i = (2 * i) + 1;
		return (i > heapSize - 1) ? null : array[i];
	}

	/* Get the right index child of the node at i */
	int rightOf(int i){
		i = (2 * i) + 2;
		return (i > heapSize - 1) ? null : array[i];
	}

	/* Get the index of parent of the node at i */
	int parentOf(int i){
		return (i - 1)/2;
	}

	/* Insert a new node and maintain heap property */
	void insert(int x){
		// Add to the end then heapify parent until root
		heapSize++;
		array[heapSize - 1] = x;

		int childIndex = heapSize - 1;

		while (array[parentOf(childIndex)] < array[childIndex]){
			//swap
			int temp = array[parentOf(childIndex)];
			array[parentOf(childIndex)] = array[childIndex];
			array[childIndex] = temp;

			//set child to its parent
			childIndex = parentOf(childIndex);
		} 
	}

	/* Delete node at i and maintain heap property */
	void delete(int i){}

	/* Heapifies subtree for heap property */
	void heapify(){}

	/* Get max given max heap */
	// int getMax(){}

	/* Removes the max and maintains heap property */
	void removeMax(){}

	public static void main(String... args){

		Heap heap = new Heap(15);
		Arrays.asList(2,4,5,6,1,3,8,9).stream().forEach(n -> heap.insert(n));
		System.out.println(Arrays.toString(heap.array));

	}

}
