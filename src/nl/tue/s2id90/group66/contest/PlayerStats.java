package nl.tue.s2id90.group66.contest;

import nl.tue.s2id90.game.Game.Result;

/**
 * Data structure used to store the game statistics of some player. To be more 
 * particular: number of wins, losses, draws and games played.
 * 
 * @author Wim Reddingius
 */
public class PlayerStats {
    
    private int numPoints = 0;
    private int numWins = 0;
    private int numLosses = 0;
    private int numDraws = 0;
    private int numPlayed = 0;

    
    public int getPoints() {
        return numPoints;
    }
    
    public int getWins() {
        return numWins;
    }
    
    public int getLosses() {
        return numLosses;
    }

    public int getDraws() {
        return numDraws;
    }
    
    public int getPlayed() {
        return numPlayed;
    }
    
    /**
     * Updates the player statistics stored in this data structure with the 
     * given result of some game
     * 
     * @param result
     * @param isWhite 
     */    
    public void applyResult(Result result, boolean isWhite) {
        numPlayed ++;
        switch (result) {
            case UNKNOWN:
                break;
            case DRAW:
                numDraws ++;
                break;
            case WHITE_WINS:
                if (isWhite) {
                    numWins ++;
                } else {
                    numLosses ++;
                }
                break;
            case BLACK_WINS:
                if(!isWhite) {
                    numWins ++;
                } else {
                    numLosses ++;
                }
                break;
        }
        if (isWhite) {
            numPoints += result.getWhitePoints();
        } else {
            numPoints += result.getBlackPoints();
        }
    }
    
}
