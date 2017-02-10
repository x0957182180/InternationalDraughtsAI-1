package nl.tue.s2id90.group66.draughts.raters;

/**
 * A position rater that only rates pieces, filters out empy positions.
 *
 * @author Wim Reddingius
 */
public abstract class PieceRater extends PositionRater {

    /**
     * Returns the score for a given position.
     * 
     * @param index position
     * @param contentType piece type
     * @return position's score
     */
    @Override
    protected int ratePosition(int index, int contentType) {
        if (isPiece(contentType)) {
            return ratePiece(index, contentType);
        }
        return 0;
    }
    
    /**
     * Returns the score for a piece.
     * 
     * @param position position
     * @param pieceType piece type
     * @return piece's score
     */
    protected abstract int ratePiece(int position, int pieceType);

}
