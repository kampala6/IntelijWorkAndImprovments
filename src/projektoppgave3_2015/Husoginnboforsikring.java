/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;

/**
 * @author suraj Tamrakar
 * @author lungamajola
 * @author Arash Amini
 */
public class Husoginnboforsikring extends Forsikring implements Serializable
{

    private String boligensAdresse;
    private int byggeaar = -1;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private final int ANTALL_KVADRATMETER;
    private int belopB = -1;
    private int belopI = -1;
    private double bonus = 0;
    private Calendar dato;
    private int kunde;

    public Husoginnboforsikring(int kunde, String boligensAdresse, String boligtype, Calendar dato, String byggemateriale,
            int antallk, int b, int i, int byggeaar, String standard, int ForsikiringID)
    {
        super(ForsikiringID);
        this.boligensAdresse = boligensAdresse;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.standard = standard;
        this.ANTALL_KVADRATMETER = antallk;
        this.belopB = b;
        this.belopI = i;
        this.dato = dato;
        this.kunde = kunde;
    }//end of KOnstractor

    /**
     *
     * @return
     */
    public String getBoligensAdresse()
    {
        return boligensAdresse;
    }

    /**
     *
     * @param boligensAdresse
     */
    public void setBoligensAdresse(String boligensAdresse)
    {
        this.boligensAdresse = boligensAdresse;
    }

    /**
     *
     * @return byggeaar
     */
    public int getByggeaar()
    {
        return byggeaar;
    }

    /**
     *
     * @param byggeaar
     */
    public void setByggeaar(int byggeaar)
    {
        this.byggeaar = byggeaar;
    }

    /**
     *
     * @return boligtype
     */
    public String getBoligtype()
    {
        return boligtype;
    }

    /**
     *
     * @param boligtype
     */
    public void setBoligtype(String boligtype)
    {
        this.boligtype = boligtype;
    }

    /**
     *
     * @return byggemateriale
     */
    public String getByggemateriale()
    {
        return byggemateriale;
    }

    /**
     *
     * @param byggemateriale
     */
    public void setByggemateriale(String byggemateriale)
    {
        this.byggemateriale = byggemateriale;
    }

    /**
     *
     * @return standard
     */
    public String getStandard()
    {
        return standard;
    }

    /**
     *
     * @param standard
     */
    public void setStandard(String standard)
    {
        this.standard = standard;
    }

    /**
     *
     * @return belopB
     */
    public int getBelopB()
    {
        return belopB;
    }

    /**
     *
     * @param belopB
     */
    public void setBelopB(int belopB)
    {
        this.belopB = belopB;
    }

    /**
     *
     * @return belopI
     */
    public int getBelopI()
    {
        return belopI;
    }

    /**
     *
     * @param belopI
     */
    public void setBelopI(int belopI)
    {
        this.belopI = belopI;
    }

    /**
     *
     * @return bonus
     */
    public double getBonus()
    {
        return bonus;
    }

    /**
     *
     * @param bonus
     */
    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

    /**
     *
     * @param dato
     */

    public void setDato(Calendar dato)
    {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    @Override
    public double premie()
    {

        return (ANTALL_KVADRATMETER * belopB) * (1 - bonus / 100);
    }

    /**
     *
     * @return
     */
    public int getForsikringsType()
    {

        return 2;
    }

    /**
     * skulle retuner dato format
     *
     * @return
     */

    public String getDato()
    {

        DateFormat df = new SimpleDateFormat("dd.MM.ÅÅÅÅ");

        return df.format(dato.getTime());

    }

    /**
     * String set till hus // datafelter
     *
     * @return
     */
    public String toString()
    {

        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt = new Formatter();
        fmt.format("%tc", cal);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        NumberFormat KroneFormat = NumberFormat.getCurrencyInstance();

        return "Hus_og_innboforsikring: "
                + "\nboligensAdresse: " + this.boligensAdresse
                + "\nbyggeaar: " + this.byggeaar
                + "\nboligtype: " + this.boligtype
                + "\nbyggemateriale: " + this.byggemateriale
                + "\nstandard  " + this.standard
                + "\nbelopB: " + this.belopB + "NOR"
                + "\nbelopI: " + this.belopI + "NOR"
                + "\nbonus: " + (int) bonus + "%"
                + "\nAntall_kvardratmeter: " + this.ANTALL_KVADRATMETER + "kvm"
                + "\n" + KroneFormat.format(premie())
                + "\n" + fmt;

    }

    /**
     *
     * @return
     */
    @Override
    public int age()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//end of cløass
