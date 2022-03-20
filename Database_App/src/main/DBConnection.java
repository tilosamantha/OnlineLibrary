package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sql.SqlConservationEffort;
import sql.SqlESAConservationStatus;
import sql.SqlEndangeredSpecies;
import sql.SqlRegion;
import sql.SqlThreat;

// UPDATED AND ORDERED BY JEN 022322
/**
 * Holds all query connections made to the database tables
 * 
 * @author Jennifer Arce, Penny Chanthavong, Sam Tilo
 *
 */
public class DBConnection {
	private static String databaseURL = "jdbc:derby:EndangeredSpeciesDB;create=true";
	private static int esaIDToQuery;

	public static void main(String[] args) {

	}
	
	/**
	 * Sets up the SQL tables in the database
	 */
	public static void setUpSQL() {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {

			
			// ----- SETUP for EndangeredSpecies table -------
//			statement.execute(SqlEndangeredSpecies.createTable());
//			statement.execute(SqlEndangeredSpecies.insertData());
//			statement.execute(SqlEndangeredSpecies.dropTable());

			// ----- SETUP for ESAConservationStatus table -------
//			 statement.execute(SqlESAConservationStatus.createTable());
//			 statement.execute(SqlESAConservationStatus.insertData());
//			 statement.execute(SqlESAConservationStatus.deleteData());
//			 statement.execute(SqlESAConservationStatus.dropTable());

			// ----- SETUP for Threat table -------
//			 statement.execute(SqlThreat.createTable());
//			 statement.execute(SqlThreat.insertData());
//			 statement.execute(SqlThreat.dropTable());

			// ----- SETUP for ConservationEffort table -------
//			 statement.execute(SqlConservationEffort.dropTable());
//			statement.execute(SqlConservationEffort.createTable());
//			statement.execute(SqlConservationEffort.insertData());
			
			// ----- SETUP for Region table -------
//		 	statement.execute(SqlRegion.dropTable());
//			statement.execute(SqlRegion.createTable());
//			statement.execute(SqlRegion.insertData());
			
//			printTableResultSets(statement);

			System.out.println();
			System.out.println("done");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Prints results of the table result sets to the console
	 * 
	 * @param statement
	 * @throws SQLException
	 */
	private static void printTableResultSets(Statement statement) throws SQLException {
		// prints data from the EndangeredSpecies table
		ResultSet results = statement.executeQuery(SqlEndangeredSpecies.allData());
		System.out.println("Endangered Species table");
		System.out.println("________________________");
		System.out.printf("%-3s %-30s %-35s %-10s %-11s %-11s %-10s %-10s%n", "ID", "Common name",
				"Scientific name", "Class", "Population", "ESA Status", "ThreatId", "EffortId");
		while (results.next()) {
			int Id = results.getInt("Id");
			String commonName = results.getString("CommonName");
			String scientificName = results.getString("ScientificName");
			String classification = results.getString("Class");
			int population = results.getInt("Population");
			// int iucnStatus = results.getInt("IUCN_Conservation_Status");
			int esaStatus = results.getInt("ESA_Conservation_Status");
			int threatId = results.getInt("ThreatId");
			int effortId = results.getInt("EffortId");

			System.out.printf("%-3d %-30s %-35s %-10s %-11d %-11d %-10d %-10d%n", Id, commonName, scientificName,
					classification, population, esaStatus, threatId, effortId);
		}
		System.out.println();
		
		// prints data from the ESAConservationStatus table
		results = statement.executeQuery(SqlESAConservationStatus.allData());
		System.out.println("ESA Categories table");
		System.out.println("____________________");
		System.out.printf("%-6s %-8s%n", "ID", "ESA Status");
		while (results.next()) {
			int Id = results.getInt("ID");
			String status = results.getString("Status");
			System.out.printf("%-6d %-8s%n", Id, status);
		}
		System.out.println();

		// prints data from the Threat table
		results = statement.executeQuery(SqlThreat.allData());
		System.out.println("Threat Types table");
		System.out.println("__________________");
		System.out.printf("%-3s %-25s%n", "ID", "Threat Description");
		while (results.next()) {
			int Id = results.getInt("ID");
			String description = results.getString("Description");
			System.out.printf("%-3d %-25s%n", Id, description);
		}
		System.out.println();
		
		// prints data from the ConservationEffort table
		results = statement.executeQuery(SqlConservationEffort.allData());
		System.out.println("Conservation Efforts table");
		System.out.println("__________________________");
		System.out.printf("%-7s %-13s %-16s %-25s %-14s %-25s %-20s %-8s%n", "ID", "Status", "Start Date", "Species",
				"Organization", "Website", "Conservation_Status", "Location");
		while (results.next()) {
			int id = results.getInt("cID");
			String status = results.getString("Status");
			String date = results.getString("StartDate");
			int species = results.getInt("Associated_species");
			String org = results.getString("Organization");
			String orgURL = results.getString("Website");
			int cStatus = results.getInt("ConservationStatus");
			String loc = results.getString("Location");
			System.out.printf("%-7s %-13s %-16s %-25d %-14s %-25s %-20d %-8s%n", id, status, date, species, org,
					orgURL, cStatus, loc);
		}
	}

	/**
	 * Joins two tables to get the value from the Status column.
	 * 
	 * @param query
	 * @return string value from the Status column
	 */
	public static String executeQueryGetStatusInnerJoin(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				String s = results.getString("Status");
				sb.append(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Returns data based on the QUERY AND column SPECIFIED.
	 * 
	 * @param query
	 * @param colName
	 * @return 
	 */
	public static String executeQueryReturnDataOnColumn(String query, String colName) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				sb.append(results.getString(colName));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	 /**
	 * RETURNS ALL CONSERVATION EFFORT DATA IN THE TABLE.
	 * 
	 * @param query
	 * @return
	 */
	public static String executeQueryReturnAllCEData(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);

			sb.append(String.format("%-7s %-20s %-9s %-14s %-25s %-30s %-8s%n", "ID", "Start Date", "Species", "Organization",
					"Website", "Conservation Status", "Location"));

			while (results.next()) {
				int id = results.getInt("cID");
				String date = results.getString("StartDate");
				int species = results.getInt("Associated_species");
				String org = results.getString("Organization");
				String orgURL = results.getString("Website");
				int cStatus = results.getInt("ConservationStatus");
				String loc = results.getString("Location");

				sb.append(String.format("%-7s %-20s %-9d %-14s %-25s %-30d %-8s%n", id, date, species, org, orgURL,
						cStatus, loc));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	 /**
	  * All data from Region table
	 * @param query
	 * @return
	 */
	public static String executeQueryReturnAllRegionData(String query) {
	        StringBuilder sb = new StringBuilder();
	        try (Connection connection = DriverManager.getConnection(databaseURL);
	                Statement statement = connection.createStatement();) {
	            ResultSet results = statement.executeQuery(query);

	            sb.append(String.format("%-5s %-20s %-20s %-20s %-20s%n", "ID", "District", "Closures", 
	            		"Endangered Species", "Threats"));

	            while (results.next()) {
	            	int Id = results.getInt("ID");
	            	String district = results.getString("District");
	            	boolean closure = results.getBoolean("Closures");
	                int species = results.getInt("Endangered_species");
	                int threat = results.getInt("Threats");

	                sb.append(String.format("%-5d %-20s %-20s %-20d %-20d%n", Id, district, closure, species, threat));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return sb.toString();
	}
	 
	/**
	 * RETURNS SELECTED DATA FROM ENDANGERED SPECIES TABLE BASED ON QUERY
	 * 
	 * @param query
	 * @return common name, scientific name, ESA status, and population.
	 */
	public static String executeQueryReturnSelectedData(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);

			sb.append(String.format("%-33s %-33s %-11s %-11s\n", "Common name", "Scientific name", "ESA Status",
					"Population"));

			while (results.next()) {
				String commonName = results.getString("CommonName");
				String scientificName = results.getString("ScientificName");
				int esaStatus = results.getInt("ESA_Conservation_Status");
				int population = results.getInt("Population");
				System.out.printf("%-33s %-33s %-11d %-11d\n", commonName, scientificName, esaStatus, population);

				sb.append(
						String.format("%-33s %-33s %-11d %-11d\n", commonName, scientificName, esaStatus, population));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	 
	 /**
	  * Returns all info from Endangered Species table and displays in Species Query panel
	 * @param query
	 * @return
	 */
	public static String executeQueryReturnAllEndangeredSpeciesData(String query) {
	        StringBuilder sb = new StringBuilder();
	        try (Connection connection = DriverManager.getConnection(databaseURL);
	                Statement statement = connection.createStatement();) {
	            ResultSet results = statement.executeQuery(query);

	            sb.append(String.format("%-3s %-33s %-33s %-10s %-11s %-11s %-10s %-10s%n", "ID", "Common name", "Scientific name",
	    				"Class", "Population", "ESA Status", "ThreatId", "EffortId"));

	        	while (results.next()) {
	    			int Id = results.getInt("Id");
	    			String commonName = results.getString("CommonName");
	    			String scientificName = results.getString("ScientificName");
	    			String classification = results.getString("Class");
	    			int population = results.getInt("Population");
	    			int esaStatus = results.getInt("ESA_Conservation_Status");
	    			int threatId = results.getInt("ThreatId");
	    			int effortId = results.getInt("EffortId");

	                sb.append(String.format("%-3d %-33s %-33s %-10s %-11d %-11d %-10d %-10d%n", Id, commonName, scientificName,
	    					classification, population, esaStatus, threatId, effortId));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return sb.toString();
	    }
	 
	/**
	 * QUERY TO UPDATE A COLUMN IN A SPECIFIED TABLE BASED ON THE QUERY
	 * PASSED
	 * 
	 * @param query
	 */
	public static void updateColumnFromTable(String query) {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * QUERY TO DELETE A ROW FROM A TABLE BASED ON QUERY PASSED
	 * 
	 * @param query
	 */
	public static void deleteRowFromTable(String query) {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * QUERY TO INSERT DATA INTO A TABLE BASED ON QUERY PASSED
	 * 
	 * @param query
	 */
	public static void executeQueryInsertDataToDB(String query) {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * QUERY TO GET AND ESA ID FROM ESA CONSERVATION TABLE
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public static String printESAID(String query) throws SQLException {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				sb.append(results.getString("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}
}
