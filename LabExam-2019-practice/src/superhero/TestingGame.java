package superhero;

public class TestingGame {

	public static void main(String[] args) {
		GameCharacter[] gcs = new GameCharacter[5];
		Power[] r = {Power.WEAPONS};
		gcs[0] = new GameCharacter("Robin", r);
		
		Power[] s = {Power.FLIGHT, Power.ENERGY_BLAST};
		gcs[1] = new GameCharacter("Starfire", s);
		
		Power[] c = {Power.STRENGTH, Power.WEAPONS};
		gcs[2] = new GameCharacter("Cyborg", c);
		
		Power[] bb = {Power.TRANSFORMATION};
		gcs[3] = new GameCharacter("Beast Boy", bb);
		
		Power[] ra = {Power.MAGIC};
		gcs[4] = new GameCharacter("Raven", ra);
		
		Player player = new Player(gcs);
		Power[] powers = {Power.WEAPONS, Power.MAGIC};
		System.out.println(player.chooseCharacters(powers));
		

	}

}
