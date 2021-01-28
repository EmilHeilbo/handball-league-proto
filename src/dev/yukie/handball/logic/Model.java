package dev.yukie.handball.logic;

import dev.yukie.handball.data.AppData;
import dev.yukie.handball.data.JDBCHandler;

import java.util.ArrayList;
import java.util.List;
public class Model {

    private static JDBCHandler jdbc = new JDBCHandler();

    public static List<String> getHold() {
        if(AppData.hold.size()==1) return new ArrayList<>();
        return AppData.hold.subList(1, AppData.hold.size());
    }

    public static List<String>  getKampe(){
        var result = new ArrayList<String>();
        var ki = AppData.kampe.iterator();
        ki.next();
        while(ki.hasNext()){
            var temp = ki.next();
            result.add(AppData.hold.get(temp[0]) + " Vs. " + AppData.hold.get(temp[1]));
        }
        return result;
    }

    public static List<String>  getRegistreringer(int kamp) {
        var result = new ArrayList<String>();
        var ri = AppData.registreringer.iterator();
        ri.next();
        while(ri.hasNext()){
            var temp = ri.next();
            if(temp[0]!=kamp) continue;
            result.add(temp[1] + AppData.haendelser.get(temp[2]));
        }
        return result;}

    /* TODO - Logik
    retunere en liste med array af Strings,
    svarende til holdnavn og points. */
    public static List<Integer> getStilling(){
        return AppData.stilling;
    }

    public static boolean addHold(String navn)
    {return jdbc.createHold(navn);}

    public static boolean addKamp(int hjemme, int ude)
    {return jdbc.createKamp(hjemme, ude);}

    public static boolean addRegistrering(int kamp, int tidspunkt, int haendelse)
    {return jdbc.createRegistrering(kamp, tidspunkt, haendelse);}

    /* TODO - Logik
    udregn stiling ud fra registreringer,
    dog kun naar kampen er faerdig registreret. */
    private static void calculateStilling(){
    }
}