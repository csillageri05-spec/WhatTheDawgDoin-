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

    public String GetLap(int i) {
        String ertek = lapok[i].getErtek().toString();
        String szin = lapok[i].getSzin().toString();
        return ertek + " | " + szin;
    }

    public void megjelenit() {
        String output = "";
        int oszlopSzelesseg = 20;
        int sorokSzama = 7;
        int oszlopokSzama = 3;

        for (int sor = 1; sor <= sorokSzama; sor++) {

            for (int oszlop = 0; oszlop < oszlopokSzama; oszlop++) {

                // Kiszámoljuk, hogy a tömbben hányas indexű kártya jön ide
                // (pl. 1. sor: 1, 8, 15; 2. sor: 2, 9, 16 stb.)
                int i = sor + (oszlop * sorokSzama);

                if (i < lapok.length) {
                    String ertek = lapok[i].getErtek().toString();
                    String szin = lapok[i].getSzin().toString();
                    String kartya = ertek + " " + szin;

                    int kozepreTolva = (oszlopSzelesseg + kartya.length()) / 2;
                    String feligFormazott = String.format("%" + kozepreTolva + "s", kartya);
                    String formazottLap = String.format("%-" + oszlopSzelesseg + "s", feligFormazott);

                    if (oszlop == oszlopokSzama - 1) {
                        output += formazottLap;
                    } else {
                        output += formazottLap + " | ";
                    }
                }
            }
            output += "\n";
        }

        System.out.println(output);
    }

    public void keveres(int valasztott) {
        Lap[] uj = new Lap[this.lapok.length];

        int index = 1;
        int[] sorrend = new int[3];

        switch (valasztott) {
            case 1:
                sorrend[0] = 1;
                sorrend[1] = 0;
                sorrend[2] = 2;
                break;
            case 2:
                sorrend[0] = 0;
                sorrend[1] = 1;
                sorrend[2] = 2;
                break;
            default:
                sorrend[0] = 0;
                sorrend[1] = 2;
                sorrend[2] = 1;
                break;
        }

        for (int o = 0; o < 3; o++) {
            for (int s = 0; s < 7; s++) {
                uj[index++] = this.lapok[sorrend[o] * 7 + s + 1];
            }
        }

        this.lapok = uj;
    }

}
