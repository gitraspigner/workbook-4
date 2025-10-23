package com.pluralsight.BlackJack;
import java.util.ArrayList;
/**
 * This class was not written by me, but was edited by me, and is from the
 * workbook of the week to represent a hand used in the BlackJack exercise/application.
 *
 * @author Ravi Spigner
 */
public class Hand {
    private ArrayList<Card> cards;
    public Hand(){
        cards = new ArrayList<>();
    }
    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void Deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    //I modified this method @author Ravi Spigner
    public int getValue(){
        int value = 0;
        for(Card card: cards){
            if (card.isFaceUp()) {
                value += card.getPointValue();
            } else {
                card.flip(); // turn the card over to see the value
                value += card.getPointValue();
                card.flip(); // hide the card again
            }
        }
        return value;
    }
    //I wrote this method @author Ravi Spigner
    public void display() {
        for (Card c : cards) {
            if(c.isFaceUp()) {
                System.out.println("Card Suit: " + c.getSuit() + " Card Value: " + c.getValue());
            } else {
                c.flip();
                System.out.println("Card Suit: " + c.getSuit() + " Card Value: " + c.getValue());
                c.flip();
            }
        }
    }
    //I wrote this method @author Ravi Spigner
    public void flipAllCards() {
        for(Card c : cards) {
            if(!c.isFaceUp()) {
                c.flip();
            }
        }
    }
}
