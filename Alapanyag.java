import java.util.ArrayList;


public class Alapanyag {
    // Attributomok
    private String nev;
    private String mertekegyseg;

    // Konsruktorok

    public Alapanyag(){
        this.nev = "Valami";
        this.mertekegyseg = "Ismeretlen";
    }

    public Alapanyag(String n, String m){
        this.nev = n;
        this.mertekegyseg = m;
    }

    // Getterek
    public String getNev(){
        return this.nev;
    }

    public String getMertek(){
        return this.mertekegyseg;
    }

    public String toString(){
        return "Név: " + getNev() + " Mértékegység: "+ getMertek();
    }


}
