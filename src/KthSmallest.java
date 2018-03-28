
public class KthSmallest {
	
	//DO NOT MODIFY THIS FILE
	//you should read through each of the sorting implementations and understand how they work
	//before attempting to implement the other files!
	
	private static int mergeSortComparisons;
	private static int quickSelectComparisons;
	private static int minHeapComparisons;
	
	/**
	 * extracts the kth smallest element from an array
	 * using your implementation of mergesort
	 */
	public static int mergeSortImpl(int k, CompareInt[] arr) {
		Sorting.mergeSort(arr);
		mergeSortComparisons = CompareInt.countComparisons(arr, 0, arr.length - 1);
		System.out.println("MERGE SORT" + arr[k-1].val);
		return arr[k-1].val;
	}
	
	/**
	 * extracts the kth smallest element from an array
	 * using your implementation of quick-select
	 */
	public static int quickSelectImpl(int k, CompareInt[] arr) {
		int select = Sorting.quickSelect(k, arr).val;
		quickSelectComparisons = CompareInt.countComparisons(arr, 0, arr.length - 1);
		return select;
	}
	
	/**
	 * extracts the kth smallest element from an array
	 * using your implementation of the MinHeap class
	 * 
	 */
	public static int heapImpl(int k, CompareInt[] arr) {
		MinHeap h = new MinHeap(arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			h.add(arr[i]);
		}
	
		for (int i = 0; i < k-1; i++) {
			System.out.println("Extracted IN loop " + h.extractMin() );
			
		}
		minHeapComparisons = CompareInt.countComparisons(arr, 1, arr.length - 1);
	
		int min=h.extractMin().val;
		System.out.println(min);
		return min;
	}
	
	public static int getMergeSortComparisons() {
		return mergeSortComparisons;
	}
	
	public static int getQuickSelectComparisons() {
		return quickSelectComparisons;
	}
	
	public static int getMinHeapComparisons() {
		return minHeapComparisons;
	}
	
}
