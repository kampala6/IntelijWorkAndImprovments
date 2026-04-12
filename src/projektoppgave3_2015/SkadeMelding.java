//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.Serializable;
import java.util.Date;

public class SkadeMelding implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date dato;
    private int skadeNummer;
    private projektoppgave3_2015.TypeSkade typeSkade;
    private String beskrivelse;
    private String vitnerKontaktInfo;
    private double takseringBeløp;
    private double utbetaltErstatningsBeløp;
    private String kobletHusAdresse;
    private String kobletFritidsboligAdresse;
    private String kobletBaatRegistreringsnummer;

    public SkadeMelding(Date var1, projektoppgave3_2015.TypeSkade var2) {
        this.dato = var1;
        this.typeSkade = var2;
    }

    public Date getDato() {
        return this.dato;
    }

    public void setDato(Date var1) {
        this.dato = var1;
    }

    public int getSkadeNummer() {
        return this.skadeNummer;
    }

    public void setSkadeNummer(int var1) {
        this.skadeNummer = var1;
    }

    public projektoppgave3_2015.TypeSkade getTypeSkade() {
        return this.typeSkade;
    }

    public void setTypeSkade(projektoppgave3_2015.TypeSkade var1) {
        this.typeSkade = var1;
    }

    public String getBeskrivelse() {
        return this.beskrivelse;
    }

    public void setBeskrivelse(String var1) {
        this.beskrivelse = var1;
    }

    public String getVitnerKontaktInfo() {
        return this.vitnerKontaktInfo;
    }

    public void setVitnerKontaktInfo(String var1) {
        this.vitnerKontaktInfo = var1;
    }

    public double getTakseringBeløp() {
        return this.takseringBeløp;
    }

    public void setTakseringBeløp(double var1) {
        this.takseringBeløp = var1;
    }

    public double getUtbetaltErstatningsBeløp() {
        return this.utbetaltErstatningsBeløp;
    }

    public void setUtbetaltErstatningsBeløp(double var1) {
        this.utbetaltErstatningsBeløp = var1;
    }

    public String getKobletHusAdresse() {
        return this.kobletHusAdresse;
    }

    public void setKobletHusAdresse(String var1) {
        this.kobletHusAdresse = var1;
    }

    public String getKobletFritidsboligAdresse() {
        return this.kobletFritidsboligAdresse;
    }

    public void setKobletFritidsboligAdresse(String var1) {
        this.kobletFritidsboligAdresse = var1;
    }

    public String getKobletBaatRegistreringsnummer() {
        return this.kobletBaatRegistreringsnummer;
    }

    public void setKobletBaatRegistreringsnummer(String var1) {
        this.kobletBaatRegistreringsnummer = var1;
    }

    public String toString() {
        String var10000 = String.valueOf(this.dato);
        return "SkadeMelding{dato=" + var10000 + ", skadeNummer=" + this.skadeNummer + ", typeSkade=" + String.valueOf(this.typeSkade) + ", beskrivelse='" + this.beskrivelse + "', vitnerKontaktInfo='" + this.vitnerKontaktInfo + "', takseringBeløp=" + this.takseringBeløp + ", utbetaltErstatningsBeløp=" + this.utbetaltErstatningsBeløp + ", kobletHusAdresse='" + this.kobletHusAdresse + "', kobletFritidsboligAdresse='" + this.kobletFritidsboligAdresse + "', kobletBaatRegistreringsnummer='" + this.kobletBaatRegistreringsnummer + "'}";
    }

}
