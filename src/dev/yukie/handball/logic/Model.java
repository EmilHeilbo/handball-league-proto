package dev.yukie.handball.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Representere vores data som var det taget direkte fra databasen,
   hvilket ses ved at vi har tomme værdier i listerne på indeks 0. */
public class Model {
    private static List<String>  hold;
    private static List<int[]>   kampe;
    private static List<String>  hændelser;
    private static List<int[]>   registreringer;
    private static List<Integer> stilling;

    // Initialisering - fjernes når database delen er implementeret.
    static{
        hold = new ArrayList<>(
            Arrays.asList(
                "",
                "Ålborg",     // 1
                "Århus",      // 2
                "Herning",    // 3
                "København",  // 4
                "Silkeborg"));// 5

        kampe = new ArrayList<>(
            Arrays.asList(
                //new int[]{},
                new int[]{3,5},  // 1 - Herning vs. Silkeborg
                new int[]{2,1},  // 2 - Århus   vs. Ålborg
                new int[]{1,2})  // 3 - Ålborg  vs. Århus
        );

        hændelser = new ArrayList<>(
            Arrays.asList(
                "",
                "Mål Hjemme",       // 1
                "Udvisning Hjemme", // 2
                "Mål Ude",          // 3
                "Udvisning Ude"     // 4
            )
        );

        registreringer = new ArrayList<>(
            Arrays.asList(
                //new int[]{},
                new int[]{1,9,4},   // 1 - Kamp nr 1,  9 sekunder inde, hændelse nr 4.
                new int[]{1,27,1},  // 2 - Kamp nr 1, 27 sekunder inde, hændelse nr 1.
                new int[]{1,42,1},  // 3 ...
                new int[]{1,99,2},  // 4 ...
                new int[]{1,114,3}  // 5 ...
            )
        );

        stilling = new ArrayList<>(Arrays.asList(new Integer[10]));
        stilling.add(3, 2);           // hold nr 3, har 2 points,
    }


// #####################################
// ##########    Getters     ###########
// ##########vvvvvvvvvvvvvvvv###########

    public static List<String> getHold()
    {return hold.subList(1, hold.size());}

    /* TODO - Logik,
    retunere en liste med array af Strings,
    svarende til holdnavnene. */
    public static List<int[]>  getKampe()
    {return kampe.subList(1, kampe.size());}

    /* TODO - Logik,
    retunere en liste med array af Strings,
    svarende til tidspunkt og hændelse af registreringer,
    for den bestemte kamp */
    public static List<int[]>  getRegistreringer(int kamp)
    {return registreringer.subList(1, registreringer.size());}

    /* TODO - Logik
    retunere en liste med array af Strings,
    svarende til holdnavn og points. */
    public static List<Integer> getStilling(){
        return stilling;
    }


// #####################################
// ##########     Adders     ###########
// ##########vvvvvvvvvvvvvvvv###########

    /* TODO - Logik
    navn må ikke allerede være i hold listen. */
    public static void addHold(String navn)
    {hold.add(navn);}

    /* TODO - Logik
    kamp.length==2
    kamp[0] og kamp[1] <= hold.length+1.*/
    public static void addKamp(int[] kamp)
    {kampe.add(kamp);}

    /* TODO - Logik
    registrering.length==3
    registrering[0] <= hold.length+1
    registrering[2] <= hændelser.length+1
    registrering[1] skal overholde kampens maks længde i spilletid. */
    public static void addRegistrering(int[] registrering)
    {registreringer.add(registrering);}


// #####################################
// ##########  Calculations  ###########
// ##########vvvvvvvvvvvvvvvv###########

    /* TODO - Logik
    udregn stiling ud fra registreringer,
    dog kun når kampen er færdig registreret. */
    private static void calculateStilling(){
    }
}