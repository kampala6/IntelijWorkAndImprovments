//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class RuntimeInsurance {
    public RuntimeInsurance() {
    }

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
                public void windowClosing(WindowEvent var1) {
                    vindu.skrivTilFil();
                    System.exit(0);
                }
            });
        });
    }
}
