package dev.yukie.handball.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCHandler {

    private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=KampregistreringDB;integratedSecurity=true;";
    private static Connection connection;
    private static String readHaendelser = "SELECT haendelse FROM haendelser ORDER BY haendelse_id";
    private static String readKampe = "SELECT (hjemme,ude) FROM kampe ORDER BY kamp_id";


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
			var sql = "SELECT * FROM hold ORDER BY hold_id";
			var rs = stmt.executeQuery(sql);
			while(rs.next()) {
				AppData.hold.add(rs.getString("navn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }


    /* TODO - Logik
    udfoer SELECT Query paa kampe,
    retunere alle kampe i en liste af int arrays,
    hvor int[0], svarer til hjemme holdet,
    og int[1], svarer til ude holdet.
    indeks 0 i listen skal vaere tom. */
    public static void readKampe(){
        AppData.kampe = new ArrayList<int[]>();
    }

    /* TODO - Logik
    udfoer SELECT Query paa haendelser,
    retunere alle haendelser i raekkefoelge,
    indeks 0 skal vaere tom. */
    public static void readHaendelser(){
        AppData.haendelser = new ArrayList<String>();

    }

    /* TODO - Logik
    udfoer SELECT Query paa registreringer,
    retunere alle registreringer i en liste af int arrays,
    hvor int[0], svarer til kampen,
    int[1], svarer til tidspunktet,
    int[2], svarer til haendelsen.
    indeks 0 i listen skal vaere tom. */
    public static void readRegistreringer(){
        AppData.registreringer = new ArrayList<int[]>();
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