package controller.domain;

import domain.user.Player;
import domain.user.Players;
import java.util.ArrayList;
import java.util.List;
import util.InputHandler;

public class UserController {

    InputHandler inputHandler = new InputHandler();

    public Players getPlayers(){
        List<Player> players = new ArrayList<>();
        List<String> playersName = inputHandler.getPlayersName();
        List<Integer> playersBet = new ArrayList<>();
        makePlayersBet(playersName, playersBet);
        makePlayers(players, playersName, playersBet);
        return new Players(players);
    }

    private void makePlayersBet(List<String> playersName, List<Integer> playersBet) {
        for (String name : playersName) {
            playersBet.add(inputHandler.getPlayersBet(name));
        }
    }

    private void makePlayers(List<Player> players, List<String> playersName, List<Integer> playersBet) {
        for(int i = 0; i< playersName.size(); i++){
            players.add(new Player(playersName.get(i), playersBet.get(i)));
        }
    }
}
