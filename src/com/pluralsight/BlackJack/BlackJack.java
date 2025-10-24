package com.pluralsight.BlackJack;
import java.util.Scanner;
/**
 * Simulates a game of Blackjack between 2 players.
 *
 * @author Ravi Spigner
 */
public class BlackJack {
    private static final Scanner scanner = new Scanner(System.in);
    private static String player1;
    private static String player2;
    private static Hand player1Hand;
    private static Hand player2Hand;
    private static final Deck deck = new Deck();
    public static void main(String[] args) {
        playGame();
    }
    public static void displayWelcome() {
        System.out.println("----Welcome to BlackJack----");
    }
    public static void playGame() {
        displayWelcome();
        getPlayerNames();
        boolean isGameOver = false;

        while (!isGameOver) {
            shuffleAndDeal();
            results();
            isGameOver = isGameOver();
        }
        displayGameOver();
    }
    public static void shuffleAndDeal() {
        System.out.println("----Shuffling Deck...----");
        deck.shuffle();
        System.out.println("----Dealing Cards To Players Hands...----");
        player1Hand = new Hand();
        player1Hand.Deal(deck.deal());
        player1Hand.Deal(deck.deal());
        player2Hand = new Hand();
        player2Hand.Deal(deck.deal());
        player2Hand.Deal(deck.deal());
        System.out.println("----Cards Have Been Dealt!----");
    }
    public static void results() {
        System.out.println("----Results:----");
        player1Hand.flipAllCards();
        System.out.println("--" + player1 +"'s Hand--");
        player1Hand.display();
        player2Hand.flipAllCards();
        System.out.println("--" + player2 +"'s Hand--");
        player2Hand.display();
        int player1Points = player1Hand.getValue();
        System.out.println("-" + player1 +"'s Point total: " + player1Points);
        int player2Points = player2Hand.getValue();
        System.out.println("-" + player2 +"'s Point total: " + player2Points);
        if (player1Points > player2Points && player1Points <= 21) {
            System.out.println("****" + player1 + " Wins, By " + (player1Points-player2Points) +
                    " Points!****");
        } else if (player2Points > player1Points  && player2Points <= 21) {
            System.out.println("****" + player2 + " Wins, By " + (player2Points-player1Points) +
                    " Points!****");
        } else if (player1Points > 21) {
            System.out.println("****" + player2 + " Wins, By " + (player2Points-player1Points) +
                    " Points!****");
        } else if (player2Points > 21) {
            System.out.println("****" + player1 + " Wins, By " + (player1Points-player2Points) +
                    " Points!****");
        } else {
            System.out.println("****It's A Tie!****");
        }
    }
    public static void displayGameOver() {
        System.out.println("----Game Over! Thanks for Playing!----");
    }
    public static boolean isGameOver() {
        System.out.println("----Play Another Game?----");
        while (true) {
            System.out.print("Please enter your choice (1-Yes, 2-No): ");
            try {
                String choice = scanner.nextLine().trim();
                if (!isNumber(choice)) {
                    System.out.println("-------------------");
                    System.out.println("ERROR: " + choice + " is not a number");
                    System.out.println("-------------------");
                } else {
                    int choiceInt = Integer.parseInt(choice);
                    if (choiceInt == 1) {
                        return false;
                    } else if (choiceInt == 2) {
                        return true;
                    } else {
                        System.out.println("You entered an invalid number, only 1 and 2 are valid" +
                                " numbers.");
                    }
                }
            } catch (Exception e) {
                System.out.println("You entered an invalid number, only 1 and 2 are valid" +
                        " numbers.");
            }

        }
    }
    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input); //will return true for doubles/decimals and ints
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void getPlayerNames() {
        System.out.print("Please enter Player 1's name: ");
        player1 = scanner.nextLine();
        System.out.print("Please enter Player 2's name: ");
        player2 = scanner.nextLine();
    }
}
