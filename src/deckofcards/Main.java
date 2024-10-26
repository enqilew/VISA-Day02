package deckofcards;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = deck.get(0);

        System.out.printf("suit: %s, name: %s, value: %d\n", 
            card.getSuit(), card.getName(), card.getValue());
        
        System.out.println(card);
        System.out.println(deck);

        // Loop through all the cards in the deck
        for (int i = 0; i < deck.cards.length; i++) {
            Card cards = deck.get(i);
            System.out.println(cards);
        }

    }
}
