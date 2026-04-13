//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

public class Kunde implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int nesteNr = 1000;
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

    /**
     * Creates a new customer and assigns the next available customer number.
     *
     * @param var1 customer name
     * @param var2 invoice address
     * @param var3 registration date
     */
    public Kunde(String var1, String var2, Calendar var3) {
        this.navn = var1;
        this.fakturaAdresse = var2;
        this.dato = var3;
        this.kundeNr = nesteNr++;
        this.bilListe = new HashSet<>();
        this.boatListe = new HashSet<>();
        this.husListe = new HashSet<>();
        this.fritidhusListe = new HashSet<>();
        this.reiseListe = new HashSet<>();
    }

    /**
     * Returns the customer number.
     *
     * @return the customer number
     */
    public int getKundeNr() {
        return this.kundeNr;
    }

    /**
     * Returns the customer name.
     *
     * @return the customer name
     */
    public String getNavn() {
        return this.navn;
    }

    /**
     * Updates the customer name.
     *
     * @param var1 new customer name
     */
    public void setNavn(String var1) {
        this.navn = var1;
    }

    /**
     * Returns the invoice address.
     *
     * @return the invoice address
     */
    public String getFakturaAdresse() {
        return this.fakturaAdresse;
    }

    /**
     * Updates the invoice address.
     *
     * @param var1 new invoice address
     */
    public void setFakturaAdresse(String var1) {
        this.fakturaAdresse = var1;
    }

    /**
     * Returns the raw calendar date object associated with the customer.
     *
     * @return the customer date object
     */
    public Calendar getDatoObjekt() {
        return this.dato;
    }

    /**
     * Updates the customer's calendar date.
     *
     * @param var1 new date value
     */
    public void setDato(Calendar var1) {
        this.dato = var1;
    }

    /**
     * Returns the customer's date formatted for display.
     *
     * @return formatted date text, or an empty string when no date exists
     */
    public String getDato() {
        if (this.dato == null) {
            return "";
        } else {
            SimpleDateFormat var1 = new SimpleDateFormat("dd.MM.yyyy");
            return var1.format(this.dato.getTime());
        }
    }

    /**
     * Indicates whether the customer has boat insurance.
     *
     * @return {@code true} when boat insurance is registered
     */
    public boolean hasBoatInsurance() {
        return this.hasBoatInsurance;
    }

    /**
     * Updates the boat-insurance flag.
     *
     * @param var1 new boat-insurance state
     */
    public void setHasBoatInsurance(boolean var1) {
        this.hasBoatInsurance = var1;
    }

    /**
     * Indicates whether the customer has car insurance.
     *
     * @return {@code true} when car insurance is registered
     */
    public boolean hasCarInsurance() {
        return this.hasCarInsurance;
    }

    /**
     * Updates the car-insurance flag.
     *
     * @param var1 new car-insurance state
     */
    public void setHasCarInsurance(boolean var1) {
        this.hasCarInsurance = var1;
    }

    /**
     * Returns the number of insurances associated with the customer.
     *
     * @return the insurance count
     */
    public int getInsuranceCount() {
        return this.insuranceCount;
    }

    /**
     * Updates the number of insurances associated with the customer.
     *
     * @param var1 new insurance count
     */
    public void setInsuranceCount(int var1) {
        this.insuranceCount = var1;
    }

    /**
     * Returns the customer's premium ratio.
     *
     * @return the premium ratio
     */
    public double getPremieRatio() {
        return this.premieRatio;
    }

    /**
     * Updates the customer's premium ratio.
     *
     * @param var1 new premium ratio
     */
    public void setPremieRatio(double var1) {
        this.premieRatio = var1;
    }

    /**
     * Returns the primary car insurance reference.
     *
     * @return the linked car insurance
     */
    public Bilforsikring getBil() {
        return this.bil;
    }

    /**
     * Updates the primary car insurance reference.
     *
     * @param var1 new car insurance reference
     */
    public void setBil(Bilforsikring var1) {
        this.bil = var1;
    }

    /**
     * Returns the set of car insurances.
     *
     * @return the car insurance set
     */
    public Set<Bilforsikring> getBilListe() {
        return this.bilListe;
    }

    /**
     * Returns the set of boat insurances.
     *
     * @return the boat insurance set
     */
    public Set<BaatForsikring> getBoatListe() {
        return this.boatListe;
    }

    /**
     * Returns the set of house insurances.
     *
     * @return the house insurance set
     */
    public Set<Husoginnboforsikring> getHusListe() {
        return this.husListe;
    }

    /**
     * Returns the set of leisure property insurances.
     *
     * @return the leisure property insurance set
     */
    public Set<FritidsboligForsikiring> getFritidhusListe() {
        return this.fritidhusListe;
    }

    /**
     * Returns the set of travel insurances.
     *
     * @return the travel insurance set
     */
    public Set<Reise> getReiseListe() {
        return this.reiseListe;
    }

    /**
     * Adds a car insurance to the customer.
     *
     * @param var1 insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean leggTilbil(Bilforsikring var1) {
        return var1 != null && this.bilListe.add(var1);
    }

    /**
     * Adds a boat insurance to the customer.
     *
     * @param var1 insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean addBaat(BaatForsikring var1) {
        return var1 != null && this.boatListe.add(var1);
    }

    /**
     * Adds a house insurance to the customer.
     *
     * @param var1 insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean addHusForsikring(Husoginnboforsikring var1) {
        return var1 != null && this.husListe.add(var1);
    }

    /**
     * Adds a leisure property insurance to the customer.
     *
     * @param var1 insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean addFritidshusForsikring(FritidsboligForsikiring var1) {
        return var1 != null && this.fritidhusListe.add(var1);
    }

    /**
     * Adds a travel insurance to the customer.
     *
     * @param var1 insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean addReise(Reise var1) {
        return var1 != null && this.reiseListe.add(var1);
    }

    /**
     * Updates the static next customer number.
     *
     * @param var1 next customer number to use
     */
    public void setKundeNr(int var1) {
        nesteNr = var1;
    }

    /**
     * Returns the static next customer number.
     *
     * @return the next customer number
     */
    public int getNesteNr() {
        return nesteNr;
    }

    /**
     * Returns a printable representation of the customer.
     *
     * @return formatted customer text
     */
    public String toString() {
        Formatter var1 = new Formatter();
        Calendar var2 = Calendar.getInstance();
        var1.format("%tc", var2);
        return "Kunde{kundeNr=" + this.kundeNr + ", navn='" + this.navn + "', fakturaAdresse='" + this.fakturaAdresse + "', dato=" + this.getDato() + ", insuranceCount=" + this.insuranceCount + ", premieRatio=" + this.premieRatio + "}";
    }
}
