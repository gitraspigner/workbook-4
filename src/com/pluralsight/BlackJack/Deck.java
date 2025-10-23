package com.pluralsight.BlackJack;
import java.util.ArrayList;
import java.util.Collections;
/**
 * This class was not written by me, but was edited by me, and is from the
 * workbook of the week to represent a deck used in the BlackJack exercise/application.
 *
 * @author Ravi Spigner
 */
public class Deck {
    private ArrayList<Card> cards;
    public Deck(){
        cards = new ArrayList<>();
        String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
        String[] values = {"2","3","4","5","6","7","8",
                "9","10","J","Q","K","A"};
        // these loops create all the cards in the deck
        // and add them to the ArrayList
        for(String suit: suits){
            for(String value: values){
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card deal(){
        // deal the top card (if there are any cards left
        if(!cards.isEmpty()){
            return cards.remove(0);
        } else {
            return null;
        }
    }
    public int getSize(){
        return cards.size();
    }
}
