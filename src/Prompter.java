import java.util.Scanner;
public class Prompter {
  private Game game;
  
  Scanner scanner = new Scanner(System.in);

  public Prompter(Game game){
  this.game = game;
  }
public boolean promptForName(){
	boolean isName = false;
	boolean trueName = false;
	do{
	System.out.println("What is your name?");
	System.out.print("Name :");
	  String nameInput = scanner.nextLine();
	  try{
	  isName = game.applyGuess(nameInput);
	  trueName = true;
	  }catch (IllegalArgumentException iae){
		  System.out.printf("%s, Please try again.%n",
				            iae.getMessage());
	  }
	  } while(!trueName);
	 System.out.printf("Welcome to the game . I hope you enjoy it :) %n%n");
	 
	 return isName;
	}
	  
	

  public boolean promptForGuess(){
  
  boolean isHit = false;
  boolean isAcceptable = false;

    do{
    	
      System.out.print("Enter a letter :  ");
      String guessInput = scanner.nextLine();
   
      
      try{
        isHit = game.applyGuess(guessInput);
        isAcceptable = true;
      } catch (IllegalArgumentException iae){
       System.out.printf("%s.  Please try again. %n",
                          iae.getMessage());
      }
    } while(! isAcceptable);
    return isHit;
  }
 
  
  public void displayProgress() {
  System.out.printf(" you have %d tries to solve:  %s%n" 
		  ,game.getRemainingTries() ,
                    game.getCurrentProgress());
  }
  public void displayOutcome(){
  if(game.isWon()){
   System.out.printf(" Congratulation , you won with %s tries remaining .%n" , 
		   game.getRemainingTries());
  } else {
   System.out.printf(" Bummer the word was %s.  :( %n ",
                     game.getAnswer()); 
  }
   
  }
}
