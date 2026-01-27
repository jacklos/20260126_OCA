import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Art 1: Math.random():double
        //System.out.println(Math.floor(Math.random() * 10)); // 0(inklusive) bis 1(exklusive)


        // Art 2: Random Objekt
        //Random rand = new Random();
        //int i = rand.nextInt(16);
        //System.out.println(i);



        Fighter f1 = new Fighter();
        Fighter f2 = new Fighter();

        System.out.println(f1); // toString()
        System.out.println(f2);


        while(f1.hp > 0 && f2.hp > 0 ) {
            f1.punch(f2);
            if(f2.hp > 0) {
                f2.punch(f1);
            }
        }

        // TODO: Gewinner ermitteln
        // TODO: Ermöglichen dass die Fighter Werkzeug(Waffen) tragen und nutzen können

        System.out.println(f1);
        System.out.println(f2);
    }
}


