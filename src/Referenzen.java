// Pro Datei ist nur 1 public Klasse erlaubt
// Die Datei heißt immer wie die public Klasse
public class Referenzen {

    public static void main(String[] args) {

        Auto a1 = new Auto("Opel", 120, "Rot");
        Auto a2 = a1;

        Auto a3 = new Auto("Ford", 80, "Gelb");
        Auto a4 = new Auto("Ford", 60, "Blau");
        Auto a5 = new Auto("Ford", 150, "Grün");

        for(int i = 0; i < 100; i++) {
            Auto a = new Auto("Ford", 150, "Grün");
            System.gc(); // Der Aufruf dieser Methode ist nur eine Empfehlung an die JVM, den GC loszuschicken
        }

        System.out.println("Es wurden "+Auto.count+" Autos produziert");
        System.out.println("davon wurden "+Auto.geloeschteAutos+" Autos gelöscht");

        a2.farbe = "Grün";
        System.out.println(a2.farbe); // Grün
        System.out.println(a1.farbe); // Grün

        // Sobald keine Variable mehr auf das Objekt zeigt
        // steht es dem GC zur Verfügung
        a1 = null;
        a2 = null;


    }
}

class Auto {
    static public int count; // 0
    static public int geloeschteAutos;
    public String marke;
    public int ps;
    public String farbe;

    public Auto(String marke, int ps, String farbe) {
        count++;
        this.marke = marke;
        this.ps = ps;
        this.farbe = farbe;
    }
    public Auto() {} // Standard Konstruktor

    // diese Methode wird aktiv, wenn das Objekt aus dem Speicher befreit wird
    // Die finalize-Methode ist in neueren Java versionen deprecated(veraltet) und sollte nicht mehr produktiv genutzt werden

    public void finalize() {
        geloeschteAutos++;
        System.out.println("Objekt aus dem Speicher gelöscht!");
    }
}
