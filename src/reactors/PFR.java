package reactors;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import numericalMethods.PFRode;


public class PFR extends Reactor{

	public PFR(double FAO, double FBO, double FCO, double FDO) {
		
		this.FAo = FAO;
		this.FBo = FBO;
		this.FCo = FCO;
		this.FDo = FDO;
		
	}
	

	public PFR() {
		// TODO Auto-generated constructor stub
	}


	public double[] getOutputFlowrates() {
		
		FirstOrderIntegrator dp853 = new DormandPrince853Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
		//Using constructor: DormandPrince853Integrator(double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
		
		double[] coeff = {-a1, -b1, +c1, +d1};
		//Creating 
		FirstOrderDifferentialEquations ode = new PFRode(kd, ki, coeff );
		
		// array with initial state
		double[] Flowrates = new double[] { FAo, FBo, FCo, FDo }; 	
		
		// final state after integration to volume.
		dp853.integrate(ode, 0.0, Flowrates, volume, Flowrates); 	
		
		return Flowrates;
	}
	
}
