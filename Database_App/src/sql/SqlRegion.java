package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Provides SQL statements related to the Region table.
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */

public class SqlRegion {
	
	/**
	 * Creates the Region table.
	 * @return 
	 * 
	 */
	public static final String createTable() {
		return "CREATE TABLE Region ( "
			    + "ID int not null primary key "
				+ "GENERATED ALWAYS AS IDENTITY "
			    + "(START WITH 1, INCREMENT BY 1), "
				+ "District varchar(255), "
			    + "Street_address varchar(255), "
				+ "Ending_address varchar(255), "
			    + "Email varchar(255), "
				+ "Phone varchar(255), "
			    + "Hours varchar(255), "
			    + "Closures boolean, "
			    + "Endangered_species int, "
			    + "Threats int "
			    + ")";
	}
	
	/**
	 * Drops the Region table.
	 * @return
	 */
	public static String dropTable() {
		return "DROP TABLE Region";
	}
	
	
	/**
	 * Inserts data values into the Region table.
	 * 
	 * @return
	 */
	public static String insertData() {
		return "INSERT INTO Region "
				+ "(District, Street_address, Ending_address, Email, Phone, Hours, "
				+ "Closures, Endangered_species, Threats) VALUES "
				+ "('Canyon Country', '82 East Dogwood', 'Moab, UT 84532', 'blm_ut_mb_mail@blm.gov', '(435) 259-2100', '8:00am - 4:30pm', true, 1, 5), "
				+ "('Color Country', '176 East D.L. Sargent Drive', 'Cedar City, UT 84721', 'BLM_UT_Cedar_City@blm.gov', '(435) 865-3000', '7:45am - 4:30pm', true, 1, 1), "
				+ "('Paria River', '669 S. Highway 89A', 'Kanab, UT 84741', 'escalante_interagency@blm.gov', '(435) 644-1200', '8:00am - 4:30pm', true, 2, 1), "
				+ "('Green River', '170 South 500 East', 'Vernal, UT 84078', 'utvnmail@blm.gov', '(435) 781-4400', '8:00am - 4:30pm', false, 3, 5), "
				+ "('West Desert', '491 North John Glenn Road', 'Salt Lake City, UT 84116', 'utslmail@blm.gov', '(801) 320-8300', '8:00am - 4:30pm', true, 5, 1)";
	}
	
	public static String getDistrictFromForm() {
		return "SELECT District FROM Region";
	}
	
	public static String getDistrict(int id) {
		return "SELECT District FROM Region WHERE ID = " + id;
	}
	
	public static String getStreetAddress(int id) {
		return "SELECT Street_address FROM Region WHERE ID = " + id;
	}
	
	public static String getEndingAddress(int id) {
		return "SELECT Ending_address FROM Region WHERE ID = " + id;
	}
	
	public static String getEmail(int id) {
		return "SELECT Email FROM Region WHERE ID = " + id;
	}
	
	public static String getPhone(int id) {
		return "SELECT Phone FROM Region WHERE ID = " + id;
	}
	
	public static String getHours(int id) {
		return "SELECT Hours FROM Region WHERE ID = " + id;
	}
	
	/**
	 * Selects and returns all data from the Region table.
	 * @return 
	 * 
	 */
	public static String allData() {
		return "SELECT * FROM Region";
	}
}
	