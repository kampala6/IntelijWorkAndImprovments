//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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

    public Kunde(String var1, String var2, Calendar var3) {
        this.navn = var1;
        this.fakturaAdresse = var2;
        this.dato = var3;
        this.kundeNr = nesteNr++;
        this.bilListe = new HashSet();
        this.boatListe = new HashSet();
        this.husListe = new HashSet();
        this.fritidhusListe = new HashSet();
        this.reiseListe = new HashSet();
    }

    public int getKundeNr() {
        return this.kundeNr;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String var1) {
        this.navn = var1;
    }

    public String getFakturaAdresse() {
        return this.fakturaAdresse;
    }

    public void setFakturaAdresse(String var1) {
        this.fakturaAdresse = var1;
    }

    public Calendar getDatoObjekt() {
        return this.dato;
    }

    public void setDato(Calendar var1) {
        this.dato = var1;
    }

    public String getDato() {
        if (this.dato == null) {
            return "";
        } else {
            SimpleDateFormat var1 = new SimpleDateFormat("dd.MM.yyyy");
            return ((DateFormat)var1).format(this.dato.getTime());
        }
    }

    public boolean hasBoatInsurance() {
        return this.hasBoatInsurance;
    }

    public void setHasBoatInsurance(boolean var1) {
        this.hasBoatInsurance = var1;
    }

    public boolean hasCarInsurance() {
        return this.hasCarInsurance;
    }

    public void setHasCarInsurance(boolean var1) {
        this.hasCarInsurance = var1;
    }

    public int getInsuranceCount() {
        return this.insuranceCount;
    }

    public void setInsuranceCount(int var1) {
        this.insuranceCount = var1;
    }

    public double getPremieRatio() {
        return this.premieRatio;
    }

    public void setPremieRatio(double var1) {
        this.premieRatio = var1;
    }

    public Bilforsikring getBil() {
        return this.bil;
    }

    public void setBil(Bilforsikring var1) {
        this.bil = var1;
    }

    public Set<Bilforsikring> getBilListe() {
        return this.bilListe;
    }

    public Set<BaatForsikring> getBoatListe() {
        return this.boatListe;
    }

    public Set<Husoginnboforsikring> getHusListe() {
        return this.husListe;
    }

    public Set<FritidsboligForsikiring> getFritidhusListe() {
        return this.fritidhusListe;
    }

    public Set<Reise> getReiseListe() {
        return this.reiseListe;
    }

    public boolean leggTilbil(Bilforsikring var1) {
        return var1 == null ? false : this.bilListe.add(var1);
    }

    public boolean addBaat(BaatForsikring var1) {
        return var1 == null ? false : this.boatListe.add(var1);
    }

    public boolean addHusForsikring(Husoginnboforsikring var1) {
        return var1 == null ? false : this.husListe.add(var1);
    }

    public boolean addFritidshusForsikring(FritidsboligForsikiring var1) {
        return var1 == null ? false : this.fritidhusListe.add(var1);
    }

    public boolean addReise(Reise var1) {
        return var1 == null ? false : this.reiseListe.add(var1);
    }

    public void setKundeNr(int var1) {
        nesteNr = var1;
    }

    public int getNesteNr() {
        return nesteNr;
    }

    public String toString() {
        Formatter var1 = new Formatter();
        Calendar var2 = Calendar.getInstance();
        var1.format("%tc", var2);
        int var10000 = this.kundeNr;
        return "Kunde{kundeNr=" + var10000 + ", navn='" + this.navn + "', fakturaAdresse='" + this.fakturaAdresse + "', dato=" + this.getDato() + ", insuranceCount=" + this.insuranceCount + ", premieRatio=" + this.premieRatio + "}";
    }
}
