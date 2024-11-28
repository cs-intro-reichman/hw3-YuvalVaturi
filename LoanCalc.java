// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter;    
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);

		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		// System.out.println("end balance fo 10k " + endBalance(loan, rate, n, 10000));
		// System.out.println("end balance fo 10k " + endBalance(loan, rate, n, 13000));

		// brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	//(last payment - period) * (1 + rate/100)
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double balance = loan;
		if (rate == 0) {
			for (int i = 0; i < n; i++) {
				balance -= payment;
			}
			return balance;
		}
		
		for (int i = 0; i<n; i++){
			balance = ((balance - payment)*(1 + rate/100));
			// System.out.println("end balance no " + i + ": " + balance);

		}
		return balance;
	}
	

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double g = (double) loan/n;
		while (endBalance(loan, rate, n, g) > 0 ){
			g = g + epsilon;
			iterationCounter++;
		}
		return g;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double low = (double) loan/n;
		double high = (double) loan;
		double g = (double) (high+low)/2;
		// System.out.println("low is: " + low + " high is: " + high);
		while ((high - low) > epsilon){
			if ((endBalance(loan, rate, n, g)*endBalance(loan, rate, n, low)) > 0){
				low = g;
			}
			else {
				high = g;
			}
			g = (double) (high+low)/2;
			iterationCounter++;

		}

		return g;
    }
}

// java LoanCalc.java 100000 5 10 
// java LoanCalc.java 100000 5 1