/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author lungamajola
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.UIManager.LookAndFeelInfo;
import projektoppgave3_2015.Bilforsikring;
import projektoppgave3_2015.Kunde;
import projektoppgave3_2015.Lister;

public final class Runtime extends JFrame
{

    private static final long serialVersionUID = 1L;

    Lister lister = new Lister();
    private Kunde kundeliste;

    JTabbedPane tabbedPane = new JTabbedPane();
    JButton view = new JButton("view");
    JButton save = new JButton("save");
    JButton addNew = new JButton("Add New");
    JButton exit = new JButton("Exit Application");

    ImageIcon icon = createImageIcon("\"images/middle.gif\"");
	 private JComboBox<Bilforsikring.BilType> bilTypeCombo;

    JPanel displayBilForsikiringPanel = new JPanel();
    JPanel leggcont1opmeg = new JPanel(new BorderLayout());
    JPanel leggcont1opmeg1 = new JPanel(new BorderLayout());
    JPanel leggcont1opmeg2 = new JPanel(new BorderLayout());
    JPanel leggcont1opmeg3 = new JPanel(new BorderLayout());
    JPanel leggcont1opmeg4 = new JPanel(new BorderLayout());
    JPanel displayBaaForsikiringpPanel = new JPanel();
    JPanel displayHusogInnboForsikiringpPanel = new JPanel();
    JPanel displayFriTidsForsikiringpPanel = new JPanel();
    JPanel displayReiseForsikiringpPanel = new JPanel();
    JPanel displayKundePanel = new JPanel();

    JPanel displayText = new JPanel((new GridLayout(10, 10)));
    JPanel displayTextFri = new JPanel((new GridLayout(10, 10)));
    JPanel displaytextHus = new JPanel((new GridLayout(10, 10)));

    JPanel displayButton = new JPanel();
    JPanel displayButton1 = new JPanel();
    JPanel displayButton2 = new JPanel();
    JPanel displayButton3 = new JPanel();
    JPanel displayButton4 = new JPanel();
    JPanel displayButton5 = new JPanel();

    JPanel displayContent = new JPanel((new GridLayout(10, 5)));
     JPanel displayContent1 = new JPanel((new GridLayout(7, 2)));
    JPanel displayContent6 = new JPanel((new GridLayout(10, 5)));
    JPanel displayContent1b = new JPanel((new GridLayout(7, 5)));
     JPanel displayContent1c = new JPanel((new FlowLayout()));
    JPanel displayContent2 = new JPanel((new GridLayout(10, 5)));
    JPanel displayContent3 = new JPanel((new GridLayout(10, 5)));
    JPanel displayContent4 = new JPanel((new GridLayout(10, 5)));
    JPanel displayContent5 = new JPanel((new GridLayout(10, 10)));

    JPanel displayTable = new JPanel(new GridLayout(2, 2));
    JPanel displayTable1 = new JPanel(new GridLayout(2, 2));
    JPanel displayTable2 = new JPanel(new GridLayout(2, 2));
    JPanel displayTable3 = new JPanel(new GridLayout(2, 2));
    JPanel displayTable4 = new JPanel(new GridLayout(2, 2));
    JPanel displayTable5 = new JPanel(new GridLayout(4, 4));

    JTextField KundeNrfeltb = new JTextField();
    JTextField biltypefelt = new JTextField();
    JTextField regarfelt = new JTextField();
    JTextField regnrfelt = new JTextField();
    JTextField kjørelengdefelt = new JTextField();
    JTextField bonusfelt = new JTextField();
    JTextField modellfelt = new JTextField();
    JTextField kunderNrfelf = new JTextField();
    JButton view1 = new JButton("view");
    JButton save1 = new JButton("save");
    JButton addNew1 = new JButton("Add New");
    JButton exit1 = new JButton("Exit Application");

    // JtextField 
    JTextArea utskrift = new JTextArea(20, 20);
    JTextArea outputbill = new JTextArea(20, 20);
    JTextArea utskriftbaat = new JTextArea(20, 20);
    JTextArea outputfrihus = new JTextArea(20, 20);
    JTextArea outputReise = new JTextArea(20, 20);
    JTextArea outputhus = new JTextArea(20, 20);

    JTextField regnumfelt = new JTextField();
    JTextField baatypefelt = new JTextField();
    JTextField modellfelt1 = new JTextField();
    JTextField lengdefelt = new JTextField();
    JTextField årsmodellfelt = new JTextField();
    JTextField motorstyrkfelt = new JTextField();
    JTextField motortypefelt = new JTextField();
    JTextField bonusfelf2 = new JTextField();
    JTextField kunderNrfelt1 = new JTextField();
	JTextField BilregNumfelt = new JTextField();
	JTextField lengdefelt1 = new JTextField();


        //JTextfield båt

    JTextArea BoligenAdress = new JTextArea();
    ;
    JTextArea Boligtype = new JTextArea();
    JTextArea Byggematerial = new JTextArea();
    JTextArea standard = new JTextArea();
    JTextArea Byggeaar = new JTextArea();
    JTextArea AntallKvardratmeter = new JTextArea();
    JTextArea BelopB = new JTextArea();
    JTextArea Bounus = new JTextArea();

    JButton view2 = new JButton("view");
    JButton save2 = new JButton("save");
    JButton addNew2 = new JButton("Add New");
    JButton exit2 = new JButton("Exit Application");
    JButton regKunde = new JButton("regkunde");

    JTextField Navnfelt = new JTextField();
    JTextArea Adressefelt = new JTextArea();
    JButton eixt4 = new JButton("Exit Application");

    JTextArea BoligenAdress1 = new JTextArea();
    JTextArea BoligType1 = new JTextArea();
    JTextArea Byggematerial1 = new JTextArea();
    JTextArea Standerd1 = new JTextArea();
    JTextArea Byggeaar1 = new JTextArea();
    JTextArea AntallKvadrataMeter1 = new JTextArea();
    JTextArea BelopB1 = new JTextArea();
    JTextArea Bounus1 = new JTextArea();

    JButton view3 = new JButton("view");
    JButton save3 = new JButton("save");
    JButton addNew3 = new JButton("Add New");
    JButton exit3 = new JButton("Exit Application");

    @Override
    public void pack()
    {
        super.pack(); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args)
    {
        try
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {

            try
            {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
            {

            }
        }

        Runtime mainFrame = new Runtime();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Runtime()
    {

        setTitle(" Insurance ");
        setSize(1000, 500);

        // Create the tab pages
        BilForsikiringTable();
        BaatForsikiringTable();
        ReiseForsikiringTable();
        HusinnBoForsikringTable();
        fritidsForsikiringTable();
        KunderReg();

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3));
        getContentPane().add(topPanel);
        topPanel.add(tabbedPane, BorderLayout.CENTER);

        // Create tabs in tabbedPane
        tabbedPane.addTab("BaatForsikiring ", icon, displayBaaForsikiringpPanel,
                "Allows you to view or Enter Data into the Baat Database");

        tabbedPane.addTab("BilForsikirings ", icon, displayBilForsikiringPanel,
                "Allows you to view or Enter Data into the Bil Database");

        tabbedPane.addTab("fritidsforsikiring ", icon, displayFriTidsForsikiringpPanel,
                "Allows you to view or Enter Data into the Fritids Database");

        tabbedPane.addTab("husogInnboForsikiring ", icon, displayHusogInnboForsikiringpPanel,
                "Allows you to view or Enter Data into the HusogInnbo Database");

        tabbedPane.addTab("Reise ", icon, displayReiseForsikiringpPanel,
                "Allows you to view or Enter Data into the Reise Database");
        tabbedPane.addTab("Kunder Database", icon, displayKundePanel,
                "Allows you to view or Enter Data into the Reise Database");

        //Enable scrolling in tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        // pack();
    }

    public static ImageIcon createImageIcon(String path)
    {

        java.net.URL imgURL = Runtime.class.getResource(path);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void melding(String s)
    {

        JOptionPane.showMessageDialog(null, s, "Feil", JOptionPane.ERROR_MESSAGE);

    }

    private void KunderReg()
    {

        displayKundePanel.setLayout(new BorderLayout());
        //displayKundePanel.add(displayContent5 ,BorderLayout.WEST);
        displayKundePanel.add(displayButton5, BorderLayout.SOUTH);
        displayKundePanel.add(displayTable5, BorderLayout.NORTH);

        displayContent5.add(new JLabel("Kunde Navn"));
        displayContent5.add(Navnfelt);
        displayContent5.add((new JLabel("Adresse")));
        displayContent5.add(Adressefelt);

        displayButton5.add(regKunde);
        displayButton5.add(eixt4);
       // utskrift = new JTextArea(10, 5);
        // displayText.add(utskrift,BorderLayout.EAST);
        displayKundePanel.add(displayContent5, BorderLayout.CENTER);
        displayKundePanel.add(utskrift, BorderLayout.EAST);

        regKunde.addActionListener((ActionEvent e) ->
        {
            if (Navnfelt.getText().equals("") && Adressefelt.getText().equals(""))
            {

                melding("Du må fylle ut navnfelt og adresefelt");
                return;
            }
            String navn = Navnfelt.getText();
            String adr = Adressefelt.getText();
            Kunde k = new Kunde(navn, adr, null);
            boolean ok = lister.leggTilKunde(k);
            if (ok)
            {
                //melding("ok worked");
                utskrift.setText(lister.viskunde());
                 // Kundefeltk.setText(Integer.toString(k.getKundeNr()));//her setter vi den nye kunder i felter till alle forsikiring objecker vi har på vindu
                // KundeNrfelt3.setText(Integer.toString(k.getKundeNr()));//her setter vi den nye kunder i felter till alle forsikiring objecker vi har på vindu
                kunderNrfelt1.setText(Integer.toString(k.getKundeNr()));//her setter vi den nye kunder i felter till alle forsikiring objecker vi har på vindu
                // KundeNrfeltb.setText(Integer.toString(k.getKundeNr()));//her setter vi den nye kunder i felter till alle forsikiring objecker vi har på vindu
                // kunderNrfelt2.setText(Integer.toString(k.getKundeNr()));//her setter vi den nye kunder i felter till alle forsikiring objecker vi har på vindu
                //utskrift.append(k.toString());
            }
            else
            {
                utskrift.setText("Det gikk ikke");

            }
        });

        eixt4.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

    }

    private void BilForsikiringTable()
    {
        displayBilForsikiringPanel.setLayout(new BorderLayout());
       // displayBilForsikiringPanel.add(displayContent1,BorderLayout.WEST);
        //  displayBilForsikiringPanel.add(displayContent1, BorderLayout.EAST);
        displayBilForsikiringPanel.add(leggcont1opmeg, BorderLayout.CENTER);
        displayBilForsikiringPanel.add(displayButton1, BorderLayout.SOUTH);
        displayBilForsikiringPanel.add(displayTable1, BorderLayout.EAST);
        //displayBilForsikiringPanel.add(displayText,BorderLayout.AFTER_LINE_ENDS);
        // displayBilForsikiringPanel.add(displayText ,BorderLayout.)

        //displayTable1.add(new JTextArea(35,5));
        displayContent1.add(new JLabel("kunder navn"));
        displayContent1.add(KundeNrfeltb);
        displayContent1.add(new JLabel("Biltype"));
        displayContent1.add(biltypefelt);
        displayContent1.add(new JLabel("Registrerings År"));
        displayContent1.add(regarfelt);
        displayContent1.add(new JLabel("Registrerings Nummer"));
        displayContent1.add(regnrfelt);
        displayContent1.add(new JLabel("Kjøre Lengde"));
        displayContent1.add(kjørelengdefelt);
        displayContent1.add(new JLabel("Bonus"));
        displayContent1.add(bonusfelt);
        displayContent1.add(new JLabel("Bil modell"));
        displayContent1.add(modellfelt);
        displayContent1.add(new JLabel(""));
       // displayContent1c.add(displayContent1);
        //displayContent1c.add(displayContent1b);
        //displayContent1c.setBorder(BorderFactory.createTitledBorder("Kunder"));

        displayButton1.add(addNew);
        displayButton1.add(save);
        displayButton1.add(view);
        displayButton1.add(exit);
        leggcont1opmeg.add(displayContent1, BorderLayout.WEST);
        leggcont1opmeg.add(outputbill, BorderLayout.CENTER);

        addNew.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String pattern = "[A-Za-z]{3}[0-9]{3}";//regex uttrykk
				
				
					String modell = modellfelt.getText();
					 //String kunder =  KundeNrfeltb.getText();
					String bilttttype = biltypefelt.getText();
					String  registerBil = BilregNumfelt.getText();

                if (!(regnrfelt.getText().toUpperCase().matches(pattern)))
                {

                    JOptionPane.showMessageDialog(null, "Registreringsnummeret må \nbestå av 3 bokstaver og 3 tall\neks: CCC111", "FEIL INPUT", JOptionPane.ERROR_MESSAGE);

                }//her skjeke vis det er en bil far forrige
                else if (lister.finnBil(regnrfelt.getText().toUpperCase()) != null)
                {

                    JOptionPane.showMessageDialog(null, "En bil med samme registreringsnumer finnes fra før", "FEIL INPUT", JOptionPane.ERROR_MESSAGE);

                }//retuner feil meling
                else if (!(biltypefelt.getText().length() == 0 || modellfelt.getText().length() == 0
                           || KundeNrfeltb.getText().length() == 0 || regnrfelt.getText().length() == 0))
                {
							int year = Integer.parseInt(regarfelt.getText());
           
						//  double bon = Double.parseDouble(bonusfelt.getText());
						   int knr = Integer.parseInt(KundeNrfeltb.getText());
						   String biltype = (String)bilTypeCombo.getSelectedItem();
						   int md = Integer.parseInt(modellfelt.getText());
						   int lengde = Integer.parseInt( lengdefelt1.getText());
                  //  Bilforsikring bil = new Bilforsikring(KundeNrfeltb.getText().length(), null, lengde, year, lengde, biltypefelt.getText(), regnrfelt.getText(), bon,md);
					      Bilforsikring bil = new Bilforsikring(null, knr, registerBil, biltype, modell,lengde, year, bilttttype,md,lengde);

                    Kunde k = lister.finnKunder(knr);
                    if (k != null)
                    {
                       // k.leggTilbil(bil);
                        //k.setBil(bil);
                    }
                    //regnrfelt.setText(bil.getRegistetingsnummer());//setter string nummer i felt
                    if (!(k == null))
                    {
                        outputbill.setText("fant ikke kunder i forsikring \n med KunderNummer: " + knr);
                    }
                    outputbill.setText(k.toString() + "\n“er registrert på " + "\n" + bil.toString());
                }
                else
                {

                    JOptionPane.showMessageDialog(null, "Du må fylle inn all informasjon om bil for å registrere.", "FEIL INPUT", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.addActionListener((ActionEvent e) ->
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });
        exit.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

    }

    private void BaatForsikiringTable()
    {

        displayBaaForsikiringpPanel.setLayout(new BorderLayout());
        displayBaaForsikiringpPanel.add(displayContent, BorderLayout.CENTER);
        displayBaaForsikiringpPanel.add(displayButton, BorderLayout.SOUTH);
        displayBaaForsikiringpPanel.add(displayTable, BorderLayout.NORTH);

         //displayBaaForsikiringpPanel.add(utsrift,BorderLayout.EAST);
        displayContent.add(new JLabel("kunderNr"));
        displayContent.add(kunderNrfelt1);

        displayContent.add(new JLabel("Registrerings Nummer"));
        displayContent.add(regnumfelt);

        displayContent.add(new JLabel("Båt Type"));
        displayContent.add(baatypefelt);

        displayContent.add(new JLabel("Båt modell"));
        displayContent.add(modellfelt1);

        displayContent.add(new JLabel("Båt Lengde"));
        displayContent.add(lengdefelt);

        displayContent.add(new JLabel("Båt Årsmodell"));
        displayContent.add(årsmodellfelt);

        displayContent.add(new JLabel("MotorStyrk"));
        displayContent.add(motorstyrkfelt);

        displayContent.add(new JLabel("Motor Type"));
        displayContent.add(motortypefelt);

        displayContent.add(new JLabel("Bonus"));
        displayContent.add(bonusfelf2);

        displayButton.add(addNew1);
        displayButton.add(save1);
        displayButton.add(view1);
        displayButton.add(exit1);

        displayBaaForsikiringpPanel.add(displayContent, BorderLayout.WEST);
        displayBaaForsikiringpPanel.add(utskriftbaat, BorderLayout.CENTER);

        exit1.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });//luker vindu
    }

    private void ReiseForsikiringTable()
    {
        displayReiseForsikiringpPanel.setLayout(new BorderLayout());
        displayReiseForsikiringpPanel.add(displayButton2, BorderLayout.SOUTH);
        displayReiseForsikiringpPanel.add(displayContent2, BorderLayout.CENTER);
        displayReiseForsikiringpPanel.add(displayTable2, BorderLayout.NORTH);

        exit.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

    }

    private void HusinnBoForsikringTable()
    {
        displayHusogInnboForsikiringpPanel.setLayout(new BorderLayout());

        //displayHusogInnboForsikiringpPanel.add(displayContent3 ,BorderLayout.EAST);
        displayHusogInnboForsikiringpPanel.add(leggcont1opmeg3, BorderLayout.CENTER);
        displayHusogInnboForsikiringpPanel.add(displayButton3, BorderLayout.SOUTH);
        displayHusogInnboForsikiringpPanel.add(displayTable3, BorderLayout.EAST);

        displayContent3.add(new JLabel("BoligenAdress"));
        displayContent3.add(BoligenAdress);
        displayContent3.add(new JLabel("BoligType"));
        displayContent3.add(Boligtype);
        displayContent3.add(new JLabel("ByggeMateriale"));
        displayContent3.add(Byggematerial);
        displayContent3.add(new JLabel("Standard"));
        displayContent3.add(standard);
        displayContent3.add(new JLabel("Byggeaar"));
        displayContent3.add(Byggeaar);
        displayContent3.add(new JLabel("AntallKvardratmeter"));
        displayContent3.add(AntallKvardratmeter);
        displayContent3.add(new JLabel("BelopB"));
        displayContent3.add(BelopB);
        displayContent3.add(new JLabel("Bonus"));
        displayContent3.add(Bounus);

        displayButton3.add(addNew2);
        displayButton3.add(save2);
        displayButton3.add(view2);
        displayButton3.add(exit2);
        leggcont1opmeg3.add(displayContent3, BorderLayout.WEST);
        leggcont1opmeg3.add(outputhus, BorderLayout.CENTER);

       //  displayButton3.add(addNew2);
        //displayButton3.add(save2);
        // displayButton3.add(view2);
        //displayButton3.add(eixt2);
        exit2.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

    }

    private void fritidsForsikiringTable()
    {
        displayFriTidsForsikiringpPanel.setLayout(new BorderLayout());
//        displayFriTidsForsikiringpPanel.add(displayButton4 ,BorderLayout.SOUTH);
//        displayFriTidsForsikiringpPanel.add(displayContent4 ,BorderLayout.WEST);
//        displayFriTidsForsikiringpPanel.add(displayTable4 , BorderLayout.NORTH);
        displayFriTidsForsikiringpPanel.add(leggcont1opmeg4, BorderLayout.CENTER);
        displayFriTidsForsikiringpPanel.add(displayButton4, BorderLayout.SOUTH);
        displayFriTidsForsikiringpPanel.add(displayTable1, BorderLayout.EAST);

        displayContent4.add(new JLabel("BoligenAdress"));
        displayContent4.add(BoligenAdress1);
        displayContent4.add(new JLabel("BoligType"));
        displayContent4.add(BoligType1);
        displayContent4.add(new JLabel("ByggeMateriale"));
        displayContent4.add(Byggematerial1);
        displayContent4.add(new JLabel("Standard"));
        displayContent4.add(Standerd1);
        displayContent4.add(new JLabel("Byggeaar"));
        displayContent4.add(Byggeaar1);
        displayContent4.add(new JLabel("AntallKvardratmeter"));
        displayContent4.add(AntallKvadrataMeter1);
        displayContent4.add(new JLabel("BelopB"));
        displayContent4.add(BelopB1);
        displayContent4.add(new JLabel("Bonus"));
        displayContent4.add(Bounus1);

        displayButton4.add(addNew3);
        displayButton4.add(save3);
        displayButton4.add(view3);
        displayButton4.add(exit3);
        leggcont1opmeg4.add(displayContent4, BorderLayout.WEST);
        leggcont1opmeg4.add(outputfrihus, BorderLayout.CENTER);

        exit3.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });
    }

}
