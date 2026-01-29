import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    final static String OPTION = "---------\n" +
            "New: Erstellt eine neue Todo\n" +
            "List: Zeigt alle Todos an\n" +
            "Check: Markiert die Todos als erledigt\n"+
            "Delete: Löscht eine Todo\n" +
            "Exit: Beendet das Programm\n" +
            "---------";

    static ArrayList<Todo> todolist = new ArrayList<>(); // Dynamische Liste

    // File ist eine Klasse aus dem io-Package und steht für einen Pfad
    static File file = new File("data\\todos.txt");

    // Aus einem statischen Kontext dürfen wir nur auf statische Variablen/Attribute/Methoden zugreifen
    // dh. in der Main-Methode(Die statisch ist) dürfen wir nur auf statische attribute zugreifen
    public static void main(String[] args) {
        readFromFile(); // Liest zu Anfang alles aus der todos.txt

        // Switch - Für Fallunterscheidungen
        // Eignet sich, wenn wir nur eine Variable haben und deren Wert überprüfen wollen

        // Die Cases dürfen nicht öfter vorkommen - Labels müssen Unique sein
        // breaks dürfen weggelassen werden - dann werden alle Cases bis zum nächsten Break abgearbeitet
        // default: wird aktiv falls sich kein anderer Fall angesprochen fühlt
        // Erlaubte Datentypen fürs Switch: byte, short, int, char, Byte, Short, Integer, Character, String, Enum
        //  Nicht erlaubte Datentypen: float, double, boolean, long,Scout und weitere Objekte
        // Variablen als Labels sind erlaubt, allerdings nur wenn sie final(Konstanten) sind

        // TODO: Check-Funktionalität einbauen
        // Die User können auswählen, welche Todo als 'erledigt' markiert wird (checked = true)
        // TODO: Kommentiert so viel wie möglich mit eigenen Worten - Was macht die Zeile/Wieso ist sie wichtig?


        boolean exit = false;
        LOOP:while(!exit) {
            System.out.println(OPTION);
            String input = sc.nextLine().toLowerCase();
            switch (input) {
                case "new":
                    System.out.println("Was soll erledigt werden?");
                    String todoText = sc.nextLine();
                    Todo todo = new Todo(todoText);
                    todolist.add(todo);
                    System.out.println("Todo("+todoText+") erstellt!");
                    saveToFile();
                    break;
                case "list":
                    // enhanced for-loop / foreach
                    // Durchläuft die Liste todoList und stopft nacheinander jedes
                    // Element in die Variable t
                    int i = 0;
                    for(Todo t:todolist) {
                        System.out.println(i+++": "+ t.toString());
                    }
                    break;
                case "check": {
                    try {
                        System.out.println("Welche Todo soll als erledigt markiert werden?(Index)");
                        int index = Integer.parseInt(sc.nextLine()); // parseInt() wandelt einen String in int um
                        Todo zuBearbeitendeTodo = todolist.get(index);
                        zuBearbeitendeTodo.checked = !zuBearbeitendeTodo.checked; // Toggle
                    } catch(Exception e) { // wird bei jeder Exception aktiv, die im Try-Block geworfen wird
                        System.out.println("Hier ist etwas schiefgegangen!");
                    } finally {
                        // finally wird immer ausgeführt - wird oft zum schließen von Resourcen verwendet
                    }
                    }
                    break;
                case "delete":
                    try {
                        System.out.println("Welche Todo möchten Sie löschen?(Index)");
                        int index = Integer.parseInt(sc.nextLine()); // parseInt() wandelt einen String in int um
                        Todo t = todolist.remove(index);
                        System.out.println("Todo("+t.text+") wurde gelöscht");
                    } catch(NumberFormatException e) {
                        System.out.println("Das ist keine Zahl gewesen! GEBEN SIE NUR ZAHLEN ZWISCHEN 0-"+(todolist.size()-1)+" EIN!");
                    } catch(IndexOutOfBoundsException e) {
                        System.out.println("Diese Zahl ist nicht im Wertebereich! GEBEN SIE NUR ZAHLEN ZWISCHEN 0-"+(todolist.size()-1)+" EIN!");
                    }
                    // code
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Ciao!");
                    // code
                    break;
                default:
                    System.out.println("Das ist kein Befehl!");
                    break;
            }

        }

    }

    public static void saveToFile() {

        try {
            if(!file.exists()) {
                file.createNewFile();// Diese Methode könnte eine IOException werfen -> Problem weil: Pfad nicht richtig, oder keine Rechte
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(todolist);

        } catch(IOException e) {
            System.out.println("Problem");
            e.printStackTrace();
        }  // Try-With-Resources
    }
    public static void readFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            todolist = (ArrayList<Todo>)in.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }








}





/*
        System.out.println("Willkommen, wie heißen Sie?");
        String input = sc.nextLine();

        System.out.println("Hallo, "+input+'!');

        System.out.println("Wie alt sind Sie?");
        int alter = Integer.parseInt(sc.nextLine()); // Michis bevorzugte Art um Zahleneingaben einzufangen
*/