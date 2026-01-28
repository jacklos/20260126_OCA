import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        final String OPTION = "---------\n" +
                "New: Erstellt eine neue Todo\n" +
                "List: Zeigt alle Todos an\n" +
                "Delete: Löscht eine Todo\n" +
                "Exit: Beendet das Programm\n" +
                "---------";

        ArrayList<Todo> todolist = new ArrayList<>(); // Dynamische Liste
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

        boolean exit = false;
        LOOP:while(!exit) {
            System.out.println(OPTION);
            String input = sc.nextLine().toLowerCase();
            switch (input) {
                case "new":
                    System.out.println("Was soll erledigt werden?");
                    String todoText = sc.nextLine();
                    //if(todoText.isEmpty()) {
                    //    continue LOOP;
                    //}
                    Todo todo = new Todo(todoText);
                    todolist.add(todo);
                    System.out.println("Todo("+todoText+") erstellt!");
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
                case "delete":
                    System.out.println("Welche Todo möchten Sie löschen?(Index)");
                    int index = Integer.parseInt(sc.nextLine()); // parseInt() wandelt einen String in int um
                    Todo t = todolist.remove(index);
                    System.out.println("Todo("+t.text+") wurde gelöscht");
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




}





/*
        System.out.println("Willkommen, wie heißen Sie?");
        String input = sc.nextLine();

        System.out.println("Hallo, "+input+'!');

        System.out.println("Wie alt sind Sie?");
        int alter = Integer.parseInt(sc.nextLine()); // Michis bevorzugte Art um Zahleneingaben einzufangen
*/