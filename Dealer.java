public class Dealer {

    private int[] handNum = {0};
    public void start() {
        Player player = new Player();
        greeting();
        player.nameEntry();
        distributionAnnounce(player);
        handNumDistributionToPlayer(player);
        handNumDistributionToDealer();
        handSumAnnounce(player);
        repeatDistributionAnnounce();
        while(player.handEntry()){
            distributionAnnounce2();
            handNumDistributionToPlayer(player);
            if (player.handSum() < 21) {
                handSumAnnounce(player);
                repeatDistributionAnnounce();
            } else {
                handSumAnnounce(player);
                System.out.println(player.getName() + "さんの手札の合計が21以上になったので自動的に結果発表に移ります");
                break;
            }
        }
        while (handSum() < 18){
            handNumDistributionToDealer();
        }
        resultAnnounce1(player);
        resultAnnounce2();
        checkResult(player);
    }

    public void greeting() {
        System.out.println("カードゲームへようこそ！");
        System.out.println("簡単なルールを説明します");
        System.out.println("今から１〜１３の手札を配ります。配られる手札の合計をできる限り２１に近づけて下さい");
        System.out.println("手札の合計が２１を超えない限り何度も手札を受け取ることは可能です");
        System.out.println("ただし、手札の合計が２１よりも大きくなってしまったら、その時点で負け確定です");
        System.out.println("対戦相手は私です");
        System.out.println("まずはじめにお名前を入力して下さい");
    }

    public void distributionAnnounce(Player player) {
        System.out.println(player.getName() + "さんですね。");
        System.out.println("これから１枚手札をお配りします");
    }

    // DealerがPlayerに１〜１３のランダムな数字を渡す
    public void handNumDistributionToPlayer(Player player) {
       int handNum = (int)(Math.random() * 13 + 1);
       player.setHandNum(handNum);
    }

    public void handNumDistributionToDealer() {
        int handNum = (int)(Math.random() * 13 + 1);
        setHandNum(handNum);
    }

    public void setHandNum(int handNum) {
        int i = this.handNum.length - 1;
        this.handNum[i] = handNum;
        makeArray(this.handNum);
    }

    public void makeArray(int[] beforeArray) {
        int[] afterArray = new int[beforeArray.length + 1];
        for(int i = 0; i < beforeArray.length; i++){
            afterArray[i] = beforeArray[i];
        }
        this.handNum = afterArray;
    }

    public int handSum() {
        int handSum = 0;
        for(int i = 0; i < this.handNum.length; i++){
            handSum += this.handNum[i];
        }
        return handSum;
    }

    public void handSumAnnounce(Player player) {
        System.out.println("あなたの手札の現時点での合計は" + player.handSum());
    }
    public void repeatDistributionAnnounce() {
        System.out.println("もう１枚手札を受け取りますか。（0：はい、1：いいえ）");
    }

    public void distributionAnnounce2() {
        System.out.println("もう１枚手札をお配りします");
    }

    public void resultAnnounce1(Player player) {
        System.out.println(player.getName() + "さんの手札の合計は" + player.handSum() + "です");
    }

    public void resultAnnounce2() {
        System.out.println("私の手札の合計は" + handSum() + "です");
    }

    public void checkResult(Player player) {
        if(handSum() <= 21 && player.handSum() <= 21 && handSum() == player.handSum()) {
            System.out.println("引き分けです");
        } else if (handSum() > 21 && player.handSum() > 21) {
            System.out.println("両方とも負けです");
        } else if (handSum() <= 21 && player.handSum() <= 21 && handSum() > player.handSum() || handSum() <= 21 && player.handSum() > 21) {
            System.out.println("私の勝利です");
        } else if (handSum() <= 21 && player.handSum() <= 21 && handSum() < player.handSum() || handSum() > 21 && player.handSum() <= 21) {
            System.out.println(player.getName() + "さんの勝利です");
        }
    }
}
