//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Calendar;

public class BaatForsikring extends Forsikring implements Serializable {
    private static final long serialVersionUID = 1L;
    private Calendar dato;
    private int kunder;
    private String registreringsnummer;
    private String baattype;
    private String modell;
    private int lengde;
    private int årsmodell;
    private String motortype;
    private int motorstyrke;
    private double bonus = (double)0.0F;

    /**
     * Creates a new boat insurance instance.
     *
     * @param var1 registration date
     * @param var2 registration number
     * @param var3 boat type
     * @param var4 model
     * @param var5 length or size factor
     * @param var6 model year
     * @param var7 engine type
     * @param var8 engine power
     * @param var9 bonus percentage
     * @param var11 insurance identifier
     * @param var12 unused legacy value retained for constructor compatibility
     */
    public BaatForsikring(Calendar var1, String var2, String var3, String var4, int var5, int var6, String var7, int var8, double var9, int var11, double var12) {
        super(var11);
        this.dato = var1;
        this.registreringsnummer = var2;
        this.baattype = var3;
        this.modell = var4;
        this.lengde = var5;
        this.årsmodell = var6;
        this.motortype = var7;
        this.motorstyrke = var8;
        this.bonus = var9;
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
    public int getKunder() {
        return this.kunder;
    }

    /**
     * Updates the customer number.
     *
     * @param var1 new customer number
     */
    public void setKunder(int var1) {
        this.kunder = var1;
    }

    /**
     * Returns the registration number.
     *
     * @return the registration number
     */
    public String getRegistreringsnummer() {
        return this.registreringsnummer;
    }

    /**
     * Updates the registration number.
     *
     * @param var1 new registration number
     */
    public void setRegistreringsnummer(String var1) {
        this.registreringsnummer = var1;
    }

    /**
     * Returns the boat type.
     *
     * @return the boat type
     */
    public String getBaattype() {
        return this.baattype;
    }

    /**
     * Updates the boat type.
     *
     * @param var1 new boat type
     */
    public void setBaattype(String var1) {
        this.baattype = var1;
    }

    /**
     * Returns the model name.
     *
     * @return the model name
     */
    public String getModell() {
        return this.modell;
    }

    /**
     * Updates the model name.
     *
     * @param var1 new model name
     */
    public void setModell(String var1) {
        this.modell = var1;
    }

    /**
     * Returns the length or size factor.
     *
     * @return the length or size factor
     */
    public int getLengde() {
        return this.lengde;
    }

    /**
     * Updates the length or size factor.
     *
     * @param var1 new length or size factor
     */
    public void setLengde(int var1) {
        this.lengde = var1;
    }

    /**
     * Returns the model year.
     *
     * @return the model year
     */
    public int getÅrsmodell() {
        return this.årsmodell;
    }

    /**
     * Updates the model year.
     *
     * @param var1 new model year
     */
    public void setÅrsmodell(int var1) {
        this.årsmodell = var1;
    }

    /**
     * Returns the engine type.
     *
     * @return the engine type
     */
    public String getMotortype() {
        return this.motortype;
    }

    /**
     * Updates the engine type.
     *
     * @param var1 new engine type
     */
    public void setMotortype(String var1) {
        this.motortype = var1;
    }

    /**
     * Returns the engine power.
     *
     * @return the engine power
     */
    public int getMotorstyrke() {
        return this.motorstyrke;
    }

    /**
     * Updates the engine power.
     *
     * @param var1 new engine power
     */
    public void setMotorstyrke(int var1) {
        this.motorstyrke = var1;
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
     * Calculates the boat insurance premium.
     *
     * @return the calculated premium
     */
    public double premie() {
        double var1 = (double)(this.motorstyrke * this.lengde) * (1.0 - this.bonus / 100.0);
        return this.beregnPremieEtterKunderabatt(var1);
    }

    /**
     * Returns the insurance type code for boat insurance.
     *
     * @return the boat insurance type code
     */
    public int getForsikringsType() {
        return 4;
    }

    /**
     * Calculates the boat age.
     *
     * @return the calculated age, or {@code 0} when no date exists
     */
    public int age() {
        if (this.dato == null) {
            return 0;
        } else {
            return this.beregnAlderFraAarstall(this.årsmodell);
        }
    }

    /**
     * Returns a printable representation of the boat insurance.
     *
     * @return formatted boat insurance text
     */
    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        int var10000 = this.kunder;
        return "BaatForsikring{kunde=" + var10000 + ", registreringsnummer='" + this.registreringsnummer + "', baattype='" + this.baattype + "', modell='" + this.modell + "', lengde=" + this.lengde + ", årsmodell=" + this.årsmodell + ", motortype='" + this.motortype + "', motorstyrke=" + this.motorstyrke + ", bonus=" + this.bonus + ", premie=" + var1.format(this.premie()) + "}";
    }

    public static enum BåtType {
        PERSON_BÅT,
        STOR_BÅT,
        CRUISE_BÅT;

        private BåtType() {
        }
    }
}
