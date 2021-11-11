/**
 * Represents a quiz of questions.
 */
public class Quiz {

	/** The number of questions in the quiz */
	private int numberOfQuestions;

	/** A list with all the questions in the quiz */
	private Question[] questions;

	/**
	 * Creates a quiz with the given number of questions.
	 * 
	 * @param nQuestions Number of questions consisting the quiz.
	 */
	public Quiz(int nQuestions) {
		this.numberOfQuestions = nQuestions;
		this.questions = new Question[this.numberOfQuestions];
	}

	/**
	 * Sets the question in the specified position in the quiz.
	 * 
	 * @param n Position of the question in the quiz
	 * @param q The question to be added.
	 */
	public void setQuestion(int n, Question q) {
		if ((n < 0) || (n >= this.numberOfQuestions)) {
			throw new IllegalArgumentException("Index out of range: " + n);
		} else {
			this.questions[n] = q;
		}
	}

	/**
	 * Prints the content of the quiz.
	 */
	public void printQuiz() {
		for (int i = 0; i < this.questions.length; i++) {
			this.questions[i].printQuestion();
		}
	}

	/**
	 * Validates the quiz by returning false if one of the questions is null or
	 * validates as false and returns true otherwise
	 * 
	 * @return
	 */
	public boolean validate() {
		boolean flag = true;

		for (int i = 0; i < this.questions.length; i++) {
			if ((this.questions[i] == null) || (flag != this.questions[i].validate())) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
