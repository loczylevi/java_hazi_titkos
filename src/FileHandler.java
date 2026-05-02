import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {

    public void createFile() throws IOException {

        File file = new File("adatbazis.txt");
        if (file.createNewFile() == true) {           // Fájl készítés probálása
            System.out.println("Fájl sikeresen létrehozva!");
        } else {
            System.out.println("Sajnálatos módon a fájl már létezik!");
        }

        //System.out.println("Fájl létrehozva");
    }

    public void writeToFile(String fileName, String what) throws IOException {

        FileWriter file = new FileWriter(fileName, true);  // a második paraméterrel append paramétert true-ra állitjuk
        file.write(what + "\n");
        file.close();  // must close manually
        System.out.println("Fájlba írás sikeresen megtörtént!");
    }

    public void readFromFile(String object) throws IOException {
        File file = new File(object);
        Scanner readerList = new Scanner(file);
        System.out.println("\n_______________Fálj-Olvasás_______________________\n");
        while (readerList.hasNextLine()) {
            String data = readerList.nextLine();
            System.out.println(data);
        }
        readerList.close();
        System.out.println("\n_______________Fálj-Olvasás_______________________\n");
    }
}