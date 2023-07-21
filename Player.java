import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    /* 合計の計算結果 */
    private int calcCard = 0;
    /* 引いたカードのリスト */
    private List<Integer> cardList = new ArrayList<Integer>();
    /* ヒットしている状態 */
    private boolean isHit = false;
    /* ステイしている状態 */
    private boolean isStay = false;

    public String getName() {
        return name;
    }

    public List<Integer> getCardList() {
        return cardList;
    }

    // ヒットするならH、ステイするならSを入力する
    public void hitOrStay() {
        Scanner scan = new Scanner(System.in);
        String selection = scan.next();
        if(selection.equals("H") || selection.equals("h")) {
            this.isHit = true;
        } else if (selection.equals("S") || selection.equals("s")) {
            this.isStay = true;
        }
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
