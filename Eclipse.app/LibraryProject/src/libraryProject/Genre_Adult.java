package libraryProject;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * 
 * Displays all available young adult titles for the customer to choose from
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Genre_Adult extends JPanel {
	private JButton potterButton;
	private JButton BtnBackButton;
	private JButton shadowButton;
	private JButton faultButton;
	private JButton hungerButton;
	private JButton btnCartButton;
	private JLabel lblAccountLabel;

	/**
	 * Create the panel.
	 */
	public Genre_Adult() {
		setBackground(new Color(255, 140, 0));
		setLayout(null);

		potterButton = new JButton("Harry Potter");
		potterButton.setBounds(203, 326, 150, 75);
		add(potterButton);

		shadowButton = new JButton("<html><body>Shadow<br>and Bone</body></html>");
		shadowButton.setBounds(357, 326, 150, 75);
		add(shadowButton);

		faultButton = new JButton("<html><body>The Fault in<br><body>Our Stars</body></html>");
		faultButton.setBounds(203, 430, 150, 75);
		add(faultButton);

		hungerButton = new JButton("<html><body>The Hunger<br><body>   Games</body></html>");
		hungerButton.setBounds(357, 430, 150, 75);
		add(hungerButton);

		// Back to Genre Browsing Button
		BtnBackButton = new JButton("Back to Browsing");
		BtnBackButton.setBounds(0, 561, 684, 40);
		add(BtnBackButton);

		// Page Title
		JLabel lblFantasyLabel = new JLabel("Young Adult Titles");
		lblFantasyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFantasyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFantasyLabel.setBounds(216, 240, 247, 39);
		add(lblFantasyLabel);

		// Account Label
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
	 * @return the potter
	 */
	public JButton getPotter() {
		return potterButton;
	}

	/**
	 * @return the shadowButton
	 */
	public JButton getShadowButton() {
		return shadowButton;
	}

	/**
	 * @return the faultButton
	 */
	public JButton getFaultButton() {
		return faultButton;
	}

	/**
	 * @return the hungerButton
	 */
	public JButton getHungerButton() {
		return hungerButton;
	}

	/**
	 * @return the btnBackButton
	 */
	public JButton getBtnBackButton() {
		return BtnBackButton;
	}

	/**
	 * @return the lblAccountLabel
	 */
	public JLabel getLblAccountLabel() {
		return lblAccountLabel;
	}

	/**
	 * @return the btnCartButton
	 */
	public JButton getBtnCartButton() {
		return btnCartButton;
	}
}
