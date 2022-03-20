package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Provides SQL statements related to the Threats table.
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class SqlThreat {
	
	/**
	 * Creates the Threats table.
	 * @return 
	 * 
	 */
	public static final String createTable() {
		return "CREATE TABLE Threats ( "
			    + "ID int not null primary key "
				+ "GENERATED ALWAYS AS IDENTITY "
			    + "(START WITH 1, INCREMENT BY 1), "
			    + "Description varchar(255) "
			    + ")";
	}
	
	/**
	 * Drops the Threat table.
	 * @return 
	 */
	public static String dropTable() {
		return "DROP TABLE Threats";
	}
	
	/**
	 * Inserts data values into the Threat table.
	 * @return 
	 * 
	 */
	public static String insertData() {
		return "INSERT INTO Threats "
				+ "(Description) VALUES "
				+ "('Residential and commercial development'), "
				+ "('Agriculture'), "
				+ "('Energy production and mining'), "
				+ "('Transportation and service corridors'), "
				+ "('Biological resource use (hunting, logging, etc.)'), "
				+ "('Human intrusions and disturbance'), "
				+ "('Natural system modifications (fire, dams, etc.)'), "
				+ "('Invasive species, genes & diseases'), "
				+ "('Pollution (sewage, oil spills, soil erosion, etc.)'), "
				+ "('Geological events'), "
				+ "('Climate change and severe weather'), "
				+ "('Other') ";
	}
	
	
	public static String getDescriptionFromForm() {
		return "SELECT Description FROM Threats";
	}
	
	public static String selectData(String s) {
		return "SELECT ID FROM Threats WHERE Description = '%"
				+ s + "%' ";
	}
	
	/**
	 * Selects and returns all data from the Region table.
	 * @return 
	 * 
	 */
	public static String allData() {
		return "SELECT * FROM Threats";
	}
}
