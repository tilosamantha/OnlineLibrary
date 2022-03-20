package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Lists all Region rows in a table to allow for user selection
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class RegionsOverview extends JPanel {

	private JTextArea regionTextArea;
	private JTextField regionIDField;
	private JButton submitBtn;
	private JLabel displayErrorLbl;

	/**
	 * Create the panel.
	 */
	public RegionsOverview() {
		setLayout(null);
		setBounds(100, 100, 1100, 900);

        JPanel panel = new JPanel();
        panel.setBounds(76, 341, 916, 272);
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));
		
        regionTextArea = new JTextArea();
        regionTextArea.setBounds(10, 10, 896, 251);
        regionTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        panel.add(regionTextArea);
        
        JScrollPane scrollPane = new JScrollPane(regionTextArea, 
        		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(900, 50));
        panel.add(scrollPane, BorderLayout.EAST);
        
        JPanel selectionPanel = new JPanel();
        selectionPanel.setBounds(239, 625, 505, 138);
        add(selectionPanel);
        selectionPanel.setLayout(null);
        
        JLabel textFieldLbl = new JLabel("Enter Region ID for a more detailed view:");
        textFieldLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        textFieldLbl.setBounds(10, 11, 266, 36);
        selectionPanel.add(textFieldLbl);
        
        regionIDField = new JTextField();
        regionIDField.setBounds(297, 11, 57, 36);
        selectionPanel.add(regionIDField);
        
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(392, 11, 89, 36);
        selectionPanel.add(submitBtn);
        
        displayErrorLbl = new JLabel("");
        displayErrorLbl.setBounds(10, 58, 266, 36);
        selectionPanel.add(displayErrorLbl);
        
        JLabel lblNewLabel = new JLabel("Listed below are the different regions of Utah determined by the Bureau of Land Management");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(76, 298, 916, 16);
        add(lblNewLabel);
	}

	/**
	 * @return the regionTextArea
	 */
	public JTextArea getRegionTextArea() {
		return regionTextArea;
	}

	/**
	 * @return the regionIDField
	 */
	public JTextField getRegionIDField() {
		return regionIDField;
	}

	/**
	 * @return the submitBtn
	 */
	public JButton getSubmitBtn() {
		return submitBtn;
	}

	/**
	 * @return the displayErrorLbl
	 */
	public JLabel getDisplayErrorLbl() {
		return displayErrorLbl;
	}

}
