package easy;

public class Reverse {
	public static void main(String[] args) {
		int  res = Rev(2114 , (int) Math.log10(2114));  // log10 number of digits - 1
		System.out.println(res);
		

		System.out.println(isPalindrome(2112));
		System.out.println(isPalindrome(2114));
	}
	
	static int Rev(int n , int digits) {
		if(n/10 == n) return n;
		
		return  (int) (n%10 * Math.pow(10,digits) + Rev(n/10 , digits - 1)) ;
	}
	
	static boolean isPalindrome(int n) {
		return n == Rev(n,(int) Math.log10(n));
	}
}
