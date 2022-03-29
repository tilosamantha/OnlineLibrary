package libraryProject;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * Displays all genres the customer can select for more titles
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Genre_Page extends JPanel {
	private JButton btnHorrorButton = new JButton("HORROR");
	private JButton btnScifi = new JButton("SCI-FI");
	private JButton btnFantasyButton = new JButton("FANTASY");
	private JButton btnAdultButton = new JButton("<html><body>YOUNG<br>ADULT</body></html>");
	static JButton btnCartButton;
	static JLabel lblAccountLabel;

	/**
	 * Create the panel.
	 */
	public Genre_Page() {
		setBackground(Color.RED);
		setLayout(null);

		// Genre Buttons
		btnHorrorButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnHorrorButton.setBounds(201, 302, 150, 75);
		add(btnHorrorButton);

		btnScifi.setFont(new Font("Impact", Font.PLAIN, 15));
		btnScifi.setBounds(354, 302, 150, 75);
		add(btnScifi);

		btnFantasyButton.setFont(new Font("Segoe Print", Font.ITALIC, 14));
		btnFantasyButton.setBounds(201, 414, 150, 75);
		add(btnFantasyButton);

		btnAdultButton.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btnAdultButton.setBounds(354, 414, 150, 75);
		add(btnAdultButton);

		// Page Title
		JLabel lblBrowseLabel = new JLabel("Browse By Genre");
		lblBrowseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrowseLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBrowseLabel.setBounds(201, 201, 247, 39);
		add(lblBrowseLabel);

		// Account holder
		lblAccountLabel = new JLabel();
		lblAccountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAccountLabel.setBounds(270, 10, 213, 32);
		add(lblAccountLabel);

		// Your cart button
		btnCartButton = new JButton();
		btnCartButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCartButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnCartButton.setBounds(520, 10, 144, 40);
		add(btnCartButton);
	}

	/**
	 * @return the btnCartButton
	 */
	public JButton getBtnCartButton() {
		return btnCartButton;
	}

	/**
	 * @return the btnNewButton
	 */
	public JButton getHorrorButton() {
		return btnHorrorButton;
	}

	/**
	 * @return the btnScifi
	 */
	public JButton getBtnScifi() {
		return btnScifi;
	}

	/**
	 * @return the btnFantasyButton
	 */
	public JButton getBtnFantasyButton() {
		return btnFantasyButton;
	}

	/**
	 * @return the btnAdultButton
	 */
	public JButton getBtnAdultButton() {
		return btnAdultButton;
	}
}
