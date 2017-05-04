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
}
