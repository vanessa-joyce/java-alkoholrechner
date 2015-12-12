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
	
	public double getCurrentLevel() {
		double currentLevel = 0;
		for (Getraenk getraenk : konsum) {
			double levelOfNewDrink = (getraenk.getAlcTotal() / this.person.getDistribution());
			// If not first drink, reduce currentLevel in relation to time passed
			if (konsum.indexOf(getraenk) > 0) {
				long secondsSinceLastDrink = getraenk.getTimeMilli() - konsum.get(konsum.indexOf(getraenk)-1).getTimeMilli();
				currentLevel -= ((secondsSinceLastDrink/3600) * 0.15);
			}
			currentLevel += levelOfNewDrink;
			System.out.print(currentLevel);
			// If last drink, calculate time difference between drink and now
			if (konsum.size() == konsum.indexOf(getraenk)-1) {
				currentLevel -= ((getraenk.getDiffSecond()/3600)* 0.15);
			}
			if (currentLevel < 0) {
				currentLevel = 0;
			}
		}
		return currentLevel;
	}
	
	public void printAll() {
		for (Getraenk getraenk : konsum) {
			getraenk.print();
		}
	}
}
