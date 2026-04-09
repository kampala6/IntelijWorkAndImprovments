package projektoppgave3_2015;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

public class Kunde implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int nesteNr = 0;

    private final int kundeNr;
    private String navn;
    private String fakturaAdresse;
    private Calendar dato;

    private boolean hasBoatInsurance;
    private boolean hasCarInsurance;
    private int insuranceCount;
    private double premieRatio;

    private Bilforsikring bil;

    private final Set<Bilforsikring> bilListe;
    private final Set<BaatForsikring> boatListe;
    private final Set<Husoginnboforsikring> husListe;
    private final Set<FritidsboligForsikiring> fritidhusListe;
    private final Set<Reise> reiseListe;

    public Kunde(String navn, String fakturaAdresse, Calendar dato) {
        this.navn = navn;
        this.fakturaAdresse = fakturaAdresse;
        this.dato = dato;
        this.kundeNr = nesteNr++;
        this.bilListe = new HashSet<>();
        this.boatListe = new HashSet<>();
        this.husListe = new HashSet<>();
        this.fritidhusListe = new HashSet<>();
        this.reiseListe = new HashSet<>();
    }

    public int getKundeNr() {
        return kundeNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getFakturaAdresse() {
        return fakturaAdresse;
    }

    public void setFakturaAdresse(String fakturaAdresse) {
        this.fakturaAdresse = fakturaAdresse;
    }

    public Calendar getDatoObjekt() {
        return dato;
    }

    public void setDato(Calendar dato) {
        this.dato = dato;
    }

    public String getDato() {
        if (dato == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(dato.getTime());
    }

    public boolean hasBoatInsurance() {
        return hasBoatInsurance;
    }

    public void setHasBoatInsurance(boolean hasBoatInsurance) {
        this.hasBoatInsurance = hasBoatInsurance;
    }

    public boolean hasCarInsurance() {
        return hasCarInsurance;
    }

    public void setHasCarInsurance(boolean hasCarInsurance) {
        this.hasCarInsurance = hasCarInsurance;
    }

    public int getInsuranceCount() {
        return insuranceCount;
    }

    public void setInsuranceCount(int insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

    public double getPremieRatio() {
        return premieRatio;
    }

    public void setPremieRatio(double premieRatio) {
        this.premieRatio = premieRatio;
    }

    public Bilforsikring getBil() {
        return bil;
    }

    public void setBil(Bilforsikring bil) {
        this.bil = bil;
    }

    public Set<Bilforsikring> getBilListe() {
        return bilListe;
    }

    public Set<BaatForsikring> getBoatListe() {
        return boatListe;
    }

    public Set<Husoginnboforsikring> getHusListe() {
        return husListe;
    }

    public Set<FritidsboligForsikiring> getFritidhusListe() {
        return fritidhusListe;
    }

    public Set<Reise> getReiseListe() {
        return reiseListe;
    }

    public boolean leggTilbil(Bilforsikring b) {
        if (b == null) {
            return false;
        }
        return bilListe.add(b);
    }

    public boolean addBaat(BaatForsikring ba) {
        if (ba == null) {
            return false;
        }
        return boatListe.add(ba);
    }

    public boolean addHusForsikring(Husoginnboforsikring h) {
        if (h == null) {
            return false;
        }
        return husListe.add(h);
    }

    public boolean addFritidshusForsikring(FritidsboligForsikiring f) {
        if (f == null) {
            return false;
        }
        return fritidhusListe.add(f);
    }

    public boolean addReise(Reise r) {
        if (r == null) {
            return false;
        }
        return reiseListe.add(r);
    }

    public void setKundeNr(int kundeNr) {
        nesteNr = kundeNr;
    }

    public int getNesteNr() {
        return nesteNr;
    }

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("%tc", cal);

        return "Kunde{" +
                "kundeNr=" + kundeNr +
                ", navn='" + navn + '\'' +
                ", fakturaAdresse='" + fakturaAdresse + '\'' +
                ", dato=" + getDato() +
                ", insuranceCount=" + insuranceCount +
                ", premieRatio=" + premieRatio +
                '}';
    }
}