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
	 */
	public void add(CompareInt val) {
		if(position==0){
			heap[position+1]=val;
			position = 2;
		}else{
			heap[position++]=val;
			bubbleUp();
		}
	}
	
	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		
/*		//System.out.println(heap);
		int N =heap.length;
		CompareInt min = heap[1];
		heap[1] = heap[N];
		sink(heap, 1);
		for( CompareInt item: heap) {
			System.out.println(item.val);
		}
		return min;*/
		return extractMin1();
	}
	public void bubbleUp(){
		int pos = position-1;
		while(pos>0 && heap[pos/2].compareTo(heap[pos])>0){
			CompareInt y = heap[pos];
			heap[pos]=heap[pos/2];
			heap[pos/2] = y;
			pos = pos/2;
		}
	}
	private CompareInt extractMin1(){
		CompareInt min = heap[1];
		heap[1]=heap[position-1];
		heap[position-1]=new CompareInt(0);
		position--;		
		sinkDown(1);
		return min;
	}
	
	public void sinkDown(int k){
		CompareInt a = heap[k];
	int smallest =k;
	if(2*k<position && heap[smallest].compareTo(heap[2*k])>0){
		smallest = 2*k;
	}
	if(2*k+1<position && heap[smallest].compareTo(heap[2*k+1])>0){
		smallest = 2*k+1;
	}
	if(smallest!=k){
		swap(k,smallest);
		sinkDown(smallest);
	}
			
}
/*	private void sink(CompareInt[] arr, int n) {
		int N = arr.length;
		int smallest = 0;
		while((2*n) <= N) {
			smallest = 2 *n;
			if (arr[2*n].compareTo(arr[2*n+1])< 0) {
				smallest = 2*n+1;
			}
			if (arr[n].compareTo(new CompareInt(n))<0) {
				break;
			}
			swap(arr, n, smallest);
			n = smallest;
		}
	}*/
	
	private void swap(int n, int k) {
		CompareInt temp = heap[n];
		heap[n] = heap[k];
		heap[k] = temp;
	}
	
	
	
	
}
