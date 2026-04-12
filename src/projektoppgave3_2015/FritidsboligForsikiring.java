//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

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

    public String getBoligensAdresse() {
        return this.boligensAdresse;
    }

    public void setBoligensAdresse(String var1) {
        this.boligensAdresse = var1;
    }

    public int getByggeaar() {
        return this.byggeaar;
    }

    public void setByggeaar(int var1) {
        this.byggeaar = var1;
    }

    public String getBoligtype() {
        return this.boligtype;
    }

    public void setBoligtype(String var1) {
        this.boligtype = var1;
    }

    public String getByggemateriale() {
        return this.byggemateriale;
    }

    public void setByggemateriale(String var1) {
        this.byggemateriale = var1;
    }

    public String getStandard() {
        return this.standard;
    }

    public void setStandard(String var1) {
        this.standard = var1;
    }

    public int getAntallKvadratmeter() {
        return this.antallKvadratmeter;
    }

    public void setAntallKvadratmeter(int var1) {
        this.antallKvadratmeter = var1;
    }

    public int getBelopB() {
        return this.belopB;
    }

    public void setBelopB(int var1) {
        this.belopB = var1;
    }

    public int getBelopI() {
        return this.belopI;
    }

    public void setBelopI(int var1) {
        this.belopI = var1;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double var1) {
        this.bonus = var1;
    }

    public Calendar getDatoObjekt() {
        return this.dato;
    }

    public void setDato(Calendar var1) {
        this.dato = var1;
    }

    public double premie() {
        return (double)(this.belopB * this.belopI) * ((double)1.0F - this.bonus / (double)100.0F);
    }

    public int getForsikringsType() {
        return 5;
    }

    public int age() {
        if (this.dato == null) {
            return 0;
        } else {
            int var1 = Calendar.getInstance().get(1);
            return Math.max(0, var1 - this.byggeaar);
        }
    }

    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        String var10000 = this.boligensAdresse;
        return "FritidsboligForsikiring{boligensAdresse='" + var10000 + "', byggeaar=" + this.byggeaar + ", boligtype='" + this.boligtype + "', byggemateriale='" + this.byggemateriale + "', standard='" + this.standard + "', antallKvadratmeter=" + this.antallKvadratmeter + ", belopB=" + this.belopB + ", belopI=" + this.belopI + ", bonus=" + this.bonus + ", premie=" + var1.format(this.premie()) + "}";
    }
}
