package nl.tue.s2id90.group66.draughts.raters;

/**
 * A piece rater that only rates pawns, filters out the other pieces.
 *
 * @author Wim Reddingius
 */
public abstract class PawnRater extends PieceRater {

    /**
     * Returns the score for a piece.
     * 
     * @param position position
     * @param pieceType piece type
     * @return piece's score
     */
    @Override
    protected int ratePiece(int position, int pieceType) {
        if (isPawn(pieceType)) {
            return ratePawn(position, isPieceMine(pieceType));
        }
        return 0;
    }

    /**
     * Returns the score for a pawn.
     * 
     * @param position position
     * @param isMine whether the pawn is mine
     * @return pawn's score
     */
    protected abstract int ratePawn(int position, boolean isMine);
    
}
