package superhero;

import java.util.Arrays;
import java.util.Objects;

public class GameCharacter {
	private String name;
	private Power[] powers;
	
	public GameCharacter(String name, Power[] powers) {
		this.name = name;
		this.powers = powers;
	}

	public String getName() {
		return name;
	}

	public Power[] getPowers() {
		return powers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(powers);
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameCharacter other = (GameCharacter) obj;
		return Objects.equals(name, other.name) && Arrays.equals(powers, other.powers);
	}

	@Override
	public String toString() {
		return "GameCharacter [name=" + name + ", powers=" + Arrays.toString(powers) + "]";
	}
	
	

}
