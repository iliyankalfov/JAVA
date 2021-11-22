package crafting;

import java.util.Map;

public class Recipe {
	
	private Resource result;
	private Map<Resource, Integer> requirements;
	
	public Recipe(Resource result, Map<Resource, Integer> requirements) {
		this.result = result;
		this.requirements = requirements;
	}

	public Resource getResult() {
		return result;
	}

	public Map<Resource, Integer> getRequirements() {
		return requirements;
	}
	
	

}
