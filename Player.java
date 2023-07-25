import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private Card card = new Card();
    /* 合計の計算結果 */
    private int calcCardOfPlayer; // フィールドで初期化してしまうと、もう一度calcCardOfPlayerを用いるメソッドが呼び出された場合、初期化されずに元々入っていた値にプラスされてしまう
    /* 合計の計算結果 */
    private int calcCardOfDealer;
    /* 引いたプレイヤーのカードのリスト */
    private List<Card> cardListOfPlayer = new ArrayList<Card>();
    /* 引いたディーラーのカードのリスト */
    private List<Card> cardListOfDealer = new ArrayList<Card>();
    /* ヒットした状態 */
    private boolean isHit = true;

    public List<Card> getCardListOfPlayer() {
        return cardListOfPlayer;
    }

    public List<Card> getCardListOfDealer() {
        return cardListOfDealer;
    }

    public void startGame() {
        distributeToPlayer();
        distributeToDealer();
    }

    // ヒットするならH、ステイするならSを入力する
    public void hitOrStay() {
        System.out.println("HITしますか、それともSTAYしますか（HIT：H、STAY：S）");
        Scanner scan = new Scanner(System.in);
        String selection = scan.next();
        if(selection.equals("H") || selection.equals("h")) {
            distributeToPlayer();
            this.isHit = true;
        } else if (selection.equals("S") || selection.equals("s")) {
            this.isHit = false;
        } else {
            System.out.println("不適切な数字です");
        }
    }

    // 引いたプレイヤーのカードのリストを全て合算する
    public void calcCardListOfPlayer() {
        this.calcCardOfPlayer = 0;
        for(Card card : cardListOfPlayer){
            calcCardOfPlayer += card.getNumber();
            setCalcCardOfPlayer(calcCardOfPlayer);
        }
    }

    // 引いたディーラーのカードのリストを全て合算する
    public void calcCardListOfDealer() {
        this.calcCardOfDealer = 0;
        for(Card card : cardListOfDealer){
            calcCardOfDealer += card.getNumber();
            setCalcCardOfDealer(calcCardOfDealer);
        }
    }

    public int getCalcCardOfPlayer() {
        return calcCardOfPlayer;
    }

    public int getCalcCardOfDealer() {
        return calcCardOfDealer;
    }

    public void setCalcCardOfPlayer(int calcCardOfPlayer) {
        this.calcCardOfPlayer = calcCardOfPlayer;
    }

    public void setCalcCardOfDealer(int calcCardOfDealer) {
        this.calcCardOfDealer = calcCardOfDealer;
    }

    public boolean getHit() {
        return isHit;
    }

    public void distributeToPlayer() {
        // プレイヤーにカードを配る
        Card cardOfPlayer = card.dealCard();
        // 配られたカードをプレイヤーのデッキに加える
        getCardListOfPlayer().add(cardOfPlayer);
        // プレイヤーに配られたカードをカードデッキから減らす
        card.deleteCard(cardOfPlayer);
        // デッキに加えたカードを合算する
        calcCardListOfPlayer();
        // 手札の確認
        System.out.printf("あなたの現時点での手札の合計は%dです%n", calcCardOfPlayer);
    }

    public void distributeToDealer() {
        // ディーラーがカードを引く
        Card cardOfDealer = card.dealCard();
        // 引いたカードをディーラーのデッキに加える
        getCardListOfDealer().add(cardOfDealer);
        // ディーラーが引いたカードをカードデッキから減らす
        card.deleteCard(cardOfDealer);
        // デッキに加えたカードを合算する
        calcCardListOfDealer();
    }

    public void showCalcCardOfPlayer() {
        System.out.printf("あなたの最終的な手札の合計は%dです%n", calcCardOfPlayer);
    }

    public void showCalcCardOfDealer() {
        System.out.printf("ディーラーの最終的な手札の合計は%dです%n", calcCardOfDealer);
    }

    public void judge() {
        if(getCalcCardOfPlayer() <= 21 && getCalcCardOfDealer() <= 21 && getCalcCardOfPlayer() == getCalcCardOfDealer()) {
            showCalcCardOfDealer();
            showCalcCardOfPlayer();
            System.out.println("引き分けです");
        } else if (getCalcCardOfDealer() > 21 && getCalcCardOfPlayer() > 21) {
            showCalcCardOfDealer();
            showCalcCardOfPlayer();
            System.out.println("両方負けです");
        } else if (getCalcCardOfDealer() <= 21 && getCalcCardOfPlayer() <= 21 && getCalcCardOfDealer() > getCalcCardOfPlayer() || getCalcCardOfDealer() <= 21 && getCalcCardOfPlayer() > 21) {
            showCalcCardOfDealer();
            showCalcCardOfPlayer();
            System.out.println("プレイヤーの負けです");
        } else if (getCalcCardOfDealer() <= 21 && getCalcCardOfPlayer() <= 21 && getCalcCardOfDealer() < getCalcCardOfPlayer() || getCalcCardOfDealer() > 21 && getCalcCardOfPlayer() <= 21) {
            showCalcCardOfDealer();
            showCalcCardOfPlayer();
            System.out.println("プレイヤーの勝ちです");
        }
    }

}
