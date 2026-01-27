import java.util.Random;

public class Fighter{

    String name;
    int str; // Stärke
    int dex; // Geschick
    int hp = 100; // Healthpoints


    /**
     * Dieser Konstruktor erwartet den Namen als Parameter, übernimmt diesen
     * und würfelt die Attribute.
     * @param name String - Name des Kämpfers
     */
    public Fighter(String name) {

        this.name = name;
        initStats();
        System.out.println("Fighter wurde erstellt!");
    }

    // Überladen: Definition einer weiteren Methode mit gleichem Namen in der selben Klasse
    // uns stehen jetzt 2 Konstruktoren zur verfügung: new Fighter("name") und new Fighter();
    public Fighter() {
                        //    0             1               2           3            4
        String[] names = {"Shredder", "Master Blaster", "Skeletor", "Lex Luther", "Joker"};
        Random rand = new Random();
        this.name = names[rand.nextInt(5)];
        initStats();
        System.out.println("Fighter wurde erstellt!");
    }

    public void initStats() {
        Random rand = new Random();
        this.str = rand.nextInt(16);
        this.dex = rand.nextInt(16);
    }


    /**
     * Berechnet den Schadenswert anhand Stärke und bisschen Zufall
     * @return int - Der Schadenswert
     */
    public int calcDmg() {
        Random rand = new Random();
        int dmg = str * 2 + rand.nextInt(11);
        //System.out.println("Schaden: "+dmg);
        return dmg; // Es gibt den Wert beim Aufruf zurück
    }

    /**
     * Nimmt den Schaden entgegen und berechnet diesen in der HP
     * @param dmg int - der zu fressende Schaden
     */
    public void takeDmg(int dmg){
        this.hp = this.hp-dmg;
        //this.hp -= dmg;
    }

    /**
     * Methode zum Ausweichen (Dex+Zufall)
     * @return boolean - ob man ausweicht oder nicht
     */
    public boolean evade() {
        return new Random().nextInt(100)+dex >= 75;
        /*
        Random rand = new Random();
        if(rand.nextInt(100)+dex >= 75) {
            // Auswichen geklingt!
            return true;
        }  else {
            // Ausweichen geklingt nicht!
            return false;
        }
         */
    }

    /**
     * Simmuliert einen Schlag - ruft intern calcDmg(), takeDmg(), evade() auf
     * @param opponent Fighter - der zu schlagende Gegner
     */
    public void punch(Fighter opponent) {
        if(opponent.evade() == true) {
            System.out.println(opponent.name + " ist Ausgewichen!");
        } else {
            int dmg = this.calcDmg();
            opponent.takeDmg(dmg);
            System.out.println(opponent.name+" wurde getroffen!("+dmg+" Schaden | hp übrig: "+opponent.hp+")");
            // this referenziert auf das Fighter-Objekt, welches punch() aufgerufen hat
        }
    }

    // die toString()-Methode wird bei einem println automatisch aufgerufen
    // in den meisten Fällen wird sie dazu verwendet um die Attribute der Objekte anzuzeigen
    // Überschreibt die Methode der Elternklasse(Object)
    @Override
    public String toString() {
        return "Fighter{" +
                "name='" + name + '\'' +
                ", str=" + str +
                ", dex=" + dex +
                ", hp=" + hp +
                '}';
    }

}
