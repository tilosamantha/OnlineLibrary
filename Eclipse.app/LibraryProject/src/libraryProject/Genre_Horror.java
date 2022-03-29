package libraryProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import java.awt.Font;
import javax.swing.JTextField;

/**
 * 
 * Displays all available horror titles for the customer to choose from
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Genre_Horror extends JPanel {
	private JButton DracButton;
	private JButton shiningButton;
	private JButton magpieButton;
	private JButton frankButton;
	private JButton btnCartButton;
	private JLabel lblAccountLabel;
	private JButton BtnBackButton;

	/**
	 * Create the panel.
	 */
	public Genre_Horror() {
		setBackground(new Color(255, 248, 220));
		setLayout(null);

		// Horror Title Buttons
		DracButton = new JButton("Dracula");
		DracButton.setBounds(203, 326, 150, 75);
		add(DracButton);

		shiningButton = new JButton("The Shining");
		shiningButton.setBounds(357, 326, 150, 75);
		add(shiningButton);

		magpieButton = new JButton("Magpie Lane");
		magpieButton.setBounds(203, 430, 150, 75);
		add(magpieButton);

		frankButton = new JButton("Frankenstien");
		frankButton.setBounds(357, 430, 150, 75);
		add(frankButton);

		// Back to Genre Browsing Button
		BtnBackButton = new JButton("Back to Browsing");
		BtnBackButton.setBounds(0, 561, 684, 40);
		add(BtnBackButton);

		// Page Title
		JLabel lblaHorrorLabel = new JLabel("Horror Titles");
		lblaHorrorLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblaHorrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblaHorrorLabel.setBounds(216, 240, 247, 39);
		add(lblaHorrorLabel);

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
	 * @return the dracButton
	 */
	public JButton getDracButton() {
		return DracButton;
	}

	/**
	 * @return the shinningButton
	 */
	public JButton getShiningButton() {
		return shiningButton;
	}

	/**
	 * @return the magpieButton
	 */
	public JButton getMagpieButton() {
		return magpieButton;
	}

	/**
	 * @return the frankButton
	 */
	public JButton getFrankButton() {
		return frankButton;
	}

	/**
	 * @return the lblAccountLabel
	 */
	public JLabel getLblAccountLabel() {
		return lblAccountLabel;
	}

	/**
	 * @return the btnBackButton
	 */
	public JButton getBtnBackButton() {
		return BtnBackButton;
	}

	/**
	 * @return the btnCartButton
	 */
	public JButton getBtnCartButton() {
		return btnCartButton;
	}
}
