package crafting;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Player {
	private String name;
	private Map<Resource, Integer> inventory;
	
	public Player(String name, Map<Resource, Integer> inventory) {
		this.name = name;
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public Map<Resource, Integer> getInventory() {
		return inventory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inventory, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(inventory, other.inventory) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", inventory=" + inventory + "]";
	}
	
	public boolean craft(Resource resource, Set<Recipe> recipes) {
		boolean exists = false;
		for(Recipe r: recipes) {
			if (resource == r.getResult()) {
				exists = true;
				
				Map<Resource, Integer> recipeRequirements = r.getRequirements();

				for (Resource key : recipeRequirements.keySet()) {
					if (this.inventory.containsKey(key)) {
						if (r.getRequirements().get(key) <= this.inventory.get(key)) {
							int amount = this.inventory.get(key);
							amount -= r.getRequirements().get(key);
							if (amount == 0) {
								this.inventory.remove(key);
							}
							else {
								this.inventory.put(key, amount);
							}
							this.inventory.put(resource, 1);
						}
						else {
							System.out.println("Not enough resuorces to craft a " + resource);
							return false;
						}
					}
					else {
						return false;
					}
				}
			}
			
		}
		return exists;
	}

}
