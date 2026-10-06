import java.util.*;
import java.util.Collections;
class Card{
	public int value;
	public int suit;
	//1=heart, 2=diamond, 3=spade, 4=club
	public Card(int value, int suit){
		this.value=value;
		this.suit=suit;
	}
	public String getValue(){
		String output="";
		if(this.value==1){
			output+="A";
		}
		else if(this.value==11){
			output+="J";
		}
		else if(this.value==12){
			output+="Q";
		}
		else if(this.value==13){
			output+="K";
		}
		else{
			output+=this.value;
		}
		return output;
	}
	public String toString(){
		String output="";
		if(this.value==1){
			output+="A";
		}
		else if(this.value==11){
			output+="J";
		}
		else if(this.value==12){
			output+="Q";
		}
		else if(this.value==13){
			output+="K";
		}
		else{
			output+=this.value;
		}
		if(this.suit==1){
			output+="\u001B[31m♥︎\u001B[0m";
		}
		else if(this.suit==2){
			output+="\u001B[31m♦\u001B[0m";
		}
		else if(this.suit==3){
			output+="♠";
		}
		else{
			output+="♣";
		}
		return output;
	}
}
class Gambling{
	public static int money=100;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		// System.out.println("Loading...");
		// try{
		// 	for(int i=0;i<20;i++){
		// 		System.out.print("—");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 		System.out.print("\\");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 		System.out.print("|");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 		System.out.print("/");
		// 		Thread.sleep(60);
		// 		System.out.print("\r\033[2k");
		// 		System.out.flush();
		// 	}
		// }
		// catch (Exception e) {
        //     System.out.println(e);
        // }
		System.out.println();
        while(true){
            System.out.println();
            System.out.println("Gambling. You have $"+money+". Pick an option:");
            System.out.println("1: Lootboxes");
            System.out.println("2: Blackjack");
            System.out.println("3: Guess the Number");
            int choice=0;
            while(true){
                String input=sc.nextLine();
                if(input.length()>0 && (input.charAt(0)=='1' || input.charAt(0)=='2' || input.charAt(0)=='3')){
                    choice=Integer.parseInt(input.substring(0,1));
                    break;
                }
                System.out.println("Pick a valid option");
            }
            switch(choice){
                case 1:
                    LootBoxes();
                    break;
                case 2:
                    Blackjack();
                    break;
                case 3:
                    GuessNumber();
                    break;
            }
        }
	}
	public static void Blackjack(){
		System.out.println("How much would you like to bet?");
		int choice=0;
		int bet=0;
		
		while(true){
			int input=sc.nextInt();
			if(input>=0){
				if(input>money){
					System.out.println("You are too broke.");
				}
				else{
					bet=input;
					break;
				}
			}
			System.out.println("Pick a valid number");
		}
        sc.nextLine();
        money-=bet;
        
        ArrayList<Card> cards = new ArrayList<>();

        for(int i=1;i<=13;i++){
			for(int j=1;j<=4;j++){
				cards.add(new Card(i,j));
			}
		}
		Collections.shuffle(cards);
		int index=0;
		int sum=0;
		long earnings=0;
		int numAces=0;
		ArrayList<Card> drawnCards=new ArrayList<>();
		while(true){
			if(cards.get(index).value==1){
				numAces++;
				sum+=11;
			}
			else{
				sum+=Math.min(10,cards.get(index).value);
			}
			if(sum>21 && numAces>0){
				sum-=10;
				numAces--;
			}
			drawnCards.add(cards.get(index));
			System.out.println("You have drawn a "+cards.get(index).getValue()+".");
			System.out.print("Your cards: ");
			for(int i=0;i<drawnCards.size();i++){
				System.out.print(drawnCards.get(i).getValue()+" ");
			}
			System.out.println();
			System.out.println("Your current sum: "+sum);
			if(sum>21){
				System.out.println("You have gone over 21! You lose :(");
				break;
			}
			else if(sum==21){
				System.out.println("Your score is exactly 21! You win $"+(bet*3)+"!");
				earnings=bet*3;
				break;
			}
			else{
				System.out.println("Do you want to draw another card? Y/N");
			}
			String input="";
			while(!input.toUpperCase().equals("Y") && !input.toUpperCase().equals("N")){
				input=sc.nextLine();
			}
			if(input.toUpperCase().equals("N")){
				break;
			}	
			index++;
		}
		if(sum<21){
			earnings=Math.round((double)bet*3/(Math.exp((double)(21-sum)/2)));
			System.out.println("Your final score: "+sum+". You earn $"+earnings+" back!");
		}
		money+=earnings;
		
		
		
	}
	public static void GuessNumber(){
		System.out.println("How much would you like to bet?");
		int choice=0;
		int bet=0;
		
		while(true){
			int input=sc.nextInt();
			if(input>=0){
				if(input>money){
					System.out.println("You are too broke.");
				}
				else{
					bet=input;
					break;
				}
			}
			System.out.println("Pick a valid number");
		}
        sc.nextLine();
        money-=bet;
		System.out.println("Guess my number from 0 to 100. Guesses closer to the actual number reward more payout. Guessing farther from 50 also increases payout.");
		
		while(true){
			int input=sc.nextInt();
			if(input>=0 && input<=100){
				choice=input;
				break;
			}
			System.out.println("Pick a valid number");
		}
        sc.nextLine();
        bet+=Math.round(bet*(Math.abs(choice-50)/40.0-0.35));
		Random random = new Random();
		int randomNum=random.nextInt(101);
		int difference=Math.abs(randomNum-choice);
        System.out.println("Your guess was: "+choice);
        try{
			for(int i=0;i<choice;i++){
				System.out.print("=");
				Thread.sleep(30);
			}
		}
		catch (Exception e) {
            System.out.println(e);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("The actual number was... ");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        try{
			for(int i=0;i<randomNum;i++){
				System.out.print("=");
				Thread.sleep(60);
			}
		}
		catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();




		System.out.println(randomNum+"! You were off by "+difference+".");
		double multiplier=Math.round(Math.pow(15.0, 1.0-difference/20.0)*100.0)/100.0;
        //System.out.println(bet+" "+multiplier);
        money+=Math.round(bet*multiplier);
		System.out.println("You earned $"+Math.round(bet*multiplier)+" Back. Always Gamble.");
	}
    public static void LootBoxes(){
        System.out.println();
        System.out.println("Choose a lootbox:");
        System.out.println("1: Money box: Small - 50");
        System.out.println("2: Money box: Medium - 200");
        System.out.println("3: Money box: Large - 500");
        System.out.println("4: Special Box - 250");
        System.out.println("5 - Back");
        int[] costs={50, 200, 500, 250};
        int choice=0;
        while(true){
            String input=sc.nextLine();
            if(input.length()>0 && (input.charAt(0)=='1' || input.charAt(0)=='2' || input.charAt(0)=='3' || input.charAt(0)=='4')){
                choice=Integer.parseInt(input.substring(0,1));
                if(costs[choice-1]>money){
                    System.out.println("Too Broke, try another");
                }
                else{
                    money-=costs[choice-1];
                    break;
                } 
            }
            else if(input.length()>0 && input.charAt(0)=='5'){
                return;
            }
            else System.out.println("Pick a valid option");
        }
        String[] smallBoxPayoutTexts={"\u001B[37m$0", "\u001B[37m$5", "\u001B[37m$10", "\u001B[37m$25", "\u001B[37m$50", "\u001B[37m$100", "\u001B[37m$200", "\u001B[33m$500"};
        String[] mediumBoxPayoutTexts={"\u001B[37m$0", "\u001B[37m$20", "\u001B[37m$50", "\u001B[37m$100", "\u001B[37m$200", "\u001B[37m$500", "\u001B[37m$750", "\u001B[33m$2000"};
        String[] bigBoxPayoutTexts={"\u001B[37m$0", "\u001B[37m$50", "\u001B[37m$100", "\u001B[37m$250", "\u001B[37m$500", "\u001B[37m$1000", "\u001B[33m$2500", "\u001B[33m$10000", "\u001B[33m$99999"};

        int[] smallBoxPayouts={0, 5, 10, 25, 50, 100, 200, 500};
        int[] mediumBoxPayouts={0, 20, 50, 100, 200, 500, 750, 2000};
        int[] bigBoxPayouts={0, 50, 100, 250, 500, 1000, 2500, 10000, 99999};
        double[] smallBoxProbabilities={0.2,0.15,0.15,0.15,0.15,0.11,0.06,0.03};
        double[] mediumBoxProbabilities={0.2,0.15,0.15,0.15,0.15,0.11,0.06,0.03};
        double[] bigBoxProbabilities={0.2, 0.15, 0.15, 0.15, 0.15, 0.13, 0.05, 0.029, 0.001};
        if(choice==1){
			Gamble(smallBoxPayoutTexts, smallBoxPayouts, smallBoxProbabilities);
		}
		else if(choice==2){
			Gamble(mediumBoxPayoutTexts, mediumBoxPayouts, mediumBoxProbabilities);
		}
		else if(choice==3){
			Gamble(bigBoxPayoutTexts, bigBoxPayouts, bigBoxProbabilities);
		}

    }
    static void Gamble(String[] payoutTexts, int[] payoutAmounts, double[] probabilities){
		Queue<Integer> payouts=new LinkedList<>();
        int spinTimer=(int)(Math.random()*80);
        System.out.println("v Your reward");
        payouts.add(0);
        String text="";
        while(text.length()<150){
            double randomNum=Math.random();
            int index=0;
            while(randomNum-probabilities[index]>0){
                randomNum-=probabilities[index];
                index++;
            }
            payouts.add(index);
            text+=" ";
            text+=payoutTexts[index];
            text+=" ";
        }
        try{
			for(int i=spinTimer;i<160;i++){
				Thread.sleep((int)Math.max(60, Math.pow(2, (i-75)/10)));
                if(i>150){
				    Thread.sleep((int)Math.max(60, Math.pow(2, (i-75)/10)));
                }
                if(i>155){
				    Thread.sleep((int)Math.max(60, Math.pow(2, (i-75)/10)));
                }
                text=text.substring(1,text.length());
                while(text.charAt(4)!='m'){
                    //console.log(text.charAt(2))
                    text=text.substring(1,text.length());
                }
                double randomNum=Math.random();
                int index=0;
                while(randomNum-probabilities[index]>0){
                    randomNum-=probabilities[index];
                    index++;
                }
                payouts.add(index);
                payouts.poll();
                text+=" ";
                text+=payoutTexts[index];
                text+=" ";
				System.out.print("\r\033[2k");
				System.out.flush();
                String tempText=text;
                while(tempText.length()<200){
                    tempText+=" ";
                }
				System.out.print(tempText);
			}
            Thread.sleep(2000);
		}
		catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("\u001B[37mYou received $"+payoutAmounts[payouts.peek()]+"!");
        money+=payoutAmounts[payouts.peek()];
	}
}
