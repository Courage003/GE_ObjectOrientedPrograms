import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DeckOfCards {

    //Arrays to store suits and ranks
    private static final String[] SUITS= {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS= {"2", "3", "4", "5", "6", "7", "8",
            "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args){
        //List to store all the cards
        List<String> deck= new ArrayList<>();

        //Populate the deck with all combinations of suits and ranks
        for(String suit: SUITS){
            for(String rank: RANKS){
                deck.add(rank + " of " + suit);
            }
        }

        //Shuffle the deck using Collections.shuffle()
        Collections.shuffle(deck);

        //2d array to store cards for 4 players (9 cards each)
        String[][] playerCards = new String[4][9];

        //Distribute 9 cards to each of the 4 players
        for(int player=0;player<4;player++){
            for(int card=0;card<9;card++){
                playerCards[player][card]=deck.remove(0); //Take a card from the shuffle deck

            }
        }

        //Print the cards received by each player
        for(int player=0;player<4;player++){
            System.out.println("\nPlayer "+ (player+1)+ "'s cards:");
            for(int card=0;card<9;card++){
                System.out.println(playerCards[player][card]);

            }
        }

    }
}
