/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

/**
 * @author Mojola
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Gruppe 57
 *
 * @author suraj Tamrakar s156127
 * @author lunga majola s929577
 * @author arash amini s929610
 */
public class Lister implements Serializable {

    private static final long serialVersionUID = 1L;

    private HashSet<Kunde> kundeListe;
    private HashSet<BaatForsikring> baatForsikringsliste;
    private HashSet<Bilforsikring> bilForsikringsListe;
    private HashSet<FritidsboligForsikiring> fritidsboligForsikiringsListe;
    private HashSet<Husoginnboforsikring> husoginnboforsikringsListe;
    private HashSet<Reise> reisesliste;
    private HashSet<Forsikring> allForsikrings;
    private HashSet<SkadeMelding> skadeMeldinger;

    public Lister(HashSet<Kunde> kundeListe, HashSet<BaatForsikring> baatForsikringsliste, HashSet<Bilforsikring> bilForsikringsListe, HashSet<FritidsboligForsikiring> fritidsboligForsikiringsListe, HashSet<Husoginnboforsikring> husoginnboforsikringsListe,
                  HashSet<Forsikring> forsikiringsliste, HashSet<Reise> reisesliste) {
        this.kundeListe = kundeListe;
        this.baatForsikringsliste = baatForsikringsliste;
        this.bilForsikringsListe = bilForsikringsListe;
        this.fritidsboligForsikiringsListe = fritidsboligForsikiringsListe;
        this.husoginnboforsikringsListe = husoginnboforsikringsListe;
        this.reisesliste = reisesliste;

    }

    public Lister() {
        this.kundeListe = new HashSet<>();
        this.baatForsikringsliste = new HashSet<>();
        this.bilForsikringsListe = new HashSet<>();
        this.fritidsboligForsikiringsListe = new HashSet<>();
        this.husoginnboforsikringsListe = new HashSet<>();
        this.reisesliste = new HashSet<>();
        this.allForsikrings = new HashSet<>();
        this.skadeMeldinger = new HashSet<>();

    }

    /**
     * @return
     */
    public HashSet<Kunde> getKundeListe() {
        return kundeListe;
    }

    /**
     * @param kundeListe
     */
    public void setKundeListe(HashSet<Kunde> kundeListe) {
        this.kundeListe = kundeListe;
    }

    /**
     * @return
     */
    public HashSet<BaatForsikring> getBaatForsikringsliste() {
        return baatForsikringsliste;
    }

    /**
     * @param baatForsikringsliste
     */
    public void setBaatForsikringsliste(HashSet<BaatForsikring> baatForsikringsliste) {
        this.baatForsikringsliste = baatForsikringsliste;
    }

    /**
     * @return
     */
    public HashSet<Bilforsikring> getBilForsikringsLIste() {
        return bilForsikringsListe;
    }

    /**
     * @param bilForsikringsLIste
     */
    public void setBilForsikringsLIste(HashSet<Bilforsikring> bilForsikringsLIste) {
        this.bilForsikringsListe = bilForsikringsLIste;
    }

    /**
     * @return
     */
    public HashSet<FritidsboligForsikiring> getFritidsboligForsikirings() {
        return fritidsboligForsikiringsListe;
    }

    /**
     * @param fritidsboligForsikirings
     */
    public void setFritidsboligForsikirings(HashSet<FritidsboligForsikiring> fritidsboligForsikirings) {
        this.fritidsboligForsikiringsListe = fritidsboligForsikirings;
    }

    /**
     * @return
     */
    public HashSet<Husoginnboforsikring> getHusoginnboforsikrings() {
        return husoginnboforsikringsListe;
    }

    /**
     * @param husoginnboforsikrings
     */
    public void setHusoginnboforsikrings(HashSet<Husoginnboforsikring> husoginnboforsikrings) {
        this.husoginnboforsikringsListe = husoginnboforsikrings;
    }

    /**
     * @return reisesliste
     */
    public HashSet<Reise> getReisesliste() {
        return reisesliste;
    }

    /**
     * @param reisesliste
     */
    public void setReisesliste(HashSet<Reise> reisesliste) {
        this.reisesliste = reisesliste;
    }//end of setter and getter

    /**
     * person class skrevet av Suraj eller kode til kunde av suraj Tamaraka
     *
     * @param k
     * @return
     */
    //start før kunder
    public boolean leggTilKunde(Kunde k) {
        return kundeListe.add(k);

    }

    /**
     * fjerner kunder ved å søker først for kunder ved kunderNr of fjern kunder
     * etter på. den er ved å kalle
     *
     * @param Knr
     * @return
     */
    public boolean fjernKunde(int Knr) {

        return kundeListe.remove(finnKunder(Knr));
    }

    /**
     * @param kunderNr Itereator som løper gjennom liste it å finne kunde ved kunder
     *                 number
     * @return
     */
    public Kunde finnKunder(int kunderNr) {
        for (Kunde kunde : kundeListe) {
            if (kunde.getBoatListe().contains(kunderNr)) {
                return kunde;
            }
        }
        return null;
    }
    /*
     public String regbaatpp(int kunderNr,String regnr, Lister reg){
        
     if(finnKunder(kunderNr) !=null){
     if(finnKunder(kunderNr).getBilforsikirng()==0){
     int forsikret = reg.finnBil(regnr).
     }
     }
     }
     *
     //end av kunde class
     //Start av bill class
     /**
     * 
     * @param regnr
     * @return 
     */

    public String finnBil(String registerNr) {
        for (Bilforsikring bilforsikring : bilForsikringsListe) {
            if ((bilforsikring.getRegistrergsnummer() == null && registerNr == null) ||
                    (bilforsikring.getRegistrergsnummer() != null && bilforsikring.getRegistrergsnummer().equals(registerNr))) {
                return registerNr;
            }
        }
        return null;
    }

    /**
     * @param registerNr
     * @return
     */
    public String finnBaat(String registerNr) {

        for (BaatForsikring baatForsikring : baatForsikringsliste) {
            if ((baatForsikring.getRegistrergsnummer() == null && registerNr == null)
                    || (baatForsikring.getRegistrergsnummer() != null && baatForsikring.getRegistrergsnummer().equals(registerNr))) {
                return registerNr;
            }
        }
        return null;
    }

    /**
     * koden under Skrevet av Arash Amini s156127 finne hus ved å likning
     * adresss
     * and modified by lunga
     *
     * @param adresse
     * @return
     */
    public String finnHus(String adresse) {
        for (Husoginnboforsikring husoginnboforsikring : husoginnboforsikringsListe) {
            if ((husoginnboforsikring.getBoligensAdresse() == null && adresse == null)
                    || (husoginnboforsikring.getBoligensAdresse() != null && husoginnboforsikring.getBoligensAdresse().equals(adresse))) {
                return adresse;
            }
        }
        return null;
    }

    /**
     * @param adresse
     * @return
     */
    public boolean fjernHus(String adresse) {

        return husoginnboforsikringsListe.remove(finnHus(adresse));
    }

    public String finnfritidsHus(String adresse1) {
        for (FritidsboligForsikiring fritidsboligForsikiring : fritidsboligForsikiringsListe) {
            if ((fritidsboligForsikiring.getBoligensAdresse() == null && adresse1 == null)
                    || fritidsboligForsikiring.getBoligensAdresse() != null && fritidsboligForsikiring.getBoligensAdresse().equals(adresse1)) {
                return adresse1;
            }
        }
        return null;
    }

    public boolean fjernfritids(String adresse1) {

        return fritidsboligForsikiringsListe.remove(finnfritidsHus(adresse1));
    }

    /**
     * kode av bil skrivet av arash
     *
     * @param b
     * @return
     */
    public String leggTilbilForsikring(Bilforsikring b) {
        try {
            boolean ok = bilForsikringsListe.add(b);
            melding("Legt til bilforsikring: " + ok);
            return ok ? "BRA " : "DÅRLIG";
        } catch (Exception e) {
            melding("Feil ved legging av bilforsikring: " + e.getMessage());
            {
                return "FEIL";
            }
        }


    }

    /**
     * @param br
     * @return
     */
    public boolean leggTilbaatForsikiring(BaatForsikring br) {
        return baatForsikringsliste.add(br);

    }

    /**
     * koden under skrevet av Lunga majola s929577
     *
     * @param forsikring
     * @return
     */
    public String tegnForsikiring(Forsikring forsikring) {

      for (Forsikring forsikring1 : allForsikrings){
          if (forsikring1.equals(forsikring)){
              return "ja";
          }
      }return null;
    }

    /**
     * legger in eller register FritidsboligForsikiring
     *
     * @param f
     * @return
     */
    public boolean leggTilFridsboligForsikiring(FritidsboligForsikiring f) {

       return fritidsboligForsikiringsListe.add(f);

    }

    /**
     * @param h
     */


    /**
     * @param r
     */
    public void leggTilRiese(Reise r) {

        reisesliste.add(r);

        Iterator<Reise> iterator = reisesliste.iterator();
        while (iterator.hasNext()) {
            Reise next = iterator.next();

        }

    }

    /**
     * @return
     */
    public boolean reiseListeisEmpty() {

        reisesliste.isEmpty();
        return false;
    }

    /**
     * @return
     */
    public boolean husoginnboListeisEmpty() {

        husoginnboforsikringsListe.isEmpty();
        return false;

    }

    /**
     * @param k
     * @return
     */
    public boolean slett(Kunde k) {

        kundeListe.remove(k);
        return equals(k);
    }

    /**
     * koden av suraj tamrakar s929610
     *
     * @return
     */
    public String visbiltostring() {

        Iterator<Bilforsikring> to = bilForsikringsListe.iterator();
        StringBuilder words = new StringBuilder();
        while (to.hasNext()) {
            Bilforsikring b = to.next();
            words.append(b.toString());
            words.append("\n");
        }
        return words.toString();

    }

    /**
     * @return
     */
    public String viskunde() {

        Iterator<Kunde> it = kundeListe.iterator();
        StringBuilder text = new StringBuilder();
        while (it.hasNext()) {
            Kunde k = it.next();
            text.append(k.toString());
            text.append("\n");
        }

        return text.toString();
        //kundeListe.getClass() +"@"+kundeListe.toString();
    }

    /**
     * kode av Arash Amini s156127
     *
     * @return
     */
    public String visbaat() {

        Iterator<BaatForsikring> it = baatForsikringsliste.iterator();
        StringBuilder text = new StringBuilder();
        while (it.hasNext()) {
            BaatForsikring b = it.next();
            text.append(b.toString());
            text.append("\n");

        }
        return text.toString();
    }

    //string som viser registere till hus og innboo

    /**
     * @return
     */
    public String visHusogInnbo() {

        Iterator<Husoginnboforsikring> hus = husoginnboforsikringsListe.iterator();
        StringBuilder wr = new StringBuilder();
        while (hus.hasNext()) {
            Husoginnboforsikring h = hus.next();
            wr.append(h.toString());
            wr.append("\n");

        }
        return wr.toString();
    }

    /**
     * under kode skrevet av Lunga majola s929577 retuner tostring for fritidsbo
     * for lister
     *
     * @return
     */
    public String visFritidsbo() {

        Iterator<FritidsboligForsikiring> fri = fritidsboligForsikiringsListe.iterator();
        StringBuilder ord = new StringBuilder();
        while (fri.hasNext()) {
            FritidsboligForsikiring f = fri.next();
            ord.append(f.toString());
            ord.append("\n");
        }
        return ord.toString();
    }

    /**
     * av Lunga Majola s929577
     *
     * @return
     */
    @Override
    public String toString() {
        Iterator<Kunde> iter = kundeListe.iterator();

        String kunder = "";
        while (iter.hasNext()) {
            kunder += iter.next().toString() + "\n";
        }
        return kunder;
    }

    /**
     * av suraj tamrakar s929610
     *
     * @param filnavn
     * @throws FileNotFoundException
     */
    public void skrivFil(String filnavn) throws FileNotFoundException {

        PrintWriter utfil = null;

        try {

            utfil = new PrintWriter(filnavn);

            Iterator<Kunde> iter = kundeListe.iterator();

            while (iter.hasNext()) {

                utfil.println(iter.next().toString());
            }
            utfil.close();
        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Filproblem",
                    "Problem med å skrive fil " + filnavn,
                    JOptionPane.WARNING_MESSAGE);

        }
    }

    public void skrivbilfil(String filnavn) throws FileNotFoundException {

        PrintWriter utfil = null;
        try {
            utfil = new PrintWriter(filnavn);
            Iterator<Bilforsikring> iterb = bilForsikringsListe.iterator();
            while (iterb.hasNext()) {
                utfil.println(iterb.next().toString());
            }
            utfil.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe);
        }
    }

    /**
     * test metode
     *
     * @return
     */
    public boolean totallkunde() {

        allForsikrings = new HashSet<>();

        Iterator<Kunde> iterator = kundeListe.iterator();
        while (iterator.hasNext()) {
            Kunde next = iterator.next();

        }//end of while lo
        return false;
    }

    /**
     * av lunga majola s929577 method som skal brukes til å skive lister
     * historic
     *
     * @param lister
     * @param utskrift
     */
    public void listAlle(HashSet<? extends Forsikring> lister, JTextArea utskrift) {

        Iterator<? extends Forsikring> iter = lister.iterator();
        while (iter.hasNext()) {
            Forsikring obj = iter.next();
            utskrift.append(obj.toString() + "\n");
        }

    }

    /**
     * @return
     */
    public HashSet<Forsikring> getAllForsikirings() {
        return allForsikrings;
    }

    public boolean nyForsikring(Forsikring f) {

        return this.allForsikrings.add(f);
    }

    /**
     * skademelding registereres på gjeldende kunde, under forutsetning at kunde
     * her forsikfing for den aktuelle skadetypen
     *
     * @param sm
     * @return
     */
    public boolean nySkadeMelding(SkadeMelding sm) {

        return this.skadeMeldinger.add(sm);

    }

    private void melding(String melding) {
        JOptionPane.showMessageDialog(null, melding, "FEILMELDING", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * noen metode til å skrive lister til jtextarea denne skrive liste av bil
     *
     * @param b
     */
    public void listAllebil(JTextArea b) {

        listAlle(bilForsikringsListe, b);
    }

    /**
     * @param h
     */
    public void listAllHusogInnbo(JTextArea h) {

        listAlle(husoginnboforsikringsListe, h);
    }

    /**
     * @param ft
     */
    public void listAllFriTidhus(JTextArea ft) {

        listAlle(fritidsboligForsikiringsListe, ft);
    }

    /**
     * ikke implementet
     *
     * @param r
     */
    public void listAllReise(JTextArea r) {

        listAlle(reisesliste, r);
    }

    /**
     * metode til å skrive i jtextaera
     *
     * @param a
     */
    public void VisRegister(JTextArea a) {

        String utskrift = "FORSIKIRINGSREGISTER\n";

    }

}//end of class
