import java.util.Arrays;
import java.util.Scanner;

public class einfachesExceptionHandling {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        String[] namen = {"Hans", "Martha", "Frida", "Otto"};
        System.out.println(namen); // Gibt den Hashcode aus, da Array ein Objekt ist und die toString()-Methode nicht überschrieben hat
        System.out.println(Arrays.toString(namen)); // Gibt alle Werte des Arrays als String zurück
        Arrays.sort(namen); // Sortiert das Array
        System.out.println(Arrays.toString(namen));

        System.out.println("Geben Sie bitte einen Index an");
        try {
            // Das try versucht die Anweisungen im Block abzuarbeiten
            // wirft jedoch eine der Anweisungen eine Exception, wird der Try-Block sofort abgebrochen
            // und wir landen im entsprechenden Catch(jenachdem welche Exception geworfen wurde)
            byte index = Byte.parseByte(sc.nextLine()); // Kann eine NumberFormatException werfen
            System.out.println(namen[index]); // ArrayIndexOutOfBoundsException
            System.out.println(10/index); // ArithmeticException
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Geben Sie nur Indizies im Wertebereich ein!");
        } catch(NumberFormatException e) {
            System.out.println("Geben Sie NUR Zahlen ein!");
        } catch(Exception e) {
            System.out.println("Ein anderes Problem ist aufgetaucht!");
        }


        System.out.println("... Weiter");



    }
}
