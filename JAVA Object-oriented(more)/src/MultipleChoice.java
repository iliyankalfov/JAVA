/**
 * Represents a question with a given number of multiple-choice options.
 */
public class MultipleChoice extends Question {

	/** The number of choices */
	private int numberOfChoices;

	/** The list of choices */
	private String[] choices;

	/** Which choice will be added next */
	private int choiceCounter = 0;

	/**
	 * Creates a new multiple choice question with the given number of choices
	 * 
	 * @param nChoices The number of choices given to the constructor.
	 */
	public MultipleChoice(int nChoices) {
		if (nChoices <= 0) {
			throw new IllegalArgumentException("The number of choices must greater than 0!");
		} else {
			this.numberOfChoices = nChoices;
			this.choices = new String[this.numberOfChoices];
		}
	}

	/**
	 * Adds the given choice to the list if there is space.
	 * 
	 * @param choice  The choice to add
	 * @param correct Whether the choice should be considered correct
	 */

	public void addChoice(String choice, boolean correct) {
		if (this.choiceCounter >= this.numberOfChoices) {
			throw new IllegalArgumentException("Cannot have more than " + this.numberOfChoices + " choices");
		} else {
			choices[this.choiceCounter] = choice;
			this.choiceCounter++;

			if (correct) {
				String answer = id + "." + choiceCounter + "";
				setAnswer(answer);
			}
		}
	}

	/**
	 * Prints the question followed by all of the multiple-choice options.
	 * 
	 * @see Question#printQuestion()
	 */
	public void printQuestion() {
		super.printQuestion();
		for (int i = 0; i < this.numberOfChoices; i++) {
			if (choices[i] != null) {
				System.out.println(id + "." + (i + 1) + " " + choices[i]);
			}
		}
	}

	/**
	 * Validates the question by returning true if all the choice have been set and
	 * there are no two identical choices and false otherwise.
	 */
	public boolean validate() {
		boolean flag = true;

		if ((this.choices.length != this.numberOfChoices) || (this.answer == null)) {
			flag = false;
		}

		for (int i = 0; i < this.choices.length; i++) {
			for (int y = i + 1; y < this.choices.length; y++) {
				if (this.choices[i] == this.choices[y]) {
					flag = false;
				}
			}
		}

		return flag;

	}

}