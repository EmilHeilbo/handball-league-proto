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
    udfør SELECT Query på kampe,
    retunere alle kampe i en liste af int arrays,
    hvor int[0], svarer til hjemme holdet,
    og int[1], svarer til ude holdet.
    indeks 0 i listen skal være tom. */
    public static void readKampe(){
        AppData.kampe = new ArrayList<int[]>();
    }

    /* TODO - Logik
    udfør SELECT Query på haendelser,
    retunere alle hændelser i rækkefølge,
    indeks 0 skal være tom. */
    public static void readHaendelser(){
        AppData.haendelser = new ArrayList<String>();

    }

    /* TODO - Logik
    udfør SELECT Query på registreringer,
    retunere alle registreringer i en liste af int arrays,
    hvor int[0], svarer til kampen,
    int[1], svarer til tidspunktet,
    int[2], svarer til hændelsen.
    indeks 0 i listen skal være tom. */
    public static void readRegistreringer(){
        AppData.registreringer = new ArrayList<int[]>();
    }

    /* TODO - Logik
    udfør INSERT på hold med auto increment. */
    public void createHold(String navn){

        }



    /* TODO - Logik
    udfør INSERT på kampe med auto increment. */
    public void createKamp(int hjemme, int ude){
    }

    /* TODO -Logik
    udfør INSERT på registrering med auto increment. */
    public void createRegistrering(int kamp, int tidspunkt, int hændelse){
    }
}