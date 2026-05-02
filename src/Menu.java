
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    private static Scanner input = new Scanner(System.in);

    private ArrayList<String> user_ingridient;


    /*1. Új alapanyag
2. Új recept
3. Recept törlése
4. Hozzávalók listázása
5. Mentés fájlba
6. Betöltés fájlból
0. Kilépés*/

    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String menu_print() {
        return "1. Új alapanyag\n2. Új recept\n3. Recept törlése\n4. Hozzávalók listázása\n5. Mentés fájlba\n6. Betöltés fájlból\n7. Kilépés";

    }

    /*
    public int user_input() {
        System.out.println("Kérek egy választási opciót:  ");

        int text = input.nextInt();
        return text;

    }
*/
    public int userInput() {
        while (true) {
            System.out.println("Kérek egy választási opciót: ");
            String text = input.nextLine();
            if (isNumber(text)) {
                int num = Integer.parseInt(text);
                return num;

            } else {
                System.out.println("Hibás bemenet! Számot adj meg.");
            }
        }
    }

    public ArrayList<String> InputIngridient() {
        ArrayList<String> list = new ArrayList<>();

        while (true){

        System.out.println("Kérek egy alapanyagot és egy mértékegységet: ");
        String items = input.nextLine();
        String[] words = items.split(" ");
        if (words.length == 2 && words[0].isEmpty() == false && words[1].isEmpty() == false && isNumber(words[0]) == false && isNumber(words[1]) == false){
            list.add(words[0]);
            list.add(words[1]);
            break;
        }
        else {
            System.out.println("Hibás bemenet! Példa: rum l");
        }

        }

        return list;


    }

    public ArrayList<String> InputRecipe() {
        ArrayList<String> list = new ArrayList<>();
        while (true){
            System.out.println("Kérek egy alapanyagot és egy mennyiséget: ");
            String items = input.nextLine();
            String[] words = items.split(" ");
            if (words.length == 2 && words[0].isEmpty() == false && words[1].isEmpty() == false && isNumber(words[1]) == true && isNumber(words[0]) == false){
                list.add(words[0]);
                list.add(words[1]);
                break;
            }
            else {
                System.out.println("Hibás bemenet! Példa: alma 2");
            }

        }

        return list;


    }

    public String newRecipe(){
        while (true){
            System.out.println("Kérek egy receptet: ");
            String NeRec = input.nextLine();
            if (NeRec.isEmpty() == false){
                return NeRec;
            }
            else{
                System.out.println("Valamit meg kell adnod a semmit nem tudjuk elmenteni!");
            }

        }



    }

    public String newinput(){
        String N = input.nextLine();
        return N;

    }


}
