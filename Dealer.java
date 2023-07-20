import java.util.Scanner;

public class Dealer {

    private String name;

    private int[] handNum = {0};
    public void start() {
        greeting();
        nameEntry();
        Player player = new Player(name);
        distributeAnnounce(player);
        Hand hand = new Hand();
        hand.distributeHandToPlayer();
        hand.distributeHandToDealer();
        announceHandsum(hand);
        repeatDistributionAnnounce();
        while(hand.handEntry()){
            distributionAnnounce2();
            hand.distributeHandToPlayer();
            if (hand.sumHandPlayer() < 21) {
                announceHandsum(hand);
                repeatDistributionAnnounce();
            } else {
                announceHandsum(hand);
                System.out.println(player.getName() + "さんの手札の合計が21以上になったので自動的に結果発表に移ります");
                break;
            }
        }
        while (hand.sumHandDealer() < 18){
            hand.distributeHandToDealer();
        }
        resultAnnounce1(player,hand);
        resultAnnounce2(hand);
        checkResult(player,hand);
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

    // 名前を入力
    public void nameEntry() {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        this.name = name;
    }

    // 手札の配布アナウンス
    public void distributeAnnounce(Player player) {
        System.out.println(player.getName() + "さんですね。");
        System.out.println("これから１枚手札をお配りします");
    }

    public void announceHandsum(Hand hand) {
        System.out.printf("あなたの手札の現時点での合計は%d%n", hand.sumHandPlayer());
    }
    public void repeatDistributionAnnounce() {
        System.out.println("もう１枚手札を受け取りますか。（0：はい、1：いいえ）");
    }

    public void distributionAnnounce2() {
        System.out.println("もう１枚手札をお配りします");
    }

    public void resultAnnounce1(Player player, Hand hand) {
        System.out.printf("%sさんの手札の合計は%dです%n", player.getName(), hand.sumHandPlayer());
    }

    public void resultAnnounce2(Hand hand) {
        System.out.printf("私の手札の合計は%dです%n", hand.sumHandDealer());
    }

    public void checkResult(Player player, Hand hand) {
        if(hand.sumHandDealer() <= 21 && hand.sumHandPlayer() <= 21 && hand.sumHandDealer() == hand.sumHandPlayer()) {
            System.out.println("引き分けです");
        } else if (hand.sumHandDealer() > 21 && hand.sumHandPlayer() > 21) {
            System.out.println("両方とも負けです");
        } else if (hand.sumHandDealer() <= 21 && hand.sumHandPlayer() <= 21 && hand.sumHandDealer() > hand.sumHandPlayer() || hand.sumHandDealer() <= 21 && hand.sumHandPlayer() > 21) {
            System.out.println("私の勝利です");
        } else if (hand.sumHandDealer() <= 21 && hand.sumHandPlayer() <= 21 && hand.sumHandDealer() < hand.sumHandPlayer() || hand.sumHandDealer() > 21 && hand.sumHandPlayer() <= 21) {
            System.out.println(player.getName() + "さんの勝利です");
        }
    }
}
