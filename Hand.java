import java.util.Scanner;

public class Hand {
    private int[] handNumPlayer = {0};
    private int[] handNumDealer = {0};

    // ランダムな数字１〜１３
    public void distributeHandToPlayer() {
        int handNum = (int) (Math.random() * 13 + 1);
        setHandToPlayer(handNum);
    }

    public void distributeHandToDealer() {
        int handNum = (int) (Math.random() * 13 + 1);
        setHandToDealer(handNum);
    }

    public boolean handEntry() {
        Scanner scan = new Scanner(System.in);
        int hand = scan.nextInt();
        if(hand == 0) {
            return true;
        } else if (hand == 1) {
            return false;
        } throw new IllegalStateException("unexpected random value: " + hand);
    }

    public void makeArrayOfPlayer(int[] beforeArray) {
        int[] afterArray = new int[beforeArray.length + 1];
        for(int i = 0; i < beforeArray.length; i++){
            afterArray[i] = beforeArray[i];
        }
        this.handNumPlayer = afterArray;
    }

    public void makeArrayOfDealer(int[] beforeArray) {
        int[] afterArray = new int[beforeArray.length + 1];
        for(int i = 0; i < beforeArray.length; i++){
            afterArray[i] = beforeArray[i];
        }
        this.handNumDealer = afterArray;
    }

    public int sumHandPlayer() {
        int handSum = 0;
        for(int i = 0; i < this.handNumPlayer.length; i++){
            handSum += this.handNumPlayer[i];
        }
        return handSum;
    }

    public int sumHandDealer() {
        int handSum = 0;
        for(int i = 0; i < this.handNumDealer.length; i++){
            handSum += this.handNumDealer[i];
        }
        return handSum;
    }

    public void setHandToPlayer(int handNum) {
        int i = this.handNumPlayer.length - 1;
        this.handNumPlayer[i] = handNum;
        makeArrayOfPlayer(this.handNumPlayer);
    }

    public void setHandToDealer(int handNum) {
        int i = this.handNumDealer.length - 1;
        this.handNumDealer[i] = handNum;
        makeArrayOfDealer(this.handNumDealer);
    }
}
