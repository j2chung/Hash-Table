package cs21as05;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;


public class hashTable{	
	final double c = (Math.sqrt(5) - 1) / 2;
	private ArrayList<ArrayList<Record>> A;
	private int m;
	
	public hashTable() {
		A = new ArrayList<ArrayList<Record>>(100);
		for(int i = 0; i < 100; i++) {
			A.add(new ArrayList<Record>());
		}
		m = A.size();
	}
	
	public hashTable(int n){
		A = new ArrayList<ArrayList<Record>>(n);
		for(int i = 0; i < n; i++) {
			A.add(new ArrayList<Record>());
		}
		m = A.size();
	}
	
	public void clear() {
		A.clear();
		for(int i = 0; i < m; i++) {
			A.add(new ArrayList<Record>());
		}
	}
	
	public void readFile(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = br.readLine()) != null) {
				insert(new Record(line));
			}
		} catch (FileNotFoundException e) {
			System.out.print
		}
	}
	
	public void writeFile(String file) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for(int i = 0; i < A.size(); i++) {
				for (int j = 0; j < A.get(i).size(); j++) {
					System.out.println(A.get(i).get(j).getData());
					bw.write(A.get(i).get(j).getData());
					bw.newLine();
					bw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Record rec) {
		if (rec != null) {
			int key = hash(rec.getID());
			if (key < m) {		
				A.get(key).add(rec);
			}
		}
	}	
	
	public void delete(int key){
		int index = hash(key);
		if (index < m) {
			for (int i = 0; i < A.get(index).size(); i++) {
				if (A.get(index).get(i).getID() == key) {
					A.get(index).remove(i);
				}
			}
		}
	}
	
	public Record search(int key){
		int index = hash(key);
		if (index < m) {
			for (int i = 0; i < A.get(index).size(); i++) {
				if (A.get(index).get(i).getID() == key) {
					return A.get(index).get(i);
				}
			}
			
		}
		return null;	
	}
	
	private Record find(int key){
		int index = hash(key);
		if (index < m) {
			for (int i = 0; i < A.get(index).size(); i++) {
				if (A.get(index).get(i).getID() == key) {
					return A.get(index).get(i);
				}
			}
			
		}
		return null;	
	}
	
	private int hash(Record rec) {
		return (int)Math.floor(m * ((rec.getID() * c - Math.floor(rec.getID() * c))));
	}
	
	
	private int hash(int key){
		return (int)Math.floor(m * ((key * c - Math.floor(key * c))));
	} 
}

	
	