package beispiel1;

public class Scoutlist {
    public static void main(String[] args) {

        // TODO: Konstruktor für die Tool-Klasse erstellen, welcher Name+Gewicht entgegennimmt
        // Instanziierung der Tools
        Tool t1 = new Tool();
        t1.name = "Zwille";
        t1.weight = 0.5F;

        Tool t2 = new Tool();
        t2.name = "Axt";
        t2.weight = 2.7F;


        // Instanziierung der Scouts
        Scout s = new Scout("Fritz", (byte)22, 75.1F); // new - Erstellt Objekte der bestimmten Klasse
        s.tool = t2;

        Scout s2 = new Scout("Anna", (byte)23, 70.3F);
        s2.tool = t1;





        System.out.println(s.name); // Lesender Zugriff auf die Attribute
        s2.getTotalWeight();

        s.sagHallo();
        s2.sagHallo();
        s.getTotalWeight();
    }
}
