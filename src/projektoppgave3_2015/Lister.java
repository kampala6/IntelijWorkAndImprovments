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

    /**
     * Creates an empty registry for customers, insurances, and claims.
     */
    public Lister() {
    }

    /**
     * Returns the customer set.
     *
     * @return the customer set
     */
    public Set<Kunde> getKundeListe() {
        return this.kundeListe;
    }

    /**
     * Returns the boat insurance set.
     *
     * @return the boat insurance set
     */
    public Set<BaatForsikring> getBaatForsikringsliste() {
        return this.baatForsikringsliste;
    }

    /**
     * Returns the car insurance set.
     *
     * @return the car insurance set
     */
    public Set<Bilforsikring> getBilForsikringsLIste() {
        return this.bilForsikringsListe;
    }

    /**
     * Returns the leisure property insurance set.
     *
     * @return the leisure property insurance set
     */
    public Set<FritidsboligForsikiring> getFritidsboligForsikirings() {
        return this.fritidsboligForsikiringsListe;
    }

    /**
     * Returns the house insurance set.
     *
     * @return the house insurance set
     */
    public Set<Husoginnboforsikring> getHusoginnboforsikrings() {
        return this.husoginnboforsikringsListe;
    }

    /**
     * Returns the travel insurance set.
     *
     * @return the travel insurance set
     */
    public Set<Reise> getReisesliste() {
        return this.reisesliste;
    }

    /**
     * Adds a customer to the registry.
     *
     * @param var1 customer to add
     * @return {@code true} if the customer was added
     */
    public boolean leggTilKunde(Kunde var1) {
        return var1 != null && this.kundeListe.add(var1);
    }

    /**
     * Removes a customer by customer number.
     *
     * @param var1 customer number
     * @return {@code true} if the customer was removed
     */
    public boolean fjernKunde(int var1) {
        Kunde var2 = this.finnKunder(var1);
        return var2 != null && this.kundeListe.remove(var2);
    }

    /**
     * Finds a customer by customer number.
     *
     * @param var1 customer number
     * @return the matching customer, or {@code null} when not found
     */
    public Kunde finnKunder(int var1) {
        for(Kunde var3 : this.kundeListe) {
            if (var3.getKundeNr() == var1) {
                return var3;
            }
        }

        return null;
    }

    /**
     * Finds a car registration number in the registry.
     *
     * @param var1 registration number to search for
     * @return the matching registration number, or {@code null} when not found
     */
    public String finnBil(String var1) {
        for(Bilforsikring var3 : this.bilForsikringsListe) {
            if (var3.getRegistreringsnummer() == null && var1 == null || var3.getRegistreringsnummer() != null && var3.getRegistreringsnummer().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    /**
     * Finds a car insurance for a specific customer and registration number.
     *
     * @param var1 customer number
     * @param var2 registration number
     * @return the matching car insurance, or {@code null} when not found
     */
    public Bilforsikring finnBilForKunde(int var1, String var2) {
        for(Bilforsikring var4 : this.bilForsikringsListe) {
            if (var4.getKunder() == var1 && var4.getRegistreringsnummer() != null && var4.getRegistreringsnummer().equals(var2)) {
                return var4;
            }
        }

        return null;
    }

    /**
     * Finds a boat registration number in the registry.
     *
     * @param var1 registration number to search for
     * @return the matching registration number, or {@code null} when not found
     */
    public String finnBaat(String var1) {
        for(BaatForsikring var3 : this.baatForsikringsliste) {
            if (var3.getRegistreringsnummer() == null && var1 == null || var3.getRegistreringsnummer() != null && var3.getRegistreringsnummer().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    /**
     * Finds a boat insurance for a specific customer and registration number.
     *
     * @param var1 customer number
     * @param var2 registration number
     * @return the matching boat insurance, or {@code null} when not found
     */
    public BaatForsikring finnBaatForKunde(int var1, String var2) {
        for(BaatForsikring var4 : this.baatForsikringsliste) {
            if (var4.getKunder() == var1 && var4.getRegistreringsnummer() != null && var4.getRegistreringsnummer().equals(var2)) {
                return var4;
            }
        }

        return null;
    }

    /**
     * Finds a house address in the registry.
     *
     * @param var1 address to search for
     * @return the matching address, or {@code null} when not found
     */
    public String finnHus(String var1) {
        for(Husoginnboforsikring var3 : this.husoginnboforsikringsListe) {
            if (var3.getBoligensAdresse() == null && var1 == null || var3.getBoligensAdresse() != null && var3.getBoligensAdresse().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    /**
     * Finds a house insurance for a specific customer and address.
     *
     * @param var1 customer number
     * @param var2 address
     * @return the matching house insurance, or {@code null} when not found
     */
    public Husoginnboforsikring finnHusForKunde(int var1, String var2) {
        for(Husoginnboforsikring var4 : this.husoginnboforsikringsListe) {
            if (var4.getKunde() == var1 && var4.getBoligensAdresse() != null && var4.getBoligensAdresse().equals(var2)) {
                return var4;
            }
        }

        return null;
    }

    /**
     * Removes a house insurance by address.
     *
     * @param var1 address to remove
     * @return {@code true} if an entry was removed
     */
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

    /**
     * Finds a leisure property address in the registry.
     *
     * @param var1 address to search for
     * @return the matching address, or {@code null} when not found
     */
    public String finnfritidsHus(String var1) {
        for(FritidsboligForsikiring var3 : this.fritidsboligForsikiringsListe) {
            if (var3.getBoligensAdresse() == null && var1 == null || var3.getBoligensAdresse() != null && var3.getBoligensAdresse().equals(var1)) {
                return var1;
            }
        }

        return null;
    }

    /**
     * Removes a leisure property insurance by address.
     *
     * @param var1 address to remove
     * @return {@code true} if an entry was removed
     */
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

    /**
     * Adds a car insurance to the registry and returns a legacy status string.
     *
     * @param var1 car insurance to add
     * @return legacy result text describing success or failure
     */
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

    /**
     * Adds a boat insurance to the registry.
     *
     * @param var1 boat insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean leggTilbaatForsikiring(BaatForsikring var1) {
        return var1 != null && this.baatForsikringsliste.add(var1);
    }

    /**
     * Adds a leisure property insurance to the registry.
     *
     * @param var1 leisure property insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean leggTilFridsboligForsikiring(FritidsboligForsikiring var1) {
        return var1 != null && this.fritidsboligForsikiringsListe.add(var1);
    }

    /**
     * Adds a travel insurance to the registry.
     *
     * @param var1 travel insurance to add
     */
    public void leggTilRiese(Reise var1) {
        if (var1 != null) {
            this.reisesliste.add(var1);
        }

    }

    /**
     * Indicates whether the travel insurance set is empty.
     *
     * @return {@code true} when no travel insurances are registered
     */
    public boolean reiseListeisEmpty() {
        return this.reisesliste.isEmpty();
    }

    /**
     * Indicates whether the house insurance set is empty.
     *
     * @return {@code true} when no house insurances are registered
     */
    public boolean husoginnboListeisEmpty() {
        return this.husoginnboforsikringsListe.isEmpty();
    }

    /**
     * Removes the given customer instance from the registry.
     *
     * @param var1 customer to remove
     * @return {@code true} if the customer was removed
     */
    public boolean slett(Kunde var1) {
        return var1 != null && this.kundeListe.remove(var1);
    }

    /**
     * Returns all car insurances as plain text.
     *
     * @return formatted car insurance text
     */
    public String visbiltostring() {
        StringBuilder var1 = new StringBuilder();

        for(Bilforsikring var3 : this.bilForsikringsListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Returns all customers as plain text.
     *
     * @return formatted customer text
     */
    public String viskunde() {
        StringBuilder var1 = new StringBuilder();

        for(Kunde var3 : this.kundeListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Returns all boat insurances as plain text.
     *
     * @return formatted boat insurance text
     */
    public String visbaat() {
        StringBuilder var1 = new StringBuilder();

        for(BaatForsikring var3 : this.baatForsikringsliste) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Returns all house insurances as plain text.
     *
     * @return formatted house insurance text
     */
    public String visHusogInnbo() {
        StringBuilder var1 = new StringBuilder();

        for(Husoginnboforsikring var3 : this.husoginnboforsikringsListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Returns all leisure property insurances as plain text.
     *
     * @return formatted leisure property insurance text
     */
    public String visFritidsbo() {
        StringBuilder var1 = new StringBuilder();

        for(FritidsboligForsikiring var3 : this.fritidsboligForsikiringsListe) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Returns all travel insurances as plain text.
     *
     * @return formatted travel insurance text
     */
    public String visReise() {
        StringBuilder var1 = new StringBuilder();

        for(Reise var3 : this.reisesliste) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Returns the same content as {@link #viskunde()}.
     *
     * @return formatted customer text
     */
    public String toString() {
        return this.viskunde();
    }

    /**
     * Writes all customers to a text file.
     *
     * @param var1 output file path
     * @throws FileNotFoundException if the file cannot be opened for writing
     */
    public void skrivFil(String var1) throws FileNotFoundException {
        try (PrintWriter var2 = new PrintWriter(var1)) {
            for(Kunde var4 : this.kundeListe) {
                var2.println(var4);
            }
        }

    }

    /**
     * Writes all car insurances to a text file.
     *
     * @param var1 output file path
     * @throws FileNotFoundException if the file cannot be opened for writing
     */
    public void skrivbilfil(String var1) throws FileNotFoundException {
        try (PrintWriter var2 = new PrintWriter(var1)) {
            for(Bilforsikring var4 : this.bilForsikringsListe) {
                var2.println(var4);
            }
        }

    }

    /**
     * Returns a defensive copy of all registered insurances.
     *
     * @return a copy of the insurance set
     */
    public HashSet<Forsikring> getAllForsikirings() {
        return new HashSet(this.allForsikrings);
    }

    /**
     * Adds a generic insurance to the master insurance set.
     *
     * @param var1 insurance to add
     * @return {@code true} if the insurance was added
     */
    public boolean nyForsikring(Forsikring var1) {
        return var1 != null && this.allForsikrings.add(var1);
    }

    /**
     * Adds a claim report to the registry.
     *
     * @param var1 claim report to add
     * @return {@code true} if the claim was added
     */
    public boolean nySkadeMelding(SkadeMelding var1) {
        return var1 != null && this.skadeMeldinger.add(var1);
    }

    /**
     * Returns the claim report set.
     *
     * @return the claim report set
     */
    public Set<SkadeMelding> getSkadeMeldinger() {
        return this.skadeMeldinger;
    }

    /**
     * Returns all claim reports as plain text.
     *
     * @return formatted claim report text
     */
    public String visSkadeMeldinger() {
        StringBuilder var1 = new StringBuilder();

        for(SkadeMelding var3 : this.skadeMeldinger) {
            var1.append(var3).append("\n");
        }

        return var1.toString();
    }

    /**
     * Shows a dialog message.
     *
     * @param var1 message text
     */
    private void melding(String var1) {
        JOptionPane.showMessageDialog((Component)null, var1, "FEILMELDING", 0);
    }

    /**
     * Appends all insurances from a set to a text area.
     *
     * @param var1 insurance set to list
     * @param var2 destination text area
     */
    public void listAlle(Set<? extends Forsikring> var1, JTextArea var2) {
        for(Forsikring var4 : var1) {
            var2.append(var4.toString() + "\n");
        }

    }

    /**
     * Appends all car insurances to a text area.
     *
     * @param var1 destination text area
     */
    public void listAllebil(JTextArea var1) {
        this.listAlle(this.bilForsikringsListe, var1);
    }

    /**
     * Appends all house insurances to a text area.
     *
     * @param var1 destination text area
     */
    public void listAllHusogInnbo(JTextArea var1) {
        this.listAlle(this.husoginnboforsikringsListe, var1);
    }

    /**
     * Appends all leisure property insurances to a text area.
     *
     * @param var1 destination text area
     */
    public void listAllFriTidhus(JTextArea var1) {
        this.listAlle(this.fritidsboligForsikiringsListe, var1);
    }

    /**
     * Appends all travel insurances to a text area.
     *
     * @param var1 destination text area
     */
    public void listAllReise(JTextArea var1) {
        this.listAlle(this.reisesliste, var1);
    }

    /**
     * Displays the insurance register header and customer list in a text area.
     *
     * @param var1 destination text area
     */
    public void VisRegister(JTextArea var1) {
        var1.setText("FORSIKIRINGSREGISTER\n");
        var1.append(this.viskunde());
    }
}
