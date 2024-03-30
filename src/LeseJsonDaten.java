import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;


public class LeseJsonDaten {

	public static void main(String[] args) throws FileNotFoundException {
			
		zeichneTrennlinie(2);		
		JSONObject json = new JSONObject()
			    .put("nummer", 1)
			    .put("vorname", "Klaus")
			    .put("nachname", "Mustermann")
				.put("alter", 54)	
				.put("sprachen", "Deutsch");		
		System.out.println("Ausgabe eines JSON-Objekts:");
		System.out.println(json);
		zeichneTrennlinie(2);		
			
		try
		{
			// JSON-Datei einlesen
			String jsonDatei = "src/daten.json";
			String jsonDaten = new String(Files.readAllBytes(Paths.get(jsonDatei)));
			
			// JSON-Objekt erstellen		
			JSONObject jsonObj = new JSONObject(jsonDaten);
			
			// JSON-Inhalte verarbeiten
			String id = jsonObj.optString("id");
            String vorname = jsonObj.getString("vorname");
            String nachname = jsonObj.getString("nachname");
            String alter = jsonObj.optString("alter");
            String sprachen = jsonObj.getString("sprachen");
            
            int zeichenID = id.length();
            int zeichenVorname = vorname.length();
            int zeichenNachname = nachname.length();
            int zeichenAlter = 5;
            int zeichenSprachen = sprachen.length();

            
            System.out.println("Anzahl der Zeichen von ID: " + zeichenID + "\n");
            
            String formatierung = "| %-" + zeichenID + "s | %-" + zeichenVorname + "s | %-" + zeichenNachname + "s | %-" + zeichenAlter + "s | %-" + zeichenSprachen + "s |";
            
            // Declaring ANSI_RESET so that we can reset the color 
            final String ANSI_RESET = "\u001B[0m"; 
          
            // Declaring the color 
            // Custom declaration 
            final String ANSI_YELLOW = "\u001B[33m"; 
            
            System.out.println(ANSI_YELLOW + "Liste aller Personen" + ANSI_RESET);
            
            linieZeichnen(zeichenID, zeichenVorname, zeichenNachname, zeichenAlter, zeichenSprachen);    		
    		System.out.println(String.format(formatierung, "ID", "Vorname", "Nachname", "Alter", "Sprachen"));
    		linieZeichnen(zeichenID, zeichenVorname, zeichenNachname, zeichenAlter, zeichenSprachen);
    		System.out.println(String.format(formatierung, id, vorname, nachname, alter, sprachen));
    		linieZeichnen(zeichenID, zeichenVorname, zeichenNachname, zeichenAlter, zeichenSprachen);
    		System.out.println(String.format(formatierung, 4711, "Susi", "Sonnenschein", 18, "Englisch"));
    		linieZeichnen(zeichenID, zeichenVorname, zeichenNachname, zeichenAlter, zeichenSprachen);
    		System.out.println(String.format(formatierung, 1234, "Klaus", "Meier", 33, "Deutsch"));
    		linieZeichnen(zeichenID, zeichenVorname, zeichenNachname, zeichenAlter, zeichenSprachen);
    		  		
            
            
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void linieZeichnen(int zeichenID, int zeichenVorname, int zeichenNachme, int zeichenAlter, int zeichenSprachen)
	{
		String linie = "";
		String kreuz = "+";
		String strich = "-";
		
		linie  = kreuz + strich.repeat(zeichenID+2);
		linie += kreuz + strich.repeat(zeichenVorname+2);
		linie += kreuz + strich.repeat(zeichenNachme+2);
		linie += kreuz + strich.repeat(zeichenAlter+2);
		linie += kreuz + strich.repeat(zeichenSprachen+2);
		linie += kreuz;
		System.out.println(linie);
	}
	
	private static void zeichneTrennlinie(int anzahlLinien)
	{
		String zeichen = "-";
		int anzahlZeichen = 90;
		String linie = zeichen.repeat(anzahlZeichen);
				
		for (int i = 0; i < anzahlLinien; i++)
		{
			System.out.println(linie);
		}
	}	
}
