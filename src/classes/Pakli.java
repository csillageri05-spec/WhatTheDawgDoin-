package classes;

import classes.Ertek;

public class Pakli {
//Gergő

    private Lap[] lapok = new Lap[22];

    public Pakli() {
        Szin[] szinek = {Szin.PIROS, Szin.TOK, Szin.MAKK, Szin.ZOLD};
        Ertek[] ertekek = {Ertek.VIII, Ertek.IX, Ertek.X, Ertek.felso, Ertek.kiraly, Ertek.asz};
        int db = 0;
        for (Szin szin : szinek) {
            for (Ertek ertek : ertekek) {
                if (db < 21) {
                    Lap lap = new Lap(ertek, szin);
                    this.lapok[++db] = lap;
                }
            }
        }

    }

    public void megjelenit() {
        String output = "";

        for (int i = 1; i < lapok.length; i++) {
            String ertek = lapok[i].getErtek().toString();
            String szin = lapok[i].getSzin().toString();

            // A %-18s fix, 18 karakter széles oszlopot hoz létre balra igazítva
            String formazottLap = String.format("%-18s", ertek + " " + szin);

            if (i % 3 == 0) {
                output += formazottLap + "\n";
            } else {
                output += formazottLap + " | ";
            }
        }
        System.out.println(output);
    }

}
