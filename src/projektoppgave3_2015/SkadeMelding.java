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
    private int kundeNr;
    private SkadeObjectType skadeObjectType;
    private TypeSkade typeSkade;
    private String beskrivelse;
    private String vitnerKontaktInfo;
    private double takseringBeløp;
    private double utbetaltErstatningsBeløp;
    private String kobletHusAdresse;
    private String kobletBaatRegistreringsnummer;
    private String kobletBilRegistreringsnummer;

    /**
     * Creates a new claim report.
     *
     * @param var1 claim date
     * @param var2 claim type
     */
    public SkadeMelding(Date var1, TypeSkade var2) {
        this.dato = var1;
        this.typeSkade = var2;
    }

    /**
     * Returns the claim date.
     *
     * @return the claim date
     */
    public Date getDato() {
        return this.dato;
    }

    /**
     * Updates the claim date.
     *
     * @param var1 new claim date
     */
    public void setDato(Date var1) {
        this.dato = var1;
    }

    /**
     * Returns the claim number.
     *
     * @return the claim number
     */
    public int getSkadeNummer() {
        return this.skadeNummer;
    }

    /**
     * Updates the claim number.
     *
     * @param var1 new claim number
     */
    public void setSkadeNummer(int var1) {
        this.skadeNummer = var1;
    }

    /**
     * Returns the customer number attached to the claim.
     *
     * @return the customer number
     */
    public int getKundeNr() {
        return this.kundeNr;
    }

    /**
     * Updates the customer number attached to the claim.
     *
     * @param var1 new customer number
     */
    public void setKundeNr(int var1) {
        this.kundeNr = var1;
    }

    /**
     * Returns the insured object type linked to the claim.
     *
     * @return the insured object type
     */
    public SkadeObjectType getSkadeObjectType() {
        return this.skadeObjectType;
    }

    /**
     * Updates the insured object type linked to the claim.
     *
     * @param var1 new insured object type
     */
    public void setSkadeObjectType(SkadeObjectType var1) {
        this.skadeObjectType = var1;
    }

    /**
     * Returns the claim damage type.
     *
     * @return the damage type
     */
    public TypeSkade getTypeSkade() {
        return this.typeSkade;
    }

    /**
     * Updates the claim damage type.
     *
     * @param var1 new damage type
     */
    public void setTypeSkade(TypeSkade var1) {
        this.typeSkade = var1;
    }

    /**
     * Returns the claim description.
     *
     * @return the claim description
     */
    public String getBeskrivelse() {
        return this.beskrivelse;
    }

    /**
     * Updates the claim description.
     *
     * @param var1 new claim description
     */
    public void setBeskrivelse(String var1) {
        this.beskrivelse = var1;
    }

    /**
     * Returns the witness contact information.
     *
     * @return the witness contact information
     */
    public String getVitnerKontaktInfo() {
        return this.vitnerKontaktInfo;
    }

    /**
     * Updates the witness contact information.
     *
     * @param var1 new witness contact information
     */
    public void setVitnerKontaktInfo(String var1) {
        this.vitnerKontaktInfo = var1;
    }

    /**
     * Returns the assessed amount.
     *
     * @return the assessed amount
     */
    public double getTakseringBeløp() {
        return this.takseringBeløp;
    }

    /**
     * Updates the assessed amount.
     *
     * @param var1 new assessed amount
     */
    public void setTakseringBeløp(double var1) {
        this.takseringBeløp = var1;
    }

    /**
     * Returns the paid compensation amount.
     *
     * @return the paid compensation amount
     */
    public double getUtbetaltErstatningsBeløp() {
        return this.utbetaltErstatningsBeløp;
    }

    /**
     * Updates the paid compensation amount.
     *
     * @param var1 new paid compensation amount
     */
    public void setUtbetaltErstatningsBeløp(double var1) {
        this.utbetaltErstatningsBeløp = var1;
    }

    /**
     * Returns the linked house address.
     *
     * @return the linked house address
     */
    public String getKobletHusAdresse() {
        return this.kobletHusAdresse;
    }

    /**
     * Updates the linked house address.
     *
     * @param var1 new linked house address
     */
    public void setKobletHusAdresse(String var1) {
        this.kobletHusAdresse = var1;
    }

    /**
     * Returns the linked boat registration number.
     *
     * @return the linked boat registration number
     */
    public String getKobletBaatRegistreringsnummer() {
        return this.kobletBaatRegistreringsnummer;
    }

    /**
     * Updates the linked boat registration number.
     *
     * @param var1 new linked boat registration number
     */
    public void setKobletBaatRegistreringsnummer(String var1) {
        this.kobletBaatRegistreringsnummer = var1;
    }

    /**
     * Returns the linked car registration number.
     *
     * @return the linked car registration number
     */
    public String getKobletBilRegistreringsnummer() {
        return this.kobletBilRegistreringsnummer;
    }

    /**
     * Updates the linked car registration number.
     *
     * @param var1 new linked car registration number
     */
    public void setKobletBilRegistreringsnummer(String var1) {
        this.kobletBilRegistreringsnummer = var1;
    }

    /**
     * Returns a printable representation of the claim report.
     *
     * @return formatted claim report text
     */
    public String toString() {
        String var10000 = String.valueOf(this.dato);
        return "SkadeMelding{dato=" + var10000 + ", skadeNummer=" + this.skadeNummer + ", kundeNr=" + this.kundeNr + ", skadeObjectType=" + String.valueOf(this.skadeObjectType) + ", typeSkade=" + String.valueOf(this.typeSkade) + ", beskrivelse='" + this.beskrivelse + "', vitnerKontaktInfo='" + this.vitnerKontaktInfo + "', takseringBeløp=" + this.takseringBeløp + ", utbetaltErstatningsBeløp=" + this.utbetaltErstatningsBeløp + ", kobletHusAdresse='" + this.kobletHusAdresse + "', kobletBaatRegistreringsnummer='" + this.kobletBaatRegistreringsnummer + "', kobletBilRegistreringsnummer='" + this.kobletBilRegistreringsnummer + "'}";
    }

    public enum SkadeObjectType {
        HUS,
        BAAT,
        BIL
    }

    public enum TypeSkade {
        VANN_SKEDE,
        BRANN_SKADE
    }
}
