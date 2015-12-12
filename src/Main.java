public class Main {
 public static void main(String[] args) {
 AlkTest tester = new AlkTest();
 tester.setPerson(80, false);
 tester.addKonsum(0);
 tester.addKonsum(2);

 // wait 2 seconds
 try {
 Thread.sleep(2000);
 } catch (Exception e) {
 System.out.println("Fehler");
 }

 tester.addKonsum(1);
 tester.addKonsum(3);
 tester.printAll();
 }
}