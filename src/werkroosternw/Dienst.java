/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

/**
 * Dienst beheert alle eigenschappen van een Dienst, zoals naam, tijden en
 * opmerkingen.
 *
 * @author Jonathan van der Steege (2020)
 */
public class Dienst {

    private final String naam;
    private final String tijdVan;
    private final String tijdTot;
    private final String opmerkingen;
    private final float uren;

    /**
     * Creatie van een dienst-object.
     *
     * @param naam Naam van de dienst
     * @param tijdVan Begintijd
     * @param tijdTot Eindtijd
     * @param opmerkingen Opmerkingen en bijzonderheden
     */
    public Dienst(String naam, String tijdVan, String tijdTot, String opmerkingen, float uren) {
        this.naam = naam;
        this.tijdVan = tijdVan;
        this.tijdTot = tijdTot;
        this.opmerkingen = opmerkingen;
	this.uren = uren;
    }

    public String geefNaam() {
        return naam;
    }

    public String geefTijdVan() {
        return tijdVan;
    }

    public String geefTijdTot() {
        return tijdTot;
    }

    public String geefOpmerkingen() {
        return opmerkingen;
    }

    public float geefUren() {
	return uren;
    }

    /**
     * Geeft alle items van de dienst.
     *
     * @return Alle items
     */
    public String geefTotaal() {
        return geefNaam() + "\t " + geefTijdVan() + " - " + geefTijdTot() + "\t " + geefUren() + "\t " + geefOpmerkingen();
    }
}
