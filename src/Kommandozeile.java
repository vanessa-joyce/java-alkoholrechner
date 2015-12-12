import java.util.Scanner;
public class Kommandozeile {
	private AlkTest tester = new AlkTest();
	private void commandLine() {
		String cmdInput = "";
		Scanner keyScan = new Scanner(System.in);
		while (!cmdInput.equals("exit")) {
			System.out.print("\nCMD> ");
			cmdInput = keyScan.nextLine();
			if (cmdInput.equals("drink")) {
				System.out.print("Bier (0), Wein (1), Likör (2), Schnaps (3)>");
				int drinkId = keyScan.nextInt();
				tester.addKonsum(drinkId);
				cmdInput = keyScan.nextLine();
			} else if (cmdInput.equals("config")) {
				System.out.print("Frau (f) oder Mann (m)>");
				String geschlecht = keyScan.nextLine();
				System.out.print("Gewicht>");
				double weight = keyScan.nextDouble();
				boolean isFemale = false;
				if (geschlecht.equals("f")) {
					isFemale = true;
				}
				else {
					isFemale = false;
				}
				tester.setPerson(weight, isFemale);
				cmdInput = keyScan.nextLine();
			} else if (cmdInput.equals("test")) {
				if (tester.hasPerson() == false) {
					System.out.print("Bitte zuerst Angaben zur Person erfassen (config)");
				}
				else {
					System.out.print("Alkoholwert von " + tester.getCurrentLevel());
				}
				cmdInput = keyScan.nextLine();
			} else if (cmdInput.equals("print")) {
				tester.printPerson();
				tester.printAll();
				cmdInput = keyScan.nextLine();
			}
		}
	}
	public static void main(String[] args) {
	Kommandozeile at = new Kommandozeile();
	at.commandLine();
	}
}