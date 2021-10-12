public class Question {
	 private String text;
	 private String answer;
	 
	 protected static int ID;
	 
	 public Question(String text, String answer) {
		 this.text = text;
		 this.answer = answer;
		 this.ID += 1;
	 }
	 
	 public Question() {
		 this.ID += 1;
	 }
	 
	 public void setText(String textQuestion) {
		 this.text = textQuestion;
	 }
	 
	 public void setAnswer(String correctAnswer) {
		 this.answer = correctAnswer;
	 }

	 public boolean checkAnswer(String response) {
		 return this.answer.equals(response);
	 }

	 public void printQuestion() {
		 System.out.println(this.ID + ". " + this.text);
	 }
}
