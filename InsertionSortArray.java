import java.util.Random;

public class InsertionSort {
	public static int[] sort(int[] list){
		for(int i = 0; i < list.length; i++){
			int tempi = list[i];
			int j = i - 1;
			while(j >= 0 &&  list[j] > tempi){
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = tempi;
		}
		return list;	
	}
}
