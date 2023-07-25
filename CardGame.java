public class CardGame {

        public static void main(String[] args){
            Player player = new Player();
            // ゲーム（プレイヤーから）開始
            player.startGame();
            // 1枚目の数を見てヒットするかステイするか
            while (player.getCalcCardOfPlayer() < 21){
                if(player.getHit()) {
                    player.hitOrStay();
                } else {
                    break;
                }
            }
            // ディーラーはカードの合計が18未満になるまでカードを引き続ける
            while(player.getCalcCardOfDealer() < 18) {
                player.distributeToDealer();
            }
            // 勝敗判定
            player.judge();
        }

}