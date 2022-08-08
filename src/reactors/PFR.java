package reactors;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import numericalMethods.PFRode;

public class PFR extends Reactor {

	// PFR class extends Reactor class since other types of reactors will eventually
	// be calculated.

	public PFR(double FAO, double FBO, double FCO, double FDO) {
		// constructor from the super class is called for initial values.
		super(FAO, FBO, FCO, FDO);
	}

	public double[] getOutputFlowrates() {

		FirstOrderIntegrator dp853 = new DormandPrince853Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
		// constructor: DormandPrince853Integrator(double minStep, double maxStep,
		// double scalAbsoluteTolerance, double scalRelativeTolerance)
		// as per Apache math documentation

		// coefficients are negative for reactants (to make derivative negative)
		// coefficients are positive for products (to make derivative positive)
		double[] coeff = { -a1, -b1, +c1, +d1 };
		FirstOrderDifferentialEquations ode = new PFRode(kd, ki, coeff);

		// array with initial state
		double[] Flowrates = new double[] { FAo, FBo, FCo, FDo };

		// final state after integration to volume.
		dp853.integrate(ode, 0.0, Flowrates, volume, Flowrates);
		// next version will use an integrator that returns an array with values to be
		// able to create graphs.
		return Flowrates;
	}
}