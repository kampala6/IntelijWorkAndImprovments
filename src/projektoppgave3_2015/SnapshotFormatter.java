//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class SnapshotFormatter {
    public SnapshotFormatter() {
    }

    public String formatLegacyCustomerText(String var1) {
        String var2 = this.normalizeTextForDisplay(var1);
        if (var2.isEmpty()) {
            return "";
        } else {
            ArrayList var3 = new ArrayList();
            StringBuilder var4 = new StringBuilder();

            for(String var8 : var2.split("\\n")) {
                String var9 = var8.trim();
                if (var9.startsWith("kunderNr:") && !var4.isEmpty()) {
                    var3.add(var4.toString().trim());
                    var4.setLength(0);
                }

                if (!var9.isEmpty()) {
                    var4.append(var9).append("\n");
                }
            }

            if (!var4.isEmpty()) {
                var3.add(var4.toString().trim());
            }

            if (var3.isEmpty()) {
                return var2;
            } else {
                StringBuilder var10 = new StringBuilder();

                for(int var11 = 0; var11 < var3.size(); ++var11) {
                    var10.append("Kunde ").append(var11 + 1).append("\n");
                    var10.append("--------------------\n");
                    var10.append((String)var3.get(var11));
                    if (var11 < var3.size() - 1) {
                        var10.append("\n\n");
                    }
                }

                return var10.toString();
            }
        }
    }

    public String buildListerTextSnapshot(Lister var1) {
        StringBuilder var2 = new StringBuilder();
        this.appendSection(var2, "Kunder", var1.viskunde());
        this.appendSection(var2, "Biler", var1.visbiltostring());
        this.appendSection(var2, "Hus/innbo", var1.visHusogInnbo());
        this.appendSection(var2, "Fritidsbolig", var1.visFritidsbo());
        this.appendSection(var2, "Skademeldinger", var1.visSkadeMeldinger());
        return var2.toString().trim() + "\n";
    }

    public String formatSectionEntries(String var1) {
        String var2 = this.normalizeTextForDisplay(var1);
        if (var2.isEmpty()) {
            return "";
        } else {
            StringBuilder var3 = new StringBuilder();

            for(String var7 : var2.split("\\n")) {
                String var8 = var7.trim();
                if (!var8.isEmpty()) {
                    if (!var3.isEmpty()) {
                        var3.append("\n\n");
                    }

                    var3.append(this.formatEntryForDisplay(var8));
                }
            }

            return var3.toString().trim();
        }
    }

    public String normalizeTextForDisplay(String var1) {
        if (var1 == null) {
            return "";
        } else {
            String var2 = var1.replace("\r\n", "\n").replace('\r', '\n').trim();
            var2 = var2.replaceAll("\n{3,}", "\n\n");
            return var2;
        }
    }

    private void appendSection(StringBuilder var1, String var2, String var3) {
        var1.append("-- ").append(var2).append(" --\n");
        String var4 = this.formatSectionEntries(var3);
        var1.append(var4.isEmpty() ? "Ingen data" : var4).append("\n\n");
    }

    private String formatEntryForDisplay(String var1) {
        String var2 = var1.trim().replace("'", "");
        int var3 = var2.indexOf(123);
        int var4 = var2.lastIndexOf(125);
        if (var3 >= 0) {
            String var5 = var2.substring(0, var3).trim();
            String var6 = var2.substring(var3 + 1, var4 > var3 ? var4 : var2.length()).trim();
            return var6.isEmpty() ? var5 : this.formatFieldsForType(var5, this.parseDisplayFields(var6));
        } else {
            return var2;
        }
    }

    private Map<String, String> parseDisplayFields(String var1) {
        LinkedHashMap var2 = new LinkedHashMap();

        for(String var6 : var1.split(",\\s*")) {
            int var7 = var6.indexOf(61);
            if (var7 > 0 && var7 < var6.length() - 1) {
                var2.put(var6.substring(0, var7).trim(), var6.substring(var7 + 1).trim());
            }
        }

        return var2;
    }

    private String formatFieldsForType(String var1, Map<String, String> var2) {
        ArrayList var3 = new ArrayList();
        switch (var1) {
            case "Kunde":
                this.appendDisplayField(var3, "kunderNr", (String)var2.get("kundeNr"));
                this.appendDisplayField(var3, "Navn", (String)var2.get("navn"));
                this.appendDisplayField(var3, "FakturaAdresse", (String)var2.get("fakturaAdresse"));
                this.appendDisplayField(var3, "Dato", (String)var2.get("dato"));
                break;
            case "Bilforsikring":
                this.appendDisplayField(var3, "kunderNr", this.firstNonBlank((String)var2.get("kunder"), (String)var2.get("kunde")));
                this.appendDisplayField(var3, "Registreringsnummer", (String)var2.get("registreringsnummer"));
                this.appendDisplayField(var3, "Biltype", (String)var2.get("biltype"));
                this.appendDisplayField(var3, "Modell", (String)var2.get("modell"));
                this.appendDisplayField(var3, "Lengde", (String)var2.get("lengde"));
                this.appendDisplayField(var3, "Arsmodell", this.firstNonBlank((String)var2.get("årsmodell"), (String)var2.get("arsmodell")));
                this.appendDisplayField(var3, "Motortype", (String)var2.get("motortype"));
                this.appendDisplayField(var3, "Motorstyrke", (String)var2.get("motorstyrke"));
                this.appendDisplayField(var3, "Bonus", (String)var2.get("bonus"));
                this.appendDisplayField(var3, "Premie", (String)var2.get("premie"));
                break;
            case "Husoginnboforsikring":
                this.appendDisplayField(var3, "kunderNr", (String)var2.get("kunde"));
                this.appendDisplayField(var3, "BoligensAdresse", (String)var2.get("boligensAdresse"));
                this.appendDisplayField(var3, "Byggeaar", (String)var2.get("byggeaar"));
                this.appendDisplayField(var3, "Boligtype", (String)var2.get("boligtype"));
                this.appendDisplayField(var3, "Byggemateriale", (String)var2.get("byggemateriale"));
                this.appendDisplayField(var3, "Standard", (String)var2.get("standard"));
                this.appendDisplayField(var3, "AntallKvadratmeter", (String)var2.get("antallKvadratmeter"));
                this.appendDisplayField(var3, "BelopB", (String)var2.get("belopB"));
                this.appendDisplayField(var3, "BelopI", (String)var2.get("belopI"));
                this.appendDisplayField(var3, "Bonus", (String)var2.get("bonus"));
                this.appendDisplayField(var3, "Premie", (String)var2.get("premie"));
                break;
            case "FritidsboligForsikiring":
                this.appendDisplayField(var3, "BoligensAdresse", (String)var2.get("boligensAdresse"));
                this.appendDisplayField(var3, "Byggeaar", (String)var2.get("byggeaar"));
                this.appendDisplayField(var3, "Boligtype", (String)var2.get("boligtype"));
                this.appendDisplayField(var3, "Byggemateriale", (String)var2.get("byggemateriale"));
                this.appendDisplayField(var3, "Standard", (String)var2.get("standard"));
                this.appendDisplayField(var3, "AntallKvadratmeter", (String)var2.get("antallKvadratmeter"));
                this.appendDisplayField(var3, "BelopB", (String)var2.get("belopB"));
                this.appendDisplayField(var3, "BelopI", (String)var2.get("belopI"));
                this.appendDisplayField(var3, "Bonus", (String)var2.get("bonus"));
                this.appendDisplayField(var3, "Premie", (String)var2.get("premie"));
                break;
            case "SkadeMelding":
                this.appendDisplayField(var3, "Dato", (String)var2.get("dato"));
                this.appendDisplayField(var3, "SkadeNummer", (String)var2.get("skadeNummer"));
                this.appendDisplayField(var3, "TypeSkade", (String)var2.get("typeSkade"));
                this.appendDisplayField(var3, "Beskrivelse", (String)var2.get("beskrivelse"));
                this.appendDisplayField(var3, "VitnerKontaktInfo", (String)var2.get("vitnerKontaktInfo"));
                this.appendDisplayField(var3, "TakseringBelop", this.firstNonBlank((String)var2.get("takseringBeløp"), (String)var2.get("takseringBelop")));
                this.appendDisplayField(var3, "UtbetaltErstatningsBelop", this.firstNonBlank((String)var2.get("utbetaltErstatningsBeløp"), (String)var2.get("utbetaltErstatningsBelop")));
                this.appendDisplayField(var3, "KobletHusAdresse", (String)var2.get("kobletHusAdresse"));
                this.appendDisplayField(var3, "KobletFritidsboligAdresse", (String)var2.get("kobletFritidsboligAdresse"));
                this.appendDisplayField(var3, "KobletBaatRegistreringsnummer", (String)var2.get("kobletBaatRegistreringsnummer"));
                break;
            default:
                for(Map.Entry var7 : var2.entrySet()) {
                    this.appendDisplayField(var3, this.toDisplayLabel((String)var7.getKey()), (String)var7.getValue());
                }
        }

        return String.join("\n", var3).trim();
    }

    private void appendDisplayField(List<String> var1, String var2, String var3) {
        if (var3 != null) {
            String var4 = var3.trim();
            if (!var4.isEmpty() && !"null".equalsIgnoreCase(var4)) {
                var1.add(var2 + ": " + var4);
            }
        }
    }

    private String firstNonBlank(String... var1) {
        for(String var5 : var1) {
            if (var5 != null && !var5.trim().isEmpty() && !"null".equalsIgnoreCase(var5.trim())) {
                return var5;
            }
        }

        return null;
    }

    private String toDisplayLabel(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            switch (var1) {
                case "kundeNr":
                case "kunder":
                case "kunde":
                    return "kunderNr";
                case "navn":
                    return "Navn";
                case "fakturaAdresse":
                    return "Fakturaadresse";
                case "dato":
                    return "Dato";
                case "insuranceCount":
                    return "Antall forsikringer";
                case "premieRatio":
                    return "Premieforhold";
                case "registreringsnummer":
                    return "Registreringsnummer";
                case "biltype":
                    return "Biltype";
                case "modell":
                    return "Modell";
                case "lengde":
                    return "Lengde";
                case "årsmodell":
                case "arsmodell":
                    return "Arsmodell";
                case "motortype":
                    return "Motortype";
                case "motorstyrke":
                    return "Motorstyrke";
                case "bonus":
                    return "Bonus";
                case "boligensAdresse":
                    return "Boligens adresse";
                case "byggeaar":
                    return "Byggeaar";
                case "boligtype":
                    return "Boligtype";
                case "byggemateriale":
                    return "Byggemateriale";
                case "standard":
                    return "Standard";
                case "antallKvadratmeter":
                    return "Antall kvadratmeter";
                case "belopB":
                    return "Belop B";
                case "belopI":
                    return "Belop I";
                case "premie":
                    return "Premie";
                default:
                    return this.humanizeLabelKey(var1);
            }
        } else {
            return "";
        }
    }

    private String humanizeLabelKey(String var1) {
        String var2 = var1.replace('_', ' ').replaceAll("([a-z])([A-Z])", "$1 $2").trim();
        if (var2.isEmpty()) {
            return var1;
        } else {
            char var10000 = Character.toUpperCase(var2.charAt(0));
            return var10000 + var2.substring(1);
        }
    }
}
