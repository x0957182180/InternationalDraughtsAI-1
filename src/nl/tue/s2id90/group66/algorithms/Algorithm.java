package nl.tue.s2id90.group66.algorithms;

/**
 * Classes that implement the Algorithm interface are supposed to have one instance for each run.
 * That means that the run method should be called once.
 * Moreover, the algorithm should be able to stop executing at any point in time.
 * 
 * @author Wim Reddingius
 */
public interface Algorithm extends Cloneable {
    
    /**
     * Runs the algorithm.
     * @throws AlgorithmStoppedException if the algorithm is stopped before termination
     */
    public void run() throws AlgorithmStoppedException;
    
    /**
     * Stops the execution of the algorithm.
     */
    public void stop();
    
}
