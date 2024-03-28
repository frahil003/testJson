import java.util.Arrays;

public class Person {
	
	private int id;
	private String vorname;
	private String nachname;
	private String[] sprachen;
	
	public Person() {
		// Do something
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String[] getSprachen() {
		return sprachen;
	}

	public void setSprachen(String[] sprachen) {
		this.sprachen = sprachen;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", sprachen="
				+ Arrays.toString(sprachen) + "]";
	}
	
	
	

}
