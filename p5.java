package cs21as05;
import java.util.Scanner;

public class p5 {
	public static void main(String[] args) {
		hashTable ht = new hashTable(178000);
		Scanner stdin = new Scanner(System.in);
		String choice; //options
		String inputData; //Data 
		String inputKey; //Key
		Record temp;
		boolean quit = false;
		while(quit == false) {
			System.out.print("(1)load (2)insert (3)delete (4)search (5)clear (6)save (7)quit -- Your choice? ");
			choice = stdin.nextLine();
			if (choice.equals("1")) {
				System.out.print("read hash table - filename? ");
				ht.readFile(stdin.nextLine());
			} else if (choice.equals("2")) {
				System.out.print("input new record:");
				inputData = stdin.nextLine();
				ht.insert(new Record(inputData));
			} else if (choice.equals("3")) {
				System.out.print("delete record - key? ");
				inputKey = stdin.nextLine();
				ht.delete(Integer.valueOf(inputKey));
				
			} else if (choice.equals("4")) {
				System.out.print("search for record - key? ");
				inputKey = stdin.nextLine();
				temp = ht.search(Integer.valueOf(inputKey));
				if (temp != null) {
					System.out.println("Found: " + temp.getData());
				} else { 
					System.out.println("Search not found: " + inputKey);				
				}
			} else if (choice.equals("5")) {
				System.out.println("clearing hash table.");
				ht.clear();
			} else if (choice.equals("6")) {
				System.out.print("write hash table - filename? ");
				ht.writeFile(stdin.nextLine());
			} else if (choice.equals("7")) {
				quit = true;
			}
			
		}
	}
}
