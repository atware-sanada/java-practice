import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Card {
    private String mark;
    private int number;
    private String name;
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
        declareName();
    }

    public void declareName() {
        if(number == 1) {
            name = "A";
        } else if (number == 11) {
            name = "J";
        } else if (number == 12) {
            name = "Q";
        } else if (number == 13) {
            name = "K";
        } else {
            name = String.valueOf(number);
        }
    }

    public String getMark() {
        return mark;
    }

    public int getNumber() {
        return number;
    }

    public int cardDeckSize() { //52枚あるかどうか確認
        return cardDeck.size();
    }

    public Card dealCard() {
        int randomNum = new Random().nextInt(cardDeck.size());
        return cardDeck.get(randomNum); // getメソッドの中身は配列のindexが入る
    }

    public void deleteCard(Card card) {
        cardDeck.remove(card);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Card card = (Card) o;
//        return number == card.number && Objects.equals(mark, card.mark);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(mark, number);
//    }
}
