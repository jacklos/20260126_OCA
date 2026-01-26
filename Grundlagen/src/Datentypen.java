public class Datentypen {


    public static void main(String[] args) {
        System.out.println("Start...");

        // Ganzzahlen
        byte b = 127; // 8-Bit | Bereich von -128 bis 127
        short s = 10_000; // 16-Bit | Bereich: -32.768 bis +32.767
        int i = -900_000;// 32-Bit | ca -2mrd bis +2mrd
        long l = 123L;// 64-Bit | bereich: -9.223.372.036.854.775.808 bis 9.223.372.036.854.775.807

        // Kein Problem in Java: einen kleineren Datentypen in einen Größeren Umwandeln
        byte b2 = 5;
        short s2 = b2;



        // Fließkommazahlen
        float f = 3.1412345677688876654323F;  // 32-Bit // ca. 7 Stellen
        double d = 3.14; // 64-Bit // ca. 15 Stellen


        // Boolean
        boolean bool = false;

        // Zeichen und Zeichenketten
        char buchstabe = 'A'; // 16-Bit
        System.out.println(buchstabe);

        // Strings sind keine primitiven Datentypen
        // Sie sind Objekte und gehören damit zu den Referenztypen
        String str1 = new String("Irgendeinen Wert");
        String zeichenkette = "Hallo Welt";










    }
}
