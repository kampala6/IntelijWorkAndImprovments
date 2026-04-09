package projektoppgave3_2015;

import java.io.Serializable;
import java.util.Date;

public class SkadeMelding implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum TypeSkade {
        VANN_SKADE,
        BRANN_SKADE
    }

    private Date dato;
    private int skadeNummer;
    private TypeSkade typeSkade;
    private String beskrivelse;
    private String vitnerKontaktInfo;
    private double takseringBeløp;
    private double utbetaltErstatningsBeløp;

    public SkadeMelding(Date dato, TypeSkade typeSkade) {
        this.dato = dato;
        this.typeSkade = typeSkade;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public int getSkadeNummer() {
        return skadeNummer;
    }

    public void setSkadeNummer(int skadeNummer) {
        this.skadeNummer = skadeNummer;
    }

    public TypeSkade getTypeSkade() {
        return typeSkade;
    }

    public void setTypeSkade(TypeSkade typeSkade) {
        this.typeSkade = typeSkade;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getVitnerKontaktInfo() {
        return vitnerKontaktInfo;
    }

    public void setVitnerKontaktInfo(String vitnerKontaktInfo) {
        this.vitnerKontaktInfo = vitnerKontaktInfo;
    }

    public double getTakseringBeløp() {
        return takseringBeløp;
    }

    public void setTakseringBeløp(double takseringBeløp) {
        this.takseringBeløp = takseringBeløp;
    }

    public double getUtbetaltErstatningsBeløp() {
        return utbetaltErstatningsBeløp;
    }

    public void setUtbetaltErstatningsBeløp(double utbetaltErstatningsBeløp) {
        this.utbetaltErstatningsBeløp = utbetaltErstatningsBeløp;
    }

    @Override
    public String toString() {
        return "SkadeMelding{" +
                "dato=" + dato +
                ", skadeNummer=" + skadeNummer +
                ", typeSkade=" + typeSkade +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", vitnerKontaktInfo='" + vitnerKontaktInfo + '\'' +
                ", takseringBeløp=" + takseringBeløp +
                ", utbetaltErstatningsBeløp=" + utbetaltErstatningsBeløp +
                '}';
    }
}