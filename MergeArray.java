import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class MergeArray {
	public static void main(String[] args)
	{
		String fileName = args[0];
		File file = new File(fileName);
		int[] list = new int[800];
		Scanner scanner = createScanner(file);
		int i = 0;
		while(scanner.hasNext()){
//			System.out.println(scanner.nextLine());
			list[i] = Integer.parseInt(scanner.nextLine());
			i++;
		}
		
//		for(Integer i : list){
//			System.out.print(i + " ");
//		}
//		System.out.println(list.size());
		String fileName2 = args[1];
		createFile(fileName2);
		
		runTests(list, Integer.parseInt(args[2]), fileName2);
//		for(Integer i : list2){
//			System.out.print(i + " ");
//		}	
	}
	
	public static void runTests(int[] list, int j, String fileName){
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("Test,Tid");
			for(int i = 1; i <= j; i++){
				long startTime = System.nanoTime();
				MergeSortArray.sort(list);
				//MergeSort.sort(newList);
				long estimatedTime = System.nanoTime() - startTime;
				fw.write("\n" + i + "," + estimatedTime);
//				System.out.println(i + "," + estimatedTime);
			}
			fw.close();
			
		} catch (IOException e) {
			System.out.println("Error...");
		}	
	}
	
	public static Scanner createScanner(File file){
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		return scanner;
	}
	
	public static void createFile(String s){
		File file = new File(s);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error.");
		}
	}
	
	public static class ListSorter <Integer extends Comparable<? super Integer>>{
	}
}
