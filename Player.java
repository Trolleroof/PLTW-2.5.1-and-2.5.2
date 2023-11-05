
import java.util.Scanner;

public class Player {

  /* your code here - attributes */

  /* added with 2.5.2 */
  private String name;
  private int points;

  /* your code here - constructor(s) */

  /* added with 2.5.2 */
  public Player() {
    points = 600; // adjusted based on new game mechanics per group implement

    System.out.println("Enter Player Name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();

    String username = name;
    System.out.println("\nHello " + username + "!!! \nWelcome to the game.\n");

    // add this later
    System.out.println("""
        How To Play:
         

                """);
  }

  /* added with 2.5.2 */
  public Player(String inputName) {
    points = 600; // adjusted based on new game mechanics per group implement

    name = inputName;
    System.out.println("Hello " + inputName + "; thanks for visiting our game.\n");
  }

  /* your code here - accessor(s) */

  /* added with 2.5.4 */
  public String getPlayerName() {
    return name;
  }

  /* added with 2.5.5 */
  public int getPoints() {
    return points;
  }

  /* your code here - mutator(s) */
}
