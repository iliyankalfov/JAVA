package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener {

	private GameButton[][] buttons;
	private JButton resetButton;
	private JLabel statusLabel;

	// A property to keep track of the current player
	private String currentPlayer = "1";
	// A property showing who the winner is if there is one
	private String winner = "";

	public GameWindow(int size) {
		super("Let's play a game!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		statusLabel = new JLabel("Current player: " + this.currentPlayer);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(size, size));

		buttons = new GameButton[size][];
		for (int i = 0; i < size; i++) {
			buttons[i] = new GameButton[size];
			for (int j = 0; j < size; j++) {
				GameButton button = new GameButton();
				button.setFont(button.getFont().deriveFont(25.0f));
				button.setPreferredSize(new Dimension(100, 100));
				buttonPanel.add(button);
				buttons[i][j] = button;
				buttons[i][j].addActionListener(this);
			}
		}

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(statusLabel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.CENTER);

		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		getContentPane().add(resetButton, BorderLayout.SOUTH);

		pack();
	}

	/**
	 * Main method -- just creates and displays the window.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameWindow(4).setVisible(true);
			}
		});
	}

	/*
	 * A method checking if the game ended because there was a winner
	 */
	private boolean endGameBecauseOfWinner() {
		boolean endGame = false;

		for (int i = 0; i < this.buttons.length - 1; i++) {
			for (int j = 0; j < this.buttons[i].length - 1; j++) {
				/*
				 * Comparing the symbol on every 4 blocks across the board
				 */
				if ((buttons[i][j].getSymbol() != null)
						&& (buttons[i][j].getSymbol() == buttons[i][j + 1].getSymbol())) {

					String symbolToCompare = buttons[i][j].getSymbol();

					if ((buttons[i + 1][j].getSymbol() != null)
							&& (buttons[i + 1][j].getSymbol() == buttons[i + 1][j + 1].getSymbol())) {

						if (symbolToCompare == buttons[i + 1][j + 1].getSymbol()) {
							this.winner = symbolToCompare;
							endGame = true;
						}
					}
				}
			}
		}
		return endGame;
	}

	/*
	 * A method checking if the game has ended
	 */
	private boolean endGame() {
		if (this.endGameBecauseOfWinner()) {
			return this.endGameBecauseOfWinner();
		} else {
			boolean fullBoard = true;
			for (int i = 0; i < this.buttons.length; i++) {
				for (GameButton button : buttons[i]) {
					if (button.getSymbol() == null) {
						fullBoard = false;
					}
				}
			}
			return fullBoard;
		}

	}

	/*
	 * An action-listener method called on mouse click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * If the reset button is clicked, the game restarts
		 */
		if (e.getSource() == this.resetButton) {
			for (int i = 0; i < buttons.length; i++) {
				for (int j = 0; j < buttons[i].length; j++) {
					buttons[i][j].reset();
				}
			}
			this.currentPlayer = "1";
			this.winner = "";
			statusLabel.setText("Current player: " + this.currentPlayer);
		} else {
			GameButton clickedButton = (GameButton) e.getSource();

			clickedButton.setSymbol(this.currentPlayer);
			/*
			 * Checks if a game has ended and acts accordingly
			 */
			if (endGame()) {
				for (int i = 0; i < buttons.length; i++) {
					for (int j = 0; j < buttons[i].length; j++) {
						buttons[i][j].setEnabled(false);
					}
				}

				if (this.winner != "") {
					statusLabel.setText("Winner: Player " + this.currentPlayer);
				} else {
					statusLabel.setText("Board is full with no winner");
				}
			} else {
				if (this.currentPlayer == "1") {
					this.currentPlayer = "2";
				} else if (this.currentPlayer == "2") {
					this.currentPlayer = "1";
				}
				statusLabel.setText("Current player: " + this.currentPlayer);
			}
		}
	}
}
