import java.util.LinkedList;
import java.util.Random;

public class HeapSort {
	private static int N;

	public static void sort(LinkedList<Integer> table) {
		heapify(table);
		for (int i = N; i > 0; i--) {
			swap(table, 0, i);
			N = N - 1;
			maxheap(table, 0);
		}
		// buildHeap(table);
		// shrinkHeap(table);
	}

	private static void maxheap(LinkedList<Integer> table, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && table.get(left) > table.get(i)) {
			max = left;
		}
		if (right <= N && table.get(right) > table.get(max)) {
			max = right;
		}
		if (max != i) {
			swap(table, i, max);
			maxheap(table, max);
		}
	}

	private static void heapify(LinkedList<Integer> table) {
		N = table.size() - 1;
		for (int i = N / 2; i >= 0; i--) {
			maxheap(table, i);
		}
	}

	private static void swap(LinkedList<Integer> table, int parent, int child) {
		int temp = table.get(parent);
		table.set(parent, table.get(child));
		table.set(child, temp);
	}

	/*
	 * private static void buildHeap(LinkedList<Integer> table){ int n = 1;
	 * while (n < table.size()){ n++; int child = n-1; int parent = (child-1)/2;
	 * while (parent >= 0 && (table.get(parent) < (table.get(child)))){
	 * swap(table, parent, child); child = parent; parent = (child - 1)/2; } } }
	 * 
	 * private static void shrinkHeap(LinkedList<Integer> table){ int n =
	 * table.size(); while(n > 0){ n--; swap(table, 0, n); // Index of parent
	 * int parent = 0; // Reheap while(true){ // Index of left child int
	 * leftChild = 2 * parent + 1; // If child index is out of heap bounds
	 * if(leftChild >= n){ break; } // Index of right child int rightChild =
	 * leftChild - 1; // Choose which child is biggest int maxChild = leftChild;
	 * if(rightChild < n && (table.get(leftChild) < (table.get(rightChild)))){
	 * maxChild = rightChild; } // If parent smaller than bigger child, switch
	 * if((table.get(parent) < (table.get(maxChild)))){ swap(table, parent,
	 * maxChild); parent = maxChild; } else { break; } }
	 * 
	 * }
	 * 
	 * }
	 * 
	 */

	// //Test method for Heap sort by n random numbers
	public static void main(String[] args) {
		int n = 10;
		LinkedList<Integer> list = new LinkedList<Integer>();
		Random rnd = new Random();

		for (int i = 0; i < n; i++) {
			list.add(rnd.nextInt(n));
		}
		System.out.println(list.get(0));
		HeapSort.sort(list);
		System.out.println(list);
	}
}
