import java.sql.SQLOutput;

public class Operatoren {

    public static void main(String[] args) {


        // Operatoren

        // Binäre Operaten - Operatoren die mit 2 Operanden arbeiten
            // Atrithmetic Operators
        System.out.println(4+6); //10
        System.out.println(4*2); //8
        System.out.println(22%7);//1

        int i = 5;

        int age = 22;
        boolean ticket = true;
        if(age >= 18 && ticket == true) { // Relationale und Logische Operatoren
            System.out.println("Rambo im Kino");
        }

        String str = "Hallo Welt";
        System.out.println(str instanceof String);
        System.out.println("------");

        // Unäre Operatoren - Operatoren mit nur EINEM Operanden
        System.out.println(!true);
        int i2 = -5;
        i2++; // postfix increment
        i2--;
        ++i2; // prefix increment
        --i2;


        System.out.println(i2); // -4


        int i3 = 5;       //5  +    7   7    + 8                      // 15 // 21 // 27
        System.out.println(i++ + ++i + i++ + i);

        System.out.println(false);

        // Ternären Operator // Arbeitet mit 3 Operanden - gilt als Kurzschreibweise für ifs

        int age2 = 22;
        String film;
        if(age >= 18) { // Relationale und Logische Operatoren
             film = "Rambo";
        } else if (age >= 13) {
            film = "Irgendein Teeniefilm";
        } else {
             film = "Spongebob";
        }
        System.out.println(film);
                                //   true        false
        String film2 = (age >= 18) ? "Rambo": "Spongebob";

        // Ternärer Operator mit else-if:
        // String film2 = (age >= 18) ? "Rambo": (age >= 13) ? "Irgendein Teeniefilm": "Spongebob";


    }
}
