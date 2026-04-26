import java.util.ArrayList;

public class Recept {
    private String rnev;
    private ArrayList<ReceptHozzavalo> hozzavalok;

    public Recept(){
        this.rnev = "Anonymus recept";
        this.hozzavalok = new ArrayList<>();
    }

    public Recept(String n){
        this.rnev = n;
        this.hozzavalok = new ArrayList<>();
    }

    public Recept(String n, ArrayList<ReceptHozzavalo> m){
        this.rnev = n;
        this.hozzavalok = m;
    }

    public String getRnev(){
        return this.rnev;
    }

    public ArrayList<ReceptHozzavalo> getHozzavalok(){
        return hozzavalok;
    }

    public void addHozzavalo(ReceptHozzavalo h){
        hozzavalok.add(h);
    }


    public String toString(){
        return "Név: " + rnev + " Hozzávalók: " + hozzavalok;
    }

    public void hozzaAd(ReceptHozzavalo d){
        hozzavalok.add(d);
    }
}