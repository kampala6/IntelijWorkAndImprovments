/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

/**
 *
 * @author lungamajola
 */
/**
 *
 * @author lungamajola
 */
//package projectOppgave.models;
import java.io.Serializable;
import java.util.Date;

public class SkadeMelding implements Serializable
{

    public enum TypeSkade
    {

        VANN_SKEDE,
        BRANN_SKADE,
        //etc...
    }

    private Date dato;
    private int skadeNummer;
    private TypeSkade typeSkade;
    private String beskrivelse;
    private String vitnerKontaktInfo;
    private double takseringBeløp;
    private double utbetaltErstatningsBeløp;

    /**
     *
     * @return dato
     */
    public Date getDato()
    {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(Date dato)
    {
        this.dato = dato;
    }

    /**
     *
     * @return skadeNummer
     */
    public int getSkadeNummer()
    {
        return skadeNummer;
    }

    /**
     *
     * @param skadeNummer
     */
    public void setSkadeNummer(int skadeNummer)
    {
        this.skadeNummer = skadeNummer;
    }

    /**
     *
     * @return
     */
    public TypeSkade getTypeSkade()
    {
        return typeSkade;
    }

    /**
     *
     * @param typeSkade
     */
    public void setTypeSkade(TypeSkade typeSkade)
    {
        this.typeSkade = typeSkade;
    }

    /**
     *
     * @return
     */
    public String getBeskrivelse()
    {
        return beskrivelse;
    }

    /**
     *
     * @param beskrivelse
     */
    public void setBeskrivelse(String beskrivelse)
    {
        this.beskrivelse = beskrivelse;
    }

    /**
     *
     * @return
     */
    public String getVitnerKontaktInfo()
    {
        return vitnerKontaktInfo;
    }

    /**
     *
     * @param vitnerKontaktInfo
     */
    public void setVitnerKontaktInfo(String vitnerKontaktInfo)
    {
        this.vitnerKontaktInfo = vitnerKontaktInfo;
    }

    /**
     *
     * @return
     */
    public double getTakseringBeløp()
    {
        return takseringBeløp;
    }

    /**
     *
     * @param takseringBeløp
     */
    public void setTakseringBeløp(double takseringBeløp)
    {
        this.takseringBeløp = takseringBeløp;
    }

    /**
     *
     * @return
     */
    public double getUtbetaltErstatningsBeløp()
    {
        return utbetaltErstatningsBeløp;
    }

    /**
     *
     * @param utbetaltErstatningsBeløp
     */
    public void setUtbetaltErstatningsBeløp(double utbetaltErstatningsBeløp)
    {
        this.utbetaltErstatningsBeløp = utbetaltErstatningsBeløp;
    }

    /**
     *
     * @param dato
     * @param typeSkade
     */

    public SkadeMelding(Date dato, TypeSkade typeSkade)
    {
        super();
        this.dato = dato;
        this.typeSkade = typeSkade;
    }
}
