

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String name1 = input.nextLine();
		String name2 = input.nextLine();
		Scanner file1 = readFile(name1, 1);
		Scanner file2 = readFile(name2, 2);
		makeFilePrinting(file1, file2);
		file1.close();
		file2.close();
		input.close();
	}

	private static void makeFilePrinting(Scanner file1,
			Scanner file2) throws FileNotFoundException {
		int a, b;
		
		a = file1.nextInt();
		b = file2.nextInt();
		while (file1.hasNext() && file2.hasNext()) {
			if (a == b) {
				System.out.println(a);
				a = file1.nextInt();
				b = file2.nextInt();
			} else if (a < b) {
				System.out.println(a);
				a = file1.nextInt();
			} else {
				System.out.println(b);
				b = file2.nextInt();
			}
		}
		if (file1.hasNext() == false && file2.hasNext() == true) {
			if (a < b) {
				System.out.println(a);
				while (file2.hasNext()) {
					b = file2.nextInt();
					System.out.println(b);
				}
				System.out.println(b);
			}
		} else if (file1.hasNext() == true && file2.hasNext() == false) {
			if (b < a) {
				System.out.println(b);
				while (file1.hasNext()) {
					a = file1.nextInt();
					System.out.println(a);
				}
				System.out.println(a);
			}
		} else {
			if (a < b) {
				System.out.println(a);
				System.out.println(b);
			} else if (b < a) {
				System.out.println(b);
				System.out.println(a);
			} else {
				System.out.println(a);
			}
		}
		
	}

	private static Scanner readFile(String name, int num) {
		try {
			FileInputStream fstream = new FileInputStream(name);
			return new Scanner(new InputStreamReader(fstream));
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir arquivo " + num);
			return null;
		}

	}
}
