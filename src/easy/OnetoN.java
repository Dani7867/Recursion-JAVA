package easy;

public class OnetoN {

	public static void main(String[] args) {
		func(11);

	}
	
	static void func(int n) {
		if(n<1) return;
		func(n-1);
		System.out.println(n);
	}

}
