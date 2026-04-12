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

    public String getBiltype() {
        return this.biltype;
    }

    public void setBiltype(String var1) {
        this.biltype = var1;
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
        return 1;
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
