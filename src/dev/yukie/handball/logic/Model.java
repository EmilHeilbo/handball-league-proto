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
        olStilling.setAll(getStilling());
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

    private static List<String> getRegistreringer(int kamp) {
        var result = new ArrayList<String>();
        var ri = AppData.registreringer.iterator();
        ri.next();
        while (ri.hasNext()) {
            var temp = ri.next();
            if (temp[0] != kamp)
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
        return new ArrayList<>();
    }

    public static boolean addHold(String navn) {
        if (jdbc.createHold(navn)) {
            olHold.add(navn);
            return true;
        } else
            return false;
    }

    public static boolean addKamp(int hjemme, int ude) {
        if (jdbc.createKamp(hjemme, ude)) {
            olKampe.add(AppData.hold.get(hjemme) + " Vs. " + AppData.hold.get(ude));
            return true;
        } else
            return false;
    }

    public static boolean addRegistrering(int kamp, int tidspunkt, int haendelse) {
        return jdbc.createRegistrering(kamp, tidspunkt, haendelse);
    }

    /*
     * TODO - Logik udregn stiling ud fra registreringer, dog kun naar kampen er
     * faerdig registreret.
     */
    private static void calculateStilling() {
    }
}