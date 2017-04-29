import java.util.LinkedList;

public class QuickSort {
	public static LinkedList<Integer> sort(LinkedList<Integer> list){
		sort(list, 0, list.size()-1);
		return list;
	}

	private static void sort(LinkedList<Integer> list, int low, int high) {
		if(low < high){
			int pi = partition(list, low, high);
			sort(list, low, pi-1);
			sort(list, pi+1, high);
		}
	}

	private static int partition(LinkedList<Integer> list, int low, int high) {
		int pivot = list.get(high);
		int i = low - 1;
		for(int j = low; j <=high-1; j++){
			int next = list.get(j);
			if(next <= pivot){
				i++;
				int temp = list.get(i);
				list.set(i, next);
				list.set(j, temp);
			}
		}
		int temp = list.get(i+1);
		list.set(i+1, list.get(high));
		list.set(high, temp);
		return i+1;
	}
}
