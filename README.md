#  21 Lapos Kártyatrükk (Java OOP Projekt)

Ez a projekt a klasszikus 21 lapos kártyatrükk konzolos implementációja Java nyelven. A szoftver szigorú objektumorientált (OOP) elvek alapján készült, bemutatva az osztályok, enumerációk (enum) és az alapvető tömbműveletek gyakorlati használatát.

##  A játékmenet

1. A program kiterít 21 darab kártyát (magyar kártya pakliból) 3 oszlopba rendezve.
2. A felhasználónak gondolnia kell egy lapra a képernyőn lévők közül.
3. A program háromszor megkérdezi, hogy a gondolt lap melyik oszlopban található (1, 2 vagy 3).
4. A harmadik válasz és keverés után a program matematikai pontossággal, tévedhetetlenül "kitalálja" és kiírja a gondolt lapot.

##  Fájlstruktúra és Architektúra

A projekt logikailag három különálló csomagra (package) van bontva:

* **`app`**: A felhasználói interakcióért felelős réteg.
  * `Trukk.java`: A főprogram (`main` metódus). Tartalmazza a játékciklust és a konzolos beolvasást (`Scanner`).
* **`classes`**: Az üzleti logika és az adatmodellek.
  * `Pakli.java`: Felelős a 21 lap tárolásáért, a formázott konzolos megjelenítésért és a trükk matematikai átrendezéséért (keverés).
  * `Lap.java`: Egyetlen kártyalapot reprezentáló osztály.
  * `Szin.java` / `Ertek.java`: Enumerációk a magyar kártya szabályos színeinek és értékeinek korlátozására.
##  Futtatás

A program futtatásához Java futtatókörnyezet (JRE) szükséges. A konzolos ékezetes karakterek megfelelő megjelenítése érdekében az alábbi VM argumentumok használata javasolt:

```bash
