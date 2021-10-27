
public class mainClass {

	public static void main(String[] args) {
//		MultipleChoice q = new MultipleChoice(4);
//		q.setText("How high am I?");
//		q.addChoice("156", false);
//		q.addChoice("189", false);
//		q.addChoice("186", true);
//		q.addChoice("199", false);
//		
//		q.printQuestion();
//		
//		System.out.println(q.checkAnswer("1.1"));
//		System.out.println(q.checkAnswer("1.3"));
//		
//		TrueFalseQ tfq = new TrueFalseQ();
//		tfq.setText("Was C++ invented before Java?");
//		tfq.setAnswer("Lala");
//		tfq.printQuestion();
//		
//		System.out.println(tfq.checkAnswer("True"));

		Question q = new TrueFalseQ();
		q.setText("Is this true?");
		// System.out.println(q.validate());

		// q.setAnswer("Lala");

		q.setAnswer("True");

		// System.out.println(q.validate());

		MultipleChoice mcq = new MultipleChoice(2);
		System.out.println(mcq.validate());

		mcq.addChoice("One", false);
		mcq.addChoice("One", true);
		System.out.println(mcq.validate());

		mcq = new MultipleChoice(2);
		mcq.addChoice("One", false);
		mcq.addChoice("Two", true);
		mcq.setText("Which is better? ");

		// System.out.println(mcq.validate());

		Quiz quiz = new Quiz(3);
		System.out.println(quiz.validate());

		// quiz.setQuestion(3, q);
		quiz.setQuestion(0, q);

		System.out.println(quiz.validate());

		quiz.setQuestion(1, mcq);
		System.out.println(quiz.validate());

		//quiz.printQuiz();
		
		Question newq = new TrueFalseQ();
		newq.setText("Is this false?");
		newq.setAnswer("False");
		
		quiz.setQuestion(2, newq);
		System.out.println(quiz.validate());
		
		quiz.printQuiz();


	}

}
