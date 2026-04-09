package projektoppgave3_2015;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Lister implements Serializable {

    private static final long serialVersionUID = 1L;

    private Set<Kunde> kundeListe;
    private Set<BaatForsikring> baatForsikringsliste;
    private Set<Bilforsikring> bilForsikringsListe;
    private Set<FritidsboligForsikiring> fritidsboligForsikiringsListe;
    private Set<Husoginnboforsikring> husoginnboforsikringsListe;
    private Set<Reise> reisesliste;
    private Set<Forsikring> allForsikrings;
    private Set<SkadeMelding> skadeMeldinger;

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

    public Set<Kunde> getKundeListe() {
        return kundeListe;
    }

    public Set<BaatForsikring> getBaatForsikringsliste() {
        return baatForsikringsliste;
    }

    public Set<Bilforsikring> getBilForsikringsLIste() {
        return bilForsikringsListe;
    }

    public Set<FritidsboligForsikiring> getFritidsboligForsikirings() {
        return fritidsboligForsikiringsListe;
    }

    public Set<Husoginnboforsikring> getHusoginnboforsikrings() {
        return husoginnboforsikringsListe;
    }

    public Set<Reise> getReisesliste() {
        return reisesliste;
    }

    public boolean leggTilKunde(Kunde k) {
        return k != null && kundeListe.add(k);
    }

    public boolean fjernKunde(int knr) {
        Kunde kunde = finnKunder(knr);
        return kunde != null && kundeListe.remove(kunde);
    }

    public Kunde finnKunder(int kunderNr) {
        for (Kunde kunde : kundeListe) {
            if (kunde.getKundeNr() == kunderNr) {
                return kunde;
            }
        }
        return null;
    }

    public String finnBil(String registerNr) {
        for (Bilforsikring bil : bilForsikringsListe) {
            if ((bil.getRegistreringsnummer() == null && registerNr == null) ||
                    (bil.getRegistreringsnummer() != null && bil.getRegistreringsnummer().equals(registerNr))) {
                return registerNr;
            }
        }
        return null;
    }

    public String finnBaat(String registerNr) {
        for (BaatForsikring baat : baatForsikringsliste) {
            if ((baat.getRegistreringsnummer() == null && registerNr == null) ||
                    (baat.getRegistreringsnummer() != null && baat.getRegistreringsnummer().equals(registerNr))) {
                return registerNr;
            }
        }
        return null;
    }

    public String finnHus(String adresse) {
        for (Husoginnboforsikring hus : husoginnboforsikringsListe) {
            if ((hus.getBoligensAdresse() == null && adresse == null) ||
                    (hus.getBoligensAdresse() != null && hus.getBoligensAdresse().equals(adresse))) {
                return adresse;
            }
        }
        return null;
    }

    public boolean fjernHus(String adresse) {
        String funnet = finnHus(adresse);
        if (funnet == null) {
            return false;
        }
        for (Husoginnboforsikring hus : husoginnboforsikringsListe) {
            if (funnet.equals(hus.getBoligensAdresse())) {
                return husoginnboforsikringsListe.remove(hus);
            }
        }
        return false;
    }

    public String finnfritidsHus(String adresse1) {
        for (FritidsboligForsikiring fritids : fritidsboligForsikiringsListe) {
            if ((fritids.getBoligensAdresse() == null && adresse1 == null) ||
                    (fritids.getBoligensAdresse() != null && fritids.getBoligensAdresse().equals(adresse1))) {
                return adresse1;
            }
        }
        return null;
    }

    public boolean fjernfritids(String adresse1) {
        String funnet = finnfritidsHus(adresse1);
        if (funnet == null) {
            return false;
        }
        for (FritidsboligForsikiring fritids : fritidsboligForsikiringsListe) {
            if (funnet.equals(fritids.getBoligensAdresse())) {
                return fritidsboligForsikiringsListe.remove(fritids);
            }
        }
        return false;
    }

    public String leggTilbilForsikring(Bilforsikring b) {
        try {
            boolean ok = bilForsikringsListe.add(b);
            melding("Legt til bilforsikring: " + ok);
            return ok ? "BRA" : "DÅRLIG";
        } catch (Exception e) {
            melding("Feil ved legging av bilforsikring: " + e.getMessage());
            return "FEIL";
        }
    }

    public boolean leggTilbaatForsikiring(BaatForsikring br) {
        return br != null && baatForsikringsliste.add(br);
    }

    public boolean leggTilFridsboligForsikiring(FritidsboligForsikiring f) {
        return f != null && fritidsboligForsikiringsListe.add(f);
    }

    public void leggTilRiese(Reise r) {
        if (r != null) {
            reisesliste.add(r);
        }
    }

    public boolean reiseListeisEmpty() {
        return reisesliste.isEmpty();
    }

    public boolean husoginnboListeisEmpty() {
        return husoginnboforsikringsListe.isEmpty();
    }

    public boolean slett(Kunde k) {
        return k != null && kundeListe.remove(k);
    }

    public String visbiltostring() {
        StringBuilder words = new StringBuilder();
        for (Bilforsikring b : bilForsikringsListe) {
            words.append(b).append("\n");
        }
        return words.toString();
    }

    public String viskunde() {
        StringBuilder text = new StringBuilder();
        for (Kunde k : kundeListe) {
            text.append(k).append("\n");
        }
        return text.toString();
    }

    public String visbaat() {
        StringBuilder text = new StringBuilder();
        for (BaatForsikring b : baatForsikringsliste) {
            text.append(b).append("\n");
        }
        return text.toString();
    }

    public String visHusogInnbo() {
        StringBuilder wr = new StringBuilder();
        for (Husoginnboforsikring h : husoginnboforsikringsListe) {
            wr.append(h).append("\n");
        }
        return wr.toString();
    }

    public String visFritidsbo() {
        StringBuilder ord = new StringBuilder();
        for (FritidsboligForsikiring f : fritidsboligForsikiringsListe) {
            ord.append(f).append("\n");
        }
        return ord.toString();
    }

    @Override
    public String toString() {
        return viskunde();
    }

    public void skrivFil(String filnavn) throws FileNotFoundException {
        try (PrintWriter utfil = new PrintWriter(filnavn)) {
            for (Kunde kunde : kundeListe) {
                utfil.println(kunde);
            }
        }
    }

    public void skrivbilfil(String filnavn) throws FileNotFoundException {
        try (PrintWriter utfil = new PrintWriter(filnavn)) {
            for (Bilforsikring bil : bilForsikringsListe) {
                utfil.println(bil);
            }
        }
    }

    public HashSet<Forsikring> getAllForsikirings() {
        return new HashSet<>(allForsikrings);
    }

    public boolean nyForsikring(Forsikring f) {
        return f != null && allForsikrings.add(f);
    }

    public boolean nySkadeMelding(SkadeMelding sm) {
        return sm != null && skadeMeldinger.add(sm);
    }

    private void melding(String melding) {
        JOptionPane.showMessageDialog(null, melding, "FEILMELDING", JOptionPane.ERROR_MESSAGE);
    }

    public void listAlle(Set<? extends Forsikring> lister, JTextArea utskrift) {
        for (Forsikring obj : lister) {
            utskrift.append(obj.toString() + "\n");
        }
    }

    public void listAllebil(JTextArea b) {
        listAlle(bilForsikringsListe, b);
    }

    public void listAllHusogInnbo(JTextArea h) {
        listAlle(husoginnboforsikringsListe, h);
    }

    public void listAllFriTidhus(JTextArea ft) {
        listAlle(fritidsboligForsikiringsListe, ft);
    }

    public void listAllReise(JTextArea r) {
        listAlle(reisesliste, r);
    }

    public void VisRegister(JTextArea a) {
        a.setText("FORSIKIRINGSREGISTER\n");
        a.append(viskunde());
    }
}