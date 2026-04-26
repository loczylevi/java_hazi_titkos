
public class ReceptHozzavalo {
    private double ertek;
    private Alapanyag egyseg;

    public ReceptHozzavalo(double ertek, Alapanyag egyseg) {
        this.ertek = ertek;
        this.egyseg = egyseg;
    }

    public double getErtek() {
        return ertek;
    }

    public Alapanyag getEgyseg() {
        return egyseg;
    }

    public String toString() {
        return egyseg.getNev() + " - " + ertek + " " + egyseg.getMertek();
    }
}


