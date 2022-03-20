package panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sql.SqlESAConservationStatus;
import sql.SqlRegion;
import sql.SqlThreat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

/**
 * Takes in user input to create a new species entry to the Endangered Species table
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class SpeciesForm extends JPanel {
	private JTextField NameField;
	private JTextField PopulationField;
	private JTextField ScientificField;
	private JTextField ClassField;
	private JComboBox<String> ThreatsSelection;
	private JButton SubmitBtn;
	private JComboBox<String> ESASelection;
	private JComboBox<String> RegionSelection;

	/**
	 * Create the panel.
	 */
	public SpeciesForm() {
		setLayout(null);
		setBounds(100, 100, 1100, 900);
		
		
		JLabel InstructionLabel = new JLabel("Add a new species to track conservation efforts: ");
		InstructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		InstructionLabel.setBounds(6, 314, 1088, 16);
		add(InstructionLabel);
		
		// = = =  NAME = = =
		NameField = new JTextField();
		NameField.setBounds(182, 375, 206, 47);
		add(NameField);
		NameField.setColumns(10);
		
		JLabel CommonNameLabel = new JLabel("Common Name: ");
		CommonNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		CommonNameLabel.setBounds(61, 375, 109, 47);
		add(CommonNameLabel);
		
		JLabel ScientificNameLabel = new JLabel("Scientific Name: ");
		ScientificNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ScientificNameLabel.setBounds(61, 454, 109, 47);
		add(ScientificNameLabel);
		
		ScientificField = new JTextField();
		ScientificField.setColumns(10);
		ScientificField.setBounds(182, 454, 206, 47);
		add(ScientificField);
		
		// = = = CONSERVATION STATUS = = =	
		JLabel ESALabel = new JLabel("ESA Status:");
		ESALabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ESALabel.setBounds(661, 526, 134, 47);
		add(ESALabel);
		
		ESASelection = new JComboBox<>();
		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlESAConservationStatus.getStatus());
			while(results.next()) {
				String name = results.getString("Status");
				ESASelection.addItem(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ESASelection.setBounds(800, 537, 238, 27);
		add(ESASelection);
		
		// = = = REGION = = =
		JLabel RegionLabel = new JLabel("Region:");
		RegionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		RegionLabel.setBounds(711, 454, 84, 47);
		add(RegionLabel);
		
		String[] regions = {"West Desert", "Green River", "Color Country", 
				"Paria River", "Canyon Country"};
		
		RegionSelection = new JComboBox<>();
		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlRegion.getDistrictFromForm());
			while(results.next()) {
				String name = results.getString("District");
				RegionSelection.addItem(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RegionSelection.setBounds(800, 465, 238, 27);
		add(RegionSelection);
		
		// = = = THREATS = = =
		JLabel ThreatsLabel = new JLabel("Threats: ");
		ThreatsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ThreatsLabel.setBounds(701, 375, 98, 47);
		add(ThreatsLabel);
		ThreatsSelection = new JComboBox<>();
		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlThreat.getDescriptionFromForm());
			while(results.next()) {
				String name = results.getString("Description");
				ThreatsSelection.addItem(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ThreatsSelection.setBounds(800, 386, 238, 27);
		add(ThreatsSelection);
		
		// = = = POPULATION = = =
		JLabel PopulationLabel = new JLabel("Population: ");
		PopulationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PopulationLabel.setBounds(384, 375, 98, 47);
		add(PopulationLabel);
		
		PopulationField = new JTextField();
		PopulationField.setColumns(10);
		PopulationField.setBounds(490, 375, 206, 47);
		add(PopulationField);
		
		// = = = CLASS = = =
		JLabel ClassLabel = new JLabel("Class:");
		ClassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ClassLabel.setBounds(413, 454, 65, 47);
		add(ClassLabel);
		
		ClassField = new JTextField();
		ClassField.setColumns(10);
		ClassField.setBounds(490, 454, 206, 47);
		add(ClassField);
		
		// = = = SUBMIT = = =
		SubmitBtn = new JButton("SUBMIT");
		SubmitBtn.setBounds(60, 695, 977, 90);
		add(SubmitBtn);
	}



	/**
	 * @return the nameField
	 */
	public String getNameField() {
		return NameField.getText();
	}

	/**
	 * @return the scientificField
	 */
	public String getScientificField() {
		return ScientificField.getText();
	}
	
	/**
	 * @return the classField
	 */
	public String getClassField() {
		return ClassField.getText();
	}
	
	/**
	 * @return the populationField
	 */
	public int getPopulationField() {
		return Integer.parseInt(PopulationField.getText());
	}
	
	public int getThreatSelection() {
		int index = ThreatsSelection.getSelectedIndex() + 1;
		return index;
	}
	
	/**
	 * @return the regionSelection
	 */
	public int getRegionSelection() {
		int index = RegionSelection.getSelectedIndex() + 1;
		return index;
	}
	
	/**
	 * @return the eSASelection
	 */
	public int getESASelection() {
		int index = ESASelection.getSelectedIndex() + 123;
		return index;	
	}

	public JButton getSubmitBtn() {
		return SubmitBtn;
	}
}
