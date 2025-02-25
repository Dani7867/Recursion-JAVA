package easy;

public class Sum {

	public static void main(String[] args) {
		int r = sum(0);
		System.out.println(r);

	}
	
	static int sum(int n) {
		
		if(n==0) return 0;
		if(n==1) return 1;
		
		return n + sum(n-1);
	}

}
