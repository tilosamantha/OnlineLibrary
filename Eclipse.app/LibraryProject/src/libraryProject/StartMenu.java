package libraryProject;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

/**
 * 
 * Welcome page for new users Requests the user's name, email address and phone
 * number to get started
 *
 * @author Mark MacDonald and Samantha Tilo
 */
public class StartMenu extends JPanel {
	private JButton startBrowsingBtn;
	static JTextField nameTextField;
	static JTextField emailTextField;
	static JTextField phoneTextField;

	/**
	 * Create the panel.
	 */
	public StartMenu() {
		setBackground(new Color(0, 191, 255));
		setLayout(null);

		// Browsing Button
		startBrowsingBtn = new JButton("Start Browsing");
		startBrowsingBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		startBrowsingBtn.setBounds(113, 564, 469, 40);
		add(startBrowsingBtn);

		// Welcome Message
		JLabel lblNewLabel = new JLabel("Welcome to CSIS Online Library!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 30));
		lblNewLabel.setBounds(6, 18, 615, 51);
		add(lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Georgia", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(154, 215, 96, 27);
		add(lblName);

		JLabel lblEmail = new JLabel("Email Address:");
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 14));
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(101, 254, 149, 26);
		add(lblEmail);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Georgia", Font.BOLD, 14));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNumber.setBounds(113, 292, 137, 23);
		add(lblPhoneNumber);

		JLabel instructionLabel = new JLabel("Please provide your name and contact information before proceeding.");
		instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		instructionLabel.setBounds(91, 96, 469, 73);
		add(instructionLabel);

		// text fields
		nameTextField = new JTextField();
		nameTextField.setBounds(279, 212, 114, 25);
		add(nameTextField);
		nameTextField.setColumns(10);

		emailTextField = new JTextField();
		emailTextField.setBounds(279, 249, 114, 28);
		add(emailTextField);
		emailTextField.setColumns(10);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(279, 289, 114, 26);
		add(phoneTextField);
		phoneTextField.setColumns(10);

	}

	/**
	 * @return the startBrowsingBtn
	 */
	public JButton getStartBrowsingBtn() {
		return startBrowsingBtn;
	}

	/**
	 * @return the nameTextField
	 */
	public JTextField getNameTextField() {
		return nameTextField;
	}

	/**
	 * @return the emailTextField
	 */
	public JTextField getEmailTextField() {
		return emailTextField;
	}

	/**
	 * @return the phoneTextField
	 */
	public JTextField getPhoneTextField() {
		return phoneTextField;
	}
}
