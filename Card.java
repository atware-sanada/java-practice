import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<Integer> cardDeck = new ArrayList<>();

    Card() {
        int cardNum = 1;
        for(int i = 0; i < 13; i++) {
            cardDeck.add(i,cardNum);
            cardNum++;
        }
    }

    public Integer dealCard() {
        int randomNum = (int)(Math.random() * 13 + 1);
        return cardDeck.get(randomNum);
    }
}


