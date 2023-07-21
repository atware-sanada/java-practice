/**
 * カードゲームのルールおよび進行を表すクラス
 */
public class CardGame {

    private static Player player = new Player();
    private static Player dealer = new Player();
    private static Card playerCard = new Card();
    private static Card dealerCard = new Card();
    private static final String EVEN = "引き分けです";
    private static final String PLAYER_WIN = "プレイヤーの勝ち";
    private static final String PLAYER_LOSE = "プレイヤーの負け";

    public static void main(String[] args){
        // ゲーム開始
        startGame();

        // 1枚目の数を見てヒットするかステイするか

        // 勝敗判定
//        judge();
    }

    public static void startGame() {
        // プレイヤーにカードを配る
        int cardOfPlayer = playerCard.dealCard();
        // 配られたカードをプレイヤーのデッキに加える
        player.getCardList().add(cardOfPlayer);
        // デッキに加えたカードを合算する
        player.calcCardList();
        // 手札の確認
        System.out.printf("あなたの現時点での手札の合計は%dです%n", player.getCalcCard());
        // ディーラーがカードを引く
        int cardOfDealer = dealerCard.dealCard();
        // 配られたカードをプレイヤーのデッキに加える
        dealer.getCardList().add(cardOfDealer);
        // デッキに加えたカードを合算する
        dealer.calcCardList();
        // 手札の確認
        System.out.printf("ディーラーの現時点での手札の合計は%dです%n", dealer.getCalcCard());
    }
}