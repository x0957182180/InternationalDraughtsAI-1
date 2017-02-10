package nl.tue.s2id90.group66.algorithms.id;

import nl.tue.s2id90.group66.algorithms.Algorithm;

/**
 * LinearIdAlgorithm is the linear version of a generic iterative deepening algorithm.
 * It can be extended for problem-specific implementations.
 * 
 * @author Wim Reddingius
 * @param <AlgorithmType>
 */
public abstract class LinearIdAlgorithm<AlgorithmType extends Algorithm> extends DryIdAlgorithm<AlgorithmType> {
    
    // the initial depth limit
    private final int initialDepthLimit;
    // the interval for the depth limit
    private final int depthLimitInterval;
    
    /**
     * Constructs a linear iterative deepening algorithm instance with an initial depth limit
     * and an depth limit interval.
     * 
     * @param initialDepthLimit initial depth limit
     * @param depthLimitInterval depth limit interval
     */
    public LinearIdAlgorithm(int initialDepthLimit, int depthLimitInterval) {
        this.initialDepthLimit = initialDepthLimit;
        this.depthLimitInterval = depthLimitInterval;
    }
    
    /**
     * Returns the initial depth limit of the iterative deepning algorithm.
     * 
     * @return the initial depth limit
     */
    @Override
    protected int getInitialDepthLimit() {
        return initialDepthLimit;
    }
    
    /**
     * Returns the next depth limit based on the previous step number.
     * 
     * @param previousStep previous step number
     * @return the next depth limit
     */
    @Override
    protected int getNextDepthLimit(int previousStep) {
        return initialDepthLimit + previousStep * depthLimitInterval;
    }
    
}
