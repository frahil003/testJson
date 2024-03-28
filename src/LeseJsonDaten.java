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
		String formatierung = "%-35s %s %s";
		String trennZeichen = ":";
		
		String dateiMitJsonDaten = "src/daten.json";	
		
		File datei = new File(dateiMitJsonDaten);
		System.out.println(String.format(formatierung, "<1> Erzeugt mit File", trennZeichen, datei));
		System.out.println(String.format(formatierung, "<2> Erzeugt mit .getName()", trennZeichen, datei.getName()));
		System.out.println(String.format(formatierung, "<3> Erzeugt mit .getAbsolutePath()", trennZeichen, datei.getAbsolutePath()));
		System.out.println(String.format(formatierung, "<4> Erzeugt mit .getcanRead()", trennZeichen, datei.canRead()));
		System.out.println(String.format(formatierung, "<5> Erzeugt mit .length()", trennZeichen, datei.length()));
		zeichneTrennlinie();
		
		FileInputStream fis = new FileInputStream(datei);		
		System.out.println(String.format(formatierung, "<6> Erzeugt mit FileInputStream", trennZeichen, fis));
		zeichneTrennlinie();

		Scanner scan = new Scanner(fis);		
		System.out.println(String.format(formatierung, "<7> Erzeugt mit Scanner", trennZeichen,  scan.toString()));
		zeichneTrennlinie();
		scan.close();
		
//		JSONObject jo = new JSONObject(datei);
//		System.out.println(String.format(formatierung, "<8> Erzeugt mit JSONObject", trennZeichen, jo.getInt("id")));
//		zeichneTrennlinie();
//		
		InputStream is = new FileInputStream(dateiMitJsonDaten);
		JSONObject objekt = new JSONObject(is);
		System.out.println(String.format(formatierung, "<8> Erzeugt mit JSONObject", trennZeichen, objekt));
		Person person = new Person();
				
		//person.setVorname(objekt.getString("vorname"));
		
		zeichneTrennlinie();
		
		JSONObject json = new JSONObject()
			    .put("nummer", 1)
			    .put("vorname", "Klaus")
			    .put("nachname", "Mustermann")
				.put("alter", 54);
		
		System.out.println("<9> " + json);
		zeichneTrennlinie();

		
		String wert = json.optString("nummer"); // -> "1"
		System.out.println("Wert von nummer: " + wert);	
		
		
		
		
		try
		{
			// JSON-Datei einlesen
			String jsonDaten = new String(Files.readAllBytes(Paths.get(dateiMitJsonDaten)));
			JSONObject jsonObj = new JSONObject(jsonDaten);
			
			// JSON-Inhalte verarbeiten
            String vorname = jsonObj.getString("vorname");
            String nachname = jsonObj.getString("nachname");
            int alter = jsonObj.getInt("alter");
            System.out.println(vorname + " " + nachname + " ist morgen " + alter + " Jahr alt!");
            
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// JSON-Objekt erstellen
		
		
		
		
	}
	
	private static void zeichneTrennlinie()
	{
		String zeichen = "-";
		int anzahl = 100;
		System.out.println(zeichen.repeat(anzahl));
	}	
	
	
}
