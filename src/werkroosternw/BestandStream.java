/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * BestandStream beheert het openen, laden en wegschrijven van bestanden.
 *
 * @author Jonathan van der Steege (2020)
 */
public class BestandStream {

    private final ArrayList<Dienst> dienstenWeek = new ArrayList<>();
    private final ArrayList<Dienst> dienstenWeekend = new ArrayList<>();

    /**
     * Opent bij het maken van een instantie gelijk de benodigde bestanden.
     */
    public BestandStream() {
        try {
            openData();
        } catch (IOException e) {

        }
    }

    /**
     * Opent de bestanden met informatie over de diensten van de week en het
     * weekend. Plaatst deze gegevens in twee lijsten.
     *
     * @throws IOException
     */
    private void openData() throws IOException {
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("dienstenWeek.dat")));
            while (s.hasNext()) {
                String naam, tijdVan, tijdTot, opmerkingen;
                while (s.hasNext()) {
                    naam = s.next();
                    tijdVan = s.next();
                    if (tijdVan.length() == 4) {
                        tijdVan = " " + tijdVan;
                    }
                    tijdTot = s.next();
                    if (tijdTot.length() == 4) {
                        tijdTot = " " + tijdTot;
                    }
                    opmerkingen = s.nextLine().trim();
                    if (opmerkingen.contains("_")) {
                        opmerkingen = "";
                    }
                    dienstenWeek.add(new Dienst(naam, tijdVan, tijdTot, opmerkingen));
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        try {
            s = new Scanner(new BufferedReader(new FileReader("dienstenWeekend.dat")));
            while (s.hasNext()) {
                String naam, tijdVan, tijdTot, opmerkingen;
                while (s.hasNext()) {
                    naam = s.next();
                    tijdVan = s.next();
                    if (tijdVan.length() == 4) {
                        tijdVan = " " + tijdVan;
                    }
                    tijdTot = s.next();
                    if (tijdTot.length() == 4) {
                        tijdTot = " " + tijdTot;
                    }
                    opmerkingen = s.nextLine().trim();
                    if (opmerkingen.contains("_")) {
                        opmerkingen = "";
                    }
                    dienstenWeekend.add(new Dienst(naam, tijdVan, tijdTot, opmerkingen));
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    /**
     * Slaat de gegevens van de diensten van de week en het weekend op naar de
     * twee bestanden.
     *
     * @param dataWeek Gegevens van diensten in de week
     * @param dataWeekend Gegevens van diensten in het weekend
     * @throws IOException
     */
    public void saveData(String dataWeek, String dataWeekend) throws IOException {
        File bestandWeek = new File("dienstenWeek.dat");
        File bestandWeekend = new File("dienstenWeekend.dat");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(bestandWeek))) {
            out.write(dataWeek);
            out.close();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(bestandWeekend))) {
            out.write(dataWeekend);
            out.close();
        }
    }

    /**
     * Geeft de diensten in de week.
     *
     * @return Diensten in de week
     */
    public ArrayList inladenWeek() {
        return dienstenWeek;
    }

    /**
     * Geeft de diensten in het weekend.
     *
     * @return Diensten in het weekend
     */
    public ArrayList inladenWeekend() {
        return dienstenWeekend;
    }

}
