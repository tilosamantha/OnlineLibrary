package libraryProject;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * 
 * Displays all available fantasy titles for the customer to choose from
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Genre_Fantasy extends JPanel {
	private JButton GameThrones;
	private JButton BtnBackButton;
	private JButton hobbitButton;
	private JButton poppyButton;
	private JButton windButton;
	private JButton btnCartButton;
	private JLabel lblAccountLabel;

	/**
	 * Create the panel.
	 */
	public Genre_Fantasy() {
		setBackground(new Color(153, 50, 204));
		setLayout(null);

		GameThrones = new JButton("<html><body>Game of<br>Thrones<br></body></html>");
		GameThrones.setBounds(203, 326, 150, 75);
		add(GameThrones);

		hobbitButton = new JButton("The Hobbit");
		hobbitButton.setBounds(357, 326, 150, 75);
		add(hobbitButton);

		poppyButton = new JButton("The Poppy War");
		poppyButton.setBounds(203, 430, 150, 75);
		add(poppyButton);

		windButton = new JButton("<html><body>The Name<br><body>of the wind</body></html>");
		windButton.setBounds(357, 430, 150, 75);
		add(windButton);

		// Back Button
		BtnBackButton = new JButton("Back to Browsing");
		BtnBackButton.setBounds(0, 561, 684, 40);
		add(BtnBackButton);

		// Page Title
		JLabel lblFantasyLabel = new JLabel("Fantasy Titles");
		lblFantasyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFantasyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFantasyLabel.setBounds(216, 240, 247, 39);
		add(lblFantasyLabel);

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
	 * @return the gameThrones
	 */
	public JButton getGameThrones() {
		return GameThrones;
	}

	/**
	 * @return the hobbitButton
	 */
	public JButton getHobbitButton() {
		return hobbitButton;
	}

	/**
	 * @return the poppyButton
	 */
	public JButton getPoppyButton() {
		return poppyButton;
	}

	/**
	 * @return the windButton
	 */
	public JButton getWindButton() {
		return windButton;
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
