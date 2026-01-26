package beispiel1;


// Eine Klasse ist eine Blaupause,
// wie die späteren Objekte auszusehen haben.

public class Scout {

    // Attribute:
    // jedes Objekt der Klasse Scout wird diese Attribute besitzen
    String name;
    byte age;
    float weight;
    Tool tool;

    // Konstruktoren heißen wie die Klasse
    // und haben keinen Rückgabetypen
    // Wird oft zum befüllen der Attribute benutzt
    public Scout(String name, byte age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void sagHallo() {
        System.out.println("Hallo! Ich bin "+ name);
    }

    public void getTotalWeight() {
        float totalWeight = weight + tool.weight;
        System.out.println("Zusammen mit allem drum und dran wiege ich: "+totalWeight+"Kg");
    }
}
