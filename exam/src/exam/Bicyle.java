package exam;

public class Bicyle {

	private int id;
	private String type;
	private boolean available;
	
	public Bicyle(int id, String type) {
		this.id = id;
		this.type = type;
		this.available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	// Bicycle bike = new Bicyle(5, "Details");
	
	

}
