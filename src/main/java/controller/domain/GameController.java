package controller.domain;

import domain.game.Benefit;
import domain.game.Score;
import domain.user.Dealer;
import domain.user.Players;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {

    List<Integer> scoreList = new ArrayList<>();
    List<Integer> benefitList;
    Benefit benefit = new Benefit();

    public boolean checkDealerBlackJack(Dealer dealer) {
        Score dealerScore = new Score(dealer);
        dealerScore.getScore();
        return dealerScore.isBlackJack();
    }

    public boolean checkPlayersBlackJack(Players players) {
        for (int i = 0; i < players.size(); i++) {
            Score playerScore = new Score(players.get(i));
            playerScore.getScore();
            if(playerScore.isBlackJack()){
                return true;
            }
        }
        return false;
    }

    public List<Integer> getScoreList(Dealer dealer, Players players) {
        scoreList.add(new Score(dealer).getScore());
        for (int i = 0; i < players.size(); i++) {
            scoreList.add(new Score(players.get(i)).getScore());
        }
        return scoreList;
    }

    public List<Integer> getBenefitList(Players players) {
        benefitList = benefit.calculateBenefit(players, scoreList);
        return benefitList;
    }

    public List<Integer> getBlackJackBenefitList(Players players) {
        benefitList = benefit.calculateBlackJack(players, scoreList);
        return benefitList;
    }
}
