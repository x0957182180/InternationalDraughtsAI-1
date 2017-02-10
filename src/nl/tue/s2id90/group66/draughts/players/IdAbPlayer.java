package nl.tue.s2id90.group66.draughts.players;

import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.group66.algorithms.AlgorithmStoppedException;
import nl.tue.s2id90.group66.algorithms.ab.AbAlgorithm;
import nl.tue.s2id90.group66.algorithms.id.IdAlgorithm;
import org10x10.dam.game.Move;

/**
 * A draughts player that uses an alpha-beta algorithm with iterative deepening.
 * 
 * @author Wim Reddingius
 */
abstract class IdAbPlayer extends NonNullMovePlayer {
    
    // instance of the iterative deepening algorithm
    private IdAlgorithm<? extends AbAlgorithm<Move>> idAlgorithm;

    /**
     * Calculate the move to make from a given state.
     * 
     * @param state current state
     * @return the move to make or null when no move is found
     */
    @Override
    public final Move calculateMove(DraughtsState state) {
        // stop the previous instance of the algorithm if it is not stopped yet
        stop();
        idAlgorithm = createIdAlgorithm(state);
        
        try {
            idAlgorithm.run();
        } catch (AlgorithmStoppedException exception) {
            // When the iterative deepning algorithm is stopped,
            // take the instance of its alpha-beta algorithm that is used in the previous iteration
            AbAlgorithm<Move> algorithm = idAlgorithm.getPreviousAlgorithm();
            if (algorithm != null) {
                Move move = algorithm.getBestSolution();
                return move;
            }
        }
        return null;
    }
    
    /**
     * The player stops searching for a move.
     */
    @Override
    public final void stop() {
        if (idAlgorithm != null) {
            idAlgorithm.stop();
        }
    }
    
    /**
     * Creates the iterative deepening that is used.
     * 
     * @return iterative deepening algorithm instance
     */
    protected abstract IdAlgorithm<? extends AbAlgorithm<Move>> createIdAlgorithm(DraughtsState state);
    
}
