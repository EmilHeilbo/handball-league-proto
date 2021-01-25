package dev.yukie.handball.logic;

import dev.yukie.handball.data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* Representere vores data som var det taget direkte fra databasen,
   hvilket ses ved at vi har tomme vaerdier i listerne paa indeks 0. */
public class Model {

    // Initialisering - fjernes naar database delen er implementeret.
    /*static{
        AppData.hold = new ArrayList<>(
            Arrays.asList(
                "",
                "Aalborg",     // 1
                "Aarhus",      // 2
                "Herning",    // 3
                "Koebenhavn",  // 4
                "Silkeborg"));// 5

        AppData.kampe = new ArrayList<>(
            Arrays.asList(
                //new int[]{},
                new int[]{3,5},  // 1 - Herning vs. Silkeborg
                new int[]{2,1},  // 2 - Aarhus   vs. Aalborg
                new int[]{1,2})  // 3 - Aalborg  vs. Aarhus
        );

        AppData.haendelser = new ArrayList<>(
            Arrays.asList(
                "",
                "Maal Hjemme",       // 1
                "Udvisning Hjemme", // 2
                "Maal Ude",          // 3
                "Udvisning Ude"     // 4
            )
        );

        AppData.registreringer = new ArrayList<>(
            Arrays.asList(
                //new int[]{},
                new int[]{1,9,4},   // 1 - Kamp nr 1,  9 sekunder inde, haendelse nr 4.
                new int[]{1,27,1},  // 2 - Kamp nr 1, 27 sekunder inde, haendelse nr 1.
                new int[]{1,42,1},  // 3 ...
                new int[]{1,99,2},  // 4 ...
                new int[]{1,114,3}  // 5 ...
            )
        );

        AppData.stilling = new ArrayList<>(Arrays.asList(new Integer[10]));
        AppData.stilling.add(3, 2);           // hold nr 3, har 2 points,
    }*/


// #####################################
// ##########    Getters     ###########
// ##########vvvvvvvvvvvvvvvv###########

    public static List<String> getHold()
    {return AppData.hold.subList(1, AppData.hold.size());}

    /* TODO - Logik,
    retunere en liste med array af Strings,
    svarende til holdnavnene. */

    public static List<int[]>  getKampe(){
        return AppData.kampe.subList(1, AppData.kampe.size());
    }

    /* TODO - Logik,
    retunere en liste med array af Strings,
    svarende til tidspunkt og haendelse af registreringer,
    for den bestemte kamp */
    public static List<int[]>  getRegistreringer(int kamp)
    {return AppData.registreringer.subList(1, AppData.registreringer.size());}

    /* TODO - Logik
    retunere en liste med array af Strings,
    svarende til holdnavn og points. */
    public static List<Integer> getStilling(){
        return AppData.stilling;
    }


// #####################################
// ##########     Adders     ###########
// ##########vvvvvvvvvvvvvvvv###########

    /* TODO - Logik
    navn maa ikke allerede vaere i hold listen. */
    public static void addHold(String navn)
    {AppData.hold.add(navn);}

    /* TODO - Logik
    kamp.length==2
    kamp[0] og kamp[1] <= hold.length+1.*/
    public static void addKamp(int[] kamp)
    {AppData.kampe.add(kamp);}

    /* TODO - Logik
    registrering.length==3
    registrering[0] <= hold.length+1
    registrering[2] <= haendelser.length+1
    registrering[1] skal overholde kampens maks laengde i spilletid. */
    public static void addRegistrering(int[] registrering)
    {AppData.registreringer.add(registrering);}


// #####################################
// ##########  Calculations  ###########
// ##########vvvvvvvvvvvvvvvv###########

    /* TODO - Logik
    udregn stiling ud fra registreringer,
    dog kun naar kampen er faerdig registreret. */
    private static void calculateStilling(){
    }
}