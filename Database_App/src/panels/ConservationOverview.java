package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import main.DBConnection;
import sql.SqlConservationEffort;

import javax.swing.JButton;
import java.awt.SystemColor;

/**
 * Class ConservationOverview holds the components for the Conservation Overview
 * and displays data from the ConservationEffort table.
 * 
 * @author Pen
 *
 */

public class ConservationOverview extends JPanel {

	private JButton ceIDButton;
	private JTextField ceIDTextField;
	private JLabel displayErrorLbl;
	private JTextArea ceOverviewTextArea;

	/**
	 * Create the panel.
	 */
	public ConservationOverview() {
        setBackground(UIManager.getColor("Button.background"));
        setLayout(null);
        setBounds(100, 100, 1100, 900);
        
        JPanel panel = new JPanel();
        panel.setBounds(76, 341, 916, 272);
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        ceOverviewTextArea = new JTextArea();
        ceOverviewTextArea.setBounds(10, 10, 896, 251);
		ceOverviewTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        panel.add(ceOverviewTextArea);
        
        JScrollPane scrollPane = new JScrollPane(ceOverviewTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(900, 50));
        panel.add(scrollPane, BorderLayout.EAST);
        
        JPanel cePanel = new JPanel();
        cePanel.setBounds(76, 624, 916, 138);
        add(cePanel);
        cePanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Enter Conservation Effort ID for detailed view:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(10, 11, 341, 36);
        cePanel.add(lblNewLabel);
        
        ceIDTextField = new JTextField();
        ceIDTextField.setBounds(363, 11, 58, 36);
        cePanel.add(ceIDTextField);
        
        ceIDButton = new JButton("Submit");
        ceIDButton.setBounds(463, 12, 89, 35);
        cePanel.add(ceIDButton);
        
        displayErrorLbl = new JLabel("");
        displayErrorLbl.setBounds(10, 58, 266, 36);
        cePanel.add(displayErrorLbl);
        
        JLabel lblNewLabel_1 = new JLabel("Listed below is a complete list of active conservation efforts in the state of Utah");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(76, 298, 916, 16);
        add(lblNewLabel_1);
    }

    /**
     * @return ceIDButton
     */
    public JButton getCeIDButton() {
        return ceIDButton;
    }

    /**
     * @return ceIDTextArea
     */
    public JTextField getCeIDTextField() {
        return ceIDTextField; // TODO: used to capture CE ID number
    }

    /**
     * @return displayErrorLbl
     */
    public JLabel getDisplayErrorLbl() {
        return displayErrorLbl;
    }

    /**
     * @return
     */
    public JTextArea getCeOverviewTextArea() {
        return ceOverviewTextArea;
    }  
}
