package projektoppgave3_2015;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public final class Vindutest extends JFrame {

    private static final long serialVersionUID = 1L;

    private final Lister lister = new Lister();
    private final JTextArea utskrift = new JTextArea(25, 60);

    private final JTextField navnFelt = new JTextField(15);
    private final JTextField adresseFelt = new JTextField(15);
    private final JTextField kundeNrFelt = new JTextField(10);

    private final JTextField bilKundeFelt = new JTextField(10);
    private final JTextField bilRegNrFelt = new JTextField(10);
    private final JTextField bilTypeFelt = new JTextField(10);
    private final JTextField bilModellFelt = new JTextField(10);
    private final JTextField bilLengdeFelt = new JTextField(10);
    private final JTextField bilAarFelt = new JTextField(10);
    private final JTextField bilMotorTypeFelt = new JTextField(10);
    private final JTextField bilMotorStyrkeFelt = new JTextField(10);

    private final JTextField husKundeFelt = new JTextField(10);
    private final JTextField husAdresseFelt = new JTextField(15);
    private final JTextField husBoligtypeFelt = new JTextField(10);
    private final JTextField husMaterialeFelt = new JTextField(10);
    private final JTextField husAntallM2Felt = new JTextField(10);
    private final JTextField husBelopBFelt = new JTextField(10);
    private final JTextField husBelopIFelt = new JTextField(10);
    private final JTextField husByggeaarFelt = new JTextField(10);
    private final JTextField husStandardFelt = new JTextField(10);
    private final JTextField husBonusFelt = new JTextField(10);

    private final JTextField friKundeFelt = new JTextField(10);
    private final JTextField friAdresseFelt = new JTextField(15);
    private final JTextField friBoligtypeFelt = new JTextField(10);
    private final JTextField friMaterialeFelt = new JTextField(10);
    private final JTextField friStandardFelt = new JTextField(10);
    private final JTextField friAntallM2Felt = new JTextField(10);
    private final JTextField friBelopBFelt = new JTextField(10);
    private final JTextField friBelopIFelt = new JTextField(10);
    private final JTextField friByggeaarFelt = new JTextField(10);
    private final JTextField friBonusFelt = new JTextField(10);

    private final JButton leggTilKundeBtn = new JButton("Legg til kunde");
    private final JButton finnKundeBtn = new JButton("Finn kunde");
    private final JButton slettKundeBtn = new JButton("Slett kunde");

    private final JButton leggTilBilBtn = new JButton("Legg til bil");
    private final JButton visBilBtn = new JButton("Vis biler");

    private final JButton leggTilHusBtn = new JButton("Legg til hus/innbo");
    private final JButton visHusBtn = new JButton("Vis hus/innbo");

    private final JButton leggTilFriBtn = new JButton("Legg til fritidsbolig");
    private final JButton visFriBtn = new JButton("Vis fritidsbolig");

    private final JButton lagreBtn = new JButton("Lagre");
    private final JButton lastBtn = new JButton("Last");

    public Vindutest() {
        super("Forsikring");

        setLayout(new BorderLayout());
        utskrift.setEditable(false);

        JPanel top = new JPanel(new GridLayout(1, 3));
        top.add(buildKundePanel());
        top.add(buildForsikringPanel());
        top.add(buildFriPanel());

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(utskrift), BorderLayout.CENTER);
        add(buildBottomPanel(), BorderLayout.SOUTH);

        wireEvents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel buildKundePanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Kunde"));

        panel.add(new JLabel("Navn"));
        panel.add(navnFelt);
        panel.add(new JLabel("Adresse"));
        panel.add(adresseFelt);
        panel.add(new JLabel("Kundenr"));
        panel.add(kundeNrFelt);

        panel.add(leggTilKundeBtn);
        panel.add(finnKundeBtn);
        panel.add(slettKundeBtn);
        panel.add(new JLabel());

        return panel;
    }

    private JPanel buildForsikringPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Bilforsikring"));

        panel.add(new JLabel("Kundenr"));
        panel.add(bilKundeFelt);
        panel.add(new JLabel("Reg.nr"));
        panel.add(bilRegNrFelt);
        panel.add(new JLabel("Type"));
        panel.add(bilTypeFelt);
        panel.add(new JLabel("Modell"));
        panel.add(bilModellFelt);
        panel.add(new JLabel("Lengde"));
        panel.add(bilLengdeFelt);
        panel.add(new JLabel("Årsmodell"));
        panel.add(bilAarFelt);
        panel.add(new JLabel("Motor type"));
        panel.add(bilMotorTypeFelt);
        panel.add(new JLabel("Motorstyrke"));
        panel.add(bilMotorStyrkeFelt);
        panel.add(leggTilBilBtn);
        panel.add(visBilBtn);

        panel.add(new JLabel("Hus kundenr"));
        panel.add(husKundeFelt);
        panel.add(new JLabel("Adresse"));
        panel.add(husAdresseFelt);
        panel.add(new JLabel("Boligtype"));
        panel.add(husBoligtypeFelt);
        panel.add(new JLabel("Materiale"));
        panel.add(husMaterialeFelt);
        panel.add(new JLabel("Antall m2"));
        panel.add(husAntallM2Felt);
        panel.add(new JLabel("Beløp B"));
        panel.add(husBelopBFelt);
        panel.add(new JLabel("Beløp I"));
        panel.add(husBelopIFelt);
        panel.add(new JLabel("Byggeår"));
        panel.add(husByggeaarFelt);
        panel.add(new JLabel("Standard"));
        panel.add(husStandardFelt);
        panel.add(new JLabel("Bonus"));
        panel.add(husBonusFelt);
        panel.add(leggTilHusBtn);
        panel.add(visHusBtn);

        return panel;
    }

    private JPanel buildFriPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Fritidsbolig"));

        panel.add(new JLabel("Kundenr"));
        panel.add(friKundeFelt);
        panel.add(new JLabel("Adresse"));
        panel.add(friAdresseFelt);
        panel.add(new JLabel("Boligtype"));
        panel.add(friBoligtypeFelt);
        panel.add(new JLabel("Materiale"));
        panel.add(friMaterialeFelt);
        panel.add(new JLabel("Standard"));
        panel.add(friStandardFelt);
        panel.add(new JLabel("Antall m2"));
        panel.add(friAntallM2Felt);
        panel.add(new JLabel("Beløp B"));
        panel.add(friBelopBFelt);
        panel.add(new JLabel("Beløp I"));
        panel.add(friBelopIFelt);
        panel.add(new JLabel("Byggeår"));
        panel.add(friByggeaarFelt);
        panel.add(new JLabel("Bonus"));
        panel.add(friBonusFelt);
        panel.add(leggTilFriBtn);
        panel.add(visFriBtn);

        return panel;
    }

    private JPanel buildBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(lagreBtn);
        panel.add(lastBtn);
        return panel;
    }

    private void wireEvents() {
        leggTilKundeBtn.addActionListener(e -> leggTilKunde());
        finnKundeBtn.addActionListener(e -> finnKunde());
        slettKundeBtn.addActionListener(e -> slettKunde());

        leggTilBilBtn.addActionListener(e -> leggTilBil());
        visBilBtn.addActionListener(e -> utskrift.setText(lister.visbiltostring()));

        leggTilHusBtn.addActionListener(e -> leggTilHus());
        visHusBtn.addActionListener(e -> utskrift.setText(lister.visHusogInnbo()));

        leggTilFriBtn.addActionListener(e -> leggTilFritidsbolig());
        visFriBtn.addActionListener(e -> utskrift.setText(lister.visFritidsbo()));

        lagreBtn.addActionListener(e -> lagre());
        lastBtn.addActionListener(e -> laste());
    }

    private void leggTilKunde() {
        String navn = navnFelt.getText().trim();
        String adr = adresseFelt.getText().trim();

        if (navn.isEmpty() || adr.isEmpty()) {
            melding("Du må fylle ut navn og adresse");
            return;
        }

        Kunde k = new Kunde(navn, adr, null);
        lister.leggTilKunde(k);

        utskrift.setText("Kunde lagt til:\n" + k);
        kundeNrFelt.setText(String.valueOf(k.getKundeNr()));
        bilKundeFelt.setText(String.valueOf(k.getKundeNr()));
        husKundeFelt.setText(String.valueOf(k.getKundeNr()));
        friKundeFelt.setText(String.valueOf(k.getKundeNr()));

        navnFelt.setText("");
        adresseFelt.setText("");
    }

    private void finnKunde() {
        try {
            int knr = Integer.parseInt(kundeNrFelt.getText().trim());
            Kunde k = lister.finnKunder(knr);
            utskrift.setText(k == null ? "Fant ikke kunde med kundenr: " + knr : k.toString());
        } catch (NumberFormatException ex) {
            melding("Kundenummer må være et tall");
        }
    }

    private void slettKunde() {
        try {
            int knr = Integer.parseInt(kundeNrFelt.getText().trim());
            boolean ok = lister.fjernKunde(knr);
            utskrift.setText(ok ? "Kunde slettet" : "Fant ikke kunde");
        } catch (NumberFormatException ex) {
            melding("Kundenummer må være et tall");
        }
    }

    private void leggTilBil() {
        try {
            int knr = Integer.parseInt(bilKundeFelt.getText().trim());
            String regNr = bilRegNrFelt.getText().trim().toUpperCase();
            String biltype = bilTypeFelt.getText().trim();
            String modell = bilModellFelt.getText().trim();
            int lengde = Integer.parseInt(bilLengdeFelt.getText().trim());
            int aar = Integer.parseInt(bilAarFelt.getText().trim());
            String motortype = bilMotorTypeFelt.getText().trim();
            int motorstyrke = Integer.parseInt(bilMotorStyrkeFelt.getText().trim());

            if (regNr.isEmpty() || biltype.isEmpty() || modell.isEmpty() || motortype.isEmpty()) {
                melding("Fyll ut alle bilfeltene");
                return;
            }

            if (lister.finnBil(regNr) != null) {
                melding("Bil med samme registreringsnummer finnes fra før");
                return;
            }

            Kunde k = lister.finnKunder(knr);
            if (k == null) {
                melding("Fant ikke kunde");
                return;
            }

            Bilforsikring bil = new Bilforsikring(null, knr, regNr, biltype, modell, lengde, aar, motortype, motorstyrke, 0);
            k.leggTilbil(bil);
            k.setBil(bil);
            lister.leggTilbilForsikring(bil);

            utskrift.setText("Bil registrert:\n" + bil);
            clearBilFields();
        } catch (NumberFormatException ex) {
            melding("Tallfeltene for bil er ugyldige");
        }
    }

    private void leggTilHus() {
        try {
            int knr = Integer.parseInt(husKundeFelt.getText().trim());
            String adr = husAdresseFelt.getText().trim();
            String boligtype = husBoligtypeFelt.getText().trim();
            String materiale = husMaterialeFelt.getText().trim();
            int antallM2 = Integer.parseInt(husAntallM2Felt.getText().trim());
            int belopB = Integer.parseInt(husBelopBFelt.getText().trim());
            int belopI = Integer.parseInt(husBelopIFelt.getText().trim());
            int byggeaar = Integer.parseInt(husByggeaarFelt.getText().trim());
            String standard = husStandardFelt.getText().trim();
            int bonus = Integer.parseInt(husBonusFelt.getText().trim());

            if (adr.isEmpty() || boligtype.isEmpty() || materiale.isEmpty() || standard.isEmpty()) {
                melding("Fyll ut alle husfeltene");
                return;
            }

            Kunde k = lister.finnKunder(knr);
            if (k == null) {
                melding("Fant ikke kunde");
                return;
            }

            Husoginnboforsikring hus = new Husoginnboforsikring(knr, adr, boligtype, null, materiale,
                    antallM2, belopB, belopI, byggeaar, standard, 0);
            hus.setBonus(bonus);

            k.addHusForsikring(hus);
            lister.nyForsikring(hus);

            utskrift.setText("Hus/innbo registrert:\n" + hus);
            clearHusFields();
        } catch (NumberFormatException ex) {
            melding("Tallfeltene for hus er ugyldige");
        }
    }

    private void leggTilFritidsbolig() {
        try {
            int knr = Integer.parseInt(friKundeFelt.getText().trim());
            String adr = friAdresseFelt.getText().trim();
            String boligtype = friBoligtypeFelt.getText().trim();
            String materiale = friMaterialeFelt.getText().trim();
            String standard = friStandardFelt.getText().trim();
            int antallM2 = Integer.parseInt(friAntallM2Felt.getText().trim());
            int belopB = Integer.parseInt(friBelopBFelt.getText().trim());
            int belopI = Integer.parseInt(friBelopIFelt.getText().trim());
            int byggeaar = Integer.parseInt(friByggeaarFelt.getText().trim());
            int bonus = Integer.parseInt(friBonusFelt.getText().trim());

            if (adr.isEmpty() || boligtype.isEmpty() || materiale.isEmpty() || standard.isEmpty()) {
                melding("Fyll ut alle fritidsboligfeltene");
                return;
            }

            Kunde k = lister.finnKunder(knr);
            if (k == null) {
                melding("Fant ikke kunde");
                return;
            }

            FritidsboligForsikiring fri = new FritidsboligForsikiring(
                    adr, null, boligtype, materiale, standard,
                    belopI, belopB, byggeaar, antallM2, bonus, 0
            );

            k.addFritidshusForsikring(fri);
            lister.nyForsikring(fri);

            utskrift.setText("Fritidsbolig registrert:\n" + fri);
            clearFriFields();
        } catch (NumberFormatException ex) {
            melding("Tallfeltene for fritidsbolig er ugyldige");
        }
    }

    private void lagre() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lister.txt"))) {
            out.writeObject(lister);
            utskrift.setText("Lagret.");
        } catch (IOException ex) {
            melding("Kunne ikke lagre: " + ex.getMessage());
        }
    }

    private void laste() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("lister.txt"))) {
            Lister loaded = (Lister) in.readObject();
            copyLister(loaded);
            utskrift.setText("Lastet.");
        } catch (IOException | ClassNotFoundException ex) {
            melding("Kunne ikke laste: " + ex.getMessage());
        }
    }

    private void copyLister(Lister loaded) {
        lister.getKundeListe().clear();
        lister.getKundeListe().addAll(loaded.getKundeListe());

        lister.getBaatForsikringsliste().clear();
        lister.getBaatForsikringsliste().addAll(loaded.getBaatForsikringsliste());

        lister.getBilForsikringsLIste().clear();
        lister.getBilForsikringsLIste().addAll(loaded.getBilForsikringsLIste());

        lister.getHusoginnboforsikrings().clear();
        lister.getHusoginnboforsikrings().addAll(loaded.getHusoginnboforsikrings());

        lister.getFritidsboligForsikirings().clear();
        lister.getFritidsboligForsikirings().addAll(loaded.getFritidsboligForsikirings());

        lister.getReisesliste().clear();
        lister.getReisesliste().addAll(loaded.getReisesliste());
    }

    private void clearBilFields() {
        bilKundeFelt.setText("");
        bilRegNrFelt.setText("");
        bilTypeFelt.setText("");
        bilModellFelt.setText("");
        bilLengdeFelt.setText("");
        bilAarFelt.setText("");
        bilMotorTypeFelt.setText("");
        bilMotorStyrkeFelt.setText("");
    }

    private void clearHusFields() {
        husKundeFelt.setText("");
        husAdresseFelt.setText("");
        husBoligtypeFelt.setText("");
        husMaterialeFelt.setText("");
        husAntallM2Felt.setText("");
        husBelopBFelt.setText("");
        husBelopIFelt.setText("");
        husByggeaarFelt.setText("");
        husStandardFelt.setText("");
        husBonusFelt.setText("");
    }

    private void clearFriFields() {
        friKundeFelt.setText("");
        friAdresseFelt.setText("");
        friBoligtypeFelt.setText("");
        friMaterialeFelt.setText("");
        friStandardFelt.setText("");
        friAntallM2Felt.setText("");
        friBelopBFelt.setText("");
        friBelopIFelt.setText("");
        friByggeaarFelt.setText("");
        friBonusFelt.setText("");
    }

    private void melding(String text) {
        JOptionPane.showMessageDialog(this, text, "Feil", JOptionPane.ERROR_MESSAGE);
    }

    public void skrivTilFil() {
        lagre();
    }
}