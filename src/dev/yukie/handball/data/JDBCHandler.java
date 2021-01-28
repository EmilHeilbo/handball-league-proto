package dev.yukie.handball.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCHandler {

    private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=KampregistreringDB;integratedSecurity=true;";
    private static Connection connection;
    private static String selectHold = "SELECT * FROM hold ORDER BY hold_id";
    private static String selectKampe = "SELECT (hjemme,ude) FROM kampe ORDER BY kamp_id";
    private static String selectHaendelser = "SELECT haendelse FROM haendelser ORDER BY haendelse_id";
    private static String selectRegistreringer = "SELECT (kamp, tidspunkt, haendelse) FROM registreringer ORDER BY registrerings_id";


    static {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             connection = DriverManager.getConnection(connectionUrl);
             loadAllData();
         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
     }

     public static void loadAllData() {
    	readHold();
    	readKampe();
    	readHaendelser();
    	readRegistreringer();
    }
    
    public static void readHold(){
        AppData.hold.clear();
        AppData.hold.add("");
        try {
			var stmt = connection.createStatement();
			var rs = stmt.executeQuery(selectHold);
			while(rs.next()) {
				AppData.hold.add(rs.getString("navn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static void readKampe(){
        AppData.kampe.clear();
        AppData.kampe.add(new int[0]);
        try {
			var stmt = connection.createStatement();
			var rs = stmt.executeQuery(selectKampe);
			var temp = new int[2];
			while(rs.next()) {
                temp[0] = rs.getInt("hjemme");
                temp[1] = rs.getInt("ude");
				AppData.kampe.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static void readHaendelser(){
        AppData.haendelser.clear();
        AppData.haendelser.add("");
        try {
			var stmt = connection.createStatement();
			var rs = stmt.executeQuery(selectHaendelser);
			while(rs.next()) {
				AppData.haendelser.add(rs.getString("haendelse"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static void readRegistreringer(){
        AppData.registreringer.clear();
        AppData.registreringer.add(new int[0]);
        try {
			var stmt = connection.createStatement();
			var rs = stmt.executeQuery(selectRegistreringer);
			var temp = new int[3];
			while(rs.next()) {
                temp[0] = rs.getInt("kamp");
                temp[1] = rs.getInt("tidspunkt");
                temp[2] = rs.getInt("haendelse");
				AppData.kampe.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /* TODO - Logik
    udfoer INSERT paa hold med auto increment. */
    public void createHold(String navn){

    }



    /* TODO - Logik
    udfoer INSERT paa kampe med auto increment. */
    public void createKamp(int hjemme, int ude){
    }

    /* TODO -Logik
    udfoer INSERT paa registrering med auto increment. */
    public void createRegistrering(int kamp, int tidspunkt, int haendelse){
    }
}