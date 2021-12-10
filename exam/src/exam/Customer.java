package exam;

import java.time.Duration;
import java.time.Instant;

public class Customer {
	private Bicyle bikeRented;
	private Instant currentTime;

	public void rentBike(Bicyle bike) throws IllegalArgumentException{
		if ((!bike.isAvailable()) || (this.bikeRented != null)){
			throw new IllegalArgumentException("The bicycle cannot be rented!");
		}
		bike.setAvailable(false);
		this.bikeRented = bike;
		this.currentTime = Instant.now();
	}
	
	public double endRental() throws IllegalArgumentException{
		if (this.bikeRented.isAvailable() != false) {
			throw new IllegalArgumentException("The bicycle cannot be rented!");
		}
		this.bikeRented.setAvailable(false);
		Instant endTime = Instant.now();
		long rentalTime = Duration.between(this.currentTime, endTime).toHours();
		return rentalTime * 2;
	}
}