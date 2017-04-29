import java.util.LinkedList;
import java.util.Random;


public class MergeSort{
		private static int[] list;
        private static int[] tempList;
        private static int length;
        
//    	public static void main(String[] args) {
//    		int n = 10000;
//    		int[] list = new int[800];
//    		Random rnd = new Random();
//    		
//    		for (int i = 0; i < 800; i++) {
//    			list[i] = rnd.nextInt(n);
//    		}
//    		
//    		sort(list);
//    		for(int i = 0; i < 800; i++){
//    			System.out.println(list[i] + " ");
//    		}
//    		
//    	}
//        
		
		public static int[] sort(int[] list2){
			list = list2;
			length = list.length;
			tempList = new int[length];
			mergesort(0, length - 1);
			
			return list;
		}

		
		private static void mergesort(int low, int high) {
            // check if low is smaller than high, if not then the array is sorted
            if (low < high) {
            	// Get the index of the element which is in the middle
                int middle = low + (high - low) / 2;
                // Sort the left side of the array
                mergesort(low, middle);
                // Sort the right side of the array
                mergesort(middle + 1, high);
                // Combine them both
                merge(low, middle, high);
            }
		}
		
		private static void merge(int low, int middle, int high) {
            // Copy both parts into the helper array
            for (int i = low; i <= high; i++) {
                tempList[i] = list[i];
            }
            int i = low;
            int j = middle + 1;
            int k = low;
            
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
            	if (tempList[i] <= tempList[j]) {
					list[k] = tempList[i];
                    i++;
                }else {
                	list[k] = tempList[j];
                    j++;
                }
                k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
            	list[k] = tempList[i];
                k++;
                i++;
            }
		}
	
}
