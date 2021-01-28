package dev.yukie.handball.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCHandler {

    private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=KampregistreringDB;integratedSecurity=true;";
    private static Connection connection;
    private static final String selectHold = "SELECT * FROM hold ORDER BY hold_id";
    private static final String selectKampe = "SELECT hjemme, ude FROM kampe ORDER BY kamp_id";
    private static final String selectHaendelser = "SELECT haendelse FROM haendelser ORDER BY haendelse_id";
    private static final String selectRegistreringer = "SELECT kamp, tidspunkt, haendelse FROM registreringer ORDER BY registrerings_id";
    private static final String callInsertHold = "{CALL insert_hold (?)}";
    private static final String callInsertKamp = "{CALL insert_kamp (?,?)}";
    private static final String callInsertRegistrering = "{CALL insert_registrering (?,?,?)}";

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
			while(rs.next()) {
                var temp = new int[2];
                temp[0] = rs.getInt(1);
                temp[1] = rs.getInt(2);
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
			while(rs.next()) {
                var temp = new int[3];
                temp[0] = rs.getInt("kamp");
                temp[1] = rs.getInt("tidspunkt");
                temp[2] = rs.getInt("haendelse");
				AppData.registreringer.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public boolean createHold(String navn){
        try {
            var cs = connection.prepareCall(callInsertHold);
            cs.setString("navn", navn);
            if(cs.execute()) AppData.hold.add(navn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean createKamp(int hjemme, int ude){
        try {
            var cs = connection.prepareCall(callInsertKamp);
            cs.setInt("hjemmeHold", hjemme);
            cs.setInt("udeHold", ude);
            if(cs.execute()) AppData.kampe.add(new int[]{hjemme,ude});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createRegistrering(int kamp, int tidspunkt, int haendelse){
        try {
            var cs = connection.prepareCall(callInsertRegistrering);
            cs.setInt("kamp", kamp);
            cs.setInt("tidspunkt", tidspunkt);
            cs.setInt("haendelse", haendelse);
            if(cs.execute()) AppData.registreringer.add(new int[]{kamp,tidspunkt,haendelse});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}