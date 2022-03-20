package sql;

/**
 * Provides SQL statements related to the ConservationEffort table.
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class SqlConservationEffort {

	/**
	 * Creates the ConservationEffort table.
	 * @return 
	 * 
	 */
	public static final String createTable() {	
		return 
			"CREATE TABLE ConservationEffort ( "
		    + "cID int not null primary key "
			+ "GENERATED ALWAYS AS IDENTITY "
		    + "(START WITH 12345, INCREMENT BY 1), "
		    + "Status varchar(255), "
		    + "StartDate varchar(255), "
		    + "Associated_species int, "
		    + "Organization varchar(255), "
		    + "Website varchar(255), "
		    + "ConservationStatus int, "
		    + "Location varchar(255) "
		    + ")";
	}
	
	/**
	 * Inserts data values into the ConservationEffort table.
	 * 
	 * @return
	 */
	public static String insertData() {
		return "INSERT INTO ConservationEffort "
				+ "(Status, StartDate, Associated_species, Organization, Website, ConservationStatus, Location) VALUES "
				+ "('testing1', '1972-03-28', 1, 'testOrg1', 'www.saveSpecies1.org', 123, 'USA'), "
				+ "('testing2', '1996-01-01', 2, 'testOrg2', 'www.saveSpecies2.org', 124, 'USA'), "
				+ "('testing3', '2011-11-10', 3, 'testOrg3', 'www.saveSpecies3.org', 125, 'USA'), "
				+ "('testing4', '2011-05-01', 4, 'testOrg4', 'www.saveSpecies4.org', 126, 'USA'), "
				+ "('testing5', '2011-05-01', 5, 'testOrg5', 'www.saveSpecies5.org', 127, 'USA'), "
				+ "('testing6', '2011-05-01', 6, 'testOrg6', 'www.saveSpecies6.org', 128, 'USA'), "
				+ "('testing7', '2011-05-01', 7, 'testOrg7', 'www.saveSpecies7.org', 129, 'USA'), "
				+ "('testing8', '1984-01-01', 8, 'testOrg8', 'www.saveSpecies8.org', 130, 'USA'), "
				+ "('testing9', '2022-02-24', 19, 'testOrg9', 'www.saveSpecies9.org', 123, 'USA'), "
				+ "('testing10', '2022-02-01', 20, 'testOrg10', 'www.saveSpecies10.org', 123, 'USA') ";
	}
	
	/**
	 * Drops the ConservationEffort table.
	 * @return 
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE ConservationEffort";
	}
	
	/**
	 * Takes parameters and inserts into database table //TODO
	 * 
	 * @param status
	 * @param date
	 * @param species
	 * @param organization
	 * @param website
	 * @param conservationStatus
	 * @param location
	 * @return 
	 */
	public static String insertDataWithParams(String status, String date, int species, 
			String organization, String website, int conservationStatus, String location) {
				
		return 
				"INSERT INTO ConservationEffort "
				+ "(Status, StartDate, Associated_species, Organization, Website, "
				+ "ConservationStatus, Location) VALUES ('" + status + "', '" + date + "', " + species + ", '" + organization 
				+ "', '" + website + "', " + conservationStatus + ", '" + location + "')";

	}

	
	
	// *** QUERIES THAT UPDATE SPECIFIC COLUMNS IN THE TABLE BASED ON THE EFFORT ID
	// ***

	/**
	 * Updates the Organization column.
	 * 
	 * @param ID          of the row to be updated.
	 * @param updatedData
	 * @return SQL query
	 */
	public static String updateOrganizationColumn(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE ConservationEffort SET Organization = " + "'" + updatedData + "'" + " WHERE cID = " + ID;
	}
	
	/**
	 * Updates the website column.
	 * 
	 * @param ID          of the row to be updated.
	 * @param updatedData
	 * @return SQL query
	 */
	public static String updateWebsiteColumn(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE ConservationEffort SET Website = " + "'" + updatedData + "'" + " WHERE cID = " + ID;
	}

	/**
	 * Updates the location column.
	 * 
	 * @param ID          of the row to be updated.
	 * @param updatedData
	 * @return SQL query
	 */
	public static String updateLocationColumn(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE ConservationEffort SET Location = " + "'" + updatedData + "'" + " WHERE cID = " + ID;
	}
	
	/**
	 * Updates the StartDate column.
	 * 
	 * @param ID          of the row to be updated.
	 * @param updatedData
	 * @return SQL query
	 */
	public static String updateStartDate(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE ConservationEffort SET StartDate = '" + updatedData + "' WHERE cID = " + ID;
	}
	
	
	
	// *** QUERIES TO RETURN THE CONSERVATION EFFORT STRING BASED ON THE ID PASSED

	/**
	 * Returns data from the ConservationEffort column based on the id.
	 * @param id of the row.
	 * @return SQL query
	 */
	public static String getConservationEffortData(int id) {
		return "SELECT * FROM ConservationEffort WHERE cID = " + id;
	}
	


	
	// *** PENNY'S JOIN QUERY ***

	/**
	 * Joins the ConservationEffort and EndangeredSpecies table on the
	 * associated_species column and ID of the endangered species and returns data
	 * from the CommonName column.
	 * 
	 * @param id of the ConservationEffort row
	 * @return SQL query
	 */
	public static String getCommonNameOnJoin(int id) {
		return "SELECT EndangeredSpecies.CommonName " + "FROM EndangeredSpecies " + "INNER JOIN ConservationEffort "
				+ "ON ConservationEffort.associated_species = EndangeredSpecies.ID " + "WHERE ConservationEffort.cID = "
				+ id;
	}

	/**
	 * Joins the ConservationEffort and EndangeredSpecies table on the
	 * associated_species column and ID of the endangered species and returns data
	 * from the ScientificName column.
	 * 
	 * @param id of the ConservationEffort row
	 * @param id
	 * @return SQL query
	 */
	public static String getSciNameOnJoin(int id) {
		return "SELECT EndangeredSpecies.ScientificName " + "FROM EndangeredSpecies " + "INNER JOIN ConservationEffort "
				+ "ON ConservationEffort.associated_species = EndangeredSpecies.ID " + "WHERE ConservationEffort.cID = "
				+ id;
	}
	
	
	
	
	// *** QUERY TO DELETE A ROW FROM TABLE
	/**
	 * Deletes the conservation effort row based on the id entered.
	 * 
	 * @param id of the row.
	 * @return
	 */
	public static String deleteConservationRow(int id) {
		return "DELETE FROM ConservationEffort WHERE cID = " + id;
	}

	
	
	/**
	 * Joins the ConservationEffort and ESAConservationStatus table on the ID column
	 * of ESAConservationStatus and the ConservationStatus column of
	 * ConservationEffort table and returns data from the Status column.
	 * 
	 * @param id of the ConservationEffort row
	 * @return SQL query
	 */
	public static String getConservationStatusOnJoin(int id) {
		return "SELECT ESAConservationStatus.Status " 
				+ "FROM ESAConservationStatus " 
				+ "INNER JOIN ConservationEffort "
				+ "ON ESAConservationStatus.ID = ConservationEffort.ConservationStatus "
				+ "WHERE ConservationEffort.cID = " + id;
	}   
	
	
	/**
	 * Selects and returns all data from the ConservationEffort table.
	 * @return 
	 * 
	 */
	public static String allData() {	
		return "SELECT * FROM ConservationEffort";
	}
}
