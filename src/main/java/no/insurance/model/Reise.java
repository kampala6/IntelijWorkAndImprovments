//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;

public class Reise extends Forsikring implements Serializable {
    public String kunder;
    private String område;
    private int sumf;
    private final Calendar dato;
    private double bouns = (double)0.0F;

    /**
     * Creates a new travel insurance instance.
     *
     * @param var1 customer identifier
     * @param var2 coverage area
     * @param var3 insured sum
     * @param var4 insurance identifier
     * @param var5 bonus value
     */
    public Reise(String var1, String var2, int var3, int var4, double var5) {
        super(var4);
        this.kunder = var1;
        this.område = var2;
        this.sumf = var3;
        this.dato = Calendar.getInstance();
        this.bouns = var5;
    }

    /**
     * Returns the coverage area.
     *
     * @return the coverage area
     */
    public String getOmråde() {
        return this.område;
    }

    /**
     * Updates the coverage area.
     *
     * @param var1 new coverage area
     */
    public void setOmråde(String var1) {
        this.område = var1;
    }

    /**
     * Returns the insured sum.
     *
     * @return the insured sum
     */
    public int getSumf() {
        return this.sumf;
    }

    /**
     * Returns the registration date formatted for display.
     *
     * @return formatted date text
     */
    public String getDato() {
        SimpleDateFormat var1 = new SimpleDateFormat("dd.MM.yyyy");
        return ((DateFormat)var1).format(this.dato.getTime());
    }

    /**
     * Updates the insured sum.
     *
     * @param var1 new insured sum
     */
    public void setSumf(int var1) {
        this.sumf = var1;
    }

    /**
     * Calculates the travel insurance premium.
     *
     * @return the calculated premium
     */
    public double premie() {
        double var1 = (double)this.sumf;
        double var3 = (double)(this.sumf / 100) * this.bouns;
        return this.beregnPremieEtterKunderabatt(var1 + var3);
    }

    /**
     * Returns a printable representation of the travel insurance.
     *
     * @return formatted travel insurance text
     */
    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        SimpleDateFormat var2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Formatter var3 = new Formatter();
        Calendar var4 = Calendar.getInstance();
        var3.format("%tc", var4);
        String var10000 = this.område;
        return "Reise{område=" + var10000 + ", sumf=" + this.sumf + ", premie=" + var1.format(this.premie()) + ", dato=" + ((DateFormat)var2).format(this.dato.getTime()) + ", formattedDate=" + String.valueOf(var3) + "}";
    }

    /**
     * Returns the age of the travel insurance basis.
     *
     * @return not supported for this insurance type
     */
    public int age() {
        return this.beregnAlderFraAarstall(this.dato.get(Calendar.YEAR));
    }

    /**
     * Returns the insurance type code for travel insurance.
     *
     * @return the travel insurance type code
     */
    public int getForsikringsType() {
        return 3;
    }
}
