import java.util.Scanner;
public class Prompter {
  private Game game;
  
  Scanner scanner = new Scanner(System.in);

  public Prompter(Game game){
  this.game = game;
  }
public void promptForName(){
	  System.out.println("What is your name?");
	  String nameInput = scanner.nextLine();
	 System.out.printf("welcome to the Hangman Game %s %n%n",nameInput);
	
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
