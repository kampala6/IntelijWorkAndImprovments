/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 *
 * @author Mojola
 */
public class mainKlasse
{

    public static void main(String[] args) throws IOException
    {

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

    }
}
