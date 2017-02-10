package nl.tue.s2id90.group66.algorithms.id;

import nl.tue.s2id90.group66.algorithms.Algorithm;
import nl.tue.s2id90.group66.algorithms.AlgorithmStoppedException;

/**
 * DryAbAlgorithm is a generic iterative deepening algorithm implementation that can be used
 * for various problems. DRY stands for Don't Repeat Yourself. This class can be extended
 * for problem-specific implementations.
 * 
 * @author Wim Reddingius
 * @param <AlgorithmType> type of the underlying algorithm called each iteration
 */
abstract class DryIdAlgorithm<AlgorithmType extends Algorithm> implements IdAlgorithm<AlgorithmType> {
    
    // the instance of the underlying algorithm of the previous iteration
    private AlgorithmType previousAlgorithm = null;
    // the instance of the underlying algorithm of the current iteration
    private AlgorithmType currentAlgorithm = null;
    
    // current depth limit
    private int currentDepthLimit;
    // current iteration number
    private int currentStep = 1;
    // whether the algorithm is stopped
    private boolean stopped = false;
    
    /**
     * Returns the algorithm that runned with the previous depthLimit.
     * 
     * @return the algorithm that runned with the previous depthLimit
     */
    @Override
    public final AlgorithmType getPreviousAlgorithm() {
        return previousAlgorithm;
    }
    
    /**
     * Runs the iterative deepening algorithm until the algorithm is stopped.
     * 
     * @throws AlgorithmStoppedException if the algorithm is stopped.
     */
    @Override
    public final void run() throws AlgorithmStoppedException {
        currentDepthLimit = getInitialDepthLimit();
        // Keep iterating if the algorithm is not stopped
        while (!stopped) {
            currentAlgorithm = createAlgorithm(currentDepthLimit);
            // run() throws an AlgorithmStoppedException when the algorithm is stopped
            currentAlgorithm.run();
            previousAlgorithm = currentAlgorithm;
            currentDepthLimit = getNextDepthLimit(currentStep);
            currentStep++;
        }
    }
    
    /**
     * Stops this algorithm and the current instance of the underlying algorithm.
     */
    @Override
    public final void stop() {
        if (currentAlgorithm != null) {
            currentAlgorithm.stop();
            stopped = true;
        }
    }
    
    /**
     * Determines the initial depth limit.
     * 
     * @return the initial depth limit
     */
    protected abstract int getInitialDepthLimit();
    
    /**
     * Determines the next depth limit.
     * 
     * @param previousStep step number of the previous run where the first is 1
     * @return the next depth limit
     */
    protected abstract int getNextDepthLimit(int previousStep) throws AlgorithmStoppedException;
    
    /**
     * Creates an algorithm with a depth limit.
     * 
     * @param depthLimit the depth limit for the underlying algorithm
     * @return an algorithm (ready to run)
     */
    protected abstract AlgorithmType createAlgorithm(int depthLimit);
    
}
