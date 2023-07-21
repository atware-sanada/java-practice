import java.util.ArrayList;
import java.util.List;
public class Player {
    private String name;
    /* 合計の計算結果 */
    private int calcCard = 0;
    /* 引いたカードのリスト */
    private List<Integer> cardList = new ArrayList<Integer>();
    /* ヒットしている状態 */
    private boolean isHit;
    public String getName() {
        return name;
    }

    public List<Integer> getCardList() {
        return cardList;
    }

    // ヒットするならH、ステイするならSを入力する
    public void hitOrStay() {
        Scanner scan = new Scanner(System.in);
        hand = scan.nextInt();
    }
    // 引いたカードのリストを全て合算する
    public void calcCardList() {
        for(int i = 0; i < cardList.size(); i++){
            calcCard += cardList.get(i);
            setCalcCard(calcCard);
        }
    }

    public int getCalcCard() {
        return calcCard;
    }

    public void setCalcCard(int calcCard) {
        this.calcCard = calcCard;
    }

}
