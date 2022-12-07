package domain.game;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;

public class Score {

    private static final int BIG_ACE = 11;
    private static final int BLACKJACK = 21;
    private static final int SMALL_ACE = 1;

    int score=0;
    List<Card>cards;

    public Score(Dealer dealer){
        this.cards = dealer.getCardList();
    }

    public Score(Player player){
        this.cards = player.getCardList();
    }

    public int getScore(){
        for (Card card : cards) {
            score = addScore(score, card);
        }
        return score;
    }
    private int addScore(int score, Card card) {
        if(isAce(card)){
            score = addAceScore(score);
            return score;
        }
        score +=card.getScore();
        return score;
    }

    private boolean isAce(Card card) {
        return card.getSymbol().equals("A");
    }

    private int addAceScore(int score) {
        if(isBigAceBetter(score)){
            score +=11;
        }
        score +=1;
        return score;
    }

    private boolean isBigAceBetter(int score) {
        return score + BIG_ACE <= BLACKJACK
                &&Math.abs(BLACKJACK-(score +BIG_ACE))<Math.abs(BLACKJACK-(score + SMALL_ACE));
    }

    public boolean isBlackJack() {
        return score==BLACKJACK;
    }
}
