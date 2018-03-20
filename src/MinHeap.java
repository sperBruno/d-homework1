import java.util.Arrays;

/**
 * A Heap implementation class
 * 
 * @param heap the array that holds the heap data
 * @param size the number of elements currently stored in the heap
 */
public class MinHeap {
	
	CompareInt[] heap;
	int size;
	
	int position = 0;
	/**
	 * Constructs a new heap with maximum capacity n
	 * Remember to index your heap at 1 instead of 0!
	 * @param n the maximum number of elements allowed in the heap
	 */
	public MinHeap(int n) {
		heap = new CompareInt[n+1];
		size = 0;
	}
	
	/**
	 * Adds an element to the heap
	 * 
	 * @param val the value to be added to the heap
	 * @throws Exception 
	 */
	public void add(CompareInt val) {
		insert(val);
		
		
	}

	public void insert(CompareInt value)  {

		if (size == heap.length)

			System.out.println("Heap's underlying storage is overflow");

		else {

			//size++;

			heap[++size] = value;
			verifyMinParent(size);
			//printHeap();
			System.out.println(heap[size].val);
			System.out.println("SIZZE is " + size);

			//siftUp(size - 1);

		}

	} 
	private void verifyMinParent(int index){
		int parentIndex = getParent(index);
		
		if (heap[parentIndex].compareTo(heap[index])>0){
			swap(index, parentIndex);
			verifyMinParent(parentIndex);
		}
		
	}
	private int getParent(int indexChild){
		if (indexChild == 1){
			return 1;
		}
		return indexChild/2;
	}
 

	private void siftUp(int nodeIndex) {

		int parentIndex;
		CompareInt tmp;

		if (nodeIndex != 0) {

			//parentIndex = getParentIndex(nodeIndex);
			parentIndex = nodeIndex/2;

			if (heap[parentIndex].compareTo(heap[nodeIndex]) >= 0) {

				tmp = heap[parentIndex];

				heap[parentIndex] = heap[nodeIndex];

				heap[nodeIndex] = tmp;

				siftUp(parentIndex);

			}

		}

	}
	
	
	public void printHeap(){
		System.out.println("ALLL HEAP " + heap.length);
		int i;
		for (CompareInt node : heap) {
			System.out.println(node.val);
		}	
	}

	  private void swap(int i, int parent) {

	        CompareInt temp = heap[parent];
	        heap[parent] = heap[i];
	        heap[i]= temp;
	    }

	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		//Arrays.sort(this.heap);
		return this.heap[0];
		
	}
	
	
}