/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

/**
 * Gruppe 57
 *
 * @author Amini Arash s156127
 * @author suraj Tamrakar s929577
 * @author lunga majola s929610
 */

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;

public class BaatForsikring extends Forsikring implements Serializable {

    public enum BåtType {

        PERSON_BÅT,
        STOR_BÅT,
        CRUISE_BÅT
    }

    private Calendar dato;
    public String Kunder;

    private String registrergsnummer;
    private String baattype, modell;
    private int lengde;
    private int årsmodell;
    private final String motortype;
    private int motorstyrk;
    private double bonus = 0;
    private int kunder = 0;

    public BaatForsikring(Calendar dato, String regnr1, String baattype, String modell,
                          int lengde, int årsmodell, String motortype, int motorstyrk, double boun, int ForsikiringID, double b) {
        super(ForsikiringID);
        this.dato = dato;

        this.registrergsnummer = regnr1;
        this.baattype = baattype;
        this.modell = modell;
        this.lengde = lengde;
        this.årsmodell = årsmodell;
        this.motortype = motortype;
        this.motorstyrk = motorstyrk;
        this.bonus = boun;

    }//end of konstrator

    /**
     * retunerer registeringsnumer
     *
     * @return
     */
    public String getRegistrergsnummer() {
        return registrergsnummer;
    }

    /**
     * @param dato
     */
    public void setDato(Calendar dato) {
        this.dato = dato;
    }

    /**
     * @return kunder
     */
    public String getKundeNr() {
        return Kunder;
    }

    /**
     * @param kundeNr
     */
    public void setKunder(int kundeNr) {
        this.kunder = kundeNr++;
    }

    /**
     * @return baattype
     */
    public String getBaattype() {
        return baattype;
    }

    /**
     * @param baattype
     */
    public void setBaattype(String baattype) {
        this.baattype = baattype;
    }

    /**
     * @return modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * @param modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * @return lengde
     */
    public int getLengde() {
        return lengde;
    }

    /**
     * @param lengde
     */
    public void setLengde(int lengde) {
        this.lengde = lengde;
    }

    /**
     * @return årsmodell
     */
    public int getÅrsmodell() {
        return årsmodell;
    }

    /**
     * @param årsmodell
     */
    public void setÅrsmodell(int årsmodell) {
        this.årsmodell = årsmodell;
    }

    /**
     * @return motorstyrkk
     */
    public int getMotorstyrk() {
        return motorstyrk;
    }

    /**
     * @param motorstyrk
     */
    public void setMotorstyrk(int motorstyrk) {
        this.motorstyrk = motorstyrk;
    }

    /**
     * @return bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * @param nydato
     */
    public void setCalendar(Calendar nydato) {
        dato = nydato;
    }

    /**
     * @return premie etter regning
     */
    public double premie() {

        return (motorstyrk * lengde) * (1 - bonus / 100);

    }

    /**
     * @return Dato
     */
    public String getDato() {
        //Returnere en string som forsikringtiden  forsikring ble skrevet ut
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(dato.getTime());
    }

    /**
     * @return ForsikiringType
     */
    public int getForsikringsType() {
        return 4;
    }

    /**
     * @return linjen
     */
    public Object[] getTabelllinje() {

        Object[] linjen =
                {
                        getDato(), baattype, registrergsnummer, modell, lengde,
                        motorstyrk, motortype, bonus
                };

        return linjen;

    }

    /**
     * tostring metode som
     *
     * @return
     */
    public String toString() {

        NumberFormat kroneFormat = NumberFormat.getCurrencyInstance();
        //DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("%tc", cal);

        return "BaatForsikring" + "Eier" + this.Kunder
                + "\nregistrergsnummer" + this.registrergsnummer
                + "\nbaattype" + this.baattype
                + "\nmodell" + this.modell
                + "\nlengde" + this.lengde + "FOT"
                + "\u00e5rsmodell" + this.årsmodell + //skrives på den måte fordi programme kjerner ikke Norsk boksstaver
                "\nmotortype " + this.motortype
                + "\nmotorstyrk" + this.motorstyrk + "HORSE POWER"
                + "\nbonus" + (int) this.bonus + "%"
                + "\nårlig premie"
                + "Dato utksrevet og kostnad: "
                + kroneFormat.format(premie()) + fmt + '}';

    }

    /**
     * age
     *
     * @return
     */
    public int age() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//end of class
