package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sql.SqlESAConservationStatus;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButton;

/**
 * Reveals all entries of the Endangered Species table
 * in a uniform list that the user can sort and make
 * a selection from to view more details.
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class SpeciesQueryGUI extends JPanel {
	private JButton speciesInfoButton;
	private JButton regionsButton;
	private JButton homeButton;
	private JButton addSpeciesButton;
	private JButton consEffortsButton;
	private JButton speciesQueryButton;
	private JTextArea siOverviewTextArea;
	private JTextField siIDTextField;
	private JButton submitSiBtn;
	private JButton submitBtn;
	private JLabel displayErrorLbl;
	private JLabel queryLbl;
	private JComboBox statusBox;
	private JComboBox classBox;
	private JLabel sortLbl;
	private ButtonGroup radioBtns;
	private JRadioButton idSortBtn;
	private JRadioButton nameSortBtn;
	private JRadioButton popBtn;
	private JComboBox updateColumnBox;
	private JLabel esaClassChoiceLbl;
	private JLabel lblNewLabel_1;

	public SpeciesQueryGUI() {
		setLayout(null);
		setBounds(0, 0, 1100, 900);

		
		// PANEL FOR DISPLAYING SPECIES INFORMATION
		JPanel scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.DARK_GRAY);
		scrollPanel.setBounds(50, 341, 978, 272);
		add(scrollPanel);
		scrollPanel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(900, 50));
		scrollPanel.add(scrollPane, BorderLayout.CENTER);
		
		siOverviewTextArea = new JTextArea();
		scrollPane.setViewportView(siOverviewTextArea);
		siOverviewTextArea.setBackground(Color.WHITE);
		siOverviewTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
		
		
		
		// PANEL FOR SELECTING A SPECIES TO VIEW INFO FOR
		JPanel siPanel = new JPanel();
		siPanel.setBounds(201, 615, 637, 50);
		add(siPanel);
		siPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Species ID for a more detailed view:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(55, 4, 297, 36);
		siPanel.add(lblNewLabel);
        
		siIDTextField = new JTextField();
		siIDTextField.setBounds(363, 4, 57, 36);
		siPanel.add(siIDTextField);
		
		displayErrorLbl = new JLabel("");
		displayErrorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		displayErrorLbl.setBounds(731, 615, 297, 46);
		add(displayErrorLbl);
		
		submitSiBtn = new JButton("Submit");
		submitSiBtn.setBounds(459, 4, 89, 36);
		siPanel.add(submitSiBtn);
		
		

		// SORT BY SPECIFICATIONS
		JPanel sortByPanel = new JPanel();
		sortByPanel.setBounds(201, 664, 637, 36);
		add(sortByPanel);
		sortByPanel.setLayout(null);

		sortLbl = new JLabel("Sort By:");
		sortLbl.setBounds(10, 8, 75, 20);
		sortByPanel.add(sortLbl);
		sortLbl.setMaximumSize(new Dimension(39, 23));
		sortLbl.setMinimumSize(new Dimension(39, 23));
		sortLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

		radioBtns = new ButtonGroup();
		radioBtns.add(idSortBtn);
		radioBtns.add(nameSortBtn);
		radioBtns.add(popBtn);

		idSortBtn = new JRadioButton("ID");
		idSortBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		idSortBtn.setBounds(91, 8, 157, 20);
		sortByPanel.add(idSortBtn);
		idSortBtn.setSelected(true);
		radioBtns.add(idSortBtn);

		nameSortBtn = new JRadioButton("Common Name");
		nameSortBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameSortBtn.setBounds(214, 8, 157, 20);
		sortByPanel.add(nameSortBtn);
		radioBtns.add(nameSortBtn);

		popBtn = new JRadioButton("Population");
		popBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		popBtn.setBounds(398, 8, 157, 20);
		sortByPanel.add(popBtn);
		radioBtns.add(popBtn);
		
		// PANEL TO SORT BY CLASS OR ESA STATUS
		JPanel selectSortpanel = new JPanel();
		selectSortpanel.setBounds(201, 700, 637, 145);
		add(selectSortpanel);
		selectSortpanel.setLayout(null);

		esaClassChoiceLbl = new JLabel(
				"Please select which endangered status category and/or species class you would like to view: ");
		esaClassChoiceLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		esaClassChoiceLbl.setBounds(10, 11, 621, 35);
		selectSortpanel.add(esaClassChoiceLbl);

		String[] speciesClasses = { "Mammal", "Bird", "Fish", "Reptile", "Plant" };
		
		classBox = new JComboBox(speciesClasses);
		classBox.setBounds(20, 84, 200, 50);
		selectSortpanel.add(classBox);
		classBox.setName("Select Species");
		
		statusBox = new JComboBox<>();
		statusBox.setBounds(243, 84, 200, 50);
		selectSortpanel.add(statusBox);
		statusBox.setName("Select Conservation Status");
		
		JLabel selectClassLbl = new JLabel("Select Class:");
		selectClassLbl.setBounds(20, 57, 200, 14);
		selectSortpanel.add(selectClassLbl);
		
		JLabel selectStatusLbl = new JLabel("Select ESA Status:");
		selectStatusLbl.setBounds(243, 57, 200, 14);
		selectSortpanel.add(selectStatusLbl);
		
		lblNewLabel_1 = new JLabel("Listed below are all species found in Utah that are currently being monitored until endangerment status improves");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(50, 296, 978, 16);
		add(lblNewLabel_1);
		/*
		 * Queries the database for the ESA status and gets added to the JComboBox and
		 * displays as a drop-down.
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:derby:EndangeredSpeciesDB;create=true");
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(SqlESAConservationStatus.allData());
			while (results.next()) {
				String name = results.getString("Status");
				statusBox.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
       
	}
	
    /**
	 * @return the popBtn
	 */
	public JRadioButton getPopBtn() {
		return popBtn;
	}

	/**
	 * @return the idSortBtn
	 */
	public JRadioButton getIdSortBtn() {
		return idSortBtn;
	}

	/**
	 * @return the nameSortBtn
	 */
	public JRadioButton getNameSortBtn() {
		return nameSortBtn;
	}

	/**
	 * @return the radioBtns
	 */
	public ButtonGroup getRadioBtns() {
		return radioBtns;
	}

	/**
	 * @return the statusBox
	 */
	public JComboBox getStatusBox() {
		return statusBox;
	}
	
	public JComboBox getClassBox() {
		return classBox;
	}

	public JButton getSiIDButton() {
        return submitSiBtn;
    }
    
    public JTextField getSiIDTextField() {
        return siIDTextField;
    }
    
    public JLabel getDisplayErrorLbl() {
        return displayErrorLbl;
    }
    
    public JTextArea getSiOverviewTextArea() {
        return siOverviewTextArea;
    } 

	public JButton getSpeciesInfoButton() {
		return speciesInfoButton;
	}

	public JButton getRegionsButton() {
		return regionsButton;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public JButton getAddSpeciesButton() {
		return addSpeciesButton;
	}

	public JButton getConsEffortsButton() {
		return consEffortsButton;
	}

	public JButton getSpeciesQueryButton() {
		return speciesQueryButton;
	}
}