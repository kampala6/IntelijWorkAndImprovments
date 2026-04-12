//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import projektoppgave3_2015.Bilforsikring.BilType;
import projektoppgave3_2015.TypeSkade;

public final class Vindutest extends JFrame {
    private static final long serialVersionUID = 1L;
    private final Lister lister = new Lister();
    private final JTextArea utskrift = new JTextArea(25, 60);
    private final JTextField navnFelt = new JTextField(10);
    private final JTextField adresseFelt = new JTextField(10);
    private final JTextField kundeNrFelt = new JTextField(10);
    private final JTextField bilKundeFelt = new JTextField(10);
    private final JTextField bilRegNrFelt = new JTextField(10);
    private final JComboBox<Bilforsikring.BilType> bilTypeCombo = new JComboBox<>(BilType.values());
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
    private final JTextField skadeDatoFelt = new JTextField(10);
    private final JTextField skadeNummerFelt = new JTextField(10);
    private final JComboBox<TypeSkade> skadeTypeCombo = new JComboBox<>(TypeSkade.values());
    private final JTextField skadeBeskrivelseFelt = new JTextField(15);
    private final JTextField skadeVitneKontaktFelt = new JTextField(15);
    private final JTextField skadeTakseringFelt = new JTextField(10);
    private final JTextField skadeUtbetaltFelt = new JTextField(10);
    private final JComboBox<String> skadeKoblingTypeCombo = new JComboBox<>(new String[]{"HUS", "FRITIDSBOLIG", "BAAT"});
    private final JTextField skadeKoblingReferanseFelt = new JTextField(15);
    private final JButton leggTilKundeBtn = new JButton("Legg til kunde");
    private final JButton finnKundeBtn = new JButton("Finn kunde");
    private final JButton slettKundeBtn = new JButton("Slett kunde");
    private final JButton leggTilBilBtn = new JButton("Legg til bil");
    private final JButton visBilBtn = new JButton("Vis biler");
    private final JButton leggTilHusBtn = new JButton("Legg til hus/innbo");
    private final JButton visHusBtn = new JButton("Vis hus/innbo");
    private final JButton leggTilFriBtn = new JButton("Legg til fritidsbolig");
    private final JButton visFriBtn = new JButton("Vis fritidsbolig");
    private final JButton leggTilSkadeBtn = new JButton("Legg til skademelding");
    private final JButton visSkadeBtn = new JButton("Vis skademeldinger");
    private final JButton hurtigVisSkadeBtn = new JButton("Skademeldinger");
    private final JLabel skadeCountLabel = new JLabel("Skader: 0");
    private final JButton lagreBtn = new JButton("Lagre");
    private final JButton lastBtn = new JButton("Last");
    private final JButton visLagretBtn = new JButton("Vis lagrede filer");
    private static final String PERSISTENCE_FILE = "lister.txt";
    private static final String SERIALIZED_PERSISTENCE_FILE = "lister.ser";
    private static final String FALLBACK_CUSTOMER_LIST_FILE = "Kunderliste.txt";
    private static final String EMPTY_SECTION_TEXT = "Ingen data";
    private final SnapshotFormatter snapshotFormatter = new SnapshotFormatter();
    private final PersistenceService persistenceService = new PersistenceService("lister.txt", "lister.ser");
    private static final Color APP_BACKGROUND_COLOR = new Color(245, 247, 250);
    private static final Color CARD_BACKGROUND_COLOR;
    private static final Color CARD_BORDER_COLOR;
    private static final Color BUTTON_PRIMARY_COLOR;
    private static final Color BUTTON_PRIMARY_TEXT_COLOR;
    private static final Color OUTPUT_BACKGROUND_COLOR;
    private static final Color OUTPUT_BORDER_COLOR;
    private static final Color INVALID_FIELD_COLOR;
    private static final Font SECTION_TITLE_FONT;
    private static final Font LABEL_FONT;
    private static final Font FIELD_FONT;
    private static final Font OUTPUT_FONT;
    private static final Insets LABEL_INSETS;
    private static final Insets FIELD_INSETS;
    private static final Insets BUTTON_INSETS_LEFT;
    private static final Insets BUTTON_INSETS_RIGHT;
    private static final Insets SINGLE_BUTTON_INSETS;
    private final Color defaultFieldColor = UIManager.getColor("TextField.background");

    public Vindutest() {
        super("Forsikring 2026");
        this.initializeVisualStyle();
        JPanel var1 = new JPanel(new BorderLayout(12, 12));
        var1.setBackground(APP_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        var1.add(this.buildHeaderPanel(), "North");
        var1.add(this.buildDashboardContent(), "Center");
        this.setContentPane(var1);
        this.configureValidation();
        this.wireEvents();
        this.refreshSkadeCountBadge();
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setMinimumSize(new Dimension(1240, 860));
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    private JComponent buildHeaderPanel() {
        JPanel var1 = new JPanel(new BorderLayout(10, 6));
        var1.setOpaque(true);
        var1.setBackground(CARD_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        JLabel var2 = new JLabel("Forsikring 2026");
        var2.setFont(new Font("SansSerif", 1, 22));
        var2.setForeground(new Color(34, 41, 52));
        JLabel var3 = new JLabel("Registrer kunder, opprett forsikringer og se lagrede data i ett samlet arbeidsområde.");
        var3.setFont(new Font("SansSerif", 0, 13));
        var3.setForeground(new Color(95, 104, 118));
        JPanel var4 = new JPanel();
        var4.setOpaque(false);
        var4.setLayout(new BoxLayout(var4, 1));
        var4.add(var2);
        var4.add(Box.createVerticalStrut(4));
        var4.add(var3);
        var1.add(var4, "Center");
        var1.add(this.createHeaderBadge("Dashboard"), "East");
        return var1;
    }

    private JComponent buildDashboardContent() {
        JSplitPane var1 = new JSplitPane(1, this.buildInputColumn(), this.buildRightColumn());
        var1.setOpaque(false);
        var1.setBorder((Border)null);
        var1.setResizeWeight(0.53);
        var1.setContinuousLayout(true);
        var1.setDividerSize(10);
        var1.setOneTouchExpandable(true);
        return var1;
    }

    private JComponent buildInputColumn() {
        JPanel var1 = new JPanel();
        var1.setOpaque(false);
        var1.setLayout(new BoxLayout(var1, 1));
        var1.add(this.buildKundePanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildForsikringPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildFriPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildSkadePanel());
        var1.add(Box.createVerticalGlue());
        JScrollPane var2 = new JScrollPane(var1);
        var2.setBorder((Border)null);
        var2.setOpaque(false);
        var2.getViewport().setOpaque(false);
        var2.getVerticalScrollBar().setUnitIncrement(16);
        return var2;
    }

    private JComponent buildRightColumn() {
        JPanel var1 = new JPanel(new BorderLayout(0, 12));
        var1.setOpaque(false);
        var1.add(this.buildOutputPanel(), "Center");
        var1.add(this.buildBottomPanel(), "South");
        return var1;
    }

    private JComponent createHeaderBadge(String var1) {
        JLabel var2 = new JLabel(var1);
        var2.setOpaque(true);
        var2.setBackground(new Color(232, 240, 255));
        var2.setForeground(BUTTON_PRIMARY_COLOR.darker());
        var2.setFont(new Font("SansSerif", 1, 12));
        var2.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        return var2;
    }

    private void initializeVisualStyle() {
        this.setLayout(new BorderLayout(12, 12));
        this.getContentPane().setBackground(APP_BACKGROUND_COLOR);
        this.utskrift.setEditable(false);
        this.utskrift.setFont(OUTPUT_FONT);
        this.utskrift.setLineWrap(true);
        this.utskrift.setWrapStyleWord(true);
        this.utskrift.setMargin(new Insets(12, 14, 12, 14));
        this.utskrift.setBackground(OUTPUT_BACKGROUND_COLOR);
        this.utskrift.setForeground(new Color(43, 50, 61));
        this.utskrift.setCaretPosition(0);
        JTextField[] var1 = new JTextField[]{this.navnFelt, this.adresseFelt, this.kundeNrFelt, this.bilKundeFelt, this.bilRegNrFelt, this.bilModellFelt, this.bilLengdeFelt, this.bilAarFelt, this.bilMotorTypeFelt, this.bilMotorStyrkeFelt, this.husKundeFelt, this.husAdresseFelt, this.husBoligtypeFelt, this.husMaterialeFelt, this.husAntallM2Felt, this.husBelopBFelt, this.husBelopIFelt, this.husByggeaarFelt, this.husStandardFelt, this.husBonusFelt, this.friKundeFelt, this.friAdresseFelt, this.friBoligtypeFelt, this.friMaterialeFelt, this.friStandardFelt, this.friAntallM2Felt, this.friBelopBFelt, this.friBelopIFelt, this.friByggeaarFelt, this.friBonusFelt, this.skadeDatoFelt, this.skadeNummerFelt, this.skadeBeskrivelseFelt, this.skadeVitneKontaktFelt, this.skadeTakseringFelt, this.skadeUtbetaltFelt, this.skadeKoblingReferanseFelt};

        for(JTextField var5 : var1) {
            this.styleTextField(var5);
        }

        JButton[] var7 = new JButton[]{this.leggTilKundeBtn, this.finnKundeBtn, this.slettKundeBtn, this.leggTilBilBtn, this.visBilBtn, this.leggTilHusBtn, this.visHusBtn, this.leggTilFriBtn, this.visFriBtn, this.leggTilSkadeBtn, this.visSkadeBtn, this.lagreBtn, this.lastBtn, this.visLagretBtn, this.hurtigVisSkadeBtn};

        for(JButton var6 : var7) {
            this.styleButton(var6);
        }

        this.stylePrimaryButton(this.leggTilKundeBtn);
        this.stylePrimaryButton(this.leggTilBilBtn);
        this.stylePrimaryButton(this.leggTilHusBtn);
        this.stylePrimaryButton(this.leggTilFriBtn);
        this.stylePrimaryButton(this.leggTilSkadeBtn);
        this.stylePrimaryButton(this.lagreBtn);
        this.bilTypeCombo.setFont(FIELD_FONT);
        this.bilTypeCombo.setBackground(Color.WHITE);
        this.skadeTypeCombo.setFont(FIELD_FONT);
        this.skadeTypeCombo.setBackground(Color.WHITE);
        this.skadeKoblingTypeCombo.setFont(FIELD_FONT);
        this.skadeKoblingTypeCombo.setBackground(Color.WHITE);
        this.skadeCountLabel.setFont(new Font("SansSerif", 1, 12));
        this.skadeCountLabel.setOpaque(true);
        this.skadeCountLabel.setBackground(new Color(232, 240, 255));
        this.skadeCountLabel.setForeground(BUTTON_PRIMARY_COLOR.darker());
        this.skadeCountLabel.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
    }

    private JPanel buildKundePanel() {
        JPanel var1 = this.createFormPanel("Kunde");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Navn", this.navnFelt);
        this.addLabeledRow(var1, var2++, "Adresse", this.adresseFelt);
        this.addLabeledRow(var1, var2++, "Kundenr", this.kundeNrFelt);
        this.addButtonRow(var1, var2++, this.leggTilKundeBtn, this.finnKundeBtn);
        this.addSingleButtonRow(var1, var2, this.slettKundeBtn);
        return var1;
    }

    private JPanel buildForsikringPanel() {
        JPanel var1 = new JPanel();
        var1.setLayout(new BoxLayout(var1, 1));
        var1.setOpaque(true);
        var1.setBackground(CARD_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), "Forsikringer", 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        var1.add(this.buildBilPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildHusPanel());
        return var1;
    }

    private JPanel buildFriPanel() {
        JPanel var1 = this.createFormPanel("Fritidsbolig");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Kundenr", this.friKundeFelt);
        this.addLabeledRow(var1, var2++, "Adresse", this.friAdresseFelt);
        this.addLabeledRow(var1, var2++, "Boligtype", this.friBoligtypeFelt);
        this.addLabeledRow(var1, var2++, "Materiale", this.friMaterialeFelt);
        this.addLabeledRow(var1, var2++, "Standard", this.friStandardFelt);
        this.addLabeledRow(var1, var2++, "Antall m2", this.friAntallM2Felt);
        this.addLabeledRow(var1, var2++, "Beløp B", this.friBelopBFelt);
        this.addLabeledRow(var1, var2++, "Beløp I", this.friBelopIFelt);
        this.addLabeledRow(var1, var2++, "Byggeår", this.friByggeaarFelt);
        this.addLabeledRow(var1, var2++, "Bonus", this.friBonusFelt);
        this.addButtonRow(var1, var2, this.leggTilFriBtn, this.visFriBtn);
        return var1;
    }

    private JPanel buildSkadePanel() {
        JPanel var1 = this.createFormPanel("Skademelding");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Dato (yyyy-MM-dd)", this.skadeDatoFelt);
        this.addLabeledRow(var1, var2++, "Skadenummer", this.skadeNummerFelt);
        this.addLabeledRow(var1, var2++, "Type skade", this.skadeTypeCombo);
        this.addLabeledRow(var1, var2++, "Beskrivelse", this.skadeBeskrivelseFelt);
        this.addLabeledRow(var1, var2++, "Vitne kontakt", this.skadeVitneKontaktFelt);
        this.addLabeledRow(var1, var2++, "Taksering belop", this.skadeTakseringFelt);
        this.addLabeledRow(var1, var2++, "Utbetalt belop", this.skadeUtbetaltFelt);
        this.addLabeledRow(var1, var2++, "Koblet objekt", this.skadeKoblingTypeCombo);
        this.addLabeledRow(var1, var2++, "Referanse", this.skadeKoblingReferanseFelt);
        this.addButtonRow(var1, var2, this.leggTilSkadeBtn, this.visSkadeBtn);
        return var1;
    }

    private JPanel buildBottomPanel() {
        JPanel var1 = new JPanel(new BorderLayout(0, 10));
        var1.setOpaque(true);
        var1.setBackground(CARD_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), "Lagring og filer", 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JLabel var2 = new JLabel("Lagre data, last inn tidligere arbeid eller vis innholdet i tekstfilene.");
        var2.setFont(new Font("SansSerif", 0, 12));
        var2.setForeground(new Color(95, 104, 118));
        JPanel var3 = new JPanel(new GridLayout(1, 3, 10, 0));
        var3.setOpaque(false);
        var3.add(this.lagreBtn);
        var3.add(this.lastBtn);
        var3.add(this.visLagretBtn);
        var1.add(var2, "North");
        var1.add(var3, "Center");
        return var1;
    }

    private JComponent buildOutputPanel() {
        JScrollPane var1 = new JScrollPane(this.utskrift);
        var1.setBorder(BorderFactory.createLineBorder(OUTPUT_BORDER_COLOR));
        var1.getVerticalScrollBar().setUnitIncrement(16);
        JPanel var2 = new JPanel(new BorderLayout());
        var2.setOpaque(true);
        var2.setBackground(CARD_BACKGROUND_COLOR);
        var2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), "Utdata og aktivitetslogg", 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        var2.add(this.createOutputToolbar(), "North");
        var2.add(var1, "Center");
        return var2;
    }

    private JComponent createOutputToolbar() {
        JPanel var1 = new JPanel(new BorderLayout());
        var1.setOpaque(false);
        var1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        JLabel var2 = new JLabel("Resultater");
        var2.setFont(new Font("SansSerif", 1, 13));
        var2.setForeground(new Color(55, 63, 78));
        JLabel var3 = new JLabel("Visninger, søk og filinnhold blir vist her.");
        var3.setFont(new Font("SansSerif", 0, 12));
        var3.setForeground(new Color(95, 104, 118));
        JPanel var4 = new JPanel();
        var4.setOpaque(false);
        var4.setLayout(new BoxLayout(var4, 1));
        var4.add(var2);
        var4.add(Box.createVerticalStrut(2));
        var4.add(var3);
        var1.add(var4, "West");
        JPanel var5 = new JPanel(new FlowLayout(2, 8, 0));
        var5.setOpaque(false);
        var5.add(this.skadeCountLabel);
        var5.add(this.hurtigVisSkadeBtn);
        var1.add(var5, "East");
        return var1;
    }

    private JPanel buildBilPanel() {
        JPanel var1 = this.createFormPanel("Bilforsikring");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Kundenr", this.bilKundeFelt);
        this.addLabeledRow(var1, var2++, "Reg.nr", this.bilRegNrFelt);
        this.addLabeledRow(var1, var2++, "Type", this.bilTypeCombo);
        this.addLabeledRow(var1, var2++, "Modell", this.bilModellFelt);
        this.addLabeledRow(var1, var2++, "Lengde", this.bilLengdeFelt);
        this.addLabeledRow(var1, var2++, "Årsmodell", this.bilAarFelt);
        this.addLabeledRow(var1, var2++, "Motor type", this.bilMotorTypeFelt);
        this.addLabeledRow(var1, var2++, "Motorstyrke", this.bilMotorStyrkeFelt);
        this.addButtonRow(var1, var2, this.leggTilBilBtn, this.visBilBtn);
        return var1;
    }

    private JPanel buildHusPanel() {
        JPanel var1 = this.createFormPanel("Hus/innbo");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Kundenr", this.husKundeFelt);
        this.addLabeledRow(var1, var2++, "Adresse", this.husAdresseFelt);
        this.addLabeledRow(var1, var2++, "Boligtype", this.husBoligtypeFelt);
        this.addLabeledRow(var1, var2++, "Materiale", this.husMaterialeFelt);
        this.addLabeledRow(var1, var2++, "Antall m2", this.husAntallM2Felt);
        this.addLabeledRow(var1, var2++, "Beløp B", this.husBelopBFelt);
        this.addLabeledRow(var1, var2++, "Beløp I", this.husBelopIFelt);
        this.addLabeledRow(var1, var2++, "Byggeår", this.husByggeaarFelt);
        this.addLabeledRow(var1, var2++, "Standard", this.husStandardFelt);
        this.addLabeledRow(var1, var2++, "Bonus", this.husBonusFelt);
        this.addButtonRow(var1, var2, this.leggTilHusBtn, this.visHusBtn);
        return var1;
    }

    private JPanel createFormPanel(String var1) {
        JPanel var2 = new JPanel(new GridBagLayout());
        var2.setOpaque(true);
        var2.setBackground(CARD_BACKGROUND_COLOR);
        var2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), var1, 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        return var2;
    }

    private void addLabeledRow(JPanel var1, int var2, String var3, JComponent var4) {
        GridBagConstraints var5 = new GridBagConstraints();
        var5.gridx = 0;
        var5.gridy = var2;
        var5.anchor = 17;
        var5.insets = LABEL_INSETS;
        GridBagConstraints var6 = new GridBagConstraints();
        var6.gridx = 1;
        var6.gridy = var2;
        var6.weightx = (double)1.0F;
        var6.fill = 2;
        var6.insets = FIELD_INSETS;
        JLabel var7 = new JLabel(var3);
        var7.setFont(LABEL_FONT);
        var7.setForeground(new Color(74, 82, 97));
        var1.add(var7, var5);
        var1.add(var4, var6);
    }

    private void addButtonRow(JPanel var1, int var2, JComponent var3, JComponent var4) {
        GridBagConstraints var5 = new GridBagConstraints();
        var5.gridx = 0;
        var5.gridy = var2;
        var5.fill = 2;
        var5.insets = BUTTON_INSETS_LEFT;
        GridBagConstraints var6 = new GridBagConstraints();
        var6.gridx = 1;
        var6.gridy = var2;
        var6.fill = 2;
        var6.insets = BUTTON_INSETS_RIGHT;
        var1.add(var3, var5);
        var1.add(var4, var6);
    }

    private void addSingleButtonRow(JPanel var1, int var2, JComponent var3) {
        GridBagConstraints var4 = new GridBagConstraints();
        var4.gridx = 0;
        var4.gridy = var2;
        var4.gridwidth = 2;
        var4.fill = 2;
        var4.insets = SINGLE_BUTTON_INSETS;
        var1.add(var3, var4);
    }

    private void styleTextField(JTextField var1) {
        var1.setFont(FIELD_FONT);
        var1.setPreferredSize(new Dimension(170, 30));
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(203, 210, 220)), BorderFactory.createEmptyBorder(4, 8, 4, 8)));
    }

    private void styleButton(JButton var1) {
        var1.setFont(new Font("SansSerif", 1, 12));
        var1.setFocusPainted(false);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(196, 204, 216)), BorderFactory.createEmptyBorder(7, 12, 7, 12)));
        var1.setBackground(Color.WHITE);
        var1.setForeground(new Color(42, 49, 61));
        var1.setOpaque(true);
        var1.setCursor(Cursor.getPredefinedCursor(12));
    }

    private void stylePrimaryButton(JButton var1) {
        var1.setBackground(BUTTON_PRIMARY_COLOR);
        var1.setForeground(BUTTON_PRIMARY_TEXT_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(BUTTON_PRIMARY_COLOR.darker()), BorderFactory.createEmptyBorder(7, 12, 7, 12)));
    }

    private ActionListener action(Runnable var1) {
        return var2 -> var1.run();
    }

    private void wireEvents() {
        this.leggTilKundeBtn.addActionListener(this.action(this::leggTilKunde));
        this.finnKundeBtn.addActionListener(this.action(this::finnKunde));
        this.slettKundeBtn.addActionListener(this.action(this::slettKunde));
        this.leggTilBilBtn.addActionListener(this.action(this::leggTilBil));
        this.visBilBtn.addActionListener(this.action(() -> this.utskrift.setText(this.lister.visbiltostring())));
        this.leggTilHusBtn.addActionListener(this.action(this::leggTilHus));
        this.visHusBtn.addActionListener(this.action(() -> this.utskrift.setText(this.lister.visHusogInnbo())));
        this.leggTilFriBtn.addActionListener(this.action(this::leggTilFritidsbolig));
        this.visFriBtn.addActionListener(this.action(() -> this.utskrift.setText(this.lister.visFritidsbo())));
        this.leggTilSkadeBtn.addActionListener(this.action(this::leggTilSkadeMelding));
        this.visSkadeBtn.addActionListener(this.action(this::visSkadeMeldinger));
        this.hurtigVisSkadeBtn.addActionListener(this.action(this::visSkadeMeldinger));
        this.lagreBtn.addActionListener(this.action(this::lagre));
        this.lastBtn.addActionListener(this.action(this::laste));
        this.visLagretBtn.addActionListener(this.action(this::visLagretData));
    }

    private void setUiBusy(boolean var1, String var2) {
        JButton[] var3 = new JButton[]{this.leggTilKundeBtn, this.finnKundeBtn, this.slettKundeBtn, this.leggTilBilBtn, this.visBilBtn, this.leggTilHusBtn, this.visHusBtn, this.leggTilFriBtn, this.visFriBtn, this.leggTilSkadeBtn, this.visSkadeBtn, this.lagreBtn, this.lastBtn, this.visLagretBtn, this.hurtigVisSkadeBtn};

        for(JButton var7 : var3) {
            var7.setEnabled(!var1);
        }

        this.setCursor(var1 ? Cursor.getPredefinedCursor(3) : Cursor.getDefaultCursor());
        if (var2 != null && !var2.isEmpty()) {
            this.utskrift.setText(var2);
        }

    }

    private void lagreAsync() {
        this.setUiBusy(true, "Lagrer...");
        (new SwingWorker<Void, Void>() {
            protected Void doInBackground() throws Exception {
                Vindutest.this.lagreIO();
                return null;
            }

            protected void done() {
                try {
                    this.get();
                    Vindutest.this.utskrift.setText("Lagret.");
                } catch (InterruptedException var2) {
                    Thread.currentThread().interrupt();
                    Vindutest.this.melding("Lagringen ble avbrutt");
                } catch (java.util.concurrent.ExecutionException var3) {
                    Throwable var1 = var3.getCause();
                    Vindutest.this.melding("Kunne ikke lagre: " + (var1 != null ? var1.getMessage() : var3.getMessage()));
                } finally {
                    Vindutest.this.setUiBusy(false, (String)null);
                }

            }
        }).execute();
    }

    private void lasteAsync() {
        this.setUiBusy(true, "Laster...");
        (new SwingWorker<Lister, Void>() {
            protected Lister doInBackground() throws Exception {
                return Vindutest.this.lasteIO();
            }

            protected void done() {
                try {
                    Lister var1 = this.get();
                    Vindutest.this.copyLister(var1);
                    Vindutest.this.refreshSkadeCountBadge();
                    Vindutest.this.utskrift.setText("Data lastet.");
                } catch (InterruptedException var3) {
                    Thread.currentThread().interrupt();
                    Vindutest.this.melding("Lastingen ble avbrutt");
                } catch (java.util.concurrent.ExecutionException var4) {
                    Throwable var2 = var4.getCause();
                    Vindutest.this.melding("Kunne ikke laste: " + (var2 != null ? var2.getMessage() : var4.getMessage()));
                } finally {
                    Vindutest.this.setUiBusy(false, (String)null);
                }

            }
        }).execute();
    }

    private void configureValidation() {
        JTextField[] var1 = new JTextField[]{this.navnFelt, this.adresseFelt, this.kundeNrFelt, this.bilKundeFelt, this.bilRegNrFelt, this.bilModellFelt, this.bilLengdeFelt, this.bilAarFelt, this.bilMotorTypeFelt, this.bilMotorStyrkeFelt, this.husKundeFelt, this.husAdresseFelt, this.husBoligtypeFelt, this.husMaterialeFelt, this.husAntallM2Felt, this.husBelopBFelt, this.husBelopIFelt, this.husByggeaarFelt, this.husStandardFelt, this.husBonusFelt, this.friKundeFelt, this.friAdresseFelt, this.friBoligtypeFelt, this.friMaterialeFelt, this.friStandardFelt, this.friAntallM2Felt, this.friBelopBFelt, this.friBelopIFelt, this.friByggeaarFelt, this.friBonusFelt, this.skadeDatoFelt, this.skadeNummerFelt, this.skadeBeskrivelseFelt, this.skadeVitneKontaktFelt, this.skadeTakseringFelt, this.skadeUtbetaltFelt, this.skadeKoblingReferanseFelt};

        for(JTextField var5 : var1) {
            this.installClearErrorOnEdit(var5);
        }

        JTextField[] var7 = new JTextField[]{this.kundeNrFelt, this.bilKundeFelt, this.bilLengdeFelt, this.bilAarFelt, this.bilMotorStyrkeFelt, this.husKundeFelt, this.husAntallM2Felt, this.husBelopBFelt, this.husBelopIFelt, this.husByggeaarFelt, this.husBonusFelt, this.friKundeFelt, this.friAntallM2Felt, this.friBelopBFelt, this.friBelopIFelt, this.friByggeaarFelt, this.friBonusFelt, this.skadeNummerFelt};

        for(JTextField var6 : var7) {
            ((AbstractDocument)var6.getDocument()).setDocumentFilter(new DigitsOnlyFilter());
        }

    }

    private void installClearErrorOnEdit(JTextField var1) {
        var1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent var1x) {
                Vindutest.this.clearFieldError(var1);
            }

            public void removeUpdate(DocumentEvent var1x) {
                Vindutest.this.clearFieldError(var1);
            }

            public void changedUpdate(DocumentEvent var1x) {
                Vindutest.this.clearFieldError(var1);
            }
        });
    }

    private boolean hasMissingRequiredFields(String var1, JTextField... var2) {
        for(JTextField var6 : var2) {
            if (var6.getText().trim().isEmpty()) {
                this.markFieldError(var6);
                var6.requestFocusInWindow();
                this.melding(var1);
                return true;
            }
        }

        return false;
    }

    private Integer parseRequiredInt(JTextField var1, String var2, int var3) {
        String var4 = var1.getText().trim();
        if (var4.isEmpty()) {
            this.markFieldError(var1);
            var1.requestFocusInWindow();
            this.melding(var2 + " må fylles ut");
            return null;
        } else {
            try {
                int var5 = Integer.parseInt(var4);
                if (var5 < var3) {
                    this.markFieldError(var1);
                    var1.requestFocusInWindow();
                    this.melding(var2 + " må være minst " + var3);
                    return null;
                } else {
                    this.clearFieldError(var1);
                    return var5;
                }
            } catch (NumberFormatException var6) {
                this.markFieldError(var1);
                var1.requestFocusInWindow();
                this.melding(var2 + " må være et heltall");
                return null;
            }
        }
    }

    private Double parseRequiredDouble(JTextField var1, String var2, double var3) {
        String var5 = var1.getText().trim().replace(',', '.');
        if (var5.isEmpty()) {
            this.markFieldError(var1);
            var1.requestFocusInWindow();
            this.melding(var2 + " må fylles ut");
            return null;
        } else {
            try {
                double var6 = Double.parseDouble(var5);
                if (var6 < var3) {
                    this.markFieldError(var1);
                    var1.requestFocusInWindow();
                    this.melding(var2 + " må være minst " + var3);
                    return null;
                } else {
                    this.clearFieldError(var1);
                    return var6;
                }
            } catch (NumberFormatException var8) {
                this.markFieldError(var1);
                var1.requestFocusInWindow();
                this.melding(var2 + " må være et tall");
                return null;
            }
        }
    }

    private Date parseRequiredDate(JTextField var1, String var2) {
        String var3 = var1.getText().trim();
        if (var3.isEmpty()) {
            this.markFieldError(var1);
            var1.requestFocusInWindow();
            this.melding(var2 + " må fylles ut");
            return null;
        } else {
            try {
                LocalDate var4 = LocalDate.parse(var3);
                this.clearFieldError(var1);
                return Date.from(var4.atStartOfDay(ZoneId.systemDefault()).toInstant());
            } catch (DateTimeParseException var5) {
                this.markFieldError(var1);
                var1.requestFocusInWindow();
                this.melding(var2 + " må være på formatet yyyy-MM-dd");
                return null;
            }
        }
    }

    private void markFieldError(JTextField var1) {
        var1.setBackground(INVALID_FIELD_COLOR);
    }

    private void clearFieldError(JTextField var1) {
        var1.setBackground(this.defaultFieldColor);
    }

    private void leggTilKunde() {
        String var1 = this.navnFelt.getText().trim();
        String var2 = this.adresseFelt.getText().trim();
        if (!this.hasMissingRequiredFields("Du må fylle ut navn og adresse", this.navnFelt, this.adresseFelt)) {
            Kunde var3 = new Kunde(var1, var2, (Calendar)null);
            this.lister.leggTilKunde(var3);
            this.utskrift.setText("Kunde lagt til:\n" + String.valueOf(var3));
            this.kundeNrFelt.setText(String.valueOf(var3.getKundeNr()));
            this.bilKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.husKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.friKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.navnFelt.setText("");
            this.adresseFelt.setText("");
        }
    }

    private void finnKunde() {
        Integer var1 = this.parseRequiredInt(this.kundeNrFelt, "Kundenummer", 1);
        if (var1 != null) {
            Kunde var2 = this.lister.finnKunder(var1);
            this.utskrift.setText(var2 == null ? "Fant ikke kunde med kundenr: " + var1 : var2.toString());
        }
    }

    private void slettKunde() {
        Integer var1 = this.parseRequiredInt(this.kundeNrFelt, "Kundenummer", 1);
        if (var1 != null) {
            boolean var2 = this.lister.fjernKunde(var1);
            this.utskrift.setText(var2 ? "Kunde slettet" : "Fant ikke kunde");
        }
    }

    private void leggTilBil() {
        String var1 = this.bilRegNrFelt.getText().trim().toUpperCase();
        Bilforsikring.BilType var2 = (Bilforsikring.BilType)this.bilTypeCombo.getSelectedItem();
        String var3 = var2 == null ? "" : var2.name();
        String var4 = this.bilModellFelt.getText().trim();
        String var5 = this.bilMotorTypeFelt.getText().trim();
        if (!this.hasMissingRequiredFields("Fyll ut alle bilfeltene", this.bilRegNrFelt, this.bilModellFelt, this.bilMotorTypeFelt)) {
            if (var2 == null) {
                this.melding("Velg biltype");
            } else {
                Integer var6 = this.parseRequiredInt(this.bilKundeFelt, "Kundenummer", 1);
                Integer var7 = this.parseRequiredInt(this.bilLengdeFelt, "Lengde", 1);
                Integer var8 = this.parseRequiredInt(this.bilAarFelt, "Årsmodell", 1);
                Integer var9 = this.parseRequiredInt(this.bilMotorStyrkeFelt, "Motorstyrke", 1);
                if (var6 != null && var7 != null && var8 != null && var9 != null) {
                    if (this.lister.finnBil(var1) != null) {
                        this.markFieldError(this.bilRegNrFelt);
                        this.bilRegNrFelt.requestFocusInWindow();
                        this.melding("Bil med samme registreringsnummer finnes fra før");
                    } else {
                        Kunde var10 = this.lister.finnKunder(var6);
                        if (var10 == null) {
                            this.markFieldError(this.bilKundeFelt);
                            this.bilKundeFelt.requestFocusInWindow();
                            this.melding("Fant ikke kunde");
                        } else {
                            Bilforsikring var11 = new Bilforsikring((Calendar)null, var6, var1, var3, var4, var7, var8, var5, var9, 0);
                            var10.leggTilbil(var11);
                            var10.setBil(var11);
                            this.lister.leggTilbilForsikring(var11);
                            this.utskrift.setText("Bil registrert:\n" + String.valueOf(var11));
                            this.clearBilFields();
                        }
                    }
                }
            }
        }
    }

    private void leggTilHus() {
        String var1 = this.husAdresseFelt.getText().trim();
        String var2 = this.husBoligtypeFelt.getText().trim();
        String var3 = this.husMaterialeFelt.getText().trim();
        String var4 = this.husStandardFelt.getText().trim();
        if (!this.hasMissingRequiredFields("Fyll ut alle husfeltene", this.husAdresseFelt, this.husBoligtypeFelt, this.husMaterialeFelt, this.husStandardFelt)) {
            Integer var5 = this.parseRequiredInt(this.husKundeFelt, "Kundenummer", 1);
            Integer var6 = this.parseRequiredInt(this.husAntallM2Felt, "Antall m2", 1);
            Integer var7 = this.parseRequiredInt(this.husBelopBFelt, "Beløp B", 0);
            Integer var8 = this.parseRequiredInt(this.husBelopIFelt, "Beløp I", 0);
            Integer var9 = this.parseRequiredInt(this.husByggeaarFelt, "Byggeår", 1);
            Integer var10 = this.parseRequiredInt(this.husBonusFelt, "Bonus", 0);
            if (var5 != null && var6 != null && var7 != null && var8 != null && var9 != null && var10 != null) {
                Kunde var11 = this.lister.finnKunder(var5);
                if (var11 == null) {
                    this.markFieldError(this.husKundeFelt);
                    this.husKundeFelt.requestFocusInWindow();
                    this.melding("Fant ikke kunde");
                } else {
                    Husoginnboforsikring var12 = new Husoginnboforsikring(var5, var1, var2, (Calendar)null, var3, var6, var7, var8, var9, var4, 0);
                    var12.setBonus((double)var10);
                    var11.addHusForsikring(var12);
                    this.lister.getHusoginnboforsikrings().add(var12);
                    this.lister.nyForsikring(var12);
                    this.utskrift.setText("Hus/innbo registrert:\n" + String.valueOf(var12));
                    this.clearHusFields();
                }
            }
        }
    }

    private void leggTilFritidsbolig() {
        String var1 = this.friAdresseFelt.getText().trim();
        String var2 = this.friBoligtypeFelt.getText().trim();
        String var3 = this.friMaterialeFelt.getText().trim();
        String var4 = this.friStandardFelt.getText().trim();
        if (!this.hasMissingRequiredFields("Fyll ut alle fritidsboligfeltene", this.friAdresseFelt, this.friBoligtypeFelt, this.friMaterialeFelt, this.friStandardFelt)) {
            Integer var5 = this.parseRequiredInt(this.friKundeFelt, "Kundenummer", 1);
            Integer var6 = this.parseRequiredInt(this.friAntallM2Felt, "Antall m2", 1);
            Integer var7 = this.parseRequiredInt(this.friBelopBFelt, "Beløp B", 0);
            Integer var8 = this.parseRequiredInt(this.friBelopIFelt, "Beløp I", 0);
            Integer var9 = this.parseRequiredInt(this.friByggeaarFelt, "Byggeår", 1);
            Integer var10 = this.parseRequiredInt(this.friBonusFelt, "Bonus", 0);
            if (var5 != null && var6 != null && var7 != null && var8 != null && var9 != null && var10 != null) {
                Kunde var11 = this.lister.finnKunder(var5);
                if (var11 == null) {
                    this.markFieldError(this.friKundeFelt);
                    this.friKundeFelt.requestFocusInWindow();
                    this.melding("Fant ikke kunde");
                } else {
                    FritidsboligForsikiring var12 = new FritidsboligForsikiring(var1, (Calendar)null, var2, var3, var4, var8, var7, var9, var6, (double)var10, 0);
                    var11.addFritidshusForsikring(var12);
                    this.lister.leggTilFridsboligForsikiring(var12);
                    this.lister.nyForsikring(var12);
                    this.utskrift.setText("Fritidsbolig registrert:\n" + String.valueOf(var12));
                    this.clearFriFields();
                }
            }
        }
    }

    private void leggTilSkadeMelding() {
        if (!this.hasMissingRequiredFields("Fyll ut dato, beskrivelse og vitnekontakt", this.skadeDatoFelt, this.skadeBeskrivelseFelt, this.skadeVitneKontaktFelt)) {
            String var1 = (String)this.skadeKoblingTypeCombo.getSelectedItem();
            String var2 = this.skadeKoblingReferanseFelt.getText().trim();
            if (var2.isEmpty()) {
                this.markFieldError(this.skadeKoblingReferanseFelt);
                this.skadeKoblingReferanseFelt.requestFocusInWindow();
                this.melding("Fyll ut referanse for valgt objekt");
            } else {
                String var3 = null;
                String var4 = null;
                String var5 = null;
                if ("HUS".equals(var1)) {
                    if (this.lister.finnHus(var2) == null) {
                        this.markFieldError(this.skadeKoblingReferanseFelt);
                        this.skadeKoblingReferanseFelt.requestFocusInWindow();
                        this.melding("Fant ikke hus med denne adressen");
                        return;
                    }

                    var3 = var2;
                } else if ("FRITIDSBOLIG".equals(var1)) {
                    if (this.lister.finnfritidsHus(var2) == null) {
                        this.markFieldError(this.skadeKoblingReferanseFelt);
                        this.skadeKoblingReferanseFelt.requestFocusInWindow();
                        this.melding("Fant ikke fritidsbolig med denne adressen");
                        return;
                    }

                    var4 = var2;
                } else {
                    String var6 = var2.toUpperCase();
                    if (this.lister.finnBaat(var6) == null) {
                        this.markFieldError(this.skadeKoblingReferanseFelt);
                        this.skadeKoblingReferanseFelt.requestFocusInWindow();
                        this.melding("Fant ikke baat med dette registreringsnummeret");
                        return;
                    }

                    var5 = var6;
                }

                Date var12 = this.parseRequiredDate(this.skadeDatoFelt, "Dato");
                Integer var7 = this.parseRequiredInt(this.skadeNummerFelt, "Skadenummer", 1);
                Double var8 = this.parseRequiredDouble(this.skadeTakseringFelt, "Taksering belop", (double)0.0F);
                Double var9 = this.parseRequiredDouble(this.skadeUtbetaltFelt, "Utbetalt belop", (double)0.0F);
                if (var12 != null && var7 != null && var8 != null && var9 != null) {
                    SkadeMelding var10 = new SkadeMelding(var12, (TypeSkade)this.skadeTypeCombo.getSelectedItem());
                    var10.setSkadeNummer(var7);
                    var10.setBeskrivelse(this.skadeBeskrivelseFelt.getText().trim());
                    var10.setVitnerKontaktInfo(this.skadeVitneKontaktFelt.getText().trim());
                    var10.setTakseringBeløp(var8);
                    var10.setUtbetaltErstatningsBeløp(var9);
                    var10.setKobletHusAdresse(var3 == null || var3.isEmpty() ? null : var3);
                    var10.setKobletFritidsboligAdresse(var4 == null || var4.isEmpty() ? null : var4);
                    var10.setKobletBaatRegistreringsnummer(var5 == null || var5.isEmpty() ? null : var5);
                    boolean var11 = this.lister.nySkadeMelding(var10);
                    if (!var11) {
                        this.melding("Kunne ikke registrere skademelding");
                    } else {
                        this.refreshSkadeCountBadge();
                        this.utskrift.setText("Skademelding registrert:\n" + String.valueOf(var10));
                        this.clearSkadeFields();
                    }
                }
            }
        }
    }

    private void visSkadeMeldinger() {
        this.refreshSkadeCountBadge();
        this.utskrift.setText(this.lister.visSkadeMeldinger());
    }

    private void refreshSkadeCountBadge() {
        this.skadeCountLabel.setText("Skader: " + this.lister.getSkadeMeldinger().size());
    }

    private void lagre() {
        this.lagreAsync();
    }

    private void laste() {
        this.lasteAsync();
    }

    private void lagreIO() throws IOException {
        this.persistenceService.save(this.lister, this.snapshotFormatter.buildListerTextSnapshot(this.lister));
    }

    private Lister lasteIO() throws IOException, ClassNotFoundException {
        return this.persistenceService.load();
    }

    private boolean showFallbackCustomerList() {
        try {
            String var1 = Files.readString(Path.of("Kunderliste.txt"));
            StringBuilder var2 = new StringBuilder();
            this.appendFileHeader(var2, "Kunderliste.txt");
            this.appendFormattedText(var2, this.snapshotFormatter.formatLegacyCustomerText(var1));
            this.utskrift.setText(var2.toString());
            return true;
        } catch (IOException var3) {
            return false;
        }
    }

    private void visLagretData() {
        StringBuilder var1 = new StringBuilder();
        this.appendFileHeader(var1, "Kunderliste.txt");

        try {
            String var2 = Files.readString(Path.of("Kunderliste.txt"));
            this.appendFormattedText(var1, this.snapshotFormatter.formatLegacyCustomerText(var2));
        } catch (IOException var5) {
            var1.append("Kunne ikke lese fil: ").append(var5.getMessage()).append("\n\n");
        }

        this.appendFileHeader(var1, "lister.txt");

        try {
            String var6 = this.persistenceService.readTextSnapshot();
            if (this.persistenceService.containsBinaryCharacters(var6)) {
                Lister var3 = this.lasteIO();
                var6 = this.snapshotFormatter.buildListerTextSnapshot(var3);
                this.persistenceService.writeTextSnapshot(var6);
            }

            this.appendFormattedText(var1, var6);
        } catch (ClassNotFoundException | IOException var4) {
            var1.append("Kunne ikke lese fil: ").append(((Exception)var4).getMessage()).append("\n");
        }

        this.utskrift.setText(var1.toString());
    }

    private void appendSection(StringBuilder var1, String var2, String var3) {
        var1.append("-- ").append(var2).append(" --\n");
        this.appendFormattedText(var1, this.snapshotFormatter.formatSectionEntries(var3));
    }

    private void appendFileHeader(StringBuilder var1, String var2) {
        if (!var1.isEmpty()) {
            var1.append("\n");
        }

        var1.append("=== ").append(var2).append(" ===\n");
    }

    private void appendFormattedText(StringBuilder var1, String var2) {
        String var3 = this.snapshotFormatter.normalizeTextForDisplay(var2);
        var1.append(var3.isEmpty() ? "Ingen data" : var3).append("\n\n");
    }

    private void copyLister(Lister var1) {
        this.lister.getKundeListe().clear();
        this.lister.getKundeListe().addAll(var1.getKundeListe());
        this.lister.getBaatForsikringsliste().clear();
        this.lister.getBaatForsikringsliste().addAll(var1.getBaatForsikringsliste());
        this.lister.getBilForsikringsLIste().clear();
        this.lister.getBilForsikringsLIste().addAll(var1.getBilForsikringsLIste());
        this.lister.getHusoginnboforsikrings().clear();
        this.lister.getHusoginnboforsikrings().addAll(var1.getHusoginnboforsikrings());
        this.lister.getFritidsboligForsikirings().clear();
        this.lister.getFritidsboligForsikirings().addAll(var1.getFritidsboligForsikirings());
        this.lister.getReisesliste().clear();
        this.lister.getReisesliste().addAll(var1.getReisesliste());
        this.lister.getSkadeMeldinger().clear();
        this.lister.getSkadeMeldinger().addAll(var1.getSkadeMeldinger());
        this.syncNextCustomerNumber();
    }

    private void syncNextCustomerNumber() {
        int var1 = 0;

        for(Kunde var3 : this.lister.getKundeListe()) {
            var1 = Math.max(var1, var3.getKundeNr() + 1);
        }

        if (!this.lister.getKundeListe().isEmpty()) {
            ((Kunde)this.lister.getKundeListe().iterator().next()).setKundeNr(var1);
        }

    }

    private void clearBilFields() {
        this.bilKundeFelt.setText("");
        this.bilRegNrFelt.setText("");
        this.bilTypeCombo.setSelectedIndex(0);
        this.bilModellFelt.setText("");
        this.bilLengdeFelt.setText("");
        this.bilAarFelt.setText("");
        this.bilMotorTypeFelt.setText("");
        this.bilMotorStyrkeFelt.setText("");
    }

    private void clearHusFields() {
        this.husKundeFelt.setText("");
        this.husAdresseFelt.setText("");
        this.husBoligtypeFelt.setText("");
        this.husMaterialeFelt.setText("");
        this.husAntallM2Felt.setText("");
        this.husBelopBFelt.setText("");
        this.husBelopIFelt.setText("");
        this.husByggeaarFelt.setText("");
        this.husStandardFelt.setText("");
        this.husBonusFelt.setText("");
    }

    private void clearFriFields() {
        this.friKundeFelt.setText("");
        this.friAdresseFelt.setText("");
        this.friBoligtypeFelt.setText("");
        this.friMaterialeFelt.setText("");
        this.friStandardFelt.setText("");
        this.friAntallM2Felt.setText("");
        this.friBelopBFelt.setText("");
        this.friBelopIFelt.setText("");
        this.friByggeaarFelt.setText("");
        this.friBonusFelt.setText("");
    }

    private void clearSkadeFields() {
        this.skadeDatoFelt.setText("");
        this.skadeNummerFelt.setText("");
        this.skadeTypeCombo.setSelectedIndex(0);
        this.skadeBeskrivelseFelt.setText("");
        this.skadeVitneKontaktFelt.setText("");
        this.skadeTakseringFelt.setText("");
        this.skadeUtbetaltFelt.setText("");
        this.skadeKoblingTypeCombo.setSelectedIndex(0);
        this.skadeKoblingReferanseFelt.setText("");
    }

    private void melding(String var1) {
        JOptionPane.showMessageDialog(this, var1, "Feil", 0);
    }

    public void skrivTilFil() {
        try {
            this.lagreIO();
            this.utskrift.setText("Lagret.");
        } catch (IOException var2) {
            this.melding("Kunne ikke lagre: " + var2.getMessage());
        }

    }

    private static final class DigitsOnlyFilter extends DocumentFilter {
        public void insertString(DocumentFilter.FilterBypass var1, int var2, String var3, AttributeSet var4) throws BadLocationException {
            if (var3 != null && this.isDigits(var3)) {
                super.insertString(var1, var2, var3, var4);
            }

        }

        public void replace(DocumentFilter.FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) throws BadLocationException {
            String var6 = var4 == null ? "" : var4;
            if (this.isDigits(var6)) {
                super.replace(var1, var2, var3, var4, var5);
            }

        }

        private boolean isDigits(String var1) {
            for(int var2 = 0; var2 < var1.length(); ++var2) {
                if (!Character.isDigit(var1.charAt(var2))) {
                    return false;
                }
            }

            return true;
        }
    }

    static {
        CARD_BACKGROUND_COLOR = Color.WHITE;
        CARD_BORDER_COLOR = new Color(214, 220, 229);
        BUTTON_PRIMARY_COLOR = new Color(47, 111, 237);
        BUTTON_PRIMARY_TEXT_COLOR = Color.WHITE;
        OUTPUT_BACKGROUND_COLOR = new Color(251, 252, 253);
        OUTPUT_BORDER_COLOR = new Color(210, 216, 226);
        INVALID_FIELD_COLOR = new Color(255, 235, 238);
        SECTION_TITLE_FONT = new Font("SansSerif", 1, 13);
        LABEL_FONT = new Font("SansSerif", 0, 12);
        FIELD_FONT = new Font("SansSerif", 0, 13);
        OUTPUT_FONT = new Font("Monospaced", 0, 13);
        LABEL_INSETS = new Insets(4, 0, 4, 10);
        FIELD_INSETS = new Insets(4, 0, 4, 0);
        BUTTON_INSETS_LEFT = new Insets(12, 0, 0, 8);
        BUTTON_INSETS_RIGHT = new Insets(12, 0, 0, 0);
        SINGLE_BUTTON_INSETS = new Insets(12, 0, 0, 0);
    }
}
