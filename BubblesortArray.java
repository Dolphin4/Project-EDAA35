import java.util.Random;

public class Bubblesort{
	public static int[] sort(int[] array){
		
		int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
        }
		return array;
	}
	
	private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
