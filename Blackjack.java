//Test code in 16.2 on zybooks
import java.sql.SQLOutput;
//you should have a nested while loop, one for the program and one for the game
import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        P1Random rand = new P1Random();
        boolean gameOn = true;
//initializing variables outside of game loop
        int gameNum = 0;
        int gameswon = 0;
        int gameslost = 0;
        int ties = 0;
        int hand = 0;

        while (gameOn == true) {
            gameNum++;
            System.out.println("START GAME #" + gameNum);
            System.out.println();
            int cV = 0;
            int dealerhand = 0;
            hand = rand.nextInt(13) + 1;
            if (hand == 13) {
                System.out.println("Your card is a KING!");
                hand = 10;
            } else if (hand == 12) {
                System.out.println("Your card is a QUEEN!");
                hand = 10;
            } else if (hand == 11) {
                System.out.println("Your card is a JACK!");
                hand = 10;
            } else if (hand == 1) {
                System.out.println("Your card is a ACE!");
            } else {
                System.out.println("Your card is a " + hand + "!");
            }
            System.out.println("Your hand is: " + hand);
            System.out.println();
            boolean playGame = true;
            while ((playGame = true)) {

                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println();
                System.out.println("Choose an option: ");
                int menu_choice = scanner.nextInt();
                if (menu_choice == 1) {
                    cV = rand.nextInt(13) + 1;
                    if (cV == 13) {
                        System.out.println("Your card is a KING!");
                        cV = 10;
                    } else if (cV == 12) {
                        System.out.println("Your card is a QUEEN!");
                        cV = 10;
                    } else if (cV == 11) {
                        System.out.println("Your card is a JACK!");
                        cV = 10;
                    } else if (cV == 1) {
                        System.out.println("Your card is a ACE!");
                        cV = 1;
                    } else {
                        System.out.println("Your card is a " + cV + "!");
                    }
                    hand += cV;
                    System.out.println("Your hand is: " + hand);
                    System.out.println();


                if (hand > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    gameslost++;
                    System.out.println();

                    break;
                }
                if (hand == 21) {
                    System.out.println("BLACKJACK! You win!");
                    gameswon++;
                    System.out.println();

                    break;
                }
            }

                else if (menu_choice == 2) {
                    dealerhand = rand.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerhand);
                    System.out.println("Your hand is: " + hand);
                    System.out.println();
                    if ((hand < dealerhand) && (dealerhand <= 21)) {
                        System.out.println("Dealer wins!");
                        gameslost++;

                        System.out.println();
                    }
                    if ((hand > dealerhand) || (dealerhand > 21)) {
                        System.out.println("You win!");
                        gameswon++;

                        System.out.println();
                    }
                    if (hand == dealerhand) {
                        System.out.println("It's a tie! No one wins!");
                        ties++;

                        System.out.println();
                    }
                    playGame = false;
                    break;
                }
                else if (menu_choice == 3) {
                    double gameNumforstats = gameswon + gameslost + ties;
                    double deci = (gameswon / gameNumforstats);
                    double percent = deci * 100;
                    int e = (int)gameNumforstats;
                    System.out.println("Number of Player wins: " + gameswon);
                    System.out.println("Number of Dealer wins: " + gameslost);
                    System.out.println("Number of tie games: " + ties);
                    System.out.println("Total # of games played is: " + e);
                    System.out.print("Percentage of Player wins: ");
                    System.out.printf("%.1f",percent);
                    System.out.println("%");
                    System.out.println();
                } else if (menu_choice == 4) {
                    gameOn = false;
                    break;
                } else {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                }
            }
        }


    }
}
