
import java.util.Scanner;
import java.io.File;

public class Board {

  /* added with 2.5.2 */
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue;

  /* your code here - constructor(s) */

  /* added with 2.5.2 */
  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    this.setLetterValue();

  }

  /* your code here - accessor(s) */

  /* added with 2.5.4 */
  public int getCurrentLetterValue() {
    setLetterValue();
    return currentLetterValue;
  }

  public String getUnsolvedPhrase() {
    return solvedPhrase;
  }

  public String getPhrase() {
    return phrase;
  }

  /* your code here - mutator(s) */

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue() {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess) {
    if (phrase.equals(guess)) {
      return true;
    }
    return false;
  }

  private String loadPhrase() {
    String tempPhrase = "";

    int numOfLines = 0;
    try {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine()) {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine()) {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt) {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    for (int i = 0; i < tempPhrase.length(); i++) {
      if (tempPhrase.substring(i, i + 1).equals(" ")) {
        solvedPhrase += "  ";
      } else {
        solvedPhrase += "_ ";
      }
    }

    return tempPhrase;
  }

  /* added with 2.5.3 */
  /*
   * Allows player to guess a letter
   *
   * Precondition:
   * Player must have a guess that is a 1 character string
   *
   * Postcondition:
   * Code records the state of whether the player guessed a letter or not
   * Changes the hidden phrase to its updated state, changing _ to their
   * respective letters if that letter was guessed
   *
   */

  public boolean guessLetter(String guess) {
    // boolean variable to check if the letter was found
    boolean foundLetter = false;

    // string variable to save the new phrase after letters checked
    String newSolvedPhrase = "";

    // beginning of the loop that iterates through each of the letters in the phrase
    for (int i = 0; i < phrase.length(); i++) {
      // enters into the loop if the letter is in the guess
      if (phrase.substring(i, i + 1).equals(guess)) {
        // appends the letter(guess) and a space after " "
        newSolvedPhrase += guess + " ";
        // letter foundLetter is saved to true
        foundLetter = true;

        // if the guess does not exist in the phrase
      } else {
        // newSolvedPhrase will save to the value of the next character and append it to
        // the newSolvedPhrase
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
      }
    }

    // solvedPhrase is saved to newSolvedPhrase
    solvedPhrase = newSolvedPhrase;

    // returns if the letter was found or not
    return foundLetter;
  }

}
