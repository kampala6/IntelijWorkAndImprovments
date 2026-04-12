//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Lister implements Serializable {
    private static final long serialVersionUID = 1L;
    private Set<Kunde> kundeListe = new HashSet();
    private Set<BaatForsikring> baatForsikringsliste = new HashSet();
    private Set<Bilforsikring> bilForsikringsListe = new HashSet();
    private Set<FritidsboligForsikiring> fritidsboligForsikiringsListe = new HashSet();
    private Set<Husoginnboforsikring> husoginnboforsikringsListe = new HashSet();
    private Set<Reise> reisesliste = new HashSet();
    private Set<Forsikring> allForsikrings = new HashSet();
    private Set<SkadeMelding> skadeMeldinger = new HashSet();

    public Lister() {
    }

    public Set<Kunde> getKundeListe() {
        return this.kundeListe;
    }

    public Set<BaatForsikring> getBaatForsikringsliste() {
        return this.baatForsikringsliste;
    }

    public Set<Bilforsikring> getBilForsikringsLIste() {
        return this.bilForsikringsListe;
    }

    public Set<FritidsboligForsikiring> getFritidsboligForsikirings() {
        return this.fritidsboligForsikiringsListe;
    }

    public Set<Husoginnboforsikring> getHusoginnboforsikrings() {
        return this.husoginnboforsikringsListe;
    }

    public Set<Reise> getReisesliste() {
        return this.reisesliste;
    }

    public boolean leggTilKunde(Kunde var1) {
        return var1 != null && this.kundeListe.add(var1);
    }

    public boolean fjernKunde(int var1) {
        Kunde var2 = this.finnKunder(var1);
        return var2 != null && this.kundeListe.remove(var2);
    }

    public Kunde finnKunder(int var1) {
        for(Kunde var3 : this.kundeListe) {
            if (var3.getKundeNr() == var1) {
                return var3;
            }
        }

        return null;
    }

    public String finnBil(String var1) {
        for(Bilforsikring var3 : this.bilForsikringsListe) {
            if (var3.getRegistreringsnummer() == null && var1 == null || var3.getRegistreringsnummer() != null && var3.getRegistreringsnummer().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    public String finnBaat(String var1) {
        for(BaatForsikring var3 : this.baatForsikringsliste) {
            if (var3.getRegistreringsnummer() == null && var1 == null || var3.getRegistreringsnummer() != null && var3.getRegistreringsnummer().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    public String finnHus(String var1) {
        for(Husoginnboforsikring var3 : this.husoginnboforsikringsListe) {
            if (var3.getBoligensAdresse() == null && var1 == null || var3.getBoligensAdresse() != null && var3.getBoligensAdresse().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    public boolean fjernHus(String var1) {
        String var2 = this.finnHus(var1);
        if (var2 == null) {
            return false;
        } else {
            for(Husoginnboforsikring var4 : this.husoginnboforsikringsListe) {
                if (var2.equals(var4.getBoligensAdresse())) {
                    return this.husoginnboforsikringsListe.remove(var4);
                }
            }

            return false;
        }
    }

    public String finnfritidsHus(String var1) {
        for(FritidsboligForsikiring var3 : this.fritidsboligForsikiringsListe) {
            if (var3.getBoligensAdresse() == null && var1 == null || var3.getBoligensAdresse() != null && var3.getBoligensAdresse().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    public boolean fjernfritids(String var1) {
        String var2 = this.finnfritidsHus(var1);
        if (var2 == null) {
            return false;
        } else {
            for(FritidsboligForsikiring var4 : this.fritidsboligForsikiringsListe) {
                if (var2.equals(var4.getBoligensAdresse())) {
                    return this.fritidsboligForsikiringsListe.remove(var4);
                }
            }

            return false;
        }
    }

    public String leggTilbilForsikring(Bilforsikring var1) {
        try {
            boolean var2 = this.bilForsikringsListe.add(var1);
            this.melding("Legt til bilforsikring: " + var2);
            return var2 ? "BRA" : "DÅRLIG";
        } catch (Exception var3) {
            this.melding("Feil ved legging av bilforsikring: " + var3.getMessage());
            return "FEIL";
        }
    }

    public boolean leggTilbaatForsikiring(BaatForsikring var1) {
        return var1 != null && this.baatForsikringsliste.add(var1);
    }

    public boolean leggTilFridsboligForsikiring(FritidsboligForsikiring var1) {
        return var1 != null && this.fritidsboligForsikiringsListe.add(var1);
    }

    public void leggTilRiese(Reise var1) {
        if (var1 != null) {
            this.reisesliste.add(var1);
        }

    }

    public boolean reiseListeisEmpty() {
        return this.reisesliste.isEmpty();
    }

    public boolean husoginnboListeisEmpty() {
        return this.husoginnboforsikringsListe.isEmpty();
    }

    public boolean slett(Kunde var1) {
        return var1 != null && this.kundeListe.remove(var1);
    }

    public String visbiltostring() {
        StringBuilder var1 = new StringBuilder();

        for(Bilforsikring var3 : this.bilForsikringsListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    public String viskunde() {
        StringBuilder var1 = new StringBuilder();

        for(Kunde var3 : this.kundeListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    public String visbaat() {
        StringBuilder var1 = new StringBuilder();

        for(BaatForsikring var3 : this.baatForsikringsliste) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    public String visHusogInnbo() {
        StringBuilder var1 = new StringBuilder();

        for(Husoginnboforsikring var3 : this.husoginnboforsikringsListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    public String visFritidsbo() {
        StringBuilder var1 = new StringBuilder();

        for(FritidsboligForsikiring var3 : this.fritidsboligForsikiringsListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    public String toString() {
        return this.viskunde();
    }

    public void skrivFil(String var1) throws FileNotFoundException {
        try (PrintWriter var2 = new PrintWriter(var1)) {
            for(Kunde var4 : this.kundeListe) {
                var2.println(var4);
            }
        }

    }

    public void skrivbilfil(String var1) throws FileNotFoundException {
        try (PrintWriter var2 = new PrintWriter(var1)) {
            for(Bilforsikring var4 : this.bilForsikringsListe) {
                var2.println(var4);
            }
        }

    }

    public HashSet<Forsikring> getAllForsikirings() {
        return new HashSet(this.allForsikrings);
    }

    public boolean nyForsikring(Forsikring var1) {
        return var1 != null && this.allForsikrings.add(var1);
    }

    public boolean nySkadeMelding(SkadeMelding var1) {
        return var1 != null && this.skadeMeldinger.add(var1);
    }

    public Set<SkadeMelding> getSkadeMeldinger() {
        return this.skadeMeldinger;
    }

    public String visSkadeMeldinger() {
        StringBuilder var1 = new StringBuilder();

        for(SkadeMelding var3 : this.skadeMeldinger) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    private void melding(String var1) {
        JOptionPane.showMessageDialog((Component)null, var1, "FEILMELDING", 0);
    }

    public void listAlle(Set<? extends Forsikring> var1, JTextArea var2) {
        for(Forsikring var4 : var1) {
            var2.append(var4.toString() + "\n");
        }

    }

    public void listAllebil(JTextArea var1) {
        this.listAlle(this.bilForsikringsListe, var1);
    }

    public void listAllHusogInnbo(JTextArea var1) {
        this.listAlle(this.husoginnboforsikringsListe, var1);
    }

    public void listAllFriTidhus(JTextArea var1) {
        this.listAlle(this.fritidsboligForsikiringsListe, var1);
    }

    public void listAllReise(JTextArea var1) {
        this.listAlle(this.reisesliste, var1);
    }

    public void VisRegister(JTextArea var1) {
        var1.setText("FORSIKIRINGSREGISTER\n");
        var1.append(this.viskunde());
    }
}
