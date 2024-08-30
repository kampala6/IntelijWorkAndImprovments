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

/**
 * @author suraj Tamrakar
 * @author lungamajola
 */
public abstract class Forsikring
{

    private static final long serialVersionUID = 1L;

    private static int ForsikiringID = 300000;

    private int TOTALKUNDERABATT = 3;//totall nummber av rabatt en kunder kan får

    public static final int BIL = 1, HUS_INNBO = 2, REISE = 3, BAAT = 4, FRITIDSBO = 5;
    private int f_type = 0;

    public abstract double premie();

    //public abstract boolean tatalKunde();
    public abstract String toString();

    public abstract int age();

    //alder som et point 

    public abstract int getForsikringsType();

    /**
     *
     * @param ForsikiringID
     */
    public Forsikring(int ForsikiringID)
    {
        Forsikring.ForsikiringID = ForsikiringID;
    }

    /**
     *
     * @return
     */
    public int getF_type()
    {
        return f_type;
    }

    /**
     *
     * @return
     */
    public int getTOTALKUNDERABATT()
    {
        return TOTALKUNDERABATT;
    }

    /**
     *
     * @param TOTALKUNDERABATT
     */
    public void setTOTALKUNDERABATT(int TOTALKUNDERABATT)
    {
        this.TOTALKUNDERABATT = TOTALKUNDERABATT;
    }

    /**
     *
     * @return
     */
    public int getForsikiringID()
    {
        return ForsikiringID;
    }

    /**
     *
     * @param ForsikiringID
     */
    public void setForsikiringID(int ForsikiringID)
    {
        this.ForsikiringID = ForsikiringID;
    }

}//end of class
