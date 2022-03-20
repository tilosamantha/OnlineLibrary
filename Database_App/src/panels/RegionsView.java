package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

/**
 * Displays information about a selected region independent 
 * from the rest of the table in a more detailed layout
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class RegionsView extends JPanel {

	private JLabel Phone;
	private JLabel Email;
	private JLabel Hours;
	private JLabel endingAddressLbl;
	private JLabel streetAddressLbl;
	private JLabel RegionTitleLbl;
	private JTextArea DescArea;

	/**
	 * Create the panel.
	 */
	public RegionsView() {
		setLayout(null);
		setBounds(100, 100, 1100, 900);
		
        DescArea = new JTextArea();
        DescArea.setBounds(52, 301, 596, 349);
		DescArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        DescArea.setLineWrap(true);
        DescArea.setWrapStyleWord(true);
        add(DescArea);
        
		JPanel ContactPanel = new JPanel();
		ContactPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(85, 107, 47), null, null, null));
		ContactPanel.setBounds(34, 690, 993, 144);
        add(ContactPanel);
        ContactPanel.setLayout(null);
        
        JLabel ContactLbl = new JLabel("Contact Info");
        ContactLbl.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        ContactLbl.setHorizontalAlignment(SwingConstants.CENTER);
        ContactLbl.setBounds(462, 18, 136, 16);
        ContactPanel.add(ContactLbl);
        
        JLabel addressLbl = new JLabel("Mailing Address: ");
        addressLbl.setBounds(229, 46, 125, 16);
        ContactPanel.add(addressLbl);
        
        JLabel EmailLbl = new JLabel("Email Address: ");
        EmailLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        EmailLbl.setBounds(527, 46, 110, 16);
        ContactPanel.add(EmailLbl);
        
        JLabel PhoneLbl = new JLabel("Phone Number: ");
        PhoneLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        PhoneLbl.setBounds(527, 78, 110, 16);
        ContactPanel.add(PhoneLbl);
        
        JLabel HoursLbl = new JLabel("Hours: ");
        HoursLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        HoursLbl.setBounds(527, 114, 110, 16);
        ContactPanel.add(HoursLbl);
        
        streetAddressLbl = new JLabel("New label");
        streetAddressLbl.setBounds(229, 74, 179, 16);
        ContactPanel.add(streetAddressLbl);
        
        endingAddressLbl = new JLabel("New label");
        endingAddressLbl.setBounds(229, 102, 179, 16);
        ContactPanel.add(endingAddressLbl);
        
        Email = new JLabel("New label");
        Email.setBounds(649, 46, 262, 16);
        ContactPanel.add(Email);
        
        Phone = new JLabel("New label");
        Phone.setBounds(649, 78, 262, 16);
        ContactPanel.add(Phone);
        
        Hours = new JLabel("New label");
        Hours.setBounds(649, 114, 262, 16);
        ContactPanel.add(Hours);
		
		JLabel regionMap = new JLabel();
		regionMap.setBounds(702, 279, 306, 373);
		add(regionMap);
		regionMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regions.jpeg")));
		
		JLabel creditLbl = new JLabel("Boyd-Peak, Kari L. Administrative Boundaries PDF Map");
		creditLbl.setFont(new Font("Monospaced", Font.ITALIC, 8));
		creditLbl.setBounds(702, 648, 357, 16);
		add(creditLbl);
		
		JLabel creditLbl2 = new JLabel("Bureau of Land Management. https://www.blm.gov/office/utah-state-office");
		creditLbl2.setFont(new Font("Monospaced", Font.ITALIC, 8));
		creditLbl2.setBounds(702, 662, 357, 16);
		add(creditLbl2);
		
	}

	/**
	 * @return the regionTitleLbl
	 */
	public JLabel getRegionTitleLbl() {
		return RegionTitleLbl;
	}
	
	/**
	 * @return the descArea
	 */
	public JTextArea getDescArea() {
		return DescArea;
	}

	/**
	 * @return the phone
	 */
	public JLabel getPhone() {
		return Phone;
	}

	/**
	 * @return the email
	 */
	public JLabel getEmail() {
		return Email;
	}

	/**
	 * @return the hours
	 */
	public JLabel getHours() {
		return Hours;
	}

	/**
	 * @return the endingAddressLbl
	 */
	public JLabel getEndingAddressLbl() {
		return endingAddressLbl;
	}

	/**
	 * @return the streetAddressLbl
	 */
	public JLabel getStreetAddressLbl() {
		return streetAddressLbl;
	}
}
