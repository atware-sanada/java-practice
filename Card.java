import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    private String mark;
    private int number;
    private List<Card> cardDeck = new ArrayList<Card>();

    Card(String mark, int number) {
        this.mark = mark;
        this.number = number;
    }

    Card() {
        String[] markList = {"ハート", "ダイヤ", "スペード", "クラブ"};
        for(String mark : markList) {
            for(int i = 1; i <= 13; i++) {
                cardDeck.add(new Card(mark,i));
            }
        }
    }

    public int getNumber() {
        return this.number;
    }

    public Card dealCard() {
        int randomNum = new Random().nextInt(cardDeck.size());
        return cardDeck.get(randomNum); // getメソッドの中身は配列のindexが入る
    }

    public void deleteCard(Card card) {
        cardDeck.remove(card);
    }

}
