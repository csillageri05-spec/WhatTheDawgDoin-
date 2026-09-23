package app;

public class KonfliktusKezeles {

    private static int valasztott;
    private static String[] pakli;

    public static void main(String[] args) {
        keveres();  
    }

    private static void keveres() {
        String[] uj = new String[22];
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
                uj[index++] = pakli[sorrend[o] * 7 + s + 1];
            }
        }
        pakli = uj;
    }

}
