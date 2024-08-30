/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Gruppe 57
 *
 * @author Arash Amini s156127
 * @author ssuraj Tamrakar s929610
 * @author lungamajola s929577
 */
public class Kunde implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private String navn;
    private String fakturaAdresse;
    private final int KundeNr;
    private static int nesteNr = 00000;
    private Calendar dato;
    private boolean hasBoatInsurance, hasCarInsurance;
    private int insuranceCount = 0;
    private double premieRatio = 0.0;
    private int Bilforsikirng, Hus, riese, fritidshus = 0;
    private BilForsikring bil = null;
    private final HashSet<BilForsikring> bilListe;
    private final HashSet<BaatForsikring> boatListe;
    private final HashSet<Husoginnboforsikring> husListe;
    private final HashSet<FritidsboligForsikiring> fitidhusListe;
    private final HashSet<Reise> rieseListe;
    // private int nesterNr;

    public Kunde(String navn, String fakturaAdresse, Calendar dato) {
        this.navn = navn;
        this.fakturaAdresse = fakturaAdresse;
        this.KundeNr = nesteNr;
        this.dato = dato;
        nesteNr++;
        bilListe = new HashSet<>();
        boatListe = new HashSet<>();
        husListe = new HashSet<>();
        fitidhusListe = new HashSet<>();
        rieseListe = new HashSet<>();

    }

    /**
     * @return
     */
    public BilForsikring getBil() {
        return bil;
    }

    /**
     * @param bil
     */
    public void setBil(BilForsikring bil) {
        this.bil = bil;
    }

    /**
     * @return PremieRatio
     */
    public double getPremieRatio() {
        return premieRatio;
    }

    /**
     * @param premieRatio
     */
    public void setPremieRatio(double premieRatio) {
        this.premieRatio = premieRatio;
    }

    /**
     * @return
     */
    public int getInsuranceCount() {
        return insuranceCount;
    }

    /**
     * @param insuranceCount
     */
    public void setInsuranceCount(int insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

    /**
     * @return
     */
    public boolean HasBoatInsurance() {
        return hasBoatInsurance;
    }

    /**
     * @param hasBoatInsurance
     */
    public void setHasBoatInsurance(boolean hasBoatInsurance) {
        this.hasBoatInsurance = hasBoatInsurance;
    }

    /**
     * @return HasCarInsurance
     */
    public boolean HasCarInsurance() {
        return hasCarInsurance;
    }

    /**
     * @param hasCarInsurance
     */
    public void setHasCarInsurance(boolean hasCarInsurance) {
        this.hasCarInsurance = hasCarInsurance;
    }

    /**
     * @return navn
     */
    public String getNavn() {
        return navn;
    }

    /**
     * @param navn
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * @return FakturaAdresse
     */
    public String getFakturaAdresse() {
        return fakturaAdresse;
    }

    /**
     * @param fakturaAdresse
     */
    public void setFakturaAdresse(String fakturaAdresse) {
        this.fakturaAdresse = fakturaAdresse;
    }

    /**
     * @return kunderNr
     */
    public int getKundeNr() {
        return KundeNr;
    }

    /**
     * @param KundeNr
     */
    public void setKundeNr(int KundeNr) {
        nesteNr = KundeNr;
    }

    /**
     * @return
     */
    public int getNesteNr() {
        return nesteNr;
    }

    /**
     * @return
     */
    public int getBilforsikirng() {
        return Bilforsikirng;
    }

    /**
     * @param Bilforsikirng
     */
    public void setBilforsikirng(int Bilforsikirng) {
        this.Bilforsikirng = Bilforsikirng;
    }

    /**
     * @return
     */
    public int getHus() {
        return Hus;
    }

    /**
     * @param Hus
     */
    public void setHus(int Hus) {
        this.Hus = Hus;
    }

    /**
     * @return
     */
    public int getRiese() {
        return riese;
    }

    /**
     * @param riese
     */
    public void setRiese(int riese) {
        this.riese = riese;
    }

    /**
     * @return
     */
    public int getFritidshus() {
        return fritidshus;
    }

    /**
     * @param fritidshus
     */
    public void setFritidshus(int fritidshus) {
        this.fritidshus = fritidshus;
    }

    /**
     * @return
     */
    public HashSet<BaatForsikring> getBoatListe() {
        return boatListe;
    }//end of hashset,getBoatListe

    /**
     * @return
     */
    public String getDato() {

        DateFormat df = new SimpleDateFormat("dd.MM.ÅÅÅÅ");

        return df.format(dato.getTime());

    }//end gatedato

    /**
     * @param b
     * @return
     */
    public boolean leggTilbil(BilForsikring b) {
        return bilListe.add(b);
    }//end of leggTilbil

    /**
     * @param h
     * @return
     */
    public boolean addHusForsikring(Husoginnboforsikring h) {
        return husListe.add(h);
    }//end of addhus

    /**
     * @param f
     * @return
     */
    public boolean addFritidshusForsikring(FritidsboligForsikiring f) {
        return fitidhusListe.add(f);
    }//end of addFritidshus

    /**
     * @param r
     * @return
     */
    public String addReise(Reise r) {

        boolean ok = rieseListe.add(r);

        if (ok) {
            //sjekker hvis en hus er registerert
            return "bra";
        } else {
            return "dårlig";// tillbakmelding hvis det gikk ikke
        }
    }//end of addResise

    /**
     * @param ba
     * @return
     */
    public String addBaat(BaatForsikring ba) {

        if (ba == null) {
            return "Error: The boat insurace object is empty";
        }
        boolean okAdded = boatListe.add(ba); //sjekker hvis en hus er registerert
        if (okAdded) {
            return "ALL is good";
        } else {
            return "DiD not fine you";
        }

        // tillbakmelding hvis det gikk ikke
    }//end of addBaat

    /**
     * @param adresse1
     * @return
     */
    public String finnfritidsHus(String adresse1) {
        Logger logger = Logger.getLogger("FritidsHusLogger");
        Iterator<FritidsboligForsikiring> iterator = fitidhusListe.iterator();// løper gjenomm liste
        while (iterator.hasNext()) {// Check if there is a next element
            FritidsboligForsikiring fh = iterator.next();//if yes then get the next element
            if (fh.getBoligensAdresse() == null ? adresse1 == null : fh.getBoligensAdresse().equals(adresse1)) {
                logger.info("fritidsHus found: " + adresse1);
                return adresse1;
            }
        }
        try {
            logger.info("fritidsHus not found: " + adresse1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }//end of finnfritiHus

    /**
     * setter tid i sanntid
     *
     * @return
     */
    public String toString() {

        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt = new Formatter();
        fmt.format("%tc", cal);

        return "kunderNr: " + KundeNr + "\nNavn: " + navn + "\nFakturaAdresse: " + fakturaAdresse + "\n" + fmt + "\nDu er registeret for forsikiring: \n";

    }//end of tosting

    private static class BilForsikring {

        public BilForsikring() {
        }
    }
}// slutt av class kunde
