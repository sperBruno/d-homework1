import java.util.Arrays;

public class Sorting {

	/**
	 * Implement the mergesort function, which should sort the array of integers
	 * in place
	 * 
	 * You will probably want to use helper functions here, as described in the
	 * lecture recordings (ex. merge(), a helper mergesort function)
	 * 
	 * @param arr
	 */
	public static void mergeSort(CompareInt[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void merge(CompareInt arr[], int left, int middle, int right) {
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;

		CompareInt auxLeftArray[] = new CompareInt[leftArraySize];
		CompareInt auxRightArray[] = new CompareInt[rightArraySize];

		for (int i = 0; i < leftArraySize; ++i)
			auxLeftArray[i] = arr[left + i];
		for (int j = 0; j < rightArraySize; ++j)
			auxRightArray[j] = arr[middle + 1 + j];

		mergeSortOrder(arr, left, leftArraySize, rightArraySize, auxLeftArray, auxRightArray);
	}

	private static void mergeSortOrder(CompareInt[] arr, int left, int leftArraySize, int rightArraySize,
			CompareInt[] auxLeftArray, CompareInt[] auxRightArray) {
		int leftIndex = 0, rightIndex = 0;

		int k = left;
		while (leftIndex < leftArraySize && rightIndex < rightArraySize) {
			if (auxLeftArray[leftIndex].compareTo(auxRightArray[rightIndex]) <= 0) {
				arr[k] = auxLeftArray[leftIndex];
				leftIndex++;
			} else {
				arr[k] = auxRightArray[rightIndex];
				rightIndex++;
			}
			k++;
		}

		while (leftIndex < leftArraySize) {
			arr[k] = auxLeftArray[leftIndex];
			leftIndex++;
			k++;
		}

		while (rightIndex < rightArraySize) {
			arr[k] = auxRightArray[rightIndex];
			rightIndex++;
			k++;
		}

	}

	private static void sort(CompareInt arr[], int left, int right) {
		if (left < right) {

			int middle = (left + right) / 2;

			sort(arr, left, middle);
			sort(arr, middle + 1, right);

			merge(arr, left, middle, right);
		}
	}

	/**
	 * Implement the quickSelect
	 * 
	 * Again, you will probably want to use helper functions here (ex.
	 * partition(), a helper quickselect function)
	 */
	public static CompareInt quickSelect(int k, CompareInt[] arr) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

}