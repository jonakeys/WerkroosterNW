/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package werkroosternw;

import java.io.*;
import java.util.Scanner;

/**
 *
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
    
    public boolean isBestandGeladen() {
        return scanner != null;
    }

    public boolean hasNext() {
        return (volgende != null);
    }

    public String volgende() {
        String huidige = volgende;
        volgende = (scanner.hasNext() ? scanner.next() : null);
        return huidige;
    }

    public String volgendeLijn() {
        String huidige = volgende;
        volgende = (scanner.hasNext() ? scanner.nextLine() : null);
        return huidige;
    }

    public String gluur() {
        return volgende;
    }

    public void close() {
        scanner.close();
    }
}
