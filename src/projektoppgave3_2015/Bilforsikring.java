/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektoppgave3_2015;

/**
 * @author lungamajola
 */

import java.io.Serializable;
import java.util.Calendar;
import java.text.NumberFormat;
import java.util.Formatter;

public class Bilforsikring extends Forsikring implements Serializable {


    public enum BilType {
        PERSONBIL,
        LASTBIL,
        ELBIL;
    }

    private Calendar dato;
    public int kunder;

    private String registrergsnummer;


    private String bilttype, modell;
    private int lengde;
    private int årsmodell;
    private final String biltype;
    private int motorstyrk;
    private double bonus = 0;
    private int kunderNum = 0;

    public Bilforsikring(Calendar dato, int kunder, String registrergsnummer, String bilttype, String modell, int lengde,
                         int årsmodell, String biltype, int motorstyrk, int ForsikiringID) {

        super(ForsikiringID);
        this.dato = dato;

        this.kunder = kunder;
        this.registrergsnummer = registrergsnummer;
        this.bilttype = bilttype;
        this.modell = modell;
        this.lengde = lengde;
        this.årsmodell = årsmodell;
        this.biltype = biltype;
        this.motorstyrk = motorstyrk;
    }


    public int getKunder() {
        return kunder;
    }

    public String getRegistrergsnummer() {
        return registrergsnummer;
    }

    public String getBilttype() {
        return bilttype;
    }

    public String getModell() {
        return modell;
    }

    public int getLengde() {
        return lengde;
    }

    public int getÅrsmodell() {
        return årsmodell;
    }

    public String getBiltype() {
        return biltype;
    }

    public int getMotorstyrk() {
        return motorstyrk;
    }

    public double getBonus() {
        return bonus;
    }

    public int getKunderNum() {
        return kunderNum;
    }

    public static int getBIL() {
        return BIL;
    }

    public void setDato(Calendar dato) {
        this.dato = dato;
    }

    public void setKunder(int kunder) {
        this.kunder = kunder;
    }


    public void setRegistrergsnummer(String registrergsnummer) {
        this.registrergsnummer = registrergsnummer;
    }

    public void setBilttype(String bilttype) {
        this.bilttype = bilttype;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getForsikringsType() {
        return 4;
    }

    public void setLengde(int lengde) {
        this.lengde = lengde;
    }

    public void setÅrsmodell(int årsmodell) {
        this.årsmodell = årsmodell;
    }

    public void setMotorstyrk(int motorstyrk) {
        this.motorstyrk = motorstyrk;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setKunderNum(int kunderNum) {
        this.kunderNum = kunderNum;
    }

    public double premie() {

        return (motorstyrk * lengde) * (1 - bonus / 100);

    }

    public int age() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose 
    }

    @Override
    public String toString() {
        NumberFormat kroneFormat = NumberFormat.getCurrencyInstance();
        //DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("%tc", cal);

        return "Bilforsikring{" + "dato=" + dato + ", kunder="
                + kunder + ", registrergsnummer=" + registrergsnummer + ", bilttype="
                + bilttype + ", modell=" + modell + ", lengde=" + lengde + ", \u00e5rsmodell="
                + årsmodell + ", biltype=" + biltype + ", motorstyrk=" + motorstyrk
                + ", bonus=" + bonus + ", kunderNum=" + kunderNum + "Dato utksrevet og kostnad"
                + kroneFormat.format(premie()) + fmt + '}';

    }


}//end of class
