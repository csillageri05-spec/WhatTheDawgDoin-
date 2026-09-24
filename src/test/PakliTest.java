package test;

import classes.Ertek;
import classes.Pakli;
import classes.Lap;
import classes.Szin;

public class PakliTest {

    public static void main(String[] args) {
        System.out.println("Tesztek futtatása...");

        testPakliMeretEsInicializalas();
        testKeveresElsoOszlopKozepreKerul();
        testTeljesTrukkMatematikaiLogikaja();

        System.out.println("Minden teszt sikeresen lefutott!");
    }

    public static void testPakliMeretEsInicializalas() {
        Pakli pakli = new Pakli();

        assert pakli.getLapok().length == 22 : "A pakli tömb mérete nem megfelelő!";
        assert pakli.getLapok()[1] != null : "Az 1. kártya hiányzik!";
        assert pakli.getLapok()[21] != null : "A 21. kártya hiányzik!";
        assert pakli.getLapok()[0] == null : "A 0. indexen nem kellene kártyának lennie!";
    }

    public static void testKeveresElsoOszlopKozepreKerul() {
        Pakli pakli = new Pakli();
        Lap elsoOszlopElsoLapja = pakli.getLapok()[1];

        pakli.keveres(1);

        // Memóriacím alapján is egyezniük kell, hiszen csak átrendeztük a tömböt
        assert pakli.getLapok()[8] == elsoOszlopElsoLapja : "Az 1. oszlop lapjai nem kerültek középre!";
    }

    public static void testTeljesTrukkMatematikaiLogikaja() {
        Pakli pakli = new Pakli();
        Lap celLap = pakli.getLapok()[18];

        // 1. KÖR 
        pakli.keveres(3);
        int ujIndex1 = megkeresLapIndex(pakli, celLap);
        int oszlop1 = ((ujIndex1 - 1) / 7) + 1;

        // 2. KÖR
        pakli.keveres(oszlop1);
        int ujIndex2 = megkeresLapIndex(pakli, celLap);
        int oszlop2 = ((ujIndex2 - 1) / 7) + 1;

        // 3. KÖR
        pakli.keveres(oszlop2);

        assert pakli.getLapok()[11] == celLap : "A háromszori keverés végén a gondolt lap nem a 11. helyre került!";
    }

    private static int megkeresLapIndex(Pakli pakli, Lap keresettLap) {
        for (int i = 1; i < pakli.getLapok().length; i++) {
            if (pakli.getLapok()[i] == keresettLap) {
                return i;
            }
        }
        return -1;
    }

    public static void testLapAdatintegritas() {
        // 1. Konstruktor és getterek tesztje
        Lap tesztLap = new Lap(Ertek.ASZ, Szin.TOK);

        assert tesztLap.getSzin() == Szin.TOK : "A getSzin() nem a konstruktorban megadott színt adta vissza!";
        assert tesztLap.getErtek() == Ertek.ASZ : "A getErtek() nem a konstruktorban megadott értéket adta vissza!";
    }

    public static void testLapReferenciaKezeles() {
        // 2. Két ugyanolyan lap létrehozása
        Lap lap1 = new Lap(Ertek.KIRALY, Szin.PIROS);
        Lap lap2 = new Lap(Ertek.KIRALY, Szin.PIROS);

        assert lap1 != lap2 : "A két külön példányosított lap memóriacíme egyezik, ami OOP-ban lehetetlen!";
    }
}
