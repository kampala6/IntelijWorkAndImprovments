package projektoppgave3_2015;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Calendar;

public class Bilforsikring extends Forsikring implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum BilType {
        PERSONBIL,
        LASTBIL,
        ELBIL
    }

    private Calendar dato;
    private int kunder;
    private String registreringsnummer;
    private String biltype;
    private String modell;
    private int lengde;
    private int årsmodell;
    private String motortype;
    private int motorstyrke;
    private double bonus = 0.0;

    public Bilforsikring(Calendar dato,
                         int kunder,
                         String registreringsnummer,
                         String biltype,
                         String modell,
                         int lengde,
                         int årsmodell,
                         String motortype,
                         int motorstyrke,
                         int forsikringId) {
        super(forsikringId);
        this.dato = dato;
        this.kunder = kunder;
        this.registreringsnummer = registreringsnummer;
        this.biltype = biltype;
        this.modell = modell;
        this.lengde = lengde;
        this.årsmodell = årsmodell;
        this.motortype = motortype;
        this.motorstyrke = motorstyrke;
    }

    public Calendar getDatoObjekt() {
        return dato;
    }

    public void setDato(Calendar dato) {
        this.dato = dato;
    }

    public int getKunder() {
        return kunder;
    }

    public void setKunder(int kunder) {
        this.kunder = kunder;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getBiltype() {
        return biltype;
    }

    public void setBiltype(String biltype) {
        this.biltype = biltype;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getLengde() {
        return lengde;
    }

    public void setLengde(int lengde) {
        this.lengde = lengde;
    }

    public int getÅrsmodell() {
        return årsmodell;
    }

    public void setÅrsmodell(int årsmodell) {
        this.årsmodell = årsmodell;
    }

    public String getMotortype() {
        return motortype;
    }

    public void setMotortype(String motortype) {
        this.motortype = motortype;
    }

    public int getMotorstyrke() {
        return motorstyrke;
    }

    public void setMotorstyrke(int motorstyrke) {
        this.motorstyrke = motorstyrke;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double premie() {
        return (motorstyrke * lengde) * (1 - bonus / 100.0);
    }

    @Override
    public int getForsikringsType() {
        return BIL;
    }

    @Override
    public int age() {
        if (dato == null) {
            return 0;
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return Math.max(0, year - årsmodell);
    }

    @Override
    public String toString() {
        NumberFormat kr = NumberFormat.getCurrencyInstance();
        return "Bilforsikring{" +
                "kunde=" + kunder +
                ", registreringsnummer='" + registreringsnummer + '\'' +
                ", biltype='" + biltype + '\'' +
                ", modell='" + modell + '\'' +
                ", lengde=" + lengde +
                ", årsmodell=" + årsmodell +
                ", motortype='" + motortype + '\'' +
                ", motorstyrke=" + motorstyrke +
                ", bonus=" + bonus +
                ", premie=" + kr.format(premie()) +
                '}';
    }
}