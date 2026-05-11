//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.model;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Forsikring implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int BIL = 1;
    public static final int HUS_INNBO = 2;
    public static final int REISE = 3;
    public static final int BAAT = 4;
    public static final int FRITIDSBO = 5;
    public static final int DEFAULT_TOTAL_KUNDERABATT = 3;
    public static final int DEFAULT_F_TYPE = 0;
    private int forsikringId;
    private int totalKunderabatt = DEFAULT_TOTAL_KUNDERABATT;
    private int fType = DEFAULT_F_TYPE;

    /**
     * Creates a new insurance base object.
     *
     * @param var1 insurance identifier
     */
    protected Forsikring(int var1) {
        this.setForsikringId(var1);
    }

    /**
     * Returns the insurance identifier.
     *
     * @return the insurance identifier
     */
    public int getForsikringId() {
        return this.forsikringId;
    }

    /**
     * Updates the insurance identifier.
     *
     * @param var1 new insurance identifier
     */
    public void setForsikringId(int var1) {
        this.forsikringId = Math.max(0, var1);
    }

    /**
     * Returns the insurance identifier using the legacy method name.
     *
     * @return the insurance identifier
     * @deprecated Use {@link #getForsikringId()} instead.
     */
    @Deprecated
    public int getForsikiringID() {
        return this.getForsikringId();
    }

    /**
     * Updates the insurance identifier using the legacy method name.
     *
     * @param var1 new insurance identifier
     * @deprecated Use {@link #setForsikringId(int)} instead.
     */
    @Deprecated
    public void setForsikiringID(int var1) {
        this.setForsikringId(var1);
    }

    /**
     * Returns the total customer discount percentage.
     *
     * @return the total customer discount
     */
    public int getTotalKunderabatt() {
        return this.totalKunderabatt;
    }

    /**
     * Updates the total customer discount percentage.
     *
     * @param var1 new discount percentage
     */
    public void setTotalKunderabatt(int var1) {
        if (var1 < 0) {
            this.totalKunderabatt = 0;
        } else {
            this.totalKunderabatt = Math.min(100, var1);
        }
    }

    /**
     * Returns the total customer discount using the legacy method name.
     *
     * @return the total customer discount
     * @deprecated Use {@link #getTotalKunderabatt()} instead.
     */
    @Deprecated
    public int getTOTALKUNDERABATT() {
        return this.getTotalKunderabatt();
    }

    /**
     * Updates the total customer discount using the legacy method name.
     *
     * @param var1 new discount percentage
     * @deprecated Use {@link #setTotalKunderabatt(int)} instead.
     */
    @Deprecated
    public void setTOTALKUNDERABATT(int var1) {
        this.setTotalKunderabatt(var1);
    }

    /**
     * Returns the internal insurance type code.
     *
     * @return the insurance type code
     */
    public int getFType() {
        return this.fType == DEFAULT_F_TYPE ? this.getForsikringsType() : this.fType;
    }

    /**
     * Updates the internal insurance type code.
     *
     * @param var1 new insurance type code
     */
    public void setFType(int var1) {
        this.fType = this.isValidForsikringType(var1) ? var1 : DEFAULT_F_TYPE;
    }

    /**
     * Checks whether a type code matches one of the known insurance categories.
     *
     * @param var1 insurance type code
     * @return {@code true} when the type code is known
     */
    private boolean isValidForsikringType(int var1) {
        return var1 == DEFAULT_F_TYPE || var1 == BIL || var1 == HUS_INNBO || var1 == REISE || var1 == BAAT || var1 == FRITIDSBO;
    }

    /**
     * Applies total customer discount to a base premium amount.
     *
     * @param var1 base premium before customer discount
     * @return premium after customer discount, never negative
     */
    protected double beregnPremieEtterKunderabatt(double var1) {
        double var3 = Math.max(0.0, var1);
        return var3 * (1.0 - (double)this.totalKunderabatt / 100.0);
    }

    /**
     * Calculates age from a model/build year.
     *
     * @param var1 model/build year
     * @return non-negative age in years
     */
    protected int beregnAlderFraAarstall(int var1) {
        int var2 = Calendar.getInstance().get(Calendar.YEAR);
        return Math.max(0, var2 - var1);
    }

    /**
     * Returns the internal insurance type code using the legacy method name.
     *
     * @return the insurance type code
     * @deprecated Use {@link #getFType()} instead.
     */
    @Deprecated
    public int getF_type() {
        return this.getFType();
    }

    /**
     * Updates the internal insurance type code using the legacy method name.
     *
     * @param var1 new insurance type code
     * @deprecated Use {@link #setFType(int)} instead.
     */
    @Deprecated
    public void setF_type(int var1) {
        this.setFType(var1);
    }

    /**
     * Calculates the premium for the insurance.
     *
     * @return the calculated premium
     */
    public abstract double premie();

    /**
     * Returns a printable representation of the insurance.
     *
     * @return formatted insurance text
     */
    public abstract String toString();

    /**
     * Returns the age of the insured object or policy basis.
     *
     * @return the calculated age in years or an equivalent value
     */
    public abstract int age();

    /**
     * Returns the insurance category code.
     *
     * @return the insurance category code
     */
    public abstract int getForsikringsType();
}
