package classes;
//Dávid

public class Lap {
    private Ertek ertek;
    private Szin szin;

    public Lap(Ertek ertek, Szin szin) {
        this.ertek = ertek;
        this.szin = szin;
    }

    public Ertek getErtek() {
        return ertek;
    }

    public Szin getSzin() {
        return szin;
    }
}
