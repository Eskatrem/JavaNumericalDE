package mainPackage;

public class MainClass {

	public static void main(String[] args) {
		//solve differential equation y' = y with y(0) = 1
		ODEsolver solver = new ODEsolver(0.0,10.0,1000);
		double[][] approxValues = solver.solve(new IdentityFunction(), 1);
		int n = approxValues.length;
		for(int i = 0; i < n; i++) {
			System.out.println(approxValues[i][0]+" "+approxValues[i][1]);
		}
	}
}
