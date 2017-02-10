package nl.tue.s2id90.group66.draughts.players;

import java.net.URL;
import javax.swing.ImageIcon;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.group66.UninformedPlayer;
import nl.tue.s2id90.group66.algorithms.ab.AbAlgorithm;
import nl.tue.s2id90.group66.algorithms.id.IdAlgorithm;
import nl.tue.s2id90.group66.algorithms.id.LinearIdAlgorithm;
import nl.tue.s2id90.group66.draughts.algorithms.DraughtsAbAlgorithm;
import nl.tue.s2id90.group66.draughts.raters.DraughtsRater;
import nl.tue.s2id90.group66.draughts.raters.concrete.SymmetricPieceRater;
import org10x10.dam.game.Move;

/**
 * A simple and configuratable implementation of the a player that uses an
 * iterative deepening algorithm with an alpha-beta pruning algorithm.
 * 
 * @author Wim Reddingius
 */
public class SimpleIdAbPlayer extends IdAbPlayer {
    
    // Default initial depth limit for the linear iterative deepening algorithm
    private static final int ID_INITIAL_DEPTH_LIMIT_DEFAULT = 1;
    // Default depth limit interval for the linear iterative deepening algorithm
    private static final int ID_DEPTH_LIMIT_INTERVAL_DEFAULT = 1;
    // Default player name
    private static final String PLAYER_NAME_DEFAULT = "SimpleIdAb player";
    // Default player icon
    private static final URL PLAYER_ICON_DEFAULT = UninformedPlayer.class.getResource("resources/simpleidab.png");
    
    // Initial depth limit for the linear iterative deepening algorithm
    private final int idInitialDepthLimit;
    // Depth limit interval for the linear iterative deepening algorithm
    private final int idDepthLimitInterval;
    // Rater that is used as heuristic evaluation function for the alpha-beta algorithm
    private final DraughtsRater rater;
    // Default player name
    private final String playerName;    
    // Default player icon
    private final ImageIcon playerIcon;
    
    /**
     * Constructs the player based on given name, icon, rater and
     * iterative deepening configuration.
     * 
     * @param playerName name of the player
     * @param iconUrl icon of the player
     * @param rater rater that is used as heuristic evaluation function for the
     * alpha-beta algorithm
     * @param idInitialDepthLimit initial depth limit of the iterative deepening algorithm
     * @param idDepthLimitInterval depth limit interval of the iterative deepening algorithm
     */
    public SimpleIdAbPlayer(final String playerName, final URL iconUrl, final DraughtsRater rater, final int idInitialDepthLimit, final int idDepthLimitInterval) {
        if (iconUrl == null) {
            this.playerIcon = null;
        } else {
            this.playerIcon = new ImageIcon(iconUrl);
        }
        this.rater = rater;
        if (playerName == null) {
            this.playerName = getDefaultName();
        } else {
            this.playerName = playerName;
        }
        this.idInitialDepthLimit = idInitialDepthLimit;
        this.idDepthLimitInterval = idDepthLimitInterval;
    }
    
    /**
     * Constructs the player based on given name and rater.
     * 
     * @param playerName name of the player
     * @param rater rater that is used as heuristic evaluation function for the
     * alpha-beta algorithm
     */
    public SimpleIdAbPlayer(final String playerName, final DraughtsRater rater) {
        this(playerName, PLAYER_ICON_DEFAULT, rater, ID_INITIAL_DEPTH_LIMIT_DEFAULT, ID_DEPTH_LIMIT_INTERVAL_DEFAULT);        
    }
    
    /**
     * Constructs the player based on given name and icon.
     * 
     * @param playerName name of the player
     * @param icon icon of the player
     */
    public SimpleIdAbPlayer(final String playerName, final URL icon) {
        this(playerName, icon, getDefaultRater(), ID_INITIAL_DEPTH_LIMIT_DEFAULT, ID_DEPTH_LIMIT_INTERVAL_DEFAULT);        
    }
    
    /**
     * Constructs the player based on given name, icon and rater.
     * 
     * @param playerName name of the player
     * @param icon icon of the player
     * @param rater rater that is used as heuristic evaluation function for the
     * alpha-beta algorithm
     */
    public SimpleIdAbPlayer(final String playerName, final URL icon, final DraughtsRater rater) {
        this(playerName, icon, rater, ID_INITIAL_DEPTH_LIMIT_DEFAULT, ID_DEPTH_LIMIT_INTERVAL_DEFAULT);        
    }

    /**
     * Constructs the player based on given name and iterative deepening configuration.
     * 
     * @param playerName name of the player
     * @param idInitialDepthLimit initial depth limit of the iterative deepening algorithm
     * @param idDepthLimitInterval depth limit interval of the iterative deepening algorithm
     */
    public SimpleIdAbPlayer(final String playerName, final int idInitialDepthLimit, final int idDepthLimitInterval) {
        this(playerName, PLAYER_ICON_DEFAULT, getDefaultRater(), idInitialDepthLimit, idDepthLimitInterval);
    }
    
    /**
     * Constructs the player based on given rater and iterative deepening configuration.
     * 
     * @param rater rater that is used as heuristic evaluation function for the
     * alpha-beta algorithm
     * @param idInitialDepthLimit initial depth limit of the iterative deepening algorithm
     * @param idDepthLimitInterval depth limit interval of the iterative deepening algorithm
     */
    public SimpleIdAbPlayer(final DraughtsRater rater, final int idInitialDepthLimit, final int idDepthLimitInterval) {
        this(PLAYER_NAME_DEFAULT, PLAYER_ICON_DEFAULT, rater, idInitialDepthLimit, idDepthLimitInterval);
    }
    
    /**
     * Constructs the player based on given name.
     * 
     * @param playerName name of the player
     */
    public SimpleIdAbPlayer(final String playerName) {
        this(playerName, ID_INITIAL_DEPTH_LIMIT_DEFAULT, ID_DEPTH_LIMIT_INTERVAL_DEFAULT);
    }

    /**
     * Constructs the player based on given rater.
     * 
     * @param rater rater that is used as heuristic evaluation function for the
     * alpha-beta algorithm
     */
    public SimpleIdAbPlayer(final DraughtsRater rater) {
        this(PLAYER_NAME_DEFAULT, rater);
    }
    
    /**
     * Constructs the player based on given iterative deepening configuration.
     * 
     * @param idInitialDepthLimit initial depth limit of the iterative deepening algorithm
     * @param idDepthLimitInterval depth limit interval of the iterative deepening algorithm
     */
    public SimpleIdAbPlayer(final int idInitialDepthLimit, final int idDepthLimitInterval) {
        this(PLAYER_NAME_DEFAULT, idInitialDepthLimit, idDepthLimitInterval);
    }
    
    /**
     * Constructs the player.
     */
    public SimpleIdAbPlayer() {
        this(PLAYER_NAME_DEFAULT);
    }
    
    /**
     * Returns the default rater.
     * 
     * @return the default rater
     */
    private static DraughtsRater getDefaultRater() {
        return new SymmetricPieceRater();
    }
    
    /**
     * Tries to use a player name based on the rater name, or use the default
     * player name if the rater's name is null.
     * 
     * @return the default player name.
     */
    private String getDefaultName() {
        String name = null;
        if (rater != null) {
            name = rater.getName();
        }
        if (name == null) {
            return PLAYER_NAME_DEFAULT;
        } else {
            return name;
        }
    }
    
    /**
     * Returns the name of the player.
     * 
     * @return the name of the player
     */
    @Override
    public String getName() {
        return playerName;
    }
    
    /**
     * Returns the icon of the player.
     * 
     * @return the icon of the player
     */
    @Override
    public ImageIcon getIcon() {
        return playerIcon;
    }
    
    /**
     * Creates the iterative deepening algorithm.
     * 
     * @param state the current draughts state
     * @return an instance of an implementation of the iterative deepening algorithm
     */
    @Override
    protected IdAlgorithm<? extends AbAlgorithm<Move>> createIdAlgorithm(final DraughtsState state) {
        // Let the rater know what is our playing color
        rater.setWhiteMine(state.isWhiteToMove());
        
        // Here we choose the implementation of the iterative deepening algorithm.
        // We need to extend the abstract linear iterative deepening algorithm to also be able choose an
        // implementation of the alpha-beta algorithm on run-time.
        LinearIdAlgorithm<DraughtsAbAlgorithm> algorithm = new LinearIdAlgorithm<DraughtsAbAlgorithm>(idInitialDepthLimit, idDepthLimitInterval) {
            
            /**
             * Creates an alpha-beta algorithm with a given depth limit.
             * 
             * @param depthLimit the depth limit for alpha-beta algorithm
             * @return an alpha-beta algorithm
             */
            @Override
            protected DraughtsAbAlgorithm createAlgorithm(final int depthLimit) {
                return createAbAlgorithm(state, depthLimit);
            }

        };
        // Return the iterative deepening algorithm
        return algorithm;
    }
    
    /**
     * Creates an alpha-beta algorithm based on a given state and depth limit.
     * 
     * @param state the initial state for the alpha-beta algorithm
     * @param depthLimit the depth limit for alpha-beta algorithm
     * @return an alpha-beta algorithm
     */
    protected DraughtsAbAlgorithm createAbAlgorithm(final DraughtsState state, final int depthLimit) {
        return new DraughtsAbAlgorithm(state, rater, depthLimit);
    }
}
