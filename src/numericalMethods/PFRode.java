package numericalMethods;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class PFRode implements FirstOrderDifferentialEquations {

	// FirstOrderDifferentialEquations interface requires only two methods as per
	// documentation: getDimension() to specify the dimension of the system
	// computeDerivatives() that will calculate the derivatives for each integration step

	private final double kDirect;
	private final double kInverse;
	private final double[] coeff;

	public PFRode(double kDirect, double kInverse, double[] coeff) {
		// created constructor to receive these required constant values
		this.kDirect = kDirect;
		this.kInverse = kInverse;
		this.coeff = coeff;

	}

	public int getDimension() {
		// Dimension is 4 as per the 4 differential equations below.
		return 4;
	}

	public void computeDerivatives(double V, double[] F, double[] FDot) {

		// solving the system dF(i)/dV = r(i) where i is each of the 4 components.

		double[] r = new double[4];
		double[] X = new double[4];

		// calculating molar concentration for each component
		double totalFlow = 0;
		// first compute the total on that step
		for (int i = 0; i < 4; i++) {
			totalFlow = totalFlow + F[i];
		}
		// then each molar concentration
		for (int i = 0; i < 4; i++) {
			X[i] = F[i] / totalFlow;
		}

		// using ideal kinetics that are linear function of each component
		// direct reaction is proportional to reactants
		// inverse reaction is proportional to products
		// future version can include different kinetic models that can be created by
		// having a kinetics class for more complex models
		double rDirect = kDirect * X[0] * X[1];
		double rInverse = kInverse * X[2] * X[3];

		for (int i = 0; i < 4; i++) {

			r[i] = coeff[i] * (rDirect - rInverse);
			// separating Fdot (derivative) from r. With an energy balance, equation is
			// likely to get more complicated. This simplifies the reading.
			FDot[i] = r[i];
		}
	}
}