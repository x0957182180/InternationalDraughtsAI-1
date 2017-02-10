package nl.tue.s2id90.group66.draughts.raters;

/**
 * A piece rater that only rates kings, filters out the other pieces.
 * 
 * @author Wim Reddingius
 */
public abstract class KingRater extends PieceRater {

    /**
     * Returns the score for a piece.
     * 
     * @param position position
     * @param pieceType piece type
     * @return piece's score
     */
    @Override
    protected final int ratePiece(int position, int pieceType) {
        if (isKing(pieceType)) {
            return rateKing(position, isPieceMine(pieceType));
        }
        return 0;
    }
    
    /**
     * Returns the score for a king.
     * 
     * @param position position
     * @param isMine whether the king is mine
     * @return king's score
     */
    protected abstract int rateKing(int position, boolean isMine);
    
}
