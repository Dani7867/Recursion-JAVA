package easy;

public class Nto1 {

	public static void main(String[] args) {
		func(11);
	}
	
	static void func(int n) {
		if(n<1) return;
		System.out.println(n);
		func(n-1);
	}

}
