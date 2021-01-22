package dev.yukie.handball.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCHandler {

    private static final String connectionUrl = "jdbc:sqlserver://localhost:1443;instanceName=SQLEXPRESS;databaseName=KampregistreringDB;integratedSecurity=true;";
    private static Connection connection;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /* TODO - Logik
    udfør SELECT Query på hold,
    retunere alle holdNavne i rækkefølge,
    indeks 0 skal være tom. */
    public void readHold(){
        AppData.hold = new ArrayList<String>();
    }

    /* TODO - Logik
    udfør SELECT Query på kampe,
    retunere alle kampe i en liste af int arrays,
    hvor int[0], svarer til hjemme holdet,
    og int[1], svarer til ude holdet.
    indeks 0 i listen skal være tom. */
    public void readKampe(){
        AppData.kampe = new ArrayList<int[]>();
    }

    /* TODO - Logik
    udfør SELECT Query på haendelser,
    retunere alle hændelser i rækkefølge,
    indeks 0 skal være tom. */
    public void readHændelser(){
        AppData.hændelser = new ArrayList<String>();
    }

    /* TODO - Logik
    udfør SELECT Query på registreringer,
    retunere alle registreringer i en liste af int arrays,
    hvor int[0], svarer til kampen,
    int[1], svarer til tidspunktet,
    int[2], svarer til hændelsen.
    indeks 0 i listen skal være tom. */
    public void readRegistreringer(){
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