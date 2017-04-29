import java.util.LinkedList;
import java.util.ListIterator;

public class Bubblesort{
	public static LinkedList<Integer> sort(LinkedList<Integer> list){
		boolean stop = false;
		while(!stop){
			ListIterator<Integer> itf = list.listIterator();
			ListIterator<Integer> its = list.listIterator();
			its.next();
			stop = true;
			while(its.hasNext()){
				int first = itf.next();
				int second = its.next();
				if(first > second){
					its.set(first);
					itf.set(second);
					stop = false;
				}
			}
		}
		return list;
	}
}
