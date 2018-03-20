import org.junit.Assert;
import org.junit.Test;


public class PrivateTests
{
  public PrivateTests() {}
  
  private static CompareInt[] convert(int[] arr)
  {
    CompareInt[] newArr = new CompareInt[arr.length];
    for (int i = 0; i < newArr.length; i++) {
      newArr[i] = new CompareInt(arr[i]);
    }
    return newArr;
  }
  
  private static void shuffle(int[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      int random = i + (int)(Math.random() * (n - i));
      int temp = array[random];
      array[random] = array[i];
      array[i] = temp;
    }
  }
  
  @Test
  public void testHeap() {
    CompareInt[] arr = convert(new int[] { 3, 1, 2 });
    try {
      Assert.assertTrue("heap implementation does not correctly get the 2nd smallest element from an array of 3", 
        KthSmallest.heapImpl(2, arr) == 2);
    } catch (NullPointerException e) {
      Assert.fail("heap implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "heap implementation throws exception " + e + " when getting 2nd smallest element " + "from an array of 3");
    }
  }
  
 /* @Test
  public void testMerge() {
    CompareInt[] arr = convert(new int[] { 3, 1, 2 });
    try {
      Assert.assertTrue("merge sort implementation does not correctly get the 2nd smallest element from an array of 3", 
        KthSmallest.mergeSortImpl(2, arr) == 2);
    } catch (NullPointerException e) {
      Assert.fail("merge sort implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "merge sort implementation throws exception " + e + " when getting 2nd smallest " + "element from an array of 3");
    }
  }
  
  @Test
  public void testQuick() {
    CompareInt[] arr = convert(new int[] { 3, 1, 2 });
    try {
      Assert.assertTrue("quick select implementation does no correctly get the 2nd smallest element from an array of 3", 
        KthSmallest.quickSelectImpl(2, arr) == 2);
    } catch (NullPointerException e) {
      Assert.fail("quick select implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "quick select implementation throws exception " + e + " when getting 2nd smallest element " + "from an array of 3");
    }
  }
 
  @Test
  public void test2Heap() {
    CompareInt[] arr = convert(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    try {
      Assert.assertTrue("heap implementation does no correctly get the 2nd largest element from a pre-sorted array", 
        KthSmallest.heapImpl(7, arr) == 7);
    } catch (NullPointerException e) {
      Assert.fail("heap implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "heap implementation throws exception " + e + " when getting 2nd largest element " + "from a pre-sorted array");
    }
  }
   */
  /*
  @Test
  public void test2Merge()
  {
    CompareInt[] arr = convert(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    try {
      Assert.assertTrue("merge sort implementation does no correctly get the 2nd largest element from a pre-sorted array", 
        KthSmallest.mergeSortImpl(7, arr) == 7);
    } catch (NullPointerException e) {
      Assert.fail("merge sort implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "merge sort implementation throws exception " + e + " when getting 2nd largest element " + "from a pre-sorted array");
    }
  }
  
  @Test
  public void test2Quick() {
    CompareInt[] arr = convert(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    try {
      Assert.assertTrue("quick select implementation does no correctly get the 2nd largest element from a pre-sorted array", 
        KthSmallest.quickSelectImpl(7, arr) == 7);
    } catch (NullPointerException e) {
      Assert.fail("quick select implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "quick select implementation throws exception " + e + " when getting 2nd largest element " + "from a pre-sorted array");
    }
  }

  @Test
  public void test3Heap() {
    CompareInt[] arr = convert(new int[] { 9, 7, 0, 5, 8, 2, 3, 13, -4 });
    try {
      Assert.assertTrue("heap implementation output is incorrect on a midsized array, getting the 6th smallest element", 
        KthSmallest.heapImpl(6, arr) == 7);
    } catch (NullPointerException e) {
      Assert.fail("heap implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "heap implementation throws exception " + e + " on a midsized array, getting the " + "6th smallest element");
    }
  }
  */
  /*
  @Test
  public void test3Merge() {
    CompareInt[] arr = convert(new int[] { 9, 7, 0, 5, 8, 2, 3, 13, -4 });
    try {
      Assert.assertTrue("merge sort implementation output is incorrect on a midsized array, getting the 6th smallest element", 
        KthSmallest.mergeSortImpl(6, arr) == 7);
    } catch (NullPointerException e) {
      Assert.fail("merge sort implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "merge sort implementation throws exception " + e + " on a midsized array, getting the " + "6th smallest element");
    }
  }
  
  @Test
  public void test3Quick() {
    CompareInt[] arr = convert(new int[] { 9, 7, 0, 5, 8, 2, 3, 13, -4 });
    try {
      Assert.assertTrue("quick select implementation output is incorrect on a midsized array, getting the 6th smallest element", 
        KthSmallest.quickSelectImpl(6, arr) == 7);
    } catch (NullPointerException e) {
      Assert.fail("quick select implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "quick select implementation throws exception " + e + " on a midsized array, getting the " + "6th smallest element");
    }
  }
 
  @Test(timeout=4000L)
  public void testLarge1Heap() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("heap implementation output is incorrect on a very large array, getting a small element", 
        KthSmallest.heapImpl(68392, newArr) == 136785);
      Assert.assertTrue("heap implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getMinHeapComparisons() < 60000000) && 
        (KthSmallest.getMinHeapComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("heap implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "heap implementation throws exception " + e + " on a very large array, getting a " + "small element");
    }
  }
  /*
  @Test(timeout=4000L)
  public void testLarge1Merge() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("merge sort implementation output is incorrect on a very large array, getting a small element", 
        KthSmallest.mergeSortImpl(68392, newArr) == 136785);
      Assert.assertTrue("merge sort implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getMergeSortComparisons() < 60000000) && 
        (KthSmallest.getMergeSortComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("merge sort implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "merge sort implementation throws exception " + e + " on a very large array, getting a " + "small element");
    }
  }
  
  @Test(timeout=4000L)
  public void testLarge1Quick() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("quick select implementation output is incorrect on a very large array, getting a small element", 
        KthSmallest.quickSelectImpl(68392, newArr) == 136785);
      Assert.assertTrue("quick select implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getQuickSelectComparisons() < 60000000) && 
        (KthSmallest.getQuickSelectComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("quick select implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "quick select implementation throws exception " + e + " on a very large array, getting a " + "small element");
    }
  }
  
  @Test(timeout=4000L)
  public void testLarge2Heap() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("heap implementation output is incorrect on a very large array, getting a large element", 
        KthSmallest.heapImpl(794312, newArr) == 1588625);
      Assert.assertTrue("heap implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getMinHeapComparisons() < 60000000) && 
        (KthSmallest.getMinHeapComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("heap implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "heap implementation throws exception " + e + " on a very large array, getting a " + "large element");
    }
  }
  /*
  @Test(timeout=4000L)
  public void testLarge2Merge() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("merge sort implementation output is incorrect on a very large array, getting a large element", 
        KthSmallest.mergeSortImpl(794312, newArr) == 1588625);
      Assert.assertTrue("merge sort implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getMergeSortComparisons() < 60000000) && 
        (KthSmallest.getMergeSortComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("merge sort implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "merge sort implementation throws exception " + e + " on a very large array, getting a " + "large element");
    }
  }
  
  @Test(timeout=4000L)
  public void testLarge2Quick() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("quick select implementation output is incorrect on a very large array, getting a large element", 
        KthSmallest.quickSelectImpl(794312, newArr) == 1588625);
      Assert.assertTrue("quick select implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getQuickSelectComparisons() < 60000000) && 
        (KthSmallest.getQuickSelectComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("quick select implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "quick select implementation throws exception " + e + " on a very large array, getting a " + "large element");
    }
  }
  
  @Test(timeout=4000L)
  public void testLarge3Heap()
  {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("heap implementation output is incorrect on a very large array, getting a middle element", 
        KthSmallest.heapImpl(519487, newArr) == 1038975);
      Assert.assertTrue("heap implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getMinHeapComparisons() < 60000000) && 
        (KthSmallest.getMinHeapComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("heap implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "heap implementation throws exception " + e + " on a very large array, getting a " + "middle element");
    }
  }
  /*
  @Test(timeout=4000L)
  public void testLarge3Merge() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("merge sort implementation output is incorrect on a very large array, getting a middle element", 
        KthSmallest.mergeSortImpl(519487, newArr) == 1038975);
      Assert.assertTrue("merge sort implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getMergeSortComparisons() < 60000000) && 
        (KthSmallest.getMergeSortComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("merge sort implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "merge sort implementation throws exception " + e + " on a very large array, getting a " + "middle element");
    }
  }
  
  @Test(timeout=4000L)
  public void testLarge3Quick() {
    int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (2 * i + 3);
    }
    shuffle(arr);
    CompareInt[] newArr = convert(arr);
    try {
      Assert.assertTrue("quick select implementation output is incorrect on a very large array, getting a middle element", 
        KthSmallest.quickSelectImpl(519487, newArr) == 1038975);
      Assert.assertTrue("quick select implementation output on a very large array uses too many comparisons", 
        (KthSmallest.getQuickSelectComparisons() < 60000000) && 
        (KthSmallest.getQuickSelectComparisons() > 1000000));
    } catch (NullPointerException e) {
      Assert.fail("quick select implementation returns a null value, make sure to implement all required functions");
    } catch (Exception e) {
      Assert.fail(
        "quick select implementation throws exception " + e + " on a very large array, getting a " + "middle element");
    }
  }*/
}