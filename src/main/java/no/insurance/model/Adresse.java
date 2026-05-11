//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.model;

import java.io.Serializable;

public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String gateAdresse;
    private String gateNummer;
    private int postNummer;
    private String by;
    private String land;

    /**
     * Creates a new address instance.
     *
     * @param var1 street name
     * @param var2 street number
     * @param var3 postal code
     * @param var4 city name
     * @param var5 country name
     */
    public Adresse(String var1, String var2, int var3, String var4, String var5) {
        this.gateAdresse = var1;
        this.gateNummer = var2;
        this.postNummer = var3;
        this.by = var4;
        this.land = var5;
    }

    /**
     * Returns the street name.
     *
     * @return the street name
     */
    public String getGateAdresse() {
        return this.gateAdresse;
    }

    /**
     * Updates the street name.
     *
     * @param var1 new street name
     */
    public void setGateAdresse(String var1) {
        this.gateAdresse = var1;
    }

    /**
     * Returns the street number.
     *
     * @return the street number
     */
    public String getGateNummer() {
        return this.gateNummer;
    }

    /**
     * Updates the street number.
     *
     * @param var1 new street number
     */
    public void setGateNummer(String var1) {
        this.gateNummer = var1;
    }

    /**
     * Returns the postal code.
     *
     * @return the postal code
     */
    public int getPostNummer() {
        return this.postNummer;
    }

    /**
     * Updates the postal code.
     *
     * @param var1 new postal code
     */
    public void setPostNummer(int var1) {
        this.postNummer = var1;
    }

    /**
     * Returns the city name.
     *
     * @return the city name
     */
    public String getBy() {
        return this.by;
    }

    /**
     * Updates the city name.
     *
     * @param var1 new city name
     */
    public void setBy(String var1) {
        this.by = var1;
    }

    /**
     * Returns the country name.
     *
     * @return the country name
     */
    public String getLand() {
        return this.land;
    }

    /**
     * Updates the country name.
     *
     * @param var1 new country name
     */
    public void setLand(String var1) {
        this.land = var1;
    }

    /**
     * Returns a printable representation of the address.
     *
     * @return formatted address text
     */
    public String toString() {
        return this.gateAdresse + " " + this.gateNummer + ", " + this.postNummer + " " + this.by + ", " + this.land;
    }
}
