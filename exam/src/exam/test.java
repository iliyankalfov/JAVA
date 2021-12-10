package exam;

public class test {

	public static void main(String[] args) {
		Customer c = new Customer();
		Bicyle b = new Bicyle(5, "road");
		c.rentBike(b);
		System.out.println(c.endRental());
		

	}

}
