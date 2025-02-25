package easy;



/*Given an integer num, return the number of steps to reduce it to zero.
In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.*/

public class NumSteps {
	
	public static void main(String[] args) {
		System.out.println(numberOfSteps(123));
	}
	
	
	public static int numberOfSteps(int num) {
        return steps(num , 0);
    }

    static int steps(int num , int step){
        if(num == 0) return step;

        if(num % 2 == 0) return steps(num/2 , step+1);
        else return steps(num - 1 , step+1);
    }
}
