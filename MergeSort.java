import java.util.LinkedList;
import java.util.Random;


public class MergeSort{
		private static LinkedList<Integer> list;
        private static LinkedList<Integer> tempList;
        private static int length;
        
//        public static void main(String[] args) {
//    		int n = 10000;
//    		LinkedList<Integer> list = new LinkedList<Integer>();
//    		Random rnd = new Random();
//
//    		for (int i = 0; i < 80; i++) {
//    			list.add(rnd.nextInt(n));
//    		}
//    		sort(list);
//    		System.out.println(list);
//    	}
		
		public static LinkedList<Integer> sort(LinkedList<Integer> list2){
			list = list2;
			length = list.size();
			tempList = new LinkedList<Integer>();
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
                tempList.add(i, list.get(i));
            }
            int i = low;
            int j = middle + 1;
            int k = low;
            
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
            	if (tempList.get(i).compareTo(tempList.get(j)) <= 0) {
					list.set(k, tempList.get(i));
                    i++;
                }else {
                	list.set(k, tempList.get(j));
                    j++;
                }
                k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
				list.set(k, tempList.get(i));
                k++;
                i++;
            }
		}
	
}
