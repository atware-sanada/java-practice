import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

//    @Test
//    @DisplayName("デッキが空になっていないかどうか")
//    void isEmptyCardDeck() {
//        Card card = new Card();
//        assertThrows(IndexOutOfBoundsException.class, () -> );
//
//    }

    /**
     * Card型という独自型の標準出力を期待値でどう表現したらいいかわからない
     */
    @Test
    @DisplayName("インスタンス生成後、cardDeckから任意の値が格納されているかどうか")
    void getCardTest() {
        Card card = new Card();
        // 期待値
        String expected = "[ハート,1]";
        // 実測値
        Card result = card.getCardDeck().get(1);
        // 比較
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("インスタンス生成後、呼び出されたmarkがフィールドにセットされているかどうか")
    void setMarkOfCardTest() {
        Card card = new Card("ハート", 1);
        // 比較
        assertTrue(card.getMark().equals("ハート"));
    }

    @Test
    @DisplayName("インスタンス生成後、呼び出されたnumberがフィールドにセットされているかどうか")
    void setNumberOfCardTest() {
        Card card = new Card("ハート", 1);
        // 比較
        assertTrue(card.getNumber() == 1);
    }

    /**
     * 期待値に関して、ランダムな数字が入るため、どう表現したらいいかわからない
     */
    @Test
    @DisplayName("dealCardメソッドで任意のカード１枚(数字)を取得できているかどうか")
    void dealCardNumberTest() {
        Card card = new Card();
        // 期待値
        // int expected = ランダムな数字が入るため、どう表現したらいいかわからない
        // 実測値
        int result = card.dealCard().getNumber();
        // 比較
//        assertEquals(expected, result);
    }

    /**
     * 期待値に関して、ランダムなマークが入るため、どう表現したらいいかわからない
     */
    @Test
    @DisplayName("dealCardメソッドで任意のカード１枚(マーク)を取得できているかどうか")
    void dealCardMarkTest() {
        Card card = new Card();
        // 期待値
        // String expected = ランダムなマークが入るため、どう表現したらいいかわからない
        // 実測値
        String result = card.dealCard().getMark();
        // 比較
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

    /**
     * 実測値が51にならない（52のまま）
     */
    @Test
    @DisplayName("任意のカードを1枚ピックアップしたらデッキから１枚減っているかどうか")
    void deleteCardTest() {
        Card card = new Card();
        // 期待値
        int expected = card.cardDeckSize() - 1;
        // 実測値
        card.deleteCard(card);
        int result = card.cardDeckSize();
        // 比較
        assertEquals(expected, result);
    }
}


/*
オブジェクトID →　実行されるたびに値が変わる
自分でequqlsメソッドを作る（コントロール＋エンター）
:site
*/