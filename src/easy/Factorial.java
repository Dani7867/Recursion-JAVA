package easy;

public class Factorial {

	public static void main(String[] args) {
		int r = fact(5);
		System.out.println(r);

	}
	
	static int fact(int n) {
		
		if(n < 2) return 1;
		
		return n * fact(n-1);
	}

}
