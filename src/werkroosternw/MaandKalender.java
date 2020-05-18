/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

import java.time.*;
import java.util.ArrayList;

/**
 * MaandKalender beheert een kalender van een gekozen maand.
 * @author Jonathan van der Steege (2020)
 */
public class MaandKalender {

    private final LocalDate datum;
    private final ArrayList<LocalDate> maand = new ArrayList<>();

    public MaandKalender(LocalDate datum) {
        this.datum = datum;
        vulKalender();
    }

    /**
     * Vult de arraylist maand met dagen. De items zijn in LocalDate.
     */
    private void vulKalender() {
        int lengteMaand = datum.lengthOfMonth();
        for (int i = 0; i < lengteMaand; i++) {
            maand.add(datum.plusDays(i));
        }
    }

    /**
     * Geeft de lijst met items van de maand.
     *
     * @return Maand
     */
    public ArrayList geefMaand() {
        return maand;
    }

    /**
     * Geeft van de gekozen datum de dag van de week.
     *
     * @param datum Gekozen datum
     * @return Dag van de week
     */
    public DayOfWeek getDag(LocalDate datum) {
        return datum.getDayOfWeek();
    }

    /**
     * Geeft van gekozen dag weer of het weekend is.
     *
     * @param dag Gekozen dag
     * @return True als de dag in het weekend is
     */
    public boolean isWeekend(int dag) {
        return !(maand.get(dag).getDayOfWeek() != DayOfWeek.SATURDAY && maand.get(dag).getDayOfWeek() != DayOfWeek.SUNDAY);
    }

    /**
     * Geeft het totaal van de maanditems (aantal dagen).
     *
     * @return Aantal dagen van de maand
     */
    public int getSize() {
        return maand.size();
    }

    /**
     * Geeft de dag van de week.
     *
     * @param dag Gekozen dag
     * @return Naam van de dag
     */
    public String getDag(int dag) {
        return "" + maand.get(dag).getDayOfWeek();
    }

    /**
     * Geeft de maand en het jaar van de kalender.
     *
     * @return Naam van de maand en het jaar
     */
    public String geefMaandJaar() {
        return "" + datum.getMonth() + " " + datum.getYear();
    }

    /**
     * Geeft de eerste weekdag van de maand
     * @return Eerste dag van de maand (0=maandag ... 6=zondag)
     */
    public int eersteDagMaand() {
        if (datum.getDayOfWeek() == DayOfWeek.MONDAY) {
            return 0;
        } else if (datum.getDayOfWeek() == DayOfWeek.TUESDAY) {
            return 1;
        }else if (datum.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            return 2;
        }else if (datum.getDayOfWeek() == DayOfWeek.THURSDAY) {
            return 3;
        }else if (datum.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return 4;
        }else if (datum.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return 5;
        } else
            return 6;
    }
}
