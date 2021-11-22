package crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestingCrafting {

	public static void main(String[] args) {
		Map<Resource, Integer> inventory = new HashMap<Resource, Integer>();
		
		inventory.put(Resource.DIAMOND, 3);
		inventory.put(Resource.WOOD, 5);
		inventory.put(Resource.APPLE, 4);
		inventory.put(Resource.GOLD, 3);
		inventory.put(Resource.IRON, 3);
		
		Player player = new Player("Josh", inventory);
		
		Map<Resource, Integer> r1Reqs = new HashMap<Resource, Integer>();
		r1Reqs.put(Resource.IRON, 3);
		r1Reqs.put(Resource.WOOD, 1);
		Recipe r1 = new Recipe(Resource.SWORD, r1Reqs);
		
		Map<Resource, Integer> r2Reqs = new HashMap<Resource, Integer>();
		r2Reqs.put(Resource.DIAMOND, 5);
		Recipe r2 = new Recipe(Resource.HELMET, r2Reqs);
		
		Set<Recipe> set = new HashSet<Recipe>();
		set.add(r1);
		set.add(r2);
		
		player.craft(Resource.HELMET, set);
		System.out.println(player);

	}

}
