package app;

import classes.Pakli;
import java.util.Scanner;

public class Trukk {

    static Scanner sc = new Scanner(System.in);

    //Közös
    public static void main(String[] args) {
        Pakli pakli = new Pakli();

        System.out.println("Gondolj egy kártyára 21-ből!\n");

        for (int i = 0; i < 3; i++) {
            pakli.megjelenit();
            int valasztottOszlop = valaszt();
            pakli.keveres(valasztottOszlop);
            System.out.println();
        }

        System.out.println("A gondolt lapod nem más, mint a: " + pakli.GetLap(11));
    }

    private static int valaszt() {
        System.out.print("Melyik oszlopban van a gondolt lap? (1, 2, 3 ): ");

        return sc.nextInt();
    }
}
