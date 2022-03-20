package panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sql.SqlESAConservationStatus;
import sql.SqlEndangeredSpecies;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Holds the components that make up the Conservation Form.
 * 
 * @author Pen
 *
 */
@SuppressWarnings("serial")
public class ConservationForm extends JPanel {
	private JTextField statusField;
	private JTextField startDateField;
	private JComboBox<String> statusComboBox;
	private JTextField orgField;
	private JTextField websiteField;
	private JTextField locField;
	private JButton submitBtn;
	private JLabel errorLbl;
	private JComboBox<String> speciesComboBox;

	/**
	 * Create the panel.
	 */
	public ConservationForm() {
		setLayout(null);
		setBounds(100, 100, 1100, 900);

		JLabel InstructionLabel = new JLabel("Add new conservation effort: ");
		InstructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		InstructionLabel.setBounds(6, 314, 1088, 16);
		add(InstructionLabel);

		JPanel panel = new JPanel();
		panel.setBounds(50, 371, 989, 312);
		add(panel);
		panel.setLayout(null);

		JLabel statusLbl = new JLabel("Status:");
		statusLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		statusLbl.setBounds(23, 42, 157, 14);
		panel.add(statusLbl);

		statusField = new JTextField();
		statusField.setBounds(192, 29, 193, 41);
		panel.add(statusField);
		statusField.setColumns(10);

		JLabel speciesLbl = new JLabel("Associated Species:");
		speciesLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		speciesLbl.setBounds(23, 183, 157, 14);
		panel.add(speciesLbl);

		speciesComboBox = new JComboBox<>();
		speciesComboBox.setBounds(192, 179, 193, 32);
		panel.add(speciesComboBox);

		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlEndangeredSpecies.getAllCommonNameCol());
			while (results.next()) {
				String name = results.getString("CommonName");
				speciesComboBox.addItem(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel startLbl = new JLabel("Start Date:");
		startLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		startLbl.setBounds(23, 114, 157, 14);
		panel.add(startLbl);

		startDateField = new JTextField();
		startDateField.setColumns(10);
		startDateField.setBounds(192, 101, 193, 41);
		panel.add(startDateField);

		JLabel conservationStatLbl = new JLabel("Conservation Status:");
		conservationStatLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		conservationStatLbl.setBounds(23, 246, 157, 14);
		panel.add(conservationStatLbl);

		/*
		 * Queries the database for the ESA status and adds each value to the JComboBox.
		 */
		statusComboBox = new JComboBox<>();
		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlESAConservationStatus.getStatus());
			while(results.next()) {
				String name = results.getString("Status");
				statusComboBox.addItem(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		statusComboBox.setBounds(192, 237, 193, 32);
		panel.add(statusComboBox);

		JLabel orgLbl = new JLabel("Organization:");
		orgLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		orgLbl.setBounds(534, 42, 131, 14);
		panel.add(orgLbl);

		orgField = new JTextField();
		orgField.setColumns(10);
		orgField.setBounds(688, 29, 193, 41);
		panel.add(orgField);

		JLabel websiteLbl = new JLabel("Website:");
		websiteLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		websiteLbl.setBounds(534, 114, 131, 14);
		panel.add(websiteLbl);

		websiteField = new JTextField();
		websiteField.setColumns(10);
		websiteField.setBounds(688, 101, 193, 41);
		panel.add(websiteField);

		JLabel locLbl = new JLabel("Location:");
		locLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		locLbl.setBounds(534, 183, 131, 14);
		panel.add(locLbl);

		locField = new JTextField();
		locField.setColumns(10);
		locField.setBounds(688, 170, 193, 41);
		panel.add(locField);

		// = = = SUBMIT = = =
		submitBtn = new JButton("SUBMIT");
		submitBtn.setBounds(60, 695, 977, 90);
		add(submitBtn);

		errorLbl = new JLabel("");
		errorLbl.setBounds(192, 377, 193, 14);
		panel.add(errorLbl);

	}

	/**
	 * Returns the text of the status field.
	 * 
	 * @return
	 */
	public String getStatusField() {
		return statusField.getText();
	}

	/**
	 * Returns the text of the Start date field.
	 * 
	 * @return
	 */
	public String getStartDateField() {
		return startDateField.getText();
	}

	/**
	 * Returns the index of the Species ComboBox.
	 * 
	 * @return index of selected combo box selection.
	 */
	public int getSpeciesComboBoxIndex() {
		int index = speciesComboBox.getSelectedIndex() + 1;
		return index;
	}

	/**
	 * Returns the index of the Status ComboBox.
	 * 
	 * @return index of the selected combo box selection.
	 */
	public int getStatusComboBoxIndex() {
		int index = statusComboBox.getSelectedIndex() + 123;
		return index;
	}

	/**
	 * Returns the text of the organization field.
	 * 
	 * @return
	 */
	public String getOrgField() {
		return orgField.getText();
	}

	/**
	 * Returns the text of the website field.
	 * 
	 * @return
	 */
	public String getWebsiteField() {
		return websiteField.getText();
	}

	/**
	 * Returns the text of the location field.
	 * 
	 * @return
	 */
	public String getLocField() {
		return locField.getText();
	}

	/**
	 * Returns the error label.
	 * 
	 * @return
	 */
	public JLabel getErrorLbl() {
		return errorLbl;
	}

	/**
	 * Returns the submit button.
	 * 
	 * @return
	 */
	public JButton getSubmitBtn() {
		return submitBtn;
	}

}