package controller.domain;

import domain.card.Card;
import domain.card.CardFactory;
import domain.game.Score;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;
import java.util.List;
import java.util.Random;
import util.InputHandler;
import view.OutputView;

public class CardController {

    private static final int isBlackJack = 21;
    private static final int STAY = 16;
    InputHandler inputHandler = new InputHandler();
    OutputView outputView = new OutputView();
    Random random = new Random();

    List<Card> cards = CardFactory.create();
    boolean isMoreCard = true;

    public void initializeUserCards(Dealer dealer, Players players) {
        initializeDealerCards(dealer, cards);
        for (int playerNum = 0; playerNum < players.size(); playerNum++) {
            initializePlayersCard(players.get(playerNum), cards);
        }
    }

    public void distributeMoreCardsToUser(Players players) {
        for (int playerNum = 0; playerNum < players.size(); playerNum++) {
            askEachPlayer(players.get(playerNum));
        }
    }

    public void distributeMoreCardsToDealer(Dealer dealer) {
        while (new Score(dealer).getScore()<= STAY) {
            outputView.printDealerGetCard();
            int index = random.nextInt(cards.size());
            dealer.addCard(cards.get(index));
            cards.remove(index);
        }
    }

    private void askEachPlayer(Player player) {
        isMoreCard = inputHandler.getMoreCardIndex(player.getName());
        int score = new Score(player).getScore();
        if (isMoreCard && score < isBlackJack) {
            int index = random.nextInt(cards.size());
            player.addCard(cards.get(index));
            cards.remove(index);
            outputView.printPlayerCards(player);
            askEachPlayer(player);
        }
    }

    private void initializeDealerCards(Dealer dealer, List<Card> cards) {
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(cards.size());
            dealer.addCard(cards.get(index));
            cards.remove(index);
        }
    }

    private void initializePlayersCard(Player player, List<Card> cards) {
        for (int j = 0; j < 2; j++) {
            int index = random.nextInt(cards.size());
            player.addCard(cards.get(index));
            cards.remove(index);
        }
    }
}
