/**
 * Represents a True/False question.
 */
public class TrueFalseQ extends Question {

	/**
	 * Sets the correct answer, which must be "True" or "False".
	 * 
	 * @param correctAnswer The answer to set
	 */
	public void setAnswer(String correctAnswer) {
		if (!(correctAnswer.equals("True")) && !(correctAnswer.equals("False"))) {
			throw new IllegalArgumentException("The correct answer must be either True of False");
		} else {
			super.setAnswer(correctAnswer);
		}
	}

	/**
	 * Prints the question, along with a prompt to answer either "True" or "False".
	 */
	public void printQuestion() {
		super.printQuestion();
		System.out.println("Please answer \"True\" or \"False\".");
	}

	/**
	 * Validates the answer of the question
	 */
	public boolean validate() {
		if ((this.answer != null) && (this.answer == "True" || this.answer == "False")) {
			return true;
		} else {
			return false;
		}
	}
}