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
 * Gruppe 57
 *
 * @author Arash Amini s156127
 * @author Suraj Tamrakar s929610
 * @author Lunga Majola
 */
public class Reise extends Forsikring implements Serializable
{

    public String Kunder;
    private String område;
    private int sumf;
    private final Calendar dato;
    private double bouns = 0;

    public Reise(String Kunder, String område, int sumf, int ForsikiringID, double bon)
    {
        super(ForsikiringID);
        this.Kunder = Kunder;
        this.område = område;
        this.sumf = sumf;
        this.dato = Calendar.getInstance();
        this.bouns = bon;
    }

    /**
     *
     * @return
     */
    public String getOmråde()
    {
        return område;
    }

    public void setOmråde(String område)
    {
        this.område = område;
    }

    public int getSumf()
    {
        return sumf;
    }

    public String getDato()
    {
        //Returnere en string som forsikringtiden  forsikring ble skrevet ut
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(dato.getTime());
    }

    public void setSumf(int sumf)
    {
        this.sumf = sumf;
    }

    public int getForsikiringID()
    {
        return super.getForsikiringID();
    }

    public void setForsikiringID(int ForsikiringID)
    {
        super.setForsikiringID(ForsikiringID);
    }

    @Override
    public double premie()
    {

        double sum = sumf;

        double boun = (sumf / 100) * bouns;
        return sum + boun;

    }

    @Override
    public String toString()
    {
        NumberFormat kroneFormat = NumberFormat.getCurrencyInstance();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt = new Formatter();
        fmt.format("%tc", cal);

        return "Reise{" + "omr\u00e5de=" + område + ", sumf=" + sumf
                + kroneFormat.format(premie()) + df.format(dato.getTime()) + fmt + '}';
    }

    @Override
    public int age()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int getForsikringsType()
    {

        return REISE;
    }

}
