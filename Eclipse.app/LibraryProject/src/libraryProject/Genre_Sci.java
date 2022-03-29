package libraryProject;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * 
 * Displays all available science fiction titles for the customer to choose from
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Genre_Sci extends JPanel {
	private JButton AnnaButton;
	private JButton duneButton;
	private JButton btn1984Button;
	private JButton martianButton;
	private JButton btnCartButton;
	private JButton BtnBackButton;
	private JLabel lblAccountLabel;

	/**
	 * Create the panel.
	 */
	public Genre_Sci() {
		setBackground(new Color(32, 178, 170));
		setLayout(null);

		AnnaButton = new JButton("Annihilation");
		AnnaButton.setBounds(203, 326, 150, 75);
		add(AnnaButton);

		duneButton = new JButton("Dune");
		duneButton.setBounds(357, 326, 150, 75);
		add(duneButton);

		btn1984Button = new JButton("1984");
		btn1984Button.setBounds(203, 430, 150, 75);
		add(btn1984Button);

		martianButton = new JButton("The Martian");
		martianButton.setBounds(357, 430, 150, 75);
		add(martianButton);

		BtnBackButton = new JButton("Back to Browsing");
		BtnBackButton.setBounds(0, 561, 684, 40);
		add(BtnBackButton);

		//Title Page Header
		JLabel lblaHorrorLabel = new JLabel("Science Fiction Titles");
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
	 * @return the annaButton
	 */
	public JButton getAnnaButton() {
		return AnnaButton;
	}

	/**
	 * @return the duneButton
	 */
	public JButton getDuneButton() {
		return duneButton;
	}

	/**
	 * @return the btn1984Button
	 */
	public JButton getBtn1984Button() {
		return btn1984Button;
	}

	/**
	 * @return the martianButton
	 */
	public JButton getMartianButton() {
		return martianButton;
	}

	/**
	 * @return the btnCartButton
	 */
	public JButton getBtnCartButton() {
		return btnCartButton;
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
}
