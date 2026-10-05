import java.util.Scanner;
import java.lang.Math;
class Triangle{
	public static void main(String[] args){
		System.out.println(false && false || true);
		Scanner sc = new Scanner(System.in);
		System.out.println("gimme a");
		int a=sc.nextInt();
		System.out.println("gimme b");
		int b=sc.nextInt();
		System.out.println("gimme c");
		int c=sc.nextInt();
		
		if(a<=0 || b<=0 || c<=0){
			System.out.println("ERROR");
		}
		else{
			if(a+b>c && b+c>a && a+c>b){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
			
			
	}
}
