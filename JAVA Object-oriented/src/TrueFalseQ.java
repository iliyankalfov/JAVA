
public class TrueFalseQ extends Question{

	public void setAnswer(String correctAnswer) {
		if ((correctAnswer != "True") && (correctAnswer != "False")) {
			System.out.println("A valid answer must be either \"True\" or \"False\"");
		}
		else {
			super.setAnswer(correctAnswer);
		}
	}
	
	 public void printQuestion() {
		 super.printQuestion();
		 
		 System.out.println("Please answer \"True\" or \"False\"");
	 }

}
