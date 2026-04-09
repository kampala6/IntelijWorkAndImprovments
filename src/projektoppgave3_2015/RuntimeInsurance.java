/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Gruppe 57
 *
 * @author Arash Amini s
 * @author Suraj Tamrakar
 * @author Lunga Majola
 */

public class RuntimeInsurance
{
	

    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here
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
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }// hentet fra java 

        final Vindutest vindu = new Vindutest();

        vindu.addWindowListener(
                new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent e)
                    {
                        vindu.skrivTilFil();
                        System.exit(0);
                    }

                });

         vindu.setVisible(true);
        vindu.skrivTilFil();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // System.exit(0);
        vindu.setVisible(true);
         vindu.skrivTilFil();
        //vindu.skrivbilFil();
    }

}//end of class
