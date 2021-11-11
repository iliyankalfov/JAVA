package game;

import javax.swing.JButton;
import java.awt.Color;

/*
 * A class for all the buttons on the board
 */
public class GameButton extends JButton {

	/*
	 * Sets the text of the button, the background color and disables the button
	 * when there is a click
	 */
	public void setSymbol(String symbol) {

		this.setText(symbol);

		if (symbol == "1") {
			this.setBackground(Color.red);
		} else if (symbol == "2") {
			this.setBackground(Color.blue);
		}

		this.setEnabled(false);
	}

	/*
	 * Returns the symbol assigned to the button
	 */
	public String getSymbol() {
		if (this.getText().equals("")) {
			return null;
		} else {
			return this.getText();
		}
	}

	/*
	 * Restarts the game
	 */
	public void reset() {
		this.setText("");
		this.setBackground(null);
		this.setEnabled(true);
	}

}
