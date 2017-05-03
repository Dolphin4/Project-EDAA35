import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Java {
	
	public static void main(String[] args) {
		File in = new File(args[0]);
		File out = new File(args[1]);
		try {
			out.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		int sortTimes = Integer.parseInt(args[2]);
		LinkedList<Integer> list = new LinkedList<Integer>();
		Scanner s;
		try {
			s = new Scanner(in);
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found, check file name and try again!");
			return;
		}
		while(s.hasNextInt()){
			list.add(s.nextInt());
		}
		s.close();
		PrintWriter writer;
		try {
			writer = new PrintWriter(out);
		} catch (FileNotFoundException e1) {
			System.out.println("Output file not found, why wasn't it created?");
			return;
		}
		writer.println("Löpnummer, Tid");
		for(int i = 1; i <= sortTimes; i++){
			@SuppressWarnings("unchecked")
			LinkedList<Integer> temp = (LinkedList<Integer>) list.clone();
			long start = System.nanoTime();
			Collections.sort(temp);
			long stop = System.nanoTime();
			String output = i + ", " + (stop - start);
			writer.println(output);
		}
		writer.close();
	}

}
