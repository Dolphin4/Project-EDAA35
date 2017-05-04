import java.util.LinkedList;
import java.util.Random;

public class MergeSort{
	private static LinkedList<Integer> list;
        private static LinkedList<Integer> tempList;
        private static int length;
		
	public static LinkedList<Integer> sort(LinkedList<Integer> list2){
		list = list2;
		length = list.size();
		tempList = new LinkedList<Integer>();
		mergesort(0, length - 1);
			
		return list;
	}

	private static void mergesort(int low, int high) {
        	if (low < high) {
                	int middle = low + (high - low) / 2;
                	mergesort(low, middle);
                	mergesort(middle + 1, high);
                	merge(low, middle, high);
            	}
	}
		
	private static void merge(int low, int middle, int high) {
            for (int i = low; i <= high; i++) {
                tempList.add(i, list.get(i));
            }
            int i = low;
            int j = middle + 1;
            int k = low;
            
            while (i <= middle && j <= high) {
            	if (tempList.get(i).compareTo(tempList.get(j)) <= 0) {
			list.set(k, tempList.get(i));
                    	i++;
                } else {
                	list.set(k, tempList.get(j));
                    	j++;
                }
                k++;
            }

            while (i <= middle) {
		list.set(k, tempList.get(i));
                k++;
                i++;
            }
	}
}
