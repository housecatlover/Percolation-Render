
/**
 * Performs experiments with Percolation_AS to return statistics
 *
 * Alex Schwartz
 * j8 1/10/22
 */
public class PercolationStats_AS
{
    double[] lengths;
    int size;
    public PercolationStats_AS(int n, int t){
        long startTime = System.currentTimeMillis();
        Percolation_AS percolat; 
        lengths = new double[t];
        size = t;
        for (int i = 0; i < t; i++){
            percolat = new Percolation_AS(n);   
            lengths[i] = percolat.main(n);
        }
        System.out.println((System.currentTimeMillis() - startTime) + " ms");
    }
    
    public PercolationStats_AS(int n, int t, boolean weighted){
        long startTime = System.currentTimeMillis();
        Percolation_AS percolat; 
        lengths = new double[t];
        size = t;
        for (int i = 0; i < t; i++){
            percolat = new Percolation_AS(n);   
            lengths[i] = percolat.weightedMain(n);
        }
        System.out.println((System.currentTimeMillis() - startTime) + " ms");
    }

    public double mean(){
        double sum = 0;
        for (int i = 0; i < size; i++){
            sum += lengths[i];
        }
        return (sum / size);
    }

    public double stddev(){
        double sum = 0; 
        double mean = mean();
        for (int i = 0; i < size; i++){
            sum += Math.abs(lengths[i] - mean);
        }
        return (sum / size);
    }

    public double confidenceLow(){
        return mean() - 1.96*stddev()/Math.sqrt(size);
    }
    
    public double confidenceHigh(){
        return mean() + 1.96*stddev()/Math.sqrt(size);
    }    
}
