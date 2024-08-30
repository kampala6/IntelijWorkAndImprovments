/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

import java.io.Serializable;

/**
 *
 * @author lungamajola
 */
public class Adresse implements Serializable
{

    private String gateAdresse;
    private String gateNummer;
    private int postNummer;
    private String by;
    private String land;

    public Adresse(String gateAdresse, String gateNummer, int postNummer,
            String by, String land)
    {
        super();

        this.gateAdresse = gateAdresse;
        this.gateNummer = gateNummer;
        this.postNummer = postNummer;
        this.by = by;
        this.land = land;
    }

    /**
     * @return the gateAdresse
     */
    public String getGateAdresse()
    {
        return gateAdresse;
    }

    /**
     * @param gateAdresse the gateAdresse to set
     */
    public void setGateAdresse(String gateAdresse)
    {
        this.gateAdresse = gateAdresse;
    }

    /**
     * @return the gateNummer
     */
    public String getGateNummer()
    {
        return gateNummer;
    }

    /**
     * @param gateNummer the gateNummer to set
     */
    public void setGateNummer(String gateNummer)
    {
        this.gateNummer = gateNummer;
    }

    /**
     * @return the postNummer
     */
    public int getPostNummer()
    {
        return postNummer;
    }

    /**
     * @param postNummer the postNummer to set
     */
    public void setPostNummer(int postNummer)
    {
        this.postNummer = postNummer;
    }

    /**
     * @return the by
     */
    public String getBy()
    {
        return by;
    }

    /**
     * @param by the by to set
     */
    public void setBy(String by)
    {
        this.by = by;
    }

    /**
     * @return the land
     */
    public String getLand()
    {
        return land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(String land)
    {
        this.land = land;
    }
}
