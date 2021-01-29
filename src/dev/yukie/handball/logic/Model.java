package dev.yukie.handball.logic;

import dev.yukie.handball.data.AppData;
import dev.yukie.handball.data.JDBCHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static final ObservableList<String> olHold = FXCollections.observableArrayList();
    private static final ObservableList<String> olKampe = FXCollections.observableArrayList();
    private static final ObservableList<String> olStilling = FXCollections.observableArrayList();

    private static JDBCHandler jdbc = new JDBCHandler();

    static {
        olHold.setAll(getHold());
        olKampe.setAll(getKampe());
        //olStilling.setAll(getStilling());
    }

    public static ObservableList<String> getObservableList(String type) {
        ObservableList<String> ol = null;
        switch (type) {
            case "hold" -> ol = olHold;
            case "kampe" -> ol = olKampe;
            case "stilling" -> ol = olStilling;
        }
        return ol;
    }

    private static List<String> getHold() {
        if (AppData.hold.size() == 1)
            return new ArrayList<>();
        return List.copyOf(AppData.hold.subList(1, AppData.hold.size()));
    }

    private static List<String> getKampe() {
        var result = new ArrayList<String>();
        var ki = AppData.kampe.iterator();
        ki.next();
        while (ki.hasNext()) {
            var temp = ki.next();
            result.add(AppData.hold.get(temp[0]) + " Vs. " + AppData.hold.get(temp[1]));
        }
        return result;
    }

    private static List<String> getRegistreringer(String kamp) {
        int k = getKampe().indexOf(kamp);
        var result = new ArrayList<String>();
        var ri = AppData.registreringer.iterator();
        ri.next();
        while (ri.hasNext()) {
            var temp = ri.next();
            if (temp[0] != k)
                continue;
            result.add(temp[1] + AppData.haendelser.get(temp[2]));
        }
        return result;
    }

    /*
     * TODO - Logik retunere en liste med array af Strings, svarende til holdnavn og
     * points.
     */
    private static List<String> getStilling() {
        //calculateStilling();
        var result = new ArrayList<String>();
        for (int i = 1; i < AppData.stilling.size(); i++) {
            try {
                AppData.stilling.get(i);
            } catch (Exception e) {
                continue;
            }
            result.add(AppData.stilling.get(i) + " points til " + AppData.hold.get(i));
        }
        return result;
    }

    public static boolean addHold(String navn) {
        if (jdbc.createHold(navn)) {
            olHold.add(navn);
            return true;
        }
        return false;
    }

    public static boolean addKamp(String hjemme, String ude) {
        int h = AppData.hold.indexOf(hjemme);
        int u = AppData.hold.indexOf(ude);
        if (jdbc.createKamp(h, u)) {
            olKampe.add(hjemme + " Vs. " + ude);
            return true;
        }
        return false;
    }

    public static boolean addRegistrering(int kamp, int tidspunkt, int haendelse) {
        return jdbc.createRegistrering(kamp, tidspunkt, haendelse);
    }

    public static boolean hasRegistreringer(String kamp) {
        var k = getKampe().indexOf(kamp)+1;
        boolean skipFirst = true;
        for (int[] i : AppData.registreringer) {
            if (skipFirst) {
                skipFirst = false;
                continue;
            }
            if (i[0] == k)
                return true;
        }
        return false;
    }

    /*
     * private static void addPoints(int hold, int points) {
     * AppData.stilling.ensureCapacity(hold+1); boolean noValue = false; try {
     * AppData.stilling.get(hold); } catch (Exception e) { noValue = true; } if
     * (noValue) AppData.stilling.add(hold, points); else AppData.stilling.set(hold,
     * AppData.stilling.get(hold)+points); }
     */

    /*
     * private static void calculateStilling() { int kamp = 0; boolean skipFirst =
     * true; int hjemmeMaal, udeMaal; hjemmeMaal = udeMaal = 0; for (int[]
     * registrering : AppData.registreringer) { if (skipFirst) { skipFirst = false;
     * continue; } if (kamp == 0) { kamp = registrering[0]; } else if
     * (registrering[0] != kamp) { int hjemmeHold, udeHold; hjemmeHold =
     * AppData.kampe.get(kamp)[0]; udeHold = AppData.kampe.get(kamp)[1]; if
     * (hjemmeMaal == udeMaal) { addPoints(hjemmeHold, 1); addPoints(udeHold, 1); }
     * else if (hjemmeMaal > udeMaal) { addPoints(hjemmeHold, 2); addPoints(udeHold,
     * 0); } else { addPoints(udeHold, 2); addPoints(hjemmeHold, 0); } hjemmeMaal =
     * udeMaal = 0; kamp = registrering[0]; } if(registrering[2]==1) hjemmeMaal++;
     * else if(registrering[2]==3) udeMaal++; } }
     */
}