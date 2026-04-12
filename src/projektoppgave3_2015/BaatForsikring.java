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

    public Calendar getDatoObjekt() {
        return this.dato;
    }

    public void setDato(Calendar var1) {
        this.dato = var1;
    }

    public int getKunder() {
        return this.kunder;
    }

    public void setKunder(int var1) {
        this.kunder = var1;
    }

    public String getRegistreringsnummer() {
        return this.registreringsnummer;
    }

    public void setRegistreringsnummer(String var1) {
        this.registreringsnummer = var1;
    }

    public String getBaattype() {
        return this.baattype;
    }

    public void setBaattype(String var1) {
        this.baattype = var1;
    }

    public String getModell() {
        return this.modell;
    }

    public void setModell(String var1) {
        this.modell = var1;
    }

    public int getLengde() {
        return this.lengde;
    }

    public void setLengde(int var1) {
        this.lengde = var1;
    }

    public int getÅrsmodell() {
        return this.årsmodell;
    }

    public void setÅrsmodell(int var1) {
        this.årsmodell = var1;
    }

    public String getMotortype() {
        return this.motortype;
    }

    public void setMotortype(String var1) {
        this.motortype = var1;
    }

    public int getMotorstyrke() {
        return this.motorstyrke;
    }

    public void setMotorstyrke(int var1) {
        this.motorstyrke = var1;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double var1) {
        this.bonus = var1;
    }

    public double premie() {
        return (double)(this.motorstyrke * this.lengde) * ((double)1.0F - this.bonus / (double)100.0F);
    }

    public int getForsikringsType() {
        return 4;
    }

    public int age() {
        if (this.dato == null) {
            return 0;
        } else {
            int var1 = Calendar.getInstance().get(1);
            return Math.max(0, var1 - this.årsmodell);
        }
    }

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
