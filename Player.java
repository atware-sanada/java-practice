import java.util.Scanner;
public class Player {
    private String name;
    private int[] handNum = {0};
    private int hand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHandNum(int handNum) {
            int i = this.handNum.length - 1;
            this.handNum[i] = handNum;
            makeArray(this.handNum);
    }

    // 1つ要素の大きい配列を新たに作成、元々あった値を代入
    public void makeArray(int[] beforeArray) {
        int[] afterArray = new int[beforeArray.length + 1];
        for(int i = 0; i < beforeArray.length; i++){
            afterArray[i] = beforeArray[i];
        }
        this.handNum = afterArray;
    }

    // 名前を入力
    public void nameEntry() {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        setName(name);
    }

    // もう一度手札を受け取るか選択（0:はい、1:いいえ）
    public boolean handEntry() {
        Scanner scan = new Scanner(System.in);
        hand = scan.nextInt();
        if(hand == 0) {
            return true;
        } else if (hand == 1) {
            return false;
        }
        return false;
    }

    // 元々持っていた手札の数とDealerから受け取った手札の数を加算する
    public int handSum() {
        int handSum = 0;
        for(int i = 0; i < this.handNum.length; i++){
            handSum += this.handNum[i];
        }
        return handSum;
    }

}
