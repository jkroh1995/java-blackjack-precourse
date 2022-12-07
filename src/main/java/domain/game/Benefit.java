package domain.game;

import domain.user.Dealer;
import domain.user.Players;
import java.util.ArrayList;
import java.util.List;

public class Benefit {

    int dealerBenefit = 0;
    List<Integer> benefitList = new ArrayList<>();


    public List<Integer> calculateBenefit(Players players, List<Integer> scoreList) {
        for (int playerNum = 1; playerNum < scoreList.size(); playerNum++) {
            calculate(players, scoreList, playerNum);
        }
        benefitList.add(0, dealerBenefit);
        return benefitList;
    }

    private void calculate(Players players, List<Integer> scoreList, int playerNum) {
        if (dealerWin(scoreList, playerNum)) {
            dealerGetBenefit(players, playerNum);
            return;
        }
        if (draw(scoreList, playerNum)) {
            noneGetBenefit();
            return;
        }
        if (playerWin(scoreList, playerNum)) {
            playerGetBenefit(players, playerNum);
        }
    }

    private void playerGetBenefit(Players players, int playerNum) {
        dealerBenefit -= players.get(playerNum - 1).getBettingMoney();
        benefitList.add((int) players.get(playerNum - 1).getBettingMoney());
    }

    private void noneGetBenefit() {
        benefitList.add(0);
    }

    private void dealerGetBenefit(Players players, int playerNum) {
        dealerBenefit += players.get(playerNum - 1).getBettingMoney();
        benefitList.add((int)players.get(playerNum - 1).getBettingMoney()*-1);
    }

    private boolean playerWin(List<Integer> scoreList, int playerNum) {
        return scoreList.get(0) > 21 || scoreList.get(0) < scoreList.get(playerNum) && scoreList.get(playerNum)<=21;
    }

    private boolean draw(List<Integer> scoreList, int playerNum) {
        return scoreList.get(0).equals(scoreList.get(playerNum));
    }

    private boolean dealerWin(List<Integer> scoreList, int playerNum) {
        return scoreList.get(playerNum) > 21 || scoreList.get(0) > scoreList.get(playerNum) && scoreList.get(0)<=21;
    }

    public List<Integer> calculateBlackJack(Players players, List<Integer> scoreList) {
        for (int playerNum = 1; playerNum < scoreList.size(); playerNum++) {
            calculateByBlackJack(players, scoreList, playerNum);
        }
        benefitList.add(0, dealerBenefit);
        return benefitList;
    }

    private void calculateByBlackJack(Players players, List<Integer> scoreList, int playerNum) {
        if (dealerWinByBlackJack(scoreList, playerNum)) {
            dealerGetBenefitByBlackJack(players, playerNum);
        }
        if(drawByBlackJack(scoreList, playerNum)){
            noneGetBenefit();
        }
        if(playerWinByBlackJack(scoreList, playerNum)){
            playerGetBenefitByBlackJack(players, playerNum);
        }
    }

    private void playerGetBenefitByBlackJack(Players players, int playerNum) {
        dealerBenefit -= players.get(playerNum -1).getBettingMoney()*150/100;
        benefitList.add((int)(players.get(playerNum -1).getBettingMoney()*150/100));
    }

    private void dealerGetBenefitByBlackJack(Players players, int playerNum) {
        dealerBenefit += players.get(playerNum -1).getBettingMoney()*150/100;
        benefitList.add((int)(players.get(playerNum -1).getBettingMoney()*150/100)*-1);
    }

    private boolean playerWinByBlackJack(List<Integer> scoreList, int playerNum) {
        return scoreList.get(playerNum)==21&& !scoreList.get(0).equals(scoreList.get(playerNum));
    }

    private boolean drawByBlackJack(List<Integer> scoreList, int playerNum) {
        return scoreList.get(playerNum)==21&& scoreList.get(0).equals(scoreList.get(playerNum));
    }

    private boolean dealerWinByBlackJack(List<Integer> scoreList, int playerNum) {
        return scoreList.get(0) == 21 && !scoreList.get(0).equals(scoreList.get(playerNum));
    }
}
