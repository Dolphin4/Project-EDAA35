import java.util.LinkedList;
import java.util.Random;

public class QuickSort {
  
	
	public static int[] sort(int[] list){
		sort(list, 0, list.length-1);
		return list;
	}

	private static void sort(int[] list, int low, int high) {
		if(low < high){
			int pi = partition(list, low, high);
			sort(list, low, pi-1);
			sort(list, pi+1, high);
		}
	}

	private static int partition(int[] list, int low, int high) {
		int pivot = list[high];
		int i = low - 1;
		for(int j = low; j <=high-1; j++){
			int next = list[j];
			if(next <= pivot){
				i++;
				int temp = list[i];
				list[i] = next;
				list[j] = temp;
			}
		}
		int temp = list[i+1];
		list[i+1] =  list[high];
		list[high] = temp;
		return i+1;
	}
	
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
