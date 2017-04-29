import java.util.LinkedList;

public class InsertionSort {
	public static LinkedList<Integer> sort(LinkedList<Integer> list){
		for(int i = 0; i < list.size(); i++){
			int tempi = list.get(i);
			int j = i - 1;
			while(j >= 0 &&  list.get(j) > tempi){
				list.set(j + 1, list.get(j));
				j--;
			}
			list.set(j + 1, tempi);
		}
		return list;	
	}
}
