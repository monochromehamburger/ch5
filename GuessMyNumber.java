import java.util.Scanner;
import java.lang.Math;
class GuessMyNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("gimme a number from 0 to 100");
		int num1=sc.nextInt();
		int number=(int)(Math.random()*101.0);
		if(num1==number){
			System.out.println("You win");
		}
		else{
			if(num1>number){
				System.out.println("Too high");
			}
			else{
				System.out.println("Too low");
			}
		System.out.println("gimme a number from 0 to 100");
			num1=sc.nextInt();
			if(num1==number){
				System.out.println("You win");
			}
			else{
				if(num1>number){
					System.out.println("Too high");
				}
				else{
					System.out.println("Too low");
				}
		System.out.println("gimme a number from 0 to 100");
				num1=sc.nextInt();
				if(num1==number){
					System.out.println("You win");
				}
				else{
					if(num1>number){
						System.out.println("Too high");
					}
					else{
						System.out.println("Too low");
					}
					System.out.println("The real number is "+number+". u lose >:(");
				}
			}
		}
	}
}
