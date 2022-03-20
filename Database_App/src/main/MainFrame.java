package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panels.ConservationForm;
import panels.ConservationOverview;
import panels.ConservationView;
import panels.HomePage;
import panels.RegionsOverview;
import panels.RegionsView;
import panels.SpeciesForm;
import panels.SpeciesView;
import panels.SpeciesQueryGUI;
import sql.SqlConservationEffort;
import sql.SqlESAConservationStatus;
import sql.SqlEndangeredSpecies;
import sql.SqlRegion;

/**
 * Main JFrame to exchange panels and display species, region and conservation effort information
 * 
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JPanel current;
	private String columnToUpdate;
	
	private NavBar navBar;
	private HomePage home;
	private RegionsView region;
	private RegionsOverview regionOV;
	private ConservationView conservationView;
	private ConservationOverview conservationOV;
	private SpeciesView speciesView;
	private SpeciesQueryGUI speciesQuery;
	private ConservationForm conservationForm;
	private SpeciesForm speciesForm;
	private Container container;

	
	private int speciesIDToUpdate;
	private int conserEffIDToUpdate;
	private int esaIDToQuery;
	private static int rID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBConnection.setUpSQL();

					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initializePanels();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		actionListeners(); 
		setContentPane(contentPane);
		contentPane.add(navBar);
		contentPane.add(home);
		
		current = home;
	}

	/**
	 * Initialize all panels
	 */
	private void initializePanels() {
		navBar = new NavBar();
		home = new HomePage();
		region = new RegionsView();
		regionOV = new RegionsOverview();
		conservationView = new ConservationView();
		conservationOV = new ConservationOverview();
		speciesView = new SpeciesView();
		speciesQuery = new SpeciesQueryGUI();
		conservationForm = new ConservationForm();
		speciesForm = new SpeciesForm();
	}

	private void actionListeners() {
		//NAVIGATION BAR BUTTONS
		navBarButtons();

		
		
		//OVERVIEW TO SINGLE VIEW
		conservationOV.getCeIDButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conservationOV.getCeIDTextField().getText().isEmpty()) {
					conservationOV.getDisplayErrorLbl().setText(
							"<html><font color='red'>Please enter ID to see conservation effort.</font></html>");
				} else {
					int ceID = Integer.parseInt(conservationOV.getCeIDTextField().getText());
					conserEffIDToUpdate = ceID;
					
					navBar.setTitleLabel("Ongoing Effort");
					
					
					conservationView.getCommNameTextArea().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlConservationEffort.getCommonNameOnJoin(ceID), "CommonName"));

					conservationView.getSciNameTextArea().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlConservationEffort.getSciNameOnJoin(ceID), "ScientificName"));
					
					conservationView.getConservStatusTextArea().setText(DBConnection
							.executeQueryGetStatusInnerJoin(SqlConservationEffort.getConservationStatusOnJoin(ceID)));

					conservationView.getStartDateTextArea().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlConservationEffort.getConservationEffortData(ceID), "StartDate"));

					conservationView.getOrgTextArea().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlConservationEffort.getConservationEffortData(ceID), "Organization"));

					conservationView.getWebsiteTextArea().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlConservationEffort.getConservationEffortData(ceID), "Website"));

					conservationView.getLocTextArea().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlConservationEffort.getConservationEffortData(ceID), "Location"));

					contentPane.remove(current);
					contentPane.add(conservationView, BorderLayout.CENTER);
					current = conservationView;
					contentPane.revalidate();
					contentPane.repaint();
				}
			}
		});
		
		speciesQuery.getSiIDButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (speciesQuery.getSiIDTextField().getText().isEmpty()) {
					conservationOV.getDisplayErrorLbl().setText(
							"<html><font color='red'>Please enter ID to see conservation effort.</font></html>");
				} else {
					int siID = Integer.parseInt(speciesQuery.getSiIDTextField().getText());
					speciesIDToUpdate = siID;
					
					navBar.setTitleLabel(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getCommonName(siID), "CommonName"));
					
					speciesView.getCommNameTextArea().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getCommonName(siID), "CommonName"));

					speciesView.getSciNameTextArea().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getSciName(siID), "ScientificName"));

					speciesView.getPopField().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getPopulation(siID), "Population"));

					speciesView.getEsaField().setText(DBConnection.executeQueryReturnDataOnColumn(
							SqlEndangeredSpecies.getESA(siID), "ESA_Conservation_Status"));

					speciesView.getClassField().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getSpeciesClass(siID), "Class"));
					
					speciesView.getThreatField().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getThreat(siID), "ThreatId"));

					speciesView.getConsEffortField().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlEndangeredSpecies.getEffort(siID), "EffortId"));

					contentPane.remove(current);
					contentPane.add(speciesView, BorderLayout.CENTER);
					current = speciesView;
					contentPane.revalidate();
					contentPane.repaint();
				}
			}
		});
		
		regionOV.getSubmitBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (regionOV.getRegionIDField().getText().isEmpty()) {
					conservationOV.getDisplayErrorLbl().setText(
							"<html><font color='red'>Please enter ID to see conservation effort.</font></html>");
				} else {
					rID = Integer.parseInt(regionOV.getRegionIDField().getText());
					
					navBar.setTitleLabel(DBConnection
							.executeQueryReturnDataOnColumn(SqlRegion.getDistrict(rID), "District"));

					if (rID == 1) {
						region.getDescArea().setText("   The Canyon Country District, comprised of the Moab and Monticello Field Offices manages about 3.6 million surface acres, providing opportunities for commercial recreation, livestock grazing, mining and oil and gas exploration, supporting local and regional economies in many ways. This part of the Colorado Plateau is best known for its world class scenery, stark red rock canyons juxtaposed against the backdrop of the La Sal and Abajo Mountain ranges, and its multitude of recreation opportunities.");
					} else if (rID == 2) {
						region.getDescArea().setText("   The Color Country District Office and Cedar City Field Office are co-located in southwest Utah’s Iron County, while managing public land in Beaver County.  Characterized by vast acres of sagebrush and pinyon-juniper foothills, the region offers a variety of landscapes ranging from salt desert shrub flats to high mountains with riparian, aspen, and bristlecone pine communities.  Mountain ranges include the Mineral Mountains, Wah Wah Mountains, and the Indian Peak Mountain Range.  The Field office is home to a variety of species including the Rocky Mountain Elk, Mule Deer, Antelope, Greater Sage Grouse, and Wild Horses. The Field Office is generally quite remote and offers a wide variety of dispersed recreation. The Parowan Gap, a deep, narrow gorge west of Summit, Utah, is renowned as a site of great importance to the Paiute Indians and others for many reasons, including the Fremont era petroglyphs etched on the canyon walls.");
					} else if (rID == 3) {
						region.getDescArea().setText("   Paria River District manages 2.3 million acres of Federal land in Southern Utah encompassing both Kane and Garfield Counties, providing multiple-use opportunities for both commercial and personal recreation, livestock grazing and mining in order to support both local and regional economies.");
					} else if (rID == 4) {
						region.getDescArea().setText("   While the Green River District is well known for mineral resources, it is quickly becoming a recreation hotspot favored by outdoor enthusiasts looking for rugged adventure. The district includes the remote and striking San Rafael Swell, which provides opportunities for hiking, mountain biking, and ATV use, and other opportunities. Near Vernal, visitors and community members can enjoy mountain biking, boating, and hunting alongside other recreational pursuits.");
					} else {
						region.getDescArea().setText("   Located in the northwestern Utah, the 7.7 million-acre West Desert District is uniquely different from any other part of the state. Much of this area is a part of the Great Basin region, a place of isolated mountain ranges separated by desert playas and wide-sweeping sagebrush flats. With few amenities, the desert provides a place of solitude and an escape from the urban lifestyle. The West Desert District consists of the Salt Lake Field Office and Fillmore Field Office.");
					}
					
					region.getStreetAddressLbl().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlRegion.getStreetAddress(rID), "Street_address"));

					region.getEndingAddressLbl().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlRegion.getEndingAddress(rID), "Ending_address"));
					
					region.getEmail().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlRegion.getEmail(rID), "Email"));
					
					region.getPhone().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlRegion.getPhone(rID), "Phone"));
					
					region.getHours().setText(DBConnection
							.executeQueryReturnDataOnColumn(SqlRegion.getHours(rID), "Hours"));

					contentPane.remove(current);
					contentPane.add(region, BorderLayout.CENTER);
					current = region;
					contentPane.revalidate();
					contentPane.repaint();
				}
			}
		});
		
		
		
		
		// --- ADD NEW ENTRIES FROM FORMS ---
		speciesForm.getSubmitBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = SqlEndangeredSpecies.insertDataWithParams(speciesForm.getNameField(),
						speciesForm.getScientificField(), speciesForm.getClassField(), speciesForm.getPopulationField(),
						speciesForm.getESASelection(), speciesForm.getThreatSelection(), 0);
				DBConnection.executeQueryInsertDataToDB(query);
				
				navBar.getTitleLabel().setText("All Species");
				speciesQuery.getSiOverviewTextArea().setText(
						DBConnection.executeQueryReturnAllEndangeredSpeciesData(SqlEndangeredSpecies.allData()));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);
				speciesQuery.getSiIDTextField().setText("");
				
				contentPane.remove(current);
				contentPane.add(speciesQuery, BorderLayout.CENTER);
				current = speciesQuery;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		conservationForm.getSubmitBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conservationForm.getStatusField().isEmpty() || conservationForm.getStartDateField().isEmpty() || 
						conservationForm.getOrgField().isEmpty() || conservationForm.getWebsiteField().isEmpty() || 
						conservationForm.getStatusField().isEmpty() || conservationForm.getLocField().isEmpty()) {
					conservationForm.getErrorLbl().setText(
							"<html><font color='red'>Enter all fields to submit form.</font></html>");
				} else {
					String query = SqlConservationEffort.insertDataWithParams(conservationForm.getStatusField(),
							conservationForm.getStartDateField(), conservationForm.getSpeciesComboBoxIndex(),
							conservationForm.getOrgField(), conservationForm.getWebsiteField(),
							conservationForm.getStatusComboBoxIndex(), conservationForm.getLocField());
					DBConnection.executeQueryInsertDataToDB(query);
					
					conservationOV.getCeOverviewTextArea()
					.setText(DBConnection.executeQueryReturnAllCEData(SqlConservationEffort.allData()));
			conservationOV.getCeOverviewTextArea().setLineWrap(true);
			conservationOV.getCeOverviewTextArea().setWrapStyleWord(true);
			conservationOV.getCeOverviewTextArea().setEditable(false);
			conservationOV.getCeIDTextField().setText("");
					
					contentPane.remove(current);
					contentPane.add(conservationOV, BorderLayout.CENTER);
					current = conservationOV;
					contentPane.revalidate();
					contentPane.repaint();
					// Testing
					System.out.println(conservationForm.getSpeciesComboBoxIndex());
					System.out.println(conservationForm.getStatusComboBoxIndex());
				}
			}
		});


		
		
		// --- SPECIES TABLE SORTING OPTIONS ---
		speciesQuery.getClassBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedClass = (String) speciesQuery.getClassBox().getSelectedItem();

				speciesQuery.getSiOverviewTextArea().setText(DBConnection
						.executeQueryReturnSelectedData(SqlEndangeredSpecies.returnSpeciesByClass(selectedClass)));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);

			}
		});

		// QUERY SPECIES BASED ON CONSERVATION STATUS USING COMBO BOX
		speciesQuery.getStatusBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// get selected status to query
				String selectedStatus = (String) speciesQuery.getStatusBox().getSelectedItem();
				System.out.println("Status selected: " + selectedStatus);
				String statusID = null;
				try {
					statusID = DBConnection.printESAID(SqlESAConservationStatus.getESAID(selectedStatus));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Status ID value: " + statusID);
				int statusIDToQuery = Integer.valueOf(statusID);
				System.out.println("Status int value: " + statusIDToQuery);

				speciesQuery.getSiOverviewTextArea().setText(DBConnection
						.executeQueryReturnSelectedData(SqlEndangeredSpecies.returnSpecifiedStatus(statusIDToQuery)));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);
			}
		});
	
		speciesQuery.getNameSortBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speciesQuery.getSiOverviewTextArea().setText(
						DBConnection.executeQueryReturnAllEndangeredSpeciesData(SqlEndangeredSpecies.orderByName()));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);

			}
		});

		speciesQuery.getIdSortBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speciesQuery.getSiOverviewTextArea().setText(
						DBConnection.executeQueryReturnAllEndangeredSpeciesData(SqlEndangeredSpecies.orderById()));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);

			}
		});

		speciesQuery.getPopBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speciesQuery.getSiOverviewTextArea().setText(DBConnection
						.executeQueryReturnAllEndangeredSpeciesData(SqlEndangeredSpecies.orderByPopulation()));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);

			}
		});
		
		
		
		
		// --- SPECIES UPDATE ---
		speciesView.getUpdateEntryBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speciesView.getUpdateColumnBox().setVisible(true);
				System.out.println("box visible");
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		speciesView.getUpdateColumnBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedColumn = (String) speciesView.getUpdateColumnBox().getSelectedItem();
				columnToUpdate = selectedColumn;

				if (selectedColumn == "CommonName") {
					speciesView.getCommNameTextArea().setBackground(Color.YELLOW);
					speciesView.getCommNameTextArea().setEditable(true);
					speciesView.getSubmitUpdateCommonNameBtn().setVisible(true);
				}

				if (selectedColumn == "ScientificName") {
					speciesView.getSciNameTextArea().setBackground(Color.YELLOW);
					speciesView.getSciNameTextArea().setEditable(true);
					speciesView.getsubmitUpdateSciNameBtn().setVisible(true);
				}

				if (selectedColumn == "Class") {
					speciesView.getClassField().setBackground(Color.YELLOW);
					speciesView.getClassField().setEditable(true);
					speciesView.getsubmitUpdateClassBtn().setVisible(true);
				}

				if (selectedColumn == "Population") {
					speciesView.getPopField().setBackground(Color.YELLOW);
					speciesView.getPopField().setEditable(true);
					speciesView.getsubmitUpdatePopBtn().setVisible(true);
				}

				if (selectedColumn == "ESA_Conservation_Status") {
					speciesView.getEsaField().setBackground(Color.YELLOW);
					speciesView.getEsaField().setEditable(true);
					speciesView.getsubmitUpdateESABtn().setVisible(true);
				}

				if (selectedColumn == "ThreatId") {
					speciesView.getThreatField().setBackground(Color.YELLOW);
					speciesView.getThreatField().setEditable(true);
					speciesView.getsubmitUpdateThreatsBtn().setVisible(true);
				}

				if (selectedColumn == "EffortId") {
					speciesView.getConsEffortField().setBackground(Color.YELLOW);
					speciesView.getConsEffortField().setEditable(true);
					speciesView.getsubmitUpdateConsEffBtn().setVisible(true);

				}

			}
		});
		
		speciesView.getSubmitUpdateCommonNameBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String updatedCommonNameData = speciesView.getCommNameTextArea().getText();
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedCommonNameData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlEndangeredSpecies.updateCommonNameColumn(rowToUpdateValue, updatedCommonNameData));

				System.out.print("CommonName entry updated");
//				contentPane.remove(speciesView);
//				contentPane.add(speciesQuery, BorderLayout.CENTER);
				speciesView.getCommNameTextArea().setBackground(Color.LIGHT_GRAY);
				speciesView.getCommNameTextArea().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getSubmitUpdateCommonNameBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});
		
		speciesView.getsubmitUpdateSciNameBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String updatedSciNameData = speciesView.getSciNameTextArea().getText();
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedSciNameData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlEndangeredSpecies.updateScientificNameColumn(rowToUpdateValue, updatedSciNameData));

				System.out.print("ScientificName entry updated");
				speciesView.getSciNameTextArea().setBackground(Color.LIGHT_GRAY);
				speciesView.getSciNameTextArea().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getsubmitUpdateSciNameBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		speciesView.getsubmitUpdateClassBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String updatedClassData = speciesView.getClassField().getText();
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedClassData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlEndangeredSpecies.updateClassColumn(rowToUpdateValue, updatedClassData));

				System.out.print("Class entry updated");
				speciesView.getClassField().setBackground(Color.LIGHT_GRAY);
				speciesView.getClassField().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getsubmitUpdateClassBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		speciesView.getsubmitUpdatePopBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int updatedPopData = Integer.parseInt(speciesView.getPopField().getText());
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedPopData);
				System.out.println(rowToUpdateValue);

				DBConnection
						.updateColumnFromTable(SqlEndangeredSpecies.updatePopColumn(rowToUpdateValue, updatedPopData));

				System.out.print("Population entry updated");
				speciesView.getPopField().setBackground(Color.LIGHT_GRAY);
				speciesView.getPopField().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getsubmitUpdatePopBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		speciesView.getsubmitUpdateESABtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int updatedESAData = Integer.parseInt(speciesView.getEsaField().getText());
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedESAData);
				System.out.println(rowToUpdateValue);

				DBConnection
						.updateColumnFromTable(SqlEndangeredSpecies.updateESAColumn(rowToUpdateValue, updatedESAData));

				System.out.print("ESA entry updated");
				speciesView.getEsaField().setBackground(Color.LIGHT_GRAY);
				speciesView.getEsaField().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getsubmitUpdateESABtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		speciesView.getsubmitUpdateThreatsBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int updatedThreatData = Integer.parseInt(speciesView.getThreatField().getText());
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedThreatData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlEndangeredSpecies.updateThreatIDColumn(rowToUpdateValue, updatedThreatData));

				System.out.print("Threat entry updated");
				speciesView.getThreatField().setBackground(Color.LIGHT_GRAY);
				speciesView.getThreatField().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getsubmitUpdateThreatsBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		speciesView.getsubmitUpdateConsEffBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int updatedConsEffData = Integer.parseInt(speciesView.getConsEffortField().getText());
				int rowToUpdateValue = speciesIDToUpdate;
				System.out.println(updatedConsEffData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlEndangeredSpecies.updateEffortIDColumn(rowToUpdateValue, updatedConsEffData));

				System.out.print("Cons Effort entry updated");
				speciesView.getConsEffortField().setBackground(Color.LIGHT_GRAY);
				speciesView.getConsEffortField().setEditable(false);
				speciesView.getUpdateColumnBox().setVisible(false);
				speciesView.getsubmitUpdateConsEffBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		// --- DELETE SPECIES ENTRY ---
		speciesView.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int siID = Integer.parseInt(speciesQuery.getSiIDTextField().getText());
				DBConnection.deleteRowFromTable(SqlEndangeredSpecies.deleteSpeciesRow(siID));

				navBar.getTitleLabel().setText("All Species");
				speciesQuery.getSiOverviewTextArea().setText(
						DBConnection.executeQueryReturnAllEndangeredSpeciesData(SqlEndangeredSpecies.allData()));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);

				System.out.print("row deleted");
				contentPane.remove(current);
				contentPane.add(speciesQuery, BorderLayout.CENTER);
				current = speciesQuery;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		
		
		
		// --- CONSERVATION UPDATE --- 
		
		conservationView.getUpdateEntryBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conservationView.getUpdateColumnBox().setVisible(true);
				System.out.println("box visible");
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		conservationView.getUpdateColumnBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String selectedColumn = (String) conservationView.getUpdateColumnBox().getSelectedItem();
				columnToUpdate = selectedColumn;

				if (selectedColumn == "Start date") {
					conservationView.getStartDateTextArea().setBackground(Color.YELLOW);
					conservationView.getStartDateTextArea().setEditable(true);
					conservationView.getUpdateStartDateBtn().setVisible(true);
				}

				if (selectedColumn == "Organization") {
					conservationView.getOrgTextArea().setBackground(Color.YELLOW);
					conservationView.getOrgTextArea().setEditable(true);
					conservationView.getUpdateOrgSubmitBtn().setVisible(true);
				}

				if (selectedColumn == "Website") {
					conservationView.getWebsiteTextArea().setBackground(Color.YELLOW);
					conservationView.getWebsiteTextArea().setEditable(true);
					conservationView.getUpdateWebsiteSubmitBtn().setVisible(true);
				}

				if (selectedColumn == "Location") {
					conservationView.getLocTextArea().setBackground(Color.YELLOW);
					conservationView.getLocTextArea().setEditable(true);
					conservationView.getUpdateLocationSubmitBtn().setVisible(true);
				}

			}
		});
				
		conservationView.getUpdateStartDateBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String updatedOrgData = conservationView.getStartDateTextArea().getText();
				int rowToUpdateValue = Integer.parseInt(conservationOV.getCeIDTextField().getText());

				System.out.println(updatedOrgData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlConservationEffort.updateStartDate(rowToUpdateValue, updatedOrgData));

				System.out.print("Date entry updated");
				conservationView.getStartDateTextArea().setBackground(Color.LIGHT_GRAY);
				conservationView.getStartDateTextArea().setEditable(false);
				conservationView.getUpdateColumnBox().setVisible(false);
				conservationView.getUpdateStartDateBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		conservationView.getUpdateOrgSubmitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String updatedOrgData = conservationView.getOrgTextArea().getText();
				int rowToUpdateValue = conserEffIDToUpdate;
				System.out.println(updatedOrgData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlConservationEffort.updateOrganizationColumn(rowToUpdateValue, updatedOrgData));

				System.out.print("Date entry updated");
				conservationView.getOrgTextArea().setBackground(Color.LIGHT_GRAY);
				conservationView.getOrgTextArea().setEditable(false);
				conservationView.getUpdateColumnBox().setVisible(false);
				conservationView.getUpdateOrgSubmitBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		conservationView.getUpdateWebsiteSubmitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String updatedWebData = conservationView.getWebsiteTextArea().getText();
				int rowToUpdateValue = conserEffIDToUpdate;
				System.out.println(updatedWebData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlConservationEffort.updateWebsiteColumn(rowToUpdateValue, updatedWebData));

				System.out.print("Web entry updated");
				conservationView.getWebsiteTextArea().setBackground(Color.LIGHT_GRAY);
				conservationView.getWebsiteTextArea().setEditable(false);
				conservationView.getUpdateColumnBox().setVisible(false);
				conservationView.getUpdateWebsiteSubmitBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		conservationView.getUpdateLocationSubmitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String updatedLocaleData = conservationView.getLocTextArea().getText();
				int rowToUpdateValue = conserEffIDToUpdate;
				System.out.println(updatedLocaleData);
				System.out.println(rowToUpdateValue);

				DBConnection.updateColumnFromTable(
						SqlConservationEffort.updateLocationColumn(rowToUpdateValue, updatedLocaleData));

				System.out.print("Locale entry updated");
				conservationView.getLocTextArea().setBackground(Color.LIGHT_GRAY);
				conservationView.getLocTextArea().setEditable(false);
				conservationView.getUpdateColumnBox().setVisible(false);
				conservationView.getUpdateLocationSubmitBtn().setVisible(false);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		// --- DELETE CONSERVATION ENTRY ---
		conservationView.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ceID = Integer.parseInt(conservationOV.getCeIDTextField().getText());
				DBConnection.deleteRowFromTable(SqlConservationEffort.deleteConservationRow(ceID));

				conservationOV.getCeOverviewTextArea()
						.setText(DBConnection.executeQueryReturnAllCEData(SqlConservationEffort.allData()));
				conservationOV.getCeOverviewTextArea().setLineWrap(true);
				conservationOV.getCeOverviewTextArea().setWrapStyleWord(true);
				conservationOV.getCeOverviewTextArea().setEditable(false);

				System.out.print("row deleted");
				contentPane.remove(current);
				contentPane.add(conservationOV, BorderLayout.CENTER);
				current = conservationOV;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}

	
	private void navBarButtons() {
		navBar.getHomeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navBar.setTitleLabel("Home");

				contentPane.remove(current);
				contentPane.add(home, BorderLayout.CENTER);
				current = home;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		navBar.getConsEffortsButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navBar.setTitleLabel("Conservation Efforts");

				conservationOV.getCeOverviewTextArea()
						.setText(DBConnection.executeQueryReturnAllCEData(SqlConservationEffort.allData()));
				conservationOV.getCeOverviewTextArea().setLineWrap(true);
				conservationOV.getCeOverviewTextArea().setWrapStyleWord(true);
				conservationOV.getCeOverviewTextArea().setEditable(false);
				conservationOV.getCeIDTextField().setText("");
		
				contentPane.remove(current);
				contentPane.add(conservationOV, BorderLayout.CENTER);
				current = conservationOV;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		navBar.getSpeciesQueryButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navBar.setTitleLabel("All Species");

				speciesQuery.getSiOverviewTextArea().setText(
						DBConnection.executeQueryReturnAllEndangeredSpeciesData(SqlEndangeredSpecies.allData()));
				speciesQuery.getSiOverviewTextArea().setLineWrap(true);
				speciesQuery.getSiOverviewTextArea().setWrapStyleWord(true);
				speciesQuery.getSiOverviewTextArea().setEditable(false);
				speciesQuery.getSiIDTextField().setText("");

				contentPane.remove(current);
				contentPane.add(speciesQuery, BorderLayout.CENTER);
				current = speciesQuery;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		navBar.getRegionButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navBar.setTitleLabel("Regions");
				
				regionOV.getRegionTextArea().setText(
						DBConnection.executeQueryReturnAllRegionData(SqlRegion.allData()));
				regionOV.getRegionTextArea().setLineWrap(true);
				regionOV.getRegionTextArea().setWrapStyleWord(true);
				regionOV.getRegionTextArea().setEditable(false);
				regionOV.getRegionIDField().setText("");
				
				contentPane.remove(current);
				contentPane.add(regionOV, BorderLayout.CENTER);
				current = regionOV;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		navBar.getAddSpeciesButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navBar.setTitleLabel("Add New Species");
				
				contentPane.remove(current);
				contentPane.add(speciesForm, BorderLayout.CENTER);
				current = speciesForm;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		navBar.getAddConservationButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navBar.setTitleLabel("Add New Conservation Effort");

				contentPane.remove(current);
				contentPane.add(conservationForm, BorderLayout.CENTER);
				current = conservationForm;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}
	
	/**
	 * Matches the correct description to the region selected for viewing
	 * @param id Region ID taken from user input
	 * @return the correct region description
	 */
	private static String getDescription(int id) {
		String desc = "hi";
		switch (id) {
		case 1:
			desc = "The Canyon Country District, comprised of the Moab and Monticello Field Offices manages about 3.6 million surface acres, providing opportunities for commercial recreation, livestock grazing, mining and oil and gas exploration, supporting local and regional economies in many ways. This part of the Colorado Plateau is best known for its world class scenery, stark red rock canyons juxtaposed against the backdrop of the La Sal and Abajo Mountain ranges, and its multitude of recreation opportunities.";
			break;
		case 2:
			desc = "The Color Country District Office and Cedar City Field Office are co-located in southwest Utah’s Iron County, while managing public land in Beaver County.  Characterized by vast acres of sagebrush and pinyon-juniper foothills, the region offers a variety of landscapes ranging from salt desert shrub flats to high mountains with riparian, aspen, and bristlecone pine communities.  Mountain ranges include the Mineral Mountains, Wah Wah Mountains, and the Indian Peak Mountain Range.  The Field office is home to a variety of species including the Rocky Mountain Elk, Mule Deer, Antelope, Greater Sage Grouse, and Wild Horses. The Field Office is generally quite remote and offers a wide variety of dispersed recreation. The Parowan Gap, a deep, narrow gorge west of Summit, Utah, is renowned as a site of great importance to the Paiute Indians and others for many reasons, including the Fremont era petroglyphs etched on the canyon walls.";
			break;
		case 3:
			desc = "Paria River District manages 2.3 million acres of Federal land in Southern Utah encompassing both Kane and Garfield Counties, providing multiple-use opportunities for both commercial and personal recreation, livestock grazing and mining in order to support both local and regional economies.";
			break;
		case 4:
			desc = "While the Green River District is well known for mineral resources, it is quickly becoming a recreation hotspot favored by outdoor enthusiasts looking for rugged adventure. The district includes the remote and striking San Rafael Swell, which provides opportunities for hiking, mountain biking, and ATV use, and other opportunities. Near Vernal, visitors and community members can enjoy mountain biking, boating, and hunting alongside other recreational pursuits.";
			break;
		case 5:
			desc = "Located in the northwestern Utah, the 7.7 million-acre West Desert District is uniquely different from any other part of the state. Much of this area is a part of the Great Basin region, a place of isolated mountain ranges separated by desert playas and wide-sweeping sagebrush flats. With few amenities, the desert provides a place of solitude and an escape from the urban lifestyle. The West Desert District consists of the Salt Lake Field Office and Fillmore Field Office.";
			break;
		}
		return desc;
		
	}
}