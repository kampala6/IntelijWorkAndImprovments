//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
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
import javax.swing.WindowConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import projektoppgave3_2015.Bilforsikring.BilType;

/**
 * The Vindutest class serves as the primary graphical user interface for managing customers, vehicles,
 * houses, leisure properties, and claims within an insurance application. It is built on top of the JFrame
 * class and provides a comprehensive set of components and methods for user interaction, data management,
 * and application logic.
 *
 * Responsibilities:
 * - Manages the layout and composition of GUI panels, including header, dashboard, input forms,
 *   output sections, and actionable buttons.
 * - Handles user actions such as creating, reading, updating, and deleting data for customers,
 *   vehicles, houses, leisure properties, and claims.
 * - Performs validation on user-provided input fields to ensure data integrity.
 * - Incorporates application-wide styling and consistent visual elements.
 * - Integrates with persistence services to save and load data asynchronously or using serialized files.
 * - Automates form field state management and preparation for new or modified entries.
 *
 * Features:
 * - Form panels for customer details, vehicle insurance, house insurance, leisure insurance, and claims management.
 * - Buttons for actions such as adding, finding, deleting customers, and showing data for various entities.
 * - Validation utilities to check required fields, numeric and date conversions, and error flagging.
 * - Support for persistence using external files, with fallback mechanisms for data integrity.
 * - Clear visual feedback for mandatory fields, inline error correction, and warnings.
 */
public final class Vindutest extends JFrame {
    private static final long serialVersionUID = 1L;
    private final Lister lister = new Lister();
    private final JTextArea utskrift = new JTextArea(25, 60);
    private final JTextField navnFelt = new PlaceholderTextField(10);
    private final JTextField adresseFelt = new PlaceholderTextField(10);
    private final JTextField kundeNrFelt = new PlaceholderTextField(10);
    private final JTextField bilKundeFelt = new PlaceholderTextField(10);
    private final JTextField bilRegNrFelt = new PlaceholderTextField(10);
    private final JComboBox<Bilforsikring.BilType> bilTypeCombo = new JComboBox<>(BilType.values());
    private final JTextField bilModellFelt = new PlaceholderTextField(10);
    private final JTextField bilLengdeFelt = new PlaceholderTextField(10);
    private final JTextField bilAarFelt = new PlaceholderTextField(10);
    private final JTextField bilMotorTypeFelt = new PlaceholderTextField(10);
    private final JTextField bilMotorStyrkeFelt = new PlaceholderTextField(10);
    private final JTextField husKundeFelt = new PlaceholderTextField(10);
    private final JTextField husAdresseFelt = new PlaceholderTextField(15);
    private final JTextField husBoligtypeFelt = new PlaceholderTextField(10);
    private final JTextField husMaterialeFelt = new PlaceholderTextField(10);
    private final JTextField husAntallM2Felt = new PlaceholderTextField(10);
    private final JTextField husBelopBFelt = new PlaceholderTextField(10);
    private final JTextField husBelopIFelt = new PlaceholderTextField(10);
    private final JTextField husByggeaarFelt = new PlaceholderTextField(10);
    private final JTextField husStandardFelt = new PlaceholderTextField(10);
    private final JTextField husBonusFelt = new PlaceholderTextField(10);
    private final JTextField reiseKundeFelt = new PlaceholderTextField(10);
    private final JTextField reiseOmradeFelt = new PlaceholderTextField(15);
    private final JTextField reiseSumFelt = new PlaceholderTextField(10);
    private final JTextField reiseBonusFelt = new PlaceholderTextField(10);
    private final JTextField friKundeFelt = new PlaceholderTextField(10);
    private final JTextField friAdresseFelt = new PlaceholderTextField(15);
    private final JTextField friBoligtypeFelt = new PlaceholderTextField(10);
    private final JTextField friMaterialeFelt = new PlaceholderTextField(10);
    private final JTextField friStandardFelt = new PlaceholderTextField(10);
    private final JTextField friAntallM2Felt = new PlaceholderTextField(10);
    private final JTextField friBelopBFelt = new PlaceholderTextField(10);
    private final JTextField friBelopIFelt = new PlaceholderTextField(10);
    private final JTextField friByggeaarFelt = new PlaceholderTextField(10);
    private final JTextField friBonusFelt = new PlaceholderTextField(10);
    private final JTextField skadeDatoFelt = new PlaceholderTextField(10);
    private final JTextField skadeKundeFelt = new PlaceholderTextField(10);
    private final JTextField skadeNummerFelt = new PlaceholderTextField(10);
    private final JComboBox<SkadeMelding.TypeSkade> skadeTypeCombo = new JComboBox<>(SkadeMelding.TypeSkade.values());
    private final JTextField skadeBeskrivelseFelt = new PlaceholderTextField(15);
    private final JTextField skadeVitneKontaktFelt = new PlaceholderTextField(15);
    private final JTextField skadeTakseringFelt = new PlaceholderTextField(10);
    private final JTextField skadeUtbetaltFelt = new PlaceholderTextField(10);
    private final JComboBox<SkadeMelding.SkadeObjectType> skadeKoblingTypeCombo = new JComboBox<>(SkadeMelding.SkadeObjectType.values());
    private final JTextField skadeKoblingReferanseFelt = new PlaceholderTextField(15);
    private final JButton leggTilKundeBtn = new JButton("Legg til kunde");
    private final JButton finnKundeBtn = new JButton("Finn kunde");
    private final JButton slettKundeBtn = new JButton("Slett kunde");
    private final JButton leggTilBilBtn = new JButton("Legg til bil");
    private final JButton visBilBtn = new JButton("Vis biler");
    private final JButton leggTilHusBtn = new JButton("Legg til hus/innbo");
    private final JButton visHusBtn = new JButton("Vis hus/innbo");
    private final JButton leggTilReiseBtn = new JButton("Legg til reise");
    private final JButton visReiseBtn = new JButton("Vis reiser");
    private final JButton leggTilFriBtn = new JButton("Legg til fritidsbolig");
    private final JButton visFriBtn = new JButton("Vis fritidsbolig");
    private final JButton leggTilSkadeBtn = new JButton("Legg til skademelding");
    private final JButton visSkadeBtn = new JButton("Vis skademeldinger");
    private final JButton hurtigVisSkadeBtn = new JButton("Skademeldinger");
    private final JLabel skadeCountLabel = new JLabel("Skader: 0");
    private final JButton lagreBtn = new JButton("Lagre");
    private final JButton lastBtn = new JButton("Last");
    private final JButton visLagretBtn = new JButton("Vis lagrede filer");
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
    private static final Color PLACEHOLDER_TEXT_COLOR;
    private static final Color HELPER_TEXT_COLOR;
    private static final Color HELPER_ERROR_TEXT_COLOR;
    private final Color defaultFieldColor = UIManager.getColor("TextField.background");
    private final Map<JTextField, JLabel> helperLabels = new IdentityHashMap<>();


    /**
     * Creates the main application window, initializes the dashboard, wires event handlers,
     * and loads any previously persisted data.
     */
    public Vindutest() {
        super("Forsikring 2026");
        this.initializeVisualStyle();
        JPanel var1 = new JPanel(new BorderLayout(12, 12));
        var1.setBackground(APP_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        var1.add(this.buildHeaderPanel(), "North");
        var1.add(this.buildDashboardContent(), "Center");
        this.setContentPane(var1);
        this.configurePlaceholders();
        this.configureValidation();
        this.wireEvents();
        this.loadPersistedDataOnStartup();
        this.refreshSkadeCountBadge();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setMinimumSize(new Dimension(1240, 860));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Builds the top banner containing the title, description, and dashboard badge.
     *
     * @return the configured header component
     */
    private JComponent buildHeaderPanel() {
        JPanel var1 = new JPanel(new BorderLayout(10, 6));
        var1.setOpaque(true);
        var1.setBackground(CARD_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), BorderFactory.createEmptyBorder(14, 16, 14, 16)));
        JLabel var2 = new JLabel("Forsikring 2026");
        var2.setFont(new Font("SansSerif", Font.BOLD, 22));
        var2.setForeground(new Color(34, 41, 52));
        JLabel var3 = new JLabel("Registrer kunder, opprett forsikringer og se lagrede data i ett samlet arbeidsområde.");
        var3.setFont(new Font("SansSerif", Font.PLAIN, 13));
        var3.setForeground(new Color(95, 104, 118));
        JPanel var4 = new JPanel();
        var4.setOpaque(false);
        var4.setLayout(new BoxLayout(var4, BoxLayout.Y_AXIS));
        var4.add(var2);
        var4.add(Box.createVerticalStrut(4));
        var4.add(var3);
        var1.add(var4, "Center");
        var1.add(this.createHeaderBadge(), "East");
        return var1;
    }

    /**
     * Builds the split layout that separates input forms from the output area.
     *
     * @return the main dashboard content component
     */
    private JComponent buildDashboardContent() {
        JSplitPane var1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.buildInputColumn(), this.buildRightColumn());
        var1.setOpaque(false);
        var1.setBorder(null);
        var1.setResizeWeight(0.53);
        var1.setContinuousLayout(true);
        var1.setDividerSize(10);
        var1.setOneTouchExpandable(true);
        return var1;
    }

    /**
     * Builds the scrollable left-side column containing all data entry forms.
     *
     * @return the input column component
     */
    private JComponent buildInputColumn() {
        JPanel var1 = new JPanel();
        var1.setOpaque(false);
        var1.setLayout(new BoxLayout(var1, BoxLayout.Y_AXIS));
        var1.add(this.buildKundePanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildForsikringPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildFriPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildSkadePanel());
        var1.add(Box.createVerticalGlue());
        JScrollPane var2 = new JScrollPane(var1);
        var2.setBorder(null);
        var2.setOpaque(false);
        var2.getViewport().setOpaque(false);
        var2.getVerticalScrollBar().setUnitIncrement(16);
        return var2;
    }

    /**
     * Builds the right-side column containing the output panel and persistence controls.
     *
     * @return the right-side dashboard component
     */
    private JComponent buildRightColumn() {
        JPanel var1 = new JPanel(new BorderLayout(0, 12));
        var1.setOpaque(false);
        var1.add(this.buildOutputPanel(), "Center");
        var1.add(this.buildBottomPanel(), "South");
        return var1;
    }

    /**
     * Creates a small highlighted badge used in the header area.
     *
     * @return the configured badge component
     */
    private JComponent createHeaderBadge() {
        JLabel var2 = new JLabel("Dashboard");
        var2.setOpaque(true);
        var2.setBackground(new Color(232, 240, 255));
        var2.setForeground(BUTTON_PRIMARY_COLOR.darker());
        var2.setFont(new Font("SansSerif", Font.BOLD, 12));
        var2.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        return var2;
    }

    /**
     * Applies shared visual styling to the frame, text fields, buttons, and output area.
     */
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
        JTextField[] var1 = new JTextField[]{this.navnFelt, this.adresseFelt, this.kundeNrFelt, this.bilKundeFelt, this.bilRegNrFelt, this.bilModellFelt, this.bilLengdeFelt, this.bilAarFelt, this.bilMotorTypeFelt, this.bilMotorStyrkeFelt, this.husKundeFelt, this.husAdresseFelt, this.husBoligtypeFelt, this.husMaterialeFelt, this.husAntallM2Felt, this.husBelopBFelt, this.husBelopIFelt, this.husByggeaarFelt, this.husStandardFelt, this.husBonusFelt, this.reiseKundeFelt, this.reiseOmradeFelt, this.reiseSumFelt, this.reiseBonusFelt, this.friKundeFelt, this.friAdresseFelt, this.friBoligtypeFelt, this.friMaterialeFelt, this.friStandardFelt, this.friAntallM2Felt, this.friBelopBFelt, this.friBelopIFelt, this.friByggeaarFelt, this.friBonusFelt, this.skadeDatoFelt, this.skadeKundeFelt, this.skadeNummerFelt, this.skadeBeskrivelseFelt, this.skadeVitneKontaktFelt, this.skadeTakseringFelt, this.skadeUtbetaltFelt, this.skadeKoblingReferanseFelt};

        for(JTextField var5 : var1) {
            this.styleTextField(var5);
        }

        JButton[] var7 = new JButton[]{this.leggTilKundeBtn, this.finnKundeBtn, this.slettKundeBtn, this.leggTilBilBtn, this.visBilBtn, this.leggTilHusBtn, this.visHusBtn, this.leggTilReiseBtn, this.visReiseBtn, this.leggTilFriBtn, this.visFriBtn, this.leggTilSkadeBtn, this.visSkadeBtn, this.lagreBtn, this.lastBtn, this.visLagretBtn, this.hurtigVisSkadeBtn};

        for(JButton var6 : var7) {
            this.styleButton(var6);
        }

        this.stylePrimaryButton(this.leggTilKundeBtn);
        this.stylePrimaryButton(this.leggTilBilBtn);
        this.stylePrimaryButton(this.leggTilHusBtn);
        this.stylePrimaryButton(this.leggTilReiseBtn);
        this.stylePrimaryButton(this.leggTilFriBtn);
        this.stylePrimaryButton(this.leggTilSkadeBtn);
        this.stylePrimaryButton(this.lagreBtn);
        this.bilTypeCombo.setFont(FIELD_FONT);
        this.bilTypeCombo.setBackground(Color.WHITE);
        this.skadeTypeCombo.setFont(FIELD_FONT);
        this.skadeTypeCombo.setBackground(Color.WHITE);
        this.skadeKoblingTypeCombo.setFont(FIELD_FONT);
        this.skadeKoblingTypeCombo.setBackground(Color.WHITE);
        this.skadeCountLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        this.skadeCountLabel.setOpaque(true);
        this.skadeCountLabel.setBackground(new Color(232, 240, 255));
        this.skadeCountLabel.setForeground(BUTTON_PRIMARY_COLOR.darker());
        this.skadeCountLabel.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
    }

    /**
     * Builds the customer registration panel.
     *
     * @return the customer form panel
     */
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

    /**
     * Builds the insurance section containing bil, hus, and reise forms.
     *
     * @return the insurance container panel
     */
    private JPanel buildForsikringPanel() {
        JPanel var1 = new JPanel();
        var1.setLayout(new BoxLayout(var1, BoxLayout.Y_AXIS));
        var1.setOpaque(true);
        var1.setBackground(CARD_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), "Forsikringer", 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        var1.add(this.buildBilPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildHusPanel());
        var1.add(Box.createVerticalStrut(12));
        var1.add(this.buildReisePanel());
        return var1;
    }

    /**
     * Builds the travel insurance form panel.
     *
     * @return the travel insurance form panel
     */
    private JPanel buildReisePanel() {
        JPanel var1 = this.createFormPanel("Reiseforsikring");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Kundenr", this.reiseKundeFelt);
        this.addLabeledRow(var1, var2++, "Område", this.reiseOmradeFelt);
        this.addLabeledRow(var1, var2++, "Sum", this.reiseSumFelt);
        this.addLabeledRow(var1, var2++, "Bonus (0-100)", this.reiseBonusFelt);
        this.addHelperRow(var1, var2++, this.reiseBonusFelt, "Bruk prosent 0-100. Desimaler som 12,5 er tillatt.");
        this.addButtonRow(var1, var2, this.leggTilReiseBtn, this.visReiseBtn);
        return var1;
    }

    /**
     * Builds the leisure property insurance form panel.
     *
     * @return the leisure property form panel
     */
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
        this.addLabeledRow(var1, var2++, "Bonus (0-100)", this.friBonusFelt);
        this.addButtonRow(var1, var2, this.leggTilFriBtn, this.visFriBtn);
        return var1;
    }

    /**
     * Builds the claim registration form panel.
     *
     * @return the claim form panel
     */
    private JPanel buildSkadePanel() {
        JPanel var1 = this.createFormPanel("Skademelding");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Dato", this.skadeDatoFelt);
        this.addHelperRow(var1, var2++, this.skadeDatoFelt, "Dato formateres automatisk som yyyy-MM-dd.");
        this.addLabeledRow(var1, var2++, "Kundenr", this.skadeKundeFelt);
        this.addLabeledRow(var1, var2++, "Skadenummer", this.skadeNummerFelt);
        this.addLabeledRow(var1, var2++, "Type skade", this.skadeTypeCombo);
        this.addLabeledRow(var1, var2++, "Beskrivelse", this.skadeBeskrivelseFelt);
        this.addLabeledRow(var1, var2++, "Vitne kontakt", this.skadeVitneKontaktFelt);
        this.addLabeledRow(var1, var2++, "Taksering (desimal)", this.skadeTakseringFelt);
        this.addHelperRow(var1, var2++, this.skadeTakseringFelt, "Tillater desimaler, for eksempel 12500,50.");
        this.addLabeledRow(var1, var2++, "Utbetalt (desimal)", this.skadeUtbetaltFelt);
        this.addHelperRow(var1, var2++, this.skadeUtbetaltFelt, "Tillater desimaler, for eksempel 10000,00.");
        this.addLabeledRow(var1, var2++, "Koblet objekt", this.skadeKoblingTypeCombo);
        this.addLabeledRow(var1, var2++, "Referanse", this.skadeKoblingReferanseFelt);
        this.addButtonRow(var1, var2, this.leggTilSkadeBtn, this.visSkadeBtn);
        return var1;
    }

    /**
     * Builds the bottom section that exposes save, load, and file-view actions.
     *
     * @return the persistence control panel
     */
    private JPanel buildBottomPanel() {
        JPanel var1 = new JPanel(new BorderLayout(0, 10));
        var1.setOpaque(true);
        var1.setBackground(CARD_BACKGROUND_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), "Lagring og filer", 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JLabel var2 = new JLabel("Lagre data, last inn tidligere arbeid eller vis innholdet i tekstfilene.");
        var2.setFont(new Font("SansSerif", Font.PLAIN, 12));
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

    /**
     * Builds the output area used to display results, logs, and file content.
     *
     * @return the output panel component
     */
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

    /**
     * Creates the toolbar shown above the output area.
     *
     * @return the configured toolbar component
     */
    private JComponent createOutputToolbar() {
        JPanel var1 = new JPanel(new BorderLayout());
        var1.setOpaque(false);
        var1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        JLabel var2 = new JLabel("Resultater");
        var2.setFont(new Font("SansSerif", Font.BOLD, 13));
        var2.setForeground(new Color(55, 63, 78));
        JLabel var3 = new JLabel("Visninger, søk og filinnhold blir vist her.");
        var3.setFont(new Font("SansSerif", Font.PLAIN, 12));
        var3.setForeground(new Color(95, 104, 118));
        JPanel var4 = new JPanel();
        var4.setOpaque(false);
        var4.setLayout(new BoxLayout(var4, BoxLayout.Y_AXIS));
        var4.add(var2);
        var4.add(Box.createVerticalStrut(2));
        var4.add(var3);
        var1.add(var4, "West");
        JPanel var5 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        var5.setOpaque(false);
        var5.add(this.skadeCountLabel);
        var5.add(this.hurtigVisSkadeBtn);
        var1.add(var5, "East");
        return var1;
    }

    /**
     * Builds the car insurance form panel.
     *
     * @return the car insurance form panel
     */
    private JPanel buildBilPanel() {
        JPanel var1 = this.createFormPanel("Bilforsikring");
        int var2 = 0;
        this.addLabeledRow(var1, var2++, "Kundenr", this.bilKundeFelt);
        this.addLabeledRow(var1, var2++, "Reg.nr (ABC123)", this.bilRegNrFelt);
        this.addLabeledRow(var1, var2++, "Type", this.bilTypeCombo);
        this.addLabeledRow(var1, var2++, "Modell", this.bilModellFelt);
        this.addLabeledRow(var1, var2++, "Lengde", this.bilLengdeFelt);
        this.addLabeledRow(var1, var2++, "Årsmodell", this.bilAarFelt);
        this.addLabeledRow(var1, var2++, "Motor type", this.bilMotorTypeFelt);
        this.addLabeledRow(var1, var2++, "Motorstyrke", this.bilMotorStyrkeFelt);
        this.addButtonRow(var1, var2, this.leggTilBilBtn, this.visBilBtn);
        return var1;
    }

    /**
     * Builds the house and contents insurance form panel.
     *
     * @return the house insurance form panel
     */
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
        this.addLabeledRow(var1, var2++, "Bonus (0-100)", this.husBonusFelt);
        this.addButtonRow(var1, var2, this.leggTilHusBtn, this.visHusBtn);
        return var1;
    }

    /**
     * Creates a standard form panel with a titled border and shared styling.
     *
     * @param var1 panel title
     * @return the initialized form panel
     */
    private JPanel createFormPanel(String var1) {
        JPanel var2 = new JPanel(new GridBagLayout());
        var2.setOpaque(true);
        var2.setBackground(CARD_BACKGROUND_COLOR);
        var2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR), var1, 1, 2, SECTION_TITLE_FONT, new Color(55, 63, 78)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        return var2;
    }

    /**
     * Adds one labeled input row to a form panel.
     *
     * @param var1 destination panel
     * @param var2 row index
     * @param var3 label text
     * @param var4 input component for the row
     */
    private void addLabeledRow(JPanel var1, int var2, String var3, JComponent var4) {
        GridBagConstraints var5 = new GridBagConstraints();
        var5.gridx = 0;
        var5.gridy = var2;
        var5.anchor = 17;
        var5.insets = LABEL_INSETS;
        GridBagConstraints var6 = new GridBagConstraints();
        var6.gridx = 1;
        var6.gridy = var2;
        var6.weightx = 1.0;
        var6.fill = GridBagConstraints.HORIZONTAL;
        var6.insets = FIELD_INSETS;
        JLabel var7 = new JLabel(var3);
        var7.setFont(LABEL_FONT);
        var7.setForeground(new Color(74, 82, 97));
        var1.add(var7, var5);
        var1.add(var4, var6);
    }

    /**
     * Adds a muted helper-text row beneath a form input.
     *
     * @param var1 destination panel
     * @param var2 row index
     * @param var3 helper text to display
     */
    private void addHelperRow(JPanel var1, int var2, JTextField var3, String var4) {
        GridBagConstraints var5 = new GridBagConstraints();
        var5.gridx = 1;
        var5.gridy = var2;
        var5.anchor = GridBagConstraints.WEST;
        var5.fill = GridBagConstraints.HORIZONTAL;
        var5.insets = new Insets(0, 0, 6, 0);
        JLabel var6 = new JLabel(var4);
        var6.setFont(new Font("SansSerif", Font.PLAIN, 11));
        var6.setForeground(HELPER_TEXT_COLOR);
        var1.add(var6, var5);
        this.helperLabels.put(var3, var6);
    }

    /**
     * Adds a row containing two side-by-side action components.
     *
     * @param var1 destination panel
     * @param var2 row index
     * @param var3 left component
     * @param var4 right component
     */
    private void addButtonRow(JPanel var1, int var2, JComponent var3, JComponent var4) {
        GridBagConstraints var5 = new GridBagConstraints();
        var5.gridx = 0;
        var5.gridy = var2;
        var5.fill = GridBagConstraints.HORIZONTAL;
        var5.insets = BUTTON_INSETS_LEFT;
        GridBagConstraints var6 = new GridBagConstraints();
        var6.gridx = 1;
        var6.gridy = var2;
        var6.fill = GridBagConstraints.HORIZONTAL;
        var6.insets = BUTTON_INSETS_RIGHT;
        var1.add(var3, var5);
        var1.add(var4, var6);
    }

    /**
     * Adds a single full-width action component to a form panel.
     *
     * @param var1 destination panel
     * @param var2 row index
     * @param var3 component to place in the row
     */
    private void addSingleButtonRow(JPanel var1, int var2, JComponent var3) {
        GridBagConstraints var4 = new GridBagConstraints();
        var4.gridx = 0;
        var4.gridy = var2;
        var4.gridwidth = 2;
        var4.fill = GridBagConstraints.HORIZONTAL;
        var4.insets = SINGLE_BUTTON_INSETS;
        var1.add(var3, var4);
    }

    /**
     * Applies the shared style used for editable text fields.
     *
     * @param var1 text field to style
     */
    private void styleTextField(JTextField var1) {
        var1.setFont(FIELD_FONT);
        var1.setPreferredSize(new Dimension(170, 30));
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(203, 210, 220)), BorderFactory.createEmptyBorder(4, 8, 4, 8)));
    }

    /**
     * Applies the default visual style used for buttons.
     *
     * @param var1 button to style
     */
    private void styleButton(JButton var1) {
        var1.setFont(new Font("SansSerif", Font.BOLD, 12));
        var1.setFocusPainted(false);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(196, 204, 216)), BorderFactory.createEmptyBorder(7, 12, 7, 12)));
        var1.setBackground(Color.WHITE);
        var1.setForeground(new Color(42, 49, 61));
        var1.setOpaque(true);
        var1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Applies the highlighted primary-button style.
     *
     * @param var1 button to emphasize
     */
    private void stylePrimaryButton(JButton var1) {
        var1.setBackground(BUTTON_PRIMARY_COLOR);
        var1.setForeground(BUTTON_PRIMARY_TEXT_COLOR);
        var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(BUTTON_PRIMARY_COLOR.darker()), BorderFactory.createEmptyBorder(7, 12, 7, 12)));
    }

    /**
     * Wraps a {@link Runnable} so it can be attached as an action listener.
     *
     * @param var1 action body to execute
     * @return an action listener that runs the provided logic
     */
    private ActionListener action(Runnable var1) {
        return var2 -> var1.run();
    }

    /**
     * Connects all UI controls to their corresponding handlers.
     */
    private void wireEvents() {
        this.leggTilKundeBtn.addActionListener(this.action(this::leggTilKunde));
        this.finnKundeBtn.addActionListener(this.action(this::finnKunde));
        this.slettKundeBtn.addActionListener(this.action(this::slettKunde));
        this.leggTilBilBtn.addActionListener(this.action(this::leggTilBil));
        this.visBilBtn.addActionListener(this.action(() -> this.utskrift.setText(this.formatForsikringListeMedAlder("Biler", this.lister.getBilForsikringsLIste()))));
        this.leggTilHusBtn.addActionListener(this.action(this::leggTilHus));
        this.visHusBtn.addActionListener(this.action(() -> this.utskrift.setText(this.formatForsikringListeMedAlder("Hus/innbo", this.lister.getHusoginnboforsikrings()))));
        this.leggTilReiseBtn.addActionListener(this.action(this::leggTilReise));
        this.visReiseBtn.addActionListener(this.action(() -> this.utskrift.setText(this.formatForsikringListeMedAlder("Reiser", this.lister.getReisesliste()))));
        this.leggTilFriBtn.addActionListener(this.action(this::leggTilFritidsbolig));
        this.visFriBtn.addActionListener(this.action(() -> this.utskrift.setText(this.formatForsikringListeMedAlder("Fritidsbolig", this.lister.getFritidsboligForsikirings()))));
        this.leggTilSkadeBtn.addActionListener(this.action(this::leggTilSkadeMelding));
        this.visSkadeBtn.addActionListener(this.action(this::visSkadeMeldinger));
        this.hurtigVisSkadeBtn.addActionListener(this.action(this::visSkadeMeldinger));
        this.skadeKoblingTypeCombo.addActionListener(this.action(this::updateSkadeReferansePlaceholder));
        this.lagreBtn.addActionListener(this.action(this::lagre));
        this.lastBtn.addActionListener(this.action(this::laste));
        this.visLagretBtn.addActionListener(this.action(this::visLagretData));
    }

    /**
     * Configures placeholder hints for the text input fields.
     */
    private void configurePlaceholders() {
        this.setPlaceholder(this.navnFelt, "f.eks. Ola Nordmann");
        this.setPlaceholder(this.adresseFelt, "f.eks. Storgata 1");
        this.setPlaceholder(this.kundeNrFelt, "f.eks. 1000");
        this.setPlaceholder(this.bilKundeFelt, "f.eks. 1000");
        this.setPlaceholder(this.bilRegNrFelt, "f.eks. AB12345");
        this.setPlaceholder(this.bilModellFelt, "f.eks. Toyota Corolla");
        this.setPlaceholder(this.bilLengdeFelt, "f.eks. 450");
        this.setPlaceholder(this.bilAarFelt, "f.eks. 2022");
        this.setPlaceholder(this.bilMotorTypeFelt, "f.eks. Bensin");
        this.setPlaceholder(this.bilMotorStyrkeFelt, "f.eks. 150");
        this.setPlaceholder(this.husKundeFelt, "f.eks. 1000");
        this.setPlaceholder(this.husAdresseFelt, "f.eks. Solsiden 12");
        this.setPlaceholder(this.husBoligtypeFelt, "f.eks. Enebolig");
        this.setPlaceholder(this.husMaterialeFelt, "f.eks. Tre");
        this.setPlaceholder(this.husAntallM2Felt, "f.eks. 120");
        this.setPlaceholder(this.husBelopBFelt, "f.eks. 1500000");
        this.setPlaceholder(this.husBelopIFelt, "f.eks. 500000");
        this.setPlaceholder(this.husByggeaarFelt, "f.eks. 2010");
        this.setPlaceholder(this.husStandardFelt, "f.eks. Høy");
        this.setPlaceholder(this.husBonusFelt, "0-100");
        this.setPlaceholder(this.reiseKundeFelt, "f.eks. 1000");
        this.setPlaceholder(this.reiseOmradeFelt, "f.eks. Europa");
        this.setPlaceholder(this.reiseSumFelt, "f.eks. 50000");
        this.setPlaceholder(this.reiseBonusFelt, "0-100 eller 12,5");
        this.setPlaceholder(this.friKundeFelt, "f.eks. 1000");
        this.setPlaceholder(this.friAdresseFelt, "f.eks. Fjellveien 7");
        this.setPlaceholder(this.friBoligtypeFelt, "f.eks. Hytte");
        this.setPlaceholder(this.friMaterialeFelt, "f.eks. Tre");
        this.setPlaceholder(this.friStandardFelt, "f.eks. Middels");
        this.setPlaceholder(this.friAntallM2Felt, "f.eks. 80");
        this.setPlaceholder(this.friBelopBFelt, "f.eks. 800000");
        this.setPlaceholder(this.friBelopIFelt, "f.eks. 250000");
        this.setPlaceholder(this.friByggeaarFelt, "f.eks. 2015");
        this.setPlaceholder(this.friBonusFelt, "0-100");
        this.setPlaceholder(this.skadeDatoFelt, "yyyy-MM-dd");
        this.setPlaceholder(this.skadeKundeFelt, "f.eks. 1000");
        this.setPlaceholder(this.skadeNummerFelt, "f.eks. 1");
        this.setPlaceholder(this.skadeBeskrivelseFelt, "Beskriv skaden");
        this.setPlaceholder(this.skadeVitneKontaktFelt, "Navn / telefon");
        this.setPlaceholder(this.skadeTakseringFelt, "f.eks. 12500,50");
        this.setPlaceholder(this.skadeUtbetaltFelt, "f.eks. 10000,00");
        this.updateSkadeReferansePlaceholder();
    }

    /**
     * Assigns placeholder text to a field when the field supports it.
     *
     * @param var1 field that should display a placeholder
     * @param var2 placeholder text
     */
    private void setPlaceholder(JTextField var1, String var2) {
        if (var1 instanceof PlaceholderTextField) {
            ((PlaceholderTextField)var1).setPlaceholder(var2);
        }
    }

    /**
     * Updates the claim reference field placeholder based on the selected object type.
     */
    private void updateSkadeReferansePlaceholder() {
        Object var1 = this.skadeKoblingTypeCombo.getSelectedItem();
        if (SkadeMelding.SkadeObjectType.HUS == var1) {
            this.setPlaceholder(this.skadeKoblingReferanseFelt, "Adresse til huset");
            ((AbstractDocument)this.skadeKoblingReferanseFelt.getDocument()).setDocumentFilter(new PassThroughFilter());
        } else if (SkadeMelding.SkadeObjectType.BAAT == var1) {
            this.setPlaceholder(this.skadeKoblingReferanseFelt, "Registreringsnummer til båt");
            ((AbstractDocument)this.skadeKoblingReferanseFelt.getDocument()).setDocumentFilter(new UppercaseAlphaNumericFilter());
        } else if (SkadeMelding.SkadeObjectType.BIL == var1) {
            this.setPlaceholder(this.skadeKoblingReferanseFelt, "Registreringsnummer til bil");
            ((AbstractDocument)this.skadeKoblingReferanseFelt.getDocument()).setDocumentFilter(new UppercaseAlphaNumericFilter());
        } else {
            this.setPlaceholder(this.skadeKoblingReferanseFelt, "Adresse eller reg.nr");
            ((AbstractDocument)this.skadeKoblingReferanseFelt.getDocument()).setDocumentFilter(new PassThroughFilter());
        }
    }

    /**
     * Enables or disables interactive controls while optionally updating the output message.
     *
     * @param var1 {@code true} to disable the UI while background work is running
     * @param var2 optional status text to show in the output area
     */
    private void setUiBusy(boolean var1, String var2) {
        JButton[] var3 = new JButton[]{this.leggTilKundeBtn, this.finnKundeBtn, this.slettKundeBtn, this.leggTilBilBtn, this.visBilBtn, this.leggTilHusBtn, this.visHusBtn, this.leggTilReiseBtn, this.visReiseBtn, this.leggTilFriBtn, this.visFriBtn, this.leggTilSkadeBtn, this.visSkadeBtn, this.lagreBtn, this.lastBtn, this.visLagretBtn, this.hurtigVisSkadeBtn};

        for(JButton var7 : var3) {
            var7.setEnabled(!var1);
        }

        this.setCursor(var1 ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getDefaultCursor());
        if (var2 != null && !var2.isEmpty()) {
            this.utskrift.setText(var2);
        }

    }

    /**
     * Starts asynchronous persistence of the current registry state.
     */
    private void lagreAsync() {
        this.setUiBusy(true, "Lagrer...");
        (new SwingWorker<Void, Void>() {
            /**
             * Performs the save operation on a background thread.
             *
             * @return {@code null} when the save completes
             * @throws Exception if the save fails
             */
            protected Void doInBackground() throws Exception {
                Vindutest.this.lagreIO();
                return null;
            }

            /**
             * Updates the UI after the background save finishes.
             */
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
                    Vindutest.this.setUiBusy(false, null);
                }

            }
        }).execute();
    }

    /**
     * Starts asynchronous loading of persisted registry data.
     */
    private void lasteAsync() {
        this.setUiBusy(true, "Laster...");
        (new SwingWorker<Lister, Void>() {
            /**
             * Loads persisted data on a background thread.
             *
             * @return the loaded registry data
             * @throws Exception if loading fails
             */
            protected Lister doInBackground() throws Exception {
                return Vindutest.this.lasteIO();
            }

            /**
             * Updates the UI after the background load finishes.
             */
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
                    Vindutest.this.setUiBusy(false, null);
                }

            }
        }).execute();
    }

    /**
     * Configures validation helpers, error clearing, and numeric-only field filters.
     */
    private void configureValidation() {
        JTextField[] var1 = new JTextField[]{this.navnFelt, this.adresseFelt, this.kundeNrFelt, this.bilKundeFelt, this.bilRegNrFelt, this.bilModellFelt, this.bilLengdeFelt, this.bilAarFelt, this.bilMotorTypeFelt, this.bilMotorStyrkeFelt, this.husKundeFelt, this.husAdresseFelt, this.husBoligtypeFelt, this.husMaterialeFelt, this.husAntallM2Felt, this.husBelopBFelt, this.husBelopIFelt, this.husByggeaarFelt, this.husStandardFelt, this.husBonusFelt, this.reiseKundeFelt, this.reiseOmradeFelt, this.reiseSumFelt, this.reiseBonusFelt, this.friKundeFelt, this.friAdresseFelt, this.friBoligtypeFelt, this.friMaterialeFelt, this.friStandardFelt, this.friAntallM2Felt, this.friBelopBFelt, this.friBelopIFelt, this.friByggeaarFelt, this.friBonusFelt, this.skadeDatoFelt, this.skadeKundeFelt, this.skadeNummerFelt, this.skadeBeskrivelseFelt, this.skadeVitneKontaktFelt, this.skadeTakseringFelt, this.skadeUtbetaltFelt, this.skadeKoblingReferanseFelt};

        for(JTextField var5 : var1) {
            this.installClearErrorOnEdit(var5);
        }

        JTextField[] var7 = new JTextField[]{this.kundeNrFelt, this.bilKundeFelt, this.bilLengdeFelt, this.bilAarFelt, this.bilMotorStyrkeFelt, this.husKundeFelt, this.husAntallM2Felt, this.husBelopBFelt, this.husBelopIFelt, this.husByggeaarFelt, this.husBonusFelt, this.reiseKundeFelt, this.reiseSumFelt, this.friKundeFelt, this.friAntallM2Felt, this.friBelopBFelt, this.friBelopIFelt, this.friByggeaarFelt, this.friBonusFelt, this.skadeKundeFelt, this.skadeNummerFelt};

        for(JTextField var6 : var7) {
            ((AbstractDocument)var6.getDocument()).setDocumentFilter(new DigitsOnlyFilter());
        }

        ((AbstractDocument)this.bilRegNrFelt.getDocument()).setDocumentFilter(new UppercaseAlphaNumericFilter());

        JTextField[] var8 = new JTextField[]{this.reiseBonusFelt, this.skadeTakseringFelt, this.skadeUtbetaltFelt};

        for(JTextField var10 : var8) {
            ((AbstractDocument)var10.getDocument()).setDocumentFilter(new DecimalInputFilter());
        }

        ((AbstractDocument)this.skadeDatoFelt.getDocument()).setDocumentFilter(new DateInputFilter());

    }

    /**
     * Installs a listener that restores a field's normal background color whenever it changes.
     *
     * @param var1 text field to monitor
     */
    private void installClearErrorOnEdit(JTextField var1) {
        var1.getDocument().addDocumentListener(new DocumentListener() {
            /**
             * Clears the error state when text is inserted.
             *
             * @param var1x document change event
             */
            public void insertUpdate(DocumentEvent var1x) {
                Vindutest.this.clearFieldError(var1);
            }

            /**
             * Clears the error state when text is removed.
             *
             * @param var1x document change event
             */
            public void removeUpdate(DocumentEvent var1x) {
                Vindutest.this.clearFieldError(var1);
            }

            /**
             * Clears the error state when the document attributes change.
             *
             * @param var1x document change event
             */
            public void changedUpdate(DocumentEvent var1x) {
                Vindutest.this.clearFieldError(var1);
            }
        });
    }

    /**
     * Checks whether any required text fields are blank and marks the first invalid field.
     *
     * @param var1 message shown when a required field is missing
     * @param var2 fields that must contain text
     * @return {@code true} if at least one required field is blank, otherwise {@code false}
     */
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

    /**
     * Parses a required integer field and validates its minimum value.
     *
     * @param var1 field containing the numeric input
     * @param var2 user-facing field name used in validation messages
     * @param var3 minimum allowed value
     * @return the parsed integer, or {@code null} when validation fails
     */
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

    /**
     * Parses a required decimal field and validates its minimum value.
     *
     * @param var1 field containing the numeric input
     * @param var2 user-facing field name used in validation messages
     * @param var3 minimum allowed value
     * @return the parsed double, or {@code null} when validation fails
     */
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

    /**
     * Parses a required percentage field and ensures the value stays between 0 and 100.
     *
     * @param var1 field containing the percentage input
     * @param var2 user-facing field name used in validation messages
     * @return the parsed percentage, or {@code null} when validation fails
     */
    private Double parseRequiredPercentage(JTextField var1, String var2) {
        Double var3 = this.parseRequiredDouble(var1, var2, 0.0);
        if (var3 == null) {
            return null;
        } else if (var3 > 100.0) {
            this.markFieldError(var1);
            var1.requestFocusInWindow();
            this.melding(var2 + " må være mellom 0 og 100");
            return null;
        } else {
            this.clearFieldError(var1);
            return var3;
        }
    }

    /**
     * Parses a required integer percentage field and ensures the value stays between 0 and 100.
     *
     * @param var1 field containing the percentage input
     * @param var2 user-facing field name used in validation messages
     * @return the parsed percentage, or {@code null} when validation fails
     */
    private Integer parseRequiredPercentageInt(JTextField var1, String var2) {
        Integer var3 = this.parseRequiredInt(var1, var2, 0);
        if (var3 == null) {
            return null;
        } else if (var3 > 100) {
            this.markFieldError(var1);
            var1.requestFocusInWindow();
            this.melding(var2 + " må være mellom 0 og 100");
            return null;
        } else {
            this.clearFieldError(var1);
            return var3;
        }
    }

    /**
     * Parses a required date field using the {@code yyyy-MM-dd} format.
     *
     * @param var1 field containing the date input
     * @param var2 user-facing field name used in validation messages
     * @return the parsed {@link Date}, or {@code null} when validation fails
     */
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

    /**
     * Highlights a field as invalid.
     *
     * @param var1 field to mark
     */
    private void markFieldError(JTextField var1) {
        var1.setBackground(INVALID_FIELD_COLOR);
        JLabel var2 = this.helperLabels.get(var1);
        if (var2 != null) {
            var2.setForeground(HELPER_ERROR_TEXT_COLOR);
        }
    }

    /**
     * Restores a field's default background color.
     *
     * @param var1 field to reset
     */
    private void clearFieldError(JTextField var1) {
        var1.setBackground(this.defaultFieldColor);
        JLabel var2 = this.helperLabels.get(var1);
        if (var2 != null) {
            var2.setForeground(HELPER_TEXT_COLOR);
        }
    }

    /**
     * Registers a new customer using the values entered in the customer form.
     */
    private void leggTilKunde() {
        String var1 = this.navnFelt.getText().trim();
        String var2 = this.adresseFelt.getText().trim();
        if (!this.hasMissingRequiredFields("Du må fylle ut navn og adresse", this.navnFelt, this.adresseFelt)) {
            Kunde var3 = new Kunde(var1, var2, null);
            this.lister.leggTilKunde(var3);
            this.utskrift.setText("Kunde lagt til:\n" + var3);
            this.kundeNrFelt.setText(String.valueOf(var3.getKundeNr()));
            this.bilKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.husKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.reiseKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.friKundeFelt.setText(String.valueOf(var3.getKundeNr()));
            this.navnFelt.setText("");
            this.adresseFelt.setText("");
        }
    }

    /**
     * Looks up a customer by customer number and displays the result.
     */
    private void finnKunde() {
        Integer var1 = this.parseRequiredInt(this.kundeNrFelt, "Kundenummer", 1);
        if (var1 != null) {
            Kunde var2 = this.lister.finnKunder(var1);
            StringBuilder output = new StringBuilder();
            if (var2 == null) {
                output.append("═════════════════════════════════════════\n");
                output.append("⚠ KUNDE IKKE FUNNET\n");
                output.append("═════════════════════════════════════════\n\n");
                output.append("Kundenummer ").append(var1).append(" finnes ikke i systemet.\n");
                output.append("Vennligst sjekk nummeret og prøv igjen.\n");
            } else {
                output.append("═════════════════════════════════════════\n");
                output.append("        KUNDEDETALJER\n");
                output.append("═════════════════════════════════════════\n\n");
                output.append(var2).append("\n\n");
                output.append("═════════════════════════════════════════\n");
            }
            this.utskrift.setText(output.toString());
        }
    }

    /**
     * Deletes a customer identified by the customer number field.
     */
    private void slettKunde() {
        Integer var1 = this.parseRequiredInt(this.kundeNrFelt, "Kundenummer", 1);
        if (var1 != null) {
            boolean var2 = this.lister.fjernKunde(var1);
            this.utskrift.setText(var2 ? "Kunde slettet" : "Fant ikke kunde");
        }
    }

    /**
     * Registers a new car insurance entry for an existing customer.
     */
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
                            Bilforsikring var11 = new Bilforsikring(null, var6, var1, var3, var4, var7, var8, var5, var9, 0);
                            var10.leggTilbil(var11);
                            var10.setBil(var11);
                            this.lister.leggTilbilForsikring(var11);
                            this.utskrift.setText(this.formatForsikringMedAlder("Bil registrert", var11));
                            this.clearBilFields();
                        }
                    }
                }
            }
        }
    }

    /**
     * Registers a new house and contents insurance entry for an existing customer.
     */
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
            Integer var10 = this.parseRequiredPercentageInt(this.husBonusFelt, "Bonus");
            if (var5 != null && var6 != null && var7 != null && var8 != null && var9 != null && var10 != null) {
                Kunde var11 = this.lister.finnKunder(var5);
                if (var11 == null) {
                    this.markFieldError(this.husKundeFelt);
                    this.husKundeFelt.requestFocusInWindow();
                    this.melding("Fant ikke kunde");
                } else {
                    Husoginnboforsikring var12 = new Husoginnboforsikring(var5, var1, var2, null, var3, var6, var7, var8, var9, var4, 0);
                    var12.setBonus((double)var10);
                    var11.addHusForsikring(var12);
                    this.lister.getHusoginnboforsikrings().add(var12);
                    this.lister.nyForsikring(var12);
                    this.utskrift.setText(this.formatForsikringMedAlder("Hus/innbo registrert", var12));
                    this.clearHusFields();
                }
            }
        }
    }

    /**
     * Registers a new leisure property insurance entry for an existing customer.
     */
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
            Integer var10 = this.parseRequiredPercentageInt(this.friBonusFelt, "Bonus");
            if (var5 != null && var6 != null && var7 != null && var8 != null && var9 != null && var10 != null) {
                Kunde var11 = this.lister.finnKunder(var5);
                if (var11 == null) {
                    this.markFieldError(this.friKundeFelt);
                    this.friKundeFelt.requestFocusInWindow();
                    this.melding("Fant ikke kunde");
                } else {
                    FritidsboligForsikiring var12 = new FritidsboligForsikiring(var1, null, var2, var3, var4, var8, var7, var9, var6, (double)var10, 0);
                    var11.addFritidshusForsikring(var12);
                    this.lister.leggTilFridsboligForsikiring(var12);
                    this.lister.nyForsikring(var12);
                    this.utskrift.setText(this.formatForsikringMedAlder("Fritidsbolig registrert", var12));
                    this.clearFriFields();
                }
            }
        }
    }

    /**
     * Registers a new travel insurance entry for an existing customer.
     */
    private void leggTilReise() {
        String var1 = this.reiseOmradeFelt.getText().trim();
        if (!this.hasMissingRequiredFields("Fyll ut alle reisefeltene", this.reiseOmradeFelt, this.reiseSumFelt, this.reiseBonusFelt)) {
            Integer var2 = this.parseRequiredInt(this.reiseKundeFelt, "Kundenummer", 1);
            Integer var3 = this.parseRequiredInt(this.reiseSumFelt, "Sum", 1);
            Double var4 = this.parseRequiredPercentage(this.reiseBonusFelt, "Bonus");
            if (var2 != null && var3 != null && var4 != null) {
                Kunde var5 = this.lister.finnKunder(var2);
                if (var5 == null) {
                    this.markFieldError(this.reiseKundeFelt);
                    this.reiseKundeFelt.requestFocusInWindow();
                    this.melding("Fant ikke kunde");
                } else {
                    Reise var6 = new Reise(String.valueOf(var2), var1, var3, 0, var4);
                    var5.addReise(var6);
                    this.lister.leggTilRiese(var6);
                    this.lister.nyForsikring(var6);
                    this.utskrift.setText(this.formatForsikringMedAlder("Reise registrert", var6));
                    this.clearReiseFields();
                }
            }
        }
    }

    /**
     * Registers a new claim, validating the customer and the linked insured object.
     */
    private void leggTilSkadeMelding() {
        if (!this.hasMissingRequiredFields("Fyll ut dato, beskrivelse og vitnekontakt", this.skadeDatoFelt, this.skadeBeskrivelseFelt, this.skadeVitneKontaktFelt)) {
            Integer var13 = this.parseRequiredInt(this.skadeKundeFelt, "Kundenummer", 1);
            if (var13 == null) {
                return;
            }

            if (this.lister.finnKunder(var13) == null) {
                this.markFieldError(this.skadeKundeFelt);
                this.skadeKundeFelt.requestFocusInWindow();
                this.melding("Fant ikke kunde");
                return;
            }

            SkadeMelding.SkadeObjectType var1 = (SkadeMelding.SkadeObjectType)this.skadeKoblingTypeCombo.getSelectedItem();
            String var2 = this.skadeKoblingReferanseFelt.getText().trim();
            if (var2.isEmpty()) {
                this.markFieldError(this.skadeKoblingReferanseFelt);
                this.skadeKoblingReferanseFelt.requestFocusInWindow();
                this.melding("Fyll ut referanse for valgt objekt");
            } else {
                if (var1 == null) {
                    this.melding("Velg skadet objekt");
                    return;
                }

                String var3 = null;
                String var4 = null;
                String var5 = null;
                if (SkadeMelding.SkadeObjectType.HUS == var1) {
                    if (this.lister.finnHusForKunde(var13, var2) == null) {
                        this.markFieldError(this.skadeKoblingReferanseFelt);
                        this.skadeKoblingReferanseFelt.requestFocusInWindow();
                        this.melding("Fant ikke hus med denne adressen for kunden");
                        return;
                    }

                    var3 = var2;
                } else if (SkadeMelding.SkadeObjectType.BAAT == var1) {
                    String var6 = var2.toUpperCase();
                    if (this.lister.finnBaatForKunde(var13, var6) == null) {
                        this.markFieldError(this.skadeKoblingReferanseFelt);
                        this.skadeKoblingReferanseFelt.requestFocusInWindow();
                        this.melding("Fant ikke baat med dette registreringsnummeret for kunden");
                        return;
                    }

                    var4 = var6;
                } else {
                    String var6 = var2.toUpperCase();
                    if (this.lister.finnBilForKunde(var13, var6) == null) {
                        this.markFieldError(this.skadeKoblingReferanseFelt);
                        this.skadeKoblingReferanseFelt.requestFocusInWindow();
                        this.melding("Fant ikke bil med dette registreringsnummeret for kunden");
                        return;
                    }

                    var5 = var6;
                }

                Date var12 = this.parseRequiredDate(this.skadeDatoFelt, "Dato");
                Integer var7 = this.parseRequiredInt(this.skadeNummerFelt, "Skadenummer", 1);
                Double var8 = this.parseRequiredDouble(this.skadeTakseringFelt, "Taksering belop", 0.0);
                Double var9 = this.parseRequiredDouble(this.skadeUtbetaltFelt, "Utbetalt belop", 0.0);
                if (var12 != null && var7 != null && var8 != null && var9 != null) {
                    SkadeMelding var10 = new SkadeMelding(var12, (SkadeMelding.TypeSkade)this.skadeTypeCombo.getSelectedItem());
                    var10.setSkadeNummer(var7);
                    var10.setKundeNr(var13);
                    var10.setSkadeObjectType(var1);
                    var10.setBeskrivelse(this.skadeBeskrivelseFelt.getText().trim());
                    var10.setVitnerKontaktInfo(this.skadeVitneKontaktFelt.getText().trim());
                    var10.setTakseringBeløp(var8);
                    var10.setUtbetaltErstatningsBeløp(var9);
                    var10.setKobletHusAdresse(var3);
                    var10.setKobletBaatRegistreringsnummer(var4 == null || var4.isEmpty() ? null : var4);
                    var10.setKobletBilRegistreringsnummer(var5 == null || var5.isEmpty() ? null : var5);
                    boolean var11 = this.lister.nySkadeMelding(var10);
                    if (!var11) {
                        this.melding("Kunne ikke registrere skademelding");
                    } else {
                        this.refreshSkadeCountBadge();
                        this.utskrift.setText("Skademelding registrert:\n" + var10);
                        this.clearSkadeFields();
                    }
                }
            }
        }
    }

    /**
     * Displays all registered claim reports in the output area.
     */
    private void visSkadeMeldinger() {
        this.refreshSkadeCountBadge();
        StringBuilder formattedOutput = new StringBuilder();
        formattedOutput.append("═════════════════════════════════════════\n");
        formattedOutput.append("        SKADEMELDINGER - OVERSIKT\n");
        formattedOutput.append("═════════════════════════════════════════\n\n");

        java.util.Set<SkadeMelding> skader = this.lister.getSkadeMeldinger();

        if (skader.isEmpty()) {
            formattedOutput.append("⚠ Ingen skademeldinger registrert i systemet.\n");
        } else {
            int count = 0;
            for (SkadeMelding skade : skader) {
                count++;
                formattedOutput.append("─────────────────────────────────────────\n");
                formattedOutput.append("Skademelding #").append(count).append(":\n");
                formattedOutput.append(skade).append("\n");
                formattedOutput.append("─────────────────────────────────────────\n\n");
            }
            formattedOutput.append("═════════════════════════════════════════\n");
            formattedOutput.append("Total: ").append(count).append(" skademeldinger registrert\n");
            formattedOutput.append("═════════════════════════════════════════\n");
        }

        this.utskrift.setText(formattedOutput.toString());
    }

    /**
     * Updates the claim count badge to reflect the current number of claims.
     */
    private void refreshSkadeCountBadge() {
        this.skadeCountLabel.setText("Skader: " + this.lister.getSkadeMeldinger().size());
    }

    /**
     * Triggers asynchronous persistence of the current registry state.
     */
    private void lagre() {
        this.lagreAsync();
    }

    /**
     * Triggers asynchronous loading of persisted registry data.
     */
    private void laste() {
        this.lasteAsync();
    }

    /**
     * Saves the current registry state to the configured persistence files.
     *
     * @throws IOException if the save operation fails
     */
    private void lagreIO() throws IOException {
        this.persistenceService.save(this.lister, this.snapshotFormatter.buildListerTextSnapshot(this.lister));
    }

    /**
     * Loads registry data from the configured persistence files.
     *
     * @return the loaded registry state
     * @throws IOException if the persisted data cannot be read
     * @throws ClassNotFoundException if serialized data contains unknown classes
     */
    private Lister lasteIO() throws IOException, ClassNotFoundException {
        return this.persistenceService.load();
    }

    /**
     * Displays the legacy customer list file when available.
     *
     * @return {@code true} if the fallback file was shown successfully, otherwise {@code false}
     */
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

    /**
     * Displays the contents of known persisted text files in the output area.
     */
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
            var1.append("Kunne ikke lese fil: ").append(var4.getMessage()).append("\n");
        }

        this.utskrift.setText(var1.toString());
    }

    /**
     * Appends a titled data section to an output buffer.
     *
     * @param var1 destination buffer
     * @param var2 section title
     * @param var3 section content
     */
    private void appendSection(StringBuilder var1, String var2, String var3) {
        var1.append("-- ").append(var2).append(" --\n");
        this.appendFormattedText(var1, this.snapshotFormatter.formatSectionEntries(var3));
    }

    /**
     * Appends a file header label to an output buffer.
     *
     * @param var1 destination buffer
     * @param var2 file name to display as the header
     */
    private void appendFileHeader(StringBuilder var1, String var2) {
        if (!var1.isEmpty()) {
            var1.append("\n");
        }

        var1.append("=== ").append(var2).append(" ===\n");
    }

    /**
     * Appends normalized text to an output buffer, inserting a default placeholder when empty.
     *
     * @param var1 destination buffer
     * @param var2 source text
     */
    private void appendFormattedText(StringBuilder var1, String var2) {
        String var3 = this.snapshotFormatter.normalizeTextForDisplay(var2);
        var1.append(var3.isEmpty() ? "Ingen data" : var3).append("\n\n");
    }

    /**
     * Formats one insurance entry together with its calculated age for display.
     *
     * @param var1 heading shown before the insurance details
     * @param var2 insurance to format
     * @return formatted output text including age information
     */
    private String formatForsikringMedAlder(String var1, Forsikring var2) {
        return var1 + ":\n" + var2 + "\nAlder: " + var2.age() + " år";
    }

    /**
     * Formats a collection of insurances together with their calculated ages.
     *
     * @param var1 heading shown at the top of the list
     * @param var2 insurances to format
     * @return formatted output text including age information for each insurance
     */
    private String formatForsikringListeMedAlder(String var1, Iterable<? extends Forsikring> var2) {
        StringBuilder var3 = new StringBuilder();
        var3.append("═════════════════════════════════════════\n");
        var3.append("   ").append(var1.toUpperCase()).append(" - OVERSIKT\n");
        var3.append("═════════════════════════════════════════\n\n");

        int count = 0;
        for(Forsikring var5 : var2) {
            count++;
            var3.append("─────────────────────────────────────────\n");
            var3.append("Forsikring #").append(count).append(":\n");
            var3.append(var5).append("\n");
            var3.append("Alder: ").append(var5.age()).append(" år\n");
            var3.append("─────────────────────────────────────────\n\n");
        }

        if (count == 0) {
            var3.append("⚠ Ingen ").append(var1.toLowerCase()).append(" registrert i systemet.\n");
        } else {
            var3.append("═════════════════════════════════════════\n");
            var3.append("Total: ").append(count).append(" ").append(var1.toLowerCase()).append(" registrert\n");
            var3.append("═════════════════════════════════════════\n");
        }

        return var3.toString();
    }

    /**
     * Copies all collections from a loaded registry into the in-memory registry instance.
     *
     * @param var1 source registry whose data should be copied
     */
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

    /**
     * Loads persisted data when the application starts, if such data exists.
     */
    private void loadPersistedDataOnStartup() {
        try {
            if (this.persistenceService.hasPersistedData()) {
                this.copyLister(this.lasteIO());
            }
        } catch (ClassNotFoundException | IOException var2) {
            this.utskrift.setText("Kunne ikke laste lagrede data ved oppstart: " + var2.getMessage());
        }

    }

    /**
     * Checks whether any in-memory registry collections currently contain data.
     *
     * @return {@code true} if at least one registry collection contains data, otherwise {@code false}
     */
    private boolean hasInMemoryData() {
        return !this.lister.getKundeListe().isEmpty() || !this.lister.getBaatForsikringsliste().isEmpty() || !this.lister.getBilForsikringsLIste().isEmpty() || !this.lister.getFritidsboligForsikirings().isEmpty() || !this.lister.getHusoginnboforsikrings().isEmpty() || !this.lister.getReisesliste().isEmpty() || !this.lister.getSkadeMeldinger().isEmpty();
    }

    /**
     * Synchronizes the static next-customer number with the highest loaded customer number.
     */
    private void syncNextCustomerNumber() {
        int var1 = 0;

        for(Kunde var3 : this.lister.getKundeListe()) {
            var1 = Math.max(var1, var3.getKundeNr() + 1);
        }

        if (!this.lister.getKundeListe().isEmpty()) {
            this.lister.getKundeListe().iterator().next().setKundeNr(var1);
        }

    }

    /**
     * Clears all fields related to car insurance registration.
     */
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

    /**
     * Clears all fields related to house insurance registration.
     */
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

    /**
     * Clears all fields related to leisure property insurance registration.
     */
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

    /**
     * Clears all fields related to travel insurance registration.
     */
    private void clearReiseFields() {
        this.reiseKundeFelt.setText("");
        this.reiseOmradeFelt.setText("");
        this.reiseSumFelt.setText("");
        this.reiseBonusFelt.setText("");
    }

    /**
     * Clears all fields related to claim registration.
     */
    private void clearSkadeFields() {
        this.skadeDatoFelt.setText("");
        this.skadeKundeFelt.setText("");
        this.skadeNummerFelt.setText("");
        this.skadeTypeCombo.setSelectedIndex(0);
        this.skadeBeskrivelseFelt.setText("");
        this.skadeVitneKontaktFelt.setText("");
        this.skadeTakseringFelt.setText("");
        this.skadeUtbetaltFelt.setText("");
        this.skadeKoblingTypeCombo.setSelectedIndex(0);
        this.skadeKoblingReferanseFelt.setText("");
    }

    /**
     * Displays an error dialog with the provided message.
     *
     * @param var1 message to show
     */
    private void melding(String var1) {
        JOptionPane.showMessageDialog(this, var1, "Feil", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Saves the in-memory data immediately unless there is nothing new to persist.
     */
    public void skrivTilFil() {
        if (!this.hasInMemoryData() && this.persistenceService.hasPersistedData()) {
            this.utskrift.setText("Ingen nye data i minnet. Beholder eksisterende lagret fil.");
            return;
        }

        try {
            this.lagreIO();
            this.utskrift.setText("Lagret.");
        } catch (IOException var2) {
            this.melding("Kunne ikke lagre: " + var2.getMessage());
        }

    }

    private static final class DigitsOnlyFilter extends DocumentFilter {
        /**
         * Inserts text only when the provided characters are digits.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 insertion offset
         * @param var3 text being inserted
         * @param var4 attribute set for the inserted text
         * @throws BadLocationException if the document position is invalid
         */
        public void insertString(DocumentFilter.FilterBypass var1, int var2, String var3, AttributeSet var4) throws BadLocationException {
            if (var3 != null && this.isDigits(var3)) {
                super.insertString(var1, var2, var3, var4);
            }

        }

        /**
         * Replaces document content only when the replacement text contains digits only.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 replacement offset
         * @param var3 number of characters to replace
         * @param var4 replacement text
         * @param var5 attribute set for the replacement text
         * @throws BadLocationException if the document position is invalid
         */
        public void replace(DocumentFilter.FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) throws BadLocationException {
            String var6 = var4 == null ? "" : var4;
            if (this.isDigits(var6)) {
                super.replace(var1, var2, var3, var4, var5);
            }

        }

        /**
         * Checks whether a string contains digits only.
         *
         * @param var1 value to inspect
         * @return {@code true} when the string contains only digits, otherwise {@code false}
         */
        private boolean isDigits(String var1) {
            for(int var2 = 0; var2 < var1.length(); ++var2) {
                if (!Character.isDigit(var1.charAt(var2))) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Passes text through without filtering.
     */
    private static final class PassThroughFilter extends DocumentFilter {
    }

    /**
     * Restricts input to uppercase letters and digits for registration numbers.
     */
    private static final class UppercaseAlphaNumericFilter extends DocumentFilter {
        /**
         * Inserts uppercase alphanumeric text when valid.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 insertion offset
         * @param var3 text being inserted
         * @param var4 attribute set for the inserted text
         * @throws BadLocationException if the document position is invalid
         */
        public void insertString(DocumentFilter.FilterBypass var1, int var2, String var3, AttributeSet var4) throws BadLocationException {
            if (var3 != null) {
                String var5 = this.normalize(var3);
                if (this.isAlphaNumeric(var5)) {
                    super.insertString(var1, var2, var5, var4);
                }
            }
        }

        /**
         * Replaces text with uppercase alphanumeric text when valid.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 replacement offset
         * @param var3 number of characters to replace
         * @param var4 replacement text
         * @param var5 attribute set for the replacement text
         * @throws BadLocationException if the document position is invalid
         */
        public void replace(DocumentFilter.FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) throws BadLocationException {
            String var6 = var4 == null ? "" : this.normalize(var4);
            if (this.isAlphaNumeric(var6)) {
                super.replace(var1, var2, var3, var4 == null ? null : var6, var5);
            }
        }

        /**
         * Normalizes input to uppercase.
         *
         * @param var1 raw input text
         * @return uppercase text
         */
        private String normalize(String var1) {
            return var1.toUpperCase();
        }

        /**
         * Checks whether the text contains only letters and digits.
         *
         * @param var1 value to inspect
         * @return {@code true} when all characters are alphanumeric
         */
        private boolean isAlphaNumeric(String var1) {
            for(int var2 = 0; var2 < var1.length(); ++var2) {
                if (!Character.isLetterOrDigit(var1.charAt(var2))) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Restricts input to decimal-compatible characters used by numeric fields.
     */
    private static final class DecimalInputFilter extends DocumentFilter {
        /**
         * Inserts text when the resulting content remains a valid decimal input.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 insertion offset
         * @param var3 text being inserted
         * @param var4 attribute set for the inserted text
         * @throws BadLocationException if the document position is invalid
         */
        public void insertString(DocumentFilter.FilterBypass var1, int var2, String var3, AttributeSet var4) throws BadLocationException {
            if (var3 != null) {
                String var5 = var1.getDocument().getText(0, var1.getDocument().getLength());
                String var6 = new StringBuilder(var5).insert(var2, var3).toString();
                if (this.isValidDecimalInput(var6)) {
                    super.insertString(var1, var2, var3, var4);
                }
            }

        }

        /**
         * Replaces text when the resulting content remains a valid decimal input.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 replacement offset
         * @param var3 number of characters to replace
         * @param var4 replacement text
         * @param var5 attribute set for the replacement text
         * @throws BadLocationException if the document position is invalid
         */
        public void replace(DocumentFilter.FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) throws BadLocationException {
            String var6 = var4 == null ? "" : var4;
            StringBuilder var7 = new StringBuilder(var1.getDocument().getText(0, var1.getDocument().getLength()));
            var7.replace(var2, var2 + var3, var6);
            if (this.isValidDecimalInput(var7.toString())) {
                super.replace(var1, var2, var3, var4, var5);
            }

        }

        /**
         * Checks whether the provided text can represent a decimal value while typing.
         *
         * @param var1 value to inspect
         * @return {@code true} when the input is valid for decimal entry
         */
        private boolean isValidDecimalInput(String var1) {
            if (var1.isEmpty()) {
                return true;
            } else {
                int var2 = 0;

                for(int var3 = 0; var3 < var1.length(); ++var3) {
                    char var4 = var1.charAt(var3);
                    if (Character.isDigit(var4)) {
                        continue;
                    }

                    if (var4 != '.' && var4 != ',') {
                        return false;
                    }

                    ++var2;
                    if (var2 > 1) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    /**
     * Restricts input to the {@code yyyy-MM-dd} date typing format.
     */
    private static final class DateInputFilter extends DocumentFilter {
        /**
         * Inserts text when the resulting content remains a valid date input pattern.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 insertion offset
         * @param var3 text being inserted
         * @param var4 attribute set for the inserted text
         * @throws BadLocationException if the document position is invalid
         */
        public void insertString(DocumentFilter.FilterBypass var1, int var2, String var3, AttributeSet var4) throws BadLocationException {
            if (var3 != null) {
                String var5 = var1.getDocument().getText(0, var1.getDocument().getLength());
                String var6 = new StringBuilder(var5).insert(var2, var3).toString();
                String var7 = this.formatDateInput(var6);
                if (var7 != null) {
                    super.replace(var1, 0, var1.getDocument().getLength(), var7, var4);
                }
            }

        }

        /**
         * Replaces text when the resulting content remains a valid date input pattern.
         *
         * @param var1 filter bypass used to mutate the document
         * @param var2 replacement offset
         * @param var3 number of characters to replace
         * @param var4 replacement text
         * @param var5 attribute set for the replacement text
         * @throws BadLocationException if the document position is invalid
         */
        public void replace(DocumentFilter.FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) throws BadLocationException {
            String var6 = var4 == null ? "" : var4;
            StringBuilder var7 = new StringBuilder(var1.getDocument().getText(0, var1.getDocument().getLength()));
            var7.replace(var2, var2 + var3, var6);
            String var8 = this.formatDateInput(var7.toString());
            if (var8 != null) {
                super.replace(var1, 0, var1.getDocument().getLength(), var8, var5);
            }

        }

        /**
         * Checks whether the provided text can represent a date while typing.
         *
         * @param var1 value to inspect
         * @return {@code true} when the input matches the expected date pattern shape
         */
        private boolean isValidDateInput(String var1) {
            if (var1.length() > 10) {
                return false;
            } else {
                for(int var2 = 0; var2 < var1.length(); ++var2) {
                    char var3 = var1.charAt(var2);
                    if (var2 == 4 || var2 == 7) {
                        if (var3 != '-') {
                            return false;
                        }
                    } else if (!Character.isDigit(var3)) {
                        return false;
                    }
                }

                return true;
            }
        }

        /**
         * Formats partial numeric date input to the yyyy-MM-dd shape.
         *
         * @param var1 raw input value
         * @return formatted partial date, or {@code null} when the input contains invalid characters
         */
        private String formatDateInput(String var1) {
            StringBuilder var2 = new StringBuilder();

            for(int var3 = 0; var3 < var1.length(); ++var3) {
                char var4 = var1.charAt(var3);
                if (Character.isDigit(var4)) {
                    var2.append(var4);
                } else if (var4 != '-') {
                    return null;
                }
            }

            if (var2.length() > 8) {
                return null;
            } else {
                StringBuilder var5 = new StringBuilder();

                for(int var6 = 0; var6 < var2.length(); ++var6) {
                    if (var6 == 4 || var6 == 6) {
                        var5.append('-');
                    }

                    var5.append(var2.charAt(var6));
                }

                String var7 = var5.toString();
                return this.isValidDateInput(var7) ? var7 : null;
            }
        }
    }

    /**
     * JTextField variant that paints placeholder text while the field is empty.
     */
    private static final class PlaceholderTextField extends JTextField {
        private String placeholder;

        /**
         * Creates a placeholder-capable text field.
         *
         * @param var1 preferred column count
         */
        private PlaceholderTextField(int var1) {
            super(var1);
        }

        /**
         * Updates the placeholder text shown for the field.
         *
         * @param var1 placeholder text
         */
        private void setPlaceholder(String var1) {
            this.placeholder = var1;
            this.repaint();
        }

        /**
         * Paints the field and the placeholder text when appropriate.
         *
         * @param var1 graphics context
         */
        protected void paintComponent(Graphics var1) {
            super.paintComponent(var1);
            if (this.placeholder != null && !this.placeholder.isEmpty() && this.getText().isEmpty() && !this.isFocusOwner()) {
                Graphics2D var2 = (Graphics2D)var1.create();
                var2.setColor(PLACEHOLDER_TEXT_COLOR);
                var2.setFont(this.getFont());
                Insets var3 = this.getInsets();
                int var4 = var2.getFontMetrics().getAscent();
                int var5 = (this.getHeight() - var2.getFontMetrics().getHeight()) / 2 + var4;
                var2.drawString(this.placeholder, var3.left + 2, var5);
                var2.dispose();
            }

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
        PLACEHOLDER_TEXT_COLOR = new Color(150, 156, 166);
        HELPER_TEXT_COLOR = new Color(120, 128, 140);
        HELPER_ERROR_TEXT_COLOR = new Color(198, 40, 40);
        SECTION_TITLE_FONT = new Font("SansSerif", Font.BOLD, 13);
        LABEL_FONT = new Font("SansSerif", Font.PLAIN, 12);
        FIELD_FONT = new Font("SansSerif", Font.PLAIN, 13);
        OUTPUT_FONT = new Font("Monospaced", Font.PLAIN, 13);
        LABEL_INSETS = new Insets(4, 0, 4, 10);
        FIELD_INSETS = new Insets(4, 0, 4, 0);
        BUTTON_INSETS_LEFT = new Insets(12, 0, 0, 8);
        BUTTON_INSETS_RIGHT = new Insets(12, 0, 0, 0);
        SINGLE_BUTTON_INSETS = new Insets(12, 0, 0, 0);
    }
}
