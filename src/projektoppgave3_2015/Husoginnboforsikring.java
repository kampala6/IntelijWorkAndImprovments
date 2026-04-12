//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

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

    public int getKunde() {
        return this.kunde;
    }

    public void setKunde(int var1) {
        this.kunde = var1;
    }

    public double premie() {
        return (double)(this.antallKvadratmeter * this.belopB) * ((double)1.0F - this.bonus / (double)100.0F);
    }

    public int getForsikringsType() {
        return 2;
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
        int var10000 = this.kunde;
        return "Husoginnboforsikring{kunde=" + var10000 + ", boligensAdresse='" + this.boligensAdresse + "', byggeaar=" + this.byggeaar + ", boligtype='" + this.boligtype + "', byggemateriale='" + this.byggemateriale + "', standard='" + this.standard + "', antallKvadratmeter=" + this.antallKvadratmeter + ", belopB=" + this.belopB + ", belopI=" + this.belopI + ", bonus=" + this.bonus + ", premie=" + var1.format(this.premie()) + "}";
    }
}
