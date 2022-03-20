package panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * An introduction page to welcome the user and provide
 * a brief description of the application
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class HomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePage() {
		setLayout(null);
		setBounds(0, 0, 1100, 600);
		
		JLabel homeDesc = new JLabel();
		homeDesc.setHorizontalTextPosition(SwingConstants.CENTER);
		homeDesc.setHorizontalAlignment(SwingConstants.CENTER);
		homeDesc.setFont(new Font("Georgia", Font.PLAIN, 25));
		
		
		homeDesc.setText("<html>Welcome to the Endangered Species Encyclopedia!<br/><br/>"
				+ "Here you can find information on endangered species located here in Utah, <br/>"
				+ "learn more about the different organizations who aim to help those at risk <br/>"
				+ "species as well as find out more information on the different regions in the state."
				+ "<br/><br/><br/><br/><br/><br/>"
				+ "Designed by Jennifer, Penny and Samantha</html>");
		homeDesc.setAlignmentX(CENTER_ALIGNMENT);
		homeDesc.setBounds(110, 298, 859, 421);
		add(homeDesc);	
	}
}