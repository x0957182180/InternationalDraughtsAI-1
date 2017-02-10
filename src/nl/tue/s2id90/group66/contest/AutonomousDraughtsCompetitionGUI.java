package nl.tue.s2id90.group66.contest;

import nl.tue.s2id90.draughts.DraughtsGUI;
import nl.tue.s2id90.draughts.DraughtsPlugin;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;
import nl.tue.s2id90.game.Game.Result;
import org10x10.dam.game.Move;

/**
 * Launches a new AutonomousCompetitionGUI for International Draughts.
 * 
 * @author Wim Reddingius
 */
public class AutonomousDraughtsCompetitionGUI 
extends AutonomousCompetitionGUI<DraughtsPlayer, DraughtsPlugin, Move, DraughtsState> {
    AutonomousDraughtsCompetitionGUI(String[] pluginFolders) {
        super(DraughtsPlugin.class,pluginFolders);
        DraughtsGUI gui = new DraughtsGUI();
        initComponents(gui);
        
        // listen to eachother's events
        this.add(gui);
        gui.add(this);
    }
    
   /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CompetitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CompetitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CompetitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CompetitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutonomousDraughtsCompetitionGUI(args).setVisible(true);
            }
        });
    } 
}
