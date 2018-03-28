
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
		heap = new CompareInt[n + 1];
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

	private void insert(CompareInt value) {

		if (size == heap.length - 1)
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

	private void swap(int i, int parent) {
		CompareInt temp = heap[parent];
		heap[parent] = heap[i];
		heap[i] = temp;
	}

	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		CompareInt minHeap = this.heap[1];
		swap(1, size);
		this.heap[size] = null;
		size--;
		sank(1);
		return minHeap;

	}

	private void sank(int index) {
		int minHeapIndex = index;
		int leftChildIndex = getLeftChild(minHeapIndex);
		int rightChildIndex = getRightChild(minHeapIndex);
		if (leftChildIndex <= size && rightChildIndex <= size) {
			CompareInt leftChildVal = heap[leftChildIndex];
			CompareInt rightChildVal = heap[rightChildIndex];
			if (leftChildVal != null && rightChildVal != null) {
				int minChildIndex = (leftChildVal.compareTo(rightChildVal) > 0) ? rightChildIndex : leftChildIndex;
				if (heap[minHeapIndex].compareTo(heap[minChildIndex]) > 0) {
					swap(minHeapIndex, minChildIndex);
					sank(minChildIndex);
				}
			}
		}
	}

	private int getLeftChild(int indexParent) {
		return (2 * indexParent);
	}

	private int getRightChild(int i) {

		return (2 * i) + 1;
	}

	private int getParent(int indexChild) {
		if (indexChild == 1) {
			return 1;
		}
		return indexChild / 2;
	}
}
