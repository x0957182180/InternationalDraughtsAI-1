package nl.tue.s2id90.group66.draughts.raters;

import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.group66.raters.Rater;

/**
 * Base class for draughts raters.
 * 
 * @author Wim Reddingius
 */
public abstract class DraughtsRater extends Rater<DraughtsState> {
    
    // Row on the board closest to the white player
    private static final int BASE_ROW_WHITE = 9;
    // Row on the board closest to the black player
    private static final int BASE_ROW_BLACK = 0;
    
    // Position index range start
    protected static final int INDEX_START = 1;
    // Position index range end
    protected static final int INDEX_END = 50;
    
    // Number of positions per row
    private static final int POSITIONS_PER_ROW = 5;
    
    // Whether I am playing with white
    private boolean isWhiteMine;
    
    /**
     * Set whether I am playing with white.
     * 
     * @param isWhiteMine true if I am the white player, false for black
     */
    public void setWhiteMine(final boolean isWhiteMine) {
        this.isWhiteMine = isWhiteMine;
    }
    
    /**
     * Returns whether I am playing with white.
     * 
     * @return whether I am playing with white
     */
    protected final boolean isWhiteMine() {
        return isWhiteMine;
    }
    
    /**
     * Returns whether a piece type is mine.
     * 
     * @param piece piece type
     * @return whether a piece type is mine
     */
    protected final boolean isPieceMine(final int piece) {
        switch (piece) {
            case DraughtsState.BLACKPIECE:
            case DraughtsState.BLACKKING:
                return !isWhiteMine;
            case DraughtsState.WHITEPIECE:
            case DraughtsState.WHITEKING:
                return isWhiteMine;
            default:
                return false;
        }
    }
    
    /**
     * Returns whether a piece type is empty.
     * 
     * @param pieceType piece type
     * @return whether a piece type is empty
     */
    protected static final boolean isEmpty(final int pieceType) {
        return !isPiece(pieceType);
    }
    
    /**
     * Returns whether a piece type is a piece (pawn or king).
     * 
     * @param pieceType piece type
     * @return whether a piece type is a piece
     */
    protected static final boolean isPiece(final int pieceType) {
        switch (pieceType) {
            case DraughtsState.BLACKPIECE:
            case DraughtsState.BLACKKING:
            case DraughtsState.WHITEPIECE:
            case DraughtsState.WHITEKING:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Returns whether a piece type is a king
     * 
     * @param piece piece type
     * @return whether a piece type is a king
     */
    protected static final boolean isKing(final int piece) {
        switch (piece) {
            case DraughtsState.BLACKKING:
            case DraughtsState.WHITEKING:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Returns whether a piece type is a pawn
     * 
     * @param piece piece type
     * @return whether a piece type is a pawn
     */
    protected static final boolean isPawn(final int piece) {
        switch (piece) {
            case DraughtsState.BLACKPIECE:
            case DraughtsState.WHITEPIECE:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Returns the row number based on a position index
     * 
     * @param index position
     * @return the row number of the position
     */
    protected static final int getRow(int index) {
        return (index - INDEX_START) / POSITIONS_PER_ROW;
    }
    
    /**
     * Returns the number of the row closest to me.
     * 
     * @return the number of the row closest to me
     */
    protected final int getMyBaseRow() {
        if (isWhiteMine()) {
            return BASE_ROW_WHITE;
        } else {
            return BASE_ROW_BLACK;
        }
    }
    
    /**
     * Returns the number of the row closest to the opponent.
     * 
     * @return the number of the row closest to the opponent
     */
    protected final int getOpponentsBaseRow() {
        if (isWhiteMine()) {
            return BASE_ROW_BLACK;
        } else {
            return BASE_ROW_WHITE;
        }
    }
    
    /**
     * Returns whether a position is adjacent to an edge of the board.
     * 
     * @return whether a position is adjacent to an edge of the board
     */
    protected static boolean isPieceAdjacentToEdge(int position) {
        int modPosition = position % (POSITIONS_PER_ROW * 2);
        return position <= 5 || position >= 46 || modPosition == POSITIONS_PER_ROW || modPosition == POSITIONS_PER_ROW + 1;
    }
    
    /**
     * Returns whether a position is on the opponent's base row.
     * 
     * @param position position (index)
     * @return whether a position is on the opponent's base row
     */
    protected boolean isAtMyPromotionLine(int position) {
        return getRow(position) == getOpponentsBaseRow();
    }
    
    /**
     * Returns the name of this rater.
     * 
     * @return the name of this rater
     */
    public String getName() {
        return null;
    }
    
}
