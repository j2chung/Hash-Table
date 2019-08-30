package cs21as05;

public class Record implements Cloneable{
	private int id;
	private String data;

	public Record() {
		id = 0;
		data = "";
	}
	
	public Record(String n) {
		id = Integer.valueOf(n.substring(0, 9));
		data = n;
	}
	
	public int getID() {
		return id;
	} // or something similar
	
	public String getData() {
		return data;
	}
  // anything else that you think is appropriate
}