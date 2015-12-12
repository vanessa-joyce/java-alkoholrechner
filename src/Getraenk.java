
public class Getraenk {
	private long drinkTime;
	public int amountMilli;
	public double alcLevel;
	public String name;
	
	public Getraenk() {
		this.drinkTime = System.currentTimeMillis();
	}
	
	public long getTimeMilli() {
		return this.drinkTime;
	}
	
	public long getDiffSecond() {
		return (System.currentTimeMillis() - this.drinkTime)/1000;
	}
	
	public double getAlcTotal() {
		return this.amountMilli * this.alcLevel * 0.8;
	}
	
	public void print() {
		System.out.println("Getränk: " + this.name);
		System.out.println("Konsum vor " + this.getDiffSecond() + " Sekunden");
		System.out.println("Menge: " + this.amountMilli + " Milliliter");
		System.out.println("Gehalt: " + this.alcLevel + "\n");
	}
	
}
