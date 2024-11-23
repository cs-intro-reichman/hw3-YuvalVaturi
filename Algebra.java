// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 = 5
		System.out.println(plus(2,(-3)));   // 2 - 3 = -1
		System.out.println(plus((-2),(-3)));   // -2 - 3 = -5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
		System.out.println(minus((-2),7));  // -2 - 7 = -9
 		System.out.println(times(3,4));  // 3 * 4 = 12
		System.out.println(times((-3),4));  // -3 * 4 = -12
		System.out.println(times((-3),(-4)));  // -3 * -4 = +12
		System.out.println(times(3,(-4)));  // 3 * -4 = -12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
		System.out.println(pow((-5),3));      // -5^3 = -125
		System.out.println(pow(5,0));      // 5^0 = 1
		System.out.println(pow(5,1));      // 5^1 = 5
   		System.out.println(div(12,3));   // 12 / 3 = 4    
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3 
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6 = 0 
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x2 > 0)
			for (int i = 0; i<x2; i++){
			sum = sum + 1;
		}
		else
			for (int i = 0; i>x2; i--){
			sum = sum - 1;
		}
		
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int product = 0;
		boolean negative = (x1 < 0) ^ (x2 < 0);
		
		if (x1 < 0) {
			x1 = minus(0, x1); } 
		if (x2 < 0) {
			x2 = minus(0, x2); } 
		for (int i = 0; i<x2; i++){
			product = plus(product, x1);
		}
		if (negative){
			product = minus(0, product);
		}

		return product;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) return 1;
		int x1 = x;
		if (x < 0) {
			x1 = minus(0, x1);
		}
		int power = 1;
		for (int i = 0; i<n; i++){
			power = times(power, x1);
		}
		if (x < 0 && mod(n, 2) != 0){
			power = minus(0, power);
		} 

		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0) throw new ArithmeticException("Division by zero");
		boolean negative = (x1 < 0) ^ (x2 < 0);
		if (x1 < 0) {
			x1 = minus(0, x1); } 
		if (x2 < 0) {
			x2 = minus(0, x2); } 
		int quot = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			quot++;
		}
		if (negative){
			quot = minus(0, quot);
		}
		return quot;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) throw new ArithmeticException("Division by zero");
		int div = div(x1, x2);
		int mult = times(x2, div);
		int mod = minus(x1, mult);
		return mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) throw new ArithmeticException("Square root of negative number");
		int result = 0;
		int i = 0;
		while (result <= x) {
			i++;
			result = times(i, i);
		}
		return minus(i, 1);
	}	  	  
}
// java Algebra.java 