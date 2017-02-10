package nl.tue.s2id90.group66.draughts.raters.concrete;

import nl.tue.s2id90.group66.draughts.raters.PawnRater;

/**
 * A pawn rater that rates the pawns based on their distance to the opponent's base row.
 * 
 * @author Wim Reddingius
 */
public class DistanceRater extends PawnRater {
    
    // Name of the rater
    private static final String RATER_NAME = "Distance";
    
    /**
     * Returns the distance to the opponent's base row or negative distance for
     * opponent's pawns.
     * 
     * @param position position
     * @param isMine whether the pawn is mine
     * @return pawn's distance to the opponent's base row
     */
    @Override
    protected int ratePawn(int position, boolean isMine) {
        final int row = getRow(position);
        if (isMine) {
            // Positive score for my pawns
            return Math.abs(getOpponentsBaseRow() - row);
        } else {
            // Negative score for opponent's pawns
            return -Math.abs(getMyBaseRow() - row);
        }
    }
    
    /**
     * Returns the name of the rater.
     * 
     * @return the name of the rater
     */
    @Override
    public String getName() {
        return RATER_NAME;
    }
    
}
