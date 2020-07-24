/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

import java.io.*;
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
        try {
            GluurScanner gs = new GluurScanner("diensten.dat");
            boolean isWeek = true;
            if (gs.isBestandGeladen()) {
                while (gs.hasNext()) {
                    String naam, tijdVan, tijdTot, uren, opmerkingen;
                                        if (gs.gluur().equals("[week]")) {
                        gs.volgende();
                    } else if (gs.gluur().equals("[weekend]")) {
                        isWeek = false;
                        gs.volgende();
                    }
                    naam = gs.volgende();
                    tijdVan = gs.volgende();
                    if (tijdVan.length() == 4) {
                        tijdVan = " " + tijdVan;
                    }
                    tijdTot = gs.volgende();
                    if (tijdTot.length() == 4) {
                        tijdTot = " " + tijdTot;
                    }
                    uren = gs.volgendeRegel();
                    double dUren = Double.parseDouble(uren);
                    opmerkingen = gs.volgende();
                    if (opmerkingen.contains("_")) {
                        opmerkingen = "";
                    }
                    if (isWeek) {
                        dienstenWeek.add(new Dienst(naam, tijdVan, tijdTot, dUren, opmerkingen));
                    } else {
                        dienstenWeekend.add(new Dienst(naam, tijdVan, tijdTot, dUren, opmerkingen));
                    }
                }
                gs.close();
            }
        } catch (IOException e) {

        }

        /*
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
         */
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
        File bestand = new File("diensten.dat");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(bestand))) {
            String data = "[week]\n" + dataWeek + "[weekend]\n" + dataWeekend ;
            out.write(data);
            out.close();
        }
    }
    
        /**
     * Schrijf de informatie van dagen van de maand met bijbehorend de dienst,
     * werktijden en opmerkingen naar een bestand.
     *
     * @param bestandsnaam Naam van het bestand
     * @param tekst Tekst die moet worden weggeschreven
     * @throws IOException Mocht er een fout optreden, wordt deze afgevangen
     */
    public void schrijfBestand(String bestandsnaam, String tekst)
            throws IOException {
        File bestand = new File(bestandsnaam);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(bestand))) {
            out.write(tekst);
            out.close();
        }
    }
    
    /**
     * Check of bestand bestaat.
     * @param bestandsnaam naam van te checken bestand
     * @return true als bestand al bestaat
     */
    public boolean bestandBestaat(String bestandsnaam) {
        File bestand = new File(bestandsnaam);
        return bestand.exists();
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
