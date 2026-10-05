import java.util.Scanner;
import java.lang.Math;
class Quadratic{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("gimme a");
		int a=sc.nextInt();
		System.out.println("gimme b");
		int b=sc.nextInt();
		System.out.println("gimme c");
		int c=sc.nextInt();
		int discriminant=b*b-4*a*c;
		if(discriminant<0){
			System.out.println("No Solutions");
		}
		else if(discriminant==0){
			double solution1=(-b)/(2*(double)a);
			System.out.println("Only solution: "+solution1);
		}
		else{
			double solution1=(-b+Math.sqrt(discriminant))/(2*(double)a);
			double solution2=(-b-Math.sqrt(discriminant))/(2*(double)a);
			System.out.println("Solutions: "+solution1+", "+solution2);
			
		}
	}
}
