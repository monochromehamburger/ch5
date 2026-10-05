import java.util.Scanner;
import java.lang.Math;
class Fermat{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("gimme a");
		int a=sc.nextInt();
		System.out.println("gimme b");
		int b=sc.nextInt();
		System.out.println("gimme c");
		int c=sc.nextInt();
		System.out.println("gimme n");
		int n=sc.nextInt();
		if(n>2 && Math.pow(a,n)+Math.pow(b,n)==Math.pow(c,n)){
			System.out.println("Correct!!!!!");
		}
		else{
			System.out.println("WRONG");
		}
		
	}
}
