package nl.tue.s2id90.group66.draughts.raters.concrete;

import nl.tue.s2id90.group66.draughts.raters.PawnRater;

/**
 * A pawn rater that is symmetric, which means that we rate my pieces in the same
 * way as the opponent's pieces, but negative. The default implementation simply
 * counts the number of my pawn and subtracts the number of the opponent's pawn.
 * 
 * @author Wim Reddingius
 */
public class SymmetricPawnRater extends PawnRater {

    // Rater's name
    private static final String RATER_NAME = "Pawns";
    
    /**
     * Returns the score for a pawn.
     * 
     * @param position position
     * @param isMine whether the pawn is mine
     * @return pawn's score
     */
    @Override
    protected final int ratePawn(int position, boolean isMine) {
        int score = rateMyPawn(position);
        if (isMine) {
            return score;
        } else {
            return -score;
        }
    }
    
    /**
     * Rate a pawn as if it is mine. The default implementation returns 1,
     * which means that it simply counts the pawns.
     * 
     * @param position position
     * @return 1
     */
    protected int rateMyPawn(int position) {
        return 1;
    }
    
    /**
     * Returns the rater's name.
     * 
     * @return the rater's name
     */
    @Override
    public String getName() {
        return RATER_NAME;
    }
    
}
