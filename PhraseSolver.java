
import java.util.Scanner;

public class PhraseSolver {
  /* your code here - attributes */

  /* added with 2.5.2 */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;
  private int player1Points;
  private int player2Points;

  /* added with 2.5.5 */
  private int points;
  // private int letterGuessValue;

  /* your code here - constructor(s) */

  /* added with 2.5.2 */
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;

    /* added with 2.5.5 */
    points = player1.getPoints();
  }

  /* your code here - accessor(s) */

  /* your code here - mutator(s) */

  /* added with 2.5.5 */
  public void getPoints() {
    points += board.getCurrentLetterValue();
  }

  public void play() {
    boolean solved = false;
    int currentPlayer = 1;
    String lettersList = "abcdefghijklmnopqrstuvwxyz";

    Scanner input = new Scanner(System.in);

    /* added with 2.5.5 */
    // boolean to check if the phrase is solved
    boolean correct = board.getUnsolvedPhrase().contains("_");

    while (!solved) {

      /* your code here - game logic */

      /* added with 2.5.4 */

      // checks for which player is currently playing
      if (currentPlayer == 1) {
        // prints player and their name
        System.out.println("Player 1: " + player1.getPlayerName());
      }
      // if player 2 is active this will run
      else {
        // prints player and their name
        System.out.println("Player 2: " + player2.getPlayerName());
      }

      /* added with 2.5.5 */
      while (points >= 0 && correct) {
        System.out.println("\nYour Points: " + points);
        /* added with 2.5.4 */

        // phrase 'unsolved'
        System.out.println(board.getUnsolvedPhrase());

        // returns a new value for the points of the next guess
        int letterGuessValue = board.getCurrentLetterValue();

        // point value of the next letter guess
        System.out.println("Points for next guess: " + letterGuessValue + "\n");

        /* added with 2.5.5 */
        System.out.println("Enter Your Guess: ");

        // takes the user input for the guess
        String guess = input.nextLine();

        // checks if the phrase equals the phrase solved with
        if (board.isSolved(guess)) {
          // phrase is solved if the guess is equal to the phrase
          correct = board.getUnsolvedPhrase().contains("_");
          points += letterGuessValue;
        } else {
          correct = false;
        }

        // checks if the character contains any special characters
        while (",./\\?<>'\";:_-+=#@!$%^&*()1234567890`~[]{}|".contains(guess)) {
          System.out.println("Not a valid input\nEnter Your Guess:");
          guess = input.nextLine();
        }

        // checks whether a letter has already been entered
        while (!(lettersList.contains(guess))) {
          System.out.println("You already guessed that\nEnter Your Guess:");
          guess = input.nextLine();
        }

        lettersList = lettersList.replace(guess, "");

        // checks if the guessed letter is in the phrase
        if (board.guessLetter(guess)) {
          // gives the player points if the letter is in the phrase
          points += letterGuessValue;
        } else {
          points -= 200;
        }

        correct = board.getUnsolvedPhrase().contains("_");

        // System.out.println(correct); // testing
        // System.out.println(points >= 0); // testing
      }

      /* added with 2.5.5 */
      // checking if the first player's turn is over
      if (currentPlayer == 1) {
        // printing out the points for Player 1
        if (points < 0) {
          points = 0;
        }
        System.out.println(board.getUnsolvedPhrase());
        System.out.println("\nPlayer 1's Points: " + points);

        // transition
        System.out.println("___________________________________\n");

        // changing players
        currentPlayer = 2;

        // saving the value of points for player 1
        player1Points = points;

        // initalizing the new values of the board
        lettersList = "abcdefghijklmnopqrstuvwxyz";
        points = player2.getPoints();
        board = new Board();
        correct = board.getUnsolvedPhrase().contains("_");

        // if player 2's turn is over
      } else {

        // ending the while loop by turing solved to true
        solved = true;

        // saving the points to player 2 points
        player2Points = points;

        // game ended phrase
        System.out.println(board.getUnsolvedPhrase());
        System.out.println("Player 2's point count: " + points);

        System.out.println("Game_over");

        // if player 1 has more points
        if (player1Points > player2Points) {
          System.out.println(player1.getPlayerName() + " won the game");
          // if player 2 has more points
        } else if (player2Points > player1Points) {
          System.out.println(player2.getPlayerName() + " won the game");
          // if there is a tie
        } else {
          System.out.println(player1.getPlayerName() + " and " + player2.getPlayerName() + " had a tie!!!");
        }
      }
    }
  }
}
