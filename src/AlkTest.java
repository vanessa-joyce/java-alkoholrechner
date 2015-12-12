import java.util.ArrayList;

public class AlkTest {
	private Person person;
	private ArrayList<Getraenk> konsum = new ArrayList<Getraenk>();
	
	public void setPerson(double weight, boolean isFemale) {
		this.person = new Person(weight, isFemale);
	}
	
	public boolean hasPerson() {
		if(this.person == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void printPerson() {
		this.person.print();
	}
	
	
	
	public void addKonsum(int drink) {
		Getraenk getraenk = null;
		switch (drink) {
		case 0: getraenk = new Bier();
		break;
		case 1: getraenk = new Wein();
		break;
		case 2: getraenk = new Likoer();
		break;
		case 3: getraenk = new Schnaps();
		break;
		}
		//System.out.println(getraenk);
		konsum.add(getraenk);
	}
	
	public void printAll() {
		for (Getraenk getraenk : konsum) {
			getraenk.print();
		}
	}
}
