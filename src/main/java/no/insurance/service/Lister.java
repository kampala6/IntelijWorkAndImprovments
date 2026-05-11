package no.insurance.service;

import no.insurance.model.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Lister implements Serializable {
    private static final long serialVersionUID = 1L;
    private Set<Kunde> kundeListe = new HashSet<>();
    private Set<BaatForsikring> baatForsikringsliste = new HashSet<>();
    private Set<Bilforsikring> bilForsikringsListe = new HashSet<>();
    private Set<FritidsboligForsikiring> fritidsboligForsikiringsListe = new HashSet<>();
    private Set<Husoginnboforsikring> husoginnboforsikringsListe = new HashSet<>();
    private Set<Reise> reisesliste = new HashSet<>();
    private Set<Forsikring> allForsikrings = new HashSet<>();
    private Set<SkadeMelding> skadeMeldinger = new HashSet<>();

    public Lister() {
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public Set<Kunde> getKundeListe() {
        return this.kundeListe;
    }

    public Set<BaatForsikring> getBaatForsikringsliste() {
        return this.baatForsikringsliste;
    }

    /** Correctly spelled replacement for {@link #getBilForsikringsLIste()}. */
    public Set<Bilforsikring> getBilForsikringsListe() {
        return this.bilForsikringsListe;
    }

    /** @deprecated Use {@link #getBilForsikringsListe()} — capital I was a typo. */
    @Deprecated
    public Set<Bilforsikring> getBilForsikringsLIste() {
        return getBilForsikringsListe();
    }

    /** Correctly spelled replacement for {@link #getFritidsboligForsikirings()}. */
    public Set<FritidsboligForsikiring> getFritidsboligForsikringer() {
        return this.fritidsboligForsikiringsListe;
    }

    /** @deprecated Use {@link #getFritidsboligForsikringer()} — "Forsikiring" was a typo. */
    @Deprecated
    public Set<FritidsboligForsikiring> getFritidsboligForsikirings() {
        return getFritidsboligForsikringer();
    }

    public Set<Husoginnboforsikring> getHusoginnboforsikrings() {
        return this.husoginnboforsikringsListe;
    }

    public Set<Reise> getReisesliste() {
        return this.reisesliste;
    }

    public Set<SkadeMelding> getSkadeMeldinger() {
        return this.skadeMeldinger;
    }

    /** Returns all insurances derived from the typed sets (never out of sync). */
    public Set<Forsikring> getAllForsikringer() {
        Set<Forsikring> all = new HashSet<>();
        all.addAll(bilForsikringsListe);
        all.addAll(baatForsikringsliste);
        all.addAll(husoginnboforsikringsListe);
        all.addAll(fritidsboligForsikiringsListe);
        all.addAll(reisesliste);
        return all;
    }

    // ── Customer operations ───────────────────────────────────────────────────

    public boolean leggTilKunde(Kunde var1) {
        return var1 != null && this.kundeListe.add(var1);
    }

    public boolean fjernKunde(int var1) {
        return this.kundeListe.removeIf(k -> k.getKundeNr() == var1);
    }

    public Kunde finnKunder(int var1) {
        for (Kunde var3 : this.kundeListe) {
            if (var3.getKundeNr() == var1) {
                return var3;
            }
        }
        return null;
    }

    public boolean slett(Kunde var1) {
        return var1 != null && this.kundeListe.remove(var1);
    }

    // ── Car insurance operations ──────────────────────────────────────────────

    public boolean leggTilbilForsikring(Bilforsikring var1) {
        return var1 != null && this.bilForsikringsListe.add(var1);
    }

    public String finnBil(String var1) {
        for (Bilforsikring var3 : this.bilForsikringsListe) {
            if (var3.getRegistreringsnummer() == null && var1 == null
                    || var3.getRegistreringsnummer() != null && var3.getRegistreringsnummer().equals(var1)) {
                return var1;
            }
        }
        return null;
    }

    public Bilforsikring finnBilForKunde(int var1, String var2) {
        for (Bilforsikring var4 : this.bilForsikringsListe) {
            if (var4.getKunder() == var1
                    && var4.getRegistreringsnummer() != null
                    && var4.getRegistreringsnummer().equals(var2)) {
                return var4;
            }
        }
        return null;
    }

    // ── Boat insurance operations ─────────────────────────────────────────────

    public boolean leggTilBaatForsikring(BaatForsikring var1) {
        return var1 != null && this.baatForsikringsliste.add(var1);
    }

    /** @deprecated Use {@link #leggTilBaatForsikring(BaatForsikring)} — "Forsikiring" was a typo. */
    @Deprecated
    public boolean leggTilbaatForsikiring(BaatForsikring var1) {
        return leggTilBaatForsikring(var1);
    }

    public String finnBaat(String var1) {
        for (BaatForsikring var3 : this.baatForsikringsliste) {
            if (var3.getRegistreringsnummer() == null && var1 == null
                    || var3.getRegistreringsnummer() != null && var3.getRegistreringsnummer().equals(var1)) {
                return var1;
            }
        }
        return null;
    }

    public BaatForsikring finnBaatForKunde(int var1, String var2) {
        for (BaatForsikring var4 : this.baatForsikringsliste) {
            if (var4.getKunder() == var1
                    && var4.getRegistreringsnummer() != null
                    && var4.getRegistreringsnummer().equals(var2)) {
                return var4;
            }
        }
        return null;
    }

    // ── House insurance operations ────────────────────────────────────────────

    public String finnHus(String var1) {
        for (Husoginnboforsikring var3 : this.husoginnboforsikringsListe) {
            if (var3.getBoligensAdresse() == null && var1 == null
                    || var3.getBoligensAdresse() != null && var3.getBoligensAdresse().equals(var1)) {
                return var1;
            }
        }
        return null;
    }

    public Husoginnboforsikring finnHusForKunde(int var1, String var2) {
        for (Husoginnboforsikring var4 : this.husoginnboforsikringsListe) {
            if (var4.getKunde() == var1
                    && var4.getBoligensAdresse() != null
                    && var4.getBoligensAdresse().equals(var2)) {
                return var4;
            }
        }
        return null;
    }

    public boolean fjernHus(String var1) {
        return var1 != null && this.husoginnboforsikringsListe.removeIf(h -> var1.equals(h.getBoligensAdresse()));
    }

    // ── Leisure property insurance operations ─────────────────────────────────

    public boolean leggTilFritidsboligForsikring(FritidsboligForsikiring var1) {
        return var1 != null && this.fritidsboligForsikiringsListe.add(var1);
    }

    /** @deprecated Use {@link #leggTilFritidsboligForsikring(FritidsboligForsikiring)} — name had two typos. */
    @Deprecated
    public boolean leggTilFridsboligForsikiring(FritidsboligForsikiring var1) {
        return leggTilFritidsboligForsikring(var1);
    }

    public String finnFritidsHus(String var1) {
        for (FritidsboligForsikiring var3 : this.fritidsboligForsikiringsListe) {
            if (var3.getBoligensAdresse() == null && var1 == null
                    || var3.getBoligensAdresse() != null && var3.getBoligensAdresse().equals(var1)) {
                return var1;
            }
        }
        return null;
    }

    public boolean fjernFritidsHus(String var1) {
        return var1 != null && this.fritidsboligForsikiringsListe.removeIf(f -> var1.equals(f.getBoligensAdresse()));
    }

    /** @deprecated Use {@link #fjernFritidsHus(String)}. */
    @Deprecated
    public boolean fjernfritids(String var1) {
        return fjernFritidsHus(var1);
    }

    // ── Travel insurance operations ───────────────────────────────────────────

    public void leggTilReise(Reise var1) {
        if (var1 != null) {
            this.reisesliste.add(var1);
        }
    }

    /** @deprecated Use {@link #leggTilReise(Reise)} — "Riese" was a typo. */
    @Deprecated
    public void leggTilRiese(Reise var1) {
        leggTilReise(var1);
    }

    public boolean reiseListeisEmpty() {
        return this.reisesliste.isEmpty();
    }

    // ── General insurance operations ──────────────────────────────────────────

    public boolean nyForsikring(Forsikring var1) {
        return var1 != null && this.allForsikrings.add(var1);
    }

    // ── Claim operations ──────────────────────────────────────────────────────

    public boolean nySkadeMelding(SkadeMelding var1) {
        return var1 != null && this.skadeMeldinger.add(var1);
    }

    // ── Status checks ─────────────────────────────────────────────────────────

    public boolean husoginnboListeisEmpty() {
        return this.husoginnboforsikringsListe.isEmpty();
    }

    // ── Display / reporting ───────────────────────────────────────────────────

    public String visbiltostring() {
        StringBuilder var1 = new StringBuilder();
        for (Bilforsikring var3 : this.bilForsikringsListe) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    public String viskunde() {
        StringBuilder var1 = new StringBuilder();
        for (Kunde var3 : this.kundeListe) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    public String visbaat() {
        StringBuilder var1 = new StringBuilder();
        for (BaatForsikring var3 : this.baatForsikringsliste) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    public String visHusogInnbo() {
        StringBuilder var1 = new StringBuilder();
        for (Husoginnboforsikring var3 : this.husoginnboforsikringsListe) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    public String visFritidsbo() {
        StringBuilder var1 = new StringBuilder();
        for (FritidsboligForsikiring var3 : this.fritidsboligForsikiringsListe) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    public String visReise() {
        StringBuilder var1 = new StringBuilder();
        for (Reise var3 : this.reisesliste) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    public String visSkadeMeldinger() {
        StringBuilder var1 = new StringBuilder();
        for (SkadeMelding var3 : this.skadeMeldinger) {
            var1.append(var3).append("\n");
        }
        return var1.toString();
    }

    @Override
    public String toString() {
        return this.viskunde();
    }

    // ── File I/O ──────────────────────────────────────────────────────────────

    public void skrivFil(String var1) throws FileNotFoundException {
        try (PrintWriter var2 = new PrintWriter(var1)) {
            for (Kunde var4 : this.kundeListe) {
                var2.println(var4);
            }
        }
    }

    public void skrivbilfil(String var1) throws FileNotFoundException {
        try (PrintWriter var2 = new PrintWriter(var1)) {
            for (Bilforsikring var4 : this.bilForsikringsListe) {
                var2.println(var4);
            }
        }
    }
}
