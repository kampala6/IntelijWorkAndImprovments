/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

/**
 *
 * @author Mojola
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Formatter;

/**
 * @author suraj Tamrakar
 * @author lungamajola
 */
public class FritidsboligForsikiring extends Forsikring
{

    private String boligensAdresse;
    private int byggeaar = -1;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private int ANTALL_KVADRATMETER = -1;//kan brukes hvis du vill viser are det ikke er string type
    private int belopB = -1;
    private int belopI = -1;
    private double bonus = 0;
    private Calendar dato;

    public FritidsboligForsikiring(int ForsikiringID)
    {
        super(ForsikiringID);

    }

    public FritidsboligForsikiring(String boligensAdresse, Calendar dato, String boligtype, String byggemateriale, String standard,
            int belopI, int belopB, int byggeaar, int Antallk, double boun, int ForsikiringID)
    {
        super(ForsikiringID);
        this.boligensAdresse = boligensAdresse;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.standard = standard;
        this.bonus = boun;
        this.ANTALL_KVADRATMETER = Antallk;
        this.byggeaar = byggeaar;
        this.belopB = belopB;
        this.belopI = belopI;
        this.dato = dato;

    }

    /**
     *
     * @return boligensAdresse.
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
     * @return boligtype.
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
     * @return belopB.
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
     * @return dato
     */
    public Calendar getDato()
    {
        return dato;
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
     * @return super.getForsikiringsID
     */
    public int getForsikiringID()
    {
        return super.getForsikiringID();
    }

    /**
     *
     * @param ForsikiringID
     */
    public void setForsikiringID(int ForsikiringID)
    {
        super.setForsikiringID(ForsikiringID);
    }

    @Override
    public double premie()
    {

        return (belopB * belopI) * (1 - bonus / 100);
    }

    @Override
    // vi har jobbet med den string metode sammen
    public String toString()
    {

        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt = new Formatter();
        fmt.format("%tc", cal);

        NumberFormat KroneFormat = NumberFormat.getCurrencyInstance();
        return "FritidsboligForsikiring"
                + "\nboligensAdresse:" + this.boligensAdresse
                + "\nbyggeaar:" + this.byggeaar
                + "\nboligtype:" + this.boligtype
                + "\nbyggemateriale: " + this.byggemateriale
                + "\nstandard" + this.standard
                + "\nbelopB" + this.belopB + "NOR"
                + "\nbelopI" + this.belopI + "NOR"
                + "\n" + this.ANTALL_KVADRATMETER + "KVM"
                + "\nbonus " + (int) bonus + "%"
                + "\ndato" + this.dato
                + "\nårspremie" + KroneFormat.format(premie())
                + "\n" + fmt;
    }

    @Override
    public int age()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getForsikringsType()
    {
        return HUS_INNBO;
    }

}
