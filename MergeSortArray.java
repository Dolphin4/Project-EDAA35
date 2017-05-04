public class MergeSortArray{
	private static int[] list;
        private static int[] tempList;
        private static int length;
       
		
	public static int[] sort(int[] list2){
		list = list2;
		length = list.length;
		tempList = new int[length];
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
                tempList[i] = list[i];
            }
            int i = low;
            int j = middle + 1;
            int k = low;
            
            while (i <= middle && j <= high) {
            	if (tempList[i] <= tempList[j]) {
		list[k] = tempList[i];
                i++;
                } else {
                	list[k] = tempList[j];
                    	j++;
                }
                k++;
            }
            
	    while (i <= middle) {
            	list[k] = tempList[i];
                k++;
                i++;
            }
	}
}
