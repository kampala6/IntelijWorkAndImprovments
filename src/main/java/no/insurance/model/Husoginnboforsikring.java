//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Calendar;

public class Husoginnboforsikring extends Forsikring implements Serializable {
    private static final long serialVersionUID = 1L;
    private String boligensAdresse;
    private int byggeaar = -1;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private final int antallKvadratmeter;
    private int belopB = -1;
    private int belopI = -1;
    private double bonus = (double)0.0F;
    private Calendar dato;
    private int kunde;

    /**
     * Creates a new house and contents insurance instance.
     *
     * @param var1 customer number
     * @param var2 address
     * @param var3 housing type
     * @param var4 registration date
     * @param var5 building material
     * @param var6 square meter count
     * @param var7 building amount
     * @param var8 contents amount
     * @param var9 build year
     * @param var10 property standard
     * @param var11 insurance identifier
     */
    public Husoginnboforsikring(int var1, String var2, String var3, Calendar var4, String var5, int var6, int var7, int var8, int var9, String var10, int var11) {
        super(var11);
        this.kunde = var1;
        this.boligensAdresse = var2;
        this.boligtype = var3;
        this.dato = var4;
        this.byggemateriale = var5;
        this.antallKvadratmeter = var6;
        this.belopB = var7;
        this.belopI = var8;
        this.byggeaar = var9;
        this.standard = var10;
    }

    /**
     * Returns the property address.
     *
     * @return the property address
     */
    public String getBoligensAdresse() {
        return this.boligensAdresse;
    }

    /**
     * Updates the property address.
     *
     * @param var1 new property address
     */
    public void setBoligensAdresse(String var1) {
        this.boligensAdresse = var1;
    }

    /**
     * Returns the build year.
     *
     * @return the build year
     */
    public int getByggeaar() {
        return this.byggeaar;
    }

    /**
     * Updates the build year.
     *
     * @param var1 new build year
     */
    public void setByggeaar(int var1) {
        this.byggeaar = var1;
    }

    /**
     * Returns the housing type.
     *
     * @return the housing type
     */
    public String getBoligtype() {
        return this.boligtype;
    }

    /**
     * Updates the housing type.
     *
     * @param var1 new housing type
     */
    public void setBoligtype(String var1) {
        this.boligtype = var1;
    }

    /**
     * Returns the building material.
     *
     * @return the building material
     */
    public String getByggemateriale() {
        return this.byggemateriale;
    }

    /**
     * Updates the building material.
     *
     * @param var1 new building material
     */
    public void setByggemateriale(String var1) {
        this.byggemateriale = var1;
    }

    /**
     * Returns the property standard.
     *
     * @return the property standard
     */
    public String getStandard() {
        return this.standard;
    }

    /**
     * Updates the property standard.
     *
     * @param var1 new property standard
     */
    public void setStandard(String var1) {
        this.standard = var1;
    }

    /**
     * Returns the square meter count.
     *
     * @return the square meter count
     */
    public int getAntallKvadratmeter() {
        return this.antallKvadratmeter;
    }

    /**
     * Returns the building amount.
     *
     * @return the building amount
     */
    public int getBelopB() {
        return this.belopB;
    }

    /**
     * Updates the building amount.
     *
     * @param var1 new building amount
     */
    public void setBelopB(int var1) {
        this.belopB = var1;
    }

    /**
     * Returns the contents amount.
     *
     * @return the contents amount
     */
    public int getBelopI() {
        return this.belopI;
    }

    /**
     * Updates the contents amount.
     *
     * @param var1 new contents amount
     */
    public void setBelopI(int var1) {
        this.belopI = var1;
    }

    /**
     * Returns the bonus percentage.
     *
     * @return the bonus percentage
     */
    public double getBonus() {
        return this.bonus;
    }

    /**
     * Updates the bonus percentage.
     *
     * @param var1 new bonus percentage
     */
    public void setBonus(double var1) {
        this.bonus = var1;
    }

    /**
     * Returns the raw calendar date object.
     *
     * @return the date object
     */
    public Calendar getDatoObjekt() {
        return this.dato;
    }

    /**
     * Updates the registration date.
     *
     * @param var1 new date value
     */
    public void setDato(Calendar var1) {
        this.dato = var1;
    }

    /**
     * Returns the customer number.
     *
     * @return the customer number
     */
    public int getKunde() {
        return this.kunde;
    }

    /**
     * Updates the customer number.
     *
     * @param var1 new customer number
     */
    public void setKunde(int var1) {
        this.kunde = var1;
    }

    /**
     * Calculates the house insurance premium.
     *
     * @return the calculated premium
     */
    public double premie() {
        double var1 = (double)(this.antallKvadratmeter * this.belopB) * (1.0 - this.bonus / 100.0);
        return this.beregnPremieEtterKunderabatt(var1);
    }

    /**
     * Returns the insurance type code for house insurance.
     *
     * @return the house insurance type code
     */
    public int getForsikringsType() {
        return 2;
    }

    /**
     * Calculates the property age.
     *
     * @return the calculated age, or {@code 0} when no date exists
     */
    public int age() {
        if (this.dato == null) {
            return 0;
        } else {
            return this.beregnAlderFraAarstall(this.byggeaar);
        }
    }

    /**
     * Returns a printable representation of the house insurance.
     *
     * @return formatted house insurance text
     */
    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        int var10000 = this.kunde;
        return "Husoginnboforsikring{kunde=" + var10000 + ", boligensAdresse='" + this.boligensAdresse + "', byggeaar=" + this.byggeaar + ", boligtype='" + this.boligtype + "', byggemateriale='" + this.byggemateriale + "', standard='" + this.standard + "', antallKvadratmeter=" + this.antallKvadratmeter + ", belopB=" + this.belopB + ", belopI=" + this.belopI + ", bonus=" + this.bonus + ", premie=" + var1.format(this.premie()) + "}";
    }
}
