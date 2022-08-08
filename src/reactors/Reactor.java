package reactors;

public class Reactor {
	// Reactor class includes all the fields and methods that are common for any
	// type of reactor.

	// Initial values
	double a1, b1, c1, d1, FAo, FBo, FCo, FDo, kd, ki, volume;
	// Final values after reaction
	double Xresult, FA, FB, FC, FD;

	public Reactor(double FAO, double FBO, double FCO, double FDO) {
		this.FAo = FAO;
		this.FBo = FBO;
		this.FCo = FCO;
		this.FDo = FDO;
	}

	public void setVolume(double VOLUME) {
		this.volume = VOLUME;
	}

	public void setKinetics(double KDIRECT, double KINVERSE) {
		this.kd = KDIRECT;
		this.ki = KINVERSE;
	}

	public void setReactionCoefficients(double coeffA, double coeffB, double coeffC, double coeffD) {
		this.a1 = coeffA;
		this.b1 = coeffB;
		this.c1 = coeffC;
		this.d1 = coeffD;
	}
}