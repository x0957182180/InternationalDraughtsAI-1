package nl.tue.s2id90.group66.algorithms.id;

import nl.tue.s2id90.group66.algorithms.Algorithm;

/**
 * An interface to the iterative deepening algorithm.
 * 
 * @author Wim Reddingius
 * @param <AlgorithmType> type of the underlying algorithm called each iteration
 */
public interface IdAlgorithm<AlgorithmType> extends Algorithm {
    
    /**
     * Returns the last executed and terminated instance of the underlying algorithm.
     * 
     * @return the last executed and terminated instance of the underlying algorithm
     */
    public AlgorithmType getPreviousAlgorithm();
    
}
