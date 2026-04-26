

public static void main(String[] args) {
    // System.out.println("szia");

    /*
    hozz létre egy alapanyagot (pl. rum)
    hozz létre egy receptet (pl. Mojito)
    add hozzá a hozzávalót
    írd ki
    */


    try {
        Faljkezelo falj = new Faljkezelo();
        falj.fajlLetrehozas();
        falj.irasFajlba("adatbazis.txt","Lorem ispum gatyusz maximusz");

        falj.fajlOlvaso("adatbazis.txt");

        Alapanyag a = new Alapanyag("fehér rum", "l");

        ReceptHozzavalo g = new ReceptHozzavalo(2, a);

        Recept rep = new Recept("Mojito");
        rep.addHozzavalo(g);

        System.out.println(rep);


    } catch (IOException hiba) {
        System.err.println(hiba.getMessage());
        hiba.printStackTrace();
    }
}


