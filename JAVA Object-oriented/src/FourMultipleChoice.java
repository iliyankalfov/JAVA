
public class FourMultipleChoice extends Question{
	private String[] choices = new String[4];
	private int index = 0;

	public void addChoice(String choice, boolean correct) {
		if (index <= 3) { 
			this.choices[index] = choice;
					
			if (correct) {
				this.setAnswer(this.ID + "." + (this.index + 1));
			}
			this.index ++;
		}
	}
	
	public void printQuestion() {
		super.printQuestion();
		
		for(int i=0;i<index;i++) {
			System.out.println(this.ID + "." + (i+1) + " " + this.choices[i]);
		}
	}

}
