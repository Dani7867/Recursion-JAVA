package easy;

public class CountZeros {
	public static void main(String[] args) {
		int res = zeros(10010101, 0);
		System.out.println(res);
	}
	
	
	static int zeros(int n, int c) {
		
		if(n == 0) return c;
		
		if(n%10 == 0) {
			return zeros(n/10,c+1);
		}else {
			return zeros(n/10,c);
		}
		
		
	}
}
