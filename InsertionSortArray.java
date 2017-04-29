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
	
//	public static void main(String[] args) {
//		int n = 10000;
//		int[] list = new int[800];
//		Random rnd = new Random();
//		
//		for (int i = 0; i < 800; i++) {
//			list[i] = rnd.nextInt(n);
//		}
//		
//		sort(list);
//		for(int i = 0; i < 800; i++){
//			System.out.println(list[i] + " ");
//		}
//		
//	}
}
