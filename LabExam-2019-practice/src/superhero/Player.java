package superhero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

	private GameCharacter[] gameCharacters;

	public Player(GameCharacter[] gameCharacters) {
		this.gameCharacters = gameCharacters;
	}

	public GameCharacter[] getGameCharacters() {
		return this.gameCharacters;
	}
	
	public List<GameCharacter> chooseCharacters(Power[] neededPowers) {
		Arrays.sort(neededPowers);
		List<GameCharacter> returnCharacters = new ArrayList<GameCharacter>();
		
		for (GameCharacter gc: this.gameCharacters) {
			Power[] tempArray = Arrays.copyOf(gc.getPowers() , gc.getPowers().length);
			Arrays.sort(tempArray);
			if (Arrays.equals(neededPowers, tempArray)) {				
				returnCharacters.add(gc);
				return returnCharacters;
			}
		}
		

		for (Power p: neededPowers) {
			boolean flag = false;
			for (GameCharacter gc: this.gameCharacters) {
				if (Arrays.asList(gc.getPowers()).contains(p)) {
					flag = true;
					returnCharacters.add(gc);
					break;
				}
			}
			if (!flag) {
				return null;
			}
		}
		return returnCharacters;
	}

}
