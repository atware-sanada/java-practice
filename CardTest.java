import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
//    @Test
//    void dealCardTest() {
//        Card card = new Card();
//        // 期待値
//        boolean expected = true;
//        // 実測値
//        boolean result = card.equals(card.dealCard());
//        // 比較
//        assertEquals(expected, result);
//    }

    @Test
    @DisplayName("デッキが空になっていないかどうか")
    void isEmptyCardDeck() {
        Card card = new Card();
        card.cardDeckSize();

    }


    @Test
    @DisplayName("dealCardメソッドで任意のカード１枚(数字)を取得できているかどうか")
    void dealCardNumberTest() {
        Card card = new Card();
        // 期待値
        // int expected = ランダムな数字が入るため、どう表現したらいいかわからない
        // 実測値
        int result = card.dealCard().getNumber();
//        assertEquals(expected, result);
    }

    @Test
    @DisplayName("dealCardメソッドで任意のカード１枚(マーク)を取得できているかどうか")
    void dealCardMarkTest() {
        Card card = new Card();
        // 期待値
        // String expected = ランダムなマークが入るため、どう表現したらいいかわからない
        // 実測値
        String result = card.dealCard().getMark();
//        assertEquals(expected, result);
    }

    @Test
    @DisplayName("デッキに入っているカードが52枚あるかどうか（初期）")
    void cardDeckSizeShouldBe52() {
        Card card = new Card();
        // 期待値
        int expected = 52;
        // 実測値
        int result = card.cardDeckSize();
        // 比較
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("任意のカードを1枚ピックアップしたらデッキから１枚減っているかどうか")
    void deleteCardTest() {

    }
}


/*
decksize should be 52（デッキに入っているカードが５２枚あるかどうか）
オブジェクトID →　実行されるたびに値が変わる

独自クラス型で期待値を代入する際は（getMark,getNumber)
自分でequqlsメソッドを作る（コントロール＋エンター）
:site
*/