//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

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

    public Reise(String var1, String var2, int var3, int var4, double var5) {
        super(var4);
        this.kunder = var1;
        this.område = var2;
        this.sumf = var3;
        this.dato = Calendar.getInstance();
        this.bouns = var5;
    }

    public String getOmråde() {
        return this.område;
    }

    public void setOmråde(String var1) {
        this.område = var1;
    }

    public int getSumf() {
        return this.sumf;
    }

    public String getDato() {
        SimpleDateFormat var1 = new SimpleDateFormat("dd.MM.yyyy");
        return ((DateFormat)var1).format(this.dato.getTime());
    }

    public void setSumf(int var1) {
        this.sumf = var1;
    }

    public double premie() {
        double var1 = (double)this.sumf;
        double var3 = (double)(this.sumf / 100) * this.bouns;
        return var1 + var3;
    }

    public String toString() {
        NumberFormat var1 = NumberFormat.getCurrencyInstance();
        SimpleDateFormat var2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Formatter var3 = new Formatter();
        Calendar var4 = Calendar.getInstance();
        var3.format("%tc", var4);
        String var10000 = this.område;
        return "Reise{område=" + var10000 + ", sumf=" + this.sumf + ", premie=" + var1.format(this.premie()) + ", dato=" + ((DateFormat)var2).format(this.dato.getTime()) + ", formattedDate=" + String.valueOf(var3) + "}";
    }

    public int age() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getForsikringsType() {
        return 3;
    }
}
