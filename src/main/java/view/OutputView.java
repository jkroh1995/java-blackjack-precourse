package view;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;
import java.util.List;

public class OutputView {

    private static final String PRINT_PLAYER_CARDS = "%s카드: %s";
    private static final String PRINT_DEALER_CARDS = "딜러 카드: %s";
    private static final String PRINT_INITIATE_CONDITION = "딜러와 %s에게 2장을 나누었습니다.\n";
    private static final String DEALER_GET_MORE_CARD = "딜러는 16이하라 한 장의 카드를 더 받았습니다.";
    private static final String SCORE = " - 결과 %d";

    public void printError(String message) {
        System.out.println((message));
    }

    public void printStartingCondition(Players players) {
        printBlankLine();
        List<String> nameList = players.getNames();
        String names = String.join(", ", nameList);
        System.out.printf(PRINT_INITIATE_CONDITION, names);
    }

    public void printDealerStartingCard(List<Card> cardList) {
        System.out.printf(PRINT_DEALER_CARDS, cardList.get(0).toString());
        printBlankLine();
    }

    public void printPlayersCards(Players players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.printf(PRINT_PLAYER_CARDS, players.get(i).getName(), players.get(i).getCards());
            printBlankLine();
        }
    }

    public void printPlayerCards(Player player) {
        System.out.printf(PRINT_PLAYER_CARDS, player.getName(), player.getCards());
        printBlankLine();
    }

    public void printDealerGetCard() {
        printBlankLine();
        System.out.println(DEALER_GET_MORE_CARD);
    }

    public void printBenefit(Players players, List<Integer> benefitList){
        System.out.println("## 최종 수익");
        System.out.printf("딜러: %d\n", benefitList.get(0));
        for(int i=0;i< players.size();i++){
            System.out.printf("%s: %d\n", players.get(i).getName(), benefitList.get(i+1));
        }
    }

    public void printFinalCardsAndScore(Dealer dealer, Players players, List<Integer>scoreList) {
        printBlankLine();
        printDealerFinal(dealer, scoreList.get(0));
        for (int i = 0; i < players.size(); i++) {
            printPlayerFinal(players.get(i), scoreList.get(i+1));
        }
    }

    private void printPlayerFinal(Player player, int playerScore) {
        System.out.printf(PRINT_PLAYER_CARDS + SCORE, player.getName(), player.getCards(), playerScore);
        printBlankLine();
    }

    private void printDealerFinal(Dealer dealer, int dealerScore) {
        System.out.printf(PRINT_DEALER_CARDS + SCORE, dealer.getCards(), dealerScore);
        printBlankLine();
    }



    public void printBlankLine() {
        System.out.println();
    }
}
