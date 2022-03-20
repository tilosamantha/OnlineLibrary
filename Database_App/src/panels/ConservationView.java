package panels;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import sql.SqlESAConservationStatus;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Class ConservationView contains components for the ConservationView panel and
 * is designed to display a detailed view of the Conservation Effort.
 * 
 * @author Pen
 *
 */
@SuppressWarnings("serial")
public class ConservationView extends JPanel {

	private JTextArea commNameTextArea;
	private JTextArea sciNameTextArea;
	private JTextArea conservStatusTextArea;
	private JTextArea startDateTextArea;
	private JTextArea orgTextArea;
	private JTextArea websiteTextArea;
	private JTextArea locTextArea;
	private JComboBox<String> updateColumnBox;
	
	private JButton updateStartDateBtn;
	private JButton updateStartDateBtn_1;
	private JButton updateOrgSubmitBtn;
	private JButton updateWebsiteSubmitBtn;
	private JButton updateLocationSubmitBtn;
	private JComboBox<String> updateConStatComboBox;
	protected Object getUpdateStartDateBtn;
	private JButton deleteBtn;
	private JButton updateEntryBtn;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public ConservationView() {
		setLayout(null);
		setBounds(100, 100, 1100, 900);

		JPanel conservPanel = new JPanel();
		conservPanel.setBackground(SystemColor.inactiveCaption);
		conservPanel.setBounds(37, 324, 478, 482);
		add(conservPanel);
		conservPanel.setLayout(null);

		JLabel commonLbl = new JLabel("Common name:");
		commonLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		commonLbl.setBounds(5, 57, 150, 30);
		conservPanel.add(commonLbl);

		JLabel sciLbl = new JLabel("Scientific name:");
		sciLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		sciLbl.setBounds(5, 162, 150, 30);
		conservPanel.add(sciLbl);

		JLabel conservStatusLbl = new JLabel("Conservation status:");
		conservStatusLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		conservStatusLbl.setBounds(5, 253, 150, 30);
		conservPanel.add(conservStatusLbl);

		JLabel startDateLbl = new JLabel("Start date:");
		startDateLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		startDateLbl.setBounds(5, 363, 150, 30);
		conservPanel.add(startDateLbl);

		commNameTextArea = new JTextArea();
		commNameTextArea.setBackground(Color.WHITE);
		commNameTextArea.setBounds(165, 57, 217, 29);
		commNameTextArea.setEditable(false);
		conservPanel.add(commNameTextArea);

		sciNameTextArea = new JTextArea();
		sciNameTextArea.setBackground(Color.WHITE);
		sciNameTextArea.setBounds(165, 162, 217, 30);
		sciNameTextArea.setEditable(false);
		conservPanel.add(sciNameTextArea);

		conservStatusTextArea = new JTextArea();
		conservStatusTextArea.setBackground(Color.WHITE);
		conservStatusTextArea.setBounds(165, 253, 217, 29);
		conservStatusTextArea.setEditable(false);
		conservPanel.add(conservStatusTextArea);

		startDateTextArea = new JTextArea();
		startDateTextArea.setEditable(false);
		startDateTextArea.setBackground(Color.WHITE);
		startDateTextArea.setBounds(165, 363, 166, 30);
		conservPanel.add(startDateTextArea);

		updateConStatComboBox = new JComboBox<>();
		updateConStatComboBox.setVisible(false);
		updateConStatComboBox.setBounds(165, 290, 217, 22);
		conservPanel.add(updateConStatComboBox);
		
		updateStartDateBtn_1 = new JButton("Submit Update");
		updateStartDateBtn_1.setBounds(343, 363, 122, 31);
		conservPanel.add(updateStartDateBtn_1);
		updateStartDateBtn_1.setVisible(false);

		/*
		 * Queries the database for the ESA status and gets added to the JComboBox and
		 * displays as a drop-down.
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlESAConservationStatus.allData());
			while (results.next()) {
				String name = results.getString("Status");
				updateConStatComboBox.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel orgPanel = new JPanel();
		orgPanel.setBackground(SystemColor.inactiveCaption);
		orgPanel.setBounds(546, 324, 502, 237);
		add(orgPanel);
		orgPanel.setLayout(null);

		JLabel orgLbl = new JLabel("Organization:");
		orgLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		orgLbl.setBounds(9, 31, 112, 30);
		orgPanel.add(orgLbl);

		orgTextArea = new JTextArea();
		orgTextArea.setBackground(Color.WHITE);
		orgTextArea.setBounds(133, 31, 196, 29);
		orgTextArea.setEditable(false);
		orgPanel.add(orgTextArea);

		JLabel websiteLbl = new JLabel("Website:");
		websiteLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		websiteLbl.setBounds(9, 93, 112, 30);
		orgPanel.add(websiteLbl);

		websiteTextArea = new JTextArea();
		websiteTextArea.setBackground(Color.WHITE);
		websiteTextArea.setBounds(133, 93, 196, 29);
		websiteTextArea.setEditable(false);
		orgPanel.add(websiteTextArea);

		JLabel locLbl = new JLabel("Location:");
		locLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		locLbl.setBounds(9, 159, 112, 30);
		orgPanel.add(locLbl);

		locTextArea = new JTextArea();
		locTextArea.setBackground(Color.WHITE);
		locTextArea.setBounds(133, 158, 196, 30);
		locTextArea.setEditable(false);
		orgPanel.add(locTextArea);

		updateOrgSubmitBtn = new JButton("Submit Update");
		updateOrgSubmitBtn.setVisible(false);
		updateOrgSubmitBtn.setBounds(339, 31, 125, 34);
		orgPanel.add(updateOrgSubmitBtn);

		updateWebsiteSubmitBtn = new JButton("Submit Update");
		updateWebsiteSubmitBtn.setVisible(false);
		updateWebsiteSubmitBtn.setBounds(339, 93, 125, 34);
		orgPanel.add(updateWebsiteSubmitBtn);

		updateLocationSubmitBtn = new JButton("Submit Update");
		updateLocationSubmitBtn.setVisible(false);
		updateLocationSubmitBtn.setBounds(339, 159, 125, 34);
		orgPanel.add(updateLocationSubmitBtn);

		updateEntryBtn = new JButton("Update Entry");
		updateEntryBtn.setAlignmentX(0.5f);
		updateEntryBtn.setBounds(546, 659, 200, 50);
		add(updateEntryBtn);

		// Delete effort from table
		deleteBtn = new JButton("Remove from Table");
		deleteBtn.setBounds(546, 584, 200, 50);
		add(deleteBtn);

		String[] updateColumn = { "Select Column to Update", "Start date", "Organization", "Website", "Location" };

		updateColumnBox = new JComboBox(updateColumn);
		updateColumnBox.setBounds(776, 659, 260, 50);
		updateColumnBox.setVisible(false);
		add(updateColumnBox);
	}

	/**
	 * Returns the update conservation status combo box.
	 * 
	 * @return updateConStatComboBox
	 */
	public JComboBox<String> getUpdateConservationStatusComboBox() {
		return updateConStatComboBox;
	}

	/**
	 * Returns the update location submit button.
	 * 
	 * @return updateLocationSubmitBtn
	 */
	public JButton getUpdateLocationSubmitBtn() {
		return updateLocationSubmitBtn;
	}

	/**
	 * Returns the update website submit button.
	 * 
	 * @return updateWebsiteSubmitBtn
	 */
	public JButton getUpdateWebsiteSubmitBtn() {
		return updateWebsiteSubmitBtn;
	}

	/**
	 * Returns the update organization submit button.
	 * 
	 * @return updateOrgSubmitBtn
	 */
	public JButton getUpdateOrgSubmitBtn() {
		return updateOrgSubmitBtn;
	}

	/**
	 * Returns the update Start date button.
	 * 
	 * @return updateStartDateBtn
	 */
	public JButton getUpdateStartDateBtn() {
		return updateStartDateBtn_1;
	}

	/**
	 * Returns the udpate entry button.
	 * 
	 * @return updateEntryBtn
	 */
	public JButton getUpdateEntryBtn() {
		return updateEntryBtn;
	}

	/**
	 * Returns the update column combo box.
	 * 
	 * @return updateColumnBox
	 */
	public JComboBox<String> getUpdateColumnBox() {
		return updateColumnBox;
	}

	/**
	 * Returns the common name text area.
	 * 
	 * @return commNameTextArea
	 */
	public JTextArea getCommNameTextArea() {
		return commNameTextArea;
	}

	/**
	 * Returns the scientific name text area.
	 * 
	 * @return sciNameTextArea
	 */
	public JTextArea getSciNameTextArea() {
		return sciNameTextArea;
	}

	/**
	 * Returns the conservation status text area.
	 * 
	 * @return conservStatusTextArea
	 */
	public JTextArea getConservStatusTextArea() {
		return conservStatusTextArea;
	}

	/**
	 * Returns the Start date text area.
	 * 
	 * @return StartDateTextArea
	 */
	public JTextArea getStartDateTextArea() {
		return startDateTextArea;
	}

	/**
	 * Returns the organization text area.
	 * 
	 * @return orgTextArea
	 */
	public JTextArea getOrgTextArea() {
		return orgTextArea;
	}

	/**
	 * Returns the website text area.
	 * 
	 * @return websiteTextArea
	 */
	public JTextArea getWebsiteTextArea() {
		return websiteTextArea;
	}

	/**
	 * Returns the location text area.
	 * 
	 * @return locTextArea
	 */
	public JTextArea getLocTextArea() {
		return locTextArea;
	}

	/**
	 * Returns the delete button.
	 * 
	 * @return deleteBtn
	 */
	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * Returns the index of the selected conservation status drop down.
	 * 
	 * @return index of the update conservation status combo box.
	 */
	public int getUpdateConStatusComboBoxIndex() {
		int index = updateConStatComboBox.getSelectedIndex() + 1;
		return index;
	}
}