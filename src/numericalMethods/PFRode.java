package numericalMethods;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class PFRode implements FirstOrderDifferentialEquations {

    private double kDirect;
	private double kInverse;
	private double[] coeff;

	public PFRode(double kDirect, double kInverse, double[] coeff) {
		
		this.kDirect = kDirect;
		this.kInverse = kInverse;
		this.coeff = coeff;
		
    }

    public int getDimension() {
        // Dimension is 4 as per the 4 differential equations below.
    	return 4;
    }

    public void computeDerivatives(double V, double[] F, double[] FDot) {
        
    	double[] r = new double[4];
    	double[] X = new double[4];
    	
    	
    	double totalFlow = 0;
    	for (int i = 0 ; i < 4 ; i++ ) {
    		totalFlow = totalFlow + F[i];
    	}
    	
    	for (int i = 0 ; i < 4 ; i++ ) {
    		X[i] = F[i] / totalFlow;
    	}
       		
  		double rDirect = kDirect * X[0] * X[1];
      	double rInverse = kInverse * X[2] * X[3];
    	    	
    	for (int i = 0; i < 4 ; i++) {
    		
    		r[i] = coeff[i]*(rDirect - rInverse);
    		
    		FDot[i] = r[i];
    	}
    	
    }

}