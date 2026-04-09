package projektoppgave3_2015;

import java.io.Serializable;

public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gateAdresse;
    private String gateNummer;
    private int postNummer;
    private String by;
    private String land;

    public Adresse(String gateAdresse, String gateNummer, int postNummer, String by, String land) {
        this.gateAdresse = gateAdresse;
        this.gateNummer = gateNummer;
        this.postNummer = postNummer;
        this.by = by;
        this.land = land;
    }

    public String getGateAdresse() {
        return gateAdresse;
    }

    public void setGateAdresse(String gateAdresse) {
        this.gateAdresse = gateAdresse;
    }

    public String getGateNummer() {
        return gateNummer;
    }

    public void setGateNummer(String gateNummer) {
        this.gateNummer = gateNummer;
    }

    public int getPostNummer() {
        return postNummer;
    }

    public void setPostNummer(int postNummer) {
        this.postNummer = postNummer;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public String toString() {
        return gateAdresse + " " + gateNummer + ", " + postNummer + " " + by + ", " + land;
    }
}