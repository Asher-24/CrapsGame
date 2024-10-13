import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        boolean done = false;

        int die1;
        int die2;
        int crapsRoll;
        int sum = 0;
        String playAgainYN = "";
        String nextRound = "";
        String playGame = "";
        int roll2;

        System.out.println("Hi! Welcome to Craps\nThe rules of the game are easy to understand: ");
        System.out.println("Rule 1. Roll two dice");
        System.out.println("Rule 2. If the sum of the two dice is 2, 3, or 12, then you got craps and whoops, you lose!");
        System.out.println("Rule 3. If the sum is 7 or 11 then it is a Natural, Meaning that you win!");
        System.out.println("Rule 4. For any other sum, it becomes 'the point' and you just keep rolling until you get a 7 and lose or make the point and win!\n");
        System.out.println("Now that you understand the rules, Let's play!");

        while (!done) {
            System.out.print("Type Enter to roll or press Backspace to stop: ");
            playGame = in.nextLine();
            if (playGame.equalsIgnoreCase("Backspace")) {
                done = true;
                System.out.println("Thank you for playing!");
            } else if (playGame.equalsIgnoreCase("Enter")) {
                die1 = gen.nextInt(6) + 1;
                die2 = gen.nextInt(6) + 1;
                crapsRoll = die1 + die2;
                if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.printf("\nOops, You rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    System.out.println("Craps! You lost, better luck next time!");
                } else if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.printf("\nYou did it! You rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    System.out.println("Natural! Wow maybe you're a natural at this game, You win!");
                    done = true;
                } else {//if (crapsRoll ==4 || crapsRoll == 5 || crapsRoll == 6 || crapsRoll == 8 || crapsRoll == 10)
                    System.out.printf("\nYou rolled: %d and %d to get %d\n", die1, die2, crapsRoll);
                    System.out.printf("Your point is: %d\n", crapsRoll);
                    boolean playAgain = true;

                    while (playAgain) {
                        System.out.print("\nType Enter to roll again to match point or Backspace to quit game: ");
                        nextRound = in.nextLine();
                        if (nextRound.equalsIgnoreCase("Enter")) {
                            die1 = gen.nextInt(6) + 1;
                            die2 = gen.nextInt(6) + 1;
                            roll2 = die1 + die2;

                            if (roll2 == crapsRoll) {
                                System.out.printf("\nWow! Lucky, you rolled: %d and %d to make %d\n", die1, die2, roll2);
                                System.out.println("You did it! You made the point, You win!");
                                playAgain = false;
                            } else if (roll2 == 7) {
                                System.out.printf("\nWoah, very unlucky. You rolled: %d and %d to make %d\n", die1, die2, roll2);
                                System.out.println("You rolled a 7, sadly, You lose.");
                                playAgain = false;
                            } else {
                                System.out.printf("\nHmm, seems like you rolled: %d and %d to make %d\n", die1, die2, roll2);
                                System.out.printf("Keep trying so you can maybe get %d\n", crapsRoll);
                            }
                        } else if (nextRound.equalsIgnoreCase("Backspace")) {
                            playAgain = false;
                            System.out.println("Thank you for playing! Feel free to test your luck again sometime!");
                        } else {
                            System.out.println("Invalid input: " + nextRound + "\nYou need to Type [Enter/Backspace]");
                        }
                    }

                }
                do {
                    System.out.println("\nDo you want to play again? [Y/N]: ");
                    playAgainYN = in.nextLine();
                    if (playAgainYN.equalsIgnoreCase("Y")) {
                        done = false;
                    } else if (playAgainYN.equalsIgnoreCase("N")) {
                        done = true;
                    } else {
                        System.out.println("\nInvalid Input: " + playAgainYN + "\nYou need to select [Y/N]: ");
                    }
                } while (!playAgainYN.equalsIgnoreCase("Y") && !playAgainYN.equalsIgnoreCase("N"));
            } else {
                System.out.println("\nInvalid input " + playGame + "\nYou need to select [Enter/Backspace]\n");
            }
        }
    }
}
