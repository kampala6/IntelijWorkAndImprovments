//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Calendar;

public class Bilforsikring extends Forsikring implements Serializable {
    private static final long serialVersionUID = 1L;
    private Calendar dato;
    private int kunder;
    private String registreringsnummer;
    private String biltype;
    private String modell;
    private int lengde;
    private int årsmodell;
    private String motortype;
    private int motorstyrke;
    private double bonus = (double)0.0F;

    /**
     * Creates a new car insurance instance.
     *
     * @param var1 registration date
     * @param var2 customer number
     * @param var3 registration number
     * @param var4 car type
     * @param var5 model
     * @param var6 length or size factor
     * @param var7 model year
     * @param var8 engine type
     * @param var9 engine power
     * @param var10 insurance identifier
     */
    public Bilforsikring(Calendar var1, int var2, String var3, String var4, String var5, int var6, int var7, String var8, int var9, int var10) {
        super(var10);
        this.dato = var1;
        this.kunder = var2;
        this.registreringsnummer = var3;
        this.biltype = var4;
        this.modell = var5;
        this.lengde = var6;
        this.årsmodell = var7;
        this.motortype = var8;
        this.motorstyrke = var9;
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
     * Returns the car type.
     *
     * @return the car type
     */
    public String getBiltype() {
        return this.biltype;
    }

    /**
     * Updates the car type.
     *
     * @param var1 new car type
     */
    public void setBiltype(String var1) {
        this.biltype = var1;
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
     * Calculates the car insurance premium.
     *
     * @return the calculated premium
     */
    public double premie() {
        double var1 = (double)(this.motorstyrke * this.lengde) * (1.0 - this.bonus / 100.0);
        return this.beregnPremieEtterKunderabatt(var1);
    }

    /**
     * Returns the insurance type code for car insurance.
     *
     * @return the car insurance type code
     */
    public int getForsikringsType() {
        return 1;
    }

    /**
     * Calculates the vehicle age.
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
     * Returns a printable representation of the car insurance.
     *
     * @return formatted car insurance text
     */
    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        int var10000 = this.kunder;
        return "Bilforsikring{kunde=" + var10000 + ", registreringsnummer='" + this.registreringsnummer + "', biltype='" + this.biltype + "', modell='" + this.modell + "', lengde=" + this.lengde + ", årsmodell=" + this.årsmodell + ", motortype='" + this.motortype + "', motorstyrke=" + this.motorstyrke + ", bonus=" + this.bonus + ", premie=" + var1.format(this.premie()) + "}";
    }

    public static enum BilType {
        PERSONBIL,
        LASTBIL,
        ELBIL;

        private BilType() {
        }
    }
}
