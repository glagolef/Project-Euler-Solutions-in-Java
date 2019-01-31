package Project_Euler_Solutions_in_Java._32_63._054;

import Project_Euler_Solutions_in_Java.Template;
import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * High PokerCard: Highest value card.
 * One Pair: Two cards of the same value.
 * Two Pairs: Two different pairs.
 * Three of a Kind: Three cards of the same value.
 * Straight: All cards are consecutive values.
 * Flush: All cards of the same suit.
 * Full House: Three of a kind and a pair.
 * Four of a Kind: Four cards of the same value.
 * Straight Flush: All cards are consecutive values of same suit.
 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 */
public class _054_PokerHands implements Template {
    private String path = Util.PATH + "\\src\\";
    private String filename = "p054_poker.txt";

    public static void main(String[] args) {
        Util.println(new _054_PokerHands().run());
    }

    public int run() {
        int winningCounter = 0;
        try {
            String tmp;
            BufferedReader br = new BufferedReader(new FileReader(path + filename));
            for (int i = 0; i < 1000; i++) {
                tmp = br.readLine();
                winningCounter += calculateWinner(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return winningCounter;
    }

    private int calculateWinner(String hands) {
        int counter = 0;

        PokerCard[] cards = new PokerCard[5];
        PokerHand home = null, away;
        String delim = " ";
        String[] inputs = hands.split(delim);
        for (String rawCard : inputs) {
            cards[counter] = new PokerCard(rawCard);
            counter++;
            if ((counter) % 5 == 0) {
                if (home == null) {
                    home = new PokerHand(cards.clone());
                } else {
                    away = new PokerHand(cards.clone());
//                    printHands(home, away);
                    if (home.compareTo(away) > 0) {
//                        Util.print(" : WINNER\n");
                        return 1;
                    } else {
//                        Util.print(" : NOT WINNER\n");
                        return 0;
                    }
                }
                counter = 0;
            }
        }
        return 0;
    }

    private void printHands(PokerHand home, PokerHand away) {
        Util.print("home: " + home.toString() + "; best_hand:" + home.getBestHand()
                + "; away: " + away.toString() + "; best_hand:" + away.getBestHand());
    }

    enum suit {
        hearts, spades, clubs, diamonds
    }
}

