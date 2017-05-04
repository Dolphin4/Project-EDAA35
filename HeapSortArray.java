public class HeapSort {
	private static int N;

	public static void sort(int[] table) {
		heapify(table);
		for (int i = N; i > 0; i--) {
			swap(table, 0, i);
			N = N - 1;
			maxheap(table, 0);
		}
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
}
