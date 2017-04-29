import java.util.LinkedList;
import java.util.Random;

public class HeapSort {
	private static int N;

	public static void sort(int[] table) {
		heapify(table);
		for (int i = N; i > 0; i--) {
			swap(table, 0, i);
			N = N - 1;
			maxheap(table, 0);
		}
		// buildHeap(table);
		// shrinkHeap(table);
	}

	private static void maxheap(int[] table, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && table[left] > table[i]) {
			max = left;
		}
		if (right <= N && table[right] > table[max]) {
			max = right;
		}
		if (max != i) {
			swap(table, i, max);
			maxheap(table, max);
		}
	}

	private static void heapify(int[] table) {
		N = table.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			maxheap(table, i);
		}
	}

	private static void swap(int[]table, int parent, int child) {
		int temp = table[parent];
		table[parent] = table[child];
		table[child] = temp;
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
		int n = 10000;
		int[] list = new int[800];
		Random rnd = new Random();
		
		for (int i = 0; i < 800; i++) {
			list[i] = rnd.nextInt(n);
		}
		
		sort(list);
		for(int i = 0; i < 800; i++){
			System.out.println(list[i] + " ");
		}
	
	}
}
