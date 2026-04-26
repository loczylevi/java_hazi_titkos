
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Faljkezelo {

    public void fajlLetrehozas() throws IOException{

        File falj = new File("adatbazis.txt");
        if (falj.createNewFile() == true) {           // Fájl készítés probálása
            System.out.println("Fájl sikeresen létrehozva!");
        } else {
            System.out.println("Sajnálatos módon a fájl már létezik!");
        }

        //System.out.println("Fájl létrehozva");
    }

    public void irasFajlba(String f, String mit) throws IOException {

        FileWriter falj = new FileWriter(f, true);  // a második paraméterrel append paramétert true-ra állitjuk
        falj.write(mit+"\n");
        falj.close();  // must close manually
        System.out.println("Fájlba írás sikeresen megtörtént!");
    }

    public void fajlOlvaso(String obj) throws IOException{
        File falj = new File(obj);
        Scanner olvasoLista = new Scanner(falj);
        System.out.println("\n_______________Fálj-Olvasás_______________________\n");
        while (olvasoLista.hasNextLine()) {
            String data = olvasoLista.nextLine();
            System.out.println(data);
        }
        olvasoLista.close();
        System.out.println("\n_______________Fálj-Olvasás_______________________\n");

    }





}
