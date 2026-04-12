//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.Serializable;

public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String gateAdresse;
    private String gateNummer;
    private int postNummer;
    private String by;
    private String land;

    public Adresse(String var1, String var2, int var3, String var4, String var5) {
        this.gateAdresse = var1;
        this.gateNummer = var2;
        this.postNummer = var3;
        this.by = var4;
        this.land = var5;
    }

    public String getGateAdresse() {
        return this.gateAdresse;
    }

    public void setGateAdresse(String var1) {
        this.gateAdresse = var1;
    }

    public String getGateNummer() {
        return this.gateNummer;
    }

    public void setGateNummer(String var1) {
        this.gateNummer = var1;
    }

    public int getPostNummer() {
        return this.postNummer;
    }

    public void setPostNummer(int var1) {
        this.postNummer = var1;
    }

    public String getBy() {
        return this.by;
    }

    public void setBy(String var1) {
        this.by = var1;
    }

    public String getLand() {
        return this.land;
    }

    public void setLand(String var1) {
        this.land = var1;
    }

    public String toString() {
        return this.gateAdresse + " " + this.gateNummer + ", " + this.postNummer + " " + this.by + ", " + this.land;
    }
}
