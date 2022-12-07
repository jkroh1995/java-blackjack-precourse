package controller;

import controller.domain.CardController;
import controller.domain.GameController;
import controller.domain.UserController;
import domain.user.Dealer;
import domain.user.Players;
import view.OutputView;

public class BlackjackController {

    CardController cardController = new CardController();
    OutputView outputView  = new OutputView();
    GameController gameController = new GameController();
    Dealer dealer = new Dealer();

    public void run(){
        Players players = new UserController().getPlayers();
        startGame(players);
        if (isBlackJackStart(players)) {
            return;
        }
        distributeCards(players);
        endGame(players);
    }

    private void endGame(Players players) {
        outputView.printFinalCardsAndScore(dealer, players, gameController.getScoreList(dealer, players));
        outputView.printBenefit(players, gameController.getBenefitList(players));
    }

    private void distributeCards(Players players) {
        cardController.distributeMoreCardsToUser(players);
        cardController.distributeMoreCardsToDealer(dealer);
    }

    private void startGame(Players players) {
        outputView.printStartingCondition(players);
        cardController.initializeUserCards(dealer, players);
        printStartingCards(players);
    }

    private boolean isBlackJackStart(Players players) {
        boolean isPlayerBlackJack = gameController.checkPlayersBlackJack(players);
        boolean isDealerBlackJack = gameController.checkDealerBlackJack(dealer);
        if(isBlackJack(isPlayerBlackJack, isDealerBlackJack)){
            endGameByBlackJack(players);
            return true;
        }
        return false;
    }

    private void endGameByBlackJack(Players players) {
        outputView.printFinalCardsAndScore(dealer, players, gameController.getScoreList(dealer, players));
        outputView.printBenefit(players, gameController.getBlackJackBenefitList(players));
    }

    private boolean isBlackJack(boolean isPlayerBlackJack, boolean isDealerBlackJack) {
        return isPlayerBlackJack || isDealerBlackJack;
    }

    private void printStartingCards(Players players) {
        outputView.printDealerStartingCard(dealer.getCardList());
        outputView.printPlayersCards(players);
    }
}
