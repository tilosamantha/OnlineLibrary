package libraryProject;

import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Displays all books that have been selected by the user so far
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Cart_Items extends JPanel {
	private JTextField textField;
	private JButton btnCheckOutButton;
	private JButton BtnBackButton;
	private JLabel lblCartItemsLabel;
	JLabel book1Label;
	JLabel book2Label;
	JLabel book3Label;
	JLabel lblAccountLabel;

	/**
	 * Create the panel.
	 */
	public Cart_Items() {
		setBackground(new Color(219, 112, 147));
		setLayout(null);

		// Account Label
		lblAccountLabel = new JLabel();
		lblAccountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAccountLabel.setBounds(270, 10, 213, 32);
		add(lblAccountLabel);

		lblCartItemsLabel = new JLabel("Your Cart Items:");
		lblCartItemsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartItemsLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		lblCartItemsLabel.setBounds(261, 127, 165, 32);
		add(lblCartItemsLabel);

		// Book Labels
		book1Label = new JLabel();
		book1Label.setOpaque(true);
		book1Label.setBackground(new Color(219, 112, 147));
		book1Label.setFont(new Font("Georgia", Font.BOLD, 20));
		book1Label.setHorizontalAlignment(SwingConstants.CENTER);
		book1Label.setBounds(130, 183, 406, 32);
		add(book1Label);

		book2Label = new JLabel();
		book2Label.setOpaque(true);
		book2Label.setBackground(new Color(219, 112, 147));
		book2Label.setFont(new Font("Georgia", Font.BOLD, 20));
		book2Label.setHorizontalAlignment(SwingConstants.CENTER);
		book2Label.setBounds(130, 250, 406, 32);
		add(book2Label);

		book3Label = new JLabel();
		book3Label.setOpaque(true);
		book3Label.setBackground(new Color(219, 112, 147));
		book3Label.setFont(new Font("Georgia", Font.BOLD, 20));
		book3Label.setHorizontalAlignment(SwingConstants.CENTER);
		book3Label.setBounds(130, 307, 406, 32);
		add(book3Label);

		// Back Button
		BtnBackButton = new JButton("Back to Browsing");
		BtnBackButton.setBounds(161, 518, 144, 40);
		add(BtnBackButton);

		// To Checkout Page
		btnCheckOutButton = new JButton("Checkout");
		btnCheckOutButton.setBounds(367, 518, 144, 40);
		add(btnCheckOutButton);

	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @return the btnBackButton
	 */
	public JButton getBtnBackButton() {
		return BtnBackButton;
	}

	/**
	 * @return the btnCheckOutButton
	 */
	public JButton getBtnCheckOutButton() {
		return btnCheckOutButton;
	}
}
