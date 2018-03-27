

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
		/*
		if (size == heap.length-1)
			System.out.println("Heap's underlying storage is overflow");
		else {
			heap[++size] = value;
			verifyMinParent(size);
			System.out.println(heap[size].val);
			System.out.println("SIZZE is " + size);
		}
		*/
		
		insertInIndex(++size, value);
		
	

	}
	
	private void insertInIndex(int index, CompareInt value){
		int currentIndex = size;
		heap[currentIndex] =  value;
		int parentIndex = getParent(currentIndex);
		CompareInt parentVal= heap[parentIndex];
		
		if (parentVal.compareTo(value)>0){
			swap(parentIndex,currentIndex);
			insertInIndex(parentIndex, heap[parentIndex]);
		}
		
		int leftChildIndex = leftChild(parentIndex);
		int rightChildIndex = rightChild(parentIndex);
		
		if (leftChildIndex < heap.length && rightChildIndex < heap.length ){
			CompareInt leftChildVal = heap[leftChildIndex];
			CompareInt rightChildVal = heap[rightChildIndex];
			if (leftChildVal != null && rightChildVal != null) {
				if (leftChildVal.compareTo(rightChildVal) > 0) {
					swap(leftChildIndex, rightChildIndex);
				}
				int minChildIndex = (leftChildVal.compareTo(rightChildVal) > 0) ? rightChildIndex :leftChildIndex;
				
				if (parentVal.compareTo(heap[minChildIndex])>0){
					swap(parentIndex, minChildIndex);
					insertInIndex(minChildIndex, heap[minChildIndex]);
					
				}
			}
		}
		return;
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
		size = newSize;
		//1. [[null, 8, 2, 3, 4, 5, 6, 7, null ]]
		orderNewMeanHeap(1);
		return minHeap;

	}

	private void orderNewMeanHeap(int index) {
		
		//-1. parentIndex = index;
		final int parentIndex = index;
		//0. leftChildIndex = getLeftChild(parentIndex)
		int leftChildIndex = leftChild(parentIndex);
		
		//0. rightChildIndex = getRightChild(parentIndex)
		int rightChildIndex = rightChild(parentIndex);
		
		if (rightChildIndex > size || leftChildIndex > size) {
			return ;
		}
		//childL = heap[leftChildIndex]
		CompareInt leftChild = heap[leftChildIndex];
		//childR = heap[rightChildIndex]
		CompareInt rightChild = heap[rightChildIndex];
		int minChildIndex = 0;
		
		if ((leftChild == null && rightChild == null) || leftChild == null)
			return;
		
		if (leftChild != null && rightChild == null) {
			minChildIndex = leftChildIndex;
		} else if (leftChild != null && (leftChild.compareTo(rightChild) < 0)){
			minChildIndex = leftChildIndex;
		}else{ 
			minChildIndex = rightChildIndex;
		}
		if (heap[parentIndex].compareTo(heap[minChildIndex])>0){
			swap(parentIndex, minChildIndex);
		}
		
		leftChild = heap[leftChildIndex];
		rightChild = heap[rightChildIndex];
		
		if (leftChild != null && rightChild != null){
			if (leftChild.compareTo(rightChild) > 0)
			{
				swap(leftChildIndex, rightChildIndex);
			}
		}
		else if (leftChild == null && rightChild!=null){
			swap(leftChildIndex, rightChildIndex);
		}
		orderNewMeanHeap(rightChildIndex);
		
	}

	private int leftChild(int indexParent) {
		return (2 * indexParent);
	}

	private int rightChild(int i) {

		return (2 * i) + 1;
	}
	
	
}