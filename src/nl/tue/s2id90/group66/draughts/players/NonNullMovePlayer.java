package nl.tue.s2id90.group66.draughts.players;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;
import org10x10.dam.game.Move;

/**
 * This abstract player guarantees to return a non-null move when there are moves available.
 * 
 * @author Wim Reddingius
 */
public abstract class NonNullMovePlayer extends DraughtsPlayer {
    
    /**
     * Return the move calculated by calculateMove() or a random move if null
     * was returned.
     * 
     * @param state current state
     * @return the move calculated by calculateMove() or a random move if null
     * was returned
     */
    @Override
    public final Move getMove(DraughtsState state) {
        Move move = calculateMove(state);
        if (move == null) {
            List<Move> moves = state.getMoves();
            if (moves.isEmpty()) {
                return null;
            } else {
                Collections.shuffle(moves);
                return moves.get(0);
            }
        } else {
            return move;
        }
    }
    
    /**
     * Calculates a move or returns null for a random move.
     * 
     * @param state current state
     * @return a move or returns null for a random move
     */
    protected abstract Move calculateMove(DraughtsState state);
    
}
