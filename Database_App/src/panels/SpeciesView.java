package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.DBConnection;
import sql.SqlConservationEffort;

/**
 * Displays all information on a selected species
 * in a more detailed JPanel isolated from the rest
 * of the table entries.
 * 
 * In this display window, the user also has the option
 * to update any fields or delete a row altogether.
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class SpeciesView extends JPanel {

	private JTextArea commNameTextArea;
	private JTextArea sciNameTextArea;
	private JTextArea popTextArea;
	private JTextArea esaTextArea;
	private JTextArea classTextArea;
	private JButton deleteBtn;
	private JButton updateEntryBtn;
	private JTextArea threatTextArea;
	private JTextArea consEffortTextArea;
	private JComboBox updateColumnBox;
	private JButton submitUpdateCommonNameBtn;
	private JButton submitUpdatePopBtn;
	private JButton submitUpdateClassBtn;
	private JButton submitUpdateESABtn;
	private JButton submitUpdateThreatsBtn;
	private JButton submitUpdateConsEffBtn;
	private JButton submitUpdateSciNameBtn;

	/**
	 * Create the panel.
	 */
	public SpeciesView() {
		setLayout(null);
		setBounds(0, 0, 1100, 900);

		JPanel speciesInfoDisplayPanel = new JPanel();
		speciesInfoDisplayPanel.setBounds(new Rectangle(0, 0, 50, 25));
		speciesInfoDisplayPanel.setBackground(new Color(95, 158, 160));
		speciesInfoDisplayPanel.setBounds(64, 347, 973, 408);
		add(speciesInfoDisplayPanel);
		speciesInfoDisplayPanel.setLayout(null);

		// = = = COMMON NAME = = =
		JLabel commonNameLbl = new JLabel("Common name:");
		commonNameLbl.setOpaque(true);
		commonNameLbl.setBackground(Color.LIGHT_GRAY);
		commonNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		commonNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		commonNameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		commonNameLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		commonNameLbl.setBounds(70, 50, 150, 25);
		speciesInfoDisplayPanel.add(commonNameLbl);

		commNameTextArea = new JTextArea();
		commNameTextArea.setEditable(false);
		commNameTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		commNameTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		commNameTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		commNameTextArea.setBackground(Color.LIGHT_GRAY);
		commNameTextArea.setBounds(300, 50, 300, 25);
		speciesInfoDisplayPanel.add(commNameTextArea);

		// = = = SCIENTIFIC NAME = = =
		JLabel sciNameLbl = new JLabel("Scientific name:");
		sciNameLbl.setOpaque(true);
		sciNameLbl.setBackground(Color.LIGHT_GRAY);
		sciNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sciNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sciNameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		sciNameLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		sciNameLbl.setBounds(70, 100, 150, 25);
		speciesInfoDisplayPanel.add(sciNameLbl);

		sciNameTextArea = new JTextArea();
		sciNameTextArea.setEditable(false);
		sciNameTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		sciNameTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		sciNameTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		sciNameTextArea.setBackground(Color.LIGHT_GRAY);
		sciNameTextArea.setBounds(300, 100, 300, 25);
		speciesInfoDisplayPanel.add(sciNameTextArea);

		// = = = CONSERVATION STATUSES = = =
		JLabel ESALbl = new JLabel("ESA Status:");
		ESALbl.setOpaque(true);
		ESALbl.setBackground(Color.LIGHT_GRAY);
		ESALbl.setHorizontalAlignment(SwingConstants.CENTER);
		ESALbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ESALbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		ESALbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		ESALbl.setBounds(70, 250, 150, 25);
		speciesInfoDisplayPanel.add(ESALbl);

		esaTextArea = new JTextArea();
		esaTextArea.setEditable(false);
		esaTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		esaTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		esaTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		esaTextArea.setBackground(Color.LIGHT_GRAY);
		esaTextArea.setBounds(300, 250, 300, 25);
		speciesInfoDisplayPanel.add(esaTextArea);

		// = = = POPULATION FIELD = = =
		JLabel populationLbl = new JLabel("Population:");
		populationLbl.setOpaque(true);
		populationLbl.setBackground(Color.LIGHT_GRAY);
		populationLbl.setHorizontalAlignment(SwingConstants.CENTER);
		populationLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		populationLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		populationLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		populationLbl.setBounds(70, 200, 150, 25);
		speciesInfoDisplayPanel.add(populationLbl);

		popTextArea = new JTextArea();
		popTextArea.setEditable(false);
		popTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		popTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		popTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		popTextArea.setBackground(Color.LIGHT_GRAY);
		popTextArea.setBounds(300, 200, 300, 25);
		speciesInfoDisplayPanel.add(popTextArea);

		// = = = CLASS FIELD = = =
		JLabel classLbl = new JLabel("Class:");
		classLbl.setOpaque(true);
		classLbl.setBackground(Color.LIGHT_GRAY);
		classLbl.setHorizontalAlignment(SwingConstants.CENTER);
		classLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		classLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		classLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		classLbl.setBounds(70, 150, 150, 25);
		speciesInfoDisplayPanel.add(classLbl);

		classTextArea = new JTextArea();
		classTextArea.setEditable(false);
		classTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		classTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		classTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		classTextArea.setBackground(Color.LIGHT_GRAY);
		classTextArea.setBounds(300, 150, 300, 25);
		speciesInfoDisplayPanel.add(classTextArea);

		// *** THREAT FIELD
		JLabel threatLabel = new JLabel("Threats:");
		threatLabel.setOpaque(true);
		threatLabel.setBackground(Color.LIGHT_GRAY);
		threatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		threatLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		threatLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		threatLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		threatLabel.setBounds(70, 300, 150, 25);
		speciesInfoDisplayPanel.add(threatLabel);

		threatTextArea = new JTextArea();
		threatTextArea.setEditable(false);
		threatTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		threatTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		threatTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		threatTextArea.setBackground(Color.LIGHT_GRAY);
		threatTextArea.setBounds(300, 300, 300, 25);
		speciesInfoDisplayPanel.add(threatTextArea);

		// *** CONSERVATION FIELD

		JLabel conservationLabel = new JLabel("Conservation Efforts:");
		conservationLabel.setOpaque(true);
		conservationLabel.setBackground(Color.LIGHT_GRAY);
		conservationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conservationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		conservationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		conservationLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		conservationLabel.setBounds(70, 350, 150, 25);
		speciesInfoDisplayPanel.add(conservationLabel);

		consEffortTextArea = new JTextArea();
		consEffortTextArea.setEditable(false);
		consEffortTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		consEffortTextArea.setBounds(new Rectangle(325, 0, 200, 25));
		consEffortTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		consEffortTextArea.setBackground(Color.LIGHT_GRAY);
		consEffortTextArea.setBounds(300, 350, 300, 25);
		speciesInfoDisplayPanel.add(consEffortTextArea);

		submitUpdateCommonNameBtn = new JButton("Submit Update");
		submitUpdateCommonNameBtn.setVisible(false);
		submitUpdateCommonNameBtn.setBounds(new Rectangle(700, 0, 125, 25));
		submitUpdateCommonNameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdateCommonNameBtn.setBounds(700, 50, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdateCommonNameBtn);

		submitUpdatePopBtn = new JButton("Submit Update");
		submitUpdatePopBtn.setVisible(false);
		submitUpdatePopBtn.setBounds(new Rectangle(700, 150, 125, 25));
		submitUpdatePopBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdatePopBtn.setBounds(700, 200, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdatePopBtn);

		submitUpdateClassBtn = new JButton("Submit Update");
		submitUpdateClassBtn.setVisible(false);
		submitUpdateClassBtn.setBounds(new Rectangle(700, 0, 125, 25));
		submitUpdateClassBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdateClassBtn.setBounds(700, 150, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdateClassBtn);

		submitUpdateESABtn = new JButton("Submit Update");
		submitUpdateESABtn.setVisible(false);
		submitUpdateESABtn.setBounds(new Rectangle(700, 0, 125, 25));
		submitUpdateESABtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdateESABtn.setBounds(700, 250, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdateESABtn);

		submitUpdateThreatsBtn = new JButton("Submit Update");
		submitUpdateThreatsBtn.setVisible(false);
		submitUpdateThreatsBtn.setBounds(new Rectangle(700, 0, 125, 25));
		submitUpdateThreatsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdateThreatsBtn.setBounds(700, 300, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdateThreatsBtn);

		submitUpdateConsEffBtn = new JButton("Submit Update");
		submitUpdateConsEffBtn.setVisible(false);
		submitUpdateConsEffBtn.setBounds(new Rectangle(700, 0, 125, 25));
		submitUpdateConsEffBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdateConsEffBtn.setBounds(700, 350, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdateConsEffBtn);

		submitUpdateSciNameBtn = new JButton("Submit Update");
		submitUpdateSciNameBtn.setVisible(false);
		submitUpdateSciNameBtn.setBounds(new Rectangle(700, 0, 125, 25));
		submitUpdateSciNameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitUpdateSciNameBtn.setBounds(700, 100, 125, 25);
		speciesInfoDisplayPanel.add(submitUpdateSciNameBtn);

		// Delete Entry from table
		deleteBtn = new JButton("Remove Entry");
		deleteBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteBtn.setBounds(185, 766, 200, 50);
		add(deleteBtn);

		// Edit Entry in Table
		updateEntryBtn = new JButton("Update Entry");
		updateEntryBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateEntryBtn.setBounds(430, 766, 200, 50);
		add(updateEntryBtn);

		String[] updateColumn = { "Select Column to Update", "CommonName", "ScientificName", "Class", "Population",
				"ESA_Conservation_Status", "ThreatId", "EffortId" };

		updateColumnBox = new JComboBox(updateColumn);
		updateColumnBox.setName("Select Column to Update");
		updateColumnBox.setBounds(736, 766, 244, 50);
		updateColumnBox.setVisible(false);
		add(updateColumnBox);
	}
	
	public JButton getSubmitUpdateCommonNameBtn() {
		return submitUpdateCommonNameBtn;
	}

	public JButton getsubmitUpdateSciNameBtn() {
		return submitUpdateSciNameBtn;
	}

	public JButton getsubmitUpdatePopBtn() {
		return submitUpdatePopBtn;
	}

	public JButton getsubmitUpdateClassBtn() {
		return submitUpdateClassBtn;
	}

	public JButton getsubmitUpdateESABtn() {
		return submitUpdateESABtn;
	}

	public JButton getsubmitUpdateThreatsBtn() {
		return submitUpdateThreatsBtn;
	}

	public JButton getsubmitUpdateConsEffBtn() {
		return submitUpdateConsEffBtn;
	}

	/**
	 * @return the commNameTextArea
	 */
	public JTextArea getCommNameTextArea() {
		return commNameTextArea;
	}

	/**
	 * @return the sciNameTextArea
	 */
	public JTextArea getSciNameTextArea() {
		return sciNameTextArea;
	}

	/**
	 * @return the popField
	 */
	public JTextArea getPopField() {
		return popTextArea;
	}

	/**
	 * @return the esaField
	 */
	public JTextArea getEsaField() {
		return esaTextArea;
	}

	/**
	 * @return the classField
	 */
	public JTextArea getClassField() {
		return classTextArea;
	}

	/**
	 * @return the classField
	 */
	public JTextArea getThreatField() {
		return threatTextArea;
	}

	/**
	 * @return the classField
	 */
	public JTextArea getConsEffortField() {
		return consEffortTextArea;
	}

	/**
	 * @return the deleteBtn
	 */
	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * @return the deleteBtn
	 */
	public JButton getUpdateEntryBtn() {
		return updateEntryBtn;
	}

	public JComboBox getUpdateColumnBox() {
		return updateColumnBox;
	}

}

