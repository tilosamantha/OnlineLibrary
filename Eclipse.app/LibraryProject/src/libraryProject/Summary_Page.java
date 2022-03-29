package libraryProject;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * 
 * Displays book details including title, author, summary and availability for
 * the user to learn more
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class Summary_Page extends JPanel {
	static JLabel lblAccountLabel;
	static JButton btnCartButton;
	JLabel summaryLabel;
	JButton AddBtn;
	JButton BackToTitleBtn;

	/**
	 * Create the panel.
	 */
	public Summary_Page() {
		setBackground(new Color(144, 238, 144));
		setLayout(null);

		// Book Summary Details Label
		summaryLabel = new JLabel();
		summaryLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		summaryLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		summaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		summaryLabel.setBounds(43, 101, 634, 411);
		add(summaryLabel);

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

		// Back Button
		BackToTitleBtn = new JButton("Back to Browsing");
		BackToTitleBtn.setBounds(43, 524, 286, 40);
		add(BackToTitleBtn);

		// Add to Cart Button
		AddBtn = new JButton("Add to Cart");
		AddBtn.setBounds(378, 524, 286, 40);
		add(AddBtn);
	}

	public JButton getAddBtn() {
		return AddBtn;
	}

	public JButton getBackToTitleBtn() {
		return BackToTitleBtn;
	}

	public JButton getCartBtn() {
		return btnCartButton;
	}

}
