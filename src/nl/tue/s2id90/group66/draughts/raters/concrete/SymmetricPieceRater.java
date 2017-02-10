package nl.tue.s2id90.group66.draughts.raters.concrete;

import nl.tue.s2id90.group66.draughts.raters.PieceRater;

/**
 * A piece rater that is symmetric, which means that we rate my pieces in the same
 * way as the opponent's pieces, but negative. The default implementation simply
 * counts the number of my pieces and subtracts the number of the opponent's pieces.
 * 
 * @author Wim Reddingius
 */
public class SymmetricPieceRater extends PieceRater {

    // Rater's name
    private static final String RATER_NAME = "Kings";
    
    /**
     * Returns the score for a piece.
     * 
     * @param position position
     * @param pieceType piece type
     * @return piece's score
     */
    @Override
    protected final int ratePiece(int position, int pieceType) {
        int score = rateMyPiece(position);
        if (isPieceMine(pieceType)) {
            return score;
        } else {
            return -score;
        }
    }

    /**
     * Rate a piece as if it is mine. The default implementation returns 1,
     * which means that it simply counts the pieces.
     * 
     * @param position position
     * @return 1
     */
    protected int rateMyPiece(int position) {
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
