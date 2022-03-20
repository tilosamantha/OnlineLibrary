package main;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * Separate JPanel that allows consistent and smooth navigation across all JPanels 
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class NavBar extends JPanel {

	private JButton SpeciesBtn;
	private JButton consEffortsButton;
	private JButton regionBtn;
	private JButton homeBtn;
	private JButton addSpeciesBtn;
	private JLabel TitleLabel;
	private JButton addConservationBtn;

	/**
	 * Create the panel.
	 */
	public NavBar() {
		setLayout(null);
		setBounds(0, 0, 1100, 263);
		
		TitleLabel = new JLabel("Home");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Georgia", Font.BOLD, 55));
		TitleLabel.setBounds(6, 26, 1088, 100);
		add(TitleLabel);
		
		SpeciesBtn = new JButton("All Species");
		SpeciesBtn.setBounds(294, 138, 228, 40);
		add(SpeciesBtn);

		consEffortsButton = new JButton("Conservation Efforts");
		consEffortsButton.setBounds(546, 138, 229, 40);
		add(consEffortsButton);

		regionBtn = new JButton("Regions");
		regionBtn.setBounds(797, 138, 229, 40);
		add(regionBtn);

		homeBtn = new JButton("Home");
		homeBtn.setBounds(53, 138, 229, 40);
		add(homeBtn);

		addSpeciesBtn = new JButton("Add Species");
		addSpeciesBtn.setBounds(294, 190, 229, 40);
		add(addSpeciesBtn);
		
		addConservationBtn = new JButton("Add Conservation Effort");
		addConservationBtn.setBounds(546, 190, 228, 40);
		add(addConservationBtn);
	}
	

	public JLabel getTitleLabel() {
		return TitleLabel;
	}

	public void setTitleLabel(String titleLabel) {
		TitleLabel.setText(titleLabel);
	}

	public JButton getHomeButton() {
		return homeBtn;
	}

	public JButton getRegionButton() {
		return regionBtn;
	}
	
	public JButton getConsEffortsButton() {
		return consEffortsButton;
	}
	
	public JButton getSpeciesQueryButton() {
		return SpeciesBtn;
	}

	public JButton getAddSpeciesButton() {
		return addSpeciesBtn;
	}
	
	public JButton getAddConservationButton() {
		return addConservationBtn;
	}
	
}


