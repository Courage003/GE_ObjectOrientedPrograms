import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class DeckOfCards {

    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int NUM_CARDS = 9; // Cards per player

    // Main method
    public static void main(String[] args) {
        // Create a deck of cards
        String[] deck = new String[52];
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Shuffle the deck
        shuffleDeck(deck);

        // Create a queue for players
        PlayerQueue players = new PlayerQueue();
        for (int i = 1; i <= 4; i++) {
            players.enqueue(new Player("Player " + i));
        }

        // Distribute cards to players
        for (int i = 0; i < NUM_CARDS; i++) {
            for (int j = 0; j < 4; j++) {
                Player player = players.dequeue();
                player.addCard(deck[i * 4 + j]);
                players.enqueue(player);
            }
        }

        // Sort cards for each player and print
        System.out.println("Player and their sorted cards:");
        while (!players.isEmpty()) {
            Player player = players.dequeue();
            player.sortCardsByRank();
            System.out.println(player);
        }
    }

    // Shuffle the deck using Fisher-Yates shuffle
    private static void shuffleDeck(String[] deck) {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
}

// Custom Queue implementation
class PlayerQueue {
    private static class Node {
        Player data;
        Node next;

        Node(Player data) {
            this.data = data;
        }
    }

    private Node front, rear;

    public void enqueue(Player player) {
        Node newNode = new Node(player);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Player dequeue() {
        if (front == null) {
            return null;
        }
        Player player = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return player;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

// Player class
class Player {
    private final String name;
    private final String[] cards;
    private int cardCount;

    public Player(String name) {
        this.name = name;
        this.cards = new String[9];
        this.cardCount = 0;
    }

    public void addCard(String card) {
        if (cardCount < cards.length) {
            cards[cardCount++] = card;
        }
    }

    public void sortCardsByRank() {
        for (int i = 0; i < cardCount - 1; i++) {
            for (int j = 0; j < cardCount - i - 1; j++) {
                if (compareRanks(cards[j], cards[j + 1]) > 0) {
                    String temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }

    private int compareRanks(String card1, String card2) {
        String rank1 = card1.split(" ")[0];
        String rank2 = card2.split(" ")[0];
        int rankIndex1 = getRankIndex(rank1);
        int rankIndex2 = getRankIndex(rank2);
        return rankIndex1 - rankIndex2;
    }

    private int getRankIndex(String rank) {
        for (int i = 0; i < DeckOfCards.RANKS.length; i++) {
            if (DeckOfCards.RANKS[i].equals(rank)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + "'s cards:\n");
        for (int i = 0; i < cardCount; i++) {
            result.append(cards[i]).append("\n");
        }
        return result.toString();
    }
}
