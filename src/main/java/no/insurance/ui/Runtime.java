package no.insurance.ui;

import java.io.Serial;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.LookAndFeelInfo;
import no.insurance.model.*;
import no.insurance.service.*;

public final class Runtime extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Lister lister = new Lister();
    private final SnapshotFormatter snapshotFormatter = new SnapshotFormatter();
    private final PersistenceService persistenceService = new PersistenceService("lister.txt", "lister.ser");

    private final JTabbedPane tabbedPane = new JTabbedPane();

    // ── Kunde tab ─────────────────────────────────────────────────────────────
    JTextField Navnfelt    = new JTextField();
    JTextArea  Adressefelt = new JTextArea(3, 15);
    JButton    regKunde    = new JButton("Registrer Kunde");
    JButton    exitKunde   = new JButton("Exit");

    private DefaultTableModel kundeModel;
    private JTable            kundeTable;

    // ── Bil tab ───────────────────────────────────────────────────────────────
    JTextField KundeNrfeltb    = new JTextField("12345");
    JTextField biltypefelt     = new JTextField("Sedan");
    JTextField regarfelt       = new JTextField("2023");
    JTextField regnrfelt       = new JTextField("ABC123");
    JTextField kjorelengdeFelt = new JTextField("5000");
    JTextField bonusfelt       = new JTextField("0.0");
    JTextField modellfelt      = new JTextField("2023");
    JTextField lengdefelt1     = new JTextField("0");
    JComboBox<String> bilTypeCombo = new JComboBox<>(new String[]{"Sedan","SUV","Kombi","Coupe","Pickup"});

    JButton addBilBtn  = new JButton("Add New");
    JButton saveBilBtn = new JButton("Save");
    JButton viewBilBtn = new JButton("View");
    JButton exitBilBtn = new JButton("Exit");

    private DefaultTableModel bilModel;
    private JTable            bilTable;

    // ── Baat tab ──────────────────────────────────────────────────────────────
    JTextField kunderNrfelt1  = new JTextField("12345");
    JTextField regnumfelt     = new JTextField("B001");
    JTextField baatypefelt    = new JTextField("Seilbåt");
    JTextField modellfelt1    = new JTextField("Model X");
    JTextField lengdefelt     = new JTextField("8");
    JTextField arsmodellFelt  = new JTextField("2022");
    JTextField motorstyrkfelt = new JTextField("50");
    JTextField motortypefelt  = new JTextField("Diesel");
    JTextField bonusfelf2     = new JTextField("0.0");

    JButton addBaatBtn  = new JButton("Add New");
    JButton saveBaatBtn = new JButton("Save");
    JButton viewBaatBtn = new JButton("View");
    JButton exitBaatBtn = new JButton("Exit");

    private DefaultTableModel baatModel;
    private JTable            baatTable;

    // ── Hus tab ───────────────────────────────────────────────────────────────
    JTextField husKundeNrFelt   = new JTextField("0");
    JTextField husAdresseFelt   = new JTextField("Eksempel gate 1");
    JTextField husBoligtypeFelt = new JTextField("Enebolig");
    JTextField husMaterialFelt  = new JTextField("Tre");
    JTextField husStandardFelt  = new JTextField("Standard");
    JTextField husByggeaarFelt  = new JTextField("1995");
    JTextField husKvmFelt       = new JTextField("150");
    JTextField husBelopBFelt    = new JTextField("5000");
    JTextField husBelopIFelt    = new JTextField("0");

    JButton addHusBtn  = new JButton("Add New");
    JButton saveHusBtn = new JButton("Save");
    JButton viewHusBtn = new JButton("View");
    JButton exitHusBtn = new JButton("Exit");

    private DefaultTableModel husModel;
    private JTable            husTable;

    // ── Fritids tab ───────────────────────────────────────────────────────────
    JTextField friAdresseFelt   = new JTextField("Hytte adresse 1");
    JTextField friBoligtypeFelt = new JTextField("Hytte");
    JTextField friMaterialFelt  = new JTextField("Tre");
    JTextField friStandardFelt  = new JTextField("Enkel");
    JTextField friByggeaarFelt  = new JTextField("2000");
    JTextField friKvmFelt       = new JTextField("80");
    JTextField friBelopBFelt    = new JTextField("3000");
    JTextField friBelopIFelt    = new JTextField("3000");
    JTextField friBonusFelt     = new JTextField("0.0");

    JButton addFriBtn  = new JButton("Add New");
    JButton saveFriBtn = new JButton("Save");
    JButton viewFriBtn = new JButton("View");
    JButton exitFriBtn = new JButton("Exit");

    private DefaultTableModel fritidsModel;
    private JTable            fritidsTable;

    // ── Reise tab ─────────────────────────────────────────────────────────────
    JTextField reiseKundeNrFelt = new JTextField();
    JTextField reiseOmradeFelt  = new JTextField();
    JTextField reiseSumFelt     = new JTextField();
    JTextField reiseBonusFelt   = new JTextField();

    JButton addReiseBtn  = new JButton("Add New");
    JButton saveReiseBtn = new JButton("Save");
    JButton viewReiseBtn = new JButton("View");
    JButton exitReiseBtn = new JButton("Exit");

    private DefaultTableModel reiseModel;
    private JTable            reiseTable;

    // ─────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
            catch (Exception ignored) {}
        }
        Runtime frame = new Runtime();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Runtime() {
        setTitle("Insurance");
        setSize(1100, 600);

        buildKundeTab();
        buildBilTab();
        buildBaatTab();
        buildHusTab();
        buildFritidsTab();
        buildReiseTab();

        JPanel top = new JPanel(new GridLayout(1, 1));
        getContentPane().add(top);
        top.add(tabbedPane);

        tabbedPane.addTab("Kunder",       null, buildKundePanel(),   "Kunder");
        tabbedPane.addTab("Bil",          null, buildBilPanel(),     "Bilforsikring");
        tabbedPane.addTab("Båt",          null, buildBaatPanel(),    "Båtforsikring");
        tabbedPane.addTab("Hus & Innbo",  null, buildHusPanel(),     "Hus og innbo");
        tabbedPane.addTab("Fritidsbolig", null, buildFritidsPanel(), "Fritidsbolig");
        tabbedPane.addTab("Reise",        null, buildReisePanel(),   "Reiseforsikring");
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    // ── Generic helpers ───────────────────────────────────────────────────────

    private void melding(String s) {
        JOptionPane.showMessageDialog(this, s, "Feil", JOptionPane.ERROR_MESSAGE);
    }

    private void bind(JButton button, Runnable action) {
        button.addActionListener(_ -> action.run());
    }

    private void bindExit(JButton button) {
        bind(button, () -> System.exit(0));
    }

    private JTable makeTable(DefaultTableModel model) {
        JTable t = new JTable(model) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        t.getTableHeader().setReorderingAllowed(false);
        t.setRowHeight(22);
        return t;
    }

    private JScrollPane scroll(JTable t) { return new JScrollPane(t); }

    private JPanel formPanel(Object[][] rows) {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints lc = new GridBagConstraints();
        lc.insets = new Insets(4,6,4,4); lc.anchor = GridBagConstraints.WEST;
        GridBagConstraints fc = new GridBagConstraints();
        fc.insets = new Insets(4,4,4,6); fc.fill = GridBagConstraints.HORIZONTAL; fc.weightx = 1.0;
        for (int i = 0; i < rows.length; i++) {
            lc.gridx = 0; lc.gridy = i;
            fc.gridx = 1; fc.gridy = i;
            p.add(new JLabel((String) rows[i][0]), lc);
            p.add((JComponent) rows[i][1], fc);
        }
        return p;
    }

    private void openDetailDialog(String title, String[] labels, JTextField[] fields,
                                   Runnable onSave, Runnable onDelete) {
        JDialog dlg = new JDialog(this, title, true);
        dlg.setLayout(new BorderLayout(8, 8));
        Object[][] rows = new Object[labels.length][2];
        for (int i = 0; i < labels.length; i++) rows[i] = new Object[]{labels[i], fields[i]};
        dlg.add(formPanel(rows), BorderLayout.CENTER);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveBtn   = new JButton("Lagre endringer");
        JButton deleteBtn = new JButton("Slett");
        JButton closeBtn  = new JButton("Lukk");
        deleteBtn.setForeground(Color.RED);
        btns.add(saveBtn); btns.add(deleteBtn); btns.add(closeBtn);
        dlg.add(btns, BorderLayout.SOUTH);

        bind(saveBtn, () -> {
            if (onSave != null) {
                onSave.run();
            }
            dlg.dispose();
        });
        bind(deleteBtn, () -> {
            int c = JOptionPane.showConfirmDialog(dlg, "Er du sikker på at du vil slette?",
                    "Bekreft sletting", JOptionPane.YES_NO_OPTION);
            if (c == JOptionPane.YES_OPTION) { if (onDelete != null) onDelete.run(); dlg.dispose(); }
        });
        bind(closeBtn, dlg::dispose);

        dlg.pack();
        dlg.setMinimumSize(new Dimension(440, 200));
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
    }

    private JLabel hintLabel() {
        JLabel l = new JLabel("Dobbeltklikk på en rad for å se / redigere / slette");
        l.setFont(l.getFont().deriveFont(Font.ITALIC, 11f));
        return l;
    }

    // ── KUNDE ─────────────────────────────────────────────────────────────────

    private void buildKundeTab() {
        kundeModel = new DefaultTableModel(new String[]{"KundeNr","Navn","Adresse","Dato"}, 0);
        kundeTable = makeTable(kundeModel);
        kundeTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                int row = kundeTable.getSelectedRow();
                if (row < 0) return;
                int knr = Integer.parseInt(kundeModel.getValueAt(row, 0).toString());
                Kunde k = lister.finnKunder(knr);
                if (k == null) return;
                JTextField fNr   = new JTextField(String.valueOf(k.getKundeNr())); fNr.setEditable(false);
                JTextField fNavn = new JTextField(k.getNavn());
                JTextField fAdr  = new JTextField(k.getFakturaAdresse());
                openDetailDialog("Kundedetaljer – " + k.getNavn(),
                    new String[]{"KundeNr","Navn","Adresse"},
                    new JTextField[]{fNr, fNavn, fAdr},
                    () -> { k.setNavn(fNavn.getText()); k.setFakturaAdresse(fAdr.getText()); refreshKundeTable(); },
                    () -> { lister.fjernKunde(knr); refreshKundeTable(); });
            }
        });
    }

    private void refreshKundeTable() {
        kundeModel.setRowCount(0);
        for (Kunde k : lister.getKundeListe())
            kundeModel.addRow(new Object[]{k.getKundeNr(), k.getNavn(), k.getFakturaAdresse(), k.getDato()});
    }

    private JPanel buildKundePanel() {
        JPanel form = formPanel(new Object[][]{
            {"Navn",    Navnfelt},
            {"Adresse", new JScrollPane(Adressefelt)}
        });
        JPanel btns = new JPanel(new FlowLayout());
        btns.add(regKunde); btns.add(exitKunde);
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Ny kunde"));
        left.add(form, BorderLayout.CENTER); left.add(btns, BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(280, 0));
        JPanel main = new JPanel(new BorderLayout(8, 0));
        main.add(left, BorderLayout.WEST);
        main.add(scroll(kundeTable), BorderLayout.CENTER);
        main.add(hintLabel(), BorderLayout.SOUTH);
        main.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        bind(regKunde, () -> {
            String navn = Navnfelt.getText().trim();
            String adr  = Adressefelt.getText().trim();
            if (navn.isEmpty() || adr.isEmpty()) { melding("Fyll ut navn og adresse."); return; }
            Kunde k = new Kunde(navn, adr, null);
            if (lister.leggTilKunde(k)) {
                kunderNrfelt1.setText(String.valueOf(k.getKundeNr()));
                refreshKundeTable();
                Navnfelt.setText(""); Adressefelt.setText("");
            } else melding("Kunne ikke legge til kunde.");
        });
        bindExit(exitKunde);
        return main;
    }

    // ── BIL ───────────────────────────────────────────────────────────────────

    private void buildBilTab() {
        bilModel = new DefaultTableModel(
            new String[]{"KundeNr","RegNr","Biltype","Modell","Årsmodell","MotorType","Lengde"}, 0);
        bilTable = makeTable(bilModel);
        bilTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                int row = bilTable.getSelectedRow();
                if (row < 0) return;
                String regNr = bilModel.getValueAt(row, 1).toString();
                Bilforsikring bil = null;
                for (Bilforsikring b : lister.getBilForsikringsLIste())
                    if (regNr.equals(b.getRegistreringsnummer())) { bil = b; break; }
                if (bil == null) return;
                final Bilforsikring fb = bil;
                JTextField fKnr    = new JTextField(String.valueOf(fb.getKunder())); fKnr.setEditable(false);
                JTextField fReg    = new JTextField(fb.getRegistreringsnummer());
                JTextField fType   = new JTextField(fb.getBiltype());
                JTextField fModell = new JTextField(fb.getModell());
                JTextField fAr     = new JTextField(String.valueOf(fb.getÅrsmodell()));
                JTextField fMotor  = new JTextField(fb.getMotortype());
                JTextField fLengde = new JTextField(String.valueOf(fb.getLengde()));
                openDetailDialog("Bilforsikring – " + regNr,
                    new String[]{"KundeNr","RegNr","Biltype","Modell","Årsmodell","MotorType","Lengde"},
                    new JTextField[]{fKnr, fReg, fType, fModell, fAr, fMotor, fLengde},
                    () -> {
                        fb.setRegistreringsnummer(fReg.getText()); fb.setBiltype(fType.getText());
                        fb.setModell(fModell.getText()); fb.setMotortype(fMotor.getText());
                        try { fb.setÅrsmodell(Integer.parseInt(fAr.getText())); } catch (NumberFormatException ignored) {}
                        try { fb.setLengde(Integer.parseInt(fLengde.getText())); } catch (NumberFormatException ignored) {}
                        refreshBilTable();
                    },
                    () -> { lister.getBilForsikringsLIste().remove(fb); refreshBilTable(); });
            }
        });
    }

    private void refreshBilTable() {
        bilModel.setRowCount(0);
        for (Bilforsikring b : lister.getBilForsikringsLIste())
            bilModel.addRow(new Object[]{b.getKunder(), b.getRegistreringsnummer(), b.getBiltype(),
                b.getModell(), b.getÅrsmodell(), b.getMotortype(), b.getLengde()});
    }

    private JPanel buildBilPanel() {
        JPanel form = formPanel(new Object[][]{
            {"KundeNr",     KundeNrfeltb}, {"Biltype", biltypefelt}, {"Reg.år", regarfelt},
            {"Reg.nummer",  regnrfelt},    {"Kjorelengde", kjorelengdeFelt}, {"Bonus", bonusfelt},
            {"Modell",      modellfelt},   {"Lengde", lengdefelt1}, {"Bil-kategori", bilTypeCombo}
        });
        JPanel btns = new JPanel(new FlowLayout());
        btns.add(addBilBtn); btns.add(saveBilBtn); btns.add(viewBilBtn); btns.add(exitBilBtn);
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Ny bilforsikring"));
        left.add(form, BorderLayout.CENTER); left.add(btns, BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(320, 0));
        JPanel main = new JPanel(new BorderLayout(8, 0));
        main.add(left, BorderLayout.WEST);
        main.add(scroll(bilTable), BorderLayout.CENTER);
        main.add(hintLabel(), BorderLayout.SOUTH);
        main.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        String pattern = "[A-Za-z]{3}[0-9]{3}";
        bind(addBilBtn, () -> {
            String regNr = regnrfelt.getText().toUpperCase();
            if (!regNr.matches(pattern)) { melding("RegNr: 3 bokstaver + 3 tall (eks: ABC123)"); return; }
            if (lister.finnBil(regNr) != null) { melding("Bil med dette nummeret finnes allerede."); return; }
            try {
                int knr    = Integer.parseInt(KundeNrfeltb.getText());
                int year   = Integer.parseInt(regarfelt.getText());
                int lengde = Integer.parseInt(lengdefelt1.getText());
                int md     = Integer.parseInt(modellfelt.getText());
                String biltype = (String) bilTypeCombo.getSelectedItem();
                Bilforsikring bil = new Bilforsikring(null, knr, regNr, biltype,
                        modellfelt.getText(), lengde, year, biltypefelt.getText(), md, lengde);
                lister.leggTilbilForsikring(bil);
                refreshBilTable();
            } catch (NumberFormatException ex) { melding("Gyldige tall kreves."); }
        });
        bind(viewBilBtn, this::refreshBilTable);
        bind(saveBilBtn, () -> {
            try { persistToDatabase(); melding("Lagret til database!"); }
            catch (Exception ex) { melding("Feil: " + ex.getMessage()); }
        });
        bindExit(exitBilBtn);
        return main;
    }

    // ── BAAT ──────────────────────────────────────────────────────────────────

    private void buildBaatTab() {
        baatModel = new DefaultTableModel(
            new String[]{"KundeNr","RegNr","BåtType","Modell","Lengde","Årsmodell","MotorType","MotorStyrke","Bonus"}, 0);
        baatTable = makeTable(baatModel);
        baatTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                int row = baatTable.getSelectedRow();
                if (row < 0) return;
                String regNr = baatModel.getValueAt(row, 1).toString();
                BaatForsikring baat = null;
                for (BaatForsikring b : lister.getBaatForsikringsliste())
                    if (regNr.equals(b.getRegistreringsnummer())) { baat = b; break; }
                if (baat == null) return;
                final BaatForsikring fb = baat;
                JTextField fKnr    = new JTextField(String.valueOf(fb.getKunder())); fKnr.setEditable(false);
                JTextField fReg    = new JTextField(fb.getRegistreringsnummer());
                JTextField fType   = new JTextField(fb.getBaattype());
                JTextField fModell = new JTextField(fb.getModell());
                JTextField fLengde = new JTextField(String.valueOf(fb.getLengde()));
                JTextField fAr     = new JTextField(String.valueOf(fb.getÅrsmodell()));
                JTextField fMotorT = new JTextField(fb.getMotortype());
                JTextField fMotorS = new JTextField(String.valueOf(fb.getMotorstyrke()));
                JTextField fBonus  = new JTextField(String.valueOf(fb.getBonus()));
                openDetailDialog("Båtforsikring – " + regNr,
                    new String[]{"KundeNr","RegNr","BåtType","Modell","Lengde","Årsmodell","MotorType","MotorStyrke","Bonus"},
                    new JTextField[]{fKnr, fReg, fType, fModell, fLengde, fAr, fMotorT, fMotorS, fBonus},
                    () -> {
                        fb.setRegistreringsnummer(fReg.getText()); fb.setBaattype(fType.getText());
                        fb.setModell(fModell.getText()); fb.setMotortype(fMotorT.getText());
                        try { fb.setLengde(Integer.parseInt(fLengde.getText())); } catch (NumberFormatException ignored) {}
                        try { fb.setÅrsmodell(Integer.parseInt(fAr.getText())); } catch (NumberFormatException ignored) {}
                        try { fb.setMotorstyrke(Integer.parseInt(fMotorS.getText())); } catch (NumberFormatException ignored) {}
                        try { fb.setBonus(Double.parseDouble(fBonus.getText())); } catch (NumberFormatException ignored) {}
                        refreshBaatTable();
                    },
                    () -> { lister.getBaatForsikringsliste().remove(fb); refreshBaatTable(); });
            }
        });
    }

    private void refreshBaatTable() {
        baatModel.setRowCount(0);
        for (BaatForsikring b : lister.getBaatForsikringsliste())
            baatModel.addRow(new Object[]{b.getKunder(), b.getRegistreringsnummer(), b.getBaattype(),
                b.getModell(), b.getLengde(), b.getÅrsmodell(), b.getMotortype(), b.getMotorstyrke(), b.getBonus()});
    }

    private JPanel buildBaatPanel() {
        JPanel form = formPanel(new Object[][]{
            {"KundeNr",     kunderNrfelt1}, {"Reg.nummer", regnumfelt}, {"BåtType", baatypefelt},
            {"Modell",      modellfelt1},   {"Lengde", lengdefelt},     {"Arsmodell", arsmodellFelt},
            {"MotorStyrke", motorstyrkfelt},{"MotorType", motortypefelt},{"Bonus", bonusfelf2}
        });
        JPanel btns = new JPanel(new FlowLayout());
        btns.add(addBaatBtn); btns.add(saveBaatBtn); btns.add(viewBaatBtn); btns.add(exitBaatBtn);
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Ny båtforsikring"));
        left.add(form, BorderLayout.CENTER); left.add(btns, BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(310, 0));
        JPanel main = new JPanel(new BorderLayout(8, 0));
        main.add(left, BorderLayout.WEST);
        main.add(scroll(baatTable), BorderLayout.CENTER);
        main.add(hintLabel(), BorderLayout.SOUTH);
        main.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        bind(addBaatBtn, () -> {
            if (kunderNrfelt1.getText().isEmpty() || regnumfelt.getText().isEmpty()) { melding("Fyll inn alle felt."); return; }
            try {
                int knr         = Integer.parseInt(kunderNrfelt1.getText());
                int lengde      = Integer.parseInt(lengdefelt.getText());
                int arsmodell   = Integer.parseInt(arsmodellFelt.getText());
                int motorstyrke = Integer.parseInt(motorstyrkfelt.getText());
                double bonus    = bonusfelf2.getText().isEmpty() ? 0.0 : Double.parseDouble(bonusfelf2.getText());
                BaatForsikring baat = new BaatForsikring(null, regnumfelt.getText(), baatypefelt.getText(),
                        modellfelt1.getText(), lengde, arsmodell, motortypefelt.getText(), motorstyrke, bonus, 4, 0.0);
                baat.setKunder(knr);
                lister.leggTilbaatForsikiring(baat);
                refreshBaatTable();
            } catch (NumberFormatException ex) { melding("Gyldige tall kreves."); }
        });
        bind(viewBaatBtn, this::refreshBaatTable);
        bind(saveBaatBtn, () -> {
            try { persistToDatabase(); melding("Lagret til database!"); }
            catch (Exception ex) { melding("Feil: " + ex.getMessage()); }
        });
        bindExit(exitBaatBtn);
        return main;
    }

    // ── HUS OG INNBO ──────────────────────────────────────────────────────────

    private void buildHusTab() {
        husModel = new DefaultTableModel(
            new String[]{"Kunde","Adresse","Boligtype","Materiale","Standard","Byggeår","Kvm","BelopB","BelopI"}, 0);
        husTable = makeTable(husModel);
        husTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                int row = husTable.getSelectedRow();
                if (row < 0) return;
                String adr = husModel.getValueAt(row, 1).toString();
                Husoginnboforsikring hus = null;
                for (Husoginnboforsikring h : lister.getHusoginnboforsikrings())
                    if (adr.equals(h.getBoligensAdresse())) { hus = h; break; }
                if (hus == null) return;
                final Husoginnboforsikring fh = hus;
                JTextField fKunde  = new JTextField(String.valueOf(fh.getKunde())); fKunde.setEditable(false);
                JTextField fAdr    = new JTextField(fh.getBoligensAdresse());
                JTextField fType   = new JTextField(fh.getBoligtype());
                JTextField fMat    = new JTextField(fh.getByggemateriale());
                JTextField fStd    = new JTextField(fh.getStandard());
                JTextField fAr     = new JTextField(String.valueOf(fh.getByggeaar()));
                JTextField fKvm    = new JTextField(String.valueOf(fh.getAntallKvadratmeter()));
                JTextField fBelopB = new JTextField(String.valueOf(fh.getBelopB()));
                JTextField fBelopI = new JTextField(String.valueOf(fh.getBelopI()));
                openDetailDialog("Hus og innbo – " + adr,
                    new String[]{"Kunde","Adresse","Boligtype","Materiale","Standard","Byggeår","Kvm","BelopB","BelopI"},
                    new JTextField[]{fKunde, fAdr, fType, fMat, fStd, fAr, fKvm, fBelopB, fBelopI},
                    () -> {
                        fh.setBoligensAdresse(fAdr.getText()); fh.setBoligtype(fType.getText());
                        fh.setByggemateriale(fMat.getText()); fh.setStandard(fStd.getText());
                        try { fh.setByggeaar(Integer.parseInt(fAr.getText())); } catch (NumberFormatException ignored) {}
                        try { fh.setBelopB(Integer.parseInt(fBelopB.getText())); } catch (NumberFormatException ignored) {}
                        try { fh.setBelopI(Integer.parseInt(fBelopI.getText())); } catch (NumberFormatException ignored) {}
                        refreshHusTable();
                    },
                    () -> { lister.fjernHus(adr); refreshHusTable(); });
            }
        });
    }

    private void refreshHusTable() {
        husModel.setRowCount(0);
        for (Husoginnboforsikring h : lister.getHusoginnboforsikrings())
            husModel.addRow(new Object[]{h.getKunde(), h.getBoligensAdresse(), h.getBoligtype(),
                h.getByggemateriale(), h.getStandard(), h.getByggeaar(),
                h.getAntallKvadratmeter(), h.getBelopB(), h.getBelopI()});
    }

    private JPanel buildHusPanel() {
        JPanel form = formPanel(new Object[][]{
            {"KundeNr",   husKundeNrFelt}, {"Adresse", husAdresseFelt},  {"Boligtype", husBoligtypeFelt},
            {"Materiale", husMaterialFelt},{"Standard",husStandardFelt}, {"Byggeår", husByggeaarFelt},
            {"Kvm",       husKvmFelt},     {"BelopB",  husBelopBFelt},   {"BelopI", husBelopIFelt}
        });
        JPanel btns = new JPanel(new FlowLayout());
        btns.add(addHusBtn); btns.add(saveHusBtn); btns.add(viewHusBtn); btns.add(exitHusBtn);
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Ny hus og innbo forsikring"));
        left.add(form, BorderLayout.CENTER); left.add(btns, BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(310, 0));
        JPanel main = new JPanel(new BorderLayout(8, 0));
        main.add(left, BorderLayout.WEST);
        main.add(scroll(husTable), BorderLayout.CENTER);
        main.add(hintLabel(), BorderLayout.SOUTH);
        main.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        bind(addHusBtn, () -> {
            try {
                int kunde    = Integer.parseInt(husKundeNrFelt.getText());
                int byggeaar = Integer.parseInt(husByggeaarFelt.getText());
                int kvm      = Integer.parseInt(husKvmFelt.getText());
                int belopB   = Integer.parseInt(husBelopBFelt.getText());
                int belopI   = Integer.parseInt(husBelopIFelt.getText());
                Husoginnboforsikring hus = new Husoginnboforsikring(kunde, husAdresseFelt.getText(),
                        husBoligtypeFelt.getText(), null, husMaterialFelt.getText(),
                        kvm, belopB, belopI, byggeaar, husStandardFelt.getText(), 2);
                lister.getHusoginnboforsikrings().add(hus);
                refreshHusTable();
            } catch (NumberFormatException ex) { melding("Gyldige tall kreves."); }
        });
        bind(viewHusBtn, this::refreshHusTable);
        bind(saveHusBtn, () -> {
            try { persistToDatabase(); melding("Lagret til database!"); }
            catch (Exception ex) { melding("Feil: " + ex.getMessage()); }
        });
        bindExit(exitHusBtn);
        return main;
    }

    // ── FRITIDSBOLIG ──────────────────────────────────────────────────────────

    private void buildFritidsTab() {
        fritidsModel = new DefaultTableModel(
            new String[]{"Adresse","Boligtype","Materiale","Standard","Byggeår","Kvm","BelopB","BelopI","Bonus"}, 0);
        fritidsTable = makeTable(fritidsModel);
        fritidsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                int row = fritidsTable.getSelectedRow();
                if (row < 0) return;
                String adr = fritidsModel.getValueAt(row, 0).toString();
                FritidsboligForsikiring f = null;
                for (FritidsboligForsikiring x : lister.getFritidsboligForsikirings())
                    if (adr.equals(x.getBoligensAdresse())) { f = x; break; }
                if (f == null) return;
                final FritidsboligForsikiring ff = f;
                JTextField fAdr    = new JTextField(ff.getBoligensAdresse());
                JTextField fType   = new JTextField(ff.getBoligtype());
                JTextField fMat    = new JTextField(ff.getByggemateriale());
                JTextField fStd    = new JTextField(ff.getStandard());
                JTextField fAr     = new JTextField(String.valueOf(ff.getByggeaar()));
                JTextField fKvm    = new JTextField(String.valueOf(ff.getAntallKvadratmeter()));
                JTextField fBelopB = new JTextField(String.valueOf(ff.getBelopB()));
                JTextField fBelopI = new JTextField(String.valueOf(ff.getBelopI()));
                JTextField fBonus  = new JTextField(String.valueOf(ff.getBonus()));
                openDetailDialog("Fritidsbolig – " + adr,
                    new String[]{"Adresse","Boligtype","Materiale","Standard","Byggeår","Kvm","BelopB","BelopI","Bonus"},
                    new JTextField[]{fAdr, fType, fMat, fStd, fAr, fKvm, fBelopB, fBelopI, fBonus},
                    () -> {
                        ff.setBoligensAdresse(fAdr.getText()); ff.setBoligtype(fType.getText());
                        ff.setByggemateriale(fMat.getText()); ff.setStandard(fStd.getText());
                        try { ff.setByggeaar(Integer.parseInt(fAr.getText())); } catch (NumberFormatException ignored) {}
                        try { ff.setBelopB(Integer.parseInt(fBelopB.getText())); } catch (NumberFormatException ignored) {}
                        try { ff.setBelopI(Integer.parseInt(fBelopI.getText())); } catch (NumberFormatException ignored) {}
                        try { ff.setBonus(Double.parseDouble(fBonus.getText())); } catch (NumberFormatException ignored) {}
                        refreshFritidsTable();
                    },
                    () -> { lister.fjernfritids(adr); refreshFritidsTable(); });
            }
        });
    }

    private void refreshFritidsTable() {
        fritidsModel.setRowCount(0);
        for (FritidsboligForsikiring f : lister.getFritidsboligForsikirings())
            fritidsModel.addRow(new Object[]{f.getBoligensAdresse(), f.getBoligtype(), f.getByggemateriale(),
                f.getStandard(), f.getByggeaar(), f.getAntallKvadratmeter(),
                f.getBelopB(), f.getBelopI(), f.getBonus()});
    }

    private JPanel buildFritidsPanel() {
        JPanel form = formPanel(new Object[][]{
            {"Adresse",   friAdresseFelt},   {"Boligtype", friBoligtypeFelt}, {"Materiale", friMaterialFelt},
            {"Standard",  friStandardFelt},  {"Byggeår",   friByggeaarFelt},  {"Kvm",       friKvmFelt},
            {"BelopB",    friBelopBFelt},     {"BelopI",    friBelopIFelt},    {"Bonus",     friBonusFelt}
        });
        JPanel btns = new JPanel(new FlowLayout());
        btns.add(addFriBtn); btns.add(saveFriBtn); btns.add(viewFriBtn); btns.add(exitFriBtn);
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Ny fritidsbolig forsikring"));
        left.add(form, BorderLayout.CENTER); left.add(btns, BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(310, 0));
        JPanel main = new JPanel(new BorderLayout(8, 0));
        main.add(left, BorderLayout.WEST);
        main.add(scroll(fritidsTable), BorderLayout.CENTER);
        main.add(hintLabel(), BorderLayout.SOUTH);
        main.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        bind(addFriBtn, () -> {
            try {
                int byggeaar = Integer.parseInt(friByggeaarFelt.getText());
                int kvm      = Integer.parseInt(friKvmFelt.getText());
                int belopB   = Integer.parseInt(friBelopBFelt.getText());
                int belopI   = Integer.parseInt(friBelopIFelt.getText());
                double bonus = friBonusFelt.getText().isEmpty() ? 0.0 : Double.parseDouble(friBonusFelt.getText());
                FritidsboligForsikiring fri = new FritidsboligForsikiring(friAdresseFelt.getText(), null,
                        friBoligtypeFelt.getText(), friMaterialFelt.getText(), friStandardFelt.getText(),
                        belopI, belopB, byggeaar, kvm, bonus, 5);
                lister.leggTilFridsboligForsikiring(fri);
                refreshFritidsTable();
            } catch (NumberFormatException ex) { melding("Gyldige tall kreves."); }
        });
        bind(viewFriBtn, this::refreshFritidsTable);
        bind(saveFriBtn, () -> {
            try { persistToDatabase(); melding("Lagret til database!"); }
            catch (Exception ex) { melding("Feil: " + ex.getMessage()); }
        });
        bindExit(exitFriBtn);
        return main;
    }

    // ── REISE ─────────────────────────────────────────────────────────────────

    private void buildReiseTab() {
        reiseModel = new DefaultTableModel(new String[]{"Kunde","Område","Sum","Dato"}, 0);
        reiseTable = makeTable(reiseModel);
        reiseTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                int row = reiseTable.getSelectedRow();
                if (row < 0) return;
                String kunde  = reiseModel.getValueAt(row, 0).toString();
                String omrade = reiseModel.getValueAt(row, 1).toString();
                Reise r = null;
                for (Reise x : lister.getReisesliste())
                    if (kunde.equals(x.kunder) && omrade.equals(x.getOmråde())) { r = x; break; }
                if (r == null) return;
                final Reise fr = r;
                JTextField fKunde  = new JTextField(fr.kunder); fKunde.setEditable(false);
                JTextField fOmrade = new JTextField(fr.getOmråde());
                JTextField fSum    = new JTextField(String.valueOf(fr.getSumf()));
                openDetailDialog("Reiseforsikring – " + kunde,
                    new String[]{"Kunde","Område","Sum"},
                    new JTextField[]{fKunde, fOmrade, fSum},
                    () -> {
                        fr.setOmråde(fOmrade.getText());
                        try { fr.setSumf(Integer.parseInt(fSum.getText())); } catch (NumberFormatException ignored) {}
                        refreshReiseTable();
                    },
                    () -> { lister.getReisesliste().remove(fr); refreshReiseTable(); });
            }
        });
    }

    private void refreshReiseTable() {
        reiseModel.setRowCount(0);
        for (Reise r : lister.getReisesliste())
            reiseModel.addRow(new Object[]{r.kunder, r.getOmråde(), r.getSumf(), r.getDato()});
    }

    private JPanel buildReisePanel() {
        JPanel form = formPanel(new Object[][]{
            {"KundeNr", reiseKundeNrFelt}, {"Område", reiseOmradeFelt},
            {"Sum",     reiseSumFelt},     {"Bonus",  reiseBonusFelt}
        });
        JPanel btns = new JPanel(new FlowLayout());
        btns.add(addReiseBtn); btns.add(saveReiseBtn); btns.add(viewReiseBtn); btns.add(exitReiseBtn);
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Ny reiseforsikring"));
        left.add(form, BorderLayout.CENTER); left.add(btns, BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(280, 0));
        JPanel main = new JPanel(new BorderLayout(8, 0));
        main.add(left, BorderLayout.WEST);
        main.add(scroll(reiseTable), BorderLayout.CENTER);
        main.add(hintLabel(), BorderLayout.SOUTH);
        main.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        bind(addReiseBtn, () -> {
            if (reiseKundeNrFelt.getText().isEmpty() || reiseOmradeFelt.getText().isEmpty() || reiseSumFelt.getText().isEmpty()) {
                melding("Fyll inn alle felt."); return;
            }
            try {
                int sum    = Integer.parseInt(reiseSumFelt.getText());
                double bon = reiseBonusFelt.getText().isEmpty() ? 0.0 : Double.parseDouble(reiseBonusFelt.getText());
                Reise r    = new Reise(reiseKundeNrFelt.getText(), reiseOmradeFelt.getText(), sum, 3, bon);
                lister.leggTilRiese(r);
                refreshReiseTable();
            } catch (NumberFormatException ex) { melding("Gyldige tall kreves."); }
        });
        bind(viewReiseBtn, this::refreshReiseTable);
        bind(saveReiseBtn, () -> {
            try { persistToDatabase(); melding("Lagret til database!"); }
            catch (Exception ex) { melding("Feil: " + ex.getMessage()); }
        });
        bindExit(exitReiseBtn);
        return main;
    }

    private void persistToDatabase() throws Exception {
        persistenceService.save(lister, snapshotFormatter.buildListerTextSnapshot(lister));
    }
}
