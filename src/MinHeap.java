

/**
 * A Heap implementation class
 * 
 * @param heap
 *            the array that holds the heap data
 * @param size
 *            the number of elements currently stored in the heap
 */
public class MinHeap {

	CompareInt[] heap;
	int size;
	int newSize;

	int countExtract = 0;

	/**
	 * Constructs a new heap with maximum capacity n Remember to index your heap
	 * at 1 instead of 0!
	 * 
	 * @param n
	 *            the maximum number of elements allowed in the heap
	 */
	public MinHeap(int n) {
		heap = new CompareInt[n+1];
		size = 0;
	}

	/**
	 * Adds an element to the heap
	 * 
	 * @param val
	 *            the value to be added to the heap
	 * @throws Exception
	 */
	public void add(CompareInt val) {
		insert(val);

	}

	public void insert(CompareInt value) {

		if (size == heap.length-1)
			System.out.println("Heap's underlying storage is overflow");
		else {
			heap[++size] = value;
			verifyMinParent(size);
			System.out.println(heap[size].val);
			System.out.println("SIZZE is " + size);
		}

	}

	private void verifyMinParent(int index) {
		int parentIndex = getParent(index);
		if (heap[parentIndex].compareTo(heap[index]) > 0) {
			swap(index, parentIndex);
			verifyMinParent(parentIndex);
		}
	}

	private int getParent(int indexChild) {
		if (indexChild == 1) {
			return 1;
		}
		return indexChild / 2;
	}

	private void swap(int i, int parent) {
		CompareInt temp = heap[parent];
		heap[parent] = heap[i];
		heap[i] = temp;
	}

	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		//[null, 1, 2, 3, 4, 5, 6, 7, 8 ]
		countExtract++;
		CompareInt minHeap = this.heap[1];
		this.heap[1] = this.heap[size];
		this.heap[size] = null;
		//change variable nonNullElementCount
		newSize = (size) - countExtract;
		//1. [[null, 8, 2, 3, 4, 5, 6, 7, null ]]
		orderNewMeanHeap(1);
		return minHeap;

	}

	private void orderNewMeanHeap(int index) {
		final int leftChild = leftChild(index);
		System.out.println("LEFT CHILD "+ (leftChild-1));
		CompareInt left = heap[leftChild-1];
		System.out.println(left);
		final int rightChild = rightChild(index);
		System.out.println("RGITH CHILD "+ (rightChild-1));
		CompareInt right = heap[rightChild-1];
		System.out.println(right);
		
		
		int indexToChange;
		if (left == null && right != null) {
			indexToChange = rightChild;
		} else if ((left != null && right == null)) {
			indexToChange = leftChild;
		} else {
			indexToChange = left.compareTo(right) < 0 ? leftChild  : rightChild;
		}
		
		if (indexToChange < newSize) {
			
			swap(index, indexToChange);
			
			orderNewMeanHeap(indexToChange);
		}
	}

	private int leftChild(int indexParent) {
		return (2 * indexParent) + 1;
	}

	private int rightChild(int i) {

		return (2 * i) + 2;
	}
	
	
}