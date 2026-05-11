//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Calendar;

public class FritidsboligForsikiring extends Forsikring implements Serializable {
    private static final long serialVersionUID = 1L;
    private String boligensAdresse;
    private int byggeaar = -1;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private int antallKvadratmeter = -1;
    private int belopB = -1;
    private int belopI = -1;
    private double bonus = (double)0.0F;
    private Calendar dato;

    /**
     * Creates a new leisure property insurance instance.
     *
     * @param var1 address
     * @param var2 registration date
     * @param var3 housing type
     * @param var4 building material
     * @param var5 property standard
     * @param var6 contents amount
     * @param var7 building amount
     * @param var8 build year
     * @param var9 square meter count
     * @param var10 bonus percentage
     * @param var12 insurance identifier
     */
    public FritidsboligForsikiring(String var1, Calendar var2, String var3, String var4, String var5, int var6, int var7, int var8, int var9, double var10, int var12) {
        super(var12);
        this.boligensAdresse = var1;
        this.dato = var2;
        this.boligtype = var3;
        this.byggemateriale = var4;
        this.standard = var5;
        this.belopI = var6;
        this.belopB = var7;
        this.byggeaar = var8;
        this.antallKvadratmeter = var9;
        this.bonus = var10;
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
     * Updates the square meter count.
     *
     * @param var1 new square meter count
     */
    public void setAntallKvadratmeter(int var1) {
        this.antallKvadratmeter = var1;
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
     * Calculates the leisure property insurance premium.
     *
     * @return the calculated premium
     */
    public double premie() {
        double var1 = (double)(this.belopB * this.belopI) * (1.0 - this.bonus / 100.0);
        return this.beregnPremieEtterKunderabatt(var1);
    }

    /**
     * Returns the insurance type code for leisure property insurance.
     *
     * @return the leisure property insurance type code
     */
    public int getForsikringsType() {
        return 5;
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
     * Returns a printable representation of the leisure property insurance.
     *
     * @return formatted leisure property insurance text
     */
    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        String var10000 = this.boligensAdresse;
        return "FritidsboligForsikiring{boligensAdresse='" + var10000 + "', byggeaar=" + this.byggeaar + ", boligtype='" + this.boligtype + "', byggemateriale='" + this.byggemateriale + "', standard='" + this.standard + "', antallKvadratmeter=" + this.antallKvadratmeter + ", belopB=" + this.belopB + ", belopI=" + this.belopI + ", bonus=" + this.bonus + ", premie=" + var1.format(this.premie()) + "}";
    }
}
