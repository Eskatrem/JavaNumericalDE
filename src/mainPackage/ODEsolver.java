package mainPackage;

public class ODEsolver {

	protected double start;
	protected double end;
	protected double step;
	protected int nSteps;
	protected double[] x;
	protected double[] y;
	
	public ODEsolver(double start, double end, double step) {
		if(step <= 0) {
			return;
		}
		this.start = start;
		this.end = end;
		this.step = step;
		this.nSteps = (int) (Math.abs(end - start)/step) +1;
		initX();
	}
	
	public ODEsolver(double start, double end, int nSteps) {
		if(nSteps <= 0) {
			return;
		}
		this.start = start;
		this.end = end;
		this.nSteps = nSteps;
		this.step =Math.abs(end - start)/((double) nSteps);
		initX();
	}
	
	
	//solves equation of the type:
	//y' = func(y) with y(start) = fStart
	//y'(x) = (y(x+step) - y(x))/step
	// <=> y(x + step) = y(x) + step * y'(x) = y(x) + step * func(y(x))
	public double[][] solve(MathFunction func, double fStart) {
		double[][] res = new double[nSteps][];
		res[0] = new double[]{start, fStart};
		for(int i = 1; i < nSteps; i++) {
			res[i] = new double[]{x[i], res[i-1][1] + step * func.eval(res[i-1][1])};
		}
		return res;
	}
	
	protected void initX() {
		this.x = new double[nSteps];
		this.x[0] = start;
		for(int i =1; i < nSteps; i++) {
			x[i] = step + x[i-1];
		}
	}
	
}
