/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

import java.io.*;
import java.util.Scanner;

/**
 * Scanner that can peek forward.
 * @author Jonathan van der Steege (2020)
 */
public class GluurScanner {

    private Scanner scanner = null;
    private String volgende;

    public GluurScanner(String source) throws IOException {
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(source)));
            volgende = (scanner.hasNext() ? scanner.next() : null);
        } catch (IOException e) {
            
        }
    }
    
    /**
     * Check of bestand is geladen.
     * @return true als bestand is geladen
     */
    public boolean isBestandGeladen() {
        return scanner != null;
    }

    /**
     * Check of er een volgend item is.
     * @return true als er een volgend item is
     */
    public boolean hasNext() {
        return (volgende != null);
    }

    /**
     * Geef het volgende item.
     * @return volgende item
     */
    public String volgende() {
        String huidige = volgende;
        volgende = (scanner.hasNext() ? scanner.next() : null);
        return huidige;
    }

    /**
     * Geef het volgende item tot einde van de regel.
     * @return volgende item tot einde van de regel
     */
    public String volgendeRegel() {
        String huidige = volgende;
        volgende = (scanner.hasNext() ? scanner.nextLine() : null);
        return huidige;
    }

    /**
     * Kijk een volgend item vooruit, zonder de scanner te verplaatsen.
     * @return volgend item (om te bekijken)
     */
    public String gluur() {
        return volgende;
    }

    /**
     * Sluit de scanner.
     */
    public void close() {
        scanner.close();
    }
}
