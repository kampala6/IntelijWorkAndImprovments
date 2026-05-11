//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.ui;

import no.insurance.model.*;
import no.insurance.service.*;
import no.insurance.db.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class RuntimeInsurance {
    /**
     * Creates the runtime launcher.
     */
    public RuntimeInsurance() {
    }

    /**
     * Starts the insurance application and configures the Nimbus look and feel when available.
     *
     * @param var0 command-line arguments
     */
    public static void main(String[] var0) {
        try {
            for(UIManager.LookAndFeelInfo var4 : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(var4.getName())) {
                    UIManager.setLookAndFeel(var4.getClassName());
                    break;
                }
            }
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException var5) {
        }

        SwingUtilities.invokeLater(() -> {
            Vindutest vindu = new Vindutest();
            vindu.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            vindu.addWindowListener(new WindowAdapter() {
                /**
                 * Persists data before the application window closes.
                 *
                 * @param var1 window event
                 */
                public void windowClosing(WindowEvent var1) {
                    vindu.skrivTilFil();
                    System.exit(0);
                }
            });
        });
    }
}
