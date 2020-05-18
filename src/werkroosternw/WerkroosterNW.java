/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

import java.util.ArrayList;

/**
 * WerkroosterNW beheert een overzicht van de diensten.
 * @author Jonathan van der Steege (2020)
 */
public class WerkroosterNW {

    private ArrayList<Dienst> dienstenWeek = new ArrayList<>();
    private ArrayList<Dienst> dienstenWeekend = new ArrayList<>();
    
    /**
     * Maakt de lijsten met gegevens van de diensten leeg.
     */
    private void resetDiensten() {
        dienstenWeek.clear();
        dienstenWeekend.clear();
    }

    /**
     * Vult de lijsten (dienstenWeek en dienstenWeekend) met namen van diensten,
     * tijden en opmerkingen.
     */
    public void vulDiensten(ArrayList<Dienst> week, ArrayList<Dienst> weekend) {
        /*
        dienstenWeek.add(new Dienst("1", " 7.30", "15.30", ""));
        dienstenWeek.add(new Dienst("3", " 7.30", "16.30", "(pauze 12.30 - 13.30)"));
        dienstenWeek.add(new Dienst("4", "10.30", "20.00", "(pauze 13.30 - 15.00)"));
        dienstenWeek.add(new Dienst("5", "14.30", "22.30", ""));
        dienstenWeek.add(new Dienst("/4", "16.30", "20.30", "(vaak met theater)"));
        dienstenWeek.add(new Dienst("D4", "10.00", "14.00", ""));
        dienstenWeek.add(new Dienst("D65", "10.00", "16.30", "(op donderdag van de TB)"));
        dienstenWeekend.add(new Dienst("1", " 7.30", "15.30", ""));
        dienstenWeekend.add(new Dienst("3", " 7.30", "15.30", ""));
        dienstenWeekend.add(new Dienst("4za", "10.45", "20.00", "(pauze 13.45 - 15.00)"));
        dienstenWeekend.add(new Dienst("4zo", "12.00", "20.00", ""));
        dienstenWeekend.add(new Dienst("5", "14.30", "22.30", ""));
         */
        resetDiensten();
        for (Dienst d : week) {
            dienstenWeek.add(d);
        }
        for (Dienst d : weekend) {
            dienstenWeekend.add(d);
        }
    }

    /**
     * Geeft de diensten in de week.
     * @return Diensten in de week
     */
    public ArrayList<Dienst> geefDienstenWeek() {
        return dienstenWeek;
    }

    /**
     * Geeft de diensten in het weekend.
     * @return Diensten in het weekend
     */
    public ArrayList<Dienst> geefDienstenWeekend() {
        return dienstenWeekend;
    }

    /**
     * Geeft alle diensten van de week.
     *
     * @return Alle diensten van de week onder elkaar
     */
    public String printDienstenWeek() {
        String res = "";
        for (Dienst d : dienstenWeek) {
            res += d.geefTotaal() + "\n";
        }
        return res;
    }

    /**
     * Geeft alle diensten van het weekend.
     *
     * @return Alle diensten van het weekend onder elkaar
     */
    public String printDienstenWeekend() {
        String res = "";
        for (Dienst d : dienstenWeekend) {
            res += d.geefTotaal() + "\n";
        }
        return res;
    }

    /**
     * Geeft de diensten in de week, zoals het opgeslagen kan worden in een
     * bestand.
     * @return Diensten in de week
     */
    public String dataOpslaanDienstenWeek() {
        String result = "";
        for (Dienst d : dienstenWeek) {
            String opmerkingen;
            if (d.geefOpmerkingen().equals("")) {
                opmerkingen = "_";
            } else {
                opmerkingen = d.geefOpmerkingen();
            }
            result += d.geefNaam() + "\t" + d.geefTijdVan() + "\t" + d.geefTijdTot() + "\t" + opmerkingen + "\n";
        }
        return result;
    }

    /**
     * Geeft de diensten in het weekend, zoals het opgeslagen kan worden in een
     * bestand.
     * @return Diensten in het weekend
     */
    public String dataOpslaanDienstenWeekend() {
        String result = "";
        for (Dienst d : dienstenWeekend) {
            String opmerkingen;
            if (d.geefOpmerkingen().equals("")) {
                opmerkingen = "_";
            } else {
                opmerkingen = d.geefOpmerkingen();
            }
            result += d.geefNaam() + "\t" + d.geefTijdVan() + "\t" + d.geefTijdTot() + "\t" + opmerkingen + "\n";
        }
        return result;
    }
}
