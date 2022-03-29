package libraryProject;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * 
 * Exit Page displays the books checked out by the customer and gives a thank
 * you parting message
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Exit extends JPanel {
	private JTextField textField;
	private JLabel lblRealEmailLabel;
	private JButton BtnBackButton;
	JLabel book1Label;
	JLabel book2Label;
	JLabel book3Label;
	JLabel lblThanksLabel;
	JLabel EmailLabel;

	/**
	 * Create the panel.
	 */
	public Exit() {
		setBackground(new Color(154, 205, 50));
		setLayout(null);

		//Thank you message
		lblThanksLabel = new JLabel();
		lblThanksLabel.setBackground(Color.WHITE);
		lblThanksLabel.setForeground(Color.BLACK);
		lblThanksLabel.setFont(new Font("Georgia", Font.BOLD, 25));
		lblThanksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksLabel.setBounds(93, 97, 462, 32);
		add(lblThanksLabel);

		//Checked Books Header
		JLabel lblCheckOutLabel = new JLabel("You Checked Out:");
		lblCheckOutLabel.setForeground(Color.BLACK);
		lblCheckOutLabel.setBackground(Color.WHITE);
		lblCheckOutLabel.setFont(new Font("Georgia", Font.BOLD, 18));
		lblCheckOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOutLabel.setBounds(218, 141, 223, 27);
		add(lblCheckOutLabel);

		//Checked Books Labels
		book1Label = new JLabel();
		book1Label.setHorizontalAlignment(SwingConstants.CENTER);
		book1Label.setFont(new Font("Georgia", Font.BOLD, 20));
		book1Label.setBounds(93, 195, 462, 32);
		add(book1Label);

		book2Label = new JLabel();
		book2Label.setHorizontalAlignment(SwingConstants.CENTER);
		book2Label.setFont(new Font("Georgia", Font.BOLD, 20));
		book2Label.setBounds(93, 251, 462, 32);
		add(book2Label);

		book3Label = new JLabel();
		book3Label.setFont(new Font("Georgia", Font.BOLD, 20));
		book3Label.setHorizontalAlignment(SwingConstants.CENTER);
		book3Label.setBounds(93, 310, 462, 32);
		add(book3Label);

		JLabel emailConfirmationLabel = new JLabel("An E-mail confirmation has been sent to:");
		emailConfirmationLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		emailConfirmationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailConfirmationLabel.setBounds(154, 358, 345, 16);
		add(emailConfirmationLabel);
		
		//Customer's email
		EmailLabel = new JLabel();
		EmailLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		EmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		EmailLabel.setBounds(191, 386, 265, 32);
		add(EmailLabel);
		
		JLabel partingMessageLabel = new JLabel("Happy reading!");
		partingMessageLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		partingMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partingMessageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		partingMessageLabel.setBounds(191, 430, 266, 32);
		add(partingMessageLabel);
		
		//Closes application
		JButton exitButton = new JButton("Close Application");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(0, 561, 684, 40);
		add(exitButton);
	}
}
