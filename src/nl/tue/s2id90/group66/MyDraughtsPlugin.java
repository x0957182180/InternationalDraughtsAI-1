package nl.tue.s2id90.group66;

import nl.tue.s2id90.draughts.DraughtsPlugin;
import nl.tue.s2id90.group66.draughts.players.SimpleIdAbPlayer;
import nl.tue.s2id90.group66.draughts.raters.concrete.OverallRater;


/**
 *
 * 
 */
public class MyDraughtsPlugin extends DraughtsPlugin {
    public MyDraughtsPlugin() {
        // make two players available to the AICompetition tool
        // During the final competition you should make only your 
        // best player available. For testing it might be handy
        // to make more than one player available.         
        
        super(new SimpleIdAbPlayer("Group 66", new OverallRater(20, 50, 0, 2, 1, 0)));
    }
}