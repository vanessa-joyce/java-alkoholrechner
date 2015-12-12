
public class Person {
	private boolean isFemale;
	private double weight;
	
	public Person(double weight, boolean isFemale) {
		this.weight = weight;
		this.isFemale = isFemale;
	}
	
	public double getDistribution() {
		if (this.isFemale == true) {
			return this.weight * 0.6;
		}
		else {
			return this.weight * 0.7;
		}
	}
	
	public void print() {
		String gender;
		if (this.isFemale == true) {
			gender = "Frau";
		}
		else {
			gender = "Mann";
		}
		System.out.println("Geschlecht: " + gender);
		System.out.println("Gewicht: " + this.weight);
		System.out.println("Reduktion: " + this.getDistribution());
	}
	
}
