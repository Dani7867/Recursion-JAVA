package easy;

public class SumofDigit {

	public static void main(String[] args) {
		int r = sum(1342);
		System.out.println(r);

	}
	
	static int sum(int n) {
		
		if(n==0) return 0;
		
		return (n%10) + sum(n/10);
		
	
	}

}
